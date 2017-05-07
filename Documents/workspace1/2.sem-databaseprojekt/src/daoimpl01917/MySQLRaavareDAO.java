package daoimpl01917;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.ArrayList;

import connector01917.Connector;

import daointerfaces01917.DALException;
import daointerfaces01917.RaavareDAO;
import dto01917.OperatoerDTO;
import dto01917.RaavareDTO;

public class MySQLRaavareDAO implements RaavareDAO {

	private Connector connector;
	public MySQLRaavareDAO(Connector C)
	{
		this.connector = C;
	}
	
	
	public RaavareDTO getRaavare(int raavareId) throws DALException {
		 try {
		    	ResultSet rs = connector.doQuery("SELECT * FROM raavare WHERE raavare_id = " + raavareId);
		    	if (!rs.first()) throw new DALException("Identifikationsnummeret " + raavareId + " findes ikke");
		    	return new RaavareDTO (rs.getInt("raavare_id"), rs.getString("raavare_navn"), rs.getString("leverandoer"));
		    }
		    catch (SQLException e) {throw new DALException(e); }
			
	}

	public List<RaavareDTO> getRaavareList() throws DALException {
		List<RaavareDTO> list = new ArrayList<RaavareDTO>();
		try
		{
			ResultSet rs = connector.doQuery("SELECT * FROM raavare");
			while (rs.next()) 
			{
				list.add(new RaavareDTO(rs.getInt("raavare_id"), rs.getString("raavare_navn"), rs.getString("leverandoer")));
			}
		}
		catch (SQLException e) { throw new DALException(e); }
		return list;
	}
	

	@Override
	public void createRaavare(RaavareDTO raavare) throws DALException {
		try {
			connector.doUpdate(
				"INSERT INTO raavare(raavare_id, raavare_navn, leverandoer) VALUES " +
				"(" + raavare.getRaavareId() + ", '" + raavare.getRaavareNavn() + "', '" + raavare.getLeverandoer() + "')"
			);
		} catch ( SQLIntegrityConstraintViolationException e) {
			e.printStackTrace();
			throw new DALException("Duplicate entry");
		} catch(SQLException e){
			e.printStackTrace();
		}
	}

	@Override
	public void updateRaavare(RaavareDTO raavare) throws DALException {
		try {
			connector.doUpdate(
					"UPDATE raavare SET  raavare_navn = '" + raavare.getRaavareNavn() +
					"', leverandoer =  '" + raavare.getLeverandoer() + "' WHERE raavare_id = " + raavare.getRaavareId()
			);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
