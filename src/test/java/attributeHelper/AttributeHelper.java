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
    private static final int limit = 3;

    private boolean statusComparisonForName(int i,List<String> desktopData, List<String> mobileData){
        boolean state = true;
        if (desktopData.get(i).contains(mobileData.get(i))) {
            LOGGER.info("Same Name      ");
        } else {
            LOGGER.info("Different Name     ");
            state = false;
        }
        return state;
    }

    private boolean statusComparisonForCommentCount(int i,List<String> desktopData, List<String> mobileData){
        boolean state = true;
        if (desktopData.get(i).contains(mobileData.get(i))) {
            LOGGER.info("Same Comment count      ");
        } else {
            LOGGER.info("Different Comment count     ");
            state = false;
        }
        return state;
    }

    public void compareNewsNames(List<String> desktopName, List<String> mobileName) {
        LOGGER.info("Checking news from Desktop and Mobile versions");
        System.out.println();
        boolean stateNames = true;
        for (int i = 0; i < limit; i++) {
            LOGGER.info("Nr." + (i+1) + "  " + desktopName.get(i) + " VS " + mobileName.get(i));
            if (!statusComparisonForName(i, desktopName, mobileName)){
                stateNames = false;
            }
        }
        Assert.assertTrue("News Names are different", stateNames);
    }

    public void compareNewsCommnetCount(List<String> desktopCommentCount, List<String> mobileCommentCount) {
        LOGGER.info("Checking news from Desktop and Mobile versions");
        System.out.println();
        boolean stateComments = true;
        for (int i = 0; i < limit; i++) {
            LOGGER.info("Nr." + (i+1) + "  " + desktopCommentCount.get(i) + " VS " + mobileCommentCount.get(i));
            if (!statusComparisonForCommentCount(i, desktopCommentCount, mobileCommentCount)){
                stateComments = false;
            }
        }
        Assert.assertTrue("News Comment Count are different", stateComments);
    }

    public List<String> getNewsNames(By news, By a1) {
        List<String> list = new ArrayList<String>();
        LOGGER.info("Getting list of news");
        for (int i = 0; i < limit; i++) {
            Assert.assertTrue("No News found", !core.getNewsElements(news).get(i).findElements(a1).isEmpty());
            list.add(i, core.getNewsElements(news).get(i).findElement(a1).getText());
        }
        return list;
    }

    public List<String> getNewsCommentCount(By news, By a2) {
        List<String> data = new ArrayList<String>();
        LOGGER.info("Getting list of news");
        for (int i = 0; i < limit; i++) {
            if (core.getNewsElements(news).get(i).findElements(a2).isEmpty()) {
                data.add(i, "0");
            } else
                data.add(i, core.getNewsElements(news).get(i).findElement(a2).getText());
        }
        return data;
    }
}
