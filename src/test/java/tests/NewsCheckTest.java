package tests;

import coreFunctions.CoreFunctions;
import org.junit.After;
import org.junit.Test;
import pageObjects.desktop.BusinessDesktopPage;
import pageObjects.desktop.ReporterDesktopPage;
import pageObjects.mobile.BusinessMobilePage;
import pageObjects.mobile.ReporterMobilePage;

public class NewsCheckTest {
    private CoreFunctions core = new CoreFunctions();
    private BusinessDesktopPage businessDesktop = new BusinessDesktopPage(core);
    private ReporterDesktopPage reporterDesktop = new ReporterDesktopPage(core);
    private BusinessMobilePage businessMobile = new BusinessMobilePage(core);
    private ReporterMobilePage reporterMobile = new ReporterMobilePage(core);

    @Test
    public void printFirstThreeBusinessNewsDesk(){
        core.checkNews(businessDesktop.getNewsList(), businessMobile.getNewsList());
        core.checkNews(reporterDesktop.getNewsList(), reporterMobile.getNewsList());
    }

    @After
    public void closePage(){
        core.closeDriver();
    }
}
