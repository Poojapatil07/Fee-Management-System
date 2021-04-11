//Step 1--> Import Package
import java.sql.*;
import javax.swing.JOptionPane;
public class JavaConnect {
            Connection conn;
            PreparedStatement pst;
            ResultSet set;
        public static Connection connectDb()
        {
            try{
                // Step 2-- > Register the Driver
                //forName is the method which belongs to the class "Class"
                //USe to Register the driver
                //IT is the "Static" method hence can called with class name.
                Class.forName("com.mysql.jdbc.Driver");  
                //Step 3 --> Establish the connection
                //Connection is "Interface" hence we cannot create its object
                //getconnection method of DriverManager class is used to establish the connection with the database
                Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/collegereg","root","root123#");
                return con;
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
                return null;
           }       
        }
}

