/**
 * MANAGER
 */
var XINER = {
    initManagerLogoTable: function (table) {
        $(table).bootstrapTable({
            url: '/commodity/goodpage',       //请求后台的URL（*）
            method: 'get',                      //请求方式（*）
            contentType: "application/x-www-form-urlencoded",
            dataType: "json",
            toolbar: '#toolbar',                //工具按钮用哪个容器
            // cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
            pagination: true,                   //是否显示分页（*）
            sortable: true,                     //是否启用排序
            sortOrder: "asc",                   //排序方式
            // // queryParams: oTableInit.queryParams,//传递参数（*）
            sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
            pageNumber: 1,                       //初始化加载第一页，默认第一页
            pageSize: 10,                       //每页的记录行数（*）
            pageList: [10, 25, 50, 100],        //可供选择的每页的行数（*）
            search: true,                       //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
            strictSearch: true,
            showColumns: true,                  //是否显示所有的列
            showRefresh: true,                  //是否显示刷新按钮
            minimumCountColumns: 1,             //最少允许的列数
            // clickToSelect: true,                //是否启用点击选中行
            // height: 550,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
            // uniqueId: "no",                     //每一行的唯一标识，一般为主键列
            showToggle: true,                    //是否显示详细视图和列表视图的切换按钮
            cardView: false,                    //是否显示详细视图
            detailView: false,                   //是否显示父子表
            queryParamsType:'limit',//查询参数组织方式
            queryParams : function (params) {//上传服务器的参数
                var temp = {//如果是在服务器端实现分页，limit、offset这两个参数是必须的
                    limit : params.limit, // 每页显示数量
                    page: (params.offset / params.limit) + 1   //当前页码
                    
                };
                return temp;
            },
            columns: [
                {
                    checkbox: true, // 显示一个勾选框
                    align: 'center' // 居中显示
                },
                {
                    field: 'id',
                    title: 'ID',
                    sortable: true
                },
                {
                    field: 'name',
                    title: 'LOGO'
                },
                {
                    field: 'price',
                    title: '品牌名称',
                    formatter: function (value) {
                        var f_x = Math.round(value) / 100;
                        var s_x = f_x.toString();
                        var pos_decimal = s_x.indexOf('.');
                        if (pos_decimal < 0) {
                            pos_decimal = s_x.length;
                            s_x += '.';
                        }
                        while (s_x.length <= pos_decimal + 2) {
                            s_x += '0';
                        }
                        return s_x;
                    }
                },
                {
                    field: 'num',
                    title: '具体描述'
                },
                {
                    field: '',
                    title: '所属国家'
                },
                {
                    field: '',
                    title: '操作',
                    align: 'center',
                    formatter: function () {
                        var result = "";
                        result += "<a href='javascript:;' class='btn btn-xs' title='查看'><span class='glyphicon glyphicon-th-large'></span></a>";
                        result += "<a href='javascript:;' class='btn btn-xs' title='编辑'><span class='glyphicon glyphicon-cog'></span></a>";

                        return result;
                    }
                }

            ]
        });
    },
    initEditor: function(select, url){
        var kingEditorParams = {
            //指定上传文件参数名称
            filePostName  : "uploadFile",
            //指定上传文件请求的url。
            uploadJson : url,
            //上传类型，分别为image、flash、media、file
            dir : "image"
        };
        return KindEditor.create(select, kingEditorParams)
    },
    initTree: function(zNodes){
        var setting = {
            view: {
                selectedMulti: false
            },
            check: {
                enable: true
            },
            data: {
                simpleData: {
                    enable: true
                }
            },
            callback:{
                beforeCheck:true,
                onCheck:onCheck
            }

        };
        $.fn.zTree.init($("#treeDemo"), setting, zNodes);
        function onCheck(e,treeId,treeNode){
            var treeObj=$.fn.zTree.getZTreeObj("treeDemo"),
                nodes=treeObj.getCheckedNodes(true),
                name="",
                cid="";
            for(var i=0;i<nodes.length;i++){
                name+=nodes[i].name + "; ";
                cid+=nodes[i].id + ",";
                // console.log("节点id:"+nodes[i].id+"节点名称"+v); //获取选中节点的值
            }
            $("#btn_add").click(function () {
                $("#add-type-display").val(name);
                $("#cid_list").val(cid);
            });

        }
    },
    dateFormat: function(cellval) {
        var dateVal = cellval + "";
        if (cellval != null) {
            var date = new Date(parseInt(dateVal.replace("/Date(", "").replace(")/", ""), 10));
            var month = date.getMonth() + 1 < 10 ? "0" + (date.getMonth() + 1) : date.getMonth() + 1;
            var currentDate = date.getDate() < 10 ? "0" + date.getDate() : date.getDate();
    
            var hours = date.getHours() < 10 ? "0" + date.getHours() : date.getHours();
            var minutes = date.getMinutes() < 10 ? "0" + date.getMinutes() : date.getMinutes();
            var seconds = date.getSeconds() < 10 ? "0" + date.getSeconds() : date.getSeconds();
    
            return date.getFullYear() + "-" + month + "-" + currentDate + " " + hours + ":" + minutes + ":" + seconds;
        }
    }

};