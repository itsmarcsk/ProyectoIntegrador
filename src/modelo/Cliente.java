package modelo;

public class Cliente {
	
	private String nombre;
	private String apellido;
	private int diaNac;
	private int mesNac;
	private int anioNac;
	private String dni;
	private int prefijo;
	private int telefono;
	private String genero;
	private String email;
	private String contrasenia;
	private int actividades;
	private int reservas;
	
	
	public Cliente(String nombre, String apellido, int diaNac, int mesNac, int anioNac, String dni, int prefijo,
			int telefono, String genero, String email, String contrasenia) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.diaNac = diaNac;
		this.mesNac = mesNac;
		this.anioNac = anioNac;
		this.dni = dni;
		this.prefijo = prefijo;
		this.telefono = telefono;
		this.genero = genero;
		this.email = email;
		this.contrasenia = contrasenia;
		
	}
	

	public Cliente(String nombre, String apellido, int diaNac, int mesNac, int anioNac, String dni, int prefijo,
			int telefono, String genero, String email, String contrasenia, int actividades, int reservas) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.diaNac = diaNac;
		this.mesNac = mesNac;
		this.anioNac = anioNac;
		this.dni = dni;
		this.prefijo = prefijo;
		this.telefono = telefono;
		this.genero = genero;
		this.email = email;
		this.contrasenia = contrasenia;
		this.actividades = actividades;
		this.reservas = reservas;
	}


	public Cliente(String dni, String contrasenia) {
		this.dni = dni;
		this.contrasenia = contrasenia;
	}


	public String getNombre() {
		return nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public int getDiaNac() {
		return diaNac;
	}


	public int getMesNac() {
		return mesNac;
	}


	public int getAnioNac() {
		return anioNac;
	}


	public String getDni() {
		return dni;
	}


	public int getPrefijo() {
		return prefijo;
	}


	public int getTelefono() {
		return telefono;
	}


	public String getGenero() {
		return genero;
	}


	public String getEmail() {
		return email;
	}


	public String getContrasenia() {
		return contrasenia;
	}


	public int getActividades() {
		return actividades;
	}


	public int getReservas() {
		return reservas;
	}
	
	
}
