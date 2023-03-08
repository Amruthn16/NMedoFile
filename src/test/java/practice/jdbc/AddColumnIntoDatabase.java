package practice.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class AddColumnIntoDatabase {

	public static void main(String[] args) throws SQLException {
		//Driver dbDriver= new Driver();
		DriverManager.registerDriver(new Driver());
		Connection connection = null;
		
		try {
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet46", "root", "root");
			Statement statement = connection.createStatement();
			
			statement.executeUpdate("alter table employee add column location char(10) not null; ");
			
			ResultSet res = statement.executeQuery("select * from employee; ");
			
			while(res.next()) {
				  String location = res.getString("location");
				System.out.println(location);
			}
		}
		finally {
			connection.close();
			System.out.println("Connection closed");
		}
	}

}
