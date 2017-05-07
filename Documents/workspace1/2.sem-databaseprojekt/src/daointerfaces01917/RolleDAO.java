package daointerfaces01917;

import java.util.List;

import dto01917.RolleDTO;

/*Dette interface g�lder for alle Roller*/

public interface RolleDAO {
	RolleDTO getRolle(int oprId) throws DALException;
	List<RolleDTO> getRolleList() throws DALException;
	void createRolle(RolleDTO rolle) throws DALException;
	void updateRolle(RolleDTO rolle) throws DALException;
}
//