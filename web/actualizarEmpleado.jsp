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
    </head>
    <body>
        <br >
        <%-- En el action del formulario le decimos que llama al Controlador --%>
        <form method="post" action="ServletActualizarEmpleado">
            <div>
                <%-- Indica al controlador que vamos hacer una modificacion --%>
                <table border="1">
                    <h1>.:Actualizando los datos del empleado:.</h1>
                    <tr>
                        <td>Codigo</td>
                        <%-- Escribimos el codigo del empleado a modificar --%>
                        <td><input type="text" name="txtCodigo" value="<%= e.getCodigo()%>" readonly /></td>
                    </tr>
                    <tr>
                        <td>Nombre</td>
                        <%-- Escribimos el nombre del empleado a modificar --%>
                        <td><input type="text" name="txtNombre" value="<%= e.getNombre()%>" /></td>
                    </tr>
                    <tr>
                        <td>Salario</td>
                        <%-- Escribimos el salario del empleado a modificar --%>
                        <td><input type="text" name="txtSalario" value="<%= e.getSalario()%>" /></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" value="Actualizar" name="btnActualizar" /></td>
                    </tr>
                </table>
            </div>
        </form>

    </body>
</html>
