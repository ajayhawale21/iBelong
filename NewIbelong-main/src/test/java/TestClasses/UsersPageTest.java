package TestClasses;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import Baseclass.BaseC;
import PageOrderModel.UsersPage;

public class UsersPageTest extends BaseC {

	public UsersPage up = new UsersPage(driver);
	@Ignore
	  @Test(priority=11) public void UsersCount() throws InterruptedException {
	  up.TotalActiveUsers(); }
	 
	 
	  @Test(priority=12) public void searchingAssociate() throws
	 InterruptedException { up.searchingAciveAssociate(BaseC.ReadConfig("ActiveAssociateName"));
	  
	  }
	 
	  @Test(priority=13) public void AddingLocationFilters() throws
	  InterruptedException { up.AddingFilters(); }
	  
	  @Test (priority=14) public void AddingHouseFilters() throws
	  InterruptedException { up.HousewiseFilter(); }
	 
	 
	  @Test(priority=15) public void AddPrivileges() throws InterruptedException {
	  up.addingPrivilege(); }
	  
	  @Test(priority=16) public void EventsMod() throws InterruptedException {
	  up.EnteringEventsMod(); }
	  
	/*

	@Test(priority = 2)
	public void UserTestPage() throws InterruptedException {
		up.TotalActiveUsers();
		up.searchingAciveAssociate(BaseC.ReadConfig("ActiveAssociateName"));
		up.AddingFilters();
		up.HousewiseFilter();
		up.addingPrivilege();
		up.EnteringEventsMod();

	}
	 */
}
