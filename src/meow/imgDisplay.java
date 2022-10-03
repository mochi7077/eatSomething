package meow;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

public class imgDisplay extends JInternalFrame {

	public imgDisplay() {
		super();

		JFrame frame = new JFrame("Menu");

		frame.setVisible(true);
		frame.setSize(650, 650);
		frame.setLocationRelativeTo(null);

		
		System.out.println(System.getProperty("user.dir"));  
		
		ImageIcon icon = new ImageIcon(System.getProperty("user.dir") + "\\dowdow\\now.jpg");
		JLabel lab = new JLabel(icon);
		JScrollPane jsp = new JScrollPane(lab);
		frame.add(jsp);


	}
}
