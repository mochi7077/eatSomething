package meow;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;


public class main extends JFrame implements ActionListener {

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
	
	private int rows;
	private ResultSet dataSet;

	public main() {
		super("EatSomething");

		setLayout(new BorderLayout());

		initDB(); // 初始化

		myModel = new MyModel();
		
		JScrollPane scrollPaneTable = new JScrollPane();
		scrollPaneTable.setBackground(Color.BLACK);
		scrollPaneTable.setBounds(440, 36, 558, 629);
		getContentPane().add(scrollPaneTable);
		
		jTable = new JTable(myModel);
		scrollPaneTable.setViewportView(jTable);
		jTable.setForeground(Color.black);
		jTable.setRowHeight(20);

		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
		tcr.setHorizontalAlignment(JLabel.CENTER);
		jTable.setDefaultRenderer(Object.class, tcr);

		jTable.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		jTable.setBorder(new LineBorder(Color.BLACK, 3, true));
		jTable.setBackground(Color.ORANGE);

		TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(myModel);
		jTable.setRowSorter(sorter);
		
		String cols[] = { "編號", "餐廳名稱", "餐廳類別", "平均消費" };
		myModel.setColumnIdentifiers(cols);
		
		// 調整欄位寬度
		TableColumnModel cModel = jTable.getColumnModel();
		TableColumn colID = cModel.getColumn(0);
		TableColumn colName = cModel.getColumn(1);
		TableColumn colType = cModel.getColumn(2);
		TableColumn colAvg = cModel.getColumn(3);
		colID.setPreferredWidth(30);
		colName.setPreferredWidth(120);
		colType.setPreferredWidth(60);
		colAvg.setPreferredWidth(30);
		
		log = new JTextArea();
		log.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		log.setForeground(Color.black);
		log.setBackground(Color.ORANGE);
		log.setBounds(22, 405, 379, 147);
		getContentPane().add(log);

		// ---價格篩選---
		ran = new JLabel("Price Range");
		ran.setForeground(Color.WHITE);
		ran.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 24));
		ran.setBounds(23, 16, 294, 43);
		getContentPane().add(ran);
		
		num1 = new JTextField();
		num1.setHorizontalAlignment(SwingConstants.CENTER);
		num1.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 18));
		num1.setForeground(Color.black);
		num1.setBackground(Color.ORANGE);
		num1.setBounds(22, 66, 96, 46);
		getContentPane().add(num1);
		num1.setColumns(10);
		
		num2 = new JTextField();
		num2.setHorizontalAlignment(SwingConstants.CENTER);
		num2.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 18));
		num2.setColumns(10);
		num2.setForeground(Color.black);
		num2.setBackground(Color.ORANGE);
		num2.setBounds(200, 66, 96, 46);
		getContentPane().add(num2);
		
		JLabel info = new JLabel("Restaurant Information");
		info.setForeground(Color.white);
		info.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 20));
		info.setBounds(22, 365, 265, 43);
		getContentPane().add(info);
		
		to = new JLabel("～");
		to.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		to.setForeground(Color.WHITE);
		to.setBounds(151, 68, 81, 43);
		getContentPane().add(to);
		
		submit = new JButton("Go");
		submit.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 20));
		submit.setBackground(Color.ORANGE);
		submit.setForeground(Color.BLACK);
		submit.addActionListener(this);

		submit.setBounds(316, 69, 81, 42);
		getContentPane().add(submit);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 122, 379, 130);
		getContentPane().add(scrollPane);
		
		outputTextArea = new JTextArea();
		scrollPane.setViewportView(outputTextArea);
		outputTextArea.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		outputTextArea.setForeground(Color.black);
		outputTextArea.setBackground(Color.ORANGE);
		
		outputTextAreaOnly = new JTextArea();
		outputTextAreaOnly.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		outputTextAreaOnly.setForeground(Color.black);
		outputTextAreaOnly.setBackground(Color.ORANGE);
		outputTextAreaOnly.setBounds(22, 302, 379, 51);
		getContentPane().add(outputTextAreaOnly);
		
		JLabel Daily = new JLabel("Daily Selected");
		Daily.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 20));
		Daily.setForeground(Color.WHITE);
		Daily.setBounds(23, 260, 265, 43);
		getContentPane().add(Daily);
		
		JButton add = new JButton("Add");
		add.addActionListener(new faddActionListener());
		
		add.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 18));
		add.setForeground(Color.BLACK);
		add.setBackground(Color.ORANGE);
		add.setBounds(22, 562, 165, 42);
		getContentPane().add(add);
		
		JButton del = new JButton("Del");
		del.addActionListener(new delActionListener());		
		del.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 18));
		del.setForeground(Color.BLACK);
		del.setBackground(Color.ORANGE);
		del.setBounds(222, 562, 175, 42);
		getContentPane().add(del);
		
		JButton menuFood = new JButton("Menu");
		menuFood.addActionListener(new menuFoodActionListener());		
		menuFood.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 18));
		menuFood.setForeground(Color.BLACK);
		menuFood.setBackground(Color.ORANGE);
		menuFood.setBounds(22, 623, 88, 42);
		getContentPane().add(menuFood);
		
		JButton mapM = new JButton("Google Map");
		mapM.addActionListener(new mapMActionListener());
		mapM.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 18));
		mapM.setForeground(Color.BLACK);
		mapM.setBackground(Color.ORANGE);
		mapM.setBounds(126, 623, 129, 42);
		getContentPane().add(mapM);
		
		JButton ubereats = new JButton("Ubereats");
		ubereats.addActionListener(new ubereatsActionListener()); 
		ubereats.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 18));
		ubereats.setForeground(Color.BLACK);
		ubereats.setBackground(Color.ORANGE);
		ubereats.setBounds(268, 623, 129, 42);
		getContentPane().add(ubereats);
		
		//hidden
		JButton icantsee = new JButton("New button");
		icantsee.setBounds(412, 576, 22, 23);
		getContentPane().add(icantsee);

		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBackground(Color.WHITE);
		getContentPane().setBackground(Color.BLACK);
		setSize(1041, 725);
		getContentPane().setLayout(null);
		
		//----視窗置中---
		java.awt.Dimension scr_size =
				   java.awt.Toolkit.getDefaultToolkit().getScreenSize();
				setLocation(
				   (scr_size.width - getWidth()) / 2,
				   (scr_size.height - getHeight()) / 2);
		
		// ------顯示詳細餐廳資訊------------------
		jTable.getSelectionModel().addListSelectionListener(new jTableListSelectionListener());
		
	}
	
	class jTableListSelectionListener implements ListSelectionListener {
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
							String ftime = rs.getString("ftime");
							String fclose = rs.getString("fclose");
							String menu = rs.getString("menu");

							// 清空上一行
							logmouseClicked(null);

							// 加入點選
							log.append(String.format("店名： %s \n電話：%s \n地址： %s\n營業時間： %s\n公休日： %s", fname, tel, addr, ftime, fclose));
//							System.out.println();
						}
					} catch (SQLException ea) {
						System.out.println(ea.toString());
					}	}}	}	}
	
	
	class faddActionListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(null, "Are you sure you want to add a data?", "Add", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
					new WinAdd();
//					setVisible(true);
		        } else {
		        	new main();
//		        	setVisible(false);
		        }
				setVisible(false);
			}
		}
	
	class delActionListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				String rtId = JOptionPane.showInputDialog("Please input the restaurant ID.");
				if (JOptionPane.showConfirmDialog(null, "Are you sure???", "Add", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
					if (rtId != null){
//						new WinDel(rtId);
						try {
							Properties prop = new Properties();
							prop.put("user", "root");
							prop.put("password", "root");
							Connection conn = DriverManager.getConnection(
									"jdbc:mysql://localhost:3306/whateat", prop);

							Statement stmt = conn.createStatement();

							String sql = "DELETE FROM food WHERE id =" + rtId;
							System.out.println(rtId);
							
							int n = stmt.executeUpdate(sql);
							
							System.out.println("成功刪除" + n + "筆資料");
							
							new main();
							
						} catch (SQLException ed) {
							System.out.println(ed.toString());
						}
						
			        } else {
			        	System.out.println("no");
			        	new main();
//			        	new ttmap();
//			        	setVisible(false);
			        }
					setVisible(false);
		        } else {
		        	new main();
//		        	setVisible(false);
		        }
				setVisible(false);
				
				
			}
		}
	
	class menuFoodActionListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				String rtId = JOptionPane.showInputDialog("Do you want to download the menu?");
				if (rtId != null){
					try {
						Properties prop = new Properties();
						prop.put("user", "root");
						prop.put("password", "root");

						Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/whateat", prop);

						String sql = "SELECT i.menu FROM info as i WHERE id =" + rtId;
						PreparedStatement pstmt = conn.prepareStatement(sql);
						ResultSet rs = pstmt.executeQuery();

						while (rs.next()) {
							String imenu = rs.getString("menu");
							System.out.println(imenu);
							
							try {
								URL url = new URL(imenu);
								HttpURLConnection connu = (HttpURLConnection) url.openConnection();
								connu.connect();

								try (BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream("dowdow/now.jpg"));
									 BufferedInputStream bin = new BufferedInputStream(connu.getInputStream());) {
									byte[] buf = new byte[1024 * 1024];
									int len;
									while ((len = bin.read(buf)) != -1) {
										bout.write(buf, 0, len);
									}
									bout.flush();
									System.out.println("下載成功");
									
								} catch (Exception em) {
									System.out.println(em.toString());
								}

							} catch (Exception eu) {
								// TODO Auto-generated catch block
								eu.printStackTrace();
							}
						}
						
					} catch (SQLException ed) {
						System.out.println(ed.toString());
					}
					new main();
					new imgDisplay();
					
		        } else {
		        	System.out.println("no");
		        	new main();
//		        	setVisible(false);
		        }
				setVisible(false);
			}
		}
	
	class mapMActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
//			new mainMap(24.156848810260875,120.64589564646003);
			String rtId = JOptionPane.showInputDialog("Which map do you want to see?");
			Double lng = null;
			Double lat = null;
			
			if (rtId != null){
			try {
				Properties prop = new Properties();
				prop.put("user", "root");
				prop.put("password", "root");

				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/whateat", prop);

				String sql = "SELECT * FROM info WHERE ID = " + rtId;
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();

				while (rs.next()) {
//					String id = rs.getString("id");
					lng = rs.getDouble("lng");
					lat = rs.getDouble("lat");
					System.out.println(String.format("%s:%s", lng, lat));
				}
			} catch (SQLException elat) {
				System.out.println(elat.toString());
			}
			
			new mainMap(lng,lat);
			
			System.out.println(lng + ":" + lat);
			
			} else {
	        	System.out.println("no");
	        }
			setVisible(true);		
		}
	}
	
	
	class ubereatsActionListener implements ActionListener	{
		public void actionPerformed(ActionEvent e) {
			new mainBrowser();
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
		
		try {
			//black
			UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");

        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
				new main();
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
				avgs.add(rs.getString(4));
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
			outputTextAreaOnly.append("＝＝ ※" + ids.get(x) + "." + names.get(x) + "－均消：" + avgs.get(x) + "元 ＝＝" );

		} catch (SQLException ea) {
			System.out.println(ea.toString());
		}
	}


}