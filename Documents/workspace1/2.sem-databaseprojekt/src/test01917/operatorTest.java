package test01917;

import static org.junit.Assert.*;
import org.hamcrest.Matchers.*;
import org.junit.Test;

public class operatorTest {

	@Test
	public void test() {
		JUnitDBTest2 test = new JUnitDBTest2();
		String expected = "(8, Henning, HEN, 123421-0987, hej, 1)";
		System.out.println("Expected: " + expected);
		try {
		String actual = test.opretOperator();
		System.out.println("Actual: " + actual);
		assertNotNull(actual);
		assertNotNull(expected);
//		assertTrue(actual.matches(expected));
		assertEquals(expected, actual);
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
