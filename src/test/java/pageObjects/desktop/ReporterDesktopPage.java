package pageObjects.desktop;

import attributeHelper.AttributeHelper;
import coreFunctions.CoreFunctions;
import org.openqa.selenium.By;
import tests.NewsCheckTest;

import java.util.List;

public class ReporterDesktopPage {
    private CoreFunctions core;
    private AttributeHelper helper;

    private static final String PAGE = "http://www.delfi.lv/reporter/";
    private static final By NEWS = By.xpath("//h3[@class = 'top2012-title']");
    private static final By A1 = By.xpath("./a[1]");
    private static final By A2 = By.xpath("./a[2]");

    public ReporterDesktopPage(CoreFunctions cf, AttributeHelper ah) {
        this.core = cf;
        this.helper = ah;
    }

    public void openWebPage() {
        core.openWebPage(PAGE);
    }
/*    public List<String> getNewsList(){
        return helper.getNewsAttributes(NEWS, A1, A2);
    }*/

    public List<String> getNewsNames(){
        return helper.getNewsNames(NEWS, A1);
    }

    public List<String> getNewsCommentCount(){
        return helper.getNewsCommentCount(NEWS, A2);
    }
}
