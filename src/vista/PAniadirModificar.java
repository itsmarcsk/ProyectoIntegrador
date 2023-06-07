package vista;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

import controlador.Control;
import modelo.Actividad;

public class PAniadirModificar extends JPanel {
	public static final String ANIADIR_ACTIVIDAD = "Añadir Actividad";
	public static final String MODIFICAR_ACTIVIDAD = "Modificar Actividad";
	private JTextField txtNombre;
	private JTextArea txtaDescripcion;
	private JButton btnModificarAniadir;
	private JSpinner spnPrecio;
	private JLabel lblNombre;
	private JLabel lblPrecio;
	private JLabel lblDescripcin;
	private JScrollPane scrpDescripcion;
	public PAniadirModificar() {
		init();
	}

	private void init() {
		// TODO Auto-generated method stub
		setSize(1920, 984);
		setLayout(null);
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Dialog", Font.PLAIN, 24));
		lblNombre.setBounds(60, 78, 167, 90);
		add(lblNombre);
		
		lblPrecio = new JLabel("Precio:");
		lblPrecio.setFont(new Font("Dialog", Font.PLAIN, 24));
		lblPrecio.setBounds(914, 78, 160, 90);
		add(lblPrecio);
		
		lblDescripcin = new JLabel("Descripción:");
		lblDescripcin.setFont(new Font("Dialog", Font.PLAIN, 24));
		lblDescripcin.setBounds(60, 187, 167, 90);
		add(lblDescripcin);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Dialog", Font.PLAIN, 20));
		txtNombre.setBounds(244, 78, 362, 90);
		add(txtNombre);
		txtNombre.setColumns(10);
		
		spnPrecio = new JSpinner();
		spnPrecio.setFont(new Font("Dialog", Font.PLAIN, 20));
		spnPrecio.setModel(new SpinnerNumberModel(10,10, 50, 1));
		spnPrecio.setBounds(1098, 78, 227, 90);
		add(spnPrecio);
		
		scrpDescripcion = new JScrollPane();
		scrpDescripcion.setBounds(66, 288, 1788, 517);
		add(scrpDescripcion);
		
		txtaDescripcion = new JTextArea();
		scrpDescripcion.setViewportView(txtaDescripcion);
		
		btnModificarAniadir = new JButton();
		btnModificarAniadir.setFont(new Font("Dialog", Font.BOLD, 20));
		btnModificarAniadir.setBounds(1525, 855, 323, 67);
		add(btnModificarAniadir);
	}
	
	public void modificar() {
		btnModificarAniadir.setText(MODIFICAR_ACTIVIDAD);
		txtNombre.setEnabled(false);
	}
	
	public void aniadir() {
		btnModificarAniadir.setText(ANIADIR_ACTIVIDAD);
		txtNombre.setEnabled(true);
	}

	public void rellenarDatos(Actividad c) {
		txtNombre.setText(c.getNombre());
		spnPrecio.setValue(c.getPrecio());
		txtaDescripcion.setText(c.getDescripcion());
	}
	
	public Actividad getDatos() {
		String nombre = txtNombre.getText();
		
		int precio = (int) spnPrecio.getValue();
		
		String desc = txtaDescripcion.getText();
		if (desc.isBlank()) {
			return null;
		} else if (nombre.isBlank()){
			return null;
		} else {
			return new Actividad(nombre, precio, desc);
		}
	}

	public void setListener(Control control) {
		// TODO Auto-generated method stub
		btnModificarAniadir.addActionListener(control);
	}

	public void reiniciar() {
		// TODO Auto-generated method stub
		txtNombre.setText("");
		txtaDescripcion.setText("");
		spnPrecio.setValue(10);
	}
}
