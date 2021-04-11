<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/4/11
  Time: 1:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/getListReqParam" method="post">
        <!--需要表明是第幾個User對象的username age-->
        username <input type="text" name="userList[0].username"><br>
        age <input type="text" name="userList[0].age"><br>

        username <input type="text" name="userList[1].username"><br>
        age <input type="text" name="userList[1].age"><br>

        <input type="submit" value="提交">
    </form>
</body>
</html>
