package BD;


import modelo.DetalleActividad;
import servicios.Conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class DetalleActividadBD {

    public static synchronized boolean insertarDetalleActividad(DetalleActividad varDetalle, Connection cn) {
        CallableStatement cl = null;
        boolean rpta = false;
        try {
            String call = "{CALL spI_detalleventa(?,?,?,?)}";
            cl = cn.prepareCall(call);
            cl.setInt(1, varDetalle.getCodigoActividad());
            cl.setInt(2, varDetalle.getCodigoEmpleado());
            cl.setDouble(3, varDetalle.getCantidad());
            cl.setDouble(4, varDetalle.getDescuento());
            rpta = cl.executeUpdate() == 1 ? true : false;
            Conexion.cerrarCall(cl);
        } catch (SQLException e) {
            e.printStackTrace();
            Conexion.cerrarCall(cl);
        } catch (Exception e) {
            e.printStackTrace();
            Conexion.cerrarCall(cl);
        }
        return rpta;
    }
}
