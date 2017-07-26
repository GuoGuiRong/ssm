<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<base href="<%=basePath%>" />
<head>
    <script type="application/javascript" src="${basePath}js/jquery-1.8.3.min.js"></script>
</head>
<title>SUCCESS页面</title>
<body>

<h1>success!${msg }</h1>
<input type="button" value="查看所有用户">
<table border="1">
    <thead>
        <tr>
            <td>id</td>
            <td>name</td>
            <td>age</td>
            <td>dob</td>
        </tr>
    </thead>
    <tbody>
    </tbody>
</table>
<script type="application/javascript">
    $(function(){
        $("input:button").click(function(){
            $.ajax({
                type:"POST",
                url:"user/getAll",
                dateType:"json",
                success:function (data) {
                    if(data!=""&&data!=null){
                        $("tbody").empty();
                        $.each(data,function(){
                            var note = "<tr><td>"+this.id+"</td><td>"+this.name+"</td><td>"+this.age+"</td><td>"+this.dob+"</td></tr>";
                            $("tbody").append(note);
                        })
                        $("tbody").hide().fadeIn();
                    }
                }
            });
        });
    });
</script>
</body>
<hr>
</html>