
package modelo;

public class DetalleActividad {

    private int codigoActividad;
    private int codigoEmpleado;
    private double cantidad;
    private double descuento;
    private Empleado empleado;
    private Actividad actividad;

    public DetalleActividad() {
    }

    public DetalleActividad(int codigoActividad, int codigoEmpleado, double cantidad, double descuento) {
        this.codigoActividad = codigoActividad;
        this.codigoEmpleado = codigoEmpleado;
        this.cantidad = cantidad;
        this.descuento = descuento;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public int getCodigoEmpleado() {
        return codigoEmpleado;
    }

    public void setCodigoEmpleado(int codigoEmpleado) {
        this.codigoEmpleado = codigoEmpleado;
    }

    public int getCodigoActividad() {
        return codigoActividad;
    }

    public void setCodigoActividad(int codigoActividad) {
        this.codigoActividad = codigoActividad;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Actividad getActividad() {
        return actividad;
    }

    public void setActividad(Actividad actividad) {
        this.actividad = actividad;
    }
}