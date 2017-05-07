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
		opretProduktBatch();
		opretProduktBatchKomp();
		
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	//Test oprettelse af- og get operator
	public String opretOperator() throws Exception {
		OperatoerDTO opr = new OperatoerDTO(8, "Henning", "HEN", "123421-0987", "hej", 1); //opretter bruger
		MySQLOperatoerDAO uDAO = new MySQLOperatoerDAO(connector);	//opretter DAO
		uDAO.createOperatoer(opr);	//opretter brugeren i databasen
		System.out.println("Bruger oprettet. Primary key: 8");
		System.out.println(uDAO.getOperatoer(opr.getOprId()).toString() + "\n"); //printer brugeren til consollen, taget fra databasen
		return uDAO.getOperatoer(opr.getOprId()).toString();
	}
	
	//Test opret get række i raavare
	public String opretRaavare() throws Exception {
		RaavareDTO rv = new RaavareDTO(8, "champignon", "Noget andet");
		MySQLRaavareDAO rDAO = new MySQLRaavareDAO(connector);
		rDAO.createRaavare(rv);
		System.out.println("Raavare oprettet. Primary key: opr_id = 8");
		System.out.println(rDAO.getRaavare(rv.getRaavareId()).toString() + "\n");
		return rDAO.getRaavare(rv.getRaavareId()).toString();
	}
	
	//Test opret og get række i raavarebatch
	public String opretRaavareBatch() throws Exception {
		RaavareBatchDTO rb = new RaavareBatchDTO(8, 8, 500);
		MySQLRaavareBatchDAO rDAO = new MySQLRaavareBatchDAO(connector);
		RaavareDTO rv = new MySQLRaavareDAO(connector).getRaavare(8);
		rDAO.createRaavareBatch(rb);
		System.out.println("Raavarebatch oprettet. Primary key: rb_id = 8");
		System.out.println(rDAO.getRaavareBatchList(rv.getRaavareId()).toString() + "\n");
		return rDAO.getRaavareBatchList(rv.getRaavareId()).toString();
	}
	
	//Test opret og get række i produktbatch
	public String opretProduktBatch() throws Exception {
		ProduktBatchDTO pb = new ProduktBatchDTO(6, 1, 3);
		MySQLProduktBatchDAO pDAO = new MySQLProduktBatchDAO(connector);
		pDAO.createProduktBatch(pb);
		System.out.println("Produktbatch oprettet. Primary key: pb_id = 6;");
		System.out.println(pDAO.getProduktBatch(pb.getPbId()).toString() + "\n");
		return pDAO.getProduktBatch(pb.getPbId()).toString();
	}
	
	//Test get række i produktbatchkomponent
	public String opretProduktBatchKomp() throws Exception {
		ProduktBatchKompDTO pb = new ProduktBatchKompDTO(6, 8, 0.7, 3.5, 8);
		MySQLProduktBatchKompDAO pDAO = new MySQLProduktBatchKompDAO(connector);
		pDAO.createProduktBatchKomp(pb);
		System.out.println("Produktbatch oprettet. Primary key: pb_id = 6; & rb_id = 8;");
		System.out.println(pDAO.getProduktBatchKomp(pb.getPbId(), pb.getRbId()).toString() + "\n");
		return pDAO.getProduktBatchKomp(pb.getPbId(), pb.getRbId()).toString();
	}
	
	//test get række i recept
	public String opretRecept() throws Exception {
		ReceptDTO rc = new ReceptDTO(4, "Hawaii");
		MySQLReceptDAO rDAO = new MySQLReceptDAO(connector);
		rDAO.createRecept(rc);
		System.out.println("Recept oprettet. Primary key: recept_id = 4;");
		System.out.println(rDAO.getRecept(rc.getReceptId()).toString() + "\n");
		return rDAO.getRecept(rc.getReceptId()).toString();
	}
	
	//test get række i receptkomponent
	public String opretReceptKomp() throws Exception {
		ReceptKompDTO rc = new ReceptKompDTO(4, 4, 2, 0.1);
		MySQLReceptKompDAO rDAO = new MySQLReceptKompDAO(connector);
		rDAO.createReceptKomp(rc);
		System.out.println("Recept oprettet. Primary key: recept_id = 4;");
		System.out.println(rDAO.getReceptKompList(rc.getReceptId()).toString() + "\n");
		return rDAO.getReceptKompList(rc.getReceptId()).toString();
	}
	
	public void resetTestResults() {
		System.out.println("\nTryk på en knap for at gendanne testen.");
		scan.nextLine();
		try {
		//CALL resetTest kører den gemete procedure resetTest i databasen
		connector.doUpdate("CALL resetTest");
		}
		catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	//Proceduren erstatter alt udkommenteret kode nedenunder.
//	connector.doUpdate("DELETE FROM produktbatchkomponent WHERE pb_id = 6 AND rb_id = 8;");
//	System.out.println("Produktbachkomponent slettet.");
//	connector.doUpdate("DELETE FROM operatoer WHERE opr_id = 8;");
//	System.out.println("Operator slettet.");
//	connector.doUpdate("DELETE FROM raavarebatch WHERE rb_id = 8;");
//	System.out.println("Raavarebatch slettet.");
//	connector.doUpdate("DELETE FROM raavare WHERE raavare_id = 8;");
//	System.out.println("Raavare slettet.");
//	connector.doUpdate("DELETE FROM produktbatch WHERE pb_id = 6;");
//	System.out.println("Produktbatch slettet.");
//	connector.doUpdate("DELETE FROM receptkomponent WHERE recept_id = 4;");
//	System.out.println("Receptkomponent slettet.");
//	connector.doUpdate("DELETE FROM recept WHERE recept_id = 4;");
//	System.out.println("Recept slettet.");

}
