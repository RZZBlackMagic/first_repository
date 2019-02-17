var Init = {
    checkLogin : function(){
        var _ticket = $.cookie("IDEAL_TOKEN");
        if(!_ticket){
            return ;
        }
        $.ajax({
            url : "http://localhost:8088/productor/token/" + _ticket,
            dataType : "jsonp",
            type : "GET",
            success : function(data){
                if(data.status == 200){

                }
            }
        });
    }
};