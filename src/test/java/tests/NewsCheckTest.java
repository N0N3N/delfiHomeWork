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


/*    @Test
    public void printBusinessNews(){
        businessDesktop.openWebPage();
        List<String> desktopNews = businessDesktop.getNewsList();
        businessMobile.openWebPage();
        List<String> mobileNews = businessMobile.getNewsList();
        helper.checkNews(desktopNews, mobileNews);
    }

    @Test
    public void printReporterNews(){
        reporterDesktop.openWebPage();
        List<String> desktopNews = reporterDesktop.getNewsList();
        reporterMobile.openWebPage();
        List<String> mobileNews = reporterMobile.getNewsList();
        helper.checkNews(desktopNews, mobileNews);
    }*/

    @Test
    public void compareBusinessNewsNames(){
        businessDesktop.openWebPage();
        List<String> desktopNewsNames = businessDesktop.getNewsNames();
        businessMobile.openWebPage();
        List<String> mobileNewsNames = businessMobile.getNewsNames();
        helper.compareNewsNames(desktopNewsNames, mobileNewsNames);
    }

    @Test
    public void compareBusinessNewsCommentCount(){
        businessDesktop.openWebPage();
        List<String> desktopNewsComments = businessDesktop.getNewsCommentCount();
        businessMobile.openWebPage();
        List<String> mobileNewsComments = businessMobile.getNewsCommentCount();
        helper.compareNewsCommnetCount(desktopNewsComments, mobileNewsComments);
    }

    @Test
    public void compareReporterNewsNames(){
        reporterDesktop.openWebPage();
        List<String> desktopNewsNames = reporterDesktop.getNewsNames();
        reporterMobile.openWebPage();
        List<String> mobileNewsNames = reporterMobile.getNewsNames();
        helper.compareNewsNames(desktopNewsNames, mobileNewsNames);
    }

    @Test
    public void compareReporterNewsCommentCount(){
        reporterDesktop.openWebPage();
        List<String> desktopNewsComments = reporterDesktop.getNewsCommentCount();
        reporterMobile.openWebPage();
        List<String> mobileNewsComments = reporterMobile.getNewsCommentCount();
        helper.compareNewsCommnetCount(desktopNewsComments, mobileNewsComments);
    }


    @After
    public void closePage(){
        core.closeDriver();
    }
}
