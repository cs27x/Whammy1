package org.magnum.cs278.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.magnum.cs278.testdriven.App;
import org.magnum.cs278.testdriven.Event;

public class AppTest {
	private App app = new App();
	
	@Test
	public void testGetRandomEventThatIsToday() throws Exception {
		assertTrue(app.getRandomEventThatIsToday() == null ||
				app.getTodaysEvents().contains(app.getRandomEventThatIsToday()));
	}

	@Test
	public void testGetEventForMonth() throws Exception {
		List<Event> pubs = app.getEventsForMonth("Mar-2014");
		assertTrue(pubs.size() > 0); // At least one March-2014 event.
		for(Event temp : pubs) {
			assertEquals(temp.getMonth(),"Mar-2014");
		}
	}
}
