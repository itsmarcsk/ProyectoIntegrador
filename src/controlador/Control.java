package controlador;

import db.Persistance;
import vista.VLogin;
import vista.VPrincipalAdmin;
import vista.VPrincipalCliente;
import vista.VRegistro;

public class Control {

	private VLogin vLogin;
	private VRegistro vRegistro;
	private VPrincipalAdmin vPA;
	private VPrincipalCliente vPC;
	private Persistance pers;
	public Control(VLogin vLogin, VRegistro vRegistro,VPrincipalAdmin vPA, VPrincipalCliente vPC) {
		
		this.vLogin = vLogin;
		this.vRegistro = vRegistro;
		this.vPA = vPA;
		this.vPC = vPC;
		pers = new Persistance();
	}
	
	
}
