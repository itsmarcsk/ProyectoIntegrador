package vista;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controlador.Control;
import modelo.Cliente;
import modelo.Consulta;

import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

public class PConsultarClientes extends JPanel {

	public String[] column = new String[] { "DNI", "NOMBRE"};
	private DefaultTableModel model = new DefaultTableModel();
	private JScrollPane scrollPane;
	private JTable table;

	/**
	 * 
	 * Create the panel.
	 */
	public PConsultarClientes() {
		init();

	}

	private void init() {
		setLayout(null);

		JLabel lblClientes = new JLabel("Clientes");
		lblClientes.setFont(new Font("Dialog", Font.BOLD, 18));
		lblClientes.setBounds(37, 32, 124, 14);
		add(lblClientes);
		scrollPane = new JScrollPane();
		scrollPane.setBounds(161, 110, 1597, 752);
		add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		configurarTabla();

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
		

		table.setModel(model);

	}

	public void rellenarTabla(ArrayList<Cliente> lA) {
		// vaciamos la tabla
		model.setRowCount(0);

		Object[] fila = new Object[2];

		for (Cliente a : lA) {
			fila[0] = a.getDni();
			fila[1] = a.getNombre();
			

			model.addRow(fila);
		}
	}

}