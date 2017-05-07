package test01917;

import static org.junit.Assert.*;

import org.junit.Test;

public class ReceptTest {

	@Test
	public void test() {
		JUnitDBTest test = new JUnitDBTest();
		String expected = "(4, Hawaii)";
		System.out.println("Expected: " + expected);
		try {
		String actual = test.opretRecept();
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
