package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JMenuItem;

import db.Persistance;
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
	private PAniadirModificar pAM;

	public Control(VLogin vLogin, VRegistro vRegistro, VPrincipalAdmin vPA, VPrincipalCliente vPC, PActividades pA,
			PPerfil pP, PConsultarClientes pCC, PClientes pC, PActividadAdmin pAA, PAniadirModificar pAM) {
		this.vLogin = vLogin;
		this.vRegistro = vRegistro;
		this.vPA = vPA;
		this.vPC = vPC;
		this.PA = pA;
		this.PP = pP;
		this.pCC = pCC;
		this.pC = pC;
		this.pAA = pAA;
		this.pAM = pAM;
		pers = new Persistance();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() instanceof JMenuItem) {
			if (e.getActionCommand().equals(VPrincipalCliente.INSTALACIONES)) {

			} else if (e.getActionCommand().equals(VPrincipalCliente.ACTIVIDADES)) {
				vPC.cargarPanel(PA);
				
			} else if (e.getActionCommand().equals(VPrincipalCliente.PERFIL)) {
				vPC.cargarPanel(PP);
				
			} else if (e.getActionCommand().equals(VPrincipalCliente.SALIR)) {
				if (vPC.mostrarPregunta("Se va a cerrar la aplicación, ¿desea continuar?")) {
					System.exit(0);
				}
			} else if (e.getActionCommand().equals(VPrincipalAdmin.MODIFICACION)) {
				
			} else if (e.getActionCommand().equals(VPrincipalAdmin.REGISTRO)) {
				
			} else if (e.getActionCommand().equals(VPrincipalAdmin.SALIR)) {
				if (vPC.mostrarPregunta("Se va a cerrar la aplicación, ¿desea continuar?")) {
					System.exit(0);
				}
			}
		} else if (e.getSource() instanceof JButton) {
			//TODO PANEL PERFIL
			if (e.getActionCommand().equals(PPerfil.CONSULTAR_ACTIVIDAD)) {
				
			} else if (e.getActionCommand().equals(PPerfil.BORRAR_ACTIVIDAD)) {
				
			} else if (e.getActionCommand().equals(PPerfil.BORRAR_CUENTA)) {
				
			} else if (e.getActionCommand().equals(PPerfil.GUARDAR_CAMBIOS)) {
				
			//TODO PANEL ACTIVIDADES
			} else if (e.getActionCommand().equals(PActividades.UNIRSE)) {
				
			} else if (e.getActionCommand().equals(PActividades.CONSULTA)) {
				
			//TODO PANEL AÑADIR MODIFICAR ACTIVIDAD
			} else if (e.getActionCommand().equals(PAniadirModificar.ANIADIR_ACTIVIDAD)) {
				
			} else if (e.getActionCommand().equals(PAniadirModificar.MODIFICAR_ACTIVIDAD)) {
				
			//TODO VENTANA LOGIN
			} else if (e.getActionCommand().equals(VLogin.INICIO_SESION)) {
				
			} else if (e.getActionCommand().equals(VLogin.REGISTRARSE)) {
				
			}
		}
	}
}