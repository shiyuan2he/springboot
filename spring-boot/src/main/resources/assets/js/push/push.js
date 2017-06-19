push() ;
function push(){
    $.get('../push/getData',function(data) {
        console.log(data);
        push();
    });
}