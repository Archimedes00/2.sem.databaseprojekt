package daoimpl01917;
import java.sql.ResultSet;import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import connector01917.Connector;
import daointerfaces01917.DALException;
import daointerfaces01917.UsersDAO;
import dto01917.UsersDTO;


public class MySQLAdminDAO implements UsersDAO{
	
	private Connector connector;
	public MySQLAdminDAO(){
		connector = new Connector();
	}
	
	public UsersDTO getUsers(int oprId) throws DALException {
	    try {
	    	ResultSet rs = connector.doQuery("SELECT * FROM Admin WHERE opr_id = " + oprId);
	    	if (!rs.first()) throw new DALException("Admin " + oprId + " findes ikke");
	    	return new UsersDTO (rs.getInt("opr_id"), rs.getString("opr_navn"), rs.getString("ini"), rs.getString("cpr"), rs.getString("password"));
	    }
	    catch (SQLException e) {throw new DALException(e); }
		
	}
	
	public void createUsers(UsersDTO opr) throws DALException {		
			try {
				connector.doUpdate(
					"INSERT INTO Admin(opr_id, opr_navn, ini, cpr, password) VALUES " +
					"(" + opr.getOprId() + ", '" + opr.getOprNavn() + "', '" + opr.getIni() + "', '" + 
					opr.getCpr() + "', '" + opr.getPassword() + "')"
				);
			} catch ( SQLIntegrityConstraintViolationException e) {
				e.printStackTrace();
				throw new DALException("Duplicate entry");
			} catch(SQLException e){
				e.printStackTrace();
			}
	}
	
	public void updateUsers(UsersDTO opr) throws DALException {
		try {
			connector.doUpdate(
					"UPDATE Admin SET  opr_navn = '" + opr.getOprNavn() + "', ini =  '" + opr.getIni() + 
					"', cpr = '" + opr.getCpr() + "', password = '" + opr.getPassword() + "' WHERE opr_id = " +
					opr.getOprId()
			);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<UsersDTO> getUsersList() throws DALException {
		List<UsersDTO> list = new ArrayList<UsersDTO>();
		try
		{
			ResultSet rs = connector.doQuery("SELECT * FROM Admin");
			while (rs.next()) 
			{
				list.add(new UsersDTO(rs.getInt("opr_id"), rs.getString("opr_navn"), rs.getString("ini"), rs.getString("cpr"), rs.getString("password")));
			}
		}
		catch (SQLException e) { throw new DALException(e); }
		return list;
	}
		
		
}
	

