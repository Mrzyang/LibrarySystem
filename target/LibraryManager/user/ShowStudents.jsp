<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>学生列表</title>
</head>
<body>
<table border=1>
    <tr align="center">
        <td colspan="6">学生信息表</td>
    </tr>
    <tr>
        <td>学号</td>
        <td>姓名</td>
        <td>电话</td>
        <td>地址</td>
        <td>性别</td>
        <td>院系</td>
    </tr>
    <c:forEach var="i" items="${students}">
        <tr>
            <td><c:out value="${i.sno}" /></td>
            <td><c:out value="${i.sname}" /></td>
            <td><c:out value="${i.sphone}" /></td>
            <td><c:out value="${i.saddr}" /></td>
            <td><c:if test="${i.sgender ==0}">女</c:if> <c:if
                    test="${i.sgender ==1}">男</c:if></td>
            <td><c:out value="${i.sdeptNo}" /></td>
        </tr>
    </c:forEach>
    <tr>
        <td><a href="<c:url value="NewStudent.jsp"/>">录入学生信息</a></td>
    </tr>
</table>
</body>
</html>