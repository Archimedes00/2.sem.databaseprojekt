package daoimpl01917;
/** Author Bijan Negari*/
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.ArrayList;

import connector01917.Connector;

import daointerfaces01917.DALException;
import daointerfaces01917.ProduktBatchKompDAO;
import dto01917.ProduktBatchKompDTO;

public class MySQLProduktBatchKompDAO implements ProduktBatchKompDAO {

	private Connector connector;
	
	public MySQLProduktBatchKompDAO(Connector C)
	{
		this.connector = C;
	}
	public ProduktBatchKompDTO getProduktBatchKomp(int pbId, int rbId) throws DALException {
		 try {
		    	ResultSet rs = connector.doQuery("SELECT * FROM produktbatchkomponent WHERE pb_id = " + pbId + " and rb_id = " + rbId);
		    	if (!rs.first()) throw new DALException("Ingrediensen med pb_id " + pbId + " og rb_id " + rbId + " findes ikke");
		    	return new ProduktBatchKompDTO (rs.getInt("pb_id"), rs.getInt("rb_id"), rs.getDouble("tara"), rs.getDouble("netto"), rs.getInt("opr_id"));
		    }
		    catch (SQLException e) {throw new DALException(e); }
	}

	@Override
	public List<ProduktBatchKompDTO> getProduktBatchKompList(int pbId) throws DALException {
		List<ProduktBatchKompDTO> list = new ArrayList<ProduktBatchKompDTO>();
		try
		{
			ResultSet rs = connector.doQuery("SELECT * FROM produktbatchkomponent where pb_id = " + pbId);
			while (rs.next()) 
			{
				list.add(new ProduktBatchKompDTO(pbId, rs.getInt("rb_id"), rs.getDouble("tara"), rs.getDouble("netto"), rs.getInt("opr_id")));
			}
		}
		catch (SQLException e) { throw new DALException(e); }
		return list;
	}

	@Override
	public List<ProduktBatchKompDTO> getProduktBatchKompList() throws DALException {
		List<ProduktBatchKompDTO> list = new ArrayList<ProduktBatchKompDTO>();
		try
		{
			ResultSet rs = connector.doQuery("SELECT * FROM produktbatchkomponent");
			while (rs.next()) 
			{
				list.add(new ProduktBatchKompDTO(rs.getInt("pb_id"), rs.getInt("rb_id"), rs.getDouble("tara"), rs.getDouble("netto"), rs.getInt("opr_id")));
			}
		}
		catch (SQLException e) { throw new DALException(e); }
		return list;
	
	}

	@Override
	public void createProduktBatchKomp(ProduktBatchKompDTO produktbatchkomponent) throws DALException {

		try
		{
			connector.doUpdate("INSERT INTO produktbatchkomponent(pb_id, rb_id, tara, netto, opr_id) VALUES " +
					"(" + produktbatchkomponent.getPbId() + ", '" + produktbatchkomponent.getRbId() + "', '" + produktbatchkomponent.getTara() + "', '" + 
					produktbatchkomponent.getNetto() + "', '" + produktbatchkomponent.getOprId() + "')"
					);
		}
			catch	( SQLIntegrityConstraintViolationException e) {
				e.printStackTrace();
				throw new DALException("Duplicate entry");
			} catch(SQLException e){
				e.printStackTrace();
		}
		
	}

	@Override
	public void updateProduktBatchKomp(ProduktBatchKompDTO produktbatchkomponent) throws DALException {
		try {
			connector.doUpdate(
					"UPDATE produktbatchkomponent SET tara = '" + produktbatchkomponent.getTara() + "', netto =  '" + produktbatchkomponent.getNetto() + 
					"', opr_id = '" + produktbatchkomponent.getOprId() + "' WHERE pb_id = " + produktbatchkomponent.getPbId() + " and rb_id = " + produktbatchkomponent.getRbId()
			);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
