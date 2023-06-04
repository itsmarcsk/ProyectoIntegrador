package modelo;

public class Consulta {

    private String nombre;
    private String dni;
    private String actividades;


    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDni() {
        return dni;
    }
    public void setDni(String dni) {
        this.dni = dni;
    }
    public String getActividades() {
        return actividades;
    }
    public void setActividades(String actividades) {
        this.actividades = actividades;
    }
    public Consulta(String nombre, String dni, String actividades) {
        this.nombre = nombre;
        this.dni = dni;
        this.actividades = actividades;
    }

}