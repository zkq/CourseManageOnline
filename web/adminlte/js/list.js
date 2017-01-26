/**
 * Created by Flyme on 2017/1/22.
 */

var currentlist = $("#profileli");
var listclick = function(){
    if($(this).is(currentlist))
        return;
    currentlist.removeClass("active");
    $(this).addClass("active");
    currentlist = $(this);
};

$("#msgli").click(listclick);
$("#profileli").click(listclick);
$("#sourceli").click(listclick);
$("#classli").click(listclick);
$("#classopli").click(listclick);