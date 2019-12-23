<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2019/12/19
  Time: 14:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/ztree/css/demo.css" type="text/css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/ztree/css/zTreeStyle/zTreeStyle.css" type="text/css">
<script type="text/javascript" src="${pageContext.request.contextPath}/static/ztree/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/ztree/js/jquery.ztree.core.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/ztree/js/jquery.ztree.excheck.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/ztree/js/jquery.ztree.exedit.js"></script>
<head>
    <SCRIPT type="text/javascript">


        $(function() {
            onLoadZTree();
        })
        /*******树状图*******/
        var setting = {
            view: {
                dblClickExpand: false,
                showLine: false,
                selectedMulti: false,
                addHoverDom: addHoverDom, //显示按钮
                removeHoverDom: removeHoverDom, //隐藏按钮
                addHoverDom:addHoverDom,
            },
            edit: {
                enable: true,
                editNameSelectAll: true,
                removeTitle: '删除',
                renameTitle: '重命名'
            },
            data: {
                simpleData: {
                    enable: true,
                    idKey: "id",
                    pIdKey: "pid",
                    rootPId: "0"
                }
            },
            callback: {
                beforeRemove: beforeRemove, //点击删除时触发，用来提示用户是否确定删除
                beforeEditName: beforeEditName, //点击编辑时触发，用来判断该节点是否能编辑,是否进入编辑状态
                beforeRename: beforeRename, //编辑结束时触发，用来验证输入的数据是否符合要求
            }
        };

        function onLoadZTree() {
            $.ajax({
                async: false, //是否异步
                cache: false, //是否使用缓存
                type: 'POST', //请求方式：post
                url: '/user/limits', //请求的路径
                success: function (data) {
                    treeNodes = data; //把后台封装好的简单Json格式赋给treeNodes
                }
            });
            var t = $("#treeDemo");
            t = $.fn.zTree.init(t, setting, treeNodes);
            t.expandAll(true);
        }

        function removeHoverDom(treeId, treeNode) {
            $("#addBtn_" + treeNode.tId).unbind().remove();
        }

        function addHoverDom(treeId, treeNode) {}
        function beforeRename(treeId, treeNode) {}
        function beforeEditName(treeId, treeNode) {}
        function beforeRemove(treeId, treeNode) {}

    </SCRIPT>
    <style type="text/css">
    .ztree li span.button.add {margin-left:2px; margin-right: -1px; background-position:-144px 0; vertical-align:top; *vertical-align:middle}
    </style>
    <title>zTree树</title>
</head>
<body>


<div class="zTreeDemoBackground left">
    <ul id="treeDemo" class="ztree"></ul>
</div>













</body>
</html>
