<%@page import="java.util.ArrayList"%>
<%@page import="modelo.*" %>
<%@page import="BD.*" %>
<%@page import="java.util.*" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    Empleado e=EmpleadoBD.obtenerEmpleado(Integer.parseInt(request.getParameter("id")));
%>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="estilos.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>.:Añadiendo actividad:.</title>
    </head>
    <body>
        <br >
        <form method="post" action="ServletAnadirCarrito">
            <div>
                <table border="1">
                    <h1>.:Añadiendo la Actividad:.</h1>
                    <tr>
                        <td>Codigo</td>
                        <td><input type="text" name="txtCodigo" value="<%= e.getCodigo()%>" readonly /></td>
                    </tr>
                    <tr>
                        <td>Nombre Empleado</td>
                        <td><input type="text" name="txtNombre" value="<%= e.getNombre()%>" readonly /></td>
                    </tr>
                    <tr>
                        <td>Salario</td>
                        <td><input type="text" name="txtSalario" value="<%= e.getSalario()%>" readonly /></td>
                    </tr>
                    <tr>
                        <td>Cantidad de Horas</td>
                        <td><input type="text" name="txtCantidad" value="0" /></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" value="Registrar" name="btnAnadir" /></td>
                    </tr>
                </table>
            </div>
        </form>

    </body>
</html>
