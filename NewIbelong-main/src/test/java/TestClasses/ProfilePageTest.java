package TestClasses;

import org.testng.annotations.Test;

import Baseclass.BaseC;
import PageOrderModel.ProfilePage;

public class ProfilePageTest extends BaseC {

public ProfilePage pp=new 	ProfilePage(driver);
	
	
	@Test(priority=22)
	public void ProfileModuleEntering() throws InterruptedException {
		pp.EnteringProfileMod();
	}
	
	@Test(priority=23)
	public void updatingImage() throws InterruptedException {
		pp.changeImage();
	}
	
	
	
	/*
	@Test(priority=4)
	public void ProfileTestPage() throws InterruptedException {
		pp.EnteringProfileMod();
		pp.changeImage();
		
	}
	
	*/
}
