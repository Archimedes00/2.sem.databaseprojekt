package daointerfaces01917;

import java.util.List;

import dto01917.OperatoerDTO;
import dto01917.PharmacistDTO;

public interface PharmacistDAO {
	PharmacistDTO getPharmacist(int oprId) throws DALException;
	List<PharmacistDTO> getPharmacistList() throws DALException;
	void createPharmacist(PharmacistDTO opr) throws DALException;
	void updatePharmacist(PharmacistDTO opr) throws DALException;
}
