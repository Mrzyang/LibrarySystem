<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <title>后台管理</title>
    <link rel="stylesheet" type="text/css" href="assets/css/common.css"/>
    <link rel="stylesheet" type="text/css" href="assets/css/main.css"/>
    <script type="text/javascript" src="assets/js/libs/modernizr.min.js"></script>
</head>
<body>
<div class="topbar-wrap white">
    <div class="topbar-inner clearfix">
        <div class="topbar-logo-wrap clearfix">
            <h1 class="topbar-logo none"><a href="index.html" class="navbar-brand">后台管理</a></h1>
            <ul class="navbar-list clearfix">
                <li><a class="on" href="index.html">首页</a></li>
                <li><a href="#" target="_blank">网站首页</a></li>
            </ul>
        </div>
        <div class="top-info-wrap">
            <ul class="top-info-list clearfix">
                <li><a>${username}</a></li>
                <li><a href="http://www.jscss.me">修改密码</a></li>
                <li><a href="/logout">退出</a></li>
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
                        <li><a href="design.html"><i class="icon-font">&#xe005;</i>图书管理</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
    <!--/sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="/jscss/admin">首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">图书管理</span></div>
        </div>
        <div class="search-wrap">
            <div class="search-content">
                <form action="/jscss/admin/design/index" method="post">
                    <table class="search-tab">
                        <tr>  
                            <th width="70">书名:</th>
                            <td><input class="common-text" placeholder="" name="bookname" value="" id="" type="text" style="width:150px"></td>
                            <th width="80">选择分类:</th>
                            <td>
                                <select name="search-sort" class="common-text">
                                    <option value="">全部</option>
                                    <option value="19">精品界面</option><option value="20">推荐界面</option>
                                </select>
                            </td>
                            <th width="80">价格区间:</th>
                            <td>
                                <input type="number" name="minprice" min="0" max="1000" placeholder="Min" class="common-text">
                                <input type="number" name="minprice" min="0" max="1000" placeholder="Max" class="common-text">
                            </td>
                            <th width="80">出版日期:</th>
                            <td>
                                <input type="date" name="bday" min="1900-01-01" max="2018-04-12" class="common-text">
                                <input type="date" name="bday" min="1900-01-01" max="2018-04-12" class="common-text">
                            </td>
                            <td style="padding-left:50px"><button type="button" class="btn btn-primary btn2">查询</button></td>                              
                        </tr>
                    </table>
                </form>
            </div>
        </div>
        <div class="result-wrap">
            <form name="myform" id="myform" method="post">
                <div class="result-title">
                    <div class="result-list">
                        <a href="insert.html"><i class="icon-font"></i>新增作品</a>
                        <a id="batchDel" href="javascript:void(0)"><i class="icon-font"></i>批量删除</a>
                        <a id="updateOrd" href="javascript:void(0)"><i class="icon-font"></i>更新排序</a>
                    </div>
                </div>
                <div class="result-content">
                    <table class="result-tab" width="100%">
                        <tr>
                            <th class="tc" width="5%"><input class="allChoose" name="" type="checkbox"></th>
                            <th>缩略图</th>
                            <th>ID</th>
                            <th>书名</th>
                            <th>作者</th>
                            <th>类别</th>
                            <th>出版时间</th>
                            <th>价格</th>
                            <th>位置</th>
                            <th>描述</th>
                            <th>操作</th>
                        </tr>
                        <tr>
                            <td class="tc"><input name="id[]" value="59" type="checkbox"></td>
                            <td><img src="assets/bookicon/think.jpg" width="80px"></td>
                            <td>1</td>
                            <td>Java编程思想</td>
                            <td>[美]Bruce Eckel</td>
                            <td>编程语言</td>
                            <td>2014-03-15</td>
                            <td>91.2</td>
                            <td>TP312-1889</td>
                            <td>Java学习必读经典,殿堂级著作！赢得了全球程序员的广泛赞誉.</td>
                            <td>
                                <a class="link-update btn btn-warning btn2" href="#">修改</a>
                                <a class="link-del btn btn-danger btn2" href="#">删除</a>
                            </td>
                        </tr>
                    </table>
                    <div class="list-page"> 2 条 1/1 页</div>
                </div>
            </form>
        </div>
    </div>
    <!--/main-->
</div>
</body>
</html>