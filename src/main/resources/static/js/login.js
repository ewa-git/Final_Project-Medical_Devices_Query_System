$(function () {
    var logo = $('#logo');
     var formSection = $('#loginForm');
    
    formSection.hide();
    logo.on('click', function(){
        formSection.slideToggle('slow');
    });

});
