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
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="/css/user_registration.css" type="text/css" rel="stylesheet"/>

    <title>Login</title>
  </head>
  <body>
    <div class="pDiv">
      <form method="post" action="/login">
        <fieldset><legend id="#centerText">Sign-In Form</legend>
        <span class="pSpan">
            <label>UserName:</label><input type="text" autofocus name="userName" value="${cookie['userName'].getValue()}"/>
        </span>
        <span class="pSpan">
            <label>Password:</label><input type="password" name="password"/>
        </span>
        <span class="message">
          <% String errorMessage=session.getAttribute("login-message")==null?"":session.getAttribute("login-message").toString();%>
          <%=errorMessage%>
        </span >
        <label>Remember Me <input type="checkbox" name="remember"></label>
        <button id="signinBtn" type="submit" value="login">Login</button>
        </fieldset>
        <fieldset>
          <small>Not Yet Registered?</small>
          <a href="/signup" id="signupBtn">Sign Up Here</a>
        </fieldset>
      </form>

      </form>
    </div>
  </body>
</html>
