package dto01917;

/**
 * Operatoer Data Access Objekt
 * 
 * @author mn/tb
 * @version 1.2
 */

public class UsersDTO
{
	/** Operatoer-identifikationsnummer (opr_id) i omraadet 1-99999999. Vaelges af brugerne */
	int oprId;                     
	/** Operatoernavn (opr_navn) min. 2 max. 20 karakterer */
	String oprNavn;                
	/** Operatoer-initialer min. 2 max. 3 karakterer */
	String ini;                 
	/** Operatoer cpr-nr 10 karakterer */
	String cpr;                 
	/** Operatoer password min. 7 max. 8 karakterer */
	String password;
	
	String Role;

	public UsersDTO(int oprId, String oprNavn, String ini, String cpr, String password)
	{
		this.oprId = oprId;
		this.oprNavn = oprNavn;
		this.ini = ini;
		this.cpr = cpr;
		this.password = password;
	}
	
    public UsersDTO(UsersDTO opr)
    {
    	this.oprId = opr.getOprId();
    	this.oprNavn = opr.getOprNavn();
    	this.ini = opr.getIni();
    	this.cpr = opr.getCpr();
    	this.password = opr.getPassword();
    }
    
    public int getOprId() { return oprId; }
	public void setOprId(int oprId) { this.oprId = oprId; }
	public String getOprNavn() { return oprNavn; }
	public void setOprNavn(String oprNavn) { this.oprNavn = oprNavn; }
	public String getIni() { return ini; }
	public void setIni(String ini) { this.ini = ini; }
	public String getCpr() { return cpr; }
	public void setCpr(String cpr) { this.cpr = cpr; }
	public String getPassword() { return password; }
	public void setPassword(String password) { this.password = password; }
	public String toString() { return oprId + "\t" + oprNavn + "\t" + ini + "\t" + cpr + "\t" + password; }
	public void addRole(String Role){ this.Role = Role; }
	public String getRole(){return Role; } 
}
