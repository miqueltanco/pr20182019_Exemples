package pru05;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
public class PRU05E01e1_Miquel_Tanco {

	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;

	public void readDataBase() throws Exception {
		try {

			connect = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/employees?&useSSL=false&"
							+ "user=root&password=cide1234");

			// Statements allow to issue SQL queries to the database
			statement = connect.createStatement();
			// Result set get the result of the SQL query
			resultSet = statement
					.executeQuery("select * from departments");
			writeResultSet(resultSet);


		} catch (Exception e) {
			throw e;
		} finally {
			close();
		}

	}


	private void writeResultSet(ResultSet resultSet) throws SQLException {


		while (resultSet.next()) {
			// It is possible to get the columns via name
			// but also possible to get the columns via the column number
			// starting at 1
			// e.g. resultSet.getSTring(2);

			String dept_no = resultSet.getString("dept_no");
			String dept_name = resultSet.getString("dept_name");


			System.out.println("Numero departamento: " + dept_no);
			System.out.println("Llinatge: " + dept_name);
			System.out.println("======================");
		}
	}

	// You need to close the resultSet
	private void close() {
		try {
			if (resultSet != null) {
				resultSet.close();
			}

			if (statement != null) {
				statement.close();
			}

			if (connect != null) {
				connect.close();
			}
		} catch (Exception e) {

		}
	}

}