//局部刷新
$(function(){
    setInterval("notsum()",1000);
});

function notsum() {

    //总条数
    var sum ;
    $.ajax({
        type: "get",
        url: "/system/notice/waring/number",
        dataType: "json",
        async: false,
        success: function (result) {
            sum =result;

            document.getElementById("flicker").innerHTML = parseInt(sum);


        },

    })
};