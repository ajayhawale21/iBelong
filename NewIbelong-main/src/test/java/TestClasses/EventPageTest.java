package TestClasses;

import org.testng.annotations.Test;

import Baseclass.BaseC;
import PageOrderModel.EventsPage;

public class EventPageTest extends BaseC {

	public EventsPage ev = new EventsPage(driver);

	@Test(priority = 17)
	public void DisplayEventsCount() {
		ev.addEventsBtnDisplay();
		ev.AllEvents();

	}

	@Test(priority = 18)
	public void AddingEvent() throws InterruptedException {
		ev.AddEventName();
		ev.addingEventsDetails(BaseC.ReadConfig("EventType"),BaseC.ReadConfig("FileType"),BaseC.ReadConfig("Description"),BaseC.ReadConfig("firstpoint"),BaseC.ReadConfig("secondpoint"), BaseC.ReadConfig("Thirdpoint"));
		ev.TotalPoints();
		ev.uploadFile();
	}

	@Test(priority = 19)
	public void EventsDisplaying() throws InterruptedException {
		ev.makeGridView();
	}

	@Test(priority = 20)
	public void EditingEvents() throws InterruptedException {
		ev.editEvents(BaseC.ReadConfig("EditFirstWinnerPoint"));
	}

	@Test(priority = 21)
	public void inactivatingEvents() {
		ev.inactivedEvent();
	}
	
	/*
	@Test(priority = 3)
	public void EventsTestPage() throws InterruptedException {
		ev.addEventsBtnDisplay();
		ev.AllEvents();
		ev.AddEventName();
		ev.addingEventsDetails(BaseC.ReadConfig("EventType"),BaseC.ReadConfig("FileType"), BaseC.ReadConfig("Description"), BaseC.ReadConfig("firstpoint"),BaseC.ReadConfig("secondpoint"), BaseC.ReadConfig("Thirdpoint"));
		ev.TotalPoints();
		ev.uploadFile();
		ev.makeGridView();
		ev.editEvents(BaseC.ReadConfig("EditFirstWinnerPoint"));
		ev.inactivedEvent();

	}
	*/

}
