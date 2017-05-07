package daointerfaces01917;

import java.util.List;

import dto01917.UserDTO;

/*Dette interface g�lder for alle Roller*/

public interface UserDAO {
	UserDTO getUser(int oprId) throws DALException;
	List<UserDTO> getUserList() throws DALException;
	void createUser(UserDTO opr) throws DALException;
	void updateUser(UserDTO opr) throws DALException;
}
