<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <title>新增书籍</title>
    <link rel="stylesheet" type="text/css" href="assets/css/common.css"/>
    <link rel="stylesheet" type="text/css" href="assets/css/main.css"/>
    <script type="text/javascript" src="assets/js/libs/modernizr.min.js"></script>
    <script type="text/javascript" charset="utf-8" src="assets/ueditor/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="assets/ueditor/ueditor.all.js"> </script>
    <!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
    <!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
    <script type="text/javascript" charset="utf-8" src="assets/ueditor/lang/zh-cn/zh-cn.js"></script>
    <script src="assets/js/jquery-3.2.1.js"></script>
    <script src="assets/layer/layer.js"></script>
    <script>
        //获取分类列表
        $(document).ready(function () {
            $.post("cate.do","",function (data,status) {
                if(data){
                    //循环读入数据并添加到院系列表中
                    $.each($.parseJSON(data),function (i,item) {
                        var opt="<option value="+item.id+">"+item.name+"</option>";
                        $("#cateId").append(opt);
                    })
                }
            });
        });
    </script>
    <script>
        //异步提交表单并上传图片
        function doUpload() {
            var formData = new FormData($( "#add-book" )[0]);
            if(!formData.get("bookname")){
                alert("请输入书名！");
                return;
            }
            if(!formData.get("cateId")){
                alert("请选择类别！");
                return;
            }
            if(!formData.get("price")){
                alert("请输入价格！");
                return;
            }
            if(!formData.get("author")){
                alert("请输入作者！");
                return;
            }
            if(!formData.get("pdate")){
                alert("请输入出版日期！");
                return;
            }
            if(!formData.get("address")){
                alert("请输入该书的所在位置！");
                return;
            }
            $.ajax({
                url: '/book.do' ,  /*这是处理文件上传的servlet*/
                type: 'POST',
                data: formData,
                dataType: 'json',
                //async: false,
                cache: false,
                contentType: false,
                processData: false,
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
    </script>
</head>
<body>
<div class="topbar-wrap white">
    <div class="topbar-inner clearfix">
        <div class="topbar-logo-wrap clearfix">
            <h1 class="topbar-logo none"><a href="/book.do?type=show" class="navbar-brand">后台管理</a></h1>
            <ul class="navbar-list clearfix">
                <li><a class="on" href="/book.do?type=show">首页</a></li>
                <li><a href="#" target="_blank">网站首页</a></li>
            </ul>
        </div>
        <div class="top-info-wrap">
            <ul class="top-info-list clearfix">
                <li><a>${username}</a></li>
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
                        <li><a href="design.html"><i class="icon-font">&#xe005;</i>图书管理</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
    <!--/sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="/jscss/admin/design/">首页</a><span class="crumb-step">&gt;</span><a class="crumb-name" href="/jscss/admin/design/">图书管理</a><span class="crumb-step">&gt;</span><span>新增书籍</span></div>
        </div>
       
        <!--add  form-->
        <div class="result-wrap">
            <div class="result-content">
                <form  id="add-book"  enctype="multipart/form-data">
                    <input type="hidden" value="add" name="type">

                    <table class="insert-tab" width="100%">
                        <tbody>
                             <tr>
                                <th>
                                    <i class="require-red">*</i>书名：</th>
                                <td>
                                    <input class="common-text required" id="title" name="bookname" size="50" value="" type="text">
                                </td>
                            </tr>
                            <tr>
                                <th width="120">
                                    <i class="require-red">*</i>分类：</th>
                                <td>
                                    <select name="cateId" id="cateId" class="required common-text">
                                        <option value="">请选择</option>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <th>价格：</th>
                                <td>
                                    <input type="number" name="price" min="0" max="1000"  class="common-text">
                                </td>
                            </tr>
                            <tr>
                                <th>作者：</th>
                                <td>
                                    <input class="common-text" name="author" size="50"  type="text">
                                </td>
                            </tr>
                            <tr>
                                <th>出版日期：</th>
                                <td>
                                    <input type="date" name="pdate" min="1900-01-01" max="2018-04-12" class="common-text">
                                </td>
                            </tr>
                            <tr>
                                <th>位置：</th>
                                <td>
                                    <input class="common-text" name="address" size="50" type="text">
                                </td>
                            </tr>
                            <tr>
                                <th>描述：</th>
                                <td>
                                    <input class="common-text" name="description" size="50"  type="text">
                                </td>
                            </tr>
                            <tr>
                                <th>
                                    <i class="require-red">*</i>缩略图：</th>
                                <td>
                                    <input type=file name="img" id="img" onchange="javascript:setImagePreview();">
                                     <img id="preview" width=-1 height=-1 style="diplay:none" />
                                </td>             
                            </tr>
                            <tr>
                                <th>详细信息：</th>
                                <td>
                                    <textarea name="content" class="common-textarea" id="content" cols="30" style="width: 98%;" rows="10"></textarea>
                                </td>
                            </tr>
                            <tr>
                                <th></th>
                                <td>
                                    <button class="btn btn-primary btn6 mr10" type="button" onclick="doUpload()">提交</button>
                                    <input class="btn btn6" onclick="history.go(-1)" value="返回" type="button">
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </form>
            </div>
        </div>
        <!--/add form-->
    </div>
    <!--/main-->
</div>
</body>
</html>

<!--图片及时预览-->
<script type="text/javascript">
    function setImagePreview() {
        var docObj = document.getElementById("img");
        var imgObjPreview = document.getElementById("preview");
        if (docObj.files && docObj.files[0]) {
            //火狐下，直接设img属性
            imgObjPreview.style.display = 'block';
            imgObjPreview.style.width = '150px';
            imgObjPreview.style.display="inline-block";
            imgObjPreview.style.marginLeft="10px";
            //imgObjPreview.style.height = '120px';
            //imgObjPreview.src = docObj.files[0].getAsDataURL();
            //火狐7以上版本不能用上面的getAsDataURL()方式获取，需要一下方式
            imgObjPreview.src = window.URL.createObjectURL(docObj.files[0]);
        } else {
            //IE下，使用滤镜
            docObj.select();
            var imgSrc = document.selection.createRange().text;
            var localImagId = document.getElementById("localImag");
            //必须设置初始大小
            localImagId.style.width = "50px";
            //localImagId.style.height = "200px";
            //图片异常的捕捉，防止用户修改后缀来伪造图片
            try {
                localImagId.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)";
                localImagId.filters
                    .item("DXImageTransform.Microsoft.AlphaImageLoader").src = imgSrc;
            } catch (e) {
                alert("您上传的图片格式不正确，请重新选择!");
                return false;
            }
            imgObjPreview.style.display = 'none';
            document.selection.empty();
        }
        return true;
    }
</script>

<script type="text/javascript">
    //实例化编辑器
    //建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('editor')就能拿到相关的实例
    var ue = UE.getEditor('content');
</script>