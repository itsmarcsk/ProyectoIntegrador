package vista;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextArea;

public class PPerfil extends JPanel {
	public static final String BORRAR_ACTIVIDAD = "Borrar Actividad";
	public static final String CONSULTAR_ACTIVIDAD = "Consultar Actividad";
	public static final String BORRAR_CUENTA = "Borrar Cuenta";
	public static final String GUARDAR_CAMBIOS = "Guardar Cambios";
	private JTextField txtNombre;
	private JTextField txtContra;
	private JTextField txtEmail;
	private JTextField txtFecNac;
	private JTextField txtDni;
	private JTable tblListaActividades;
	private JTextArea txtDescripcion;
	private JButton btnBorrarActividad;
	private JButton btnConsultar;
	private JScrollPane scrpListaActividades;
	private JButton btnGuardarCambios;
	private JButton btnBorrarCuenta;
	public PPerfil() {
		init();
		
	}
	

	private void init() {
		// TODO Auto-generated method stub
		setSize(1920,1080);
		setLayout(null);
		
		JScrollPane scrpDatos = new JScrollPane();
		scrpDatos.setBounds(1248, 0, 672, 1080);
		add(scrpDatos);
		
		JPanel panelActividades = new JPanel();
		scrpDatos.setViewportView(panelActividades);
		panelActividades.setLayout(null);
		
		JLabel lblDatosPersonales = new JLabel("Datos Personales");
		lblDatosPersonales.setFont(new Font("Dialog", Font.BOLD, 24));
		lblDatosPersonales.setBounds(23, 31, 245, 66);
		panelActividades.add(lblDatosPersonales);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblNombre.setBounds(45, 139, 180, 56);
		panelActividades.add(lblNombre);
		
		JLabel lblContrasea = new JLabel("Contraseña");
		lblContrasea.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblContrasea.setBounds(45, 246, 180, 56);
		panelActividades.add(lblContrasea);
		
		JLabel lblCorreo = new JLabel("Correo electrónico");
		lblCorreo.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblCorreo.setBounds(45, 353, 180, 56);
		panelActividades.add(lblCorreo);
		
		JLabel lblFecNac = new JLabel("Fecha de nacimiento");
		lblFecNac.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblFecNac.setBounds(45, 460, 199, 56);
		panelActividades.add(lblFecNac);
		
		JLabel lblDni = new JLabel("DNI");
		lblDni.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblDni.setBounds(45, 567, 180, 56);
		panelActividades.add(lblDni);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Dialog", Font.PLAIN, 20));
		txtNombre.setBounds(259, 139, 351, 56);
		panelActividades.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtContra = new JTextField();
		txtContra.setFont(new Font("Dialog", Font.PLAIN, 20));
		txtContra.setHorizontalAlignment(SwingConstants.CENTER);
		txtContra.setColumns(10);
		txtContra.setBounds(259, 246, 351, 56);
		panelActividades.add(txtContra);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Dialog", Font.PLAIN, 20));
		txtEmail.setColumns(10);
		txtEmail.setBounds(259, 353, 351, 56);
		panelActividades.add(txtEmail);
		
		txtFecNac = new JTextField();
		txtFecNac.setFont(new Font("Dialog", Font.PLAIN, 20));
		txtFecNac.setColumns(10);
		txtFecNac.setBounds(259, 460, 351, 56);
		panelActividades.add(txtFecNac);
		
		txtDni = new JTextField();
		txtDni.setFont(new Font("Dialog", Font.PLAIN, 20));
		txtDni.setColumns(10);
		txtDni.setBounds(259, 567, 351, 56);
		panelActividades.add(txtDni);
		
		btnGuardarCambios = new JButton(GUARDAR_CAMBIOS);
		btnGuardarCambios.setFont(new Font("Dialog", Font.PLAIN, 16));
		btnGuardarCambios.setBounds(430, 660, 180, 43);
		panelActividades.add(btnGuardarCambios);
		
		btnBorrarCuenta = new JButton(BORRAR_CUENTA);
		btnBorrarCuenta.setFont(new Font("Dialog", Font.PLAIN, 20));
		btnBorrarCuenta.setBounds(45, 724, 219, 66);
		panelActividades.add(btnBorrarCuenta);
		
		JScrollPane scrpActividades = new JScrollPane();
		scrpActividades.setBounds(0, 0, 1250, 1080);
		add(scrpActividades);
		
		JPanel panelDatosPersonales = new JPanel();
		scrpActividades.setViewportView(panelDatosPersonales);
		panelDatosPersonales.setLayout(null);
		
		JLabel lblMisActividades = new JLabel("Mis Actividades");
		lblMisActividades.setFont(new Font("Dialog", Font.BOLD, 24));
		lblMisActividades.setBounds(36, 31, 245, 66);
		panelDatosPersonales.add(lblMisActividades);
		
		scrpListaActividades = new JScrollPane();
		scrpListaActividades.setBounds(59, 131, 525, 864);
		panelDatosPersonales.add(scrpListaActividades);
		
		tblListaActividades = new JTable();
		scrpListaActividades.setViewportView(tblListaActividades);
		
		JScrollPane scrpDescripcion = new JScrollPane();
		scrpDescripcion.setBounds(655, 312, 525, 684);
		panelDatosPersonales.add(scrpDescripcion);
		
		txtDescripcion = new JTextArea();
		txtDescripcion.setFont(new Font("Dialog", Font.PLAIN, 20));
		txtDescripcion.setEditable(false);
		txtDescripcion.setWrapStyleWord(true);
		scrpDescripcion.setViewportView(txtDescripcion);
		
		btnBorrarActividad = new JButton(BORRAR_ACTIVIDAD);
		btnBorrarActividad.setFont(new Font("Dialog", Font.PLAIN, 20));
		btnBorrarActividad.setBounds(935, 131, 245, 66);
		panelDatosPersonales.add(btnBorrarActividad);
		
		btnConsultar = new JButton(CONSULTAR_ACTIVIDAD);
		btnConsultar.setFont(new Font("Dialog", Font.PLAIN, 20));
		btnConsultar.setBounds(655, 131, 245, 66);
		panelDatosPersonales.add(btnConsultar);
		
		JLabel lblDescripcin = new JLabel("Descripción");
		lblDescripcin.setFont(new Font("Dialog", Font.BOLD, 24));
		lblDescripcin.setBounds(655, 222, 245, 66);
		panelDatosPersonales.add(lblDescripcin);
	}
}