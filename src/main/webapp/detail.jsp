<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <title>后台管理</title>
    <link rel="stylesheet" type="text/css" href="assets/css/common.css"/>
    <link rel="stylesheet" type="text/css" href="assets/css/main.css"/>
    <link type="text/css" rel="stylesheet" href="assets/css/detail.css">
</head>
<body>
<div class="topbar-wrap white">
    <div class="topbar-inner clearfix">
        <div class="topbar-logo-wrap clearfix">
            <h1 class="topbar-logo none"><a class="navbar-brand">后台管理</a></h1>
            <ul class="navbar-list clearfix">
                <li><a class="on" href="/book.do?type=pageList">首页</a></li>
                <li><a href="/book.do?type=pageList" target="_blank">网站首页</a></li>
            </ul>
        </div>
        <div class="top-info-wrap">
            <ul class="top-info-list clearfix">
                <li><a>${username}</a></li>
                <li><a>修改密码</a></li>
                <li><a href="/login.do?type=logout">退出</a></li>
            </ul>
        </div>
    </div>
</div>
<div class="container clearfix">
    <div class="sidebar-wrap">
        <div class="sidebar-title">
            <h1>菜单</h1>
        </div>
        <div class="sidebar-content">
            <ul class="sidebar-list">
                <li>
                    <ul class="sub-menu">
                        <li><a><i class="icon-font">&#xe005;</i>图书管理</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
    <!--/sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="/book.do?type=pageList">首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">图书管理</span></div>
        </div>
        <div class="detailBox">
            <div class="imgbox">
                <img src="${book.img}" class="bookimg">
            </div>
            <div class="bookcontent">
                <P class="bookname">${book.name}</P>
                <div class="info">
                    <table>
                       <tr> <td>价格: <span class="price">${book.price}</span></td></tr>
                        <tr>
                            <td>作者: <span class="author">${book.author}</span></td>
                            <td>类别: <span class="cate">${book.cate.name}</span>
                        </tr>
                        <tr>
                            <td>出版日期: <span class="pdate">${book.pdate}</span></td>
                            <td>位置: <span class="address">${book.address}</span></td>
                        </tr>
                        <tr> <td>摘要: <span class="description">${book.description}</span></td></tr>
                    </table>
                </div>
             </div>
            <div class="detail">${book.detail}</div>
        </div>
</body>
</html>