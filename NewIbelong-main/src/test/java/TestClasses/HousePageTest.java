package TestClasses;

import org.testng.annotations.Test;

import Baseclass.BaseC;
import PageOrderModel.HousePage;

public class HousePageTest extends BaseC {

	public HousePage hp = new HousePage(driver);

	@Test(priority = 5)

	public void ChangingYearInVayu() throws InterruptedException {
		hp.changeYear();
		hp.changeLocation();

	}

	@Test(priority = 6)
	public void DownloadingData() {
		hp.downloadData();

	}

	@Test(priority = 7)
	public void PaginationTest() {
		hp.pagination();
	}

	@Test(priority = 8)
	public void SearchingAssociate(String AssociateNm) throws InterruptedException {
		hp.searching(BaseC.ReadConfig(AssociateNm));
	}

	@Test(priority = 9)
	public void GivingPriv() {
		hp.AddingPrivilege();
	}

	@Test(priority = 10)
	public void UserMod() {
		hp.EnteringUsersMod();
	}

	/*
	 * 
	 * @Test(priority=1) public void HouseTestPage() throws InterruptedException {
	 * hp.changeYear(); hp.changeLocation(); hp.downloadData();
	 * 
	 * hp.pagination(); hp.searching(BaseC.ReadConfig("AssociateNm"));
	 * hp.AddingPrivilege(); hp.EnteringUsersMod();
	 * 
	 * 
	 * 
	 * }
	 * 
	 */

}
