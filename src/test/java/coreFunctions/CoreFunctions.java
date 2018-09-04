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
    private static final String CHROME_DRIVER_LOCATION = "C:/driver/chromedriver.exe";
    private static final Logger LOGGER = LogManager.getLogger(CoreFunctions.class);

    public CoreFunctions() {
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_LOCATION);
        this.driver = new ChromeDriver();
        driver.manage().window().maximize();
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

    public List<WebElement> getNewsElements(By path) {
        Assert.assertTrue("No elements found", !driver.findElements(path).isEmpty());
        return driver.findElements(path);
    }
}
