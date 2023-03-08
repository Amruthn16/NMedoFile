package practice.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ModifyDataIntoDatabase {
	public static void main(String[] args) throws SQLException {
		//step1-- create instance for Driver --> register driver to jdbc
		Driver dbDriver= new Driver();
		DriverManager.registerDriver(dbDriver);
		
		//step2-- get connection 
		Connection connection = null;
		
		try {
			//step2-- get connection --> dburl, un, pwd jdbc:mysql://localhost:3306/mydb
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet46", "root", "root");

			//step3-- create statement
			Statement statement = connection.createStatement();

			//step4--execute query
			int result = statement.executeUpdate("insert into employee values(1007, 'amruth', 99999, 789780129, 'Bangalore','');");

			//step5--iterate data and verify or fetch
			if(result==1) {
				System.out.println("Data added sucessfully");
			}
		}
		//step- close connection
		finally {
			connection.close();
			System.out.println("Connection closed");
		}

	}
}

