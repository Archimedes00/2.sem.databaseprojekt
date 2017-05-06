package connector01917;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/** @author Ronnie Dalsgaard */
public class Connector {
    private  String HOST;
    private  int PORT;
    private  String DATABASE;
    private  String USERNAME;
    private  String PASSWORD;
    private Connection connection;
    
    public Connector() 
    {
        try 
        {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DATABASE;
			connection = DriverManager.getConnection(url, USERNAME, PASSWORD);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			System.exit(1);
		}
    }
    
    public void SetupConnector(String HOST, int PORT, String DATABASE, String USERNAME, String PASSWORD)
    {
    	this.HOST = HOST;
    	this.PORT = PORT;
    	this.DATABASE = DATABASE;
    	this.USERNAME = USERNAME;
    	this.PASSWORD = PASSWORD;
    	
    }
    
    public Connection getConnection(){
    	return connection;
    }
    
    public ResultSet doQuery(String query) throws SQLException{
        Statement stmt = connection.createStatement();
        ResultSet res = stmt.executeQuery(query);
        return res;
    }
    
    public void doUpdate(String query) throws SQLException{
        Statement stmt = connection.createStatement();
        stmt.executeUpdate(query);
    }
}
