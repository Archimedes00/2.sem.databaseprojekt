package test01917;

import daoimpl01917.MySQLUsersDAO;
import daoimpl01917.MySQLProduktBatchDAO;
import daoimpl01917.MySQLRaavareDAO;

import daointerfaces01917.DALException;
import dto01917.UsersDTO;
import dto01917.ProduktBatchDTO;
import dto01917.RaavareBatchDTO;
import dto01917.RaavareDTO;

import java.sql.SQLException;
import connector01917.Connector;

public class Main {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		new Connector();

		MySQLUsersDAO opr = new MySQLUsersDAO();
		MySQLProduktBatchDAO produktbatch = new MySQLProduktBatchDAO();
		MySQLRaavareDAO raavare = new MySQLRaavareDAO();

		//tjekker UsersDAO
				System.out.println("Operatoer nummer 3:");
				try { System.out.println(opr.getOperatoer(3)); }
				catch (DALException e) { System.out.println(e.getMessage()); }
		
				System.out.println("Indsaettelse af ny operatoer med opr_id =  4");
				UsersDTO oprDTO = new UsersDTO(4,"Don Juan","DJ","000000-0000","iloveyou",1);
				try { opr.createOperatoer(oprDTO); }
				catch (DALException e) { System.out.println(e.getMessage()); }	
				
				System.out.println("Opdatering af initialer for operatoer nummer 4");
				oprDTO.setIni("DoJu");
				try { opr.updateOperatoer(oprDTO); }
				catch (DALException e) { System.out.println(e.getMessage()); }
		
				System.out.println("Alle operatoerer:");
				try { System.out.println(opr.getOperatoerList()); }
				catch (DALException e) { System.out.println(e.getMessage()); }
		
				System.out.println("Deactivating operatoer nummer 4");
				try { opr.deactivateOperatoer(oprDTO); }
				catch (DALException e) { System.out.println(e.getMessage()); }	
				
				//Kør operatoer_view her.

		//Tjekker RaavareDAO & Raavarebatch
				System.out.println("raavare nummer 4");
				try {System.out.println(raavare.getRaavare(4)); }
				catch (DALException e) {System.out.println(e.getMessage()); }

				System.out.println("Alle raavare:");
				try {System.out.println(raavare.getRaavareList()); }
				catch (DALException e) {System.out.println(e.getMessage()); }
				
				System.out.println("Oprettelse af ny raavare");
				RaavareDTO raavareDTO = new RaavareDTO(8, "juice", "Bijan & Jakobsen.");
				try { raavare.createRaavare(raavareDTO); }
				catch (DALException e) {System.out.println(e.getMessage()); }
				
				System.out.println("Køb af den nye raavare.");
				RaavareBatchDTO raavarebatchDTO = new RaavarebatchDTO()
				
				System.out.println("Raavare nummer 3:");
				try { System.out.println(raavare.getRaavare(3)); }
				catch (DALException e) { System.out.println(e.getMessage()); }

				System.out.println("Raavare nummer 10:");
				try { System.out.println(raavare.getRaavare(10)); }
				catch (DALException e) { System.out.println(e.getMessage()); }

		//tjekker produktbatchDAO
				System.out.println("Produktbatch nummer 2");
				try{ System.out.println((produktbatch.getProduktBatch(2))); }
				catch (DALException e) { System.out.println(e.getMessage());}

				System.out.println("Indsaettelse af ny produktbatch med pb_id =  6");
				ProduktBatchDTO produktbatchDTO = new ProduktBatchDTO(6, 0, 4);
				try { produktbatch.createProduktBatch(produktbatchDTO); }
				catch (DALException e) { System.out.println(e.getMessage()); }

	}
}