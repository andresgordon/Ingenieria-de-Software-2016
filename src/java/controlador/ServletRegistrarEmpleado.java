
package controlador;

import BD.EmpleadoBD;
import modelo.Empleado;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Wendy_Andres
 */
public class ServletRegistrarEmpleado extends HttpServlet {

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

        Empleado e = new Empleado();
        //request.getParameter --> Sirve para obtener los valores de las cajas de texto
        e.setNombre(request.getParameter("txtNombre").toUpperCase());
        e.setSalario(Double.parseDouble(request.getParameter("txtSalario")));
        boolean rpta = EmpleadoBD.insertarEmpleado(e);
        if (rpta) {
            //Si inserto lo redireccionamos a otra pagina que se llama "mensaje.jsp"
            response.sendRedirect("mensaje.jsp?men=Se registro el empleado de manera correcta");
        } else {
            //Si no se inserto lo redireccionamos a otra pagina que se llama "mensaje.jsp"
            response.sendRedirect("mensaje.jsp?men=No se registro el empleado");
        }
        
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
