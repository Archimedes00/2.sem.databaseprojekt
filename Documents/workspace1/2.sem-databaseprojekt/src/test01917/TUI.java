package test01917;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import connector01917.Connector;
import daoimpl01917.MySQLUserDAO;
import daoimpl01917.MySQLProduktBatchDAO;
import daoimpl01917.MySQLProduktBatchKompDAO;
import daoimpl01917.MySQLRaavareBatchDAO;
import daoimpl01917.MySQLRaavareDAO;
import daoimpl01917.MySQLReceptDAO;
import daoimpl01917.MySQLReceptKompDAO;
import daointerfaces01917.DALException;
import daointerfaces01917.ProduktBatchDAO;
import daointerfaces01917.ProduktBatchKompDAO;
import daointerfaces01917.RaavareBatchDAO;
import daointerfaces01917.RaavareDAO;
import daointerfaces01917.ReceptDAO;
import daointerfaces01917.ReceptKompDAO;
import daointerfaces01917.UserDAO;
import dto01917.ProduktBatchDTO;
import dto01917.ProduktBatchKompDTO;
import dto01917.RaavareBatchDTO;
import dto01917.RaavareDTO;
import dto01917.ReceptDTO;
import dto01917.ReceptKompDTO;
import dto01917.UserDTO;

public class TUI implements ITUI
{
	private UserDAO DAO;
	private UserDTO DTO;
	private ProduktBatchDAO PBatchDAO;
	private ProduktBatchDTO PBatchDTO;
	private ProduktBatchKompDAO PBatchKompDAO;
	private ProduktBatchKompDTO PBatchKompDTO;
	private ReceptDAO ReceptDAO;
	private ReceptDTO ReceptDTO;
	private ReceptKompDAO ReceptKompDAO;
	private ReceptKompDTO ReceptKompDTO;
	private RaavareBatchDAO RaavareBatchDAO;
	private RaavareBatchDTO RaavareBatchDTO;
	private RaavareDAO RaavareDAO;
	private RaavareDTO RaavareDTO;
	private Connector C = new Connector();
	
	
	int input;
	Scanner scan = new Scanner(System.in);
	
	public void Connector()
	{
		System.out.println("Please type in the name or ip address of the host");
		String hostname = scan.nextLine();
		
		System.out.println("Please type in the port number of the host");
		int Portnumber = scan.nextInt();
		
		System.out.println("Please type in the name of the database");
		String databasename = scan.nextLine();
		
		System.out.println("Please type in the username and Password");
		String username = scan.nextLine();
		String Password = scan.nextLine();

		/* havde forstillet mig at g�re det muligt at v�lge hvad for en host, database, portnummer osv osv */

		
	}
	public void Selector()
	{
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
            		UserDAO DAO = new MySQLUserDAO();
            		UserDTO DTO = new UserDTO(0, null, null, null, null, 1); //Initialising the object//
            		Usermenu(DAO, DTO);
            		break;
                }
            case 2:	
            	{
            		ProduktBatchDAO PBatchDAO = new MySQLProduktBatchDAO();
            		ProduktBatchDTO PBatchDTO = new ProduktBatchDTO(0, 0, 0);
            		ProduktBatchmenu(PBatchDAO, PBatchDTO);
                	break;
                }
            case 3:
            	{
            		ProduktBatchKompDAO PBatchKompDAO = new MySQLProduktBatchKompDAO();
            		ProduktBatchKompDTO PBatchKompDTO = new ProduktBatchKompDTO(0, 0, 0, 0, 0);
            		ProduktBatchKompmenu(PBatchKompDAO, PBatchKompDTO);
            		break;
            	}
                
            case 4:
            	{	
            		ReceptDAO ReceptDAO = new MySQLReceptDAO();
            		ReceptDTO ReceptDTO = new ReceptDTO(0, null);
            		Receptmenu(ReceptDAO, ReceptDTO);
            		break;
            	}
            case 5:
        		{
        			ReceptKompDAO ReceptKompDAO = new MySQLReceptKompDAO();
        			ReceptKompDTO ReceptKompDTO = new ReceptKompDTO(0, 0, 0, 0);
        			ReceptKompmenu(ReceptKompDAO, ReceptKompDTO);
        			break;
        		}
            case 6:
    			{
    				RaavareBatchDAO RaavareBatchDAO = new MySQLRaavareBatchDAO();
    				RaavareBatchDTO RaavareBatchDTO = new RaavareBatchDTO(0, 0, 0);
    				RaavareBatchmenu(RaavareBatchDAO, RaavareBatchDTO);
    				break;
    			}
            case 7:
				{
					RaavareDAO RaavareDAO = new MySQLRaavareDAO();
					RaavareDTO RaavareDTO = new RaavareDTO(0, null, null);
					Raavaremenu(RaavareDAO, RaavareDTO);
					break;
				}
            default:
                System.out.println("Invalid entry");
                break;
        }
        
        scan.close();
      
	}

	
	
	public void Usermenu(UserDAO DAO, UserDTO DTO)
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
			DAO.createUser(DTO);
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
                     
                     this.DTO = DAO.getUser(ID);
                     this.DTO.setOprId(newID);
                     
                     DAO.updateUser(this.DTO);
             
                     break;
                 case 2:
                     System.out.println("============================");
                     System.out.println("|     UPDATE USER NAME     |");
                     System.out.println("============================");
                     
                     System.out.println("Enter user ID: ");
                     ID = scan.nextInt();
                     
                     System.out.println("Enter new user name: ");
                     String newName = scan.next();
                     
                     this.DTO = DAO.getUser(ID);
                     this.DTO.setOprNavn(newName);
                     
                     DAO.updateUser(this.DTO);
                     
                     break;
                 case 3:
                     System.out.println("============================");
                     System.out.println("|   UPDATE USER INITIALS   |");
                     System.out.println("============================");
                     
                     System.out.println("Enter user ID: ");
                     ID = scan.nextInt();
                     
                     System.out.println("Enter new user initials: ");
                     String newIni = scan.next();
                     
                     this.DTO = DAO.getUser(ID);
                     this.DTO.setIni(newIni);
                     
                     DAO.updateUser(this.DTO);
                  
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
                     
                     this.DTO = DAO.getUser(ID);
                     this.DTO.addRole(newRole);
                     DAO.updateUser(this.DTO);
                     break;
                	 
                 case 5:
                     System.out.println("============================");
                     System.out.println("|      UPDATE USER CPR     |");
                     System.out.println("============================");
                     
                     System.out.println("Enter User ID: ");
                     ID = scan.nextInt();
                     
                     System.out.println("Enter new user CPR: ");
                     String newCPR = scan.next();
                     
                     this.DTO = DAO.getUser(ID);
                     this.DTO.setCpr(newCPR);
                     
                     DAO.updateUser(this.DTO);
                     
                     break;
                     
                 case 6:
                	 System.out.println("============================");
                     System.out.println("|    UPDATE USER PASSWORD   |");
                     System.out.println("============================");
                     
                     System.out.println("Enter User ID: ");
                     ID = scan.nextInt();
                     
                     this.DTO = DAO.getUser(ID);
                     DAO.updateUser(this.DTO);
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

			for (int i = 0; i < DAO.getUserList().size(); i++)
				System.out.println("User ID: " + DAO.getUserList().get(i).getOprId() + "\t User name: "
						+ DAO.getUserList().get(i).getOprNavn());

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
			for (int i = 0; i < DAO.getUserList().size(); i++) 
			{
				System.out.print(DAO.getUserList().get(i).getOprId() + ", ");
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
     
     public void ProduktBatchmenu(ProduktBatchDAO PBatchDAO, ProduktBatchDTO PBatchDTO)
     {
    	 int NumberInput;
    	 
    	 do 
 		{
 			try 
 			{
 			this.PBatchDAO = PBatchDAO;
 			this.PBatchDTO = PBatchDTO;
 			
 			
 			
              System.out.println("============================");
              System.out.println("|       MENU SELECTION     |");
              System.out.println("============================");
              System.out.println("| Options:                 |");
              System.out.println("| 1. Get ProduktBatch  	 |");
              System.out.println("| 2. Get ProduktBatchList  |");
              System.out.println("| 3. Create ProduktBatch   |");
              System.out.println("| 4. Update ProduktBatch   |");
              System.out.println("| 5. Exit         	 	 |");
              System.out.println("============================");
           
              input = scan.nextInt();
              
              	 
              switch (input) 
              {
                  case 1:
                	  
                	  System.out.println("Please type in the id of the product batch");
                	  NumberInput = scan.nextInt();
                	  System.out.println(PBatchDAO.getProduktBatch(NumberInput));
                	  
                      break;
                  case 2:
                	  
                	  for (int i = 0; i < PBatchDAO.getProduktBatchList().size(); i++)
                	  {
                		  System.out.print(PBatchDAO.getProduktBatchList().get(i).getPbId() + ", ");
          		      }
                	  
                      break;
                  case 3:
                	  
                	  System.out.println("Please type in the ID of the ProductBatch");
                	  NumberInput = scan.nextInt();
                	  this.PBatchDTO.setPbId(NumberInput);
                	  
                	  System.out.println("Please set the status of the ProductBatch");
                	  NumberInput = scan.nextInt();
                	  this.PBatchDTO.setStatus(NumberInput);
                	  
                	  System.out.println("Please type in the receptId of the ProductBatch");
                	  NumberInput = scan.nextInt();
                	  this.PBatchDTO.setReceptId(NumberInput);
                	  
                	  this.PBatchDAO.createProduktBatch(this.PBatchDTO);
                	  
                      break;
                  case 4:
                	  
                	  System.out.println("Please type in the ID of the ProductBatch you want to update");
                	  NumberInput = scan.nextInt();
                	  
                	  this.PBatchDTO.setPbId(NumberInput);
                	  
                	  System.out.println("Please update the status of the ProductBatch");
                	  NumberInput = scan.nextInt();
                	  this.PBatchDTO.setStatus(NumberInput);
                	  
                	  System.out.println("Please type in the new receptId of the ProductBatch");
                	  NumberInput = scan.nextInt();
                	  this.PBatchDTO.setReceptId(NumberInput);
                	  
                	  this.PBatchDAO.updateProduktBatch(this.PBatchDTO);
                	  
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
     public void ProduktBatchKompmenu(ProduktBatchKompDAO PBatchKompDAO, ProduktBatchKompDTO PBatchKompDTO)
     {
    	 int NumberInput, NumberInput2;
    	 float NumberInput3;
    	 do 
 		{
 			try 
 			{
 			this.PBatchKompDAO = PBatchKompDAO;
 			this.PBatchKompDTO = PBatchKompDTO;
 			
 			
 			
              System.out.println("=========================================");
              System.out.println("|       MENU SELECTION                  |");
              System.out.println("========================================|");
              System.out.println("| Options:                     		  |");
              System.out.println("| 1. Get specific ProduktBatchKomp      |");
              System.out.println("| 2. Get ProduktBatchKomp List 		  |");
              System.out.println("| 3. Get ProduktBatchKomp List          |");
              System.out.println("| 4. Create ProduktBatchKomp            |");
              System.out.println("| 5. Update ProduktBatchKomp         	  |");
              System.out.println("| 6. Exit					        	  |");
              System.out.println("=========================================");
           
              input = scan.nextInt();
              
              	 
              switch (input) 
              {
                  case 1:
                	  
                	  System.out.println("Please type in the id of the product batch komp and the id for the raavarebatch");
                	  NumberInput = scan.nextInt();
                	  NumberInput2 = scan.nextInt();
                	  System.out.println(PBatchKompDAO.getProduktBatchKomp(NumberInput, NumberInput2));
                	 
                      break;
                  case 2:
                	  
                	  System.out.println("Please type in the id of the product batch komp");
                	  NumberInput = scan.nextInt();
                	 
                	  for (int i = 0; i < PBatchKompDAO.getProduktBatchKompList(NumberInput).size(); i++)
                	  {
                		  System.out.print(PBatchKompDAO.getProduktBatchKompList(NumberInput).get(i) + ", ");
          		      }
                	  
                      break;
                  case 3:
                	 
                	  for (int i = 0; i < PBatchKompDAO.getProduktBatchKompList().size(); i++)
                	  {
                		  System.out.print(PBatchKompDAO.getProduktBatchKompList().get(i) + ", ");
          		      }
                	  
                      break;
                  case 4:
                	  
                	  System.out.println("Please type in the ID of the operator");
                	  NumberInput = scan.nextInt();
                	  this.PBatchKompDTO.setOprId(NumberInput);
                	  
                	  System.out.println("Please set net weight of the productBatchKomp");
                	  NumberInput = scan.nextInt();
                	  this.PBatchKompDTO.setNetto(NumberInput);
                	
                	  System.out.println("Please type in the id of the productbatch");
                	  NumberInput = scan.nextInt();
                	  this.PBatchKompDTO.setPbId(NumberInput);
                	  
                	  System.out.println("Please type in the id of the raavarebatch");
                	  NumberInput = scan.nextInt();
                	  this.PBatchKompDTO.setRbId(NumberInput);
                	  
                	  System.out.println("Please set tara weight of the productBatchKomp");
                	  NumberInput3 = scan.nextFloat();
                	  this.PBatchKompDTO.setTara(NumberInput3);
                	  
                	  this.PBatchKompDAO.createProduktBatchKomp(this.PBatchKompDTO);
                	 
                      break;
                  case 5:
                	  System.out.println("Please type in the ID of the productBatch and the ID of the commodityBatch you want to update");
                	  NumberInput = scan.nextInt();
                	  NumberInput2 = scan.nextInt();
           
                	  this.PBatchKompDTO.setPbId(NumberInput);
                	  this.PBatchKompDTO.setRbId(NumberInput2);
                	  
                	  System.out.println("Please set the new net weight of the productBatchKomp");
                	  NumberInput = scan.nextInt();
                	  this.PBatchKompDTO.setNetto(NumberInput);
                	  
                	  System.out.println("Please type in the new ID of the operator");
                	  NumberInput = scan.nextInt();
                	  this.PBatchKompDTO.setOprId(NumberInput);
                	  
                	  System.out.println("Please set the new tara weight of the productBatchKomp");
                	  NumberInput3 = scan.nextFloat();
                	  this.PBatchKompDTO.setTara(NumberInput3);
                	  
                	  this.PBatchKompDAO.updateProduktBatchKomp(this.PBatchKompDTO);
                	  
                      break;
                      
                  case 6:
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
 			
 		} while (input != 6);			
    	 
     }
     public void Receptmenu(ReceptDAO ReceptDAO, ReceptDTO ReceptDTO)
     {
    	 int NumberInput;
    	 String StringInput;
    	 
    	 do 
 		{
 			try 
 			{
 			this.ReceptDAO = ReceptDAO;
 			this.ReceptDTO = ReceptDTO;
 			
 			
 			
              System.out.println("============================");
              System.out.println("|       MENU SELECTION     |");
              System.out.println("============================");
              System.out.println("| Options:                 |");
              System.out.println("| 1. Get recept		  	 |");
              System.out.println("| 2. Get receptList,       |");
              System.out.println("| 3. Create recept  		 |");
              System.out.println("| 4. Update recept		 |");
              System.out.println("| 5. Exit         	 	 |");
              System.out.println("============================");
           
              input = scan.nextInt();
              
              	 
              switch (input) 
              {
                  case 1:
                	  
                	  System.out.println("Please type in the id of the recept");
                	  NumberInput = scan.nextInt();
                	  System.out.println(ReceptDAO.getRecept(NumberInput));
                	  
                      break;
                  case 2:
                	  
                	  for (int i = 0; i < ReceptDAO.getReceptList().size(); i++)
                	  {
                		  System.out.print(ReceptDAO.getReceptList().get(i).getReceptId() + ", ");
          		      }
                	  
                      break;
                  case 3:
                	  
                	  System.out.println("Please type in the ID of the recept");
                	  NumberInput = scan.nextInt();
                	  this.ReceptDTO.setReceptId(NumberInput);
                	  
                	  System.out.println("Please type in the name of the recept");
                	  StringInput = scan.nextLine();
                	  this.ReceptDTO.setReceptNavn(StringInput);
                	  
                	  this.ReceptDAO.createRecept(this.ReceptDTO);
                	  
                      break;
                  case 4:
                	  
                	  System.out.println("Please type in the ID of the recept you want to update");
                	  NumberInput = scan.nextInt();
                	 
                	  this.ReceptDTO.setReceptId(NumberInput);
                	  
                	  System.out.println("Please update the name of the recept");
                	  StringInput = scan.nextLine();

                	  this.ReceptDTO.setReceptNavn(StringInput);
                	  
                	  this.ReceptDAO.updateRecept(this.ReceptDTO);
                	  
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
     public void ReceptKompmenu(ReceptKompDAO ReceptKompDAO ,ReceptKompDTO ReceptKompDTO)
     {
    	 int NumberInput, NumberInput2;
    	 float NumberInput3;
    	 
    	 do 
 		{
 			try 
 			{
 			this.ReceptKompDAO = ReceptKompDAO;
 			this.ReceptKompDTO = ReceptKompDTO;
 			
 			
 			
              System.out.println("=========================================");
              System.out.println("|       MENU SELECTION                  |");
              System.out.println("========================================|");
              System.out.println("| Options:                     		  |");
              System.out.println("| 1. Get specific receptKomp      	  |");
              System.out.println("| 2. Get ReceptKompList List 		      |");
              System.out.println("| 3. Get ReceptKompList List            |");
              System.out.println("| 4. Create receptKomp            	  |");
              System.out.println("| 5. Update receptKomp         	      |");
              System.out.println("| 6. Exit					        	  |");
              System.out.println("=========================================");
           
              input = scan.nextInt();
              
              	 
              switch (input) 
              {
                  case 1:
                	  
                	  System.out.println("Please type in the id of the recept and the id for the raavare");
                	  NumberInput = scan.nextInt();
                	  NumberInput2 = scan.nextInt();
                	  System.out.println(ReceptKompDAO.getReceptKomp(NumberInput, NumberInput2));
                	 
                      break;
                  case 2:
                	  
                	  System.out.println("Please type in the id of the recept");
                	  NumberInput = scan.nextInt();
                	 
                	  for (int i = 0; i < ReceptKompDAO.getReceptKompList(NumberInput).size(); i++)
                	  {
                		  System.out.print(ReceptKompDAO.getReceptKompList(NumberInput).get(i) + ", ");
          		      }
                	  
                      break;
                  case 3:
 
                	 
                	  for (int i = 0; i < ReceptKompDAO.getReceptKompList().size(); i++)
                	  {
                		  System.out.print(ReceptKompDAO.getReceptKompList().get(i) + ", ");
          		      }
                	  
                      break;
                  case 4:
                	  
                	  System.out.println("Please type in the ID of the recept");
                	  NumberInput = scan.nextInt();
                	  this.ReceptKompDTO.setReceptId(NumberInput);
                	  
                	  System.out.println("Please set the nominal weight of the ingredient");
                	  NumberInput = scan.nextInt();
                	  this.ReceptKompDTO.setNomNetto(NumberInput);
                	  
                	
                	  System.out.println("Please type in the id of the raavare");
                	  NumberInput = scan.nextInt();
                	  this.ReceptKompDTO.setRaavareId(NumberInput);
                	  
                	  System.out.println("Please set the weight tolerance of the ingredient");
                	  NumberInput3 = scan.nextFloat();
                	  this.ReceptKompDTO.setTolerance(NumberInput3);
                	  
                	  this.ReceptKompDAO.createReceptKomp(this.ReceptKompDTO);
                	 
                      break;
                  case 5:
                	  System.out.println("Please type in the ID of the raavare and the ID of the recept you want to update");
                	  NumberInput = scan.nextInt();
                	  NumberInput2 = scan.nextInt();
                	  
                	  this.ReceptKompDTO.setReceptId(NumberInput);
                	  this.ReceptKompDTO.setRaavareId(NumberInput2);
                	  
                	  System.out.println("Please set the new weight tolerance of the ingredient");
                	  NumberInput3 = scan.nextFloat();
                	  this.ReceptKompDTO.setTolerance(NumberInput3);
                	  this.PBatchKompDTO.setNetto(NumberInput);
                	  
                	  System.out.println("Please set the new nominal weight of the ingredient");
                	  NumberInput = scan.nextInt();
                	  this.ReceptKompDTO.setNomNetto(NumberInput);
                
                	  this.ReceptKompDAO.updateReceptKomp(this.ReceptKompDTO);
                	  
                      break;
                      
                  case 6:
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
 			
 		} while (input != 6);
     }
     public void RaavareBatchmenu(RaavareBatchDAO RaavareBatchDAO, RaavareBatchDTO RaavareBatchDTO)
     {
    	 int NumberInput;
    	 float NumberInput2;
    	 
    	 do 
 		{
 			try 
 			{
 			this.RaavareBatchDAO = RaavareBatchDAO;
 			this.RaavareBatchDTO = RaavareBatchDTO;
 			
 			
 			
              System.out.println("============================");
              System.out.println("|       MENU SELECTION     |");
              System.out.println("============================");
              System.out.println("| Options:                 |");
              System.out.println("| 1. Get RaavareBatch  	 |");
              System.out.println("| 2. Get RaavareBatchList  |");
              System.out.println("| 3. Create RaavareBatch   |");
              System.out.println("| 4. Update RaavareBatch   |");
              System.out.println("| 5. Exit         	 	 |");
              System.out.println("============================");
           
              input = scan.nextInt();
              
              	 
              switch (input) 
              {
                  case 1:
                	  
                	  System.out.println("Please type in the id of the Raavare batch");
                	  NumberInput = scan.nextInt();
                	  System.out.println(RaavareBatchDAO.getRaavareBatch(NumberInput));
                	
                	  
                      break;
                  case 2:
                	  
                	  for (int i = 0; i < RaavareBatchDAO.getRaavareBatchList().size(); i++)
                	  {
                		  System.out.print(RaavareBatchDAO.getRaavareBatchList().get(i).getRaavareId() + ", ");
          		      }
                	  
                      break;
                  case 3:
                	  
                	  System.out.println("Please type in the ID of the RaavareBatch");
                	  NumberInput = scan.nextInt();
                	  this.RaavareBatchDTO.setRaavareId(NumberInput);
                	  
                	  System.out.println("Please type in the ID of the raavareBatch");
                	  NumberInput = scan.nextInt();
                	  this.RaavareBatchDTO.setRbId(NumberInput);
                	  
                	  System.out.println("Please type in the amount of the raavareBatch");
                	  NumberInput2 = scan.nextFloat();
                	  this.RaavareBatchDTO.setMaengde(NumberInput2);
                	  
                	  this.RaavareBatchDAO.createRaavareBatch(this.RaavareBatchDTO);
                	
                      break;
                  case 4:
                	  
                	  System.out.println("Please type in the ID of the raavareBatch you want to update");
                	  NumberInput = scan.nextInt();
                	  
                	  this.RaavareBatchDTO.setRbId(NumberInput);
                	  
                	  System.out.println("Please type in the new raavare ID of the ProductBatch");
                	  NumberInput = scan.nextInt();
                	  this.RaavareBatchDTO.setRaavareId(NumberInput);
                	  
                	  System.out.println("Please type in the new amount of the raavareBatch");
                	  NumberInput2 = scan.nextFloat();
                	  this.RaavareBatchDTO.setMaengde(NumberInput2);
                	  
                	  this.RaavareBatchDAO.updateRaavareBatch(this.RaavareBatchDTO);
                	  
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
     public void Raavaremenu(RaavareDAO RaavareDAO, RaavareDTO RaavareDTO)
     {
    	 int NumberInput;
    	 String StringInput;
    	 
    	 do 
 		{
 			try 
 			{
 			this.RaavareDAO = RaavareDAO;
 			this.RaavareDTO = RaavareDTO;
 			
 			
 			
              System.out.println("============================");
              System.out.println("|       MENU SELECTION     |");
              System.out.println("============================");
              System.out.println("| Options:                 |");
              System.out.println("| 1. Get raavare		  	 |");
              System.out.println("| 2. Get raavareList,      |");
              System.out.println("| 3. Create raavare  		 |");
              System.out.println("| 4. Update raavare		 |");
              System.out.println("| 5. Exit         	 	 |");
              System.out.println("============================");
           
              input = scan.nextInt();
              
              	 
              switch (input) 
              {
                  case 1:
                	  
                	  System.out.println("Please type in the id of the raaver");
                	  NumberInput = scan.nextInt();
                	  System.out.println(RaavareDAO.getRaavare(NumberInput));
                	  
                      break;
                  case 2:
                	  
                	  for (int i = 0; i < RaavareDAO.getRaavareList().size(); i++)
                	  {
                		  System.out.print(RaavareDAO.getRaavareList().get(i).getRaavareId() + ", ");
          		      }
                	  
                      break;
                  case 3:
                	  
                	  System.out.println("Please type in the ID of the raavare");
                	  NumberInput = scan.nextInt();
                	  this.RaavareDTO.setRaavareId(NumberInput);
                	  
                	  System.out.println("Please type in the name of the raavare");
                	  StringInput = scan.nextLine();
                	  this.RaavareDTO.setRaavareNavn(StringInput);
                	  
                	  System.out.println("Please type in the name of the supplier");
                	  StringInput = scan.nextLine();
                	  this.RaavareDTO.setLeverandoer(StringInput);
                	  
                	  
                	  this.RaavareDAO.createRaavare(this.RaavareDTO);
                	  
                      break;
                  case 4:
                	  
                	  System.out.println("Please type in the ID of the raavare you want to update");
                	  NumberInput = scan.nextInt();
                	  
                	  this.RaavareDTO.setRaavareId(NumberInput);
                	  
                	  System.out.println("Please update the name of the raavare");
                	  StringInput = scan.nextLine();
                	  
                	  this.RaavareDTO.setRaavareNavn(StringInput);
                	  
                	  System.out.println("Please update the name of the supplier");
                	  StringInput = scan.nextLine();
                	  
                	  this.RaavareDTO.setLeverandoer(StringInput);
                	  
                	  this.RaavareDAO.updateRaavare(this.RaavareDTO);
                	  
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
}

    	 




