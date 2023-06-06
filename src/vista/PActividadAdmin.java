package vista;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import modelo.Actividad;

public class PActividadAdmin extends JPanel{
	public static final String ELIMINAR = "Eliminar";
	public static final String MODIFICAR = "Modificar";
	private JButton btnEliminar;
	private JButton btnModificar;
	private DefaultTableModel model = new DefaultTableModel();
	public String[] column = new String[] { "NOMBRE", "PRECIO" ,"DESCRIPCION"};
	private JScrollPane scrollPane;
	private JTable table;
	public PActividadAdmin() {
		
		
		setLayout(null);
		init();
		
	}
	private void init() {
		setSize(1920, 1080);
		
		btnModificar = new JButton(MODIFICAR);
		btnModificar.setFont(new Font("Dialog", Font.BOLD, 24));
		btnModificar.setBounds(477, 926, 244, 81);
		add(btnModificar);
		
		btnEliminar = new JButton(ELIMINAR);
		btnEliminar.setFont(new Font("Dialog", Font.BOLD, 24));
		btnEliminar.setBounds(1198, 926, 244, 81);
		add(btnEliminar);
		
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
				 * if (column == 2) { return true; } else {
				 */
				return false;
				// }
			}

		};
		model.addColumn(column[0]);
		model.addColumn(column[1]);
		model.addColumn(column[2]);
		

		table.setModel(model);

	}
	public void rellenarTabla(ArrayList<Actividad> lA) {
		// vaciamos la tabla
		model.setRowCount(0);

		Object[] fila = new Object[2];

	for (Actividad a : lA) {
			fila[0] = a.getNombre();
			fila[1] = a.getPrecio();
			fila[2] = a.getDescripcion();
			
			model.addRow(fila);
		}
	}
	
	public void hacerVisible() {
		setVisible(true);
	}
}