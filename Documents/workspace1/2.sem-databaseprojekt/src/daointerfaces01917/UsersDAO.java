package daointerfaces01917;

import java.util.List;

import dto01917.UsersDTO;

public interface UsersDAO {
	UsersDTO getOperatoer(int oprId) throws DALException;
	List<UsersDTO> getOperatoerList() throws DALException;
	void createOperatoer(UsersDTO opr) throws DALException;
	void updateOperatoer(UsersDTO opr) throws DALException;
}
