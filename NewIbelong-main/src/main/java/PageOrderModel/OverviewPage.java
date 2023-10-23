package PageOrderModel;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

public class OverviewPage {
	WebDriver driver;

	@FindBy(xpath = "//div[@class='ant-col ant-col-4 houses-grid']")
	WebElement HousesCard;
	@FindBy(xpath = "//span[@class='ant-select-selection-item']")
	WebElement Calender;
	@FindBy(xpath = "//span[text()='SuperAdmin']")
	WebElement superadminLogo;
	@FindBy(xpath = "//*[@class='SideBar_main__n9w6o']/nav/ul/li[4]")
	WebElement EventsModule;
	@FindBy(xpath = "//li[@id='Users']")
	WebElement UsersModule;

	public OverviewPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void displayingHouseCards() {

		int size = driver.findElements(By.xpath("//div[@class='ant-col ant-col-4 houses-grid']")).size();
		System.out.println("The Size of houses card is :" + "" + size);
		for (int i = 0; i <= size - 1; i++) {
			String name = driver.findElements(By.xpath("//div[@class='ant-col ant-col-4 houses-grid']")).get(i)
					.getText();
			System.out.println("The houses are : " + name);
		}
	}

	public void OverviewCalender() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		if (Calender.equals("2023")) {
			wait(1000);
			System.out.println("2023 Year calender is selected");

		} else {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5000));
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='ant-select-selection-item']")));
			driver.findElement(By.xpath("//span[@class='ant-select-selection-item']")).click();
			// wait(2000);

			driver.findElement(By.xpath("(//div[@class='ant-select-item-option-content'])[2]")).click();
			System.out.println("2023 selected");
		}
	}

	public void displayingSuperAdm() {
		boolean a = superadminLogo.isDisplayed();
		System.out.println("Superadmin get logged in" + " " + a);

	}

	public void TotalWhatsHappeningCards() {
		int cards = driver.findElements(By.xpath("//div[@class='ant-col ant-col-7 ant-col-offset-1 events-list']"))
				.size();
		System.out.println("Total whats happening cards present on overview page is :" + " " + cards);
	}

	public void ClickingOnHouseMod() throws InterruptedException {
		// WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(7000));
		// wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@id='vayu']"));

		driver.findElement(By.xpath("//li[@id='vayu']")).click();

		System.out.println("Enter in Vayu House page");
	}

}
