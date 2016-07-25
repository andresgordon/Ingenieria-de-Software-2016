<%@page import="java.util.ArrayList"%>
<%@page import="modelo.*" %>
<%@page import="BD.*" %>
<%@page import="java.util.*" %>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <link rel="stylesheet" type="text/css" href="estilos.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Proyecto final - Andrés Gordon</title>
    </head>
    <body>

        <div id="contenedor">
            <div id="titulo">
                <h1>IKEACost</h1>
            </div>
            <div id="menu">
                <jsp:include page="navegacion.jsp"/>
            </div>
            <div id="cuerpo">
                <c:if test="${FormularioActivo == null}">
                    <jsp:include page="inicial.jsp"/>
                </c:if>
                <c:if test="${FormularioActivo != null}">
                    <jsp:include page="${FormularioActivo}"/>
                </c:if>
            </div>        
            <div id="footer">
                Andrés Guillermo Gordon - Ingeniería de Software
            </div>
        </div>
    </body>
</html>
