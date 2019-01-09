$(function () {
    setInterval("get_log()",2000);
});

function get_log() {
    var log1 = document.getElementById("log1");
    var log2 = document.getElementById("log2");
    var log3 = document.getElementById("log3");
    var log4 = document.getElementById("log4");
    $.get("/cmcc/get_log.do").done(function (data) {
        log1.innerHTML=data.data1;
        log2.innerHTML=data.data2;
        log3.innerHTML=data.data3;
        log4.innerHTML=data.data4;
    })
}