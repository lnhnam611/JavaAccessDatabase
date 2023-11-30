package DatabaseProject;

import java.sql.*;

public class DatabaseApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Connection conn = null;
		Statement statement = null;
		ResultSet result = null;
		
		try
		{
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		}
		catch(ClassNotFoundException ex)
		{
			System.out.println("Problem in loading the driver");
			ex.printStackTrace();
		}
		
		try
		{
			String dbName = "DB_Employee.accdb";
			String dbURL = "jdbc:ucanaccess://" + dbName;
			conn = DriverManager.getConnection(dbURL);
			statement = conn.createStatement();
			//String query = "insert into emp (EmpName, Salary) values ('John','89000');";
			//statement.execute(query);
			
			result = statement.executeQuery("SELECT * FROM EMP where Salary > 80000;");
			int id;
			String name;
			double sal;
			while(result.next())
			{
				id = result.getInt(1);
				name = result.getString(2);
				sal = result.getDouble(3);
				
				System.out.println("ID: "+id + " name "+ name + " salary "+ sal);
				
			}
		}
		catch(SQLException ex)
		{
			System.out.println("problem with databse");
		}
		finally
		{
			try
			{
				if(conn != null)
				{
					result.close();
					statement.close();
					conn.close();					
				}
			}
			catch(SQLException ex)
			{
				ex.printStackTrace();
			}
		}
	}

}
