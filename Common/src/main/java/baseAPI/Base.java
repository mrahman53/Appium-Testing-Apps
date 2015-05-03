package baseAPI;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by mrahman on 5/3/15.
 */
public class Base {


    public static AppiumDriver driver = null;
    public String app = null;
    public String OS = null;
    public String deviceType = null;
    public String appType = null;
    public String version = null;

    public File file = null;
    public File findApp = null;
    public DesiredCapabilities cap = null;

    @Parameters
    @BeforeMethod
    public void setUp(String app, String device, String deviceType, String version)throws IOException{

        if(app.contains("ios")){
            //TODO IOS
            if(OS.contains("iPhone")){

                if(deviceType.contains("RealDevice")){
                    //TODO Real Device Phone
                    cap = new DesiredCapabilities();
                    cap.setCapability(MobileCapabilityType.DEVICE_NAME, deviceType);
                    cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.IOS);
                    cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, version);
                    cap.setCapability(MobileCapabilityType.APP, findApp.getAbsolutePath());
                    driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
                    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

                }else if (deviceType.contains("iPhone Simulator")){
                    //TODO Real Device iPhone Simulator
                    cap = new DesiredCapabilities();
                    cap.setCapability(MobileCapabilityType.DEVICE_NAME,"iPhone Simulator");
                    cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.IOS);
                    cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, version);
                    cap.setCapability(MobileCapabilityType.APP, findApp.getAbsolutePath());
                    driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
                    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                }


            }else if(device.contains("iPad")){
                if(deviceType.contains("RealDevice")){
                    cap = new DesiredCapabilities();
                    cap.setCapability(MobileCapabilityType.DEVICE_NAME,"iPad");
                    cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.IOS);
                    cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, version);
                    cap.setCapability(MobileCapabilityType.APP, findApp.getAbsolutePath());
                    driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
                    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

                }else if (deviceType.contains("iPad Simulator")){
                    cap = new DesiredCapabilities();
                    cap.setCapability(MobileCapabilityType.DEVICE_NAME,"iPad Simulator");
                    cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.IOS);
                    cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, version);
                    cap.setCapability(MobileCapabilityType.APP, findApp.getAbsolutePath());
                    driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
                    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

                }
            }

        }else if(app.contains("Android")){
            //TODO Android
            if(OS.contains("Phone")){
                if(deviceType.contains("RealDevice")){
                    cap = new DesiredCapabilities();
                    cap.setCapability(MobileCapabilityType.DEVICE_NAME,"Android Phone");
                    cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
                    cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, version);
                    cap.setCapability(MobileCapabilityType.APP, findApp.getAbsolutePath());
                    driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
                    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

                }else if (deviceType.contains("Phone Emulator")){

                    cap = new DesiredCapabilities();
                    cap.setCapability(MobileCapabilityType.DEVICE_NAME,"Android Phone Emulator");
                    cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
                    cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, version);
                    cap.setCapability(MobileCapabilityType.APP, findApp.getAbsolutePath());
                    driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
                    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                }

            }else if(OS.contains("Tablets")){
                if(deviceType.contains("RealDevice")){
                    cap = new DesiredCapabilities();
                    cap.setCapability(MobileCapabilityType.DEVICE_NAME,"Android Tablets");
                    cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
                    cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, version);
                    cap.setCapability(MobileCapabilityType.APP, findApp.getAbsolutePath());
                    driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
                    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

                }else if (deviceType.contains("Tablets Emulator")){

                    cap = new DesiredCapabilities();
                    cap.setCapability(MobileCapabilityType.DEVICE_NAME,"Android Tablets Emulator");
                    cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
                    cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, version);
                    cap.setCapability(MobileCapabilityType.APP, findApp.getAbsolutePath());
                    driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
                    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                }

            }

        }




    }



    @AfterMethod
    public void cleanUpApp(){
        driver.quit();
    }






}
