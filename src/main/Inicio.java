package main;

import java.awt.EventQueue;

import vista.PActividades;
import vista.PConsultarClientes;
import vista.PPerfil;
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
				PConsultarClientes pC = new PConsultarClientes();
				PPerfil pP = new PPerfil();
				Control control = new Control(vLogin, vRegistro, vPA, vPC, PA, pC, pP);
				vLogin.hacerVisible();
			}
		});
	}
}
