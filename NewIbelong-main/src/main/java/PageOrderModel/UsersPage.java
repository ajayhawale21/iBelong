package PageOrderModel;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class UsersPage {

	WebDriver driver;

	@FindBy(xpath = "//a[@href='/users']")
	WebElement UsersModule;
	@FindBy(xpath = "(//span[@class='ant-select-selection-item'])[1]")
	WebElement Year;
	@FindBy(xpath = "//div[@class='rc-virtual-list-holder']/div/div/div[2]")
	WebElement CurrentYearValue;
	@FindBy(xpath = "//span[text()='Download User Data ']")
	WebElement DownloadUserDataBtn;
	@FindBy(xpath = "//li[@class='ant-pagination-total-text']")
	WebElement UserCountText;
	@FindBy(xpath = "//input[@id='searchUser']")
	WebElement SearchField;
	@FindBy(xpath = "(//span[@class='anticon anticon-filter'])[1]")
	WebElement LocFilter;
	@FindBy(xpath = "(//span[@class='anticon anticon-filter'])[2]")
	WebElement HouseFilter;
	@FindBy(xpath = "(//input[@type='radio'])[1]")
	WebElement BangaloreLoc;
	@FindBy(xpath = "(//input[@type='radio'])[2]")
	WebElement COBLoc;
	@FindBy(xpath = "//button[@type='button']/span[text()='Reset']")
	WebElement ResetBtn;
	@FindBy(xpath = "//button[@type='button']/span[text()='Ok']")
	WebElement OkBtn;

	@FindBy(xpath = "(//span[@class='ant-select-selection-item'])[2]")
	WebElement PrivilegeField;
	@FindBy(xpath = "//div[@class='ant-select-item-option-content']")
	WebElement PrivilegeOptions;
	@FindBy(xpath = "(//div[@class='ant-select-item-option-content'])[2]")
	WebElement EventOrgPrivilege;
	
	@FindBy (xpath="//li[@id='Events']")
	WebElement EventsMod;

	public UsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void YearCheck() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		// Year.click();
		String YearValue = Year.getText();
		if (YearValue.contentEquals("2023")) {
			System.out.println("2023 year is selected for Users");
		} else {
			Year.click();
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3000));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(YearValue)));

			driver.findElement(By.xpath("//div[@class='rc-virtual-list-holder']/div/div/div[2]")).click();

		}
		// WebElement yearDropdown =
		// driver.findElement(By.xpath("//span[@title='2023']"));

		// Select selectYear = new Select(yearDropdown);

		// selectYear.selectByVisibleText("2023");

	}

	public void TotalActiveUsers() throws InterruptedException {
		String TotalCount = driver.findElement(By.xpath("//li[@class='ant-pagination-total-text']")).getText();
		System.out.println("Total active users count --" + " " + TotalCount);
		driver.findElement(By.xpath("//span[text()='Download User Data ']")).click();
		System.out.println("Downloaded the active users data..");
		wait(2000);

		driver.findElement(By.xpath("//span[text()='Inactive Associates']")).click();
		System.out.println("Inactive users are displaying");

		if (UserCountText.isDisplayed()) {
			System.out.println("In inactive users tab ,INACTIVE users data is present");
			wait(2000);
			driver.findElement(By.xpath("//span[text()='Download User Data ']")).click();
			System.out.println("Downloaded the inactive users data..");
		} else {
			System.out.println("Inactive users not present");
		}
		wait(2000);
		driver.findElement(By.xpath("//span[text()='Active Associates']")).click();
		System.out.println("Returned back to active users section");

	}

	public void searchingAciveAssociate(String ActiveAssociateName) throws InterruptedException {
		SearchField.clear();
		SearchField.sendKeys(ActiveAssociateName);
		wait(5000);
		String eventsCount = driver.findElement(By.xpath("(//tbody[@class='ant-table-tbody']/tr/td[4])[1]")).getText();
		System.out.println("Captain Jal has participated in" + " " + eventsCount + " Events");
		wait(2000);
		SearchField.clear();
		driver.navigate().refresh();
		wait(4000);

	}

	public void AddingFilters() throws InterruptedException {
		LocFilter.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3000));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@type='radio'])[1]")));
		BangaloreLoc.click();
		wait(2000);
		OkBtn.click();
		wait(4000);
		String Loc = driver.findElement(By.xpath("//tbody/tr[9]/td[5]")).getText();
		Assert.assertEquals(Loc, "bangalore", "Bangalore location matched");

		LocFilter.click();
		wait(2000);
		ResetBtn.click();

		SoftAssert soft = new SoftAssert();
		String ExpectedString = "bangalore";

		String ActualString = driver.findElement(By.xpath("//tbody/tr[2]/td[5]")).getText();

		soft.assertEquals(ActualString, ExpectedString, "String Location comparison failed due to reset.");

		soft.assertAll();

	}

	public void HousewiseFilter() throws InterruptedException {

		HouseFilter.click();
		wait(4000);
		driver.findElement(By.xpath("(//input[@type='radio'])[6]")).click(); // clicking on agni house

		wait(1000);
		driver.findElement(By.xpath("(//button[@type='button']/span[text()='Ok'])[2]")).click();
		System.out.println("Agni House is selected");

		DownloadUserDataBtn.click();
		System.out.println("Downloaded Agni house data without location filter");

		String ExpecetedHouse = "AGNI";
		String ActualHouse = driver.findElement(By.xpath("//tbody/tr[4]/td[8]")).getText();
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(ActualHouse, ExpecetedHouse, "String House match  successfully.");

		soft.assertAll();

		HouseFilter.click();
		wait(1000);

		driver.findElement(By.xpath("(//button[@type='button']/span[text()='Reset'])[2]")).click();

		wait(1000);

		driver.findElement(By.xpath("(//input[@type='radio'])[4]")).click(); // selecting prithvi house

		String PrithviHouse = driver.findElement(By.xpath("//tbody/tr[1]/td[8]")).getText();

		Assert.assertEquals(PrithviHouse, "PRITHVI", "PRITHVI House data is displaying");

	}

	public void addingPrivilege() throws InterruptedException {
		boolean p = PrivilegeField.isEnabled();
		System.out.println("Privileges can be selected");
		List<WebElement> ele = driver.findElements(By.xpath("//div[@class='ant-select-item-option-content']"));

		// for loop for printing all privileges

		PrivilegeField.click();
		wait(1000);
		EventOrgPrivilege.click();
		String Actual = driver.findElement(By.xpath("(//span[@class='ant-select-selection-item'])[2]")).getText();
		String Expected = "Event Organiser";
		if(Actual.equalsIgnoreCase(Expected)) {
			System.out.println("Event Organiser privilege has been added");
		}
		else {
			System.out.println("Privilege is not added correctly...");
		}

	}
	
	public void EnteringEventsMod() throws InterruptedException {
		EventsMod.click();
		wait(3000);
		System.out.println("Entered in Events Module...");
	}
	

}
