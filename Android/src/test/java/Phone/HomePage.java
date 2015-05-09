package Phone;

import baseAPI.Base;
import constant.UserInfo;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

/**
 * Created by mrahman on 5/5/15.
 */
public class HomePage extends Base {

    UserInfo ui = new UserInfo();

    @Test
    public void home()throws InterruptedException{
        System.out.println("App is launched");
        clickByXpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.ScrollView[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.Button[1]");
        typeByXpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.RelativeLayout[1]/android.widget.EditText[1]", ui.userName, Keys.TAB);
        typeByXpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.RelativeLayout[1]/android.widget.EditText[2]", ui.password, Keys.ENTER);
        sleep(3);
    }
}
