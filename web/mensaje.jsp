<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>
        <link rel="stylesheet" type="text/css" href="estilos.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <br >
        <div>
            <h2><%= request.getParameter("men")%></h2>
            <a href="index.jsp">Volver al inicio</a>
        </div>
    </body>
</html>
