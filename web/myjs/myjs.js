/**
 * Created by Flyme on 2017/1/23.
 */

function toggleProgress(show) {

    var progress = $(".progress");
    var submitbtn = $("#submitbtn");
    var resetbtn = $("#resetbtn");
    
    if(show){
        progress.show();
        submitbtn.html("上传中...");
        submitbtn.attr("disabled", true);
        resetbtn.attr("disabled", true);
    }else{
        progress.hide();
        submitbtn.html("提交");
        submitbtn.attr("disabled", false);
        resetbtn.attr("disabled", false);
    }
    
}

function ajaxfile(who, refreshparent, requirefile) {
    //没有文件按照正常方式提交
    if($("input[type='file']")[0].files.length == 0){
        if(requirefile){
            alert("请选择一个资源");
            return;
        }
        ajaxsubmit(who, refreshparent, false, false);
        return;
    }
    
    var bar = $('.bar');
    var percent = $('.percent');
    
    var currentform = $(who.form);
    currentform.ajaxSubmit({
        resetForm : true,
        
        beforeSend: function(xhr) {
            
            var filesize = $("input[type='file']")[0].files[0].size/1024/1024;
            if(filesize > 50){
                alert("文件大小超过限制，最多50M");
                xhr.abort();
                return false;
            }

            toggleProgress(true);
            var percentVal = '0%';
            bar.width(percentVal);
            percent.html(percentVal);
        },

        uploadProgress: function(event, position, total, percentComplete) {
            var percentVal = percentComplete + '%';
            bar.width(percentVal);
            percent.html(percentVal);
        },
        error: function(data) {
            alert("处理出错");
            toggleProgress(false);
            
        },
        success: function(data) {
            if(data == "" || data == "ok"){
                alert("操作成功");
                if(refreshparent)
                    window.open("/pages/home.jsp", "_parent");
            }else{
                alert(data);
            }
            toggleProgress(false);
        }
    });
}

function ajaxsubmit(who, refreshparent, refreshself, resetform) {
    var currentform = $(who.form);
    currentform.ajaxSubmit({
        resetForm : resetform,
        error: function(data) {
            alert("处理出错");
        },
        success: function(data) {
            if(data == "" || data == "ok"){
                alert("操作成功");
                if(refreshparent)
                    window.open("/pages/home.jsp", "_parent");
                else if(refreshself)
                    location.reload();
            }else{
                alert(data);
            }
        }
    });
}


function ajaxurl(url, feedback, refreshparent, refreshself) {
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
                else if(refreshself)
                    location.reload();
            }else{
                alert(data);
            }
        }
    });
}

var currentlist = $("#profileli");
var listclick = function(){
    if($(this).is(currentlist))
        return;
    $(this).addClass("active");
    currentlist.removeClass("active");
    currentlist = $(this);
};
$("#profileli").click(listclick);
$("#sourceli").click(listclick);
$("#classli").click(listclick);
$("#classopli").click(listclick);
$("#msgli").click(listclick);