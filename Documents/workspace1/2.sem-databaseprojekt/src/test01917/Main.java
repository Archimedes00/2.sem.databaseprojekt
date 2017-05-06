package test01917;

import daoimpl01917.MySQLOperatoerDAO;
import daoimpl01917.MySQLProduktBatchDAO;
import daoimpl01917.MySQLProduktBatchKompDAO;
import daoimpl01917.MySQLRaavareBatchDAO;
import daoimpl01917.MySQLRaavareDAO;
import daoimpl01917.MySQLReceptDAO;
import daoimpl01917.MySQLReceptKompDAO;

import daointerfaces01917.DALException;
import dto01917.OperatoerDTO;
import dto01917.ProduktBatchDTO;
import dto01917.ProduktBatchKompDTO;
import dto01917.RaavareBatchDTO;
import dto01917.RaavareDTO;
import dto01917.ReceptDTO;
import dto01917.ReceptKompDTO;

import java.sql.SQLException;
import connector01917.Connector;

public class Main {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		new Connector();

		MySQLOperatoerDAO opr = new MySQLOperatoerDAO();
		MySQLProduktBatchDAO produktbatch = new MySQLProduktBatchDAO();
		MySQLProduktBatchKompDAO produktbatchkomp = new MySQLProduktBatchKompDAO();
		MySQLRaavareBatchDAO raavarebatch = new MySQLRaavareBatchDAO();
		MySQLRaavareDAO raavare = new MySQLRaavareDAO();
		MySQLReceptDAO recept = new MySQLReceptDAO();
		MySQLReceptKompDAO receptkomp = new MySQLReceptKompDAO();


		//		System.out.println("Operatoer nummer 3:");
		//		try { System.out.println(opr.getOperatoer(3)); }
		//		catch (DALException e) { System.out.println(e.getMessage()); }
		//
		//		System.out.println("Indsaettelse af ny operatoer med opr_id =  4");
		//		OperatoerDTO oprDTO = new OperatoerDTO(4,"Don Juan","DJ","000000-0000","iloveyou",1);
		//		try { opr.createOperatoer(oprDTO); }
		//		catch (DALException e) { System.out.println(e.getMessage()); }	
		//		
		//		System.out.println("Opdatering af initialer for operatoer nummer 4");
		//		oprDTO.setIni("DoJu");
		//		try { opr.updateOperatoer(oprDTO); }
		//		catch (DALException e) { System.out.println(e.getMessage()); }
		//		
		//		System.out.println("Indsaettelse af ny operatoer med opr_id =  5");
		//		OperatoerDTO oprDTO2 = new OperatoerDTO(5,"Bij Kapish","BK","123456-1337","sutmig",1);
		//		try { opr.createOperatoer(oprDTO2); }
		//		catch (DALException e) { System.out.println(e.getMessage()); }
		//
		//		System.out.println("Alle operatoerer:");
		//		try { System.out.println(opr.getOperatoerList()); }
		//		catch (DALException e) { System.out.println(e.getMessage()); }
		//
		//		System.out.println("Deactivating operatoer nummer 4");
		//		try { opr.deactivateOperatoer(oprDTO); }
		//		catch (DALException e) { System.out.println(e.getMessage()); }
		//		
		//		System.out.println("Operatoer nummer 5:");
		//		try { System.out.println(opr.getOperatoer(5)); }
		//		catch (DALException e) { System.out.println(e.getMessage()); }		


		//		System.out.println("Produktbatch nummer 2");
		//		try{ System.out.println((produktbatch.getProduktBatch(2))); }
		//		catch (DALException e) { System.out.println(e.getMessage());}

		//		System.out.println("Indsaettelse af ny produktbatch med pb_id =  6");
		//		ProduktBatchDTO produktbatchDTO = new ProduktBatchDTO(6, 0, 4);
		//		try { produktbatch.createProduktBatch(produktbatchDTO); }
		//		catch (DALException e) { System.out.println(e.getMessage()); }

		System.out.println("raavare nummer 4");
		try {System.out.println(raavare.getRaavare(4)); }
		catch (DALException e) {System.out.println(e.getMessage()); }
		
		System.out.println("Alle råvare:");
		try {System.out.println(raavare.getRaavareList()); }
		catch (DALException e) {System.out.println(e.getMessage()); }

		System.out.println("Oprettelse af ny råvare");
		RaavareDTO raavareDTO = new RaavareDTO(8, "penismælk", "Bijan himself");
		try { raavare.createRaavare(raavareDTO); }
		catch (DALException e) {System.out.println(e.getMessage()); }

		
		
		//		System.out.println("Raavare nummer 3:");
		//		try { System.out.println(raavare.getRaavare(3)); }
		//		catch (DALException e) { System.out.println(e.getMessage()); }
		//		
		//		System.out.println("Raavare nummer 10:");
		//		try { System.out.println(raavare.getRaavare(10)); }
		//		catch (DALException e) { System.out.println(e.getMessage()); }
	}
}