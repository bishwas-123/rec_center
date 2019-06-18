<%@ page import="java.io.PrintWriter" %>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head lang="en">
    <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>Rec center admin login</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <link rel="stylesheet" type="text/css" href="../resources/css/login.css"/>
    <link href="../resources/css/bootstrap.css" rel="stylesheet" id="bootstrap-css">
    <script src="../resources/js/jquery.js"></script>
    <script src="../resources/js/bootstrap.min.js"></script>
    <script>var basePath="${contextPath}";</script>
</head>
<%
    Cookie[] cookies=request.getCookies();
    String userName ="",rememberVal="";
    if (cookies != null) {
        for (Cookie cookie : cookies) {
            if(cookie.getName().equals("uname")) {
                userName = cookie.getValue();
            }
            if(cookie.getName().equals("remember")){
                rememberVal = cookie.getValue();

            }
        }
    }
%>
<body>
<div class="container">
    <div class="card card-container">
        <img id="profile-img" class="profile-img-card" src="${pageContext.request.contextPath}/resources/img/avatar_2x.png" />
        <p id="profile-name" class="profile-name-card"></p>
        <form class="form-signin" id="form-signin" method="post" action="${pageContext.request.contextPath}/admin">

        <span id="reauth-email" class="reauth-email">
          <small class="message">
            <% String errorMessage=session.getAttribute("login-message")==null?"":session.getAttribute("login-message").toString();%>
            <%=errorMessage%>
          </small>
        </span>
            <input autocomplete="off" type="text" name="email" id="inputEmail" class="form-control" placeholder="Email Address" required autofocus value="<%=userName%>">
            <input autocomplete="off" type="password" name="password" id="inputPassword" class="form-control" placeholder="Password" required>
            <div id="remember" class="checkbox">
                <label>
                    <input type="checkbox" name="remember" value="<%= rememberVal%>"
                            <%= "1".equals(rememberVal.trim()) ? "checked='checked'":"" %> />Remember me
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
<script src="../resources/js/login.js"></script>
<script src="../resources/js/custom.js"></script>
</body>
</html>
