package vista;


import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


public class VPrincipalAdmin extends JFrame {

	private JPanel contentPane;
	private JMenuItem mntmOpcionRegistro;
	private JMenuItem mntmOpcionModificacion;
	private JScrollPane scrpContenedor;
	private JSeparator separator_2;
	private JMenuItem mntmOpcionConsulta;
	private JSeparator separator;
	private JMenuItem mnMenuSalir;
	public static final String SALIR = "Salir";
	public static final String REGISTRO = "Añadir actividad";
	public static final String MODIFICACION = "Modificación de actividad";
	public static final String ELIMINAR = "Eliminar activadad";
	public VPrincipalAdmin() {
		init();
		this.setExtendedState(this.MAXIMIZED_BOTH);
	}
	private void init() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		configurarMenu();
		setContentPane(contentPane);
	}
	private void configurarMenu() {
		// TODO Auto-generated method stub
		JMenuBar mnbBarraMenu = new JMenuBar();
		mnbBarraMenu.setFont(new Font("Arial", Font.PLAIN, 12));
		setJMenuBar(mnbBarraMenu);

		JMenu mnMenu1 = new JMenu("Actividades");
		mnMenu1.setBorder(new MatteBorder(0, 0, 0, 1, (Color) new Color(0, 0, 0)));
		mnMenu1.setFont(new Font("Dialog", Font.BOLD, 14));
		mnbBarraMenu.add(mnMenu1);
		
		mnMenuSalir = new JMenuItem(SALIR);
		mnMenuSalir.setFont(new Font("Dialog", Font.BOLD, 14));
		mnbBarraMenu.add(mnMenuSalir);

		mntmOpcionConsulta = new JMenuItem(REGISTRO);
		mntmOpcionConsulta.setHorizontalAlignment(SwingConstants.LEFT);
		mntmOpcionConsulta.setFont(new Font("Arial", Font.PLAIN, 12));
		mnMenu1.add(mntmOpcionConsulta);

		separator = new JSeparator();

		mnMenu1.add(separator);
		mntmOpcionRegistro = new JMenuItem(MODIFICACION);
		mntmOpcionRegistro.setHorizontalAlignment(SwingConstants.LEFT);
		mntmOpcionRegistro.setFont(new Font("Arial", Font.PLAIN, 12));
		mnMenu1.add(mntmOpcionRegistro);

		separator_2 = new JSeparator();
		mnMenu1.add(separator_2);

		mntmOpcionModificacion = new JMenuItem(ELIMINAR);
		mntmOpcionModificacion.setHorizontalAlignment(SwingConstants.LEFT);
		mntmOpcionModificacion.setFont(new Font("Arial", Font.PLAIN, 12));
		mnMenu1.add(mntmOpcionModificacion);
		getContentPane().setLayout(null);
		getContentPane().setLayout(null);
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
}
