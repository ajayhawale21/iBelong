package TestClasses;

import org.testng.annotations.Test;

import Baseclass.BaseC;
import PageOrderModel.ChatsPage;

public class ChatPageTest extends BaseC {
	public ChatsPage cp = new ChatsPage(driver);
	
	 
	  @Test(priority=24) public void ChatModEntering() throws InterruptedException
	  { cp.enteringChatMod(BaseC.ReadConfig("SearchAssociateName"));
	  
	  
	 }
	  
	  @Test(priority=25) public void chats() {
		  cp.chatActions(); 
		  }
	  
	 @Test(priority=26)
	  
	  public void MsgSending() throws InterruptedException { cp.sendingMsg(BaseC.ReadConfig("msg")); }
	

	 
	 /*
	@Test(priority = 5)
	public void ChatTestPage() throws InterruptedException {
		cp.enteringChatMod(BaseC.ReadConfig("SearchAssociateName"));
		cp.chatActions();
		cp.sendingMsg(BaseC.ReadConfig("msg"));

	}
 */
}
