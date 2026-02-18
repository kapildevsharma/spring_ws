

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTEST {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");	
		Connection conn = DriverManager.getConnection("jdbc:sqlserver://10.175.172.158\\kapilsharma05:1433;user=ARA_11_2;password=ARA_11_2;database=ARA_11_2");
		
		Statement sta = conn.createStatement();
		String Sql = "select * from loginObject";
		ResultSet rs = sta.executeQuery(Sql);
		while (rs.next()) {
			System.out.print("id : "+rs.getString("id"));
			System.out.print(" name : "+rs.getString("name"));
			System.out.println(" folderid : "+rs.getString("folderId"));
			System.out.println(" ownerId : "+rs.getString("ownerId"));
			System.out.println(" typeId : "+rs.getString("typeId"));
		}
	}
}
