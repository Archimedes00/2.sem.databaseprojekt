package daoimpl01917;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.ArrayList;

import connector01917.Connector;

import daointerfaces01917.DALException;
import daointerfaces01917.ProduktBatchDAO;
import dto01917.OperatoerDTO;
import dto01917.ProduktBatchDTO;


public class MySQLProduktBatchDAO implements ProduktBatchDAO {

	private Connector connector;
	
	public MySQLProduktBatchDAO(Connector C)
	{
		this.connector = C;
	}

	public ProduktBatchDTO getProduktBatch(int pbId) throws DALException {
		 try {
		    	ResultSet rs = connector.doQuery("SELECT * FROM ProduktBatch WHERE pb_id = " + pbId);
		    	if (!rs.first()) throw new DALException("pb_id " + pbId + " findes ikke");
		    	return new ProduktBatchDTO (rs.getInt("pb_id"), rs.getInt("status"), rs.getInt("recept_id"));
		    }
		    catch (SQLException e) {throw new DALException(e); }
	}
	@Override
	public List<ProduktBatchDTO> getProduktBatchList() throws DALException {
		List<ProduktBatchDTO> list = new ArrayList<ProduktBatchDTO>();
		try
		{
			ResultSet rs = connector.doQuery("SELECT * FROM produktbatch");
			while (rs.next()) 
			{
				list.add(new ProduktBatchDTO(rs.getInt("pb_id"), rs.getInt("status"), rs.getInt("recept_id")));
			}
		}
		catch (SQLException e) { throw new DALException(e); }
		return list;
	}
	@Override
	public void createProduktBatch(ProduktBatchDTO produktbatch) throws DALException {
		try {
			connector.doUpdate(
				"INSERT INTO produktbatch(pb_id, status, recept_id) VALUES " +
				"(" + produktbatch.getPbId() + ", '" + produktbatch.getStatus() + "', '" + produktbatch.getReceptId() + "')"
			);
		} catch ( SQLIntegrityConstraintViolationException e) {
			e.printStackTrace();
			throw new DALException("Duplicate entry");
		} catch(SQLException e){
			e.printStackTrace();
		}
		
	}
	@Override
	public void updateProduktBatch(ProduktBatchDTO produktbatch) throws DALException {
		try {
			connector.doUpdate(
					"UPDATE produktbatch SET status = '" + produktbatch.getStatus() + "', recept_id =  '" + produktbatch.getReceptId() + 
					"' where pb_id = " + produktbatch.getPbId()
			);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	
}
