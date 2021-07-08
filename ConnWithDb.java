import java.sql.*;

public class ConnWithDb {
    
    public Connection c;
    public Statement s;
 
    public ConnWithDb(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            c =DriverManager.getConnection("jdbc:mysql:///abc","root","dharvi08");
            s = c.createStatement();
            
        
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}
 