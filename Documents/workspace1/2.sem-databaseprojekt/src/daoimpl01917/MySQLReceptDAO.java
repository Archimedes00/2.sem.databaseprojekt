package daoimpl01917;
/** Author Bijan Negari */
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.ArrayList;

import connector01917.Connector;

import daointerfaces01917.DALException;
import daointerfaces01917.ReceptDAO;
import dto01917.ReceptDTO;

public class MySQLReceptDAO implements ReceptDAO {
	
	private Connector connector;
	public MySQLReceptDAO(Connector C)
	{
		this.connector = C;
	}

	public ReceptDTO getRecept(int receptId) throws DALException {
		try {
	    	ResultSet rs = connector.doQuery("SELECT * FROM recept WHERE recept_id = " + receptId);
	    	if (!rs.first()) throw new DALException("Identifikationsnummer " + receptId + " findes ikke");
	    	return new ReceptDTO (rs.getInt("recept_id"), rs.getString("recept_navn"));
	    }
	    catch (SQLException e) {throw new DALException(e); }
	}

	@Override
	public List<ReceptDTO> getReceptList() throws DALException {
		List<ReceptDTO> list = new ArrayList<ReceptDTO>();
		try
		{
			ResultSet rs = connector.doQuery("SELECT * FROM recept");
			while (rs.next()) 
			{
				list.add(new ReceptDTO(rs.getInt("recept_id"), rs.getString("recept_navn")));
			}
		}
		catch (SQLException e) { throw new DALException(e); }
		return list;
	}

	@Override
	public void createRecept(ReceptDTO recept) throws DALException {
		try 
		{
			String query =
					"Call CreateNewRecept ('" +
					 recept.getReceptId() + "', '" + recept.getReceptNavn() + "')";

			PreparedStatement pstmt = this.connector.getConnection().prepareCall("{call CreateNewRecepts(?,?)}");
			
			pstmt.setInt(1, recept.getReceptId());
			pstmt.setString(2, recept.getReceptNavn());
			
			//pstmt.registerOutParameter(3, java.sql.Types.VARCHAR);
			pstmt.executeUpdate();

	
			/*
			connector.doUpdate
			(
				"INSERT INTO recept (recept_id, recept_navn) VALUES " +
				"(" + recept.getReceptId() + ", '" + recept.getReceptNavn() + "')"
			);
			*/
			
		} catch ( SQLIntegrityConstraintViolationException e) {
			e.printStackTrace();
			throw new DALException("Duplicate entry");
		} catch(SQLException e){
			e.printStackTrace();
		}
	}

	@Override
	public void updateRecept(ReceptDTO recept) throws DALException {
		try {
			connector.doUpdate(
					"UPDATE recept SET  recept_navn = '" + recept.getReceptNavn() + "' WHERE recept_id = " +
					recept.getReceptId()
			);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
