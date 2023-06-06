package vista;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class PClientes extends JPanel {
	public static final String BUSCAR = "Buscar";
	private JTextField txtBuscar;
	private JTable tblClientes;
	private DefaultTableModel dtm;
	private JButton btnBuscar;
	public PClientes() {
		init();

	}

	private void init() {
		// TODO Auto-generated method stub
		setSize(1920, 1080);
		setLayout(null);
		
		JScrollPane scrpTabla = new JScrollPane();
		scrpTabla.setBounds(74, 197, 1772, 828);
		add(scrpTabla);
		
		tblClientes = new JTable();
		scrpTabla.setViewportView(tblClientes);
		
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
		
		rellenarTabla();
	}

	private void rellenarTabla() {
		// TODO Auto-generated method stub
		dtm = new DefaultTableModel();

		dtm.addColumn("DNI");
		dtm.addColumn("NOMBRE");
		dtm.addColumn("APELLIDOS");
		dtm.addColumn("FECHA DE NACIMIENTO");
		dtm.addColumn("NUMERO");
		dtm.addColumn("EMAIL");
		dtm.addColumn("ACTIVIDADES");
		dtm.addColumn("RESERVAS");
		dtm.addColumn("GÉNERO");

		tblClientes.setModel(dtm);
		
//		Al hacer click en buscar se hace un: SELECT * FROM Cliente WHERE *texto introducido* IN (DNI, NOMBRE, APELLIDOS, NUM_TEL, EMAIL, GENERO);
//		y se rellena la tabla con los datos encontrados de la tabla Cliente
	}
}
