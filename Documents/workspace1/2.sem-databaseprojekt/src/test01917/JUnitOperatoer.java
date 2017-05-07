package test01917;

//
import java.sql.ResultSet;

import connector01917.Connector;
import daoimpl01917.MySQLUserDAO;
import daointerfaces01917.DALException;
import dto01917.UsersDTO;

public class JUnitOperatoer {

	private Connector connector = new Connector();
		
	public void OprettelseAfOperatoer() throws Exception {
		connector.doUpdate(
				"INSERT INTO operatoer(opr_id, opr_navn, ini, cpr, password) VALUES " +
				"(" + opr.getOprId() + ", '" + opr.getOprNavn() + "', '" + opr.getIni() + "', '" + 
				opr.getCpr() + "', '" + opr.getPassword() + "')"
			);
	}
	
	public void test () {
		Assert.assertNotNull(this.player1);
		Assert.assertNotNull(this.player2);
	
		Assert.assertNotNull(pay1000);
		Assert.assertNotNull(get1000);
		Assert.assertNotNull(get500FromPlayer2);
		
		Assert.assertTrue(this.pay1000 instanceof PlayerPayMoney);
		Assert.assertTrue(this.get1000 instanceof PlayerGetMoney);
		Assert.assertTrue(this.get500FromPlayer2 instanceof GetMoneyFromPlayers);
	}
	
	public void testDrawCardPay1000() {
		int expected = 30000; 
		int actual = this.player1.getPoints();
		Assert.assertEquals(expected, actual);
		
		this.pay1000.DrawCard(player1);
		expected = 29000;
		actual = this.player1.getPoints();
		Assert.assertEquals(expected, actual);		
	}
	
	

}
