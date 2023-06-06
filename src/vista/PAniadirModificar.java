package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class PAniadirModificar extends JPanel {
	public static final String ANIADIR_ACTIVIDAD = "Añadir Actividad";
	public static final String MODIFICAR_ACTIVIDAD = "Modificar Actividad";
	private String aniadirModificarBoton = "";
	private JTextField txtNombre;
	private JTextArea txtaDescripcion;
	private JButton btnModificar;
	private JSpinner spnPrecio;
	public PAniadirModificar() {
		init();
	}

	private void init() {
		// TODO Auto-generated method stub
		setSize(1920,1080);
		setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Dialog", Font.PLAIN, 24));
		lblNombre.setBounds(60, 78, 167, 90);
		add(lblNombre);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setFont(new Font("Dialog", Font.PLAIN, 24));
		lblPrecio.setBounds(914, 78, 160, 90);
		add(lblPrecio);
		
		JLabel lblDescripcin = new JLabel("Descripción:");
		lblDescripcin.setFont(new Font("Dialog", Font.PLAIN, 24));
		lblDescripcin.setBounds(60, 242, 167, 90);
		add(lblDescripcin);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Dialog", Font.PLAIN, 20));
		txtNombre.setBounds(244, 78, 362, 90);
		add(txtNombre);
		txtNombre.setColumns(10);
		
		spnPrecio = new JSpinner();
		spnPrecio.setFont(new Font("Dialog", Font.PLAIN, 20));
		spnPrecio.setModel(new SpinnerNumberModel(10,139, 50, 1));
		spnPrecio.setBounds(1098, 78, 227, 90);
		add(spnPrecio);
		
		JScrollPane scrpDescripcion = new JScrollPane();
		scrpDescripcion.setBounds(60, 343, 1788, 611);
		add(scrpDescripcion);
		
		txtaDescripcion = new JTextArea();
		scrpDescripcion.setViewportView(txtaDescripcion);
		
		btnModificar = new JButton(aniadirModificarBoton);
		btnModificar.setFont(new Font("Dialog", Font.BOLD, 20));
		btnModificar.setBounds(1525, 981, 323, 67);
		add(btnModificar);
	}
	
	public void modificar() {
		aniadirModificarBoton = MODIFICAR_ACTIVIDAD;
	}
	
	public void aniadir() {
		aniadirModificarBoton = ANIADIR_ACTIVIDAD;
	}
}
