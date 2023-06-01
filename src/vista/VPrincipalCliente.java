package vista;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.SwingConstants;
import java.awt.Font;

public class VPrincipalCliente extends JFrame{
	private JMenuItem mntmActividades;
	private JMenuItem mntmInstalaciones;
	
	
	public VPrincipalCliente() {
		getContentPane().setLayout(null);
		this.setExtendedState(this.MAXIMIZED_BOTH);
		init();
	}

	private void init() {
		JMenuBar menuBar = new JMenuBar();
		menuBar.setToolTipText("Menu");
		menuBar.setBounds(0, 0, 102, 22);
		getContentPane().add(menuBar);
		
		JMenu mnMenu = new JMenu("Menu");
		mnMenu.setFont(new Font("Dialog", Font.BOLD, 14));
		menuBar.add(mnMenu);
		
		mntmInstalaciones = new JMenuItem("Instalaciones ");
		mntmInstalaciones.setHorizontalAlignment(SwingConstants.CENTER);
		mntmInstalaciones.setHorizontalTextPosition(SwingConstants.CENTER);
		mntmInstalaciones.setFont(new Font("Arial", Font.PLAIN, 12));
		mnMenu.add(mntmInstalaciones);
		
		mntmActividades = new JMenuItem("Actividades");
		mntmActividades.setFont(new Font("Arial", Font.PLAIN, 12));
		mnMenu.add(mntmActividades);
		
		JMenuItem mntmPerfil = new JMenuItem("Perfil");
		mntmPerfil.setFont(new Font("Arial", Font.PLAIN, 12));
		mnMenu.add(mntmPerfil);
		
		JMenu mnSalir = new JMenu("Salir");
		mnSalir.setFont(new Font("Dialog", Font.BOLD, 14));
		menuBar.add(mnSalir);
		
	}
	
	public void hacerVisible() {
		setVisible(true);
	}
	
	public void mostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje, "Información", JOptionPane.INFORMATION_MESSAGE);

	}

	public void mostrarError(String error) {
		JOptionPane.showMessageDialog(this, error, "Error", JOptionPane.ERROR_MESSAGE);
	}
	public void mostrarAlerta(String alerta) {
		JOptionPane.showMessageDialog(this, alerta, "Error", JOptionPane.WARNING_MESSAGE);
	}
}