package jdbcsample.hj.spring.jpa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Application {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/jpa?serverTimezone=UTC&characterEncoding=UTF-8";
		String username = "root";
		String password = "rlaguswhd21";
		
		try {
			Connection con = DriverManager.getConnection(url, username, password);
			System.out.println(con);
			
//			String sql = "CREATE TABLE ACCOUNT (id int, username varchar(255), password varchar(255));";
			String sql = "INSERT INTO ACCOUNT VALUES(1, 'hj', 'pass');";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.execute();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
