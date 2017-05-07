package dto01917;


public class RolleDTO
{
	/** Operatoer-identifikationsnummer (opr_id) i omraadet 1-99999999.*/
	int oprId;                     
	/** Rolle. Enum, en af 4 roller: Admin, Foreman, Pharmacist, Operator*/
	String rolle;                
	
	public RolleDTO(int oprId, String rolle)
	{
		this.oprId = oprId;
		this.rolle = rolle;
	}
	
    public RolleDTO(RolleDTO rolle)
    {
    	this.oprId = rolle.getOprId();
    	this.rolle = rolle.getRolle();
    }
    
	public int getOprId() { return oprId; }
	public void setOprId(int oprId) { this.oprId = oprId; }
	public String getRolle() { return rolle; }
	public void setRolle(String rolle) { this.rolle = rolle; }
	public String toString() { return oprId + "\t" + rolle; }
}
//