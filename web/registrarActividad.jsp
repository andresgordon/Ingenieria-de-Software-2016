<%@page import="java.util.ArrayList"%>
<%@page import="modelo.*" %>
<%@page import="java.util.*" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <link rel="stylesheet" type="text/css" href="estilos.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <h1>REGISTRO DE ACTIVIDADES</h1>
        <br >
        <div>
            <form method="post" action="ServletRegistrarActividad">
                <%-- Llamamos a la accion Registrar Actividad --%>
                <table border="1">
                        <tr style="background-color: chocolate">
                            <td colspan="5"><h2>Registro de actividades de Empleado</h2></td>
                        </tr>
                        <tr style="background-color: chocolate">
                            <td>Nombre de Actividad:</td>
                            <td colspan="4"><input type="text" name="txtActividad" value="" /></td>
                        </tr>
                        <tr style="background-color: chocolate">
                            <td>Nombre</td>
                            <td>Salario</td>
                            <td>Cantidad Horas</td>
                        </tr>
                        <%--  --%>
                        <%
                                    ArrayList<DetalleActividad> lista = (ArrayList<DetalleActividad>)session.getAttribute("carrito");
                                    if(lista!=null){
                                        for (DetalleActividad d : lista) {
                        %>
                                        <tr>
                                            <td><%= d.getEmpleado()%></td>
                                            <td><%= d.getEmpleado().getSalario()%></td>
                                            <td><%= d.getCantidad()%></td>
                                        </tr>
                        <%
                                        }
                                    }
                        %>
                        <tr >
                            <td colspan="5"><input type="submit" value="Registrar Actividad" name="btnActividad" /></td>
                        </tr>
                    </table>
                </form>
        </div>


    </body>
</html>
