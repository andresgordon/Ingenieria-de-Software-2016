package modelo;


/**
 * @version 1.0
 * @created 14-Jul.-2016 8:19:48 p. m.
 */
public class Actividad {

	private String id_actividad;
	private String nombre_actividad;
	private int estado;
	private int cantidad_horas;

	public Actividad(){
	}

    public Actividad(String id_actividad, String nombre_actividad, int estado, int cantidad_horas) {
        this.id_actividad = id_actividad;
        this.nombre_actividad = nombre_actividad;
        this.estado = estado;
        this.cantidad_horas = cantidad_horas;
    }

    public String getId_actividad() {
        return id_actividad;
    }

    public void setId_actividad(String id_actividad) {
        this.id_actividad = id_actividad;
    }

    public String getNombre_actividad() {
        return nombre_actividad;
    }

    public void setNombre_actividad(String nombre_actividad) {
        this.nombre_actividad = nombre_actividad;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getCantidad_horas() {
        return cantidad_horas;
    }

    public void setCantidad_horas(int cantidad_horas) {
        this.cantidad_horas = cantidad_horas;
    }

    
	public void finalize() throws Throwable {

	}

	public void validarHorario(){

	}

}