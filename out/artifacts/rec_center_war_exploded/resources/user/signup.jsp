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

    <title>SignUp</title>
  </head>
  <body>
    <div class="pDiv">
      <form method="post" action="/signup">
        <fieldset><legend id="#centerText">Sign-Up Form</legend>
        <fieldset><legend>Log Detail</legend>
        <span class="pSpan">
            <label>Set userName:<input type="text" autofocus name="userName"/></label>
        </span>
        <span class="pSpan">
            <label>Set password:<input type="password" name="password"/></label>
        </span>
        </fieldset>
          <fieldset><legend>User Detail</legend>
        <span class="pSpan">
            <label>Full Name:<input type="text" name="fullName"/></label>
        </span>
        <span class="pSpan">
            <label>Occupation:</label><select name="password">
              <option value="Faculty">Faculty</option>
              <option value="Staff">Staff</option>
              <option value="Student">Student</option>
              <option value="Local Resident">Local Resident</option>
              <option value="Other">Other</option>
            </select>
        </span>
        <span class="pSpan">
            <label>Address:<input type="text" name="address"/></label>
        </span>
        <span class="pSpan">
            <label>Contact No.:<input type="tel" name="contact"/></label>
        </span>
        <span>
            <label class="pSpan">Email Address:<input type="email" name="email"/></label>
        </span>
        <span>
            <label class="pSpan">Date of Birth:<input type="date" name="dob"/></label>
        </span>
        <span>
          <label>Gender:</label>

              <label><input type="radio" name="gender" value="Male"/> Male</label>
              <label><input type="radio" name="gender" value="Female"/> Female</label>
              <label><input type="radio" name="gender" value="Other"/> Other</label>

        </span>
        <span class="pSpan">
          <label>Image:</label>
          <input type = "file" name = "file" size = "20"/><input type = "button" value = "Upload File" />
        </span>
          </fieldset>
        <span>
            <button id="signupBtn" type="submit" value="login">Sign Up</button>
        </span>
        </fieldset>
        <fieldset>
          <small>Already have an account?</small>
          <a href="/login" id="signinBtn">Sign In Here</a>
        </fieldset>
      </form>
    </div>
  </body>
</html>
