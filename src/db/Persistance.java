package db;

public class Persistance {
	private AccesoDB aDB;
	static final String TABLA_ADMIN = "Administradores";
	static final String COL_DNI_ADMIN = "DNI";
	static final String COL_NOMBRE_ADMIN = "NOMBRE";
	static final String COL_APELLIDO_ADMIN = "APELLIDO";
	static final String COL_CONTRASENA_ADMIN = "CONTRASEÑA";
	static final String TABLA_CLI = "Clientes";
	static final String COL_DNI_CLI = "DNI";
	static final String COL_NOMBRE_CLI = "NOMBRE";
	static final String COL_APELLIDO_CLI = "APELLIDO";
	static final String COL_DIA_NAC_CLI = "DIA NACIMIENTO";
	static final String COL_MES_NAC_CLI = "MES NACIMIENTO";
	static final String COL_ANO_NAC_CLI ="AÑO NACIMIENTO";
	static final String COL_PREFIJO_NUM_CLI = "PREFIJO NUMERO";
	static final String COL_NUM_TEL_CLI = "NUMERO DE TELEFONO";
	static final String COL_CONTRASENA_CLI = "CONTRASEÑA";
	static final String COL_ACTIVIDADES_CLI = "ACTIVIDADES";
	static final String COL_RESERVAS_CLI = "RESERVAS";  
	static final String COL_EMAIL_CLI = "EMAIL";
	static final String COL_GENERO_CLI = "GENERO";
	static final String TABLA_DEPORTES = "Deportes";
	static final String COL_ID_DEPORTES = "ID";
	static final String COL_NOMBRE_DEPORTES = "NOMBRE";
	static final String TABLA_PISTAS = "Pistas";
	static final String COL_ID_PISTAS = "ID";
	static final String COL_PRECIO_PISTAS = "";
	static final String COL_HORARIO_INI_PISTAS = "HORARIO INICIO";
	static final String COL_HORARIO_FIN_PISTAS = "HORARIO FINAL";
	static final String COL_ID_DEPORTE_PISTAS = "ID DEPORTE";
	static final String TABLA_ACTIVIDADES = "Actividades";
	static final String COL_ID_ACTI = "ID";
	static final String COL_PRECIO_ACTI = "PRECIO";
	static final String COL_HORARIO_INI_ACTI = "HORARIO INICIO";
	static final String COL_HORARIO_FIN_ACTI = "HORARIO FINAL";
	static final String COL_ID_DEPORTE_ACTI = "ID DEPORTE";
	public Persistance() {
		aDB = new AccesoDB();
	}
} 
