package maybe;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.JTextField;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import java.awt.GridLayout;
import javax.swing.SpringLayout;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class DrWinAdd {

	private JFrame frame;
	private JTextField afNameText;
	private JTextField afAvgText;
	private JTextField afTelText;
	private JTextField afAddrText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DrWinAdd window = new DrWinAdd();
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
	public DrWinAdd() {
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
		
		JLabel afName = new JLabel("餐廳名稱：");
		afName.setBackground(Color.BLACK);
		afName.setForeground(Color.WHITE);
		afName.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		afName.setBounds(10, 10, 123, 49);
		frame.getContentPane().add(afName);
		
		JLabel afAvg = new JLabel("平均消費：");
		afAvg.setForeground(Color.WHITE);
		afAvg.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		afAvg.setBounds(10, 70, 123, 49);
		frame.getContentPane().add(afAvg);
		
		JLabel afAddr = new JLabel("餐廳地址：");
		afAddr.setForeground(Color.WHITE);
		afAddr.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		afAddr.setBounds(10, 142, 123, 49);
		frame.getContentPane().add(afAddr);
		
		JLabel afType = new JLabel("餐廳類別：");
		afType.setForeground(Color.WHITE);
		afType.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		afType.setBounds(267, 10, 123, 49);
		frame.getContentPane().add(afType);
		
		JLabel afTel = new JLabel("餐廳電話：");
		afTel.setForeground(Color.WHITE);
		afTel.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		afTel.setBounds(267, 70, 123, 49);
		frame.getContentPane().add(afTel);
		
		afNameText = new JTextField();
		afNameText.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		afNameText.setBackground(Color.ORANGE);
		afNameText.setBounds(105, 23, 152, 27);
		frame.getContentPane().add(afNameText);
		afNameText.setColumns(10);
		
		afAvgText = new JTextField();
		afAvgText.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		afAvgText.setBackground(Color.ORANGE);
		afAvgText.setColumns(10);
		afAvgText.setBounds(105, 86, 152, 27);
		frame.getContentPane().add(afAvgText);
		
		JComboBox afTypeBox = new JComboBox();
		afTypeBox.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		afTypeBox.setBackground(Color.ORANGE);
		afTypeBox.setBounds(372, 25, 189, 28);
		frame.getContentPane().add(afTypeBox);
		
		afTelText = new JTextField();
		afTelText.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		afTelText.setBackground(Color.ORANGE);
		afTelText.setColumns(10);
		afTelText.setBounds(372, 86, 189, 27);
		frame.getContentPane().add(afTelText);
		
		JComboBox afAddrBox1 = new JComboBox();
		afAddrBox1.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		afAddrBox1.setModel(new DefaultComboBoxModel(new String[] {"臺中市", "臺北市", "新北市", "桃園市", "臺南市", "高雄市", "新竹市", "新竹縣", "苗栗縣", "彰化縣", "南投縣", "雲林縣", "嘉義市", "嘉義縣", "屏東縣", "宜蘭縣", "花蓮縣", "臺東縣", "澎湖縣", "金門縣", "連江縣", "基隆市"}));
		afAddrBox1.setBackground(Color.ORANGE);
		afAddrBox1.setBounds(105, 157, 94, 28);
		frame.getContentPane().add(afAddrBox1);
		
		JComboBox afAddrBox2 = new JComboBox();
		afAddrBox2.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		afAddrBox2.setModel(new DefaultComboBoxModel(new String[] {"中區", "東區", "西區", "南區", "北區", "西屯區", "南屯區", "北屯區", "豐原區", "大里區", "太平區", "清水區", "沙鹿區", "大甲區", "東勢區", "梧棲區", "烏日區", "神岡區", "大肚區", "大雅區", "后里區", "霧峰區", "潭子區", "龍井區", "外埔區", "和平區", "石岡區", "大安區", "新社區"}));
		afAddrBox2.setBackground(Color.ORANGE);
		afAddrBox2.setBounds(209, 157, 94, 28);
		frame.getContentPane().add(afAddrBox2);
		
		afAddrText = new JTextField();
		afAddrText.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		afAddrText.setBackground(Color.ORANGE);
		afAddrText.setColumns(10);
		afAddrText.setBounds(105, 201, 456, 27);
		frame.getContentPane().add(afAddrText);
		
		JButton afAdd = new JButton("Add");
		afAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		afAdd.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 18));
		afAdd.setBackground(Color.ORANGE);
		afAdd.setBounds(41, 257, 216, 45);
		frame.getContentPane().add(afAdd);
		
		JButton afCancel = new JButton("Cancel");
		afCancel.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 18));
		afCancel.setBackground(Color.ORANGE);
		afCancel.setBounds(345, 257, 216, 45);
		frame.getContentPane().add(afCancel);
	}
}
