package meow;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import maybe.DrWinAdd;

public class WinDel extends JFrame{
	private JFrame frame;
	private JTextField dfNameText;
	private JTextField dfAvgText;
	private JTextField dfTelText;
	private JTextField dfAddrText;
	private int i;
	
	

	 private static final JDesktopPane DESKTOP_PANE = new JDesktopPane();
	 

	    public WinDel(String rtId) {
	    	this.dfNameText = dfNameText;
	    	

	        
	        initDB();
	        //---------------------------
	        i = Integer.parseInt(rtId);
	        dfNameText.setText("123");
	        
//	        try {
//				Properties prop = new Properties();
//				prop.put("user", "root");
//				prop.put("password", "root");
//
//				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/whateat", prop);
//				
//				String sql = "SELECT * FROM info WHERE ID = " + (i + 1);
//					
//				PreparedStatement pstmt = conn.prepareStatement(sql);
//				ResultSet rs = pstmt.executeQuery();
//				
//				System.out.println(rs);
//				
////				ArrayList<String> ids = new ArrayList<String>();
////				ArrayList<String> names = new ArrayList<String>();
////				ArrayList<String> avgs = new ArrayList<String>();
//				
//				while (rs.next()) {
//					String id = rs.getString("id");
//					String fname = rs.getString("fname");
////					String favg = rs.getString("favg");
//
////					ids.add(rs.getString(1));
////					names.add(rs.getString(2));
////					avgs.add(rs.getString(4));
////					dfNameText.setText(String.format("店名： %s \n", id));
//					
//
//				}
////		        System.out.println(rtId);
//				
//			} catch (SQLException ea) {
//				System.out.println(ea.toString());
//			}
	        //-------------------------------------------------------------
	        

        
	        frame = new JFrame();
			frame.getContentPane().setBackground(Color.BLACK);
			frame.setBounds(100, 100, 652, 369);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(null);
			
			JLabel dfName = new JLabel("餐廳名稱：");
			dfName.setBackground(Color.BLACK);
			dfName.setForeground(Color.WHITE);
			dfName.setFont(new Font("微軟正黑體", Font.BOLD, 18));
			dfName.setBounds(10, 10, 123, 49);
			frame.getContentPane().add(dfName);
			
			JLabel dfAvg = new JLabel("平均消費：");
			dfAvg.setForeground(Color.WHITE);
			dfAvg.setFont(new Font("微軟正黑體", Font.BOLD, 18));
			dfAvg.setBounds(10, 70, 123, 49);
			frame.getContentPane().add(dfAvg);
			
			JLabel dfAddr = new JLabel("餐廳地址：");
			dfAddr.setForeground(Color.WHITE);
			dfAddr.setFont(new Font("微軟正黑體", Font.BOLD, 18));
			dfAddr.setBounds(10, 142, 123, 49);
			frame.getContentPane().add(dfAddr);
			
			JLabel dfType = new JLabel("餐廳類別：");
			dfType.setForeground(Color.WHITE);
			dfType.setFont(new Font("微軟正黑體", Font.BOLD, 18));
			dfType.setBounds(267, 10, 123, 49);
			frame.getContentPane().add(dfType);
			
			JLabel dfTel = new JLabel("餐廳電話：");
			dfTel.setForeground(Color.WHITE);
			dfTel.setFont(new Font("微軟正黑體", Font.BOLD, 18));
			dfTel.setBounds(267, 70, 123, 49);
			frame.getContentPane().add(dfTel);
			
			dfNameText = new JTextField();
			dfNameText.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
			dfNameText.setForeground(Color.BLACK);
			dfNameText.setBackground(Color.GRAY);
			dfNameText.setBounds(105, 23, 152, 27);
			frame.getContentPane().add(dfNameText);
			dfNameText.setColumns(10);
			
			dfAvgText = new JTextField();
			dfAvgText.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
			dfAvgText.setForeground(Color.BLACK);
			dfAvgText.setBackground(Color.GRAY);
			dfAvgText.setColumns(10);
			dfAvgText.setBounds(105, 86, 152, 27);
			frame.getContentPane().add(dfAvgText);
			
			JComboBox dfTypeBox = new JComboBox();
			dfTypeBox.setModel(new DefaultComboBoxModel(new String[] 
					{"西式/牛排", "台菜", "壽喜燒", "素食", "粵菜館", "日本料理", "茶藝館", "中式麵食館", "印度餐廳", "居酒屋", "鐵板燒", "韓式", "義式", "小吃", "泰式", "咖啡輕食", "餐酒館", "素食", "粵菜館", "日本料理", "茶藝館", "中式麵食館", "印度餐廳", "其他"}));
			dfTypeBox.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
			dfTypeBox.setBackground(Color.GRAY);
			dfTypeBox.setForeground(Color.BLACK);
			dfTypeBox.setBounds(372, 25, 189, 28);
			frame.getContentPane().add(dfTypeBox);
			
			dfTelText = new JTextField();
			dfTelText.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
			dfTelText.setBackground(Color.GRAY);
			dfTelText.setForeground(Color.BLACK);
			dfTelText.setColumns(10);
			dfTelText.setBounds(372, 86, 189, 27);
			frame.getContentPane().add(dfTelText);
			
			JComboBox dfAddrBox1 = new JComboBox();
			dfAddrBox1.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
			dfAddrBox1.setModel(new DefaultComboBoxModel(new String[] {"臺中市", "臺北市", "新北市", "桃園市", "臺南市", "高雄市", "新竹市", "新竹縣", "苗栗縣", "彰化縣", "南投縣", "雲林縣", "嘉義市", "嘉義縣", "屏東縣", "宜蘭縣", "花蓮縣", "臺東縣", "澎湖縣", "金門縣", "連江縣", "基隆市"}));
			dfAddrBox1.setBackground(Color.GRAY);
			dfAddrBox1.setForeground(Color.BLACK);
			dfAddrBox1.setBounds(105, 157, 94, 28);
			frame.getContentPane().add(dfAddrBox1);
			
			JComboBox dfAddrBox2 = new JComboBox();
			dfAddrBox2.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
			dfAddrBox2.setModel(new DefaultComboBoxModel(new String[] {"中區", "東區", "西區", "南區", "北區", "西屯區", "南屯區", "北屯區", "豐原區", "大里區", "太平區", "清水區", "沙鹿區", "大甲區", "東勢區", "梧棲區", "烏日區", "神岡區", "大肚區", "大雅區", "后里區", "霧峰區", "潭子區", "龍井區", "外埔區", "和平區", "石岡區", "大安區", "新社區"}));
			dfAddrBox2.setBackground(Color.GRAY);
			dfAddrBox2.setForeground(Color.BLACK);
			dfAddrBox2.setBounds(209, 157, 94, 28);
			frame.getContentPane().add(dfAddrBox2);
			
			dfAddrText = new JTextField();
			dfAddrText.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
			dfAddrText.setForeground(Color.BLACK);
			dfAddrText.setBackground(Color.GRAY);
			dfAddrText.setColumns(10);
			dfAddrText.setBounds(105, 201, 456, 27);
			frame.getContentPane().add(dfAddrText);
			
			JButton dfDel = new JButton("Del");
			dfDel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			dfDel.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 18));
			dfDel.setForeground(Color.red);
			dfDel.setBackground(Color.ORANGE);
			dfDel.setBounds(30, 257, 152, 45);
			frame.getContentPane().add(dfDel);
			
			JButton dfEdit = new JButton("Edit");
			dfEdit.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 18));
			dfEdit.setForeground(Color.red);
			dfEdit.setBackground(Color.ORANGE);
			dfEdit.setBounds(220, 257, 152, 45);
			frame.getContentPane().add(dfEdit);
			
			JButton dfClose = new JButton("Close");
			dfClose.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.dispose();
					new main();
				}
			});
			dfClose.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 18));
			dfClose.setForeground(Color.red);
			dfClose.setBackground(Color.ORANGE);
			dfClose.setBounds(409, 257, 152, 45);
			frame.getContentPane().add(dfClose);
		
			frame.setLocationRelativeTo(null);
			frame.getContentPane().add(DESKTOP_PANE);
	        frame.setVisible(true);
	        
	    }
	    
	    private void initDB() {
			Properties prop = new Properties();
			prop.put("user", "root");
			prop.put("password", "root");

			try {
				Properties ppa = new Properties();
				ppa.put("user", "root");
				ppa.put("password", "root");

				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/whateat", ppa);

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


					// 加入點選
//					log.append(String.format("店名： %s \n電話：%s \n地址： %s\n營業時間： %s\n公休日： %s", fname, tel, addr, ftime, fclose));

				}
			} catch (Exception e) {
				System.out.println(e.toString());
			}
			
			try {
				//black
				UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");

	        } catch (ClassNotFoundException ex) {
	            java.util.logging.Logger.getLogger(WinDel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (InstantiationException ex) {
	            java.util.logging.Logger.getLogger(WinDel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (IllegalAccessException ex) {
	            java.util.logging.Logger.getLogger(WinDel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
	            java.util.logging.Logger.getLogger(WinDel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        }
		}

	    public static void main(String[] args) {
//	        new jf_b();
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
//						WinDel window = new WinDel();
//						window.frame.setVisible(true);
						new WinDel(null);
						
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
	    }
	}