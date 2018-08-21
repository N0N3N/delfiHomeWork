package pageObjects.desktop;

import coreFunctions.CoreFunctions;
import org.openqa.selenium.By;
import java.util.List;

public class BusinessDesktopPage {
    private CoreFunctions core;

    private static final String PAGE = "http://www.delfi.lv/biznes/";
    private static final By NEWS = By.xpath("//h3[@class = 'top2012-title']");
    private static final By A1 = By.xpath("./a[1]");
    private static final By A2 = By.xpath("./a[2]");

    public BusinessDesktopPage(CoreFunctions cf){
        this.core = cf;
    }

    public List<String> getNewsList(){
        core.openWebPage(PAGE);
        return core.getNewsAttributes(NEWS, A1, A2);
    }
}
