package com.yanfuchang.appium.testng;

import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class NewTest {
	
	private AndroidDriver<AndroidElement> driver;
	/**
	 *	每个测试用例执行之前执行该方法
	 */
	@BeforeTest
	public void setUp() throws Exception {
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability("automationName", "Appium");//appium做自动化
		cap.setCapability("deviceName", "emulator-5554");//设备名称
		cap.setCapability("platformName", "Android"); //安卓自动化还是IOS自动化
		cap.setCapability("platformVersion", "6.0"); //安卓操作系统版本
		cap.setCapability("appPackage","com.android.calculator2");//被测app的包名
		cap.setCapability("appActivity",".Calculator");//被测app的入口Activity名称
		cap.setCapability("unicodeKeyboard", "True"); //支持中文输入
		cap.setCapability("resetKeyboard", "True"); //支持中文输入，必须两条都配置
		cap.setCapability("newCommandTimeout", "30"); //没有新命令，appium30秒退出
		driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);//把以上配置传到appium服务端并连接手机
	}

	/**
	 *	测试用例
	 */
	@Test
	public void test() {
		driver.pressKeyCode(3);
	}
	
	/**
	 *	每个测试用例执行之后执行该方法
	 */
	@AfterTest
	public void tearDown() {
		driver.quit();//关闭
	}
}
