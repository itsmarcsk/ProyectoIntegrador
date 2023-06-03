package main;

import java.awt.EventQueue;

import vista.PActividades;
import vista.VLogin;
import vista.VPrincipalAdmin;
import vista.VPrincipalCliente;
import vista.VRegistro;
import controlador.Control;

public class Inicio {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				VLogin vLogin = new VLogin();
				VRegistro vRegistro = new VRegistro();
				VPrincipalAdmin vPA = new VPrincipalAdmin();
				VPrincipalCliente vPC = new VPrincipalCliente();
				PActividades PA = new PActividades();
				Control control = new Control(vLogin, vRegistro, vPA, vPC, PA);
				vLogin.hacerVisible();
			}
		});
	}
}
