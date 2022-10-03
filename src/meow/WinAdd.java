package meow;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
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

import maybe.DrWinAdd;

public class WinAdd extends JFrame {
	private JFrame frame;
	private JTextField afNameText;
	private JTextField afAvgText;
	private JTextField afTelText;
	private JTextField afAddrText;
	private JLabel afName;
	private JLabel afAvg;
	private JLabel afAddr;
	private JLabel afType;
	private JLabel afTel;
	private JComboBox afTypeBox;
	private JComboBox afAddrBox1;
	private JComboBox afAddrBox2;
	private JTextField afTelArea;
	private JLabel afTelDe;

	private static final JDesktopPane DESKTOP_PANE = new JDesktopPane();

	public WinAdd() {
		super("Add");

		frame = new JFrame();
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setBounds(100, 100, 652, 369);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		afName = new JLabel("餐廳名稱：");
		afName.setBackground(Color.BLACK);
		afName.setForeground(Color.WHITE);
		afName.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		afName.setBounds(10, 10, 123, 49);
		frame.getContentPane().add(afName);

		afAvg = new JLabel("平均消費：");
		afAvg.setForeground(Color.WHITE);
		afAvg.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		afAvg.setBounds(10, 70, 123, 49);
		frame.getContentPane().add(afAvg);

		afAddr = new JLabel("餐廳地址：");
		afAddr.setForeground(Color.WHITE);
		afAddr.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		afAddr.setBounds(10, 142, 123, 49);
		frame.getContentPane().add(afAddr);

		afType = new JLabel("餐廳類別：");
		afType.setForeground(Color.WHITE);
		afType.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		afType.setBounds(267, 10, 123, 49);
		frame.getContentPane().add(afType);

		afTel = new JLabel("餐廳電話：");
		afTel.setForeground(Color.WHITE);
		afTel.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		afTel.setBounds(267, 74, 123, 49);
		frame.getContentPane().add(afTel);

		afNameText = new JTextField();
		afNameText.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		afNameText.setForeground(Color.BLACK);
		afNameText.setBackground(Color.ORANGE);
		afNameText.setBounds(105, 23, 152, 27);
		frame.getContentPane().add(afNameText);
		afNameText.setColumns(10);

		afAvgText = new JTextField();
		afAvgText.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		afAvgText.setForeground(Color.BLACK);
		afAvgText.setBackground(Color.ORANGE);
		afAvgText.setColumns(10);
		afAvgText.setBounds(105, 86, 152, 27);
		frame.getContentPane().add(afAvgText);

		afTypeBox = new JComboBox();
		afTypeBox.setModel(new DefaultComboBoxModel(new String[] { "西式/牛排", "台菜", "壽喜燒", "燒肉", "素食", "粵菜館", "日本料理",
				"茶藝館", "中式麵食館", "印度餐廳", "居酒屋", "鐵板燒", "法式", "美式", "韓式", "義式", "泰式", "咖啡輕食", "餐酒館", "其他" }));
		afTypeBox.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		afTypeBox.setForeground(Color.BLACK);
		afTypeBox.setBackground(Color.ORANGE);
		afTypeBox.setBounds(372, 25, 189, 28);
		frame.getContentPane().add(afTypeBox);

		afTelText = new JTextField();
		afTelText.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		afTelText.setForeground(Color.BLACK);
		afTelText.setBackground(Color.ORANGE);
		afTelText.setColumns(10);
		afTelText.setBounds(446, 86, 115, 27);
		frame.getContentPane().add(afTelText);
		// -----------------------------------------------------------------

		String[] restTypeArr = new String[] { "臺中市", "臺北市", "新北市", "桃園市", "臺南市", "高雄市", "新竹市", "新竹縣", "苗栗縣", "彰化縣",
				"南投縣", "雲林縣", "嘉義市", "嘉義縣", "屏東縣", "宜蘭縣", "花蓮縣", "臺東縣", "澎湖縣", "金門縣", "連江縣", "基隆市" };
		afAddrBox1 = new JComboBox();
		afAddrBox1.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		DefaultComboBoxModel restType = new DefaultComboBoxModel(restTypeArr);
		afAddrBox1.setModel(restType);

		afAddrBox1.setBackground(Color.ORANGE);
		afAddrBox1.setForeground(Color.BLACK);
		afAddrBox1.setBounds(105, 157, 94, 28);
		frame.getContentPane().add(afAddrBox1);

		afAddrBox2 = new JComboBox();
		afAddrBox2.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		afAddrBox2.setBackground(Color.ORANGE);
		afAddrBox2.setForeground(Color.BLACK);
		afAddrBox2.setBounds(209, 157, 94, 28);
		frame.getContentPane().add(afAddrBox2);

		afAddrText = new JTextField();
		afAddrText.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		afAddrText.setForeground(Color.BLACK);
		afAddrText.setBackground(Color.ORANGE);
		afAddrText.setColumns(10);
		afAddrText.setBounds(105, 201, 456, 27);
		frame.getContentPane().add(afAddrText);
//-------------------------------------------------------------------------
		String[] Detaiching = new String[] { "南屯區", "中區", "東區", "西區", "南區", "北區", "西屯區", "北屯區", "豐原區", "大里區", "太平區",
				"清水區", "沙鹿區", "大甲區", "東勢區", "梧棲區", "烏日區", "神岡區", "大肚區", "大雅區", "后里區", "霧峰區", "潭子區", "龍井區", "外埔區", "和平區",
				"石岡區", "大安區", "新社區" };

		DefaultComboBoxModel typeC = new DefaultComboBoxModel(Detaiching);
		afAddrBox2.setModel(typeC);

//-------------------------------------------------------------------------			
		DefaultComboBoxModel Taiching = new DefaultComboBoxModel(Detaiching);

		DefaultComboBoxModel Taipei = new DefaultComboBoxModel(
				new String[] { "中正區", "大同區", "中山區", "萬華區", "信義區", "松山區", "大安區", "南港區", "北投區", "內湖區", "士林區", "文山區" });

		DefaultComboBoxModel NewTaipei = new DefaultComboBoxModel(new String[] { "板橋區", "三重區", "中和區", "永和區", "新莊區",
				"新店區", "土城區", "蘆洲區", "樹林區", "汐止區", "鶯歌區", "三峽區", "淡水區", "瑞芳區", "五股區", "泰山區", "林口區", "深坑區", "石碇區", "坪林區",
				"三芝區", "石門區", "八里區", "平溪區", "雙溪區", "貢寮區", "金山區", "萬里區", "烏來區" });

		DefaultComboBoxModel Keelung = new DefaultComboBoxModel(
				new String[] { "仁愛區", "中正區", "信義區", "安樂區", "中山區", "七堵區", "暖暖區" });

		DefaultComboBoxModel Taoyuan = new DefaultComboBoxModel(new String[] { "桃園區", "中壢區", "平鎮區", "八德區", "楊梅區", "蘆竹區",
				"龜山區", "龍潭區", "大溪區", "大園區", "觀音區", "新屋區", "復興區" });

		DefaultComboBoxModel HsinchuCounty = new DefaultComboBoxModel(new String[] { "竹北市", "竹東鎮", "新埔鎮", "關西鎮", "峨眉鄉",
				"寶山鄉", "北埔鄉", "橫山鄉", "芎林鄉", "湖口鄉", "新豐鄉", "尖石鄉", "五峰鄉" });

		DefaultComboBoxModel HsinchuCity = new DefaultComboBoxModel(new String[] { "東區", "北區", "香山區" });

		DefaultComboBoxModel Miaoli = new DefaultComboBoxModel(new String[] { "苗栗市", "通霄鎮", "苑裡鎮", "竹南鎮", "頭份鎮", "後龍鎮",
				"卓蘭鎮", "西湖鄉", "頭屋鄉", "公館鄉", "銅鑼鄉", "三義鄉", "造橋鄉", "三灣鄉", "南庄鄉", "大湖鄉", "獅潭鄉", "泰安鄉" });

		DefaultComboBoxModel Nantou = new DefaultComboBoxModel(new String[] { "南投市", "埔里鎮", "草屯鎮", "竹山鎮", "集集鎮", "名間鄉",
				"鹿谷鄉", "中寮鄉", "魚池鄉", "國姓鄉", "水里鄉", "信義鄉", "仁愛鄉" });

		DefaultComboBoxModel Changhua = new DefaultComboBoxModel(new String[] { "彰化市", "員林鎮", "和美鎮", "鹿港鎮", "溪湖鎮",
				"二林鎮", "田中鎮", "北斗鎮", "花壇鄉", "芬園鄉", "大村鄉", "永靖鄉", "伸港鄉", "線西鄉", "福興鄉", "秀水鄉", "埔心鄉", "埔鹽鄉", "大城鄉", "芳苑鄉",
				"竹塘鄉", "社頭鄉", "二水鄉", "田尾鄉", "埤頭鄉", "溪州鄉" });

		DefaultComboBoxModel Yunlin = new DefaultComboBoxModel(new String[] { "斗六市", "斗南鎮", "虎尾鎮", "西螺鎮", "土庫鎮", "北港鎮",
				"莿桐鄉", "林內鄉", "古坑鄉", "大埤鄉", "崙背鄉", "二崙鄉", "麥寮鄉", "臺西鄉", "東勢鄉", "褒忠鄉", "四湖鄉", "口湖鄉", "水林鄉", "元長鄉" });

		DefaultComboBoxModel ChiayiCounty = new DefaultComboBoxModel(new String[] { "太保市", "朴子市", "布袋鎮", "大林鎮", "民雄鄉",
				"溪口鄉", "新港鄉", "六腳鄉", "東石鄉", "義竹鄉", "鹿草鄉", "水上鄉", "中埔鄉", "竹崎鄉", "梅山鄉", "番路鄉", "大埔鄉", "阿里山鄉" });

		DefaultComboBoxModel ChiayiCity = new DefaultComboBoxModel(new String[] { "東區", "西區" });

		DefaultComboBoxModel Tainan = new DefaultComboBoxModel(
				new String[] { "中西區", "東區", "南區", "北區", "安平區", "安南區", "永康區", "歸仁區", "新化區", "左鎮區", "玉井區", "楠西區", "南化區",
						"仁德區", "關廟區", "龍崎區", "官田區", "麻豆區", "佳里區", "西港區", "七股區", "將軍區", "學甲區", "北門區", "新營區", "後壁區",
						"白河區", "東山區", "六甲區", "下營區", "柳營區", "鹽水區", "善化區", "大內區", "山上區", "新市區", "安定區" });

		DefaultComboBoxModel Kaohsiung = new DefaultComboBoxModel(
				new String[] { "楠梓區", "左營區", "鼓山區", "三民區", "鹽埕區", "前金區", "新興區", "苓雅區", "前鎮區", "小港區", "旗津區", "鳳山區",
						"大寮區", "鳥松區", "林園區", "仁武區", "大樹區", "大社區", "岡山區", "路竹區", "橋頭區", "梓官區", "彌陀區", "永安區", "燕巢區",
						"田寮區", "阿蓮區", "茄萣區", "湖內區", "旗山區", "美濃區", "內門區", "杉林區", "甲仙區", "六龜區", "茂林區", "桃源區", "那瑪夏區" });

		DefaultComboBoxModel Pingtung = new DefaultComboBoxModel(new String[] { "屏東市", "潮州鎮", "東港鎮", "恆春鎮", "萬丹鄉",
				"長治鄉", "麟洛鄉", "九如鄉", "里港鄉", "鹽埔鄉", "高樹鄉", "萬巒鄉", "內埔鄉", "竹田鄉", "新埤鄉", "枋寮鄉", "新園鄉", "崁頂鄉", "林邊鄉", "南州鄉",
				"佳冬鄉", "琉球鄉", "車城鄉", "滿州鄉", "枋山鄉", "霧台鄉", "瑪家鄉", "泰武鄉", "來義鄉", "春日鄉", "獅子鄉", "牡丹鄉", "三地門鄉" });

		DefaultComboBoxModel Yilan = new DefaultComboBoxModel(
				new String[] { "宜蘭市", "羅東鎮", "蘇澳鎮", "頭城鎮", "礁溪鄉", "壯圍鄉", "員山鄉", "冬山鄉", "五結鄉", "三星鄉", "大同鄉", "南澳鄉" });

		DefaultComboBoxModel Hualien = new DefaultComboBoxModel(new String[] { "花蓮市", "鳳林鎮", "玉里鎮", "新城鄉", "吉安鄉", "壽豐鄉",
				"秀林鄉", "光復鄉", "豐濱鄉", "瑞穗鄉", "萬榮鄉", "富里鄉", "卓溪鄉" });

		DefaultComboBoxModel Taitung = new DefaultComboBoxModel(new String[] { "臺東市", "成功鎮", "關山鎮", "長濱鄉", "海端鄉", "池上鄉",
				"東河鄉", "鹿野鄉", "延平鄉", "卑南鄉", "金峰鄉", "大武鄉", "達仁鄉", "綠島鄉", "蘭嶼鄉", "太麻里鄉" });

		DefaultComboBoxModel Penghu = new DefaultComboBoxModel(
				new String[] { "馬公市", "湖西鄉", "白沙鄉", "西嶼鄉", "望安鄉", "七美鄉" });

		DefaultComboBoxModel Kinmen = new DefaultComboBoxModel(
				new String[] { "金城鎮", "金湖鎮", "金沙鎮", "金寧鄉", "烈嶼鄉", "烏坵鄉" });

		DefaultComboBoxModel Lianjiang = new DefaultComboBoxModel(new String[] { "南竿鄉", "北竿鄉", "莒光鄉", "東引鄉" });

		afAddrBox1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ("臺中市".equals(afAddrBox1.getSelectedItem())) {
					afAddrBox2.setModel(Taiching);
				}
				if ("臺北市".equals(afAddrBox1.getSelectedItem())) {
					afAddrBox2.setModel(Taipei);
				}
				if ("新北市".equals(afAddrBox1.getSelectedItem())) {
					afAddrBox2.setModel(NewTaipei);
				}
				if ("基隆市".equals(afAddrBox1.getSelectedItem())) {
					afAddrBox2.setModel(Keelung);
				}
				if ("桃園市".equals(afAddrBox1.getSelectedItem())) {
					// set the appropriate model here
					afAddrBox2.setModel(Taoyuan);
				}
				if ("臺南市".equals(afAddrBox1.getSelectedItem())) {
					// set the appropriate model here
					afAddrBox2.setModel(Taiching);
				}
				if ("高雄市".equals(afAddrBox1.getSelectedItem())) {
					// set the appropriate model here
					afAddrBox2.setModel(Kaohsiung);
				}
				if ("新竹市".equals(afAddrBox1.getSelectedItem())) {
					// set the appropriate model here
					afAddrBox2.setModel(HsinchuCity);
				}
				if ("新竹縣".equals(afAddrBox1.getSelectedItem())) {
					// set the appropriate model here
					afAddrBox2.setModel(HsinchuCounty);
				if ("苗栗縣".equals(afAddrBox1.getSelectedItem())) {
					// set the appropriate model here
					afAddrBox2.setModel(Miaoli);
				}
				if ("彰化縣".equals(afAddrBox1.getSelectedItem())) {
					// set the appropriate model here
					afAddrBox2.setModel(Changhua);
				}
				if ("南投縣".equals(afAddrBox1.getSelectedItem())) {
					// set the appropriate model here
					afAddrBox2.setModel(Nantou);
				}
				if ("雲林縣".equals(afAddrBox1.getSelectedItem())) {
					// set the appropriate model here
					afAddrBox2.setModel(Yunlin);
				}
				if ("嘉義市".equals(afAddrBox1.getSelectedItem())) {
					// set the appropriate model here
					afAddrBox2.setModel(ChiayiCity);
				}
				if ("嘉義縣".equals(afAddrBox1.getSelectedItem())) {
					// set the appropriate model here
					afAddrBox2.setModel(ChiayiCounty);
				}
				if ("屏東縣".equals(afAddrBox1.getSelectedItem())) {
					// set the appropriate model here
					afAddrBox2.setModel(Pingtung);
				}
				if ("宜蘭縣".equals(afAddrBox1.getSelectedItem())) {
					// set the appropriate model here
					afAddrBox2.setModel(Yilan);
				}
				if ("花蓮縣".equals(afAddrBox1.getSelectedItem())) {
					// set the appropriate model here
					afAddrBox2.setModel(Hualien);
				}
				if ("臺東縣".equals(afAddrBox1.getSelectedItem())) {
					// set the appropriate model here
					afAddrBox2.setModel(Taitung);
				}
				if ("澎湖縣".equals(afAddrBox1.getSelectedItem())) {
					// set the appropriate model here
					afAddrBox2.setModel(Penghu);
				}
				if ("金門縣".equals(afAddrBox1.getSelectedItem())) {
					// set the appropriate model here
					afAddrBox2.setModel(Kinmen);
				}
				if ("連江縣".equals(afAddrBox1.getSelectedItem())) {
					// set the appropriate model here
					afAddrBox2.setModel(Lianjiang);
				}

				} else {
					
				}
			}
		});

		JButton afAdd = new JButton("Add");
		afAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String UafName = afNameText.getText();
				String UafType = (String) afTypeBox.getSelectedItem();
				String UafAvg = afAvgText.getText();
				String TelArea = afTelArea.getText();

				String UafTel = afTelText.getText();
				String UafTelFront = UafTel.substring(0, 4);
				String UafTelBack = UafTel.substring(4, 8);
				String UafTelOnly = "(" + TelArea + ")" + "-" + UafTelFront + "-" + UafTelBack;

				String UafAddr1 = (String) afAddrBox1.getSelectedItem();
				String UafAddr2 = (String) afAddrBox2.getSelectedItem();
				String UafAddrT = afAddrText.getText();
				String UafAddrOnly = UafAddr1 + UafAddr2 + UafAddrT;
//					System.out.println(UafAddrOnly);

//					 System.out.println(UafName);
//					 System.out.println(UafType);
				
				if (JOptionPane.showConfirmDialog(null, "Are they correct?", "Add", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
					try {
						Properties prop = new Properties();
						prop.put("user", "root");
						prop.put("password", "root");
						Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/whateat", prop);


						Statement stmt = conn.createStatement();
						String sqlfood = "INSERT INTO food (fname, ftype, favg) VALUES" + "('" + UafName + "', '" + UafType
								+ "', '" + UafAvg + "')";

						int n = stmt.executeUpdate(sqlfood);

						String sqlinfo = "INSERT INTO info (fname, tel, addr) VALUES" + "('" + UafName + "', '" + UafTel
								+ "', '" + UafAddrOnly + "')";

						int m = stmt.executeUpdate(sqlinfo);

						System.out.println("成功上傳" + n + "筆food資料");
						System.out.println("成功上傳" + m + "筆info資料");

						JOptionPane.showMessageDialog(null, "Successfully Added!");
						frame.dispose();
						new main();

					} catch (SQLException mama) {
						System.out.println(mama.toString());
					}
		        } else {
		        	new main();
//		        	setVisible(false);
		        }
				setVisible(false);

				
			}

			// ---------------------------------------------------------------------------------------
		});
		afAdd.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 18));
		afAdd.setForeground(Color.BLACK);
		afAdd.setBackground(Color.ORANGE);
		afAdd.setBounds(41, 257, 216, 45);
		frame.getContentPane().add(afAdd);

		JButton afClose = new JButton("Close");
		afClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new main();

			}
		});
		afClose.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 18));
		afClose.setForeground(Color.BLACK);
		afClose.setBackground(Color.ORANGE);
		afClose.setBounds(345, 257, 216, 45);
		frame.getContentPane().add(afClose);

		frame.setLocationRelativeTo(null);
		frame.getContentPane().add(DESKTOP_PANE);

		afTelArea = new JTextField();
		afTelArea.setForeground(Color.BLACK);
		afTelArea.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		afTelArea.setColumns(10);
		afTelArea.setBackground(Color.ORANGE);
		afTelArea.setBounds(372, 86, 42, 27);
		frame.getContentPane().add(afTelArea);

		afTelDe = new JLabel("-");
		afTelDe.setHorizontalAlignment(SwingConstants.CENTER);
		afTelDe.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		afTelDe.setForeground(Color.WHITE);
		afTelDe.setBounds(408, 92, 47, 15);
		frame.getContentPane().add(afTelDe);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WinAdd window = new WinAdd();
					window.frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}