package pac1;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ContactTest {
	
	WebDriver driver;
	
	@Parameters("browserName")
	@Test
	public void createContactTest(String BN) throws MalformedURLException, InterruptedException {
		
		URL ipAdd = URI.create("http://localhost:4444").toURL();
		
		if(BN.equals("chrome")) {
			ChromeOptions option = new ChromeOptions();
			driver = new RemoteWebDriver(ipAdd, option);
		}else if(BN.equals("firefox")) {
			FirefoxOptions option = new 			FirefoxOptions();
			driver = new RemoteWebDriver(ipAdd, option);
		}else if(BN.equals("edge")) {
			EdgeOptions option = new EdgeOptions();
			driver = new RemoteWebDriver(ipAdd, option);
		}
		
		
		Thread.sleep(10000);
		driver.get("https://google.com");
		System.out.println(driver.getTitle());
		Thread.sleep(10000);
		driver.close();
	}

}