package daointerfaces01917;

import java.util.List;

import dto01917.UsersDTO;
/*Dette interface gælder for alle Roller*/
public interface UsersDAO {
	UsersDTO getUsers(int oprId) throws DALException;
	List<UsersDTO> getUsersList() throws DALException;
	void createUsers(UsersDTO opr) throws DALException;
	void updateUsers(UsersDTO opr) throws DALException;
}
