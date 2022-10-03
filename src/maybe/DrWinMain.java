package maybe;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.ScrollPaneConstants;

public class DrWinMain {

	private JFrame frame;
	private JTextField num1;
	private JTextField num2;
	private JTable jTable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DrWinMain window = new DrWinMain();
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
	public DrWinMain() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBackground(Color.WHITE);
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setSize(1041, 725);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel to = new JLabel("～");
		to.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		to.setForeground(Color.WHITE);
		to.setBounds(151, 68, 81, 43);
		frame.getContentPane().add(to);
		
		JButton submit = new JButton("GO");
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		submit.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 20));
		submit.setBackground(Color.WHITE);
		submit.setForeground(Color.DARK_GRAY);
		submit.setBounds(316, 69, 81, 42);
		frame.getContentPane().add(submit);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 122, 379, 130);
		frame.getContentPane().add(scrollPane);
		
		JTextArea outputTextArea = new JTextArea();
		scrollPane.setViewportView(outputTextArea);
		outputTextArea.setBackground(Color.WHITE);
		outputTextArea.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		
		JLabel Daily = new JLabel("Daily Selected");
		Daily.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 20));
		Daily.setForeground(Color.WHITE);
		Daily.setBounds(23, 260, 265, 43);
		frame.getContentPane().add(Daily);
		
		JLabel ran = new JLabel("Price Range");
		ran.setForeground(Color.WHITE);
		ran.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 24));
		ran.setBounds(23, 16, 294, 43);
		frame.getContentPane().add(ran);
		
		JTextArea outputTextAreaOnly = new JTextArea();
		outputTextAreaOnly.setBackground(Color.WHITE);
		outputTextAreaOnly.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		outputTextAreaOnly.setBounds(22, 302, 379, 51);
		frame.getContentPane().add(outputTextAreaOnly);
		
		num1 = new JTextField();
		num1.setHorizontalAlignment(SwingConstants.CENTER);
		num1.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 18));
		num1.setBounds(22, 66, 96, 46);
		frame.getContentPane().add(num1);
		num1.setColumns(10);
		
		num2 = new JTextField();
		num2.setHorizontalAlignment(SwingConstants.CENTER);
		num2.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 18));
		num2.setColumns(10);
		num2.setBounds(200, 66, 96, 46);
		frame.getContentPane().add(num2);
		
		JLabel info = new JLabel("Restaurant Information");
		info.setForeground(Color.WHITE);
		info.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 20));
		info.setBounds(22, 365, 265, 43);
		frame.getContentPane().add(info);
		
		JTextArea log = new JTextArea();
		log.setBackground(Color.WHITE);
		log.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		log.setBounds(22, 405, 379, 147);
		frame.getContentPane().add(log);
		
		JButton add = new JButton("Add");
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		add.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 18));
		add.setBounds(22, 562, 165, 42);
		frame.getContentPane().add(add);
		
		JButton del = new JButton("Del");
		del.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 18));
		del.setBounds(222, 562, 175, 42);
		frame.getContentPane().add(del);
		
		JButton menuFood = new JButton("Menu");
		menuFood.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 18));
		menuFood.setBounds(22, 623, 88, 42);
		frame.getContentPane().add(menuFood);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(440, 36, 558, 629);
		frame.getContentPane().add(scrollPane_1);
		
		jTable = new JTable();
		scrollPane_1.setViewportView(jTable);
		jTable.setForeground(Color.WHITE);
		jTable.setRowHeight(50);//指定每一行的行高50
		jTable.setRowHeight(2, 30);//指定2行的高度30
		jTable.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		jTable.setBorder(new LineBorder(Color.WHITE, 3, true));
		jTable.setBackground(Color.DARK_GRAY);
		
		JButton mapM = new JButton("Google Map");
		mapM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mapM.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 18));
		mapM.setBounds(126, 623, 129, 42);
		frame.getContentPane().add(mapM);
		
		JButton ubereats = new JButton("Ubereats");
		ubereats.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		ubereats.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 18));
		ubereats.setBounds(268, 623, 129, 42);
		frame.getContentPane().add(ubereats);
		
		JButton icantsee = new JButton("New button");
		icantsee.setBounds(412, 576, 22, 23);
		frame.getContentPane().add(icantsee);
	
	}
}
