package modelo;


public class Actividad {

    private String nombre;
    private int precio;
    private String horaIni;
    private String horaFin;
    private String descripcion;
    

    public Actividad(String nombre, int precio, String descripcion) {
		this.nombre = nombre;
		this.precio = precio;
		this.descripcion = descripcion;
	}
	public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getPrecio() {
        return precio;
    }
    public void setPrecio(int precio) {
        this.precio = precio;
    }
    
    public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getHoraIni() {
        return horaIni;
    }
    public void setHoraIni(String horaIni) {
        this.horaIni = horaIni;
    }
    public String getHoraFin() {
        return horaFin;
    }
    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }

    public Actividad(String nombre, int precio, String horaIni, String horaFin) {
        this.nombre = nombre;
        this.precio = precio;
        this.horaIni = horaIni;
        this.horaFin = horaFin;

    }
    public Actividad(String horaIni, String horaFin) {
        this.horaIni = horaIni;
        this.horaFin = horaFin;
    }

	public Actividad(String nombre, int precio) {
		this.nombre = nombre;
		this.precio = precio;
	}

}