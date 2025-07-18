<%--
  Created by IntelliJ IDEA.
  User: saisa
  Date: 14-07-2025
  Time: 15:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
<h2>Welcome</h2>
<button type="submit" name="register" id="register">Register User</button>
</body>
<script>
    document.getElementById('register').addEventListener('click', ()=>{
        window.location.href='user-registration.jsp'
    });
</script>
</html>
