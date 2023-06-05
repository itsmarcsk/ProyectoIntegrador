package vista;

import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import modelo.Cliente;

public class VRegistro extends JFrame {
	private JTextField txtApellido;
	private JTextField txtDni;
	private JTextField txtTelef;
	private JTextField txtContrasenia;
	private JTextField txtContrasenia2;
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

	public VRegistro() {
		super("REGISTRO");
		init();
	}

	private void init() {
		// TODO Auto-generated method stub
		setSize(700, 800);
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("REGISTRO");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 30));
		lblNewLabel.setBounds(46, 27, 215, 59);
		getContentPane().add(lblNewLabel);

		txtNombre = new JTextField();
		txtNombre.setBounds(132, 108, 189, 59);
		getContentPane().add(txtNombre);
		txtNombre.setColumns(10);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblNombre.setBounds(46, 108, 99, 59);
		getContentPane().add(lblNombre);

		txtApellido = new JTextField();
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
		txtDni.setColumns(10);
		txtDni.setBounds(132, 264, 127, 59);
		getContentPane().add(txtDni);

		JLabel lblTelefono = new JLabel("Telefono: +");
		lblTelefono.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblTelefono.setBounds(269, 264, 127, 59);
		getContentPane().add(lblTelefono);

		txtTelef = new JTextField();
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

		txtContrasenia = new JTextField();
		txtContrasenia.setColumns(10);
		txtContrasenia.setBounds(220, 498, 435, 59);
		getContentPane().add(txtContrasenia);

		txtContrasenia2 = new JTextField();
		txtContrasenia2.setColumns(10);
		txtContrasenia2.setBounds(220, 580, 435, 59);
		getContentPane().add(txtContrasenia2);

		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(132, 420, 523, 59);
		getContentPane().add(txtEmail);

		btnCrearCuenta = new JButton("Crear Cuenta");
		btnCrearCuenta.setFont(new Font("Dialog", Font.PLAIN, 20));
		btnCrearCuenta.setBounds(68, 668, 253, 59);
		getContentPane().add(btnCrearCuenta);

		btnCancelar = new JButton("Cancelar");
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
		cmbPrefijo.setModel(new DefaultComboBoxModel(new String[] {"", "34", "355", "49", "376", "43", "32", "375", "387",
				"359", "385", "357", "45", "421", "386", "372", "358", "33", "30", "36", "354", "353", "39", "371",
				"423", "370", "352", "389", "356", "373", "377", "31", "47", "48", "351", "40", "44", "7", "378", "378",
				"421", "46", "41", "90", "380", "379" }));
		cmbPrefijo.setBounds(372, 264, 72, 59);
		getContentPane().add(cmbPrefijo);
	}

	private String[] obtenerAnios() {
		String[] aniosA = new String[104];
		for (int i = 1920; i < 2024; i++) {
			aniosA[i - 1920] = "" + i;
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
		
		int diaNac = (int) cmbDia.getSelectedItem();
		int mesNac = (int) cmbMes.getSelectedItem();
		int anioNac = (int) cmbAnio.getSelectedItem();
		
		String dni = txtDni.getText();
		if (dni.isBlank()) {
			return null;
		}
		
		int prefijo = (int) cmbPrefijo.getSelectedItem();
		String telefonoS = txtTelef.getText();
		if (telefonoS.length() != 9) {
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
		
		String genero = btngrpGenero.getSelection().toString();
		
		if (genero.isBlank()) {
			return null;
		} else if (genero.equals("Prefiero no decirlo")) {
			genero = null;
		}
		
		String email = txtEmail.getText();
		
		if (email.isBlank()) {
			return null;
		}
		
		if (txtContrasenia.getText().equals(txtContrasenia2.getText())) {
			String contrasenia = txtContrasenia.getText();
			Cliente cliente = new Cliente(nombre, apellido, diaNac, mesNac, anioNac, dni, prefijo, telefono, genero, email, dni);
			return cliente;
		} else {
			
			return null;
		}
	}
	

}