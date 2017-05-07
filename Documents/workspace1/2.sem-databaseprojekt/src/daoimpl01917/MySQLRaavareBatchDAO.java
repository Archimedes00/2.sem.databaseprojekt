package daoimpl01917;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.ArrayList;

import connector01917.Connector;

import daointerfaces01917.DALException;
import daointerfaces01917.RaavareBatchDAO;
import dto01917.RaavareBatchDTO;

public class MySQLRaavareBatchDAO implements RaavareBatchDAO{

	private Connector connector;
	
	public MySQLRaavareBatchDAO(Connector C)
	{
		this.connector = C;	
	}

	public RaavareBatchDTO getRaavareBatch(int rbId) throws DALException {
		try {
			ResultSet rs = connector.doQuery("select * from raavarebatch where rb_id = " + rbId);
			if (!rs.first()) throw new DALException("råvarebatch med identifikationsnummer " + rbId + " findes ikke");
			return new RaavareBatchDTO (rs.getInt("rb_id"), rs.getInt("raavare_id"), rs.getInt("maengde"));
		}
		catch (SQLException e) {
			throw new DALException(e); }

	}

	@Override
	public List<RaavareBatchDTO> getRaavareBatchList() throws DALException {
		List<RaavareBatchDTO> list = new ArrayList<RaavareBatchDTO>();
		try
		{
			ResultSet rs = connector.doQuery("SELECT * FROM raavarebatch");
			while (rs.next()) 
			{
				list.add(new RaavareBatchDTO(rs.getInt("rb_id"), rs.getInt("raavare_id"), rs.getInt("maengde")));
			}
		}
		catch (SQLException e) { throw new DALException(e); }
		return list;
	}

	@Override
	public List<RaavareBatchDTO> getRaavareBatchList(int raavareId) throws DALException {
		List<RaavareBatchDTO> list = new ArrayList<RaavareBatchDTO>();
		try
		{
			ResultSet rs = connector.doQuery("SELECT * FROM raavarebatch where raavare_id = " + raavareId);
			while (rs.next()) 
			{
				list.add(new RaavareBatchDTO(rs.getInt("rb_id"), rs.getInt("raavare_id"), rs.getInt("maengde")));
			}
		}
		catch (SQLException e) { throw new DALException(e); }
		return list;
	}

	@Override
	public void createRaavareBatch(RaavareBatchDTO raavarebatch) throws DALException {
		try {
			connector.doUpdate(
				"INSERT INTO raavarebatch(rb_id, raavare_id, maengde) VALUES " +
				"(" + raavarebatch.getRbId() + ", '" + raavarebatch.getRaavareId() + "', '" + raavarebatch.getMaengde() + "')"
			);
		} catch ( SQLIntegrityConstraintViolationException e) {
			e.printStackTrace();
			throw new DALException("Duplicate entry");
		} catch(SQLException e){
			e.printStackTrace();
		}
	}

	@Override
	public void updateRaavareBatch(RaavareBatchDTO raavarebatch) throws DALException {
		try {
			connector.doUpdate(
					"UPDATE raavarebatch SET  raavare_id = '" + raavarebatch.getRaavareId() + "', maengde =  '" + raavarebatch.getMaengde() + 
					"' WHERE rb_id = " + raavarebatch.getRbId()
			);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
