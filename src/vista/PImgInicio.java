package vista;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class PImgInicio extends JPanel {
	public PImgInicio() {
		init();
	}

	private void init() {
		// TODO Auto-generated method stub
		setSize(1920,984);
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 1920, 984);
		add(scrollPane);
		
		
		
		try {
			
			BufferedImage myPicture;
			myPicture = ImageIO.read(new File("img/polideportivo.png"));
			
			JLabel lblUsuario = new JLabel(new ImageIcon(myPicture));
			lblUsuario.setBounds(783, 325, 354, 351);
			scrollPane.setViewportView(lblUsuario);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
