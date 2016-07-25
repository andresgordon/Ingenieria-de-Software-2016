package BD;

import modelo.DetalleActividad;
import modelo.DetalleActividad;
import modelo.Empleado;
import modelo.Actividad;
import modelo.Actividad;
import servicios.Conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

public class ActividadBD {

    public static synchronized boolean insertarActividad(Actividad varactividad, ArrayList<DetalleActividad> detalle) {

        Connection cn = null;
        CallableStatement cl = null;
        boolean rpta = false;
        try {
            String call = "{CALL spI_venta(?,?)}";
            cn = Conexion.getConexion();
            cn.setAutoCommit(false);
            cl = cn.prepareCall(call);
            cl.registerOutParameter(1, Types.INTEGER);
            cl.setString(2, varactividad.getNombre());
            rpta = cl.executeUpdate() == 1 ? true : false;
            varactividad.setCodigo(cl.getInt(1));
            if (rpta) {
                for (DetalleActividad det : detalle) {
                    det.setCodigoActividad(varactividad.getCodigo());
                    rpta = DetalleActividadBD.insertarDetalleActividad(det, cn);
                    if (!rpta) {
                        break;
                    }
                }
                if (rpta) {
                    cn.commit();
                } else {
                    Conexion.deshacerCambios(cn);
                }
            } else {
                Conexion.deshacerCambios(cn);
            }
            Conexion.cerrarCall(cl);
            Conexion.cerrarConexion(cn);
        } catch (SQLException e) {
            e.printStackTrace();
            Conexion.deshacerCambios(cn);
            Conexion.cerrarCall(cl);
            Conexion.cerrarConexion(cn);
        } catch (Exception e) {
            e.printStackTrace();
            Conexion.deshacerCambios(cn);
            Conexion.cerrarCall(cl);
            Conexion.cerrarConexion(cn);
        }
        return rpta;
    }

    public static synchronized ArrayList<DetalleActividad> obtenerActividades() {
        ArrayList<DetalleActividad> lista = new ArrayList<DetalleActividad>();
        Connection cn = null;
        CallableStatement cl = null;
        ResultSet rs = null;
        try {
            String call = "{CALL spF_venta_All()}";
            cn = Conexion.getConexion();
            cl = cn.prepareCall(call);
            rs = cl.executeQuery();
            while (rs.next()) {
                Actividad act=new Actividad();
                Empleado emp=new Empleado();
                DetalleActividad det=new DetalleActividad();
                act.setCodigo(rs.getInt("CodigoVenta"));
                act.setNombre(rs.getString("Cliente"));
                act.setFecha(rs.getTimestamp("Fecha"));
                emp.setCodigo(rs.getInt("CodigoProducto"));
                emp.setNombre(rs.getString("Nombre"));
                emp.setSalario(rs.getDouble("Precio"));
                det.setCantidad(rs.getDouble("Cantidad"));
                det.setDescuento(rs.getDouble("Descuento"));
                det.setActividad(act);
                det.setEmpleado(emp);
                lista.add(det);
            }
            Conexion.cerrarCall(cl);
            Conexion.cerrarConexion(cn);
        } catch (SQLException e) {
            e.printStackTrace();
            Conexion.cerrarCall(cl);
            Conexion.cerrarConexion(cn);
        } catch (Exception e) {
            e.printStackTrace();
            Conexion.cerrarCall(cl);
            Conexion.cerrarConexion(cn);
        }
        return lista;
    }
}