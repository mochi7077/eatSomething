package maybe;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class excuteQuery {
//查詢資料庫
	public static void main(String[] args) {
		try {

			Properties prop = new Properties();
			prop.put("user", "root");
			prop.put("password", "root");

			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/whateat", prop);

//			String sql = "SELECT * FROM info";
			String sql = "SELECT * FROM info WHERE ID = 3";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				// 這邊無論原本設定的型別是int還是什麼，就都給他設定string
//				String id = rs.getString("id");
				String fname = rs.getString("fname");
				String tel = rs.getString("tel");
				String addr = rs.getString("addr");
//				System.out.println(String.format("%s:%s:%s:%s", id, fname, tel, addr));
				System.out.println(String.format("%s:%s:%s", fname, tel, addr));
			}


		} catch (SQLException e) {
			System.out.println(e.toString());
		}

	}

}
