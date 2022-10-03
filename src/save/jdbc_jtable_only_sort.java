package save;

import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Comparator;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class jdbc_jtable_only_sort extends JFrame {

	private JTable jTable;
	private MyModel myModel;
	
	private int rows;
	private ResultSet dataSet;

	public jdbc_jtable_only_sort() {
		super("今晚我想來點...");

		setLayout(new BorderLayout());

		initDB(); // 初始化

		myModel = new MyModel();
		jTable = new JTable(myModel);
		
		//加入排序
		TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(myModel);
		jTable.setRowSorter(sorter); 
		
		 
		JScrollPane jsp = new JScrollPane(jTable);
		add(jsp, BorderLayout.CENTER);
		
		//設定欄位名稱
		String cols[] = { "編號", "餐廳名稱", "餐廳類別", "平均消費" };
		myModel.setColumnIdentifiers(cols);

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
		
		
//		TableModel model = new DefaultTableModel(rows, cols) {
//	        @Override
//	        public Class<?> getColumnClass(int columnIndex) {
//	            if (columnIndex == 0) return Integer.class;
//	            return super.getColumnClass(columnIndex);
//	        }
//	    };
		@Override
		public Class<?> getColumnClass(int columnIndex) {
			Class returnValue;
			if ((columnIndex >= 0) && (columnIndex < getColumnCount())) {
				returnValue = getValueAt(0, columnIndex).getClass();
			} else {
				returnValue = Object.class;
			}
			return returnValue;
		}
		
		@Override
		public int getRowCount() {
			// 決定有幾筆資料
			return rows;
		}

		@Override
		public int getColumnCount() {
			// 先前面3欄，均消先不顯示
			return 4;
		}


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
		new jdbc_jtable_only_sort();

	}

}