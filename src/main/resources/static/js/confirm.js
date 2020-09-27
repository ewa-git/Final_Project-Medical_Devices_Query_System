$(function () {
    $(".popup").click(function (e) {
        e.preventDefault();
        var idOkna = $(this).attr("data-windowId");
        $(idOkna).fadeIn("fast");
        $(idOkna).find("#close").click(function () {
            $(idOkna).fadeOut("fast");
        });
    });
});

