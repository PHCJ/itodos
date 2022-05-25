$(document).ready(function(){

    var fonte = 16;

    $('#aumenta').click(function(){
        if (fonte<20){
            fonte = fonte + 1;
            $('body').css({'font-size': fonte + 'px'});
        }
     });

    $('#diminui').click(function(){
        if(fonte>16){
            fonte = fonte - 1;
            $('body').css({'font-size': fonte + 'px'});
        }
    });    

});
