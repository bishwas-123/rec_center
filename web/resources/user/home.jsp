<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 6/11/2019
  Time: 9:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <link rel="stylesheet" href="/css/user_registration.css" type="text/css">
    <title>Home</title>
  </head>
  <body>
  <div class="pDiv">
    <h3>
      Welcome <% String userName=(String)session.getAttribute("userName");%><%=userName%>
      <form method="get" action="/login">
        <button type="submit" name="logout">Logout</button>
      </form>
    </h3>
  </div>
  </body>
</html>
