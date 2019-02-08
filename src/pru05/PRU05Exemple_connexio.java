package pru05;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
public class PRU05Exemple_connexio {

    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    public void readDataBase() throws Exception {
        try {

            connect = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/employees?serverTimezone=UTC&useSSL=false&"
                            + "user=root&password=Cide2018");

            // Statements allow to issue SQL queries to the database
            statement = connect.createStatement();
            // Result set get the result of the SQL query
            resultSet = statement
                    .executeQuery("select emp_no,birth_date,first_name,"
                    		+ "last_name from employees limit 2");
            writeResultSet(resultSet);

           
        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }

    }


    private void writeResultSet(ResultSet resultSet) throws SQLException {
        
    	ArrayList<Empleado> empleats = new ArrayList<Empleado>();
    	
        while (resultSet.next()) {
            // It is possible to get the columns via name
            // but also possible to get the columns via the column number
            // starting at 1
            // e.g. resultSet.getSTring(2);

        	int i = 0;
        	
        	empleats.add(new Empleado(resultSet.getInt("emp_no"), resultSet.getDate("birth_date"), resultSet.getString("first_name"), resultSet.getString("last_name")));
        	
           /* 
            * int emp_no = resultSet.getInt("emp_no");
            * Date birth_date = resultSet.getDate("birth_date");
            * String first_name = resultSet.getString("first_name");
            * String last_name = resultSet.getString("last_name");
            */

            System.out.println("Num empleat: " + empleats.get(i).emp_no);
            System.out.println("Data naixament: " + empleats.get(i).birth_date);
            System.out.println("Nom: " + empleats.get(i).first_name);
            System.out.println("Llinatge: " + empleats.get(i).last_name);
            System.out.println("======================");
           
            i++;
            
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