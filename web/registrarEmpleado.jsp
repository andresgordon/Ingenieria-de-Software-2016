<%@page import="java.util.ArrayList"%>
<%@page import="modelo.*" %>
<%@page import="java.util.*" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>
        <link rel="stylesheet" type="text/css" href="estilos.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <h1>REGISTRO DE EMLEADOS</h1>
        <br >
        <%-- En el action del formulario le decimos que llama al Controlador --%>
        <form method="post" action="ServletRegistrarEmpleado">
            <div>
                <table border="1">
                    <tr>
                        <td>Nombre</td>
                        <td><input type="text" name="txtNombre" value="" /></td>
                    </tr>
                    <tr>
                        <td>Salario</td>
                        <td><input type="text" name="txtSalario" value="0" /></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" value="Registrar" name="btnRegistrar" /></td>
                    </tr>
                </table>
            </div>
        </form>

    </body>
</html>
