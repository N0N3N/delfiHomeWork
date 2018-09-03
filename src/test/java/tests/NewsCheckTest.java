package tests;

import coreFunctions.CoreFunctions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import pageObjects.desktop.BusinessDesktopPage;
import pageObjects.desktop.ReporterDesktopPage;
import pageObjects.mobile.BusinessMobilePage;
import pageObjects.mobile.ReporterMobilePage;

import java.util.ArrayList;
import java.util.List;

public class NewsCheckTest {
    private CoreFunctions core = new CoreFunctions();
    private BusinessDesktopPage businessDesktop = new BusinessDesktopPage(core);
    private ReporterDesktopPage reporterDesktop = new ReporterDesktopPage(core);
    private BusinessMobilePage businessMobile = new BusinessMobilePage(core);
    private ReporterMobilePage reporterMobile = new ReporterMobilePage(core);
    private static final Logger LOGGER = LogManager.getLogger(NewsCheckTest.class);

    public void checkNews(List<String> desktopData, List<String> mobileData) {
        LOGGER.info("Checking news from Desktop and Mobile versions");
        System.out.println();

        boolean state = true;
        for (int i = 0; i < 3; i++) {
            LOGGER.info("Nr." + i + 1 + "  " + desktopData.get(i*2) + " " + desktopData.get(i*2+1) + " VS " + mobileData.get(i*2) + " " + mobileData.get(i*2+1));
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

    @Test
    public void printFirstThreeBusinessNews(){
        businessDesktop.openWebPage();
        List<String> desktopNews = businessDesktop.getNewsList();
        businessMobile.openWebPage();
        List<String> mobileNews = businessMobile.getNewsList();
        checkNews(desktopNews, mobileNews);
    }

    @Test
    public void printFirstThreeReporterNews(){
        reporterDesktop.openWebPage();
        List<String> desktopNews = reporterDesktop.getNewsList();
        reporterMobile.openWebPage();
        List<String> mobileNews = reporterMobile.getNewsList();
        checkNews(desktopNews, mobileNews);
    }

    @After
    public void closePage(){
        core.closeDriver();
    }
}
