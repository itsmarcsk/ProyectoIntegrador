package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JMenuItem;

import db.Persistance;
import modelo.Actividad;
import modelo.Cliente;
import vista.PActividadAdmin;
import vista.PActividades;
import vista.PAniadirModificar;
import vista.PClientes;
import vista.PConsultarClientes;
import vista.PInstalaciones;
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
	private PInstalaciones pI;
	
	public Control(VLogin vLogin, VRegistro vRegistro, VPrincipalAdmin vPA, VPrincipalCliente vPC, PActividades pA,
			PPerfil pP, PConsultarClientes pCC, PClientes pC, PActividadAdmin pAA, PAniadirModificar pAM, PInstalaciones pI) {
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
		this.pI = pI;
		pers = new Persistance();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() instanceof JMenuItem) {
			if (e.getActionCommand().equals(VPrincipalCliente.INSTALACIONES)) {
				vPC.cargarPanel(pI);
			} else if (e.getActionCommand().equals(VPrincipalCliente.ACTIVIDADES)) {
				vPC.cargarPanel(PA);
				
			} else if (e.getActionCommand().equals(VPrincipalCliente.PERFIL)) {
				vPC.cargarPanel(PP);
				
			} else if (e.getActionCommand().equals(VPrincipalCliente.SALIR)) {
				if (vPC.mostrarPregunta("Se va a cerrar la aplicación, ¿desea continuar?")) {
					System.exit(0);
				}
			} else if (e.getActionCommand().equals(VPrincipalAdmin.CONSULTAR)) {
				vPA.cargarPanel(pAA);
			} else if (e.getActionCommand().equals(VPrincipalAdmin.ANIADIR_ACT)) {
				pAM.aniadir();
				vPA.cargarPanel(pAM);
			} else if (e.getActionCommand().equals(VPrincipalAdmin.SALIR)) {
				if (vPC.mostrarPregunta("Se va a cerrar la aplicación, ¿desea continuar?")) {
					System.exit(0);
				}
			}
		} else if (e.getSource() instanceof JButton) {
			//TODO PANEL PERFIL
			if (e.getActionCommand().equals(PPerfil.CONSULTAR_ACTIVIDAD)) {
				
				if (PP.getNombre() != null) {
					PP.rellenarDescripcion(pers.consultaDescripcion(PP.getNombre()));
				} else {
					vPC.mostrarError("No has seleccionado ninguna actividad");
				}
				
			} else if (e.getActionCommand().equals(PPerfil.BORRAR_ACTIVIDAD)) {
				
				if (PP.getNombre() != null) {
					pers.borrarActividadCliente(PP.getNombre(), vLogin.getUsuario());
				} else {
					vPC.mostrarError("No has seleccionado ninguna actividad");
				}
				
			} else if (e.getActionCommand().equals(PPerfil.BORRAR_CUENTA)) {
				
				if (vPC.mostrarPregunta("¿De verdad quieres borrar tu cuenta?")) {
					pers.borrarCuenta(vLogin.getUsuario());
				}
				
			} else if (e.getActionCommand().equals(PPerfil.GUARDAR_CAMBIOS)) {
				
				pers.actualizarDatosCliente(vLogin.getUsuario(), PP.guardarDatosPersonales());
				
			//TODO PANEL ACTIVIDADES
			} else if (e.getActionCommand().equals(PActividades.UNIRSE)) {
				
				PA.activar(false);
				if (PA.rellenarActividad() != null) {
					pers.registrarActividadCliente(vLogin.getUsuario(), PA.rellenarActividad());
				} else {
					vPC.mostrarError("Has introducido una hora de fin anterior a la hora de inicio");
				}
				
			} else if (e.getActionCommand().equals(PActividades.CONSULTA)) {
				
				if (PA.getNombre() != null) {
					PA.rellenarDesc(pers.consultaDescripcion(PA.getNombre()));
					PA.activar(true);
				} else {
					vPA.mostrarError("No se ha seleccionado una actividad");
				}
				
			//TODO PANEL AÑADIR MODIFICAR ACTIVIDAD
			} else if (e.getActionCommand().equals(PAniadirModificar.ANIADIR_ACTIVIDAD)) {
				
				if (pAM.getDatos() != null) {
					pers.registrarActividad(pAM.getDatos());
				} else {
					vPA.mostrarError("No se han rellenado todos los datos");
				}
				
			} else if (e.getActionCommand().equals(PAniadirModificar.MODIFICAR_ACTIVIDAD)) {
				Actividad c = pAM.getDatos();
				if (c == null) {
					vPA.mostrarError("No se han introducido todos los campos");
				} else {
					pers.modificarActividad(c);
				}
				
				
			//TODO PANEL PCLIENTE
			} else if (e.getActionCommand().equals(PClientes.BUSCAR)) {
				
				pers.consultarClientes(pC.getNombre());
				
			//TODO VENTANA LOGIN
			} else if (e.getActionCommand().equals(VRegistro.CANCELAR)) {
				
				vRegistro.dispose();
				vLogin.hacerVisible();
				
			} else if (e.getActionCommand().equals(VRegistro.CREAR_CUENTA)) {
				
				Cliente c = vRegistro.getDatos();
				pers.registrarCliente(c);
				
				vRegistro.dispose();
				vLogin.hacerVisible();
				
			} else if (e.getActionCommand().equals(VLogin.INICIO_SESION)) {
				
				if (pers.confirmarInicioCliente(vLogin.getUsuario(), vLogin.getPassword())) {
					vLogin.dispose();
					vPC.hacerVisible();
				} else if (pers.confirmarInicioAdmin(vLogin.getUsuario(), vLogin.getPassword())) {
					vLogin.dispose();
					vPA.hacerVisible();
				} else {
					vPA.mostrarError("No existe la cuenta introducida");
				}
				
			} else if (e.getActionCommand().equals(VLogin.REGISTRARSE)) {
				
				vLogin.dispose();
				vRegistro.hacerVisible();
				
			} else if (e.getActionCommand().equals(PActividadAdmin.MODIFICAR)) {
				
				String nombre = pAA.getNombre();
				
				Actividad c = pers.consultarActividadesTodos(nombre);
				
				pAM.rellenarDatos(c);
				
				pAM.modificar();
				vPA.cargarPanel(pAM);
			} else if (e.getActionCommand().equals(PActividadAdmin.ELIMINAR)) {
				
				if (!(pAA.getNombre().isBlank())) {
					pers.borrarActividad(pAA.getNombre());
				} else {
					vPA.mostrarError("No se ha seleccionado ninguna actividad");
				}
				
			}
		}
	}
}