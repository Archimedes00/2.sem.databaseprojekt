package daoimpl01917;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import connector01917.Connector;
import daointerfaces01917.DALException;
import daointerfaces01917.OperatoerDAO;
import daointerfaces01917.PharmacistDAO;
import dto01917.OperatoerDTO;
import dto01917.PharmacistDTO;

public class MySQLPharmacistDAO implements PharmacistDAO {

private Connector connector;
public MySQLPharmacistDAO(){
	connector = new Connector();
}

public PharmacistDTO getPharmacist(int oprId) throws DALException {
    try {
    	ResultSet rs = connector.doQuery("SELECT * FROM Pharmacist WHERE opr_id = " + oprId);
    	if (!rs.first()) throw new DALException("Pharmacist " + oprId + " findes ikke");
    	return new PharmacistDTO (rs.getInt("opr_id"), rs.getString("opr_navn"), rs.getString("ini"), rs.getString("cpr"), rs.getString("password"));
    }
    catch (SQLException e) {throw new DALException(e); }
	
}

public void createPharmacist(PharmacistDTO opr) throws DALException {		
		try {
			connector.doUpdate(
				"INSERT INTO Pharmacist(opr_id, opr_navn, ini, cpr, password) VALUES " +
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

public void updatePharmacist(PharmacistDTO opr) throws DALException {
	try {
		connector.doUpdate(
				"UPDATE Pharmacist SET  opr_navn = '" + opr.getOprNavn() + "', ini =  '" + opr.getIni() + 
				"', cpr = '" + opr.getCpr() + "', password = '" + opr.getPassword() + "' WHERE opr_id = " +
				opr.getOprId()
		);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

public List<PharmacistDTO> getPharmacistList() throws DALException {
	List<PharmacistDTO> list = new ArrayList<PharmacistDTO>();
	try
	{
		ResultSet rs = connector.doQuery("SELECT * FROM Pharmacist");
		while (rs.next()) 
		{
			list.add(new PharmacistDTO(rs.getInt("opr_id"), rs.getString("opr_navn"), rs.getString("ini"), rs.getString("cpr"), rs.getString("password")));
		}
	}
	catch (SQLException e) { throw new DALException(e); }
	return list;
}

}
