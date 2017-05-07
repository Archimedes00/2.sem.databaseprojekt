package daoimpl01917;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.ArrayList;

import connector01917.Connector;

import daointerfaces01917.DALException;
import daointerfaces01917.OperatoerDAO;
import dto01917.OperatoerDTO;


public class MySQLOperatoerDAO implements OperatoerDAO 
{
	
	private Connector connector;
	
	public MySQLOperatoerDAO(Connector C)
	{
		connector = C;
	}

	public OperatoerDTO getOperatoer(int oprId) throws DALException {
	    try {
	    	ResultSet rs = connector.doQuery("SELECT * FROM operatoer WHERE opr_id = " + oprId);
	    	if (!rs.first()) throw new DALException("Operatoeren " + oprId + " findes ikke");
	    	return new OperatoerDTO (rs.getInt("opr_id"), rs.getString("opr_navn"), rs.getString("ini"), rs.getString("cpr"), rs.getString("password"), rs.getInt("opr_status"));
	    }
	    catch (SQLException e) {throw new DALException(e); }
		
	}
	
	public void createOperatoer(OperatoerDTO opr) throws DALException {		
			try {
				connector.doUpdate(
					"INSERT INTO operatoer(opr_id, opr_navn, ini, cpr, password, opr_status) VALUES " +
					"(" + opr.getOprId() + ", '" + opr.getOprNavn() + "', '" + opr.getIni() + "', '" + 
					opr.getCpr() + "', '" + opr.getPassword() + "', '" + opr.getStatus() + "')"
				);
			} catch ( SQLIntegrityConstraintViolationException e) {
				e.printStackTrace();
				throw new DALException("Duplicate entry");
			} catch(SQLException e){
				e.printStackTrace();
			}
	}
	
	public void updateOperatoer(OperatoerDTO opr) throws DALException {
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
	
	public List<OperatoerDTO> getOperatoerList() throws DALException {
		List<OperatoerDTO> list = new ArrayList<OperatoerDTO>();
		try
		{
			ResultSet rs = connector.doQuery("SELECT * FROM operatoer");
			while (rs.next()) 
			{
				list.add(new OperatoerDTO(rs.getInt("opr_id"), rs.getString("opr_navn"), rs.getString("ini"), rs.getString("cpr"), rs.getString("password"), rs.getInt("opr_status")));
			}
		}
		catch (SQLException e) { throw new DALException(e); }
		return list;
	}
		
	public void deactivateOperatoer(OperatoerDTO opr) throws DALException {
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