<%--
  Created by IntelliJ IDEA.
  User: saisa
  Date: 14-07-2025
  Time: 15:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Registration Page</title>
</head>
<script src="C:\lpu\PEP classes\Summer PEP\Spring Boot\user-registration\src\main\resources\static\js\user-registration.js"></script>
<body>
<h2>Register User</h2>
<form action="/register" method="post" id="registration-form">
    Username: <input type="text" name="username" id="username"> <br>
    First Name: <input type="text" name="fname" id="fname"><br>
    Last Name: <input type="text" name="lname" id="lname"><br>
    Mobile: <input type="text" name="mobile" id="mobile"><br>
    Email: <input type="text" name="mail" id="mail"><br>
    Address: <input type="text" name="address" id="address"><br>
    Date Of Birth: <input type="date" name="dob" id="dob"><br>
    Password: <input type="text" name="password" id="password"><br>
    Re-enter password: <input type="text" name="re-password" id="re-password"><br>
    <input type="submit" name="submit" value="Register" id="register">
</form>
</body>
</html>
