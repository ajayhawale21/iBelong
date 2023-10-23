package PageOrderModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage {
WebDriver driver;


@FindBy (xpath="//a[@href='/myProfile']")
WebElement profileModule;
@FindBy(xpath="//h2[text()='View House Card']")
WebElement viewHouseCard;
@FindBy (xpath="//div[@class='ant-upload ant-upload-select ant-upload-select-text']")
WebElement changeImage;
@FindBy (xpath="//span[@class='ant-select-selection-item']")
WebElement yearValue;
@FindBy (xpath="(//span)[16]")
WebElement eventParticipatedCount;









public ProfilePage (WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
	
}


public void EnteringProfileMod() throws InterruptedException {
	boolean p=profileModule.isEnabled();
	System.out.println("Entered in PROFILE module");
	wait(3000);
	viewHouseCard.click();
	wait(3000);
	System.out.println("Event participated count for Superadmin"+ eventParticipatedCount);
	
	driver.navigate().back();
	
}
public void changeImage() throws InterruptedException {
	Actions act = new Actions(driver);
	act.moveToElement(changeImage).click().perform();
	Thread.sleep(2000);
	
	uploadfile("C:\\Users\\Brigosha_Guest\\Desktop\\EventPic.jpg");
	System.out.println("Profile picture updated successfully");

}

private void uploadfile(String string) {
	// TODO Auto-generated method stub
	
}


public void changeEventCount() {
	// change year 2022 & 2023 - then println -events participated count
}

}
