package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Actividad;
import modelo.Cliente;

public class Persistance {
	private AccesoDB aDB;
	static final String TABLA_ADMIN = "Administradores";
	static final String COL_DNI_ADMIN = "DNI";
	static final String COL_NOMBRE_ADMIN = "NOMBRE";
	static final String COL_APELLIDO_ADMIN = "APELLIDOS";
	static final String COL_CONTRASENA_ADMIN = "CONTRASENA";
	static final String TABLA_CLI = "Clientes";
	static final String COL_DNI_CLI = "DNI";
	static final String COL_NOMBRE_CLI = "NOMBRE";
	static final String COL_APELLIDO_CLI = "APELLIDOS";
	static final String COL_DIA_NAC_CLI = "DIA_NAC";
	static final String COL_MES_NAC_CLI = "MES_NAC";
	static final String COL_ANO_NAC_CLI = "ANO_NAC";
	static final String COL_PREFIJO_NUM_CLI = "PREFIJO_NUM";
	static final String COL_NUM_TEL_CLI = "NUM_TEL";
	static final String COL_CONTRASENA_CLI = "CONTRASENA";
	static final String COL_EMAIL_CLI = "EMAIL";
	static final String COL_GENERO_CLI = "GENERO";
	static final String TABLA_CLIENTES_ACTIVIDADES = "Clientes_Actividades";
	static final String COL_NOMBRE_CLI_ACT = "NOMBRE";
	static final String COL_DNI_CLI_ACT = "DNI";
	static final String COL_HORARIO_INI = "HORARIO_INI";
	static final String COL_HORARIO_FIN = "HORARIO_FIN";
	static final String TABLA_ACTIVIDADES = "Actividades";
	static final String COL_PRECIO_ACTI = "PRECIO";
	static final String COL_NOM_ACTI = "NOMBRE";
	static final String COL_DES_ACT = "DESCRIPCION";

	public Persistance() {
		aDB = new AccesoDB();
	}
	//inicio de sesion cliente
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

			if (dni.equals(rslt.getString(COL_DNI_CLI)) && contrasenia.equals(rslt.getString(COL_CONTRASENA_CLI))) {
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
	//inicio de sesion admin
	public boolean confirmarInicioAdmin(String dni, String contrasenia) {
		String queryAdmin = "SELECT " + COL_DNI_ADMIN + ", " + COL_CONTRASENA_ADMIN + " FROM " + TABLA_ADMIN + " WHERE "
				+ COL_DNI_ADMIN + " = ?";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rslt = null;
		boolean conseguido = false;
		try {
			con = aDB.getConnection();
			stmt = con.prepareStatement(queryAdmin);
			stmt.setString(1, dni);
			rslt = stmt.executeQuery();
			if (dni.equals(rslt.getString(COL_DNI_ADMIN)) && contrasenia.equals(rslt.getString(COL_CONTRASENA_ADMIN))) {
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
	// datos para PPerfil del cliente
	public Cliente consultarDatos(String dni) {
		String query = "SELECT " + COL_DNI_CLI + ", "  + COL_NOMBRE_CLI + ", " + COL_APELLIDO_CLI + ", " + COL_DIA_NAC_CLI + ", " + COL_MES_NAC_CLI + ", " + COL_ANO_NAC_CLI + ", " + COL_EMAIL_CLI + " FROM " + TABLA_CLI + " WHERE " + COL_DNI_CLI + "  = ?" ;
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rslt = null;
		Cliente c = null;
		try {
			con = aDB.getConnection();
			stmt = con.prepareStatement(query);
			stmt.setString(1, dni);
			rslt = stmt.executeQuery();
			c = new Cliente(rslt.getString(COL_NOMBRE_CLI), rslt.getString(COL_APELLIDO_CLI) , rslt.getInt(COL_DIA_NAC_CLI), rslt.getInt(COL_MES_NAC_CLI), rslt.getInt(COL_ANO_NAC_CLI) , rslt.getString(COL_DNI_CLI), rslt.getString(COL_EMAIL_CLI));
			
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
		return c;
	}
	public ArrayList<Cliente> consultarClientes(String nombre) {
		String query = "SELECT * FROM " + TABLA_CLI + " WHERE " + COL_NOMBRE_CLI + " LIKE ?";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rslt = null;
		ArrayList<Cliente> listaClientes = new ArrayList<>();
		try {
			con = aDB.getConnection();
			stmt = con.prepareStatement(query);
			stmt.setString(1, nombre);
			rslt = stmt.executeQuery();
			while (rslt.next()) {
				listaClientes.add(new Cliente(rslt.getString(COL_NOMBRE_CLI), rslt.getString(COL_APELLIDO_CLI), rslt.getInt(COL_DIA_NAC_CLI), rslt.getInt(COL_MES_NAC_CLI), rslt.getInt(COL_ANO_NAC_CLI), rslt.getString(COL_DNI_CLI), rslt.getInt(COL_PREFIJO_NUM_CLI), rslt.getInt(COL_NUM_TEL_CLI), rslt.getString(COL_GENERO_CLI), rslt.getString(COL_EMAIL_CLI)));
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
		return listaClientes;
	}
	public ArrayList<Actividad> consultarActividadesCliente(String dni) {
		String query = "SELECT " + COL_NOM_ACTI + ", " + COL_PRECIO_ACTI + ", " + COL_DES_ACT + " FROM " + TABLA_ACTIVIDADES + " WHERE " + COL_NOM_ACTI + " = (SELECT " + COL_NOMBRE_CLI_ACT + " FROM " + TABLA_CLIENTES_ACTIVIDADES + " WHERE " + COL_DNI_CLI + " = ?)";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rslt = null;
		ArrayList<Actividad> listaActividad = new ArrayList<>();
		try {
			con = aDB.getConnection();
			stmt = con.prepareStatement(query);
			stmt.setString(1, dni);
			rslt = stmt.executeQuery();
			while (rslt.next()) {
				listaActividad.add(new Actividad(rslt.getString(COL_NOM_ACTI), rslt.getInt(COL_PRECIO_ACTI), rslt.getString(COL_DES_ACT)));
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
		return listaActividad;
	
	}
	//consultar actividades para PActividad
	public ArrayList<Actividad> consultarActividades(){
		String query = "SELECT " + COL_NOM_ACTI + ", " + COL_PRECIO_ACTI + " FROM " + TABLA_ACTIVIDADES;
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rslt = null;
		ArrayList<Actividad> listaActividad = new ArrayList<>();

		try {
			con = aDB.getConnection();
			stmt = con.prepareStatement(query);
			rslt = stmt.executeQuery();
			while (rslt.next()) {
				listaActividad.add(new Actividad(rslt.getString(COL_NOM_ACTI), rslt.getInt(COL_PRECIO_ACTI)));
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
		return listaActividad;
	}
	public Actividad consultarActividadesTodos(String nombre){
		String query = "SELECT " + COL_NOM_ACTI + ", " + COL_PRECIO_ACTI + ", " + COL_DES_ACT + " FROM " + TABLA_ACTIVIDADES + " WHERE " + COL_NOM_ACTI + " = ?";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rslt = null;
		Actividad c = null;
		try {
			con = aDB.getConnection();
			stmt = con.prepareStatement(query);
			stmt.setString(1, nombre);
			rslt = stmt.executeQuery();
			c = new Actividad(rslt.getString(COL_NOM_ACTI),rslt.getInt(COL_PRECIO_ACTI),rslt.getString(COL_DES_ACT));
			
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
		return c;
	}
	
	public String consultaDescripcion(String nombre) {
        String query = "SELECT " + COL_DES_ACT + " FROM " + TABLA_ACTIVIDADES + " WHERE " + COL_NOM_ACTI + " = ?";
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rslt = null;
        String c = null;
        try {
            con = aDB.getConnection();
            stmt = con.prepareStatement(query);
            stmt.setString(1, nombre);
            rslt = stmt.executeQuery();
            c = rslt.getString(COL_DES_ACT);
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
        return c;
    }
	
	public int modificarActividad(Actividad c) {
		String query = "UPDATE " + TABLA_ACTIVIDADES + " SET " + COL_PRECIO_ACTI
				+ " = ?, " + COL_DES_ACT + " = ? " +   " WHERE " + COL_NOM_ACTI + " = ?";
		int res = 0;
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = aDB.getConnection();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, c.getPrecio());
			stmt.setString(2, c.getDescripcion());
			stmt.setString(3, c.getNombre());
			
			res = stmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			res = -1;
		} finally {
			try {

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
		return res;
	}
	//actualizar datos de cliente
	public int actualizarDatosCliente(String dni, Cliente c) {
		String query = "UPDATE " + TABLA_CLI + " SET " + COL_NOMBRE_CLI + " = ?, " + COL_APELLIDO_CLI
				+ " = ?, " + COL_DIA_NAC_CLI + " = ?, " + COL_MES_NAC_CLI + " = ?, " + COL_ANO_NAC_CLI + " = ?, " + COL_EMAIL_CLI
				+ " = ?" + COL_CONTRASENA_CLI + " = ?, " +   " WHERE " + COL_DNI_CLI + " = ?";
		int res = 0;
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = aDB.getConnection();
			stmt = con.prepareStatement(query);
			stmt.setString(1, c.getNombre());
			stmt.setString(2, c.getApellido());
			stmt.setInt(3, c.getDiaNac());
			stmt.setInt(4, c.getMesNac());
			stmt.setInt(5, c.getAnioNac());
			stmt.setString(6, c.getEmail());
			stmt.setString(7, c.getContrasenia());
			stmt.setString(8, dni);
			res = stmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			res = -1;
		} finally {
			try {

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
		return res;
	}
	//borrar para PPerfil y para PConsultarClientes
	public int borrarCuenta(String dni) {
		String query = "DELETE FROM " + TABLA_CLI + " WHERE " + COL_DNI_CLI + " = ?";
		int res = 0;
		Connection con = null;
		PreparedStatement stmt = null;

		try {
			con = aDB.getConnection();
			stmt = con.prepareStatement(query);
			stmt.setString(1, dni);
			res = stmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			res = -1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			res = -1;
		} finally {
			try {

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
		return res;
	}
	
	public int borrarActividad(String nombre) {
        String query = "DELETE FROM " + TABLA_ACTIVIDADES + " WHERE " + COL_NOM_ACTI + " = ?";
        int res = 0;
        Connection con = null;
        PreparedStatement stmt = null;

        try {
            con = aDB.getConnection();
            stmt = con.prepareStatement(query);
            stmt.setString(1, nombre);
            res = stmt.executeUpdate();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            res = -1;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            res = -1;
        } finally {
            try {

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
        return res;
        
    }
	
	public int borrarActividadCliente(String nombre, String dni) {
        String query = "DELETE FROM " + TABLA_CLIENTES_ACTIVIDADES + " WHERE " + COL_NOMBRE_CLI_ACT + " = ? AND " + COL_DNI_CLI_ACT + " = ?";
        int res = 0;
        Connection con = null;
        PreparedStatement stmt = null;

        try {
            con = aDB.getConnection();
            stmt = con.prepareStatement(query);
            stmt.setString(1, nombre);
            stmt.setString(2, dni);
            res = stmt.executeUpdate();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            res = -1;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            res = -1;
        } finally {
            try {

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
        return res;
    }
	
	//registrar datos de cliente
	public int registrarCliente(Cliente c) {
		String query = "INSERT INTO " + TABLA_CLI + "( " + COL_DNI_CLI + ", " + COL_NOMBRE_CLI + ", " + COL_APELLIDO_CLI
				+ ", " + COL_DIA_NAC_CLI + ", " + COL_MES_NAC_CLI + ", " + COL_ANO_NAC_CLI + ", " + COL_PREFIJO_NUM_CLI + ", "
				+ COL_NUM_TEL_CLI + ", " + COL_CONTRASENA_CLI + ", " + COL_EMAIL_CLI + ", " + COL_GENERO_CLI + ") VALUES (?, ?, ? , ? , ? , ? , ? , ?, ? , ? , ?)";

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
			stmt.setString(10, c.getEmail());
			stmt.setString(11, c.getGenero());
			res = stmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			res = -1;
		}
		return res;
	}
	public int registrarActividad(Actividad a) {
		String query = "INSERT INTO " + TABLA_ACTIVIDADES + " ( " + COL_NOM_ACTI + ", " + COL_PRECIO_ACTI + ", " + COL_DES_ACT + " ) VALUES (?, ? , ?)";
		Connection con = null;
		PreparedStatement stmt = null;
		int res = 0;
		try {
			con = aDB.getConnection();
			stmt = con.prepareStatement(query);
			stmt.setString(1, a.getNombre());
			stmt.setInt(2, a.getPrecio());
			stmt.setString(3, a.getDescripcion());
			res = stmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			res = -1;
		}
		return res;
	}
	
	public int registrarActividadCliente(String dni, Actividad c) {
        String query = "INSERT INTO " + TABLA_CLIENTES_ACTIVIDADES + " ( " + COL_DNI_CLI_ACT + ", " + COL_NOMBRE_CLI_ACT + ", " +  COL_HORARIO_INI + ", " + COL_HORARIO_FIN + " ) VALUES (?,?,?,?)";
        Connection con = null;
        PreparedStatement stmt = null;
        int res = 0;
        try {
            con = aDB.getConnection();
            stmt = con.prepareStatement(query);
            stmt.setString(1, dni);
            stmt.setString(2, c.getNombre());
            stmt.setString(3, c.getHoraIni());
            stmt.setString(4, c.getHoraFin());
            res = stmt.executeUpdate();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            res = -1;
        }
        return res;
    }
}