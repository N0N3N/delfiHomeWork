package coreFunctions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;



public class CoreFunctions {
    private WebDriver driver;
    private static final String CHROME_DRIVER_LOCATION = "C://driver/chromedriver.exe";
    private static final Logger LOGGER = LogManager.getLogger(CoreFunctions.class);
    private boolean state = true;

    public CoreFunctions() {
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_LOCATION);
        this.driver = new ChromeDriver();
    }

    public void openWebPage(String url) {
        if (!url.contains("http://") && !url.contains("https://")) {
            url = "http://" + url;
        }
        LOGGER.info("Opening web page: " + url);
        driver.get(url);
    }

    public void closeDriver() {
        driver.close();
    }


    public void checkNews(String[][] deskSum, String[][] mobSum) {
        LOGGER.info("Checking news from Mob. and Desk. versions");
        System.out.println(" ");
        for (int i = 0; i < 3; i++) {
            System.out.println("Nr." + i + "  " + deskSum[0][i] + " " + deskSum[1][i] + " VS " + mobSum[0][i] + " " + mobSum[1][i]);
            if (deskSum[0][i].contains(mobSum[0][i])) {
                System.out.print("Same Name      ");
            } else{
                System.out.print("Different Name     ");
                state = false;
            }

            if (deskSum[1][i].contains(mobSum[1][i])) {
                System.out.println("Same Comment count");
            } else {
                System.out.println("Different Comment count");
                state = false;
                System.out.println(" ");
            }
        }
        if (!state){
            Assert.assertTrue("News are different", state=true);
        }
    }


    public List<WebElement> getNewsElements(By NEWS) {
        List<WebElement> newsElements = driver.findElements(NEWS);
        return newsElements;
    }


    public String[][] getNewsAttributes(By NEWS, By a1, By a2) {
        String[][] sum = {{"", "", ""}, {"", "", ""}};
        LOGGER.info("Getting list of news:");
        for (int i = 0; i < 3; i++) {
            Assert.assertTrue("No News found", !getNewsElements(NEWS).get(i).findElements(a1).isEmpty());
            sum[0][i] = getNewsElements(NEWS).get(i).findElement(a1).getText();
            System.out.print(i + " " + sum[0][i]);

            if (getNewsElements(NEWS).get(i).findElements(a2).isEmpty()) {
                sum[1][i] = "0";
            } else
                sum[1][i] = getNewsElements(NEWS).get(i).findElement(a2).getText();
            System.out.println(" " + sum[1][i]);
        }

        return sum;

    }

}
