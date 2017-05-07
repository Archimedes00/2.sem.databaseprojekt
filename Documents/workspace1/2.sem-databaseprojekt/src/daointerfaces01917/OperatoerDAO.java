package daointerfaces01917;

import java.util.List;

import dto01917.OperatoerDTO;

/*Dette interface g�lder for alle Roller*/

public interface OperatoerDAO {
	OperatoerDTO getUser(int oprId) throws DALException;
	List<OperatoerDTO> getUserList() throws DALException;
	void createUser(OperatoerDTO opr) throws DALException;
	void updateUser(OperatoerDTO opr) throws DALException;
}
