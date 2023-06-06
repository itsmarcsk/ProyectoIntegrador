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




	public Cliente(String nombre, String apellido, int diaNac, int mesNac, int anioNac, String dni, String email, String contrasenia) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.diaNac = diaNac;
		this.mesNac = mesNac;
		this.anioNac = anioNac;
		this.dni = dni;
		this.email = email;
		this.contrasenia = contrasenia;
	}


	public Cliente(String nombre, String apellido, int diaNac, int mesNac, int anioNac, String dni, String email) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.diaNac = diaNac;
		this.mesNac = mesNac;
		this.anioNac = anioNac;
		this.dni = dni;
		this.email = email;
	}
	

	public Cliente(String nombre, String apellido, int diaNac, int mesNac, int anioNac, String dni, int prefijo,
			int telefono, String genero, String email) {
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
}