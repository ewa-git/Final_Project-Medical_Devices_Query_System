$(function () {
    var logo = $('#logo');
     var formSection = $('#loginForm');
     var error = $('.notification .delete');
    
    formSection.hide();
    logo.on('click', function(){
        formSection.slideToggle('slow');
    });

    (document.querySelectorAll('.notification .delete') || []).forEach(($delete) => {
        $notification = $delete.parentNode;

        $delete.addEventListener('click', () => {
            $notification.parentNode.removeChild($notification);
        });
    });

});
