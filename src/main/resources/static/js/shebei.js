var setting={
    callback: {//回调函数
        onClick:ztreeOnClick,
        beforeRemove: beforeRemove,//删除节点之前执行回调函数
        onRename: onRename//捕获节点编辑名称结束之后的事情回调函数
    },
    async: {
        enable: true,//是否使用异步加载 true使用
        url:"/ecg/oneEqmCateGory",//请求路径
    },
    view: {
        addHoverDom: addHoverDom,//鼠标移动到节点上，显示按钮
        removeHoverDom: removeHoverDom,//鼠标移除节点，隐藏按钮
        selectedMulti: false//是否允许选中多个节点，false不允许
    },
    edit: {
        enable: true,
        showRemoveBtn:showRemoveBtn,
        drag: {
            isCopy: false,
            isMove: true
        }
    },
    data:{
        simpleData:{
            enable: true,
            idKey: "id", //节点数据中保存唯一标识的属性名称
            pIdKey: "pid",//节点数据中保存其父节点唯一标识的属性名称
            rootPId: 0  //用于修正根节点父节点数据，即 pIdKey 指定的属性值
        }
    }

};

//是否显示删除按钮
function showRemoveBtn(treeId, treeNode) {
    //获取节点所配置的noRemoveBtn属性值
    if (treeNode.noRemoveBtn != undefined && treeNode.noRemoveBtn) {
        return false;
    } else {
        return true;
    }
}

var zNodes =[];
var log, className = "dark";
//删除节点
function beforeRemove(treeId, treeNode) {
    className = (className === "dark" ? "":"dark");
    var zTree = $.fn.zTree.getZTreeObj("shebei");
    zTree.selectNode(treeNode);
    var conf = confirm("是否删除这个节点？");
    if(conf==true){
        var id = treeNode.id;
        $.ajax({
            url:"/ecg/delEqmCateGory",
            type:"post",
            dataType:"json",
            data:{id:id},
            success:function(data){
                alert("删除成功");
                initZTree();
            }
        })
        return true;
    }else return false;
}
//编辑节点
function onRename(e, treeId, treeNode, isCancel) {
    var name = treeNode.name;
    var id = treeNode.id;
    var code = treeNode.code;
    alert(id)
    $.ajax({
        url:"/ecg/upEqmCateGory",
        type:"post",
        dataType:"json",
        data:{id:id,
            name:name,
            code:code
        },
        success:function(data){
            alert("修改成功");
            initZTree();
        }
    })
}

var newCount = 1;
//鼠标悬浮显示节点
function addHoverDom(treeId, treeNode) {
    if(treeNode.pid == 0){
            treeNode.noRemoveBtn=true;
            treeNode.noEditBtn=true;
    }
    var sObj = $("#" + treeNode.tId + "_span");
    if (treeNode.editNameFlag || $("#addBtn_"+treeNode.tId).length>0) return;
    var addStr = "<span class='button add' id='addBtn_" + treeNode.tId
        + "' title='add node' onfocus='this.blur();'></span>";

    sObj.after(addStr);
    var btn = $("#addBtn_"+treeNode.tId);//添加节点
    if (btn) btn.bind("click", function(){
        $('#addTree').modal('show');
        $("#pId").val(treeNode.id);
    });
};

//鼠标移除隐藏节点
function removeHoverDom(treeId, treeNode) {
    $("#addBtn_"+treeNode.tId).unbind().remove();
};








$(document).ready(function(){
    initZTree();

    $("#tab").bootstrapTable({
        url:"/ecg/allid/"+100,//请求的路径
        pagination:true,//分页的开关，默认是关闭的
        sidePagination:"server",//客户端分页
        pageList:[5,10,20],
        pageSize:3,
        queryParams:function(param){
            return{
                offset:param.offset,
                limit:param.limit,
                sort:param.sort,
                order:param.order
            }
        },
        columns: [//field对应的是entity中的属性  title:列名
            {
                field: 'id', // 返回json数据中的name
                title: '', // 表格表头显示文字

            }, {
                field: 'name',
                title: '设备名称'
            },  {
                field: 'equno',
                title: '设备编号',
            },  {
                field: 'storagedate',
                title: '设备日期',
            },  {
                field: 'equstatus',
                title: '设备状态',
                formatter:function(value,row,index){

                    if (row.equstatus=="normal") {
                        return "正常";
                    }else{
                        return "故障";
                    }

                }
            },  {
                field: 'eqmUseStatue',
                title: '使用状态',
                formatter:function(value,row,index){

                    if (row.eqmUseStatue=="using") {
                        return "使用中";
                    }else{
                        return "空闲中";
                    }

                }
            }, {
                field: 'eqmStartUseDate',
                title: '精准等级'
            },{
                field: '',
                title: '岗位'
            },
            {
                field: '',
                title: '供应商'
            },
            {
                title: "操作",
                field:'id',
                formatter:function(value,row,index){
                    if(row.addr_default==1){
                        return "--";
                    }
                    var a="<a onclick='deleteUserById("+value+")'><img src='/static/imgs/icon76.gif'></a>&nbsp;&nbsp;";
                    var b="<a onclick='deleteUserById("+value+")'><img src='/static/imgs/print.gif'></a>&nbsp;&nbsp;";
                    var c="<a onclick='deleteUserById("+value+")'><img src='/static/imgs/icon13.gif'></a>&nbsp;&nbsp;";
                    var d="<a onclick='deleteEqmById("+value+")'><img src='/static/imgs/icon19.gif'></a>&nbsp;&nbsp;";
                    if (row.eqmUseStatue=="using") {
                        return a+b+c;
                    }else{
                        return a+b+c+d;
                    }
                }
            }
        ]
    });
});



function initZTree(){
    $.fn.zTree.init($("#shebei"),setting);
}


function ztreeOnClick(event,treeId,treeNode){
    var name=treeNode.name;
    var n = name.substring(0,name.indexOf("["));
    $("#biaoti").html(n);
    var id=treeNode.id;
    $("#tab").bootstrapTable('destroy');
    $("#tab").bootstrapTable({
        url:"/ecg/allid/"+treeNode.id,//请求的路径
        pagination:true,//分页的开关，默认是关闭的
        sidePagination:"server",//客户端分页
        pageList:[5,10,20],
        pageSize:3,
        queryParams:function(param){
            return{
                offset:param.offset,
                limit:param.limit,
                sort:param.sort,
                order:param.order
            }
        },
        columns: [//field对应的是entity中的属性  title:列名
            {
                field: 'id', // 返回json数据中的name
                title: '', // 表格表头显示文字

            }, {
                field: 'name',
                title: '设备名称'
            },  {
                field: 'equno',
                title: '设备编号',
            },  {
                field: 'storagedate',
                title: '设备日期',
            },  {
                field: 'equstatus',
                title: '设备状态',
                formatter:function(value,row,index){
                    if (row.equstatus=="normal") {
                        return "正常";
                    }else{
                        return "故障";
                    }
                    }
            },  {
                field: 'eqmUseStatue',
                title: '使用状态',
                formatter:function(value,row,index){
                    if (row.eqmUseStatue=="using") {
                        return "使用中";
                    }else{
                        return "空闲中";
                    }
                    }
            }, {
                field: 'eqmStartUseDate',
                title: '精准等级'
            },{
                field: '',
                title: '岗位'
            },
            {
                field: '',
                title: '供应商'
            },
            {
                title: "操作",
                field:'id',
                formatter:function(value,row,index){
                    if(row.addr_default==1){
                        return "--";
                    }
                    var a="<a onclick='deleteUserById("+value+")'><img src='/static/imgs/icon76.gif'></a>&nbsp;&nbsp;";
                    var b="<a onclick='deleteUserById("+value+")'><img src='/static/imgs/print.gif'></a>&nbsp;&nbsp;";
                    var c="<a onclick='deleteUserById("+value+")'><img src='/static/imgs/icon13.gif'></a>&nbsp;&nbsp;";
                    var d="<a onclick='deleteEqmById("+value+")'><img src='/static/imgs/icon19.gif'></a>&nbsp;&nbsp;";
                    if (row.eqmUseStatue=="using") {
                        return a+b+c;
                    }else{
                        return a+b+c+d;
                    }
                    }
            }
        ]
    });
}

function deleteEqmById(id) {
    $.ajax({
        type:"post",
        url:"/ecg/delEqm",
        data:{id:id},
        dataType:"json",
        success:function(data){
            if(data){
                alert("删除成功");
                $("#tab").bootstrapTable("refresh");
            }else{
                alert("错误提示！")
            }
        }
    });
}

function addEqmCateGory() {
    var id = $("#pId").val();
    var name = $("#zname").val();
    $.ajax({
        type:"post",
        url:"/ecg/addEqmCateGory",
        data:{id:id,name:name},
        dataType:"json",
        success:function(data){
            if(data){
                alert("添加成功！");
                initZTree();
            }else{
                alert("错误提示！")
            }
        }
    });
}