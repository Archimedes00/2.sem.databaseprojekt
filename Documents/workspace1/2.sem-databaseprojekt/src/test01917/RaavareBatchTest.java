package test01917;

import static org.junit.Assert.*;

import org.junit.Test;

public class RaavareBatchTest {

	@Test
	public void test() {
		JUnitDBTest test = new JUnitDBTest();
		String expected = "[8, 8, 500.0]";
		System.out.println("Expected: " + expected);
		try {
		String actual = test.opretRaavareBatch();
		System.out.println("Actual: " + actual);
		assertNotNull(actual);
		assertNotNull(expected);
		assertEquals(expected, actual);
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}

