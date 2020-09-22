$(function () {
    var people = $('#logo');
     var formSection = $('#loginForm');
    
    formSection.hide();
    people.on('click', function(){
//        console.log("dziala");
        var formSection = $('#loginForm');
//        formSection.toggle('slow');
        formSection.slideToggle('slow');
    });

});
