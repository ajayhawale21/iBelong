package PageOrderModel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class ChatsPage {
	WebDriver driver;

	@FindBy(xpath = "//a[@href='/chat']")
	WebElement ChatModule;
	@FindBy(xpath = "//button[@class='convo']")
	WebElement conversationTab;
	@FindBy(xpath = "//button[@class='grp']")
	WebElement GroupsTab;
	@FindBy(xpath = "//input[@id='searchUser']")
	WebElement searchField;
	@FindBy(xpath = "//span[@class='anticon anticon-search']")
	WebElement searchIcon;
	@FindBy(xpath = "(//div[@class='User'])[2]")
	WebElement captainVayuSearch;

	@FindBy(xpath = "//div[@class='ant-space-item']")
	WebElement threeDots;

	@FindBy(xpath = "//textarea[@placeholder='Type a message..']")
	WebElement textArea;

	public ChatsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void enteringChatMod(String SearchAssociateName) throws InterruptedException {
		ChatModule.click();
		wait(3000);
		boolean c = conversationTab.isDisplayed();
		boolean g = GroupsTab.isEnabled();
		System.out.println("conversation tabs is showing - " + c + "Group tab is showing -" + g);
		Assert.assertEquals(c, "True");
		searchField.clear();
		searchField.sendKeys(SearchAssociateName);
		wait(2000);
		searchIcon.click();
		wait(4000);
		captainVayuSearch.click();
		wait(1000);
		String chatName = driver.findElement(By.xpath("(//span[text()='Captain Vayu'])[2]")).getText();
		SoftAssert soft = new SoftAssert();
		soft.assertEquals("Captain Vayu", "chatName", "Same chat gets open");

	}

	public void chatActions() {
		boolean d = threeDots.isEnabled();
		System.out.println("Three dots button is  enabled" + d);
		threeDots.click();

		String ExpectedOptions[] = { "Mute", "Clear Chat" };

		Select sel = new Select(threeDots);
		List<WebElement> options = sel.getOptions();

		for (int i = 0; i < options.size(); i++) {

			// Assert.assertEqualsDeep(options.get(i).getText(), ExpectedOptions(i));
			driver.findElement(By.xpath("(//span[@class='ant-dropdown-menu-title-content'])[2]")).click();
		}

	}

	public void sendingMsg(String msg) throws InterruptedException {
		boolean t = driver.findElement(By.xpath("//div[@class='mentionInputContainer']")).isEnabled();
		System.out.println("Text field in chat is enabled :-" + " " + t);

		driver.findElement(By.xpath("//div[@class='mentionInputContainer']")).sendKeys(msg);
		wait(2000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}

	private void ExpectedOptions(int i) {
		// TODO Auto-generated method stub

	}

}
