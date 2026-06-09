package pac2;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class BrowserStackCode {
	
	@Test
	public void sampleTest() throws MalformedURLException, InterruptedException {
		String username = "guruprasadkr_emCuEn";
		String password = "BUhqCLg6xL3WuWEM4MXD";
		
		MutableCapabilities capabilities = new MutableCapabilities();
		HashMap<String, Object> bstackOptions = new HashMap<String, Object>();
		capabilities.setCapability("browserName", "Chrome");
		bstackOptions.put("os", "Windows");
		bstackOptions.put("osVersion", "11");
		bstackOptions.put("buildName", "MyFirstBuild");
		bstackOptions.put("sessionName", "GoogleTitleTest");
		bstackOptions.put("browserVersion", "131.0");
		bstackOptions.put("consoleLogs", "info");
		capabilities.setCapability("bstack:options", bstackOptions);

		
		RemoteWebDriver driver = new RemoteWebDriver(new URL("https://"+username+":"+password+"@hub-cloud.browserstack.com/wd/hub"), capabilities);
		
		System.out.println("Session ID = " + driver.getSessionId());
		driver.get("https://google.com");
		
		System.out.println(driver.getTitle());
		Thread.sleep(3000);
		
		System.out.println("Before quit");
		
		driver.quit();
		
		System.out.println("After quit");
	}

}
