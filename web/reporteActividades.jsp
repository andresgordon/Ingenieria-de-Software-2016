<%@page import="java.util.ArrayList"%>
<%@page import="modelo.*" %>
<%@page import="BD.*" %>
<%@page import="java.util.*" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <h1>CONSULTA DE ACTIVIDADES REGISTRADAS</h1>
        <br >
        <div>
            <table border="1" align="center">
                <tr style="background-color: chocolate">
                    <td colspan="6"><h2>Lista de Actividades registradas</h2></td>

                </tr>
                <tr style="background-color: chocolate">
                    <td>Cod. Actividad</td>
                    <td>Empleado</td>
                    <td>Salario</td>
                    <td>Cantidad de horas</td>
                    <td>Nom. Actividad</td>
                    <td>Fecha</td>
                </tr>
                <%
                            ArrayList<DetalleActividad> lista = ActividadBD.obtenerActividades();
                            for (DetalleActividad d : lista) {
                %>
                <tr>
                    <td><%= d.getActividad().getCodigo()%></td>
                    <td><%= d.getEmpleado()%></td>
                    <td><%= d.getEmpleado().getSalario()%></td>
                    <td><%= d.getCantidad()%></td>
                    <td><%= d.getActividad().getNombre()%></td>
                    <td><%= d.getActividad().getFecha()%></td>
                </tr>
                <%
                            }
                %>

            </table>
        </div>


    </body>
</html>
