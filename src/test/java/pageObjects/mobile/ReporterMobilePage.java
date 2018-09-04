package pageObjects.mobile;

import attributeHelper.AttributeHelper;
import coreFunctions.CoreFunctions;
import org.openqa.selenium.By;
import java.util.List;

public class ReporterMobilePage {
    private CoreFunctions core;
    private AttributeHelper helper;

    private static final By NEWS = By.xpath("//div[@class = 'md-mosaic']/div/div");
    private static final By A1 = By.xpath("./a[1]");
    private static final By A2 = By.xpath("./a[2]");
    private static final String PAGE = "http://m.rus.delfi.lv/reporter/";

    public ReporterMobilePage(CoreFunctions cf, AttributeHelper ah) {
        this.core = cf;
        this.helper = ah;
    }

    public void openWebPage() {
        core.openWebPage(PAGE);
    }

    public List<String> getNewsNames(){
        return helper.getNewsNames(NEWS, A1);
    }

    public List<String> getNewsCommentCount(){
        return helper.getNewsCommentCount(NEWS, A2);
    }
}
