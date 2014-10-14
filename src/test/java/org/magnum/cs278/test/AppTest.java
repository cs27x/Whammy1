package org.magnum.cs278.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.magnum.cs278.testdriven.App;

public class AppTest {
	private App app = new App();
	
	@Test
	public void testGetRandomEventThatIsToday() throws Exception {
		assertTrue(app.getRandomEventThatIsToday() == null ||
				app.getTodaysEvents().contains(app.getRandomEventThatIsToday()));
	}

}
