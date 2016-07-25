
package controlador;

import BD.EmpleadoBD;
import modelo.DetalleActividad;
import modelo.Empleado;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Wendy_Andres
 */
public class ServletAnadirCarrito extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Obtenemos la sesion actual
        HttpSession sesion = request.getSession();
        ArrayList<DetalleActividad> carrito;
        //Si no existe la sesion creamos al carrito de cmoras
        if (sesion.getAttribute("carrito") == null) {
            carrito = new ArrayList<DetalleActividad>();
        } else {
            carrito = (ArrayList<DetalleActividad>) sesion.getAttribute("carrito");
        }
        //Obtenemos el producto que deseamos añadir al carrito
        Empleado e = EmpleadoBD.obtenerEmpleado(Integer.parseInt(request.getParameter("txtCodigo")));
        //Creamos un detalle para el carrtio
        DetalleActividad d = new DetalleActividad();
        //Obtenemos los valores de la caja de texto
        d.setCodigoEmpleado(Integer.parseInt(request.getParameter("txtCodigo")));
        d.setEmpleado(e);
        d.setCantidad(Double.parseDouble(request.getParameter("txtCantidad")));
        //Calculamos el descuento, si es sub detalle es mayor a 50 se le hace
        //un descuento del 5% aca es donde se encuentra la logica del negocio
        double subTotal = e.getSalario() * d.getCantidad();
        if (subTotal > 50) {
            d.setDescuento(subTotal * (5D / 100D));
        } else {
            d.setDescuento(0);
        }
        //Sirva para saber si tenemos agregado el producto al carrito de compras
        int indice = -1;
        //recorremos todo el carrito de compras
        for (int i = 0; i < carrito.size(); i++) {
            DetalleActividad det = carrito.get(i);
            if (det.getCodigoEmpleado() == e.getCodigo()) {
                //Si el producto ya esta en el carrito, obtengo el indice dentro
                //del arreglo para actualizar al carrito de compras
                indice = i;
                break;
            }
        }
        if (indice == -1) {
            //Si es -1 es porque voy a registrar
            carrito.add(d);
        } else {
            //Si es otro valor es porque el producto esta en el carrito
            //y vamos actualizar la 
            carrito.set(indice, d);
        }
        //Actualizamos la sesion del carrito de compras
        sesion.setAttribute("carrito", carrito);
        //Redireccionamos al formulario de culminar el registro de la actividad
        response.sendRedirect("registrarActividad.jsp");
    
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
