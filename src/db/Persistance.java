package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.Cliente;

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
	static final String COL_ANO_NAC_CLI = "AÑO NACIMIENTO";
	static final String COL_PREFIJO_NUM_CLI = "PREFIJO NUMERO";
	static final String COL_NUM_TEL_CLI = "NUMERO DE TELEFONO";
	static final String COL_CONTRASENA_CLI = "CONTRASEÑA";
	static final String COL_ACTIVIDADES_CLI = "ACTIVIDADES";
	static final String COL_RESERVAS_CLI = "RESERVAS";
	static final String COL_EMAIL_CLI = "EMAIL";
	static final String COL_GENERO_CLI = "GENERO";
	static final String TABLA_CLIENTES_ACTIVIDADES = "Clientes_Actividades";
	static final String COL_ID_CLI_ACT = "ID";
	static final String COL_DNI_CLI_ACT = "DNI";
	static final String TABLA_ACTIVIDADES = "Actividades";
	static final String COL_ID_ACTI = "ID";
	static final String COL_PRECIO_ACTI = "PRECIO";
	static final String COL_HORARIO_INI_ACTI = "HORARIO INICIO";
	static final String COL_HORARIO_FIN_ACTI = "HORARIO FINAL";
	static final String COL_ID_DEPORTE_ACTI = "ID DEPORTE";

	public Persistance() {
		aDB = new AccesoDB();
	}

	public boolean confirmarInicioCliente(String dni, String contrasenia) {
		String queryCliente = "SELECT " + COL_DNI_CLI + ", " + COL_CONTRASENA_CLI + " FROM " + TABLA_CLI + " WHERE "
				+ COL_DNI_CLI + " = ?";
		Cliente c;
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rslt = null;
		boolean conseguido = false;
		try {
			con = aDB.getConnection();
			stmt = con.prepareStatement(queryCliente);
			stmt.setString(1, dni);
			rslt = stmt.executeQuery();

			if (dni == rslt.getString(COL_DNI_CLI) && contrasenia == rslt.getString(COL_CONTRASENA_CLI)) {
				conseguido = true;
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rslt != null) {
					rslt.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return conseguido;

	}

	public boolean confirmarInicioAdmin(String dni, String contrasenia) {
		String queryAdmin = "SELECT " + COL_DNI_ADMIN + ", " + COL_CONTRASENA_ADMIN + " FROM " + TABLA_CLI + " WHERE "
				+ COL_DNI_CLI + " = ?";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rslt = null;
		boolean conseguido = false;
		try {
			con = aDB.getConnection();
			stmt = con.prepareStatement(queryAdmin);
			stmt.setString(1, dni);
			rslt = stmt.executeQuery();
			if (dni == rslt.getString(COL_DNI_ADMIN) && contrasenia == rslt.getString(COL_CONTRASENA_ADMIN)) {
				conseguido = true;
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rslt != null) {
					rslt.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return conseguido;

	}

	public int registrarCliente(Cliente c) {
		String query = "INSERT INTO " + TABLA_CLI + "( " + COL_DNI_CLI + ", " + COL_NOMBRE_CLI + ", " + COL_APELLIDO_CLI
				+ ", " + COL_DIA_NAC_CLI + ", " + COL_MES_NAC_CLI + ", " + COL_ANO_NAC_CLI + ", " + COL_PREFIJO_NUM_CLI + ", "
				+ COL_NUM_TEL_CLI + ", " + COL_CONTRASENA_CLI + ", " + COL_ACTIVIDADES_CLI + ", " + COL_RESERVAS_CLI + ", " + COL_EMAIL_CLI + ", " + COL_GENERO_CLI + ") VALUES (?, ?, ? , ? , ? , ? , ? , ? , ? , ?, ? , ? , ?);";

		Connection con = null;
		PreparedStatement stmt = null;
		int res = 0;
		try {
			con = aDB.getConnection();
			stmt = con.prepareStatement(query);
			stmt.setString(1, c.getDni());
			stmt.setString(2, c.getNombre());
			stmt.setString(3, c.getApellido());
			stmt.setInt(4, c.getDiaNac());
			stmt.setInt(5, c.getMesNac());
			stmt.setDouble(6, c.getAnioNac());
			stmt.setDouble(7, c.getPrefijo());
			stmt.setInt(8, c.getTelefono());
			stmt.setString(9, c.getContrasenia());
			stmt.setInt(10, c.getActividades());
			stmt.setInt(11, c.getReservas());
			stmt.setString(12, c.getEmail());
			stmt.setString(13, c.getGenero());
			res = stmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			res = -1;
		}
		return res;
	}
}
