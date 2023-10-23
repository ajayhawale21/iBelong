package PageOrderModel;

import java.awt.Desktop.Action;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class HousePage {
	WebDriver driver;

	@FindBy(xpath = "//span[text()='2023']")
	WebElement Year;
	@FindBy(xpath = "//span[@title='All']")
	WebElement Location;
	@FindBy(xpath = "(//div[@class='house-details-content'])")
	WebElement Housecards;
	@FindBy(xpath = "//div[@class='ant-col ant-col-6']")
	WebElement CaptainNameCard;
	@FindBy(xpath = "//div [@name='VAYU']")
	WebElement VayuHouse;
	@FindBy(xpath = "//div[@class='scroll-menu-arrow ']")
	WebElement RightSideArrow;
	@FindBy(xpath = "//div[@class='scroll-menu-arrow scroll-menu-arrow--disabled']")
	WebElement LeftSideArrow;
	@FindBy(xpath = "//input[@id='searchUser']")
	WebElement SearchField;
	@FindBy(xpath = "//li[@class='ant-pagination-item ant-pagination-item-2']")
	WebElement SecondPage;
	@FindBy(xpath = "//li[@class='ant-pagination-item ant-pagination-item-3']")
	WebElement ThirdPage;
	@FindBy(xpath = "(//span[@role='img'])[5]")
	WebElement HouseFilter;
	@FindBy(xpath = "(//input[@type='radio'])[1]")
	WebElement VayuHouseOption;
	@FindBy(xpath = "//button[@class='ant-btn ant-btn-default users_locbtn__3VqOI']/span[text()='Ok']")
	WebElement OkBtn;
	@FindBy(xpath = "//input[@placeholder='Search']")
	WebElement SearchFld;
	@FindBy(xpath = "//span[text()='Download User Data ']")
	WebElement DownloadUserDataHouses;

	public HousePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void changeYear() throws InterruptedException {
		if (Year.equals("2023")) {
			System.out.println("2023 year associate data is showing");
		} else {
			Year.click();
			wait(3000);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5000));
			wait.until(ExpectedConditions.elementToBeClickable(
					By.xpath("(//div[@class='ant-select ant-select-single ant-select-show-arrow'])[1]")));
			driver.findElement(By.xpath("(//div[@class='ant-select ant-select-single ant-select-show-arrow'])[1]"))
					.click();

		}
	}

	public void changeLocation() throws InterruptedException {
		if (Location.equals("ALL")) {
			System.out.println("All locations option is selected");
		}

		else {
			driver.findElement(By.xpath("(//span[@class='ant-select-arrow'])[2]")).click();
			wait(3000);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4000));
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("")));

			driver.findElement(By.xpath("")).click();
		}
	}

	public void downloadData() {

		int size = driver.findElements(By.xpath("(//div[@class='house-details-content'])")).size();

		for (int i = 0; i <= size - 1; i++) {
			String HouseCard = driver.findElements(By.xpath("(//div[@class='house-details-content'])")).get(i)
					.getText();
			System.out.println("House card showing" + HouseCard);

		}
	}

	public void pagination() {
		Actions act = new Actions(driver);
		act.moveToElement(SecondPage);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5000));
		wait.until(ExpectedConditions.elementToBeClickable(SecondPage));

		SecondPage.click();

		ThirdPage.click();

		driver.findElement(By.xpath("//li[@class='ant-pagination-item ant-pagination-item-1']")).click();

	}

	public void searching(String AssociateNm) throws InterruptedException {
		HouseFilter.click();
		Thread.sleep(3000);
		VayuHouseOption.click();

		OkBtn.click();

		SearchFld.sendKeys(AssociateNm);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4000));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//tbody/tr/td[1])[1]")));
		driver.findElement(By.xpath("(//tbody/tr/td[1])[1]")).click();

		String AssociateName = (driver.findElement(By.xpath("//span[text()='Captain Vayu']"))).getText();
		System.out.println("Associate Name on which Click action is done" + AssociateName);

		if (AssociateName.equals("Captain Vayu")) {
			System.out.println("As per search name is successfully found");
		} else {
			System.out.println("Search action is failed");
		}

		driver.navigate().back();
	}

	public void AddingPrivilege() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5000));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Download User Data ']")));

		driver.findElement(By.xpath("//span[text()='Download User Data ']")).click();
		System.out.println("Vayu house user data gets downloaded");

	}
	
	public void EnteringUsersMod() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5000));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@id='Users']")));
		
		driver.findElement(By.id("Users")).click();
		System.out.println("Entered in the Users Module....");
	}

}
