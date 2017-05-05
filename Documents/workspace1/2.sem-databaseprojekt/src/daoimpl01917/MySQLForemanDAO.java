package daoimpl01917;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import connector01917.Connector;
import daointerfaces01917.DALException;
import daointerfaces01917.ForemanDAO;
import dto01917.ForemanDTO;
import dto01917.OperatoerDTO;

public class MySQLForemanDAO implements ForemanDAO{
	
	private Connector connector;
	public MySQLForemanDAO(){
		connector = new Connector();
	}
	
	public ForemanDTO getForeman(int oprId) throws DALException {
	    try {
	    	ResultSet rs = connector.doQuery("SELECT * FROM Foreman WHERE opr_id = " + oprId);
	    	if (!rs.first()) throw new DALException("Operatoeren " + oprId + " findes ikke");
	    	return new ForemanDTO (rs.getInt("opr_id"), rs.getString("opr_navn"), rs.getString("ini"), rs.getString("cpr"), rs.getString("password"));
	    }
	    catch (SQLException e) {throw new DALException(e); }
		
	}
	
	public void createForeman(ForemanDTO opr) throws DALException {		
			try {
				connector.doUpdate(
					"INSERT INTO Foreman(opr_id, opr_navn, ini, cpr, password) VALUES " +
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
	
	public void updateForeman(ForemanDTO opr) throws DALException {
		try {
			connector.doUpdate(
					"UPDATE Foreman SET  opr_navn = '" + opr.getOprNavn() + "', ini =  '" + opr.getIni() + 
					"', cpr = '" + opr.getCpr() + "', password = '" + opr.getPassword() + "' WHERE opr_id = " +
					opr.getOprId()
			);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<ForemanDTO> getForemanList() throws DALException {
		List<ForemanDTO> list = new ArrayList<ForemanDTO>();
		try
		{
			ResultSet rs = connector.doQuery("SELECT * FROM Foreman");
			while (rs.next()) 
			{
				list.add(new ForemanDTO(rs.getInt("opr_id"), rs.getString("opr_navn"), rs.getString("ini"), rs.getString("cpr"), rs.getString("password")));
			}
		}
		catch (SQLException e) { throw new DALException(e); }
		return list;
	}
}
