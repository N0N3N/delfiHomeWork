package attributeHelper;

import coreFunctions.CoreFunctions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

public class AttributeHelper {
    private CoreFunctions core;
    public AttributeHelper(CoreFunctions cf){
        this.core = cf;
    }
    private static final Logger LOGGER = LogManager.getLogger(AttributeHelper.class);

    public void checkNews(List<String> desktopData, List<String> mobileData) {
        LOGGER.info("Checking news from Desktop and Mobile versions");
        System.out.println();

        boolean state = true;
        for (int i = 0; i < 3; i++) {
            LOGGER.info("Nr." + (i+1) + "  " + desktopData.get(i*2) + " " + desktopData.get(i*2+1) + " VS " + mobileData.get(i*2) + " " + mobileData.get(i*2+1));
            if (desktopData.get(i*2).contains(mobileData.get(i*2))) {
                LOGGER.info("Same Name      ");
            } else {
                LOGGER.info("Different Name     ");
                state = false;
            }

            if (desktopData.get(i*2+1).contains(mobileData.get(i*2+1))) {
                LOGGER.info("Same Comment count");
                System.out.println();
            } else {
                LOGGER.info("Different Comment count");
                System.out.println();
                state = false;
            }
        }
        Assert.assertTrue("News are different", state);
    }

    public List<String> getNewsAttributes(By news, By a1, By a2) {
        int limit = 3;
        List<String> data = new ArrayList<String>();
        LOGGER.info("Getting list of news");
        for (int i = 0; i < limit; i++) {
            Assert.assertTrue("No News found", !core.getNewsElements(news).get(i).findElements(a1).isEmpty());
            data.add(i*2, core.getNewsElements(news).get(i).findElement(a1).getText());

            if (core.getNewsElements(news).get(i).findElements(a2).isEmpty()) {
                data.add(i*2+1, "0");
            } else
                data.add(i*2+1, core.getNewsElements(news).get(i).findElement(a2).getText());
        }

        return data;
    }
}
