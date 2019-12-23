<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2019/12/18
  Time: 20:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>图片上传</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery.js"></script>
</head>
<body>
<form action="/user/ossPic" method="post" enctype="multipart/form-data">
<!-- 图片文本框 -->
<input type="file" class="form-control" id="file" name="file" onchange="change(this)"><br><br><br>

    <img id="upLoadImg" src=""/>


    <br><br><br>

<!-- 提交...这里pageIndex和pageSize可传可不传,主要取决于提交之后是否需要回到当前页面. -->
<button type="submit"  class="btn btn-primary">提交</button>
</form>
</body>
<script type="text/javascript">

    //js获取
    var inputTag = document.getElementById("file");
    var img = inputTag.files[0];

    function change(img) {
        var file = img.files[0];
        //获取一个指向该元素的地址
        var path = window.URL.createObjectURL(file);
        console.log(path);
        $("#upLoadImg").attr('src', path);
    }
    //如果不使用this，也可以使用jq直接获取控件
    $("file").get(0).files[0]


</script>
<%--<script>
    function submitForm(pageIndex, pageSize) {
        var formData = new FormData(); //将需要提交的参数封装起来
        formData.append("id", $("#id").val());
        var zswb = $("#file").val();    //获取file中的内容,看是否有值
        if (zswb == '' || zswb.length < 1) {    //没有file提交的时候走的接口
            $.ajax({
                url : '/user/',
                type : 'post',
                data : formData,
                processData : false,
                contentType : false,
                success : function(value) {
                    var result = JSON.parse(value);
                    if (result == 'true') {
                        window.location.href = "/index?pageIndex=" + pageIndex+ "&pageSize=" + pageSize;
                    } else {
                        Lobibox.alert('error', {msg : "媒资信息更新失败!!!"});
                    }
                }
            });
        } else {    //有file提交的时候走的接口
            formData.append("file", $("#file")[0].files[0]);
            $.ajax({
                url : '/editMovieInfo',
                type : 'post',
                data : formData,
                processData : false,
                contentType : false,
                success : function(value) {
                    var result = JSON.parse(value);
                    if (result == 'true') {
                        window.location.href = "/index?pageIndex=" + pageIndex+ "&pageSize=" + pageSize;
                    } else {
                        Lobibox.alert('error', {msg : "媒资信息更新失败!!!"});
                    }
                }
            });
        }
    }



    //图片回显:
    function preview(file) {
        $("#imgHidden").css("display", "none");
        var prevDiv = document.getElementById('preview');
        if (file.files && file.files[0]) {
            var reader = new FileReader();
            reader.onload = function(evt) {
                prevDiv.innerHTML = '<img style="width: 100px;height: 100px;" src="' + evt.target.result + '" />';
            }
            reader.readAsDataURL(file.files[0]);
        } else {
            prevDiv.innerHTML = '<div class="img" style="width: 100px;height:100px;filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale,src=\'' +
                file.value + '\'"></div>';
        }
    }
</script>--%>
</html>
