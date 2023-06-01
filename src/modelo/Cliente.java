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
		super();
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
	
}
