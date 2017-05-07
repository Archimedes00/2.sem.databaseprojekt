package test01917;

import static org.junit.Assert.*;

import org.junit.Test;

public class ProduktBatchTest {

	@Test
	public void test() {
		JUnitDBTest test = new JUnitDBTest();
		String expected = "(6, 1, 3)";
		System.out.println("Expected: " + expected);
		try {
		String actual = test.opretProduktBatch();
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
