package test01917;

import java.sql.SQLException;
import org.junit.Test;
public class Main 
{
	public static void main(String[] args)
	{
//		ITUI userInterface = new TUI();
//		userInterface.Selector();
		
//		JUnitDBTest test = new JUnitDBTest();
//		try {
//		test.startTest();
//		test.resetTestResults();
//		}
//		catch(Exception ex) {
//			ex.printStackTrace();
//		}
		
		JUnitDBTest JUnit = new JUnitDBTest();
		OperatorTest ot = new OperatorTest();
		ot.test(JUnit);
		
		RaavareTest rt = new RaavareTest();
		rt.test(JUnit);
		
	}
}
