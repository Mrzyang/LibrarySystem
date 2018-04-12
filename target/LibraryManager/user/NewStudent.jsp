<%--
  Created by IntelliJ IDEA.
  User: Mrzyang
  Date: 2018/3/23
  Time: 12:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加学生</title>
    <script src="../js/jquery-3.2.1.js"></script>
    <script>
        $(document).ready(function () {
            $.post("department","",function (data,status) {
                if(data){
                    //循环读入数据并添加到院系列表中
                    $.each($.parseJSON(data),function (i,item) {
                        var opt="<option value="+item.dno+">"+item.dname+"</option>";
                        $("#dept").append(opt);
                    })
                }
            });
        });
    </script>
</head>
<body>
<h1 align="center">新增学生</h1>
<form action="student" method="post">
    <input type="hidden" name="type" value="new">
    学号:<input type="text" name="Sno"><br>
    姓名:<input type="text" name="Sname"><br>
    电话:<input type="text" name="Sphone"><br>
    地址:<input type="text" name="Saddr"><br>
    女:<input type="radio" name="Sgender" value="0">
    男:<input type="radio" name="Sgender" value="1"><br>
    院系:
    <select id="dept" name="SdeptNo">
        <option value="0">请选择</option>
    </select><br>
    <input type="submit" value="提交" name="submit">
</form>
</body>
</html>
