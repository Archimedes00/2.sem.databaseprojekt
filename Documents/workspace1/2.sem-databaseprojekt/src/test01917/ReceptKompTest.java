package test01917;

import static org.junit.Assert.*;

import org.junit.Test;

public class ReceptKompTest {

	@Test
	public void test() {
		JUnitDBTest test = new JUnitDBTest();
		String expected = "[(4, 4, 2.0, 0.1)]";
		System.out.println("Expected: " + expected);
		try {
		String actual = test.opretReceptKomp();
		System.out.println("Actual: " + actual);
		assertNotNull(actual);
		assertNotNull(expected);
		assertEquals(expected, actual);
		
		test.resetTestResults();
		
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
