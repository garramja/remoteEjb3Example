<%--
  Created by IntelliJ IDEA.
  User: javier.garcia
  Date: 06/07/2016
  Time: 10:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title></title>
  </head>
  <body>
        <h1>Ejemplo invocacion de ejb remoto</h1>

        <p>Presentate al Servicio de Ejb remoto</p>

  <form id="presentacion" action="presentacion" method="post">
      <label for="nombre">¿Quién eres?</label>
      <input type="text" id="nombre" name="nombre" value=""/>
      <p><button type="button" onclick="validar()">Presentarme</button> </p>
  </form>

  <script>

      function validar() {

          if(document.getElementById("nombre").value == '') {
              alert("Debes rellenar el texto");
              return false;
          } else {
              document.getElementById("presentacion").submit()
          }

      }

  </script>

  </body>
</html>
