package vista;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JMenu;
import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.awt.Color;

public class VPrincipalCliente extends JFrame{
	private JPanel contentPane;
	private JScrollPane scrpContenedor;
	private JMenuItem mntmInstalaciones;
	private JMenu mnMenu;
	private JMenuBar menuBar;
	private JMenuItem mntmActividades;
	public VPrincipalCliente() {
		
		init();
		this.setExtendedState(this.MAXIMIZED_BOTH);
	}

	private void init() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		configurarMenu();
				

	}

	private void configurarMenu() {
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnMenu = new JMenu("Menu");
		mnMenu.setFont(new Font("Arial", Font.BOLD, 12));
		menuBar.add(mnMenu);
		
		mntmInstalaciones = new JMenuItem("Instalaciones");
		mntmInstalaciones.setFont(new Font("Dialog", Font.BOLD, 12));
		mnMenu.add(mntmInstalaciones);
		
		mntmActividades = new JMenuItem("Actividades");
		mntmActividades.setFont(new Font("Dialog", Font.BOLD, 12));
		mnMenu.add(mntmActividades);
		
		JMenuItem mntmPerfil = new JMenuItem("Perfil");
		mntmPerfil.setFont(new Font("Dialog", Font.BOLD, 12));
		mntmPerfil.setForeground(new Color(0, 0, 0));
		mnMenu.add(mntmPerfil);
		
		JMenu mnSalir = new JMenu("Salir");
		mnSalir.setFont(new Font("Arial", Font.BOLD, 12));
		menuBar.add(mnSalir);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
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
	public void cargarPanel(JPanel panel) {
		// TODO Auto-generated method stub
		scrpContenedor.setViewportView(panel);
	}
}