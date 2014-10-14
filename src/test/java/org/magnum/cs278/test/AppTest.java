package org.magnum.cs278.test;

import static org.junit.Assert.*;

import java.util.List;

import org.joda.time.DateTime;
import org.junit.Test;
import org.magnum.cs278.testdriven.App;
import org.magnum.cs278.testdriven.Event;

public class AppTest {

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	private App app = new App();
	
	@Test
	public void testGetThreeThingsToDo() throws Exception {
		List<Event> whatToDo = app.getThreeThingsToDo();
		assertEquals(3, whatToDo.size());
		
		DateTime today = DateTime.now();
		
		for(Event thingToDo : whatToDo){
			assertNotNull(thingToDo);
			assertNotNull(thingToDo.getDate());
			
			try{
				DateTime eventDate = Event.DATE_TIME_FORMAT.parseDateTime(thingToDo.getDate());
				assertTrue(eventDate.isAfter(today));
			}catch(IllegalArgumentException arg){
			}
		}
	}
	
	@Test
	public void testGetParkSpecialPermits() throws Exception {
		List<Event> events = app.getParkSpecialPermits();
		assertTrue(events.size() > 0);
		for(Event event : events){
			assertNotNull(event);
			assertNotNull(event.getLocation());
			assertNotNull(event.getName());
			assertNotNull(event.getAttendance());
			assertNotNull(event.getDate());
		}
	}
	
	
	@Test
	public void testGetEventsWithLocation() throws Exception {
		List<Event> events = app.getEventsWithLocation("riverfront park");
        assertTrue(events.size() > 0);
		for(Event event : events) {
			assertTrue(event.getLocation().toLowerCase().equals("riverfront park"));
		}
	}


	@Test
	public void testTodaysEvents() throws Exception {
		List<Event> whatToDo = app.getTodaysEvents();
		
		for(Event thingToDo : whatToDo){
			assertNotNull(thingToDo);
			assertNotNull(thingToDo.getDate());
			
			try{
				DateTime eventDate = Event.DATE_TIME_FORMAT.parseDateTime(thingToDo.getDate());
				assertTrue(eventDate.isEqualNow());
			}catch(IllegalArgumentException arg){
			}
		}
	}
	
	@Test
	public void testGetEventsForMonth() throws Exception {
		
		List<Event> events = app.getEventsForMonth("Mar-2014");
		assertTrue(events.size() == 1);
		assertEquals("Mar-2014", events.get(0).getMonth());
	}
	
	@Test
	public void testGetFirstEventOfMonth() throws Exception {
		String month = "Feb-2014";
		String testEventName = "Cupid's Chase";
		
		Event first = app.getFirstEventOfMonth(month);
		
		assertTrue(first.getName().equals(testEventName));
	}
}
