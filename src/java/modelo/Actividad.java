package modelo;

import java.sql.Timestamp;

public class Actividad {

    private int codigo;
    private String nombre;
    private Timestamp fecha;

    public Actividad() {
    }

    public Actividad(int codigo, String nombre, Timestamp fecha) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }
}
