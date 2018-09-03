package pageObjects.mobile;

import coreFunctions.CoreFunctions;
import org.openqa.selenium.By;
import java.util.List;

public class ReporterMobilePage {
    private CoreFunctions core;
    private static final By NEWS = By.xpath("//div[@class = 'md-mosaic']/div/div");
    private static final By A1 = By.xpath("./a[1]");
    private static final By A2 = By.xpath("./a[2]");
    private static final String PAGE = "http://m.rus.delfi.lv/reporter/";

    public ReporterMobilePage(CoreFunctions cf){
        this.core = cf;
    }

    public void openWebPage() {
        core.openWebPage(PAGE);
    }
    public List<String> getNewsList(){
        return core.getNewsAttributes(NEWS, A1, A2);
    }
}
