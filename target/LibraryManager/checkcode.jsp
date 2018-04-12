<%--
  Created by IntelliJ IDEA.
  User: Mrzyang
  Date: 2018/4/12
  Time: 9:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>验证码示例</title>
</head>
<body>
<!-- 验证码 -->
<tr>
    <td nowrap width="437"></td>
    <td>
        <img id="img" src="${ctx}/authImage" onclick="javascript:changeImg()"/>
    </td>
</tr>


<!-- 触发JS刷新验证码-->
<script type="text/javascript">
    function changeImg(){
        var img = document.getElementById("img");
        img.src = "${ctx}/authImage?date=" + new Date();;
    }
</script>
</body>
</html>
