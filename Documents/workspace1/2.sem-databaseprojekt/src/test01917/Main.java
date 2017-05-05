package test01917;

import daoimpl01917.MySQLOperatoerDAO;
import daoimpl01917.MySQLProduktBatchDAO;
import daoimpl01917.MySQLProduktBatchKompDAO;
import daoimpl01917.MySQLRaavareBatchDAO;
import daoimpl01917.MySQLRaavareDAO;
import daoimpl01917.MySQLReceptDAO;
import daoimpl01917.MySQLReceptKompDAO;

import daointerfaces01917.DALException;
import daointerfaces01917.OperatoerDAO;
import daointerfaces01917.ProduktBatchDAO;
import daointerfaces01917.ProduktBatchKompDAO;
import daointerfaces01917.RaavareBatchDAO;
import daointerfaces01917.RaavareDAO;
import daointerfaces01917.ReceptDAO;
import daointerfaces01917.ReceptKompDAO;
import dto01917.OperatoerDTO;
import dto01917.ProduktBatchDTO;
import dto01917.ProduktBatchKompDTO;
import dto01917.RaavareBatchDTO;
import dto01917.RaavareDTO;
import dto01917.ReceptDTO;
import dto01917.ReceptKompDTO;



import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import connector01917.Connector;

public class Main 
{
	private OperatoerDAO DAO;
	private OperatoerDTO DTO;
	int input;
	Scanner scan = new Scanner(System.in);
	
	public void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		new Connector();
		
		
		
		System.out.println("Please choose which Schema to operate in");
		
		
		System.out.println("============================");
        System.out.println("|       MENU SELECTION     	|");
        System.out.println("=============================");
        System.out.println("| Options:                	|");
        System.out.println("|      1. Operatoer			|");
        System.out.println("|      2. ProduktBatch     	|");
        System.out.println("|      3. ProduktBatchKomp 	|");
        System.out.println("|      4. Recept		    |");
        System.out.println("|      5. ReceptKomp		|");
        System.out.println("|	   6. RaavareBatch		|");
        System.out.println("|	   7. Raavare  		    |");
        System.out.println("|	    			 		|");
        System.out.println("=============================");
        
         
		int chooseRole = scan.nextInt();
		
        switch (chooseRole) 
        {
            case 1:	
            	{
            		OperatoerDAO DAO = new MySQLOperatoerDAO();
            		OperatoerDTO DTO = new OperatoerDTO(0, null, null, null, null); //Initialising the object//
            		startOperation(DAO, DTO);
            		break;
                }
            case 2:	
            	{
            		ProduktBatchDAO DAO = new MySQLProduktBatchDAO();
            		ProduktBatchDTO DTO = new ProduktBatchDTO(0, 0, 0);
                	break;
                }
            case 3:
            	{
            		ProduktBatchKompDAO DAO = new MySQLProduktBatchKompDAO();
            		ProduktBatchKompDTO DTO = new ProduktBatchKompDTO(0, 0, 0, 0, 0);
            		break;
            	}
                
            case 4:
            	{
            		ReceptDAO DAO = new MySQLReceptDAO();
            		ReceptDTO DTO = new ReceptDTO(0, null);
            		break;
            	}
            case 5:
        		{
        			ReceptKompDAO DAO = new MySQLReceptKompDAO();
        			ReceptKompDTO DTO = new ReceptKompDTO(0, 0, 0, 0);
        			break;
        		}
            case 6:
    			{
    				RaavareBatchDAO DAO = new MySQLRaavareBatchDAO();
    				RaavareBatchDTO DTO = new RaavareBatchDTO(0, 0, 0);
    				break;
    			}
            case 7:
				{
					RaavareDAO DAO = new MySQLRaavareDAO();
					RaavareDTO DTO = new RaavareDTO(0, null, null);
					break;
				}
            default:
                System.out.println("Invalid entry");
                break;
        }
        
        scan.close();
        
        
    
        /*
		System.out.println("Operatoer nummer 3:");
		MySQLOperatoerDAO opr = new MySQLOperatoerDAO();
		try { System.out.println(opr.getOperatoer(3)); }
		catch (DALException e) { System.out.println(e.getMessage()); }

		System.out.println("Indsaettelse af ny operatoer med opr_id =  4");
		OperatoerDTO oprDTO = new OperatoerDTO(4,"Don Juan","DJ","000000-0000","iloveyou");
		try { opr.createOperatoer(oprDTO); }
		catch (DALException e) { System.out.println(e.getMessage()); }	

		System.out.println("Operatoer nummer 4:");
		try { System.out.println(opr.getOperatoer(4)); }
		catch (DALException e) { System.out.println(e.getMessage()); }

		System.out.println("Opdatering af initialer for operatoer nummer 4");
		oprDTO.setIni("DoJu");
		try { opr.updateOperatoer(oprDTO); }
		catch (DALException e) { System.out.println(e.getMessage()); }

		System.out.println("Operatoer nummer 4:");
		try { System.out.println(opr.getOperatoer(4)); }
		catch (DALException e) { System.out.println(e.getMessage()); }

		System.out.println("Alle operatoerer:");
		try { System.out.println(opr.getOperatoerList()); }
		catch (DALException e) { System.out.println(e.getMessage()); }

		System.out.println("Operatoer nummer 5:");
		try { System.out.println(opr.getOperatoer(5)); }
		catch (DALException e) { System.out.println(e.getMessage()); }		

		System.out.println("Raavare nummer 3:");
		RaavareDAO raavare = new MySQLRaavareDAO();
		try { System.out.println(raavare.getRaavare(3)); }
		catch (DALException e) { System.out.println(e.getMessage()); }
		
		System.out.println("Raavare nummer 6:");
		try { System.out.println(raavare.getRaavare(6)); }
		catch (DALException e) { System.out.println(e.getMessage()); }
		*/
	}

	
	
	public void startOperation (OperatoerDAO DAO, OperatoerDTO DTO)
	{	
		do 
		{
			try 
			{
			this.DAO = DAO;
			this.DTO = DTO;
		
             System.out.println("============================");
             System.out.println("|       MENU SELECTION     |");
             System.out.println("============================");
             System.out.println("| Options:                 |");
             System.out.println("|        1. Create User    |");
             System.out.println("|        2. Update User    |");
             System.out.println("|        3. Delete User    |");
             System.out.println("|        4. List Users     |");
             System.out.println("|        5. Exit           |");
             System.out.println("============================");
            
             input = scan.nextInt();
             	 
             switch (input) 
             {
                 case 1:
					 createUser();
                     break;
                 case 2:
                     updateUser();
                     break;
                 case 3:
                     deleteUser();
                     break;
                 case 4:
                     listUsers();
                     break;
                 case 5:
                     quitProgram();
                     break;
                 default:
                     System.out.println("Invalid entry");
                     break;
             }
        
			} catch (Exception e) 
			{
				e.getMessage();
	   		}
			
			scan.nextLine();
			
		} while (input != 5);			
	}
	
	public void createUser() 
	{

		int step = 1;
		boolean cont = true;

		System.out.println("============================");
		System.out.println("|        CREATE USER       |");
		System.out.println("============================\n");
		
		while (cont) 
		{

			try 
			{
				cont = createUserIteration(step);
				step++;
			} catch (Exception e) 
			{
				//step = e.getMessage();
				System.out.println(e.getMessage());
			}
		}

		try 
		{
			DAO.createOperatoer(DTO);
		} catch (DALException e) {
			System.out.println(e.getMessage());
		}
	}

     public void updateUser() throws Exception
     {
         try {

             display:
             while (true) {

                 System.out.println("============================");
                 System.out.println("|     UPDATE SELECTION     |");
                 System.out.println("============================");
                 System.out.println("| Updates:                 |");
                 System.out.println("|      1. User ID          |");
                 System.out.println("|      2. User name        |");
                 System.out.println("|      3. User Initials    |");
                 System.out.println("|      4. User Role        |");
                 System.out.println("|      5. User CPR         |");
                 System.out.println("|      6. User Password    |");
                 System.out.println("|      7. Return           |");
                 System.out.println("============================");

                 int chooseUpdate = scan.nextInt();
                 int ID;
                 boolean run = true;
                 String newRole = null;

                 switch (chooseUpdate) {
                 case 1:
                     System.out.println("============================");
                     System.out.println("|      UPDATE USER ID      |");
                     System.out.println("============================");
                     
                     System.out.println("Enter user ID: ");
                     ID = scan.nextInt();
                     
                     System.out.println("Enter new user ID: ");
                     int newID = scan.nextInt();
                     
                     this.DTO = DAO.getOperatoer(ID);
                     this.DTO.setOprId(newID);
                     
                     DAO.updateOperatoer(this.DTO);
             
                     break;
                 case 2:
                     System.out.println("============================");
                     System.out.println("|     UPDATE USER NAME     |");
                     System.out.println("============================");
                     
                     System.out.println("Enter user ID: ");
                     ID = scan.nextInt();
                     
                     System.out.println("Enter new user name: ");
                     String newName = scan.next();
                     
                     this.DTO = DAO.getOperatoer(ID);
                     this.DTO.setOprNavn(newName);
                     
                     DAO.updateOperatoer(this.DTO);
                     
                     break;
                 case 3:
                     System.out.println("============================");
                     System.out.println("|   UPDATE USER INITIALS   |");
                     System.out.println("============================");
                     
                     System.out.println("Enter user ID: ");
                     ID = scan.nextInt();
                     
                     System.out.println("Enter new user initials: ");
                     String newIni = scan.next();
                     
                     this.DTO = DAO.getOperatoer(ID);
                     this.DTO.setIni(newIni);
                     
                     DAO.updateOperatoer(this.DTO);
                  
                     break;
                 case 4:
                	 System.out.println("============================");
                     System.out.println("|        UPDATE ROLE       |");
                     System.out.println("============================");
                     
                     System.out.println("Enter user ID: ");
                     ID = scan.nextInt();
                     scan.nextLine();
                     
                     while(run)
                     {
                    	 System.out.println("Enter new role: ");
                         newRole = scan.nextLine();
                         
                         if(newRole.equals("Admin") || newRole.equals("Operator") || newRole.equals("Foreman") || newRole.equals("Pharmacist"))
                           {
                        	 run = false;
                           }
                           else
                           {
                        	 System.out.println("Unknown role, please try again!");
                           }
                     }
                     
                     this.DTO = DAO.getOperatoer(ID);
                     this.DTO.addRole(newRole);
                     DAO.updateOperatoer(this.DTO);
                     break;
                	 
                 case 5:
                     System.out.println("============================");
                     System.out.println("|      UPDATE USER CPR     |");
                     System.out.println("============================");
                     
                     System.out.println("Enter User ID: ");
                     ID = scan.nextInt();
                     
                     System.out.println("Enter new user CPR: ");
                     String newCPR = scan.next();
                     
                     this.DTO = DAO.getOperatoer(ID);
                     this.DTO.setCpr(newCPR);
                     
                     DAO.updateOperatoer(this.DTO);
                     
                     break;
                     
                 case 6:
                	 System.out.println("============================");
                     System.out.println("|    UPDATE USER PASSWORD   |");
                     System.out.println("============================");
                     
                     System.out.println("Enter User ID: ");
                     ID = scan.nextInt();
                     
                     this.DTO = DAO.getOperatoer(ID);
                     DAO.updateOperatoer(this.DTO);
                     break;
                     
                 case 7:
                     System.out.println("Returning...");
                     break display;
             }
         }
     } catch (InputMismatchException e)
     {		String errorMessage = "Input mismatch. Please try again.";
         throw new Exception(errorMessage, e);
     } catch (DALException e) {
    	 System.out.println(e.getMessage());
     }
 }

	public void listUsers() {
		try {
			System.out.println("============================");
			System.out.println("|       LIST USERS         |");
			System.out.println("============================");

			for (int i = 0; i < DAO.getOperatoerList().size(); i++)
				System.out.println("User ID: " + DAO.getOperatoerList().get(i).getOprId() + "\t User name: "
						+ DAO.getOperatoerList().get(i).getOprNavn());

		} catch (DALException e) {
			System.out.println(e);
			//e.printStackTrace();
		}
	}
     
	public void listID() 
	{
		try 
		{
			System.out.print("Unavailable user IDs: {");
			for (int i = 0; i < DAO.getOperatoerList().size(); i++) 
			{
				System.out.print(DAO.getOperatoerList().get(i).getOprId() + ", ");
			}
			System.out.print("...}");
			System.out.println();
		} catch (DALException e) 
		{
			System.out.println(e);
			e.printStackTrace();
		}
	}

	public void deleteUser() 
	{
		try 
		{

			System.out.println("============================");
			System.out.println("|       DELETE USER        |");
			System.out.println("============================");
			System.out.println("Enter user ID: ");
			int ID = scan.nextInt();
			DAO.deleteUser(ID); /*Skal lave en deaktivate Operator her*/
			System.out.println("User has been deleted");

		} catch (DALException e) {
			System.out.println(e.getMessage());
		}
	}
     
	public boolean createUserIteration(int step) throws Exception 
	{

		boolean cont = true;
		String errorMessage = null; //Skal lige finde ud af hvor denne skal bruges//
		display:

		try {
			switch (step) 
			{

			case 1:
				errorMessage = "Input mismatch. Please try again.\n";
				listID();
				
				System.out.println("Type userID: ");
				
				int ID = scan.nextInt();
				
				DTO.setOprId(ID);
				break;

			case 2:
				System.out.println("Type user name: ");
				String name = scan.nextLine();
				
				DTO.setOprNavn(name);
				break;

			case 3:
				System.out.println("Type initials: ");
				String ini = scan.next();

				DTO.setIni(ini);
				break;

			case 4:
				System.out.println("Type user CPR: ");
				scan.nextLine();
				
				String CPR = scan.nextLine();
				DTO.setCpr(CPR);
				break;

			case 5:
				System.out.println("============================");
				System.out.println("|       ROLE SELECTION     |");
				System.out.println("============================");
				System.out.println("| Roles:                   |");
				System.out.println("|      1. Admin		       |");
				System.out.println("|      2. Operator         |");
				System.out.println("|      3. Foreman	       |");
				System.out.println("|      4. Pharmacist       |");
				System.out.println("|      5. Return           |");
				System.out.println("============================");

				int chooseRole = scan.nextInt();
				switch (chooseRole) {
				case 1:
					// set Operator
					DTO.addRole("Admin");
					break;
				case 2:
					DTO.addRole("Operator"); // set Foreman
					break;
				case 3:
					DTO.addRole("Foreman");
					break;
				case 4:
					DTO.addRole("Pharmacist");
					break;
				case 5:
					System.out.println("Returning...");
					break display;
				default:
					System.out.println("Invalid entry");
					break;
				}
				break;

			case 6:
				cont = false;
				break;

			}
		} catch (InputMismatchException e) {
			scan.nextLine();

		} 
		return cont;
	}

     public void quitProgram(){}
 
	
	
	
	
	
	
	
	
}
