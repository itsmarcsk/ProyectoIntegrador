package vista;


import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import controlador.Control;


public class VPrincipalAdmin extends JFrame {

	private JPanel contentPane;
	private JMenuItem mntmOpcionModificacion;
	private JScrollPane scrpContenedor;
	private JSeparator separator_2;
	private JMenuItem mntmOpcionRegistro;
	private JMenuItem mntmOpcionConsulta;
	private JSeparator separator;
	private JMenuItem mnMenuSalir;
	public static final String SALIR = "Salir";
	public static final String ANIADIR_ACT = "Añadir actividad";
	public static final String CONSULTAR = "Consultar actividad";

	public static final String CONSULTA = "Consulta";
	public VPrincipalAdmin() {
		super("FITDEVELOPER");
		this.setExtendedState(this.MAXIMIZED_BOTH);
		setSize(1920, 1080);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		configurarMenu();
		init();
	}

	private void configurarMenu() {
		// TODO Auto-generated method stub
		JMenuBar mnbBarraMenu = new JMenuBar();
		mnbBarraMenu.setFont(new Font("Dialog", Font.PLAIN, 12));
		setJMenuBar(mnbBarraMenu);

		JMenu mnMenu1 = new JMenu("Actividades");
		mnMenu1.setBorder(new MatteBorder(0, 0, 0, 1, (Color) new Color(0, 0, 0)));
		mnMenu1.setFont(new Font("Dialog", Font.BOLD, 14));
		mnbBarraMenu.add(mnMenu1);
		
		JMenu mnMenu2 = new JMenu("Clientes");
		mnMenu2.setBorder(new MatteBorder(0, 0, 0, 1, (Color) new Color(0, 0, 0)));
		mnMenu2.setFont(new Font("Dialog", Font.BOLD, 14));
		mnbBarraMenu.add(mnMenu2);
		
		mnMenuSalir = new JMenuItem(SALIR);
		mnMenuSalir.setFont(new Font("Dialog", Font.BOLD, 14));
		mnbBarraMenu.add(mnMenuSalir);

		mntmOpcionRegistro = new JMenuItem(ANIADIR_ACT);
		mntmOpcionRegistro.setHorizontalAlignment(SwingConstants.LEFT);
		mntmOpcionRegistro.setFont(new Font("Dialog", Font.PLAIN, 12));
		mnMenu1.add(mntmOpcionRegistro);

		separator = new JSeparator();

		mnMenu1.add(separator);
		mntmOpcionModificacion = new JMenuItem(CONSULTAR);
		mntmOpcionModificacion.setHorizontalAlignment(SwingConstants.LEFT);
		mntmOpcionModificacion.setFont(new Font("Dialog", Font.PLAIN, 12));
		mnMenu1.add(mntmOpcionModificacion);

//		separator_2 = new JSeparator();
//		mnMenu1.add(separator_2);

		mntmOpcionConsulta = new JMenuItem(CONSULTA);
		mntmOpcionConsulta.setHorizontalAlignment(SwingConstants.LEFT);
		mntmOpcionConsulta.setFont(new Font("Dialog", Font.PLAIN, 12));
		mnMenu2.add(mntmOpcionConsulta);
		getContentPane().setLayout(null);
		getContentPane().setLayout(null);
	}
	private void init() {
		// TODO Auto-generated method stub
		scrpContenedor = new JScrollPane();
		scrpContenedor.setBounds(0, 0, 2000, 1920);
		getContentPane().add(scrpContenedor);

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

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
		JOptionPane.showMessageDialog(this, alerta, "Alerta", JOptionPane.WARNING_MESSAGE);
	}
	public void cargarPanel(JPanel panel) {
		// TODO Auto-generated method stub
		scrpContenedor.setViewportView(panel);
	}
	public void setListener(Control control) {
		// TODO Auto-generated method stub
		mntmOpcionConsulta.addActionListener(control);
		mntmOpcionModificacion.addActionListener(control);
		mntmOpcionRegistro.addActionListener(control);
		mnMenuSalir.addActionListener(control);
	}
}
