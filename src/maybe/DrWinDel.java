package maybe;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class DrWinDel {

	private JFrame frame;
	private JTextField dfNameText;
	private JTextField dfAvgText;
	private JTextField dfTelText;
	private JTextField dfAddrText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DrWinDel window = new DrWinDel();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DrWinDel() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
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
		dfNameText.setBackground(Color.GRAY);
		dfNameText.setBounds(105, 23, 152, 27);
		frame.getContentPane().add(dfNameText);
		dfNameText.setColumns(10);
		
		dfAvgText = new JTextField();
		dfAvgText.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
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
		dfTelText.setColumns(10);
		dfTelText.setBounds(372, 86, 189, 27);
		frame.getContentPane().add(dfTelText);
		
		JComboBox dfAddrBox1 = new JComboBox();
		dfAddrBox1.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		dfAddrBox1.setModel(new DefaultComboBoxModel(new String[] {"臺中市", "臺北市", "新北市", "桃園市", "臺南市", "高雄市", "新竹市", "新竹縣", "苗栗縣", "彰化縣", "南投縣", "雲林縣", "嘉義市", "嘉義縣", "屏東縣", "宜蘭縣", "花蓮縣", "臺東縣", "澎湖縣", "金門縣", "連江縣", "基隆市"}));
		dfAddrBox1.setBackground(Color.GRAY);
		dfAddrBox1.setBounds(105, 157, 94, 28);
		frame.getContentPane().add(dfAddrBox1);
		
		JComboBox dfAddrBox2 = new JComboBox();
		dfAddrBox2.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		dfAddrBox2.setModel(new DefaultComboBoxModel(new String[] {"中區", "東區", "西區", "南區", "北區", "西屯區", "南屯區", "北屯區", "豐原區", "大里區", "太平區", "清水區", "沙鹿區", "大甲區", "東勢區", "梧棲區", "烏日區", "神岡區", "大肚區", "大雅區", "后里區", "霧峰區", "潭子區", "龍井區", "外埔區", "和平區", "石岡區", "大安區", "新社區"}));
		dfAddrBox2.setBackground(Color.GRAY);
		dfAddrBox2.setBounds(209, 157, 94, 28);
		frame.getContentPane().add(dfAddrBox2);
		
		dfAddrText = new JTextField();
		dfAddrText.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		dfAddrText.setBackground(Color.GRAY);
		dfAddrText.setColumns(10);
		dfAddrText.setBounds(105, 201, 456, 27);
		frame.getContentPane().add(dfAddrText);
		
		JButton dfDel = new JButton("Del");
		dfDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//----------------------------------------------------------------------------------
				
				
				
				
				
				
				
				
				
				//-------------------------------------------------------------------------------
			}
		});
		dfDel.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 18));
		dfDel.setBackground(Color.ORANGE);
		dfDel.setBounds(30, 257, 152, 45);
		frame.getContentPane().add(dfDel);
		
		JButton dfEdit = new JButton("Edit");
		dfEdit.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 18));
		dfEdit.setBackground(Color.ORANGE);
		dfEdit.setBounds(220, 257, 152, 45);
		frame.getContentPane().add(dfEdit);
		
		JButton dfClose = new JButton("Close");
		dfClose.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 18));
		dfClose.setBackground(Color.ORANGE);
		dfClose.setBounds(409, 257, 152, 45);
		frame.getContentPane().add(dfClose);
	}
	

}
