
var utils = {
    GetQueryString: function (name)
    {
        var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
        var r = window.location.search.substr(1).match(reg);
        if(r!=null)
            return  unescape(r[2]);
        return null;
    },
    initEditor: function(id, url){
        var kingEditorParams = {
            filePostName  : "uploadFile",
            uploadJson : url,
            dir : "image"
        };
        return KindEditor.create(id, kingEditorParams)
    },
    initCatTree: function(zNodes){
        var setting = {
            data: {
                simpleData: {
                    enable: true
                }
            },
            callback:{
                beforeClick: onClick
            }

        };
        $.fn.zTree.init($("#treeDemo"), setting, zNodes);
        function onClick(event, treeNode){
            if (treeNode.isParent == false){
                $("#category").val("id: "+treeNode.id + "  name: " + treeNode.name);
                $("#category-hidden").val(treeNode.id);
                $("#Modal2").modal('hide');
            }
        }
    }
};