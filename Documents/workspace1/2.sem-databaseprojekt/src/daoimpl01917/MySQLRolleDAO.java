package daoimpl01917;
/** Author Bijan Negari */
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import connector01917.Connector;
import daointerfaces01917.DALException;
import daointerfaces01917.RolleDAO;
import dto01917.RolleDTO;

public class MySQLRolleDAO implements RolleDAO{

	private Connector connector;

	public MySQLRolleDAO(Connector C)
	{
		connector = C;
	}

	public RolleDTO getRolle(int oprId) throws DALException {
		try {
			ResultSet rs = connector.doQuery("SELECT * FROM rolle WHERE opr_id = " + oprId);
			if (!rs.first()) throw new DALException("Opr ID'et " + oprId + " findes ikke");
			return new RolleDTO (rs.getInt("opr_id"), rs.getString("rolle"));
		}
		catch (SQLException e) {throw new DALException(e); }

	}

	public void createRolle(RolleDTO rolle) throws DALException {		
		try {
			connector.doUpdate(
					"INSERT INTO rolle(opr_id, rolle) VALUES " +
							"(" + rolle.getOprId() + ", '" + rolle.getRolle() + "')"
					);
		} catch ( SQLIntegrityConstraintViolationException e) {
			e.printStackTrace();
			throw new DALException("Duplicate entry");
		} catch(SQLException e){
			e.printStackTrace();
		}
	}

	public void updateRolle(RolleDTO opr) throws DALException {
		try {
			connector.doUpdate(
					"UPDATE rolle SET  rolle = '" + opr.getRolle() + "' WHERE opr_id = " +
							opr.getOprId()
					);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<RolleDTO> getRolleList() throws DALException {
		List<RolleDTO> list = new ArrayList<RolleDTO>();
		try
		{
			ResultSet rs = connector.doQuery("SELECT * FROM rolle");
			while (rs.next()) 
			{
				list.add(new RolleDTO(rs.getInt("opr_id"), rs.getString("rolle")));
			}
		}
		catch (SQLException e) { throw new DALException(e); }
		return list;
	}

}
