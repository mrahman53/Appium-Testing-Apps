package iPad.welcomePage;

import baseAPI.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mrahman on 5/5/15.
 */
public class HomePage extends Base {

    @Test
    public void home()throws InterruptedException{
        List<WebElement> list = new ArrayList<WebElement>();
        sleep(1);
        list = driver.findElements(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell"));
        sleep(1);
        for(int i=1; i<list.size(); i++) {
            clickByXpathWebElement(list.get(i));
            //"//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]"
            sleep(2);
            clickByXpath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[1]");
            sleep(2);
        }
    }
}
