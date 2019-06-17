<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 6/11/2019
  Time: 9:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
  <head>

      <meta http-equiv='X-UA-Compatible' content='IE=edge'>
      <meta name='viewport' content='width=device-width, initial-scale=1'>
      <link rel="stylesheet" type="text/css" href="assets/css/login.css"/>
      <link href="assets/css/bootstrap.css" rel="stylesheet" id="bootstrap-css">
<%--      <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>--%>
      <script src="assets/js/bootstrap.min.js"></script>
      <script src="assets/js/jquery.js"></script>
      <script type="text/javascript" src="resources/js/signScript.js"></script>
      <title>SignUp</title>
  </head>
  <body>
        <div class="container">
            <div class="card signup-container">
            <div class="row">
                <div id="signupMessage"><h2>Sign Up Form</h2></div>
            </div>
            <div class="row">
            <div class="col-6">

                <label>Set User-Name:<input class="form-control" type="text" autofocus name="userName" id="userName"/></label>
                <label>Email Address:<input  class="form-control" type="email" name="email" id="email"/></label>
                <label>Set password:<input class="form-control" type="password" name="password" id="password"/></label>
                <label>Full Name:<input class="form-control" type="text" name="fullName" id="fullName"/></label>
                <label>Occupation:</label>
                    <select name="occupation" id="occupation" class="form-control">
                    <option value="Faculty">Faculty</option>
                    <option value="Staff">Staff</option>
                    <option value="Student">Student</option>
                    <option value="Local Resident">Local Resident</option>
                    <option value="Other">Other</option>
                    </select>
            </div>
            <div class="col-6">
                <label>Address:<input  class="form-control" type="text" name="address" id="address"/></label>
                <label>Contact No.:<input class="form-control"  type="tel" name="contact" id="contact"/></label>
                <label>Date of Birth:<input  class="form-control" type="date" name="dob" id="dob"/></label>
                <fieldset class="gender"><label>Gender: </label>
                    <label><input type="radio" name="gender" value="Male"/> Male</label>
                    <label><input type="radio" name="gender" value="Female"/> Female</label>
                    <label><input type="radio" name="gender" value="Other"/> Other</label></fieldset>

            <label>Image:</label>
                    <input  class="form-control" type = "file" name = "file" size = "20"/><input type = "button" value = "Upload File" />

            </div></div>
            <button class="btn btn-lg btn-primary btn-block btn-signin" id="signupBtn" type="submit" value="signup">Sign Up</button>
                <small>Already have an account?</small>
                <a class="btn btn-lg btn-primary btn-block btn-signin" href="/login" id="signinBtn">Sign In Here</a>
            </div>
        </div>
        </div>
  </body>
</html>
