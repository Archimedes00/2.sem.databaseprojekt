package daointerfaces01917;

import java.util.List;

import dto01917.OperatoerDTO;

/*Dette interface g�lder for alle Roller*/

public interface OperatoerDAO {
	OperatoerDTO getOperatoer(int oprId) throws DALException;
	List<OperatoerDTO> getOperatoerList() throws DALException;
	void createOperatoer(OperatoerDTO opr) throws DALException;
	void updateOperatoer(OperatoerDTO opr) throws DALException;
	void deactivateOperatoer(OperatoerDTO opr) throws DALException;
}
