
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
	public static final String CONSULTA = "Consultar";
	public static final String UNIRSE = "Unirse";
	private JTable table;
	private JScrollPane scrollPane;
	private DefaultTableModel model = new DefaultTableModel();
	public String[] column = new String[] { "ACTIVIDAD", "PRECIO"};
	private JComboBox cmbhoraFin;
	private JLabel lblhoraFin;
	private JTextField txtTablaDescripcion;
	private JComboBox cmbhoraIni;
	private JButton btnConsulta;
	private JButton btnUnirse;
	public PActividades() {
		setLayout(null);
		init();
	}

	private void init() {
		setSize(1920, 1080);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 475, 1080);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		configurarTabla();
		
		cmbhoraIni = new JComboBox();
		cmbhoraIni.setModel(new DefaultComboBoxModel(new String[] {"", "9:00 ", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00"}));
		cmbhoraIni.setBounds(712, 172, 279, 69);
		add(cmbhoraIni);
		
		JLabel lblhoraIni = new JLabel("Hora de Inicio :");
		lblhoraIni.setFont(new Font("Dialog", Font.BOLD, 24));
		lblhoraIni.setBounds(762, 95, 185, 84);
		add(lblhoraIni);
		
		cmbhoraFin = new JComboBox();
		cmbhoraFin.setModel(new DefaultComboBoxModel(new String[] {"", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00"}));
		cmbhoraFin.setBounds(1398, 172, 279, 69);
		add(cmbhoraFin);
		
		lblhoraFin = new JLabel("Hora Final :");
		lblhoraFin.setFont(new Font("Dialog", Font.BOLD, 24));
		lblhoraFin.setBounds(1477, 95, 145, 84);
		add(lblhoraFin);
		
		txtTablaDescripcion = new JTextField();
		txtTablaDescripcion.setFont(new Font("Dialog", Font.PLAIN, 24));
		txtTablaDescripcion.setEnabled(false);
		txtTablaDescripcion.setEditable(false);
		txtTablaDescripcion.setBounds(712, 315, 965, 537);
		add(txtTablaDescripcion);
		txtTablaDescripcion.setColumns(10);
		
		btnUnirse = new JButton(UNIRSE);
		btnUnirse.setFont(new Font("Dialog", Font.PLAIN, 24));
		btnUnirse.setBounds(1248, 914, 267, 77);
		add(btnUnirse);
		
		btnConsulta = new JButton(CONSULTA);
		btnConsulta.setFont(new Font("Dialog", Font.PLAIN, 24));
		btnConsulta.setBounds(890, 914, 267, 77);
		add(btnConsulta);
		
		activar(false);
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
		btnConsulta.addActionListener(c);
		btnUnirse.addActionListener(c);
	}
	
	public void activar(boolean b) {
		cmbhoraFin.setEnabled(b);
		cmbhoraIni.setEnabled(b);
	}
	
	public String getNombre() {
		if (table.getSelectedRow() == -1) {
			return "";
		} else {
			return model.getValueAt(table.getSelectedRow(), 0).toString();
		}
	}
	
	public void rellenarDesc(String desc) {
		txtTablaDescripcion.setText(desc);
	}
	
	public boolean comprobarHora() {
		if (cmbhoraFin.getSelectedIndex() == 0 || cmbhoraIni.getSelectedIndex() == 0 || cmbhoraFin.getSelectedIndex() > cmbhoraIni.getSelectedIndex()) {
			return false;
		} else {
			return true;
		}
	}
	
	public Actividad rellenarActividad() {
		if (comprobarHora()) {
			return new Actividad(getNombre(),cmbhoraIni.getSelectedItem() + "", cmbhoraFin.getSelectedItem() + "");
		} else {
			return null;
		}
	}
}

