$(document).ready(function(){

	$("#contraste").click(function(){
		$('#acessibilidadeCss').attr('href', 'contraste.css');
	});

	$("#semcontraste").click(function(){
		$('#acessibilidadeCss').attr('href', 'estilo.css');
	});
	
});