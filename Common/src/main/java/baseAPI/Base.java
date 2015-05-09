package baseAPI;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by mrahman on 5/3/15.
 */
public class Base {


    public static AppiumDriver driver = null;
    public String OS = null;
    public String deviceName = null;
    public String deviceType = null;
    public String appType = null;
    public String version = null;
    public File appDirectory = null;
    public File findApp = null;
    public DesiredCapabilities cap = null;

    @Parameters ({"OS","appType","deviceType","deviceName","version"})
    @BeforeMethod
    public void setUp(String OS,String appType, String deviceType, String deviceName, String version)throws
            IOException, InterruptedException{

       // Runtime.getRuntime().exec("/Applications/Appium.app/Contents/Resources/node_modules/appium/bin/appium.js");
        //Thread.sleep(8000);
        System.out.println("Appium Server has been started");
        if(OS.equalsIgnoreCase("ios")){
            if(appType.contains("iPhone")){
                appDirectory = new File("IOS/src/app");
                findApp = new File(appDirectory,"UICatalog6.1.app.zip");
                if(deviceType.equalsIgnoreCase("RealDevice")){
                    cap = new DesiredCapabilities();
                    cap.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
                    cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.IOS);
                    cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, version);
                    cap.setCapability(MobileCapabilityType.APP, findApp.getAbsolutePath());
                    driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

                }else if (deviceType.equalsIgnoreCase("Simulator")){
                    cap = new DesiredCapabilities();
                    cap.setCapability(MobileCapabilityType.DEVICE_NAME,deviceName);
                    cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.IOS);
                    cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, version);
                    cap.setCapability(MobileCapabilityType.APP, findApp.getAbsolutePath());
                    driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                }


            }else if(appType.equalsIgnoreCase("iPad")){
                appDirectory = new File("IOS/src/app");
                findApp = new File(appDirectory,"UICatalog6.1.app.zip");
                if(deviceType.contains("RealDevice")){
                    cap = new DesiredCapabilities();
                    cap.setCapability(MobileCapabilityType.DEVICE_NAME,deviceName);
                    cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.IOS);
                    cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, version);
                    cap.setCapability(MobileCapabilityType.APP, findApp.getAbsolutePath());
                    driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

                }else if (deviceType.equalsIgnoreCase("Simulator")){
                    cap = new DesiredCapabilities();
                    cap.setCapability(MobileCapabilityType.DEVICE_NAME,deviceName);
                    cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.IOS);
                    cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, version);
                    cap.setCapability(MobileCapabilityType.APP, findApp.getAbsolutePath());
                     driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

                }
            }

        }else if(OS.contains("Android")){
            if(appType.contains("Phone")){
                appDirectory = new File("Android/src/app");
                findApp = new File(appDirectory,"snapchat.apk");
                if(deviceType.equalsIgnoreCase("RealDevice")){
                    cap = new DesiredCapabilities();
                    cap.setCapability(MobileCapabilityType.DEVICE_NAME,deviceName);
                    cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
                    cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, version);
                    cap.setCapability(MobileCapabilityType.APP, findApp.getAbsolutePath());
                    driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

                }else if (deviceType.equalsIgnoreCase("Emulator")){

                    cap = new DesiredCapabilities();
                    cap.setCapability(MobileCapabilityType.DEVICE_NAME,deviceName);
                    cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
                    cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, version);
                    cap.setCapability(MobileCapabilityType.APP, findApp.getAbsolutePath());
                    driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                }

            }else if(OS.equalsIgnoreCase("Tablets")){
                if(deviceType.equalsIgnoreCase("RealDevice")){
                    cap = new DesiredCapabilities();
                    cap.setCapability(MobileCapabilityType.DEVICE_NAME,deviceName);
                    cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
                    cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, version);
                    cap.setCapability(MobileCapabilityType.APP, findApp.getAbsolutePath());
                    driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

                }else if (deviceType.equalsIgnoreCase("Emulator")){

                    cap = new DesiredCapabilities();
                    cap.setCapability(MobileCapabilityType.DEVICE_NAME,deviceName);
                    cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
                    cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, version);
                    cap.setCapability(MobileCapabilityType.APP, findApp.getAbsolutePath());
                    driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                }

            }

        }




    }



    @AfterMethod
    public void cleanUpApp(){
        driver.quit();
    }

    public void clickByXpath(String locator){
        driver.findElement(By.xpath(locator)).click();
    }
    public void clickByXpathWebElement(WebElement locator){
        locator.click();
    }
    public void sleep(int sec)throws InterruptedException{
        Thread.sleep(1000 * sec);
    }

    public void typeByXpath(String locator, String value, Keys key){
        driver.findElement(By.xpath(locator)).sendKeys(value);
    }

    public List<String> getTexts(List<WebElement> elements){
        List<String> text = new ArrayList<String>();
        for(WebElement element:elements){
            text.add(element.getText());
        }

        return text;
    }







}
