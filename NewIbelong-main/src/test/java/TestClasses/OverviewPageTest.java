package TestClasses;

import org.testng.annotations.Test;

import Baseclass.BaseC;
import PageOrderModel.OverviewPage;

public class OverviewPageTest extends BaseC {

	public OverviewPage ov = new OverviewPage(driver);

	
	  @Test(priority = 0, enabled = true) public void displayingCards() {
	  ov.displayingHouseCards();
	  
	 }
	 
	 @Test(priority = 1) public void selectingCalender() throws
	  InterruptedException { ov.OverviewCalender();
	  System.out.println("Second Test"); }
	  
	  @Test(priority = 2) public void DisplaySuperad() { ov.displayingSuperAdm(); }
	 
	  @Test(priority = 3, groups = { "iBelong" }) public void TotalCards() {
	  ov.TotalWhatsHappeningCards(); }
	  
	  @Test(priority = 4) public void EventsModule() throws InterruptedException {
	  ov.ClickingOnHouseMod(); }
	  
	 
	 
/*
	@Test(priority = 0)
	public void OverviewPageAllTCS() throws InterruptedException {
		ov.displayingHouseCards();

		ov.OverviewCalender();
		ov.displayingSuperAdm();
		ov.TotalWhatsHappeningCards();
		ov.ClickingOnHouseMod();

	}*/

}
