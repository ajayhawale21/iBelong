package Baseclass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseC {
	public static  WebDriver driver;
	public static Properties prop;
	
	
	public static String ReadConfig(String key) {
		try {
			prop = new Properties();
			
			FileInputStream ip = new FileInputStream("./configs\\config.properties");
			prop.load(ip);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String str = prop.getProperty(key);
		return str;
	}
	
	
	@BeforeSuite
	public static void startBrowser() {

		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--remote-allow-origins=*");

		WebDriver driver = new ChromeDriver(opt);
		
		System.out.println("URL data"+ReadConfig("url"));
		driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			
		driver.get(ReadConfig("url"));

	//	driver.get("https://testibelong.brigosha.com/?hash=634ac8a3c5969_88776677");
		System.out.println(driver.getTitle());

	}
@AfterSuite
public void quitBrowser() {
	driver.quit();
}




}
