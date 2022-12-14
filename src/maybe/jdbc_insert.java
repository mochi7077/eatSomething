package maybe;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class jdbc_insert {

	public static void main(String[] args) {
		try {

			Properties prop = new Properties();
			prop.put("user", "root");
			prop.put("password", "root");
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/whateat", prop);
			
			// 增加多筆資料
			Statement stmt = conn.createStatement();
			
			
//			int n = stmt.executeUpdate("INSERT INTO food (fname, ftype, pricelow, pricehigh) VALUES" +
//					"('湯棧', '火鍋', '265', '1000')," +
//					"('無為草堂', '茶藝館', '400', '600')," +
//					"('12MINI 經典即享鍋', '火鍋', '140', '180')," +
//					"('山東餃子牛肉麵館', '中式麵食店', '150', '230')," +
//					"('太初麵食りようり', '中式麵食店', '100', '300')," +
//					"('斯里印度餐廳', '印度餐廳', '300', '600')," +
//					"('公益麵攤', '中式麵食店', '100', '300')," +
//					"('一笈壽司', '日本料理', '400', '500')," +
//					"('花一番炸牛排專門店', '日本料理', '310', '450')," +
//					"('品心港式飲茶', '粵菜館', '200', '400')," +
//					"('唐太盅養生燉品甜湯', '台菜', '200', '500')," +
//					"('飯飯', '日本料理', '160', '350')," +
//					"('首學無刺虱目魚專賣店', '台菜', '50', '200')," +
//					"('華暘香鵝肉飯專賣店', '台菜', '90', '200')," +
//					"('王將藥燉排骨', '台菜', '35', '200')" 
//					);
			
			int n = stmt.executeUpdate("INSERT INTO info (fname, tel, addr, ftime) VALUES" +
					"('湯棧', '(04)-2258-0617', '台中市南屯區公益路二段248號', '11:00–02:00')," +
					"('無為草堂', '(04)-2329-6707', '台中市南屯區公益路二段106號', '10:30–21:30')," +
					"('12MINI 經典即享鍋', '(04)-2322-1312', '台中市西區公益路383號', '11:00~23:30')," +
					"('山東餃子牛肉麵館', '(04)-2321-5955', '台中市西區公益路94號', '11:00–21:00')," +
					"('太初麵食りようり', '(04)-2319-5101', '台中市南屯區公益路二段115號', '11:00–00:00')," +
					"('斯里印度餐廳', '(04)-2323-3377', '台中市西區公益北街45號', '11:30–21:30')," +
					"('公益麵攤', '(04)-2320-1605', '台中市西區公益路162號', '11:00–02:00')," +
					"('一笈壽司', '(04)-2320-6368', '台中市南屯區公益路二段25號', '11:00–23:00')," +
					"('花一番炸牛排專門店', '(04)-2259-6960', '台中市南屯區文心路一段435號', '11:00–22:30')," +
					"('品心港式飲茶', '(04)-2328-6661', '台中市南屯區公益路二段138號', '11:00–22:00')," +
					"('唐太盅養生燉品甜湯', '(04)-2328-2329', '台中市西區公益路22號', '11:30–21:00')," +
					"('飯飯', '(04)-2326-1888', '台中市西區公益路102號', '11:00–20:00')," +
					"('首學無刺虱目魚專賣店', '(04)-3506-0606', '台中市西區公益路110號', '07:00–20:30')," +
					"('華暘香鵝肉飯專賣店', '(04)-2321-0798', '台中市西區公益路170號', '11:00–08:00')," +
					"('王將藥燉排骨', '0979-777-071', '台中市西區公益路204號', '18:00–03:00')" 
					);

			
			System.out.println("成功上傳" + n + "筆資料");
			
		} catch (SQLException e) {
			System.out.println(e.toString());
		}

	}

}
