package vista;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JMenu;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controlador.Control;

import java.awt.Font;

public class VPrincipalCliente extends JFrame {
	public static final String SALIR = "Salir";
	public static final String PERFIL = "Perfil";
	public static final String ACTIVIDADES = "Actividades";
	public static final String INSTALACIONES = "Instalaciones";
	private JPanel contentPane;
	private JScrollPane scrpContenedor;
	private JMenuItem mntmInstalaciones;
	private JMenuItem mntmActividades;
	private JMenuItem mntmPerfil;
	private JMenuItem mnSalir;

	public VPrincipalCliente() {
		super("FITDEVELOPER");
		init();
		this.setExtendedState(this.MAXIMIZED_BOTH);
	}

	private void init() {
		setSize(1920, 1080);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		configurarMenu();
	}

	private void configurarMenu() {
		JMenuBar menuBar_1 = new JMenuBar();
		setJMenuBar(menuBar_1);
		
		JMenu mnMenu_1 = new JMenu("Menu");
		mnMenu_1.setFont(new Font("Dialog", Font.BOLD, 14));
		menuBar_1.add(mnMenu_1);
		
		mntmInstalaciones = new JMenuItem(INSTALACIONES);
		mntmInstalaciones.setHorizontalTextPosition(SwingConstants.CENTER);
		mntmInstalaciones.setHorizontalAlignment(SwingConstants.CENTER);
		mntmInstalaciones.setFont(new Font("Dialog", Font.PLAIN, 12));
		mnMenu_1.add(mntmInstalaciones);
		
		mntmActividades = new JMenuItem(ACTIVIDADES);
		mntmActividades.setFont(new Font("Dialog", Font.PLAIN, 12));
		mnMenu_1.add(mntmActividades);
		
		mntmPerfil = new JMenuItem(PERFIL);
		mntmPerfil.setFont(new Font("Dialog", Font.PLAIN, 12));
		mnMenu_1.add(mntmPerfil);
		
		mnSalir = new JMenuItem(SALIR);
		mnSalir.setFont(new Font("Dialog", Font.BOLD, 14));
		menuBar_1.add(mnSalir);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
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
	
	public boolean mostrarPregunta(String mensaje) {
		if (JOptionPane.showConfirmDialog(this, mensaje, "Confirmación", JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_NO_OPTION) {
			return true;
		} else {
			return false;
		}
	}

	public void cargarPanel(JPanel panel) {
		scrpContenedor.setViewportView(panel);
	}

	public void setListener(Control control) {
		mnSalir.addActionListener(control);
		mntmActividades.addActionListener(control);
		mntmInstalaciones.addActionListener(control);
		mntmPerfil.addActionListener(control);
	}
}