var IDEAL = {

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

    initTree: function(tree, select_url, setting){
        $.ajax({
            type:"post",
            url: select_url,
            dataType:"json",
            success:function(res){
                res[0].open = true;
                $.fn.zTree.init($(tree), setting, res);
            }
        });
    }

};