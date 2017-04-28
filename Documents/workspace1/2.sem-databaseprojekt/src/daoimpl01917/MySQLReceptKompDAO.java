package daoimpl01917;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.ArrayList;

import connector01917.Connector;
import daointerfaces01917.ReceptKompDAO;
import dto01917.OperatoerDTO;
import dto01917.ProduktBatchKompDTO;
import dto01917.ReceptKompDTO;
import daointerfaces01917.DALException;

public class MySQLReceptKompDAO implements ReceptKompDAO {

	private Connector connector;
	public MySQLReceptKompDAO(){
		connector = new Connector();
	}
	
	@Override
	public ReceptKompDTO getReceptKomp(int receptId, int raavareId) throws DALException {
		try {
	    	ResultSet rs = connector.doQuery("SELECT * FROM receptkomponent WHERE recept_id = " + receptId + " and raavare_id = " + raavareId);
	    	if (!rs.first()) throw new DALException("Ingrediensen med pb_id " + receptId + " og rb_id " + raavareId + " findes ikke");
	    	return new ReceptKompDTO (rs.getInt("recept_id"), rs.getInt("raavare_id"), rs.getDouble("nom_netto"), rs.getDouble("tolerance"));
	    }
	    catch (SQLException e) {throw new DALException(e); }
		
	}

	@Override
	public List<ReceptKompDTO> getReceptKompList(int receptId) throws DALException {
		List<ReceptKompDTO> list = new ArrayList<ReceptKompDTO>();
		try
		{
			ResultSet rs = connector.doQuery("SELECT * FROM receptkomponent where recept_id = " + receptId);
			while (rs.next()) 
			{
				list.add(new ReceptKompDTO(receptId, rs.getInt("raavare_id"), rs.getDouble("nom_netto"), rs.getDouble("tolerance")));
			}
		}
		catch (SQLException e) { throw new DALException(e); }
		return list;
	}

	@Override
	public List<ReceptKompDTO> getReceptKompList() throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createReceptKomp(ReceptKompDTO receptkomponent) throws DALException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateReceptKomp(ReceptKompDTO receptkomponent) throws DALException {
		// TODO Auto-generated method stub
		
	}

}
