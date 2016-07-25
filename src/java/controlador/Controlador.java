package controlador;

import modelo.DetalleActividad;
import modelo.Empleado;
import BD.EmpleadoBD;
import modelo.Actividad;
import BD.ActividadBD;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Controlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String FormularioActivo = "index.jsp";
        String accion = request.getParameter("accion");
        if (accion.equals("Registrar Empleado")) {
            FormularioActivo = "registrarEmpleado.jsp";
        } else if (accion.equals("Modificar Empleado")) {
            this.actualizarEmpleado(request, response);
        } else if (accion.equals("Registrar Actividad")) {
            FormularioActivo = "registrarActividad.jsp";
        } else if (accion.equals("Consultar Actividades")) {
            FormularioActivo = "reporteActividades.jsp";
        } else if (accion.equals("Reporte")) {
            FormularioActivo = "Reporte";
        }else{
            FormularioActivo = "inicial.jsp";
        }
        session.setAttribute("FormularioActivo", FormularioActivo);
        request.getRequestDispatcher("index.jsp").forward(request, response);

    }

    private void registrarEmpleado(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Empleado p = new Empleado();
        p.setNombre(request.getParameter("txtNombre").toUpperCase());
        p.setSalario(Double.parseDouble(request.getParameter("txtSalario")));
        boolean rpta = EmpleadoBD.insertarEmpleado(p);
        if (rpta) {
            response.sendRedirect("mensaje.jsp?men=Se registro del empleado de manera correcta");
        } else {
            response.sendRedirect("mensaje.jsp?men=No se registro el empleado");
        }
    }
    private void actualizarEmpleado(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Empleado e = new Empleado();
        e.setCodigo(Integer.parseInt(request.getParameter("txtCodigo")));
        e.setNombre(request.getParameter("txtNombre").toUpperCase());
        e.setSalario(Double.parseDouble(request.getParameter("txtSalario")));
        boolean rpta = EmpleadoBD.actualizarEmpleado(e);
        if (rpta) {
            response.sendRedirect("mensaje.jsp?men=Se actualizo el empleado de manera correcta");
        } else {
            response.sendRedirect("mensaje.jsp?men=No se actualizo el empleado");
        }
    }
    private void añadirCarrito(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession();
        ArrayList<DetalleActividad> carrito;
        if (sesion.getAttribute("carrito") == null) {
            carrito = new ArrayList<DetalleActividad>();
        } else {
            carrito = (ArrayList<DetalleActividad>) sesion.getAttribute("carrito");
        }
        Empleado e = EmpleadoBD.obtenerEmpleado(Integer.parseInt(request.getParameter("txtCodigo")));
        DetalleActividad d = new DetalleActividad();
        d.setCodigoEmpleado(Integer.parseInt(request.getParameter("txtCodigo")));
        d.setEmpleado(e);
        d.setCantidad(Double.parseDouble(request.getParameter("txtCantidad")));
        double subTotal = e.getSalario() * d.getCantidad();
        if (subTotal > 50) {
            d.setDescuento(subTotal * (5D / 100D));
        } else {
            d.setDescuento(0);
        }
        int indice = -1;
        for (int i = 0; i < carrito.size(); i++) {
            DetalleActividad det = carrito.get(i);
            if (det.getCodigoEmpleado() == e.getCodigo()) {
                indice = i;
                break;
            }
        }
        if (indice == -1) {
            carrito.add(d);
        } else {
            carrito.set(indice, d);
        }
        sesion.setAttribute("carrito", carrito);
        response.sendRedirect("registrarActividad.jsp");
    }
    private void registrarActividad(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession();
        Actividad a=new Actividad();
        a.setNombre(request.getParameter("txtActividad").toUpperCase());
        ArrayList<DetalleActividad> detalle  = (ArrayList<DetalleActividad>) sesion.getAttribute("carrito");
        boolean rpta=ActividadBD.insertarActividad(a, detalle);
        if (rpta) {
            response.sendRedirect("mensaje.jsp?men=Se registro la actividad de manera correcta");
        } else {
            response.sendRedirect("mensaje.jsp?men=No se registro la actividad");
        }
    }

    
}
