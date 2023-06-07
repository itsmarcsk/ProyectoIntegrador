package vista;


import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controlador.Control;


public class VLogin extends JFrame {

	public static final String INICIO_SESION = "Inicio sesion";
	public static final String REGISTRARSE = "Registrarse";
	public static final int ANCHO = 700;
	public static final int ALTO = 500;
	private JPanel contentPane;
	private JLabel lblLogin;
	private JLabel lblContrasena;
	private JTextField txtUsuario;
	private JTextField txtPassword;
	private JButton btnRegistro;
	private JButton btnIniciarSesion;
	
	public VLogin() {
		super("LOGIN");
		init();
	}
	private void init() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblLogin = new JLabel("LOGIN");
		lblLogin.setFont(new Font("Dialog", Font.BOLD, 30));
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setHorizontalTextPosition(SwingConstants.LEFT);
		lblLogin.setEnabled(true);
		lblLogin.setVerticalAlignment(SwingConstants.CENTER);
		lblLogin.setBounds(253, 27, 179, 38);
		contentPane.add(lblLogin);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuario.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblUsuario.setBounds(253, 76, 179, 26);
		contentPane.add(lblUsuario);
		
		lblContrasena = new JLabel("Contraseña");
		lblContrasena.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblContrasena.setHorizontalAlignment(SwingConstants.CENTER);
		lblContrasena.setBounds(242, 165, 199, 26);
		contentPane.add(lblContrasena);
		
		txtUsuario = new JTextField();
		txtUsuario.setFont(new Font("Dialog", Font.PLAIN, 20));
		txtUsuario.setToolTipText("Escribe nombre usuario");
		txtUsuario.setBounds(248, 112, 189, 42);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtPassword = new JTextField();
		txtPassword.setFont(new Font("Dialog", Font.PLAIN, 20));
		txtPassword.setToolTipText("Introduce contraseña");
		txtPassword.setBounds(247, 198, 189, 42);
		contentPane.add(txtPassword);
		txtPassword.setColumns(10);
		
		btnIniciarSesion = new JButton(INICIO_SESION);
		btnIniciarSesion.setFont(new Font("Dialog", Font.PLAIN, 20));
		btnIniciarSesion.setBounds(206, 268, 272, 60);
		contentPane.add(btnIniciarSesion);
		
		btnRegistro = new JButton(REGISTRARSE);
		btnRegistro.setFont(new Font("Dialog", Font.PLAIN, 20));
		btnRegistro.setBounds(242, 399, 199, 38);
		contentPane.add(btnRegistro);
		String registro = "En caso de que se quiera registrar,\n pulse el botón de abajo";
		JLabel lblRegistro = new JLabel("<html>\r\n<div center>\r\nEn caso de que se quiera registrar,\r\n<br>\r\n pulse el botón de abajo\r\n</div>\r\n</html>");
		lblRegistro.setFont(new Font("Dialog", Font.PLAIN, 10));
		lblRegistro.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistro.setBounds(214, 353, 256, 62);
		contentPane.add(lblRegistro);
		setSize(ANCHO, ALTO);
		centrarVentana();
	}
	private void centrarVentana() {
		// TODO Auto-generated method stub
		// Se obtienen las dimensiones en pixels de la pantalla.
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		// Crear un objeto de tipo Dimension con las medidas en pixels de la ventana.
		Dimension ventana = new Dimension(ANCHO, ALTO);
		// Una cuenta para situar la ventana en el centro de la pantalla.
		setLocation((pantalla.width - ventana.width) / 2, (pantalla.height - ventana.height) / 2);
	}
	public void hacerVisible() {
		setVisible(true);

	}
	public String getUsuario() {
		String usuario = txtUsuario.getText();
		return usuario;
	}
	public String getPassword() {
		String password = txtPassword.getText();
		return password;
	}
	public void setListener(Control control) {
		btnIniciarSesion.addActionListener(control);
		btnRegistro.addActionListener(control);
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
}
