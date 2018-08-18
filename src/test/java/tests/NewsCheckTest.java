package tests;

import coreFunctions.CoreFunctions;
import org.junit.Test;
import pageObjects.desktop.TabBusinessDesktop;
import pageObjects.desktop.TabReporterDesktop;
import pageObjects.mobile.TabBusinessMobile;
import pageObjects.mobile.TabReporterMobile;


public class NewsCheckTest {
    private CoreFunctions core = new CoreFunctions();

    private TabBusinessDesktop businessDesktop = new TabBusinessDesktop(core);
    private TabReporterDesktop reporterDesktop = new TabReporterDesktop(core);

    private TabBusinessMobile businessMobile = new TabBusinessMobile(core);
    private TabReporterMobile reporterMobile = new TabReporterMobile(core);

    @Test
    public void print3BusinessNewsDesk(){
        core.checkNews(businessDesktop.getNewsList(), businessMobile.getNewsList());
        core.checkNews(reporterDesktop.getNewsList(), reporterMobile.getNewsList());
        core.closeDriver();
    }

}
