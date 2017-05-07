package test01917;

//
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import org.junit.Assert;

import connector01917.Connector;
import daoimpl01917.*;
import daointerfaces01917.DALException;
import dto01917.*;

public class JUnitDBTest {

	private Connector connector = new Connector(
			"localhost", 		//host
			3306, 				//port
			"lab_database2", 	//db
			"root", 			//user
			"root");			//pass
	
	
	Scanner scan = new Scanner(System.in);
	
	//Start test
	public void startTest() {
		System.out.println("Tryk på en knap for at køre testen.");
		scan.nextLine();
		
		try {
			
		opretOperator();
		opretRaavare();
		opretRaavareBatch();
		
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	//Test oprettelse af operator
	public void opretOperator() throws Exception {
		OperatoerDTO opr = new OperatoerDTO(8, "Henning", "HEN", "123421-0987", "hej", 1); //opretter bruger
		MySQLOperatoerDAO uDAO = new MySQLOperatoerDAO(connector);	//opretter DAO
		uDAO.createOperatoer(opr);	//opretter brugeren i databasen
		System.out.println("Bruger oprettet. Primary key: 8");
		System.out.println(uDAO.getOperatoer(opr.getOprId()).toString() + "\n"); //printer brugeren til consollen, taget fra databasen
	}
	
	//Test get række i raavare
	public void opretRaavare() throws Exception {
		RaavareDTO rv = new RaavareDTO(8, "champignon", "Noget andet");
		MySQLRaavareDAO rDAO = new MySQLRaavareDAO(connector);
		rDAO.createRaavare(rv);
		System.out.println("Raavare oprettet. Primary key: opr_id = 8");
		System.out.println(rDAO.getRaavare(rv.getRaavareId()).toString() + "\n");
	}
	
	//Test get række i raavarebatch
	public void opretRaavareBatch() throws Exception {
		RaavareBatchDTO rb = new RaavareBatchDTO(8, 8, 500);
		MySQLRaavareBatchDAO rDAO = new MySQLRaavareBatchDAO(connector);
		RaavareDTO rv = new MySQLRaavareDAO(connector).getRaavare(8);
		rDAO.createRaavareBatch(rb);
		System.out.println("Raavarebatch oprettet. Primary key: rb_id = 8");
		System.out.println(rDAO.getRaavareBatchList(rv.getRaavareId()).toString() + "\n");
	}
	

	
	public void resetTestResults() {
		System.out.println("Tryk på en knap for at gendanne testen.");
		scan.nextLine();
		try {
		connector.doUpdate("DELETE FROM operatoer WHERE opr_id = 8;");
		connector.doUpdate("DELETE FROM raavare WHERE raavare_id = 8;");
		connector.doUpdate("DELETE FROM raavarebatch WHERE rb_id = 8;");
		}
		catch (SQLException ex) {
			ex.printStackTrace();
		}
		
	}
	
	//Test get række i produktbatch
	
	//Test get række i produktbatchkomponent
	
	//test get række i recept
	
	//test get række i receptkomponent
	
	
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
