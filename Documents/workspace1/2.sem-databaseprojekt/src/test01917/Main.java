package test01917;

import java.sql.SQLException;

public class Main 
{
	public static void main(String[] args)
	{
//		ITUI userInterface = new TUI();
//		userInterface.Selector();
		
		JUnitDBTest test = new JUnitDBTest();
		try {
		test.startTest();
		test.resetTestResults();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}
