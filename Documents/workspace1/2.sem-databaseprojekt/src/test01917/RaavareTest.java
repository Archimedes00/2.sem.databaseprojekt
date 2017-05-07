package test01917;
import static org.junit.Assert.*;

import org.junit.Test;

public class RaavareTest {

	@Test
	public void test() {
		JUnitDBTest test = new JUnitDBTest();
		String expected = "(8, champignon, Noget andet)";
		System.out.println("Expected: " + expected);
		try {
		String actual = test.opretRaavare();
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
