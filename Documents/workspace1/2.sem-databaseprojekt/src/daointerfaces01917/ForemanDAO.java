package daointerfaces01917;

import java.util.List;

import dto01917.ForemanDTO;
import dto01917.OperatoerDTO;

public interface ForemanDAO {
	ForemanDTO getForeman(int oprId) throws DALException;
	List<ForemanDTO> getForemanList() throws DALException;
	void createForeman(ForemanDTO opr) throws DALException;
	void updateForeman(ForemanDTO opr) throws DALException;
}
