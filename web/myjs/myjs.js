/**
 * Created by Flyme on 2017/1/23.
 */

function ajaxsubmit(who, refreshparent) {
    var currentform = $(who.form);
    $.ajax({
        type: who.form.method,
        url: who.form.action,
        data: currentform.serialize(),
        async: false,
        error: function(data) {
            alert("处理出错");
        },
        success: function(data) {
            if(data == "" || data == "ok"){
                alert("操作成功");
                if(refreshparent)
                    window.open("/pages/home.jsp", "_parent");
                else
                    location.reload();
            }else{
                alert(data);
            }
        }
    });
}

function ajaxurl(url, feedback, refreshparent) {
    $.ajax({
        type: "POST",
        url: url,
        async: false,
        error: function(data) {
            alert("连接出错");
        },
        success: function(data) {
            if(data == "" || data == "ok"){
                if(feedback)
                    alert("操作成功");
                
                if(refreshparent)
                    window.open("/pages/home.jsp", "_parent");
                else
                    location.reload();
            }else{
                alert(data);
            }
        }
    });
}