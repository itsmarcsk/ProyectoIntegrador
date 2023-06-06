package main;

import java.awt.EventQueue;

import vista.PActividadAdmin;
import vista.PActividades;
import vista.PAniadirModificar;
import vista.PClientes;
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
				PConsultarClientes pCC = new PConsultarClientes();
				PPerfil pP = new PPerfil();
				PClientes pC = new PClientes();
				PActividadAdmin pAA = new PActividadAdmin();
				PAniadirModificar pAM = new PAniadirModificar();
				Control control = new Control(vLogin, vRegistro, vPA, vPC, PA, pP, pCC , pC, pAA, pAM);
				
				
				
				vLogin.setListener(control);
				vRegistro.setListener(control);
				vPA.setListener(control);
                vPC.setListener(control);
                PA.setListener(control);
                pP.setListener(control);
                pC.setListener(control);
                pAA.setListener(control);
                pAM.setListener(control);
				
				vLogin.hacerVisible();
			}
		});
	}
}
