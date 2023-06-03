package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import db.Persistance;
import vista.PActividades;
import vista.VLogin;
import vista.VPrincipalAdmin;
import vista.VPrincipalCliente;
import vista.VRegistro;

public class Control implements ActionListener{

	private VLogin vLogin;
	private VRegistro vRegistro;
	private VPrincipalAdmin vPA;
	private VPrincipalCliente vPC;
	private PActividades PA;
	private Persistance pers;
	public Control(VLogin vLogin, VRegistro vRegistro,VPrincipalAdmin vPA, VPrincipalCliente vPC, PActividades PA) {
		
		this.vLogin = vLogin;
		this.vRegistro = vRegistro;
		this.vPA = vPA;
		this.vPC = vPC;
		this.PA = PA;
		pers = new Persistance();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
