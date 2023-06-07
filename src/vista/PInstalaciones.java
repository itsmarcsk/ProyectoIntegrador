package vista;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class PInstalaciones extends JPanel{
	

	public PInstalaciones () {
		
		init();
	}

	private void init() {
		// TODO Auto-generated method stub
		setSize(1920, 984);
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 1920, 984);
		add(scrollPane);
		
		try {
			
			BufferedImage myPicture;
			myPicture = ImageIO.read(new File("img/mapaActu.png"));
			JLabel picLabel = new JLabel(new ImageIcon(myPicture));
			scrollPane.setViewportView(picLabel);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}