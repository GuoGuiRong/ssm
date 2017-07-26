<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<base href="<%=basePath%>" />
<head>
</head>
<title>ERROR页面</title>
<body>
<%Exception ex = (Exception) request.getAttribute("ex");%>
<h2>Exception:!<%=ex.getMessage()%></h2>
<a href=${basePath}"druid/index.html">数据库服务</a>
<div>${ex }</div>
<div>${ex.printStackTrace() }</div>
</body>
<hr>
</html>