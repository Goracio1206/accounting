<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<b>User Information</b>
<br/>
<br/> User ID: ${user.id}
<br/>
<br/> User Name: ${user.firstName}
<br/>
<br/> User Password: ${user.password}
<br/>
<br/> <a href="${pageContext.request.contextPath}/index.jsp">main page</a>
<br/>
<br/>
<br/>
</body>
</html>
