$(function () {
    var status = $(".status");
    var editButton = $(this).attr("data-buttonId");
    console.log(status);
    console.log(editButton);
    status.each(function() {
        if (this.innerText === "IN_PROGRESS") {
            var button = $(this).parent().find('div a.edit');
            button.hide();
        }
    })

});
