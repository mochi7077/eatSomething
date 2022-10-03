package save;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Properties;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class teach_table extends JFrame implements ActionListener {

	private JTable jTable;
	private MyModel myModel;
	private JTextArea log;
	private JLabel ran;
	private JTextField num1;
	private JLabel to;
	private JTextField num2;
	private JButton submit;
	private JTextArea outputTextArea;
	private JTextArea outputTextAreaOnly;
	private JLabel menuGet;
	private ImageIcon icon;

	private int rows;
	private ResultSet dataSet;

	public teach_table() {
		super("EatSomething");

		setLayout(new BorderLayout());

		initDB(); // 初始化

		myModel = new MyModel();
		jTable = new JTable(myModel);
		log = new JTextArea(5, 1);
		menuGet = new JLabel();

		add(log, BorderLayout.SOUTH);


		// ---價格篩選---
		ran = new JLabel("Price Range：");
		num1 = new JTextField(10);
		to = new JLabel("～");
		num2 = new JTextField(10);
		submit = new JButton("Go！");
		outputTextArea = new JTextArea(8,50);
		outputTextAreaOnly = new JTextArea(8,50);

		JPanel topUp = new JPanel(new FlowLayout());
		topUp.add(ran);
		topUp.add(num1);
		topUp.add(to);
		topUp.add(num2);
		topUp.add(submit);
		
		JPanel topDown = new JPanel(new FlowLayout());
		topDown.add(outputTextArea);
		topDown.add(outputTextAreaOnly);
		
		JPanel top = new JPanel(new BorderLayout());
		top.add(topUp, BorderLayout.NORTH);
		top.add(topDown, BorderLayout.SOUTH);
		
		topUp.setBackground(Color.pink);
		topDown.setBackground(Color.pink);
		
		add(top, BorderLayout.NORTH);
		add(menuGet, BorderLayout.EAST);

		submit.addActionListener(this);

		// ------皮膚-----------------
		
		try {
            UIManager.setLookAndFeel("com.jtattoo.plaf.noire.NoireLookAndFeel");
 
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(teach_table.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(teach_table.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(teach_table.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(teach_table.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
		
		//----加入排序--------
		TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(myModel);
		jTable.setRowSorter(sorter);

		JScrollPane jsp = new JScrollPane(jTable);
		add(jsp, BorderLayout.CENTER);
		

		// 設定欄位名稱
		String cols[] = { "編號", "餐廳名稱", "餐廳類別", "平均消費" };
		myModel.setColumnIdentifiers(cols);

		setSize(950, 600);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// ------顯示詳細餐廳資訊------------------
		
		jTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					// 拖動多選
					int[] rows = jTable.getSelectedRows();
					for (int i : rows) {

						try {
							Properties prop = new Properties();
							prop.put("user", "root");
							prop.put("password", "root");

							Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/whateat", prop);

							String sql = "SELECT * FROM info WHERE ID = " + (i + 1);
							PreparedStatement pstmt = conn.prepareStatement(sql);
							ResultSet rs = pstmt.executeQuery();

							while (rs.next()) {
								String fname = rs.getString("fname");
								String tel = rs.getString("tel");
								String addr = rs.getString("addr");
								String menu = rs.getString("menu");

								// 清空上一行
								logmouseClicked(null);

								// 加入點選
								log.append(String.format("店名： %s \n電話：%s \n地址： %s", fname, tel, addr));
								
								//------下載菜單-------------------
								
								Calendar cal = Calendar.getInstance();
//								int hour = cal.get(Calendar.HOUR);
//								int min = cal.get(Calendar.MINUTE);
//								int sec = cal.get(Calendar.SECOND);
//								int rand = (int)(Math.random()*999)*10;
								
								try {
									URL url = new URL(menu);
									HttpURLConnection hconn = (HttpURLConnection) url.openConnection();
									hconn.connect();

									try (BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream("dowdow/meeeu.jpg"));
//										 BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream("dowdow/" + rand + hour + min + sec + ".jpg"));
											BufferedInputStream bin = new BufferedInputStream(hconn.getInputStream());) {

										byte[] buf = new byte[1024 * 1024];
										int len;
										while ((len = bin.read(buf)) != -1) {
											bout.write(buf, 0, len);
										}
										bout.flush();
//										System.out.println(rand + hour + min + sec + "下載成功");
										System.out.println("下載成功");
										
										menuGetmoClicked(null);
										Container con = getContentPane();
								        Icon icon = new ImageIcon("C:\\Users\\minim\\eclipse-workspace\\Food\\dowdow\\meeeu.jpg");
								        
								        menuGet.setIcon(icon);
								        
								        con.add(menuGet);
								        
								        
									} catch (Exception ea) {
										System.out.println(ea.toString());
									}

								} catch (Exception eb) {
									// TODO Auto-generated catch block
									eb.printStackTrace();
								}
							}
						} catch (SQLException ea) {
							System.out.println(ea.toString());
						}	}}	}	});	}
	
	public void doublemouseClicked(MouseEvent event) {
	
	  if (event.getClickCount() == 2 && event.getButton() == MouseEvent.BUTTON1) {
	    System.out.println("double clicked");
	  }
	}

	private void initDB() {
		Properties prop = new Properties();
		prop.put("user", "root");
		prop.put("password", "root");

		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/whateat", prop);

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

		Class[] columnTypes = { Integer.class, String.class, String.class, Integer.class };

		@Override
		public Class getColumnClass(int column) {
//        	System.out.println(column + ":" + columnTypes[column].getName());
			return this.columnTypes[column];
		}

		@Override
		public int getRowCount() {
			return rows;
		}

		@Override
		public int getColumnCount() {
			return 4;
		}


		@Override
		public Object getValueAt(int row, int column) {
			Object ret = null;
			try {
				dataSet.absolute(row + 1);
				if (column == 0) {
					ret = (Integer) dataSet.getInt(1);
				} else if (column == 3) {
					ret = (Integer) dataSet.getInt(column + 1);
				} else {
					ret = dataSet.getString(column + 1);
				}
			} catch (SQLException e) {
				System.out.println(e.toString());
				ret = "***";
			}
			return ret;
		}

	}

	public static void main(String[] args) {

		Runnable runb = new Runnable() {
			public void run() {
				new teach_table();
			}
		};
		SwingUtilities.invokeLater(runb);

	}

	public void logmouseClicked(MouseEvent e) {
		log.setText("");
	}
	
	public void outputTextAreamouseClicked(MouseEvent e) {
		outputTextArea.setText("");
		outputTextAreaOnly.setText("");
		menuGet.setIcon(null);
	}
	
	public void menuGetmoClicked(MouseEvent e) {
		menuGet.setIcon(null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		int n1 = Integer.parseInt(num1.getText());
		int n2 = Integer.parseInt(num2.getText());

		try {
			Properties prop = new Properties();
			prop.put("user", "root");
			prop.put("password", "root");

			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/whateat", prop);
			
			String sql = String.format("SELECT * FROM food AS f WHERE f.favg BETWEEN %d AND %d", n1, n2);
					
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			outputTextAreamouseClicked(null);
			
			ArrayList<String> ids = new ArrayList<String>();
			ArrayList<String> names = new ArrayList<String>();
			ArrayList<String> avgs = new ArrayList<String>();
			
			while (rs.next()) {
				String id = rs.getString("id");
				String fname = rs.getString("fname");
				String favg = rs.getString("favg");

				ids.add(rs.getString(1));
				names.add(rs.getString(2));
				avgs.add(rs.getString(3));
				outputTextArea.append(String.format("※%s. %s－平均消費：%s元\n", id, fname, favg));

			}
			
			//-------取得會查出幾筆----------
			
			String numsql = String.format("SELECT count(*) AS nums FROM food AS f WHERE f.favg BETWEEN %d AND %d", n1, n2);
			PreparedStatement numpstmt = conn.prepareStatement(numsql);
			ResultSet numrs = numpstmt.executeQuery();
			numrs.next();
			int nums = numrs.getInt("nums");
			System.out.println(nums);
			
			//印出查詢到的物件，放入陣列
			System.out.println(names);
			
			//隨機取得陣列第幾個位置
			int x = (int) (Math.random() * nums);
//			System.out.println(x);
//			System.out.println(names.get(x));
			
			//抽出一間
			outputTextAreaOnly.append("本日精選：\n ＝＝ ※" + ids.get(x) + "." + names.get(x) + avgs.get(x) + " ＝＝" );

			
		} catch (SQLException ea) {
			System.out.println(ea.toString());
		}
	}

	// 雙擊滑鼠事件
//	MouseListener mouseListener = new MouseAdapter() {
//		public void mouseClicked(MouseEvent mouseEvent) {
//			List theList = (List) mouseEvent.getSource();
//			if (mouseEvent.getClickCount() == 2) {
//				int index = theList.getSelectedIndex();
//				if (index >= 0) {
//					String s = theList.getItem(index);
//				}
//			}
//		}
//	};

}