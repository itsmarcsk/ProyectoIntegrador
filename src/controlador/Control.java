package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JMenuItem;

import db.Persistance;
import vista.PActividadAdmin;
import vista.PActividades;
import vista.PClientes;
import vista.PConsultarClientes;
import vista.PPerfil;
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
	private PPerfil PP;
	private PConsultarClientes pCC;
	private PClientes pC;
	private PActividadAdmin pAA;
	private Persistance pers;

	
	
	


	public Control(VLogin vLogin, VRegistro vRegistro, VPrincipalAdmin vPA, VPrincipalCliente vPC, PActividades pA,
			PPerfil pP, PConsultarClientes pCC, PClientes pC, PActividadAdmin pAA) {
		this.vLogin = vLogin;
		this.vRegistro = vRegistro;
		this.vPA = vPA;
		this.vPC = vPC;
		this.PA = pA;
		this.PP = pP;
		this.pCC = pCC;
		this.pC = pC;
		this.pAA = pAA;
		pers = new Persistance();
	}






	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() instanceof JMenuItem) {
			if (e.getActionCommand().equals(vPC.INSTALACIONES)) {

			} else if (e.getActionCommand().equals(vPC.ACTIVIDADES)) {
				vPC.cargarPanel(PA);
				
			} else if (e.getActionCommand().equals(vPC.PERFIL)) {
				vPC.cargarPanel(PP);
				
			} else if (e.getActionCommand().equals(vPC.SALIR)) {
				if (vPC.mostrarPregunta("Se va a cerrar la aplicación, ¿desea continuar?")) {
					System.exit(0);
				}
			}
		} else if (e.getSource() instanceof JButton) {
			//PANEL PERFIL
			if (e.getActionCommand().equals(PP.CONSULTAR_ACTIVIDAD)) {
				
			} else if (e.getActionCommand().equals(PP.BORRAR_ACTIVIDAD)) {
				
			} else if (e.getActionCommand().equals(PP.BORRAR_CUENTA)) {
				
			} else if (e.getActionCommand().equals(PP.GUARDAR_CAMBIOS)) {
				
			//PANEL ACTIVIDADES
			} else if (e.getActionCommand().equals(PA.UNIRSE)) {
				
			} else if (e.getActionCommand().equals(PA.CONSULTA)) {
				
			//VENTANA LOGIN
			} else if (e.getActionCommand().equals(vLogin.INICIO_SESION)) {
				
			} else if (e.getActionCommand().equals(vLogin.REGISTRARSE)) {
				
			}
		}
	}
}