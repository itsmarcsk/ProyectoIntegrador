package vista;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JTextField;
import javax.swing.JButton;

public class VLogin extends JFrame {

	public static final int ANCHO = 700;
	public static final int ALTO = 500;
	private JPanel contentPane;
	private JLabel lblLogin;
	private JLabel lblContrasena;
	private JTextField txtUsuario;
	private JTextField txtPassword;
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
		lblLogin.setBounds(290, 10, 179, 38);
		contentPane.add(lblLogin);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(363, 89, 45, 13);
		contentPane.add(lblUsuario);
		
		lblContrasena = new JLabel("Contraseña");
		lblContrasena.setHorizontalAlignment(SwingConstants.CENTER);
		lblContrasena.setBounds(332, 178, 96, 13);
		contentPane.add(lblContrasena);
		
		txtUsuario = new JTextField();
		txtUsuario.setToolTipText("Escribe nombre usuario");
		txtUsuario.setBounds(332, 112, 96, 19);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtPassword = new JTextField();
		txtPassword.setToolTipText("Introduce contraseña");
		txtPassword.setBounds(332, 201, 96, 19);
		contentPane.add(txtPassword);
		txtPassword.setColumns(10);
		
		JButton btnIniciarSesion = new JButton("Inicio sesion");
		btnIniciarSesion.setBounds(321, 251, 117, 21);
		contentPane.add(btnIniciarSesion);
		
		JButton btnRegistro = new JButton("Registrarse");
		btnRegistro.setBounds(332, 341, 85, 21);
		contentPane.add(btnRegistro);
		String registro = "En caso de que se quiera registrar,\n pulse el botón de abajo";
		JLabel lblRegistro = new JLabel(registro);
		lblRegistro.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRegistro.setBounds(195, 282, 314, 38);
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
}
