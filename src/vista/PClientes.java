package vista;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controlador.Control;
import modelo.Cliente;
import modelo.Consulta;

public class PClientes extends JPanel {
	public static final String BUSCAR = "Buscar";
	private JTextField txtBuscar;
	private JTable table;
	private DefaultTableModel model;
	private JButton btnBuscar;
	private JScrollPane scrollPane;
	public String[] column = new String[] { "DNI", "NOMBRE", "APELLIDOS" , "FECHA DE NACIMIENTO" , "NUMERO" ,  "EMAIL" , "GÉNERO"};

	public PClientes() {
		init();

	}

	private void init() {
		// TODO Auto-generated method stub
		setSize(1920, 1080);
		setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(161, 110, 1140, 752);
		add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		configurarTabla();

		JLabel lblClientes = new JLabel("Clientes");
		lblClientes.setFont(new Font("Dialog", Font.BOLD, 24));
		lblClientes.setBounds(74, 49, 248, 79);
		add(lblClientes);

		txtBuscar = new JTextField();
		txtBuscar.setToolTipText("Buscar");
		txtBuscar.setFont(new Font("Dialog", Font.PLAIN, 20));
		txtBuscar.setBounds(1340, 88, 300, 64);
		add(txtBuscar);
		txtBuscar.setColumns(10);

		btnBuscar = new JButton(BUSCAR);
		btnBuscar.setFont(new Font("Dialog", Font.PLAIN, 20));
		btnBuscar.setBounds(1650, 88, 195, 64);
		add(btnBuscar);

		
	}


	public void configurarTabla() {
		model = new DefaultTableModel() {

			@Override
			public boolean isCellEditable(int row, int column) {
				/*
				 * 
				 * if (column == 2) { return true; } else {
				 */
				return false;
			}

		};
		model.addColumn(column[0]);
		model.addColumn(column[1]);
		model.addColumn(column[2]);
		model.addColumn(column[3]);
		model.addColumn(column[4]);
		model.addColumn(column[5]);
		model.addColumn(column[6]);
		table.setModel(model);

	}

	public void rellenarTabla(ArrayList<Cliente> lA) {
		// vaciamos la tabla
		model.setRowCount(0);

		Object[] fila = new Object[2];

		for (Cliente a : lA) {
			fila[0] = a.getDni();
			fila[1] = a.getNombre();
			fila[2] = a.getApellido();
			fila[3] = a.getDiaNac() + "/" + a.getMesNac() + "/" + a.getAnioNac();
			fila[4] = "+" + a.getPrefijo() + " " + a.getTelefono();
			fila[5] = a.getEmail();
			fila[6] = a.getGenero();

			model.addRow(fila);
		}
	}

	public String getNombre() {
		if (txtBuscar.getText().isBlank()) {
			return null;
		} else {
			return txtBuscar.getText();
		}

	}

	public void setListener(Control control) {
		btnBuscar.addActionListener(control);
	}
}