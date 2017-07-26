<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<base href="<%=basePath%>" />
<head>
    <script type="application/javascript" src="/static/js/jquery-1.8.3.min.js"></script>
</head>
<body>
<title>register注册页面</title>

<sf:form method="post" modelAttribute="user">
    <sf:label path="name">用户名:</sf:label>
    <sf:input path="name"/>
    <sf:errors path="name" cssStyle="color:red"></sf:errors><br>

    <sf:label path="age"> 年   龄:</sf:label>
    <sf:input path="age"/>
    <sf:errors path="age" cssStyle="color:red"></sf:errors><br>

    <sf:label path="dob"> 生   日:</sf:label>
    <sf:input path="dob"/>
    <sf:errors path="dob" cssStyle="color:red"></sf:errors><br>
    <input type="submit" value="提交"/>
</sf:form>
</body>
<hr>
</html>