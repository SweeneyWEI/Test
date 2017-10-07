$(function() {
    $(".cf_listATitle").on("click", function() {
        $(this).next().toggle(1000, function() {
            console.log($(this).prev().find("i").text());
            if ($(this).prev().find("i").text() == "-") {
                $(this).prev().find("i").text("+");
            } else {
                $(this).prev().find("i").text("-");
            }
        });
    }); // 左侧导航 商品分类 点击隐藏 or 显示
})