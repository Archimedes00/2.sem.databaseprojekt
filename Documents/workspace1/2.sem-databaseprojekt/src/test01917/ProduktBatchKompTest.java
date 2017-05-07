package test01917;

import static org.junit.Assert.*;

import org.junit.Test;

public class ProduktBatchKompTest {

	@Test
	public void test() {
		JUnitDBTest test = new JUnitDBTest();
		String expected = "(6, 8, 0.7, 3.5, 8)";
		System.out.println("Expected: " + expected);
		try {
		String actual = test.opretProduktBatchKomp();
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


