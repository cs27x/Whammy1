package org.magnum.cs278.test;

import java.util.List;

import org.magnum.cs278.testdriven.*;

import static org.junit.Assert.*;

import org.junit.Test;

public class EventTest {
	
	private App app = new App();
	
	@Test
	public void test() throws Exception {
		List<Event> pubs = app.getEventsForMonth("Mar-2014");
		assertTrue(pubs.size() > 0); // At least one March-2014 event.
		for(Event temp : pubs) {
			assertEquals(temp.getMonth(),"Mar-2014");
		}
	}

}
