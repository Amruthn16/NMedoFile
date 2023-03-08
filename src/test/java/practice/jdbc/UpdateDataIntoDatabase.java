package practice.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class UpdateDataIntoDatabase {
	public static void main(String[] args) throws SQLException {
		DriverManager.registerDriver(new Driver());
		Connection connection = null;

		try {
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet46", "root", "root");
			Statement statement = connection.createStatement();
			//int result = statement.executeUpdate("update employee set emp_id='1004'where emp_name='Krishna';");
			int result = statement.executeUpdate("delete from employee where emp_name='vishwas';");
			
			if(result==1) {
				System.out.println("Data updated successfully");
			}
		}
		finally {
			connection.close();
			System.out.println("Connection closed");
		}

	}

}

