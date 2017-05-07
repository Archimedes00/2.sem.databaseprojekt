package daoimpl01917;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Savepoint;
import java.util.List;
import java.util.ArrayList;

import connector01917.Connector;

import daointerfaces01917.DALException;
import daointerfaces01917.UsersDAO;
import dto01917.UsersDTO;


public class MySQLUsersDAO implements UsersDAO {
	
	private Connector connector;
	public MySQLUsersDAO(){
		connector = new Connector();
	}
	
	public UsersDTO getOperatoer(int oprId) throws DALException {
	    try {
	    	ResultSet rs = connector.doQuery("SELECT * FROM operatoer WHERE opr_id = " + oprId);
	    	if (!rs.first()) throw new DALException("Operatoeren " + oprId + " findes ikke");
	    	return new UsersDTO (rs.getInt("opr_id"), rs.getString("opr_navn"), rs.getString("ini"), rs.getString("cpr"), rs.getString("password"), rs.getInt("opr_status"));
	    }
	    catch (SQLException e) {throw new DALException(e); }
		
	}
	
	public void createOperatoer(UsersDTO opr) throws DALException, SQLException {		
		try {
            connector.getConnection().setAutoCommit(false);
        } catch (SQLException e) {
	        System.out.println("Could not disable autocommit");
        }

        try {
        		connector.doUpdate(
					"INSERT INTO operatoer(opr_id, opr_navn, ini, cpr, password, opr_status) VALUES " +
					"(" + opr.getOprId() + ", '" + opr.getOprNavn() + "', '" + opr.getIni() + "', '" + 
					opr.getCpr() + "', '" + opr.getPassword() + "', '" + opr.getStatus() + "')"
				);
        		
        		connector.doUpdate(
        			"INSERT INTO rolle(opr_id, rolle) VALUES " +
        			"(" + opr.getOprId() + ", '" + opr.getRolle() + "')"
        		);
        		
				connector.getConnection().commit();
				
			} catch ( SQLIntegrityConstraintViolationException e) {
				e.printStackTrace();
				throw new DALException("Duplicate entry");
			} catch(SQLException e){
				e.printStackTrace();
				try {
				    connector.getConnection().rollback();
                } catch (SQLException e1) {
				    System.out.println("Operation was rolled back");
                }
			}
	}
	
	public void updateOperatoerRolle(UsersDTO opr) throws DALException {
		//Skal laves
	}
	
	public void updateOperatoer(UsersDTO opr) throws DALException {
		try {
			connector.doUpdate(
					"UPDATE operatoer SET  opr_navn = '" + opr.getOprNavn() + "', ini =  '" + opr.getIni() + 
					"', cpr = '" + opr.getCpr() + "', password = '" + opr.getPassword() + "', opr_status = '" + opr.getStatus() + "' WHERE opr_id = " +
					opr.getOprId()
			);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<UsersDTO> getOperatoerList() throws DALException {
		List<UsersDTO> list = new ArrayList<UsersDTO>();
		try
		{
			ResultSet rs = connector.doQuery("SELECT * FROM operatoer");
			while (rs.next()) 
			{
				list.add(new UsersDTO(rs.getInt("opr_id"), rs.getString("opr_navn"), rs.getString("ini"), rs.getString("cpr"), rs.getString("password"), rs.getInt("opr_status")));
			}
		}
		catch (SQLException e) { throw new DALException(e); }
		return list;
	}
		
	public void deactivateOperatoer(UsersDTO opr) throws DALException {
		try {
			connector.doUpdate(
					"UPDATE operatoer SET  opr_navn = '" + opr.getOprNavn() + "', ini =  '" + opr.getIni() + 
					"', cpr = '" + opr.getCpr() + "', password = '" + opr.getPassword() + "', opr_status = '0' WHERE opr_id = " +
					opr.getOprId()
			);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
		
}
	
