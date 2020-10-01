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
	
	@Test
	public void testGetRepeats(){
		assertEquals(event1.getRepeats(), false);
		assertEquals(event2.getRepeats(), true);
		assertNotEquals(event1.getRepeats(), event2.getRepeats());
	}
	
	@Test
	public void testGetDate(){
		assertEquals(event1.getDate(), event2.getDate());
		assertNotEquals(event1.getDate(), LocalDate.of(2021, 12, 25));
		assertNotEquals(event2.getDate(), LocalDate.of(2020, 12, 31));
	}
	
	@Test
	public void testGetStartDate(){
		assertEquals(event2.getStartDate(), LocalDate.of(2020, 12, 25));
		assertNotEquals(event2.getStartDate(), LocalDate.of(2021, 12, 25));
		assertNotEquals(event2.getStartDate(), LocalDate.of(2020, 12, 31));
	}
	
	@Test
	public void testGetEndDate(){
		assertEquals(event2.getEndDate(), LocalDate.of(2020, 12, 31));
		assertNotEquals(event2.getEndDate(), LocalDate.of(2021, 12, 31));
		assertNotEquals(event2.getEndDate(), LocalDate.of(2020, 12, 25));
	}
	
	@Test
	public void testSummary(){
		assertNotEquals(event1.summary(), event2.summary());
		assertNotEquals(event1.summary(), "");
		assertNotEquals(event2.summary(), "");
	}
	
	@Test
	public void testGetRepetitionWeeksLength(){
		assertEquals(event2.getRepetitonWeeksLength(), 2);
		assertNotEquals(event2.getRepetitonWeeksLength(), 0);
		assertNotEquals(event2.getRepetitonWeeksLength(), 3);
	}
	
	@Test
	public void testGetMaskValue(){
		assertEquals(event2.getMaskValue(0,0), false);
		assertEquals(event2.getMaskValue(0,1), true);
		assertEquals(event2.getMaskValue(1,2), true);
	}
}