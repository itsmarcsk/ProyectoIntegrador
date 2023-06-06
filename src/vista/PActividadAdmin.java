package vista;

import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JScrollBar;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import modelo.Actividad;

public class PActividadAdmin extends JPanel{
	private JButton btnEliminar;
	private JButton btnModificar;
	private DefaultTableModel model = new DefaultTableModel();
	public String[] column = new String[] { "NOMBRE", "PRECIO" ,"DESCRIPCION"};
	private JScrollBar scrollBar;
	private JTable table;
	public PActividadAdmin() {
		
		
		setLayout(null);
		init();
		
	}
	private void init() {
		
		btnModificar = new JButton("Modificar");
		btnModificar.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnModificar.setBounds(47, 246, 85, 21);
		add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnEliminar.setBounds(268, 246, 85, 21);
		add(btnEliminar);
		
		scrollBar = new JScrollBar();
		scrollBar.setBounds(433, 10, 17, 300);
		add(scrollBar);
		
		table = new JTable();
		table.setBounds(370, 184, -315, -151);
		add(table);
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