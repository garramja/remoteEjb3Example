<%--
  Created by IntelliJ IDEA.
  User: javier.garcia
  Date: 06/07/2016
  Time: 10:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<h1>Resultado</h1>
<p>Te has presentado como <%=request.getAttribute("nombre")%></p>
<p>El servicio remoto contesta: <%=request.getAttribute("respuesta")%></p>
</body>
</html>
