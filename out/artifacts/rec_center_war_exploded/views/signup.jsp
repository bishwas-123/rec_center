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
    <link rel="stylesheet" type="text/css" href="../resources/css/login.css"/>
    <link href="../resources/css/bootstrap.css" rel="stylesheet" id="bootstrap-css">
    <%--      <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>--%>
    <script src="../resources/js/bootstrap.min.js"></script>
    <script src="../resources/js/jquery.js"></script>
    <script type="text/javascript" src="../resources/js/signScript.js"></script>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.2/jquery-confirm.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.2/jquery-confirm.min.js"></script>




    <title>SignUp</title>



</head>
<body class="gym-city">




<form id="form-signUp">
    <div class="container">
        <div class="card signup-container">
            <div class="row">
                <div id="signupMessage"><h2>Sign Up Form</h2></div>
            </div>
            <div class="row">
                <div class="col-6">

                    <label>User-Name: <small id="myError"></small><input class="form-control nullCheck" type="text" autofocus name="userName"
                                                                         id="userName" required/></label>
                    <label>Email Address:<input class="form-control nullCheck" type="email" name="email" id="email"
                                                required/></label>
                    <div><small id="myError1"></small></div>
                    <label>Password:<input class="form-control nullCheck" type="password" name="password" id="password"
                                           required/></label>
                    <label>Full Name:<input class="form-control nullCheck" type="text" name="fullName" id="fullName"
                                            required/></label>
                    <div><small id="myError2"></small></div>
                    <label>Occupation:</label>
                    <select name="occupation" id="occupation" class="form-control nullCheck" required>
                        <option value="Faculty">Faculty</option>
                        <option value="Staff">Staff</option>
                        <option value="Student">Student</option>
                        <option value="Local Resident">Local Resident</option>
                        <option value="Other">Other</option>
                    </select>
                    <label>Address:<input class="form-control nullCheck" type="text" name="address" id="address"
                                          required/></label>
                    <label>Contact No.:<input class="form-control nullCheck" type="tel" name="contact" id="contact"
                                              placeholder="888 888 8888" pattern="[0-9]{3} [0-9]{3} [0-9]{4}" maxlength="12"  title="Ten digits code" required/></label>
                    <div><small id="myError3"></small></div>
                </div>
                <div class="col-6">
                    <label>Date of Birth:<input class="form-control" type="date" name="dob" id="dob" required/></label>
                    <fieldset class="gender"><label>Gender: </label>
                        <label><input type="radio" name="gender" value="Male" required/> Male</label>
                        <label><input type="radio" name="gender" value="Female" required/> Female</label>
                        <label><input type="radio" name="gender" value="Other" required/> Other</label></fieldset>

                    <label>Image:</label>
                    <input class="form-control" type="file" name="file" size="20" value="#"/>
                    <input class="btn btn-lg btn-primary btn-block btn-signin" type="button" value="Upload File"/>
                    <hr/>
                    <button type="reset" class="btn btn-lg btn-primary btn-block btn-signin">Reset Form</button>
                </div>
            </div>
            <input class="btn btn-lg btn-primary btn-block btn-signin" id="signupBtn" type="button" value="Sign-Up"/>
<div class="row">
<div class="col-6">
                <small>Already have an account?</small>
                <input class="btn btn-lg btn-primary btn-block btn-signin" id="gotoLogin" type="button" value="Sign-In"/>
            </div>
            <div class="col-6"><br/>
                <input class="btn btn-lg btn-primary btn-block btn-signin" id="goHome" type="button" value="Go Home"/>
            </div></div>
        </div>
    </div>
</form>
</body>
<style>
    #myError {
        color: red;
    }
</style>

</html>
