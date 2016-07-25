package BD;

import modelo.Empleado;
import servicios.Conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;


public class EmpleadoBD {

    public static synchronized boolean insertarEmpleado(Empleado varempleado) {
        Connection cn = null;
        CallableStatement cl = null;
        boolean rpta = false;
        try {
            String call = "{CALL spI_producto(?,?,?)}";
            cn = Conexion.getConexion();
            cn.setAutoCommit(false);
            cl = cn.prepareCall(call);
            cl.registerOutParameter(1, Types.INTEGER);
            cl.setString(2, varempleado.getNombre());
            cl.setDouble(3, varempleado.getSalario());
            rpta = cl.executeUpdate() == 1 ? true : false;
            if (rpta) {
                cn.commit();
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

    public static synchronized boolean actualizarEmpleado(Empleado varempleado) {
        Connection cn = null;
        CallableStatement cl = null;
        boolean rpta = false;
        try {
            String call = "{CALL spU_producto(?,?,?)}";
            cn = Conexion.getConexion();
            cn.setAutoCommit(false);
            cl = cn.prepareCall(call);
            cl.setInt(1, varempleado.getCodigo());
            cl.setString(2, varempleado.getNombre());
            cl.setDouble(3, varempleado.getSalario());
            rpta = cl.executeUpdate() == 1 ? true : false;
            if (rpta) {
                cn.commit();
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

    public static synchronized ArrayList<Empleado> obtenerEmpleado() {
        ArrayList<Empleado> lista = new ArrayList<Empleado>();
        Connection cn = null;
        CallableStatement cl = null;
        ResultSet rs = null;
        try {
            String call = "{CALL spF_producto_all()}";
            cn = Conexion.getConexion();
            cl = cn.prepareCall(call);
            rs = cl.executeQuery();
            while (rs.next()) {
                Empleado p = new Empleado();
                p.setCodigo(rs.getInt("codigoProducto"));
                p.setNombre(rs.getString("nombre"));
                p.setSalario(rs.getDouble("precio"));
                lista.add(p);
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
    public static synchronized Empleado obtenerEmpleado(int codigo) {
        Empleado p = new Empleado();
        Connection cn = null;
        CallableStatement cl = null;
        ResultSet rs = null;
        try {
            String call = "{CALL spF_producto_one(?)}";
            cn = Conexion.getConexion();
            cl = cn.prepareCall(call);
            cl.setInt(1, codigo);
            rs = cl.executeQuery();
            while (rs.next()) {
                p.setCodigo(rs.getInt("codigoProducto"));
                p.setNombre(rs.getString("nombre"));
                p.setSalario(rs.getDouble("precio"));
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
        return p;
    }
}
