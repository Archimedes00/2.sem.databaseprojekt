package daointerfaces01917;

import java.util.List;

import dto01917.AdminDTO;
import dto01917.OperatoerDTO;

public interface AdminDAO 
{
	AdminDTO getAdmin(int oprId) throws DALException;
	List<AdminDTO> getAdminList() throws DALException;
	void createAdmin(AdminDTO opr) throws DALException;
	void updateAdmin(AdminDTO opr) throws DALException;
}
