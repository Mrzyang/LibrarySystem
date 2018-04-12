<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <title>后台登录</title>
    <link href="assets/css/admin_login.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div class="admin_login_wrap">
    <h1>后台管理</h1>
    <div class="adming_login_border">
        <div class="admin_input">
            <form action="index.html" method="post">
                <ul class="admin_items">
                    <li>
                        <label for="user">用户名：</label>
                        <input type="text" name="username" value="admin" id="user" size="35" class="admin_input_style" />
                    </li>
                    <li>
                        <label for="pwd">密码：</label>
                        <input type="password" name="pwd" value="admin" id="pwd" size="35" class="admin_input_style" />
                    </li>
                    <li>
                        <label for="pwd">验证码:</label>
                        <input type="password" name="pwd" value="admin" id="checkcode" size="18" class="admin_input_style" />
                        <img id="img" src="${ctx}/authImage" onclick="javascript:changeImg()" style="position: relative;top: 10px"/>
                    </li>
                    <li>
                        <button tabindex="3" type="button" class="btn btn-primary">登录</button>
                    </li>
                </ul>
            </form>
        </div>
    </div>
</div>
</body>
</html>

<!-- 触发JS刷新验证码-->
<script type="text/javascript">
    function changeImg(){
        var img = document.getElementById("img");
        img.src = "${ctx}/authImage?date=" + new Date();;
    }
</script>