package skrt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Dao1 {
	public static Connection getCon() throws ClassNotFoundException, SQLException {
	   Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
	   System.out.println("driver loaded");
	   Connection cn=DriverManager.getConnection("jdbc:sqlserver://DESKTOP-FQJMKES\\SQLEXPRESS:1433;databaseName=niit" ,"sa","123");
	   System.out.println("database Connected ");
	   return cn;
   }
	public void dTest(Employee e)throws SQLException, ClassNotFoundException {
		
		PreparedStatement ps=Dao1.getCon().prepareStatement("insert into Employee values(?,?,?,?)");  
		System.out.println("Statement is being prepared");
		ps.setString(1, e.getFirstname());
		ps.setString(2, e.getLastname());
		ps.setString(3, e.getDesignation());
		ps.setString(4, e.getContact());
		 
		   int i=ps.executeUpdate();  
		   System.out.println(i+" records affected");  
	}
}
