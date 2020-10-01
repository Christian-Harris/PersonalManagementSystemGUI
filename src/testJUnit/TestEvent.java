package testJUnit;

import org.junit.Test;
import static org.junit.Assert.*;

import java.time.*;
import java.util.UUID;

import event.Event;

public class TestEvent{
	Event event1 = new Event("Test Event 1", LocalDate.of(2020, 12, 25), LocalTime.of(8, 30), LocalTime.of(18, 0), "an event for testing", "school", false);
	boolean[][] testMask = {
								{false, true, false, true, false, true, false},
								{false, false, true, false, true, false, false}
							};
	Event event2 = new Event("Test Event 2", LocalDate.of(2020, 12, 25), LocalTime.of(8, 30), LocalTime.of(18, 0), "an event for testing", "school", true, LocalDate.of(2020, 12, 25), LocalDate.of(2020, 12, 31), testMask);

	@Test
	public void testGetName(){
			assertEquals("Test Event 1", event1.getName());
			assertEquals("Test Event 2", event2.getName());
			assertNotEquals(event1.getName(), event2.getName());
	}
}