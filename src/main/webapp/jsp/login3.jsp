<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2019/11/14
  Time: 19:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta charset="UTF-8">
    <title>登录</title>
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <meta name="keywords" content="" />
    <meta name="description" content="" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/vendor/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/fonts/iconic/css/material-design-iconic-font.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/assets/css/font-awesome.min.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/assets/css/ace-skins.min.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/util.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/main.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/font.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/xadmin.css">
    <script src="${pageContext.request.contextPath}/static/common/jquery-3.2.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/xadmin.js"></script>
    <script src="${pageContext.request.contextPath}/static/layui/layui.js" charset="utf-8"></script>



</head>

<body style="background-image: url(${pageContext.request.contextPath}/static/images/pic/12412.jpg)" class="login-bg">
<div class="limiter">
    <div class="container-login100">
    <div class="wrap-login100 p-l-55 p-r-55 p-t-65 p-b-54">
            <form class="login100-form validate-form" method="post" class="layui-form">
                <span class="login100-form-title p-b-49">登录</span>

                <div class="wrap-input100 validate-input m-b-23" data-validate="请输入用户名">
                    <span class="label-input100">用户名</span>
                    <input class="input100" type="text" name="bianhao" placeholder="请输入用户名" autocomplete="off" id="bianhao">
                    <span class="focus-input100" data-symbol="&#xf206;"></span>
                </div>

                <div class="wrap-input100 validate-input" data-validate="请输入密码" >
                    <span class="label-input100">密码</span>
                    <input class="input100" type="password" name="password" placeholder="请输入密码" id="password">
                    <span class="focus-input100" data-symbol="&#xf190;"></span>
                </div>

                <div class="text-right p-t-8 p-b-31">
                    <a href="javascript:">忘记密码？</a>
                </div>

              <div class="container-login100-form-btn">
                    <div class="wrap-login100-form-btn">
                        <div class="login100-form-bgbtn"></div>
                          <button class="login100-form-btn" type="submit" lay-submit lay-filter="login">登 录</button>
                    </div>
                </div>


                <div class="txt1 text-center p-t-54 p-b-20">
                    <span>第三方登录</span>
                </div>

                <div class="flex-c-m">
                    <a href="#" class="login100-social-item bg1">
                        <i class="fa fa-wechat"></i>
                    </a>

                    <a href="#" class="login100-social-item bg2">
                        <i class="fa fa-qq"></i>
                    </a>

                    <a href="#" class="login100-social-item bg3">
                        <i class="fa fa-weibo"></i>
                    </a>
                </div>

                <div class="flex-col-c p-t-25">
                    <a href="register.jsp" class="txt2">立即注册</a>
                </div>

            </form>

        <%--<button onclick="login()">登 录</button>--%>
        </div>
    </div>
</div>

<script>
    $(function  () {
        layui.use('form', function(){
            var form = layui.form;
            form.on('submit(login)', function(data){
                var bianhao=$("input[name='bianhao']").val();
                var password=$("input[name='password']").val();
                alert(bianhao+"*****"+password);
                if(bianhao!=''&&password!=''){
                    $.ajax({
                        type: "post",//方法类型
                        url: "/user/login?bianhao="+bianhao+"&password="+password+"",
                        success: function (result) {
                            if(result!=null){
                                alert("登录成功!");
                                window.location.href = "${pageContext.request.contextPath}/jsp/index2.jsp";
                            }
                            else{
                                window.location.href = "${pageContext.request.contextPath}/login3.jsp";
                            }

                        },
                        error : function() {
                            alert("异常！");
                        }
                    });
                }
                else  return false;




            });
        });
    })

</script>




<script src="${pageContext.request.contextPath}/static/js/main.js"></script>
<!-- 底部结束 -->
</body>
</html>
