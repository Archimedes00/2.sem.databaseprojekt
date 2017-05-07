package test01917;

//
import java.sql.ResultSet;
import java.util.Scanner;

import org.junit.Assert;

import connector01917.Connector;
import daoimpl01917.MySQLUserDAO;
import daointerfaces01917.DALException;
import dto01917.*;

public class JUnitDBTest {

	private Connector connector = new Connector(
			"localhost", 		//host
			3306, 				//port
			"lab_database2", 	//db
			"root", 			//user
			"root");			//pass
	
	//Test oprettelse af operator
	Scanner scan = new Scanner(System.in);
	public void startTest() {
		System.out.println("Tryk på en knap for at køre testen.");
		scan.nextLine();
	}
	
	public void opretOperator() throws Exception {
		UserDTO opr = new UserDTO(8, "Henning", "HEN", "123421-0987", "hej", 1);
		
		connector.doUpdate(
				"INSERT INTO operatoer(opr_id, opr_navn, ini, cpr, password, opr_status) VALUES " +
				"(" + opr.getOprId() + ", '" + opr.getOprNavn() + "', '" + opr.getIni() + "', '" + 
				opr.getCpr() + "', '" + opr.getPassword() + "', " + opr.getStatus() + ");"
			);
		
		System.out.println("Bruger oprettet. Primary key: 8");
	}
	
	//Test get række i raavare
	
	//Test get række i raavarebatch
	
	//Test get række i produktbatch
	
	//Test get række i produktbatchkomponent
	
	//test get række i recept
	
	//test get række i receptkomponent
	
	
	public void resetTestResults() {
		System.out.println("Tryk på en knap for at gendanne testen.");
		scan.nextLine();
	}
	
//	
//	public void test () {
//		Assert.assertNotNull(this.player1);
//		Assert.assertNotNull(this.player2);
//	
//		Assert.assertNotNull(pay1000);
//		Assert.assertNotNull(get1000);
//		Assert.assertNotNull(get500FromPlayer2);
//		
//		Assert.assertTrue(this.pay1000 instanceof PlayerPayMoney);
//		Assert.assertTrue(this.get1000 instanceof PlayerGetMoney);
//		Assert.assertTrue(this.get500FromPlayer2 instanceof GetMoneyFromPlayers);
//	}
//	
//	public void testDrawCardPay1000() {
//		int expected = 30000; 
//		int actual = this.player1.getPoints();
//		Assert.assertEquals(expected, actual);
//		
//		this.pay1000.DrawCard(player1);
//		expected = 29000;
//		actual = this.player1.getPoints();
//		Assert.assertEquals(expected, actual);		
//	}
//	
//	

}
