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
<body>
<div class="container">
    <div class="card card-container">
        <img id="profile-img" class="profile-img-card" src="../resources/img/avatar_2x.png" />
        <p id="profile-name" class="profile-name-card"></p>

        <form class="form-signin" id="form-signin" method="post" action="${contextPath}/admin">
            <span id="reauth-email" class="reauth-email"></span>
            <input type="email" name="username" id="inputEmail" class="form-control" placeholder="Email address" autofocus>
            <input type="password" name="password" id="inputPassword" class="form-control" placeholder="Password">
            <div id="remember" class="checkbox">
                <label>
                    <input type="checkbox" name="remember" value="1"> Remember me
                </label>
            </div>
            <button id="logIn-btn" class="btn btn-lg btn-primary btn-block btn-signin" type="submit">Sign in</button>
            <a href="/signup" class="btn btn-lg btn-primary btn-block btn-signin" type="submit">Sign up</a>

        </form><!-- /form -->
        <a href="#" class="forgot-password">
            Forgot the password?
        </a>
    </div><!-- /card-container -->
</div><!-- /container -->
<script src="../resources/js/login.js"></script>
<script src="../resources/js/custom.js"></script>
</body>
</html>