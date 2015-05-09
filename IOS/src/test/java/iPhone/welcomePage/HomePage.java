package iPhone.welcomePage;


import baseAPI.Base;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

/**
 * Created by mrahman on 5/4/15.
 */
public class HomePage extends Base{


    @Test
    public void home()throws InterruptedException{
        System.out.println("App launched");
        for(int i=1; i<=12; i++) {
            sleep(1);
            clickByXpath("//UIAApplication[1]/UIAWindow[2]/UIATableView[1]/UIATableCell["+i+"]");
            sleep(2);
            clickByXpath("//UIAApplication[1]/UIAWindow[2]/UIANavigationBar[1]/UIAButton[1]");
            //UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[1]
            sleep(2);
        }
    }



}
