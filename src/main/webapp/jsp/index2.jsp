<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/11/11
  Time: 10:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>首页</title>
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />

    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/layui/css/layui.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/font.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/xadmin.css">
    <script src="${pageContext.request.contextPath}/static/js/jquery-3.2.1.js" ></script>
    <script src="${pageContext.request.contextPath}/static/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/xadmin.js"></script>
    <%--<jsp:include page="header.jsp"></jsp:include>--%>

</head>

<script>

</script>

<script>
</script>
<script>

    //设置关闭打开左侧栏
    function ccc(a) {
        if ($(a).next("dl").css("display") == "none") {
            $(a).next("dl").css('display', '');
            $(a).next("dl").addClass("layui-nav-child");
            return;
        }
        $(a).next("dl").css("display", "none");
    }


    $(function () {//权限分配
        $.ajax({
            //几个参数需要注意一下
            type: "POST",//方法类型
            dataType: "json",//预期服务器返回的数据类型
            url: "${pageContext.request.contextPath}/user/getlimits",//url
            success: function (result) {
                if(result.length==0){
                    alert("登录信息过期,请重新登录");
                    window.location="http://localhost:8083/jsp/login3.jsp";
                    return;
                }
                var str = "";
                for (var i = 0; i < result.length; i++) {
                    if (result[i].pid >= 100) {
                        if (i == 0) {
                            str += "<li  class='layui-nav-item layui-nav-itemed'><a onclick='ccc(this)' href='javascript:;'>" + result[i].name + "</a><dl class='layui-nav-child'>";
                        } else {
                            str += "<li  class='layui-nav-item layui-nav-itemed'><a onclick='ccc(this)' href='javascript:;'>" + result[i].name + "</a><dl style='display: none' class='layui-nav-child'>";

                        }
                        for (var k = 0; k < result.length; k++) {
                            if (result[k].pid == result[i].id) {
                                str += " <dd><a  class='iframeurl'  href='javascript:;' style='color: white'  id=" + result[k].id + "  name='"+result[k].href+"'>" + result[k].name + "</a></dd>";
                            }
                        }
                        str += "</dl>";
                    }
                }
                str += "</li>";
                $("#left_menu").html(str);
            },
            error: function () {
                alert("异常！");
            }
        });
    })


    $(document).on('click', '.iframeurl', function () {
        var hrefup = $(this).attr("name");
        $("#iframe").attr("src", hrefup);
    });


</script>


<body>
<!-- 顶部开始 -->
<div class="container">
    <div class="logo"><a href="index.html">L-admin v2.0</a></div>
    <div class="left_open">
        <i title="展开左侧栏" class="iconfont">&#xe699;</i>
    </div>
    <ul class="layui-nav left fast-add" lay-filter="">
        <li class="layui-nav-item">
            <a href="javascript:;">+新增</a>
            <dl class="layui-nav-child"> <!-- 二级菜单 -->
                <dd><a onclick="x_admin_show('资讯','http://www.baidu.com')"><i class="iconfont">&#xe6a2;</i>资讯</a></dd>
                <dd><a onclick="x_admin_show('图片','http://www.baidu.com')"><i class="iconfont">&#xe6a8;</i>图片</a></dd>
                <dd><a onclick="x_admin_show('用户','http://www.baidu.com')"><i class="iconfont">&#xe6b8;</i>用户</a></dd>
            </dl>
        </li>
    </ul>
    <ul class="layui-nav right" lay-filter="">
        <li class="layui-nav-item">
            <a href="javascript:;">admin</a>
            <dl class="layui-nav-child"> <!-- 二级菜单 -->
                <dd><a onclick="x_admin_show('个人信息','http://www.baidu.com')">个人信息</a></dd>
                <dd><a onclick="x_admin_show('切换帐号','http://www.baidu.com')">切换帐号</a></dd>
                <dd><a href="login3.jsp">退出</a></dd>
            </dl>
        </li>
        <li class="layui-nav-item to-index"><a href="#">前台首页</a></li>
    </ul>

</div>
<!-- 顶部结束 -->
<!-- 左侧菜单开始 -->
<div class="left-nav">
    <div id="side-nav">
        <ul id="left_menu" class="layui-nav layui-nav-tree" lay-filter="test">
        </ul>
    </div>
</div>



<!-- 左侧菜单结束 -->
<!-- 右侧(主体)开始 -->
<div class="page-content">
    <div class="layui-tab tab" lay-filter="xbs_tab" lay-allowclose="false">
        <ul class="layui-tab-title">
            <li class="home"><i class="layui-icon">&#xe68e;</i>我的桌面</li>
        </ul>
        <div class="layui-tab-content">
            <div class="layui-tab-item layui-show">
                <iframe src='/jsp/area.jsp' frameborder="0" id="iframe"  scrolling="yes"  class="layadmin-iframe"></iframe>
            </div>
        </div>
    </div>
</div>
<div class="page-content-bg"></div>
<!-- 右侧主体结束 -->
<!-- 中部结束 -->
<!-- 底部开始 -->
<!--<div class="footer">
    <div class="copyright">Copyright ©2019 L-admin v2.3 All Rights Reserved</div>
</div>-->
<!-- 底部结束 -->



</body>
</html>
