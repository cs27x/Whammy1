package org.magnum.cs278.test;

import java.util.List;

import org.magnum.cs278.testdriven.*;

import static org.junit.Assert.*;
import org.junit.Test;
import org.magnum.cs278.testdriven.Event;

public class EventTest {
	private Event testEvent = new Event("name", "location", "0", "1", "1/1/2001");

	@Test
	public void testToString() {
		assertTrue(testEvent.toString().equals("name / location / 0 / 1 / 1/1/2001"));
	}
	
	@Test
	public void testGetDateTime() {
		assertTrue(testEvent.getDateTime().equals(Event.DATE_TIME_FORMAT.parseDateTime("1/1/2001")));
	}
}
