package test01917;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	OperatorTest.class, 
	RaavareTest.class, 
	RaavareBatchTest.class, 
	ProduktBatchTest.class, 
	ProduktBatchKompTest.class, 
	ReceptTest.class, 
	ReceptKompTest.class
		 })

public class AllTests {
	
}


