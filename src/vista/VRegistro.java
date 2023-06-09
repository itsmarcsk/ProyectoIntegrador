package vista;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import controlador.Control;
import modelo.Cliente;
import javax.swing.JPasswordField;

public class VRegistro extends JFrame {
	private static final int ALTO = 800;
	private static final int ANCHO = 700;
	public static final String CANCELAR = "Cancelar";
	public static final String CREAR_CUENTA = "Crear Cuenta";
	private JTextField txtApellido;
	private JTextField txtDni;
	private JTextField txtTelef;
	private JTextField txtEmail;
	private final ButtonGroup btngrpGenero = new ButtonGroup();
	private JButton btnCancelar;
	private JButton btnCrearCuenta;
	private JRadioButton rdbtnMasc;
	private JRadioButton rdbtnFemenino;
	private JRadioButton rdbtnPrefieroNoDecirlo;
	private JComboBox cmbDia;
	private JComboBox cmbMes;
	private JComboBox cmbAnio;
	private JTextField txtNombre;
	private JComboBox cmbPrefijo;
	private JPasswordField txtContrasenia;
	private JPasswordField txtContrasenia2;

	public VRegistro() {
		super("REGISTRO");
		init();
	}

	private void init() {
		// TODO Auto-generated method stub
		setSize(ANCHO, ALTO);
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("REGISTRO");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 30));
		lblNewLabel.setBounds(46, 27, 215, 59);
		getContentPane().add(lblNewLabel);

		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Dialog", Font.PLAIN, 20));
		txtNombre.setBounds(132, 108, 189, 59);
		getContentPane().add(txtNombre);
		txtNombre.setColumns(10);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblNombre.setBounds(46, 108, 99, 59);
		getContentPane().add(lblNombre);

		txtApellido = new JTextField();
		txtApellido.setFont(new Font("Dialog", Font.PLAIN, 20));
		txtApellido.setColumns(10);
		txtApellido.setBounds(466, 108, 189, 59);
		getContentPane().add(txtApellido);

		JLabel lblApellido = new JLabel("Apellidos");
		lblApellido.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblApellido.setBounds(372, 108, 99, 59);
		getContentPane().add(lblApellido);

		JLabel lblFecNac = new JLabel("Fecha de Nacimiento");
		lblFecNac.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblFecNac.setBounds(46, 186, 204, 59);
		getContentPane().add(lblFecNac);

		JLabel lblDni = new JLabel("DNI");
		lblDni.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblDni.setBounds(46, 264, 99, 59);
		getContentPane().add(lblDni);

		txtDni = new JTextField();
		txtDni.setFont(new Font("Dialog", Font.PLAIN, 20));
		txtDni.setColumns(10);
		txtDni.setBounds(132, 264, 127, 59);
		getContentPane().add(txtDni);

		JLabel lblTelefono = new JLabel("Telefono: +");
		lblTelefono.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblTelefono.setBounds(269, 264, 127, 59);
		getContentPane().add(lblTelefono);

		txtTelef = new JTextField();
		txtTelef.setFont(new Font("Dialog", Font.PLAIN, 20));
		txtTelef.setColumns(10);
		txtTelef.setBounds(480, 268, 175, 55);
		getContentPane().add(txtTelef);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblEmail.setBounds(46, 420, 99, 59);
		getContentPane().add(lblEmail);

		JLabel lblContrasenia = new JLabel("Contraseña");
		lblContrasenia.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblContrasenia.setBounds(46, 498, 130, 59);
		getContentPane().add(lblContrasenia);

		JLabel lblContrasenia2 = new JLabel("Repite la contraseña");
		lblContrasenia2.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblContrasenia2.setBounds(22, 576, 198, 59);
		getContentPane().add(lblContrasenia2);

		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Dialog", Font.PLAIN, 20));
		txtEmail.setColumns(10);
		txtEmail.setBounds(132, 420, 523, 59);
		getContentPane().add(txtEmail);

		btnCrearCuenta = new JButton(CREAR_CUENTA);
		btnCrearCuenta.setFont(new Font("Dialog", Font.PLAIN, 20));
		btnCrearCuenta.setBounds(68, 668, 253, 59);
		getContentPane().add(btnCrearCuenta);

		btnCancelar = new JButton(CANCELAR);
		btnCancelar.setFont(new Font("Dialog", Font.PLAIN, 20));
		btnCancelar.setBounds(393, 668, 253, 59);
		getContentPane().add(btnCancelar);

		JLabel lblGenero = new JLabel("Genero");
		lblGenero.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblGenero.setBounds(46, 342, 99, 59);
		getContentPane().add(lblGenero);

		rdbtnMasc = new JRadioButton("Masculino");
		btngrpGenero.add(rdbtnMasc);
		rdbtnMasc.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdbtnMasc.setBounds(166, 343, 130, 57);
		getContentPane().add(rdbtnMasc);

		rdbtnFemenino = new JRadioButton("Femenino");
		btngrpGenero.add(rdbtnFemenino);
		rdbtnFemenino.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdbtnFemenino.setBounds(328, 343, 130, 57);
		getContentPane().add(rdbtnFemenino);

		rdbtnPrefieroNoDecirlo = new JRadioButton("Prefiero no decirlo");
		btngrpGenero.add(rdbtnPrefieroNoDecirlo);
		rdbtnPrefieroNoDecirlo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdbtnPrefieroNoDecirlo.setBounds(466, 343, 215, 57);
		getContentPane().add(rdbtnPrefieroNoDecirlo);

		cmbDia = new JComboBox();
		cmbDia.setFont(new Font("Dialog", Font.PLAIN, 20));
		cmbDia.setModel(new DefaultComboBoxModel(
				new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16",
						"17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
		cmbDia.setBounds(260, 186, 72, 59);
		getContentPane().add(cmbDia);

		cmbMes = new JComboBox();
		cmbMes.setFont(new Font("Dialog", Font.PLAIN, 20));
		cmbMes.setModel(new DefaultComboBoxModel(
				new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
		cmbMes.setBounds(393, 186, 72, 59);
		getContentPane().add(cmbMes);

		cmbAnio = new JComboBox();
		cmbAnio.setFont(new Font("Dialog", Font.PLAIN, 20));
		String[] aniosA = obtenerAnios();
		cmbAnio.setModel(new DefaultComboBoxModel(aniosA));
		cmbAnio.setSelectedIndex(0);
		cmbAnio.setBounds(527, 186, 128, 59);
		getContentPane().add(cmbAnio);

		cmbPrefijo = new JComboBox();
		cmbPrefijo.setFont(new Font("Dialog", Font.PLAIN, 20));
		cmbPrefijo.setModel(new DefaultComboBoxModel(new String[] { "", "34", "355", "49", "376", "43", "32", "375",
				"387", "359", "385", "357", "45", "421", "386", "372", "358", "33", "30", "36", "354", "353", "39",
				"371", "423", "370", "352", "389", "356", "373", "377", "31", "47", "48", "351", "40", "44", "7", "378",
				"378", "421", "46", "41", "90", "380", "379" }));
		cmbPrefijo.setBounds(372, 264, 72, 59);
		getContentPane().add(cmbPrefijo);

		txtContrasenia = new JPasswordField();
		txtContrasenia.setFont(new Font("Dialog", Font.PLAIN, 20));
		txtContrasenia.setBounds(220, 498, 435, 55);
		getContentPane().add(txtContrasenia);

		txtContrasenia2 = new JPasswordField();
		txtContrasenia2.setFont(new Font("Dialog", Font.PLAIN, 20));
		txtContrasenia2.setBounds(220, 576, 435, 55);
		getContentPane().add(txtContrasenia2);
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

	private String[] obtenerAnios() {
		String[] aniosA = new String[74];
		for (int i = 1950; i < 2024; i++) {
			aniosA[i - 1950] = "" + i;
		}

		for (int i = 0; i < aniosA.length / 2; i++) {
			String temp = aniosA[i];
			aniosA[i] = aniosA[aniosA.length - i - 1];
			aniosA[aniosA.length - i - 1] = temp;
		}
		return aniosA;
	}

	public Cliente getDatos() {

		String nombre = txtNombre.getText();
		if (nombre.isBlank()) {
			return null;
		}

		String apellido = txtApellido.getText();
		if (apellido.isBlank()) {
			return null;
		}

		int diaNac = Integer.parseInt((String) cmbDia.getSelectedItem());
		int mesNac = Integer.parseInt((String) cmbMes.getSelectedItem());
		int anioNac = Integer.parseInt((String) cmbAnio.getSelectedItem());

		String dni = txtDni.getText();
		if (dni.isBlank()) {
			return null;
		}
		int prefijo = 0;
		try {
			prefijo = Integer.parseInt((String) cmbPrefijo.getSelectedItem());
			
		} catch (Exception e) {
			mostrarError("Debes de seleccionar un prefijo de telefono");
		}
		String telefonoS = txtTelef.getText();
		
		if (telefonoS.length() != 9) {
			mostrarError("Debes de introducir 9 digitos en el telefono");
			return null;
		}
		int telefono = 0;
		try {
			telefono = Integer.parseInt(telefonoS);
			if (telefono == 0) {
				return null;
			}

		} catch (NumberFormatException e) {
			e.printStackTrace();
		}

		String genero = generoElegido();

		String email = txtEmail.getText();

		if (email.isBlank()) {
			return null;
		}

		if (txtContrasenia.getText().equals(txtContrasenia2.getText())) {
			String contrasenia = txtContrasenia.getText();
			
			if (contrasenia.isBlank()) {
				return null;
			}
			
			Cliente cliente = new Cliente(nombre, apellido, diaNac, mesNac, anioNac, dni, prefijo, telefono, genero,
					email, contrasenia);
			return cliente;
		} else {

			return null;
		}
	}

	private String generoElegido() {
		// TODO Auto-generated method stub
		if (rdbtnPrefieroNoDecirlo.isSelected()) {
			return null;
		} else if (rdbtnMasc.isSelected()) {
			return "Masculino";
		} else if (rdbtnFemenino.isSelected()) {
			return "Femenino";
		} else {
			return null;
		}

	}

	public void hacerVisible() {
		setVisible(true);
	}

	public void setListener(Control control) {
		btnCancelar.addActionListener(control);
		btnCrearCuenta.addActionListener(control);
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
		if (JOptionPane.showConfirmDialog(this, mensaje, "Confirmación",
				JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_NO_OPTION) {
			return true;
		} else {
			return false;
		}
	}

	public void reinicar() {
		// TODO Auto-generated method stub
		txtApellido.setText("");
		txtContrasenia.setText("");
		txtContrasenia2.setText("");
		txtDni.setText("");
		txtEmail.setText("");
		txtNombre.setText("");
		txtTelef.setText("");
		cmbDia.setSelectedIndex(0);
		cmbMes.setSelectedIndex(0);
		cmbAnio.setSelectedIndex(0);
		cmbPrefijo.setSelectedIndex(0);
	}
}