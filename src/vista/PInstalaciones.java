package vista;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PInstalaciones extends JPanel{
	
	private JFrame frame;

	public PInstalaciones () {
		
		init();
	}

	private void init() {
		frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
		JLabel lblNewLabel = new JLabel();
        lblNewLabel.setBounds(10, 10, 414, 242);
        lblNewLabel.setIcon(new ImageIcon("img/mapaActu.jpg"));
        frame.getContentPane().add(lblNewLabel);
	}

}