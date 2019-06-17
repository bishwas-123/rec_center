<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 6/11/2019
  Time: 9:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html lang="en">
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
  <head>
<%--    <link href="/resources/css/user_registration.css" type="text/css" rel="stylesheet"/>--%>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <link rel="stylesheet" type="text/css" href="assets/css/login.css"/>
    <link href="assets/css/bootstrap.css" rel="stylesheet" id="bootstrap-css">

    <script src="assets/js/bootstrap.min.js"></script>
    <script src="assets/js/jquery.js"></script>
    <script type="text/javascript" src="resources/js/signScript.js"></script>
  <script>var basePath="${contextPath}";</script>

    <title>Login</title>
  </head>
  <body>
  <div class="container">
    <div class="card card-container">
      <img id="profile-img" class="profile-img-card" src="assets/img/avatar_2x.png" />
      <p id="profile-name" class="profile-name-card"></p>
      <form class="form-signin" id="form-signin" method="post" action="/login">

        <span id="reauth-email" class="reauth-email">
          <small class="message">
            <% String errorMessage=session.getAttribute("login-message")==null?"":session.getAttribute("login-message").toString();%>
            <%=errorMessage%>
          </small >

        </span>
        <input type="text" name="email" id="inputEmail" class="form-control" placeholder="Email Address" required autofocus value="${cookie['email'].getValue()}">
        <input type="password" name="password" id="inputPassword" class="form-control" placeholder="Password" required>
        <div id="remember" class="checkbox">
          <label>
            <input type="checkbox" name="remember" value="remember-me"> Remember me
          </label>
        </div>

        <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit">Sign in</button>

        <fieldset>
          <small>Not Yet Registered?</small>
<%--          <a href="/signup" class="btn btn-lg btn-primary btn-block btn-signin">Sign Up Here</a>--%>
            <input class="btn btn-lg btn-primary btn-block btn-signin" type="button" id="gotoSignUp" value="Sign Up Here"/>
        </fieldset>
      </form>
    </div><!-- /card-container -->
  </div><!-- /container -->
  <script src="assets/js/login.js"></script>
  <script src="assets/js/custom.js"></script>
  </body>
</html>
