<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2019/12/18
  Time: 20:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/ajaxfileupload.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-1.8.3.min.js"></script>
</head>
<body>

<input type="file" capture="camera" accept="images/*"  id="upload" name="file">

<script>
    $("#upload").live("change",upload);
    function upload(event){
        if(event.target.files.length == 1 ) {
            if (event.target.files[0].size >= 4096000) {
                alert('您这张图片过大，应小于4M');
            }else{
                $.ajaxFileUpload(
                    {url:'ossPic',
                    secureuri:false,
                    fileElementId:'upload',
                    dataType: 'text/html',
                    success: function(data,success){
                        alert(data);
                    },
                    error: function (data, status, e){
                        aler("上传图片失败，请稍后重试。");
                        closeLoad();
                    }
                });
            }
        }else{
            alert('您上传的不是图片，请选择图片上传');
        }
    }
</script>

</body>
</html>
