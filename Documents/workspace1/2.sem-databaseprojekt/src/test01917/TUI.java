package test01917;
import java.util.InputMismatchException;
import java.util.Scanner;
import connector01917.Connector;
import daoimpl01917.MySQLOperatoerDAO;
import daoimpl01917.MySQLProduktBatchDAO;
import daoimpl01917.MySQLProduktBatchKompDAO;
import daoimpl01917.MySQLRaavareBatchDAO;
import daoimpl01917.MySQLRaavareDAO;
import daoimpl01917.MySQLReceptDAO;
import daoimpl01917.MySQLReceptKompDAO;
import daoimpl01917.MySQLRolleDAO;
import daointerfaces01917.DALException;
import daointerfaces01917.ProduktBatchDAO;
import daointerfaces01917.ProduktBatchKompDAO;
import daointerfaces01917.RaavareBatchDAO;
import daointerfaces01917.RaavareDAO;
import daointerfaces01917.ReceptDAO;
import daointerfaces01917.ReceptKompDAO;
import daointerfaces01917.OperatoerDAO;
import dto01917.ProduktBatchDTO;
import dto01917.ProduktBatchKompDTO;
import dto01917.RaavareBatchDTO;
import dto01917.RaavareDTO;
import dto01917.ReceptDTO;
import dto01917.ReceptKompDTO;
import dto01917.OperatoerDTO;

/** @author Stuart McLean */

public class TUI implements ITUI
{
	private OperatoerDAO DAO;
	private OperatoerDTO DTO;
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
	private Connector C;
	
	int input, connStatus=0;
	Scanner scan = new Scanner(System.in);
	Scanner scan2 = new Scanner(System.in);


	public void ConEstablishment()
	{
		String Hostname, Databasename, Operatoername, Password;
		int Portnumber;

		System.out.println("Please type in the name or ip address of the host");
		Hostname = scan.nextLine();

		System.out.println("Please type in the port number");
		Portnumber = scan.nextInt();
		scan.nextLine();

		System.out.println("Please type in the name of the database");
		Databasename = scan.nextLine();

		System.out.println("Please type in the Operatoername and Password");
		System.out.print("Operatoername: ");
		Operatoername = scan.nextLine();
		System.out.print("Password: ");
		Password = scan.nextLine();

		this.C = new Connector(Hostname, Portnumber, Databasename, Operatoername, Password);

	}
	public void Selector()
	{
		if(this.connStatus == 0)
		{
			this.connStatus = 1;
			ConEstablishment();
		}

		System.out.println("Please choose which Schema to operate in");


		System.out.println("============================");
		System.out.println("|       MENU SELECTION      |");
		System.out.println("=============================");
		System.out.println("| Options:                  |");
		System.out.println("|      1. Operatoer         |");
		System.out.println("|      2. ProduktBatch      |");
		System.out.println("|      3. ProduktBatchKomp  |");
		System.out.println("|      4. Recept            |");
		System.out.println("|      5. ReceptKomp        |");
		System.out.println("|      6. RaavareBatch      |");
		System.out.println("|      7. Raavare           |");
		System.out.println("|                           |");
		System.out.println("=============================");


		int chooseRole = scan.nextInt();

		switch (chooseRole) 
		{
		case 1:	
		{
			OperatoerDAO DAO = new MySQLOperatoerDAO(this.C);
			OperatoerDTO DTO = new OperatoerDTO(0, null, null, null, null, 1); //Initialising the object//
			Operatoermenu(DAO, DTO);
			break;
		}
		case 2:	
		{
			ProduktBatchDAO PBatchDAO = new MySQLProduktBatchDAO(this.C);
			ProduktBatchDTO PBatchDTO = new ProduktBatchDTO(0, 0, 0);
			ProduktBatchmenu(PBatchDAO, PBatchDTO);
			break;
		}
		case 3:
		{
			ProduktBatchKompDAO PBatchKompDAO = new MySQLProduktBatchKompDAO(this.C);
			ProduktBatchKompDTO PBatchKompDTO = new ProduktBatchKompDTO(0, 0, 0, 0, 0);
			ProduktBatchKompmenu(PBatchKompDAO, PBatchKompDTO);
			break;
		}

		case 4:
		{	
			ReceptDAO ReceptDAO = new MySQLReceptDAO(this.C);
			ReceptDTO ReceptDTO = new ReceptDTO(0, null);
			Receptmenu(ReceptDAO, ReceptDTO);
			break;
		}
		case 5:
		{
			ReceptKompDAO ReceptKompDAO = new MySQLReceptKompDAO(this.C);
			ReceptKompDTO ReceptKompDTO = new ReceptKompDTO(0, 0, 0, 0);
			ReceptKompmenu(ReceptKompDAO, ReceptKompDTO);
			break;
		}
		case 6:
		{
			RaavareBatchDAO RaavareBatchDAO = new MySQLRaavareBatchDAO(this.C);
			RaavareBatchDTO RaavareBatchDTO = new RaavareBatchDTO(0, 0, 0);
			RaavareBatchmenu(RaavareBatchDAO, RaavareBatchDTO);
			break;
		}
		case 7:
		{
			RaavareDAO RaavareDAO = new MySQLRaavareDAO(this.C);
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

	public void Operatoermenu(OperatoerDAO DAO, OperatoerDTO DTO)
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
				System.out.println("|   1. Create Operatoer    |");
				System.out.println("|   2. Update Operatoer    |");
				System.out.println("|   3. Delete Operatoer    |");
				System.out.println("|   4. List Operatoers     |");
				System.out.println("|   5. Exit                |");
				System.out.println("============================");

				input = scan.nextInt();

				switch (input) 
				{
				case 1:
					createOperatoer();
					break;
				case 2:
					updateOperatoer();
					break;
				case 3:
					deleteOperatoer();
					break;
				case 4:
					listOperatoers();
					break;
				case 5:
					Selector();
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

	public void createOperatoer() 
	{

		int step = 1;
		boolean cont = true;

		System.out.println("=================================");
		System.out.println("|        CREATE Operatoer       |");
		System.out.println("===============================\n");

		while (cont) 
		{
			try 
			{
				cont = createOperatoerIteration(step);
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
		} catch (DALException e) 
		{
			System.out.println(e.getMessage());
		}
	}

	public void updateOperatoer() throws Exception
	{
		try 
		{
			display:
				while (true)
				{

					System.out.println("=================================");
					System.out.println("|     UPDATE SELECTION          |");
					System.out.println("=================================");
					System.out.println("| Updates:                      |");
					System.out.println("|      1. Operatoer ID          |");
					System.out.println("|      2. Operatoer name        |");
					System.out.println("|      3. Operatoer Initials    |");
					System.out.println("|      4. Operatoer Role        |");
					System.out.println("|      5. Operatoer CPR         |");
					System.out.println("|      6. Operatoer Password    |");
					System.out.println("|      7. Return                |");
					System.out.println("=================================");

					int chooseUpdate = scan.nextInt();
					int ID;
					boolean run = true;
					String newRole = null;

					switch (chooseUpdate) 
					{
					case 1:
						System.out.println("================================");
						System.out.println("|      UPDATE Operatoer ID     |");
						System.out.println("================================");

						System.out.println("Enter Operatoer ID: ");
						ID = scan.nextInt();

						System.out.println("Enter new Operatoer ID: ");
						int newID = scan.nextInt();

						this.DTO = DAO.getOperatoer(ID);
						this.DTO.setOprId(newID);

						DAO.updateOperatoer(this.DTO);

						break;
					case 2:
						System.out.println("================================");
						System.out.println("|     UPDATE Operatoer NAME    |");
						System.out.println("================================");

						System.out.println("Enter Operatoer ID: ");
						ID = scan.nextInt();

						System.out.println("Enter new Operatoer name: ");
						String newName = scan.next();

						this.DTO = DAO.getOperatoer(ID);
						this.DTO.setOprNavn(newName);

						DAO.updateOperatoer(this.DTO);

						break;
					case 3:
						System.out.println("=================================");
						System.out.println("|   UPDATE Operatoer INITIALS   |");
						System.out.println("=================================");

						System.out.println("Enter Operatoer ID: ");
						ID = scan.nextInt();

						System.out.println("Enter new Operatoer initials: ");
						String newIni = scan.next();

						this.DTO = DAO.getOperatoer(ID);
						this.DTO.setIni(newIni);

						DAO.updateOperatoer(this.DTO);

						break;
					case 4:
						System.out.println("============================");
						System.out.println("|        UPDATE ROLE       |");
						System.out.println("============================");

						System.out.println("Enter Operatoer ID: ");
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
						this.DTO.setRolle(newRole);
						DAO.updateRolle(this.DTO);

						break;

					case 5:
						System.out.println("=================================");
						System.out.println("|      UPDATE Operatoer CPR     |");
						System.out.println("=================================");

						System.out.println("Enter Operatoer ID: ");
						ID = scan.nextInt();

						System.out.println("Enter new Operatoer CPR: ");
						String newCPR = scan.next();

						this.DTO = DAO.getOperatoer(ID);
						this.DTO.setCpr(newCPR);

						DAO.updateOperatoer(this.DTO);

						break;

					case 6:
						System.out.println("==================================");
						System.out.println("|    UPDATE Operatoer PASSWORD   |");
						System.out.println("==================================");

						System.out.println("Enter Operatoer ID: ");
						ID = scan.nextInt();

						this.DTO = DAO.getOperatoer(ID);
						
						System.out.println("Enter new password: ");
						String pass = scan2.nextLine();
						DTO.setPassword(pass);
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

	public void listOperatoers() 
	{
		try 
		{
			System.out.println("=================================");
			System.out.println("|       LIST Operatoers         |");
			System.out.println("=================================");

			for (int i = 0; i < DAO.getOperatoerList().size(); i++)
				System.out.println("Operatoer ID: " + DAO.getOperatoerList().get(i).getOprId() + "\t Operatoer name: "
						+ DAO.getOperatoerList().get(i).getOprNavn());

		} catch (DALException e) 
		{
			System.out.println(e);
			//e.printStackTrace();
		}
	}

	public void listID() 
	{
		try 
		{
			System.out.print("Unavailable Operatoer IDs: {");
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

	public void deleteOperatoer() 
	{
		try 
		{

			System.out.println("=================================");
			System.out.println("|       DELETE Operatoer        |");
			System.out.println("=================================");

			System.out.println("Enter Operatoer ID: ");

			int ID = scan.nextInt();

			DTO.setOprId(ID);
			DAO.deactivateOperatoer(this.DTO); /*Skal lave en deaktivate Operator her*/
			System.out.println("Operatoer has been deleted");

		} catch (DALException e) 
		{
			System.out.println(e.getMessage());
		}
	}

	public boolean createOperatoerIteration(int step) throws Exception 
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

					System.out.println("Type OperatoerID: ");

					int ID = scan.nextInt();

					DTO.setOprId(ID);
					break;

				case 2:
					System.out.println("Type Operatoer name: ");
					String name = scan2.nextLine();

					DTO.setOprNavn(name);
					break;

				case 3:
					System.out.println("Type initials: ");
					String ini = scan2.next();
					scan.nextLine();
					DTO.setIni(ini);
					break;

				case 4:
					System.out.println("Type Operatoer CPR: ");

					String CPR = scan.nextLine();
					DTO.setCpr(CPR);
					break;

				case 5:
					System.out.println("Type in password: ");

					String pass = scan.nextLine();
					DTO.setPassword(pass);
					break;
				case 6:
					System.out.println("============================");
					System.out.println("|       ROLE SELECTION     |");
					System.out.println("============================");
					System.out.println("| Roles:                   |");
					System.out.println("|      1. Admin            |");
					System.out.println("|      2. Operator         |");
					System.out.println("|      3. Foreman          |");
					System.out.println("|      4. Pharmacist       |");
					System.out.println("|      5. Return           |");
					System.out.println("============================");

					int chooseRole = scan.nextInt();
					switch (chooseRole) {
					case 1:
						// set Operator
						DTO.setRolle("Admin");
						break;
					case 2:
						DTO.setRolle("Operator"); // set Foreman
						break;
					case 3:
						DTO.setRolle("Foreman");
						break;
					case 4:
						DTO.setRolle("Pharmacist");
						break;
					case 5:
						System.out.println("Returning...");
						break display;
					default:
						System.out.println("Invalid entry");
						break;
					}
					break;

				case 7:
					cont = false;
					break;

				}
			} catch (InputMismatchException e) 
		{
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
				System.out.println("| 1. Get ProduktBatch      |");
				System.out.println("| 2. Get ProduktBatchList  |");
				System.out.println("| 3. Create ProduktBatch   |");
				System.out.println("| 4. Update ProduktBatch   |");
				System.out.println("| 5. GoBack                |");
				System.out.println("============================");

				input = scan.nextInt();

				switch (input) 
				{
				case 1:

					System.out.println("Please type in the id of the Product batch");
					NumberInput = scan.nextInt();
					System.out.println(" pb_id: " + PBatchDAO.getProduktBatch(NumberInput));

					break;
				case 2:

					for (int i = 0; i < PBatchDAO.getProduktBatchList().size(); i++)
					{
						System.out.println(" pb_id: " + PBatchDAO.getProduktBatchList().get(i).getPbId() + " status: " + PBatchDAO.getProduktBatchList().get(i).getStatus() + " recept_id: " + PBatchDAO.getProduktBatchList().get(i).getReceptId() );
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
					Selector();
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
				System.out.println("| Options:                              |");
				System.out.println("| 1. Get ProduktBatchKomp               |");
				System.out.println("| 2. Get ProduktBatchKompList           |");
				System.out.println("| 3. Get ProduktBatchKompList           |");
				System.out.println("| 4. Create ProduktBatchKomp            |");
				System.out.println("| 5. Update ProduktBatchKomp            |");
				System.out.println("| 6. GoBack                             |");
				System.out.println("=========================================");

				input = scan.nextInt();


				switch (input) 
				{
				case 1:

					System.out.println("Please type in the ID of the ProductBatchKomp and the ID for the RaavareBatch");

					System.out.print("ProductBatch ID:   ");
					NumberInput = scan.nextInt();
					scan.nextLine();

					System.out.print("RaavareBatch ID:   ");
					NumberInput2 = scan.nextInt();

					System.out.println(" pb_id: " + PBatchKompDAO.getProduktBatchKomp(NumberInput, NumberInput2));

					break;
				case 2:

					System.out.println("Please type in the ID of the ProductBatchKomp");
					NumberInput = scan.nextInt();

					for (int i = 0; i < PBatchKompDAO.getProduktBatchKompList(NumberInput).size(); i++)
					{
						System.out.println(" pb_id: " + PBatchKompDAO.getProduktBatchKompList(NumberInput).get(i).getPbId() + " rb_id: " + PBatchKompDAO.getProduktBatchKompList(NumberInput).get(i).getRbId() + " tara: " + PBatchKompDAO.getProduktBatchKompList(NumberInput).get(i).getTara() + " netto: " + PBatchKompDAO.getProduktBatchKompList(NumberInput).get(i).getNetto() + " opr_id: " + PBatchKompDAO.getProduktBatchKompList(NumberInput).get(i).getOprId() );
					}

					break;
				case 3:

					System.out.println("ProductBatchKomp full list below");

					for (int i = 0; i < PBatchKompDAO.getProduktBatchKompList().size(); i++)
					{
						System.out.println(" pb_id: " + PBatchKompDAO.getProduktBatchKompList().get(i).getPbId() + " rb_id: " + PBatchKompDAO.getProduktBatchKompList().get(i).getRbId() + " tara: " + PBatchKompDAO.getProduktBatchKompList().get(i).getTara() + " netto: " + PBatchKompDAO.getProduktBatchKompList().get(i).getNetto() + " opr_id: " + PBatchKompDAO.getProduktBatchKompList().get(i).getOprId() );
					}

					break;
				case 4:

					System.out.println("Please type in the ID of the Operator");
					NumberInput = scan.nextInt();

					this.PBatchKompDTO.setOprId(NumberInput);

					System.out.println("Please set netto weight of the ProductBatchKomp");
					NumberInput = scan.nextInt();
					this.PBatchKompDTO.setNetto(NumberInput);

					System.out.println("Please type in the ID of the ProductBatch");
					NumberInput = scan.nextInt();
					this.PBatchKompDTO.setPbId(NumberInput);

					System.out.println("Please type in the ID of the RaavareBatch");
					NumberInput = scan.nextInt();
					this.PBatchKompDTO.setRbId(NumberInput);

					System.out.println("Please set tara weight of the ProductBatchKomp");
					NumberInput3 = scan.nextFloat();
					this.PBatchKompDTO.setTara((NumberInput3/100));

					this.PBatchKompDAO.createProduktBatchKomp(this.PBatchKompDTO);

					break;
				case 5:
					System.out.println("Please type in the ID of the ProductBatch and the ID of the RaavareBatch you want to update");

					System.out.print("ProductBatch ID:   ");
					NumberInput = scan.nextInt();
					scan.nextLine();

					System.out.print("RaavareBatch ID:   ");
					NumberInput2 = scan.nextInt();


					this.PBatchKompDTO.setPbId(NumberInput);
					this.PBatchKompDTO.setRbId(NumberInput2);

					System.out.println("Please set the new netto weight of the ProductBatchKomp");
					NumberInput = scan.nextInt();
					this.PBatchKompDTO.setNetto(NumberInput);

					System.out.println("Please type in the new ID of the Operator");
					NumberInput = scan.nextInt();
					this.PBatchKompDTO.setOprId(NumberInput);

					System.out.println("Please set the new tara weight of the ProductBatchKomp");
					NumberInput3 = scan.nextFloat();
					this.PBatchKompDTO.setTara((NumberInput3/100));

					this.PBatchKompDAO.updateProduktBatchKomp(this.PBatchKompDTO);

					break;

				case 6:
					Selector();
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
				System.out.println("| 1. Get Recept            |");
				System.out.println("| 2. Get ReceptList        |");
				System.out.println("| 3. Create Recept         |");
				System.out.println("| 4. Update Recept         |");
				System.out.println("| 5. GoBack                |");
				System.out.println("============================");

				input = scan.nextInt();

				switch (input) 
				{
				case 1:

					System.out.println("Please type in the id of the Recept");
					NumberInput = scan.nextInt();
					System.out.println(" recept_id: " + ReceptDAO.getRecept(NumberInput));

					break;
				case 2:

					System.out.println("ReceptList full list below");
					for (int i = 0; i < ReceptDAO.getReceptList().size(); i++)
					{
						System.out.println(" recept_id: " + ReceptDAO.getReceptList().get(i).getReceptId() +  " recept_navn: " + ReceptDAO.getReceptList().get(i).getReceptNavn());
					}

					break;
				case 3:

					System.out.println("Please type in the ID of the Recept");
					NumberInput = scan.nextInt();
					StringInput = scan.nextLine();
					this.ReceptDTO.setReceptId(NumberInput);

					System.out.println("Please type in the name of the Recept");
					StringInput = scan2.nextLine();
					this.ReceptDTO.setReceptNavn(StringInput);

					this.ReceptDAO.createRecept(this.ReceptDTO);

					break;
				case 4:

					System.out.println("Please type in the ID of the Recept you want to update");
					NumberInput = scan.nextInt();

					this.ReceptDTO.setReceptId(NumberInput);

					System.out.println("Please update the name of the Recept");
					StringInput = scan2.nextLine();

					this.ReceptDTO.setReceptNavn(StringInput);

					this.ReceptDAO.updateRecept(this.ReceptDTO);

					break;
				case 5:
					Selector();
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
				System.out.println("| Options:                              |");
				System.out.println("| 1. Get specific ReceptKomp            |");
				System.out.println("| 2. Get ReceptKompList List            |");
				System.out.println("| 3. Get ReceptKompList List            |");
				System.out.println("| 4. Create ReceptKomp                  |");
				System.out.println("| 5. Update ReceptKomp                  |");
				System.out.println("| 6. GoBack                             |");
				System.out.println("=========================================");

				input = scan.nextInt();


				switch (input) 
				{
				case 1:

					System.out.println("Please type in the ID of the Recept and the ID for the Raavare");
					NumberInput = scan.nextInt();
					NumberInput2 = scan.nextInt();
					System.out.println(" recept_id: " + ReceptKompDAO.getReceptKomp(NumberInput, NumberInput2));

					break;
				case 2:

					System.out.println("Please type in the ID of the Recept");
					NumberInput = scan.nextInt();

					for (int i = 0; i < ReceptKompDAO.getReceptKompList(NumberInput).size(); i++)
					{
						System.out.println(" recept_id: " + ReceptKompDAO.getReceptKompList(NumberInput).get(i).getReceptId() +  " raavare_id: " + ReceptKompDAO.getReceptKompList(NumberInput).get(i).getRaavareId() + " nom_netto: " + ReceptKompDAO.getReceptKompList(NumberInput).get(i).getNomNetto() +  " tolerance: " + ReceptKompDAO.getReceptKompList(NumberInput).get(i).getTolerance() );
					}

					break;
				case 3:

					System.out.println("ReceptKomp full list below");
					for (int i = 0; i < ReceptKompDAO.getReceptKompList().size(); i++)
					{
						System.out.println(" recept_id: " + ReceptKompDAO.getReceptKompList().get(i).getReceptId() +  " raavare_id: " + ReceptKompDAO.getReceptKompList().get(i).getRaavareId() + " nom_netto: " + ReceptKompDAO.getReceptKompList().get(i).getNomNetto() +  " tolerance: " + ReceptKompDAO.getReceptKompList().get(i).getTolerance() );
					}

					break;
				case 4:

					System.out.println("Please type in the ID of the Recept");
					NumberInput = scan.nextInt();
					this.ReceptKompDTO.setReceptId(NumberInput);

					System.out.println("Please set the nominal weight of the ingredient");
					NumberInput = scan.nextInt();
					this.ReceptKompDTO.setNomNetto(NumberInput);

					System.out.println("Please type in the ID of the raavare");
					NumberInput = scan.nextInt();
					this.ReceptKompDTO.setRaavareId(NumberInput);

					System.out.println("Please set the weight tolerance of the ingredient");
					NumberInput3 = scan.nextFloat();
					this.ReceptKompDTO.setTolerance((NumberInput3/100));

					this.ReceptKompDAO.createReceptKomp(this.ReceptKompDTO);

					break;
				case 5:
					System.out.println("Please type in the ID of the Recept and the ID of the Raavare you want to update");
					NumberInput = scan.nextInt();
					NumberInput2 = scan.nextInt();

					this.ReceptKompDTO.setReceptId(NumberInput);
					this.ReceptKompDTO.setRaavareId(NumberInput2);

					System.out.println("Please set the new nominal weight of the ingredient");
					NumberInput = scan.nextInt();
					this.ReceptKompDTO.setNomNetto(NumberInput);

					System.out.println("Please set the new weight tolerance of the ingredient");
					NumberInput3 = scan.nextFloat();
					this.ReceptKompDTO.setTolerance((NumberInput3/100));

					this.ReceptKompDAO.updateReceptKomp(this.ReceptKompDTO);

					break;

				case 6:
					Selector();
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
				System.out.println("| 1. Get RaavareBatch      |");
				System.out.println("| 2. Get RaavareBatchList  |");
				System.out.println("| 3. Get RaavareBatchList  |");
				System.out.println("| 4  Create RaavareBatch   |");
				System.out.println("| 5. Update RaavareBatch   |");
				System.out.println("| 6. GoBack                |");
				System.out.println("============================");

				input = scan.nextInt();


				switch (input) 
				{
				case 1:

					System.out.println("Please type in the ID of the RaavareBatch");
					NumberInput = scan.nextInt();
					System.out.println(" rb_id: " + RaavareBatchDAO.getRaavareBatch(NumberInput));

					break;
				case 2:

					System.out.println("Please type in the ID of the Raavare");

					NumberInput = scan.nextInt();

					for (int i = 0; i < RaavareBatchDAO.getRaavareBatchList().size(); i++)
					{
						System.out.println(" rb_id: " + RaavareBatchDAO.getRaavareBatchList(NumberInput).get(i).getRbId() +  " raavare_id: " + RaavareBatchDAO.getRaavareBatchList(NumberInput).get(i).getRaavareId() +  " maengde: " + RaavareBatchDAO.getRaavareBatchList(NumberInput).get(i).getMaengde());

					}

					break;
				case 3:

					System.out.println("RaavareBatch full list below");
					for (int i = 0; i < RaavareBatchDAO.getRaavareBatchList().size(); i++)
					{
						System.out.println(" rb_id: " + RaavareBatchDAO.getRaavareBatchList().get(i).getRbId() +  " raavare_id: " + RaavareBatchDAO.getRaavareBatchList().get(i).getRbId() +  " maengde: " + RaavareBatchDAO.getRaavareBatchList().get(i).getMaengde());
					}

					break;
				case 4:

					System.out.println("Please type in the ID of the RaavareBatch");
					NumberInput = scan.nextInt();
					this.RaavareBatchDTO.setRbId(NumberInput);

					System.out.println("Please type in the ID of the Raavare");
					NumberInput = scan.nextInt();
					this.RaavareBatchDTO.setRaavareId(NumberInput);

					System.out.println("Please type in the amount of the RaavareBatch");
					NumberInput2 = scan.nextFloat();
					this.RaavareBatchDTO.setMaengde((NumberInput2/100));

					this.RaavareBatchDAO.createRaavareBatch(this.RaavareBatchDTO);

					break;
				case 5:

					System.out.println("Please type in the ID of the RaavareBatch you want to update");
					NumberInput = scan.nextInt();

					this.RaavareBatchDTO.setRbId(NumberInput);

					System.out.println("Please type in the new Raavare ID of the RaavareBatch");
					NumberInput = scan.nextInt();
					this.RaavareBatchDTO.setRaavareId(NumberInput);

					System.out.println("Please type in the new amount of the RaavareBatch");
					NumberInput2 = scan.nextFloat();
					this.RaavareBatchDTO.setMaengde((NumberInput2/100));

					this.RaavareBatchDAO.updateRaavareBatch(this.RaavareBatchDTO);

					break;
				case 6:
					Selector();
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
				System.out.println("| 1. Get Raavare           |");
				System.out.println("| 2. Get RaavareList       |");
				System.out.println("| 3. Create Raavare        |");
				System.out.println("| 4. Update Raavare        |");
				System.out.println("| 5. GoBack                |");
				System.out.println("============================");

				input = scan.nextInt();

				switch (input) 
				{
				case 1:

					System.out.println("Please type in the ID of the Raavare");
					NumberInput = scan.nextInt();
					System.out.println(" raavare_id: " + RaavareDAO.getRaavare(NumberInput));

					break;
				case 2:

					for (int i = 0; i < RaavareDAO.getRaavareList().size(); i++)
					{
						System.out.println(" raavare_id: " + RaavareDAO.getRaavareList().get(i).getRaavareId() +  " raavare_navn: " + RaavareDAO.getRaavareList().get(i).getRaavareNavn() +  " leverandoer: " + RaavareDAO.getRaavareList().get(i).getLeverandoer());
					}

					break;
				case 3:

					System.out.println("Please type in the ID of the Raavare");
					NumberInput = scan.nextInt();
					this.RaavareDTO.setRaavareId(NumberInput);

					System.out.println("Please type in the name of the Raavare");
					StringInput = scan2.nextLine();
					this.RaavareDTO.setRaavareNavn(StringInput);

					System.out.println("Please type in the name of the supplier");
					StringInput = scan2.nextLine();
					this.RaavareDTO.setLeverandoer(StringInput);

					this.RaavareDAO.createRaavare(this.RaavareDTO);

					break;
				case 4:

					System.out.println("Please type in the ID of the Raavare you want to update");
					NumberInput = scan.nextInt();

					this.RaavareDTO.setRaavareId(NumberInput);

					System.out.println("Please update the name of the Raavare");
					StringInput = scan2.nextLine();

					this.RaavareDTO.setRaavareNavn(StringInput);

					System.out.println("Please update the name of the supplier");
					StringInput = scan2.nextLine();

					this.RaavareDTO.setLeverandoer(StringInput);

					this.RaavareDAO.updateRaavare(this.RaavareDTO);

					break;
				case 5:
					Selector();
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
