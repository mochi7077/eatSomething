package save;

import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class first_table extends JFrame {

	private JTable jTable;
	private MyModel myModel;
	private int rows;
	private ResultSet dataSet;

	public first_table() {
		super("今晚我想來點...");

		setLayout(new BorderLayout());

		initDB(); // 初始化

		myModel = new MyModel();
		jTable = new JTable(myModel);

		JScrollPane jsp = new JScrollPane(jTable);
		add(jsp, BorderLayout.CENTER);
		
		//設定欄位名稱
		String meow[] = { "編號", "餐廳名稱", "餐廳類別" };
		myModel.setColumnIdentifiers(meow);

		setSize(640, 480);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	private void initDB() {
		Properties prop = new Properties();
		prop.put("user", "root");
		prop.put("password", "root");

		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/whateat", prop);

			// 查詢一共有幾筆資料
			String sqlCount = "SELECT count(*) total FROM food";
			PreparedStatement ps = conn.prepareStatement(sqlCount);
			ResultSet rs = ps.executeQuery();
			rs.next();
			rows = rs.getInt("total");

			String sqlQuery = "SELECT * FROM food";
			PreparedStatement ps2 = conn.prepareStatement(sqlQuery, ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			dataSet = ps2.executeQuery();

		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	private class MyModel extends DefaultTableModel {

		@Override
		public int getRowCount() {
			// 決定有幾筆資料
			return rows;
		}

		@Override
		public int getColumnCount() {
			// 先前面3欄，均消先不顯示
			return 3;
		}

//		@Override
//		public String getColumnName(int column) { //決定欄位名稱
//			return "Field" + column;
//
//		}

		@Override
		public Object getValueAt(int row, int column) { // 裡面的資料放什麼
			String ret = "";
			try {
				dataSet.absolute(row + 1); // 因為0是beforefirst，所以位置absolute就讓他從第一列開始存資料
				ret = dataSet.getString(column + 1); // 從第一欄開始存入資料
			} catch (SQLException e) {
				System.out.println(e.toString());
				ret = "***";
			}
			return ret;
		}

	}

	public static void main(String[] args) {
		new first_table();

	}

}