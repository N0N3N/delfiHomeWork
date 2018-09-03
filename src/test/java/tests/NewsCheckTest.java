package tests;

import attributeHelper.AttributeHelper;
import coreFunctions.CoreFunctions;
import org.junit.After;
import org.junit.Test;
import pageObjects.desktop.BusinessDesktopPage;
import pageObjects.desktop.ReporterDesktopPage;
import pageObjects.mobile.BusinessMobilePage;
import pageObjects.mobile.ReporterMobilePage;
import java.util.List;

public class NewsCheckTest {
    private CoreFunctions core = new CoreFunctions();
    private AttributeHelper helper = new AttributeHelper(core);
    private BusinessDesktopPage businessDesktop = new BusinessDesktopPage(core, helper);
    private ReporterDesktopPage reporterDesktop = new ReporterDesktopPage(core, helper);
    private BusinessMobilePage businessMobile = new BusinessMobilePage(core, helper);
    private ReporterMobilePage reporterMobile = new ReporterMobilePage(core, helper);


    @Test
    public void printFirstThreeBusinessNews(){
        businessDesktop.openWebPage();
        List<String> desktopNews = businessDesktop.getNewsList();
        businessMobile.openWebPage();
        List<String> mobileNews = businessMobile.getNewsList();
        helper.checkNews(desktopNews, mobileNews);
    }

    @Test
    public void printFirstThreeReporterNews(){
        reporterDesktop.openWebPage();
        List<String> desktopNews = reporterDesktop.getNewsList();
        reporterMobile.openWebPage();
        List<String> mobileNews = reporterMobile.getNewsList();
        helper.checkNews(desktopNews, mobileNews);
    }

    @After
    public void closePage(){
        core.closeDriver();
    }
}
