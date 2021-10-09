$(document).ready(function(){


 
// Obtener referencia a formulario y botones

var listausuForm = document.querySelector('#listaReportes"');

var repocol1 = document.querySelector('#repocol1');
var repocol2 = document.querySelector('#repocol2');
var repocol3 = document.querySelector('#repocol3');
var repocol4 = document.querySelector('#repocol4');
var repocol5 = document.querySelector('#repocol5');
var repocol6 = document.querySelector('#repocol6');



// Definir función y evitar definirla de manera anónima
const cuandoSeHaceClick = function (evento) {
	
	tablevisibility.style.visibility = "hidden";
	repocol1.style.visibility = "hidden";
    repocol2.style.visibility = "hidden";
	repocol3.style.visibility = "hidden";
    repocol4.style.visibility = "hidden";
	repocol5.style.visibility = "hidden";
	repocol6.style.visibility = "hidden";

	// Asign etiqueta y valor al boton aceptar segun operacion realizada
	switch(this.id){
		
		case "list_usu":

		case "list_clientes":
		      repocol1.style.visibility = "visible";
			  repocol2.style.visibility = "visible";
	          repocol3.style.visibility = "visible";
              repocol4.style.visibility = "visible";
			  repocol5.style.visibility = "visible";
	          repocol6.style.visibility = "visible";
			  tablevisibility.style.visibility = "visible";
              break;

		case "List_ventas":	
		      repocol1.style.visibility = "visible";
			  repocol2.style.visibility = "visible";
	          repocol3.style.visibility = "visible";
			  repocol4.style.visibility = hidden;
	          repocol5.style.visibility = hidden;
			  repocol4.style.display=none;
	          repocol5.style.display=none;
              $('.unselectable').prop("disabled",true)

			  tablevisibility.style.visibility = "visible";
			
		default:
			break;	
	}
	
	

 }


botonsaceptar.forEach(boton => {
	//Agregar listener
	boton.addEventListener("submit", cuandoSeHaceClick);
});




});/**
 * 
 */