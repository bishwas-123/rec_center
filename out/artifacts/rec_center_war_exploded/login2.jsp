<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head lang="en">
  <meta charset='utf-8'>
  <meta http-equiv='X-UA-Compatible' content='IE=edge'>
  <title>Page Title</title>
  <meta name='viewport' content='width=device-width, initial-scale=1'>
  <link rel="stylesheet" type="text/css" href="assets/css/login.css"/>
  <link href="assets/css/bootstrap.css" rel="stylesheet" id="bootstrap-css">

  <script src="assets/js/bootstrap.min.js"></script>
  <script src="assets/js/jquery.js"></script>
</head>
<body>

<div class="container">
  <form method="post" action="/login">
    <div class="card card-container">
      <img id="profile-img" class="profile-img-card" src="assets/img/avatar_2x.png" />
      <p id="profile-name" class="profile-name-card"></p>
      <form class="form-signin">
        <span id="reauth-email" class="reauth-email"></span>
        <input type="text" name="userName" id="inputEmail" class="form-control" placeholder="User Name" required autofocus value="${cookie['userName'].getValue()}">
        <input type="password" id="inputPassword" class="form-control" placeholder="Password" required>
        <div id="remember" class="checkbox">
          <label>
            <input type="checkbox" name="remember" value="remember-me"> Remember me
          </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit">Sign in</button>
        <%--                <small class="message">--%>
        <%--                  <% String errorMessage=session.getAttribute("login-message")==null?"":session.getAttribute("login-message").toString();%>--%>
        <%--                  <%=errorMessage%>--%>
        <%--                </small >--%>
      </form><!-- /form -->
      <a href="#" class="forgot-password">
        Forgot the password?
      </a>
      <fieldset>
        <small>Not Yet Registered?</small>
        <a class="btn btn-lg btn-primary btn-block btn-signin" href="/signup" >Sign Up Here</a>
      </fieldset>
    </div><!-- /card-container -->
  </form>
</div><!-- /container -->

<script src="assets/js/login.js"></script>
</body>
</html>