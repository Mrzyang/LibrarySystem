<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <title>后台登录</title>
    <link href="assets/css/admin_login.css" rel="stylesheet" type="text/css" />
    <script src="assets/js/jquery-3.2.1.js"></script>
    <script src="assets/layer/layer.js"></script>
</head>
<body>
<%
    //防止重复登录
if (session.getAttribute("username")!=null)
    response.sendRedirect("/book.do?type=show");
%>
<div class="admin_login_wrap">
    <h1>后台管理</h1>
    <div class="adming_login_border">
        <div class="admin_input">
            <form id="form_for_login">
                <ul class="admin_items">
                    <li>
                        <label for="username">用户名：</label>
                        <input type="text" name="username" id="username" size="35" class="admin_input_style" />
                    </li>
                    <li>
                        <label for="password">密码：</label>
                        <input type="password" name="password"  id="password" size="35" class="admin_input_style" />
                    </li>
                    <li>
                        <label for="checkcode">验证码:</label>
                        <input type="text" name="checkcode" id="checkcode" size="18" class="admin_input_style" />
                        <img id="img" src="/authImage" onclick="javascript:changeImg()" style="position: relative;top: 10px"/>
                    </li>
                    <li>
                        <button tabindex="3" type="button" class="btn btn-primary" id="btn-submit">登录</button>
                    </li>
                </ul>
            </form>
        </div>
    </div>
</div>
</body>
</html>
<!--ajax提交表单-->
<script>
    $(document).ready(function () {
        $("#btn-submit").click(function () {
            if (!$('#username').val()) {
                alert("请输入用户名！");
                return;
            }
            if (!$('#password').val()) {
                alert("请输入密码！");
                return;
            }
            if(!$('#checkcode').val()){
                alert("请输入验证码！");
            } else {
                $.ajax({
                    type: "post",
                    url: "/login.do",
                    data: $('#form_for_login').serialize(),
                    dataType: "json",
                    success: function (msg) {
                        if (msg.status == 1) {
                            layer.msg(msg.data);
                            window.setTimeout("window.location.href='/book.do?type=show'", 1000);
                        } else {
                            layer.msg(msg.data);
                        }
                    }
                });
            }
        });
    });
</script>

<!-- 触发JS刷新验证码-->
<script type="text/javascript">
    function changeImg(){
        var img = document.getElementById("img");
        img.src = "/authImage?date=" + new Date();;
    }
</script>