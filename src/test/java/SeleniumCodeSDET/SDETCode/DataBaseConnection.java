package SeleniumCodeSDET.SDETCode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

public class DataBaseConnection {

@Test
public void Database() throws SQLException {
	
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hr", "root", "root");
	Statement st = con.createStatement();
	String s = "select employee_id, first_name, lastname from employees";
	ResultSet rs = st.executeQuery(s);
	
	while(rs.next()) {
		
		int id = rs.getInt("");
	}

}

	
}
