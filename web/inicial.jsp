<%-- 
    Document   : inicial
    Created on : 23/05/2015, 02:35:46 AM
    Author     : Wendy_Andres
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.*" %>
<%@page import="BD.*" %>
<%@page import="java.util.*" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>EMPLEADOS</h1>
            <table border="1">
                <tr style="background-color: chocolate">
                    <td colspan="4"><h2>Lista de Empleados</h2></td>

                </tr>
                <tr style="background-color: chocolate">
                    <td>Codigo</td>
                    <td>Nombre</td>
                    <td>Salario</td>
                    <td>Proceso</td>
                </tr>
                <%-- Lista de todos los productos --%>
                <%
                            ArrayList<Empleado> lista = EmpleadoBD.obtenerEmpleado();
                            for (Empleado e : lista) {
                %>
                <tr>
                    <td><%= e.getCodigo()%></td>
                    <td><%= e.getNombre()%></td>
                    <td><%= e.getSalario()%></td>
                    <td><a href="actualizarEmpleado.jsp?id=<%= e.getCodigo()%>">Actualizar</a> |
                        <a href="anadirCarrito.jsp?id=<%= e.getCodigo()%>">Registrar Actividad</a>
                    </td>
                </tr>
                <%
                            }
                %>

            </table>
    </body>
</html>
