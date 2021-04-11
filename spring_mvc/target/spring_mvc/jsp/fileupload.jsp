<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/4/11
  Time: 11:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/fileUploads" method="post" enctype="multipart/form-data">
        名稱 <input type="text" name="name"/> <br/>
        文件 <input type="file" name="uploadFiles"/> <br/>
        文件 <input type="file" name="uploadFiles"/> <br/>
        文件 <input type="file" name="uploadFiles"/> <br/>
        <input type="submit" value="提交"/>
    </form>
</body>
</html>
