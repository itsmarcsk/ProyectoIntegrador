package modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;
public class Actividad {

    private String nombre;
    private int precio;
    private String horaIni;
    private String horaFin;
    public static final ArrayList<String> listaActividades = new ArrayList<String>();
    public static final ArrayList<Integer> listaPrecio = new ArrayList<>();
    public void meterDatos() {

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

}