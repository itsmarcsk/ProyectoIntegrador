
package vista;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

import controlador.Control;
import modelo.Actividad;

public class PActividades extends JPanel {
	public static final String CONSULTA = "Consultar";
	public static final String UNIRSE = "Unirse";
	private JTable table;
	private JScrollPane scrpTabla;
	private DefaultTableModel model = new DefaultTableModel();
	public String[] column = new String[] { "ACTIVIDAD", "PRECIO" };
	private JComboBox cmbhoraFin;
	private JLabel lblhoraFin;
	private JComboBox cmbhoraIni;
	private JButton btnConsulta;
	private JButton btnUnirse;
	private JTextArea txtTablaDescripcion;

	public PActividades() {
		setLayout(null);
		init();
	}

	private void init() {
		setSize(1920, 984);

		

		cmbhoraIni = new JComboBox();
		cmbhoraIni.setFont(new Font("Dialog", Font.PLAIN, 20));
		cmbhoraIni.setModel(new DefaultComboBoxModel(new String[] { "", "9:00 ", "10:00", "11:00", "12:00", "13:00",
				"14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00" }));
		cmbhoraIni.setBounds(712, 129, 279, 69);
		add(cmbhoraIni);

		JLabel lblhoraIni = new JLabel("Hora de Inicio :");
		lblhoraIni.setFont(new Font("Dialog", Font.BOLD, 24));
		lblhoraIni.setBounds(762, 52, 185, 84);
		add(lblhoraIni);

		cmbhoraFin = new JComboBox();
		cmbhoraFin.setFont(new Font("Dialog", Font.PLAIN, 20));
		cmbhoraFin.setModel(new DefaultComboBoxModel(new String[] { "", "10:00", "11:00", "12:00", "13:00", "14:00",
				"15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00" }));
		cmbhoraFin.setBounds(1398, 129, 279, 69);
		add(cmbhoraFin);

		lblhoraFin = new JLabel("Hora Final :");
		lblhoraFin.setFont(new Font("Dialog", Font.BOLD, 24));
		lblhoraFin.setBounds(1477, 52, 145, 84);
		add(lblhoraFin);

		btnUnirse = new JButton(UNIRSE);
		btnUnirse.setFont(new Font("Dialog", Font.PLAIN, 24));
		btnUnirse.setBounds(1248, 850, 267, 77);
		add(btnUnirse);

		btnConsulta = new JButton(CONSULTA);
		btnConsulta.setFont(new Font("Dialog", Font.PLAIN, 24));
		btnConsulta.setBounds(890, 850, 267, 77);
		add(btnConsulta);

		activar(false);
		scrpTabla = new JScrollPane();
		scrpTabla.setBounds(0, 0, 475, 1080);
		add(scrpTabla);

		table = new JTable();
		scrpTabla.setViewportView(table);
		
		JScrollPane scrpDesc = new JScrollPane();
		scrpDesc.setBounds(712, 245, 966, 546);
		add(scrpDesc);
		
		txtTablaDescripcion = new JTextArea();
		txtTablaDescripcion.setEditable(false);
		txtTablaDescripcion.setFont(new Font("Dialog", Font.PLAIN, 18));
		scrpDesc.setViewportView(txtTablaDescripcion);
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
			if (se != -1 && hF != -1) {
				if (se < hF) {
					horaFin = (String) cmbhoraFin.getSelectedItem();
				}
			}
		}

		return new Actividad(horaInicio, horaFin);

	}

	public void setListener(Control c) {
		btnConsulta.addActionListener(c);
		btnUnirse.addActionListener(c);
	}

	public void activar(boolean b) {
		cmbhoraFin.setEnabled(b);
		cmbhoraIni.setEnabled(b);
		btnUnirse.setEnabled(b);
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
		if (cmbhoraFin.getSelectedIndex() == 0 || cmbhoraIni.getSelectedIndex() == 0
				|| cmbhoraFin.getSelectedIndex() < cmbhoraIni.getSelectedIndex()) {
			return false;
		} else {
			return true;
		}
	}

	public Actividad rellenarActividad() {
		if (comprobarHora()) {
			return new Actividad(getNombre(), cmbhoraIni.getSelectedItem() + "", cmbhoraFin.getSelectedItem() + "");
		} else {
			return null;
		}
	}
	public void limpiarDatos() {
		cmbhoraFin.setSelectedIndex(0);
		cmbhoraIni.setSelectedIndex(0);
		txtTablaDescripcion.setText("");
	}
}