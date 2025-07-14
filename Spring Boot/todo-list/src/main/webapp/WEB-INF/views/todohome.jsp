<%--
  Created by IntelliJ IDEA.
  User: saisa
  Date: 14-07-2025
  Time: 09:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Home</title>
  </head>
  <body>
  <h2>To Do Home</h2>
  <div>
  <%
    String error=(String) request.getAttribute("error");
    if(error!=null) System.out.println(error);
  %>
  </div>
  <form action="/login" method="post">
    Username: <input type="text" name="username"/> <br>
    Password: <input type="password" name="password"/> <br>
    <input type="submit" value="Submit"/>
  </form>
  </body>
</html>
