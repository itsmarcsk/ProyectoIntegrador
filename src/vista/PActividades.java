
package vista;

import java.util.ArrayList;
import java.util.Set;
import java.util.stream.Collectors;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controlador.Control;
import modelo.Actividad;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;

public class PActividades extends JPanel {
	private JTable table;
	private JScrollPane scrollPane;
	private DefaultTableModel model = new DefaultTableModel();
	public String[] column = new String[] { "ACTIVIDAD", "PRECIO"};
	private JComboBox cmbhoraFin;
	private JLabel lblhoraFin;
	private JTextField txtTablaDescripcion;
	private JComboBox cmbhoraIni;
	private JButton btnConsulta;
	public PActividades() {
		setLayout(null);
		init();
	}

	private void init() {
		
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 177, 549);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		configurarTabla();
		
		cmbhoraIni = new JComboBox();
		cmbhoraIni.setModel(new DefaultComboBoxModel(new String[] {"", "9:00 ", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00"}));
		cmbhoraIni.setBounds(316, 110, 87, 22);
		add(cmbhoraIni);
		
		JLabel lblhoraIni = new JLabel("Hora de Inicio :");
		lblhoraIni.setFont(new Font("Dialog", Font.BOLD, 14));
		lblhoraIni.setBounds(207, 110, 115, 22);
		add(lblhoraIni);
		
		cmbhoraFin = new JComboBox();
		cmbhoraFin.setModel(new DefaultComboBoxModel(new String[] {"", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00"}));
		cmbhoraFin.setBounds(607, 110, 87, 22);
		add(cmbhoraFin);
		
		lblhoraFin = new JLabel("Hora Final :");
		lblhoraFin.setFont(new Font("Dialog", Font.BOLD, 14));
		lblhoraFin.setBounds(524, 110, 87, 22);
		add(lblhoraFin);
		
		txtTablaDescripcion = new JTextField();
		txtTablaDescripcion.setEnabled(false);
		txtTablaDescripcion.setEditable(false);
		txtTablaDescripcion.setBounds(264, 183, 388, 177);
		add(txtTablaDescripcion);
		txtTablaDescripcion.setColumns(10);
		
		JButton btnUnirse = new JButton("Unirse");
		btnUnirse.setFont(new Font("Dialog", Font.PLAIN, 14));
		btnUnirse.setBounds(509, 417, 102, 30);
		add(btnUnirse);
		
		btnConsulta = new JButton("Consulta");
		btnConsulta.setFont(new Font("Dialog", Font.PLAIN, 14));
		btnConsulta.setBounds(316, 417, 102, 30);
		add(btnConsulta);
		
		
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
		

		table.setModel(model);

	}
	public void rellenarTabla(ArrayList<Actividad> lA) {
		// vaciamos la tabla
		model.setRowCount(0);

		Object[] fila = new Object[2];

	for (Actividad a : lA) {
			fila[0] = a.getNombre();
			fila[1] = a.getPrecio();
			
			model.addRow(fila);
		}
	}
	public Actividad getDatos() {
		String horaInicio = (String) cmbhoraIni.getSelectedItem();
		String horaFin = "";
		if (!horaInicio.isEmpty()) {
			int se = cmbhoraIni.getSelectedIndex();
			int hF = cmbhoraFin.getSelectedIndex();
			if(se != -1 && hF != -1) {
				if(se < hF) {
					horaFin = (String) cmbhoraFin.getSelectedItem();
				}
			}
		}
		
		 
		return new Actividad(horaInicio, horaFin);

	}
	public void setListener (Control c) {
//		btnConsulta.addActionListener(c);
		
	}
}

