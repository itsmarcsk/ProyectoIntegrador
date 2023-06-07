package main;

import java.awt.EventQueue;

import vista.PActividadAdmin;
import vista.PActividades;
import vista.PAniadirModificar;
import vista.PConsultarClientes;
import vista.PImgInicio;
import vista.PInstalaciones;
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
				PActividadAdmin pAA = new PActividadAdmin();
				PAniadirModificar pAM = new PAniadirModificar();
				PInstalaciones pI = new PInstalaciones();
				PImgInicio pII = new PImgInicio();
				
				Control control = new Control(vLogin, vRegistro, vPA, vPC, PA, pP, pCC , pAA, pAM, pI, pII);
				
				
				
				vLogin.setListener(control);
				vRegistro.setListener(control);
				vPA.setListener(control);
                vPC.setListener(control);
                PA.setListener(control);
                pP.setListener(control);
                pAA.setListener(control);
                pAM.setListener(control);
				
				vLogin.hacerVisible();
			}
		});
	}
}
