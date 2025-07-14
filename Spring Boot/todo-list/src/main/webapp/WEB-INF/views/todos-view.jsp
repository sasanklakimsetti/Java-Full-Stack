<%--
  Created by IntelliJ IDEA.
  User: saisa
  Date: 14-07-2025
  Time: 11:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ToDo List</title>
</head>
<body>
<h2>Welcome <%=request.getAttribute("username")%></h2>
<h3>Your ToDo list: </h3>
<%=request.getAttribute("list")%>
</body>
</html>
