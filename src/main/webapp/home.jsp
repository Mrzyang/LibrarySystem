<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <title>后台管理</title>
    <link rel="stylesheet" type="text/css" href="assets/css/common.css"/>
    <link rel="stylesheet" type="text/css" href="assets/css/main.css"/>
    <link rel="stylesheet" type="text/css" href="assets/css/pagination.css">
    <script type="text/javascript" src="assets/js/libs/modernizr.min.js"></script>
    <script src="assets/js/jquery-3.2.1.js"></script>
    <script src="assets/layer/layer.js"></script>
    <script src="assets/js/dateFormat.js"></script>
    <style type="text/css">
        td,#col-title th{text-align: center;}
    </style>
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
        <div class="search-wrap">
            <!--用于查询得表单-->
            <div class="search-content">
                <form method="get" action="/book.do" id="searchForm">
                    <input type="hidden" name="type" value="search">
                    <table class="search-tab">
                        <tr>  
                            <th width="70">书名:</th>
                            <td><input class="common-text" placeholder="" name="bookname"  id="bookname" value="${type=="search"?formerKeywords:""}" type="text" style="width:150px"></td>
                            <th width="80">选择分类:</th>
                            <td>
                                <select name="cateId" class="common-text" id="cateId">
                                    <option value="0">全部</option>
                                </select>
                            </td>
                            <th width="80">价格区间:</th>
                            <td>
                                <input type="number" name="minprice" id="minprice" min="0" max="1000" placeholder="Min" value="${type=="search"?formerMinprice:""}" class="common-text">--
                                <input type="number" name="maxprice" id="maxprice" min="0" max="1000" placeholder="Max" value="${type=="search"?formerMinprice:""}" class="common-text">
                            </td>
                            <th width="80">出版日期:</th>
                            <td>
                                <input type="date" name="minPdate" min="1900-01-01" id="minPdate" value="${type=="search"?formerMinpdate:""}" class="common-text">--
                                <input type="date" name="maxPdate" min="1900-01-01" id="maxPdate" value="${type=="search"?formerMaxpdate:""}" class="common-text">
                            </td>
                            <td style="padding-left:50px"><button class="btn btn-primary btn2" type="button" onclick="searchSubmit()">查询</button></td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
        <div class="result-wrap">
            <form name="myform" id="myform" method="post">
                <div class="result-title">
                    <div class="result-list">
                        <a href="add.jsp"><i class="icon-font"></i>添加书籍</a>
                        <a id="batchDel" href="javascript:void(0)" onclick="many_del()"><i class="icon-font"></i>批量删除</a>
                        <a id="updateOrder" href="javascript:void(0)"><i class="icon-font"></i>更新排序</a>
                    </div>
                </div>
                <div class="result-content">
                    <table class="result-tab" width="100%">
                        <tr id="col-title">
                            <th class="tc" width="5%"><input id="allChoose" name="" type="checkbox"></th>
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
                        <c:forEach var="i" items="${books}">
                        <tr>
                            <td class="tc"><input name="ids[]" value="${i.id}" type="checkbox" class="singleChoose"></td>
                            <td><img src="${i.img}" width="80px" height="85"></td>
                            <td>${i.id}</td>
                            <td>${i.name}</td>
                            <td>${i.author}</td>
                            <td>${i.cate.name}</td>
                            <td>${i.pdate}</td>
                            <td>${i.price}</td>
                            <td>${i.address}</td>
                            <td style="text-align: left">${i.description}</td>
                            <td align="center">
                                <a class="link-update btn btn-success btn2" href="/book.do?type=detail&id=${i.id}">查看</a>
                                <a class="link-update btn btn-warning btn2" href="/book.do?type=update&id=${i.id}">修改</a>
                                <a class="link-del btn btn-danger btn2" onclick="detete_book(${i.id},this)">删除</a>
                            </td>
                        </tr>
                        </c:forEach>
                    </table>
                    <div class="list-page">
                        <c:set var="params" value="${type=='search'?queryParams:''}"/>
                        <ul class="pagination">
                            <li><a href="/book.do?page=1&type=${type}${params}">首页</a></li>
                            <li><a href="/book.do?type=${type}&page=${page-1>1?page-1:1}${params}">&laquo;</a></li>

                            <c:forEach begin="1" end="${totalPages}" varStatus="loop">
                                <c:set var="active" value="${loop.index==page?'active':''}"/>
                                <li class="${active}">
                                    <a href="/book.do?type=${type}&page=${loop.index}${params}">${loop.index}</a>
                                </li>
                            </c:forEach>
                            <li>
                                <a href="/book.do?type=${type}&page=${page+1<totalPages?page+1:totalPages}${params}">&raquo;</a>
                            </li>
                            <li><a href="/book.do?type=${type}&page=${totalPages}${params}">尾页</a></li>
                        </ul>
                    </div>
                </div>
            </form>
        </div>
    </div>
    <!--/main-->
</div>
<p hidden id="formerCateId">${type=="search"?formerCateId:0}</p>
</body>
</html>

<script>
    //获取分类列表
    $(document).ready(function () {
        var opt;
        var formerCateId=$('#formerCateId').text();
        $.post("cate.do","",function (data,status) {
            if(data){
                //循环读入数据并添加到院系列表中
                $.each($.parseJSON(data),function (i,item) {
                    if(item.id==formerCateId)
                        opt="<option value="+item.id+" selected>"+item.name+"</option>";
                    else
                        opt="<option value="+item.id+">"+item.name+"</option>";
                    $("#cateId").append(opt);
                })
            }
        });
    });
</script>
<script>
    //格式化日期为yyyy-MM-dd形式,将查询得最大时间范围设定为今天
    $(document).ready(function () {
        var date=new Date();
        var today= date.Format("yyyy-MM-dd");
        $('#minPdate').attr('max',today);
        $('#maxPdate').attr('max',today);
        if($('#maxPdate').val().length==0)
            $('#maxPdate').val(today);
    })
</script>

<script>
    //查询表单的提交
    function searchSubmit() {
        var minprice=$('#minprice').val();
        var maxprice=$('#maxprice').val();
        if(minprice>maxprice){
            alert("输入有误，价格区间右端必须比左端大！");
            return;
        }

        var maxpdate=$('#maxPdate').val();
        var minpdate=$('#minPdate').val();
        if(minpdate>maxpdate){
            alert("输入有误，时间区间右端必须比左端大！");
            return;
        }
        $('#searchForm').submit();
    }
</script>


<!--删除，修改，批量删除的js脚本-->
<script>
    function detete_book(id, obj) {
        layer.confirm('确认要删除吗？', function (index) {
            //此处请求后台程序，下方是成功后的前台处理……
            $.get("book.do", { id: id,type: 'delete'});
            $(obj).parents("tr").remove();
            layer.msg('已删除!', { icon: 1, time: 1000 });
        });
    }
    function many_del() {
        var idStr = '';
        $(".singleChoose").each(function () {
            if ($(this)[0].checked) {
                idStr += $(this).val() + ',';
            }
        });
        if (!idStr) { alert('请至少勾选一个！'); return }
        layer.confirm('确认要删除吗？', function (index) {
            $.get("/book.do", { idStr: idStr,type: 'batchDel' })
            layer.msg('已删除!', { icon: 1, time: 1000 });
            window.location.reload();
        });
    }

    //checkbox的全选与取消全选
    $('#allChoose').on('change', function () {
        if ($(this).is(':checked')) {
            $('.singleChoose').prop('checked', 'checked');
        } else {
            $('.singleChoose').prop('checked', '');
        }
    })
</script>