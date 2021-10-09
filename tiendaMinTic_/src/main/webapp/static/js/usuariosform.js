$(document).ready(function(){


 
// Obtener referencia a formulario y botones

var usuariosForm = document.querySelector('#usuariosForm');
const botones = document.querySelectorAll(".botons");

var inputCedula = document.querySelector('#cedula');
var inputUsuario = document.querySelector('#usuario');
var inputPasswordUsuario = document.querySelector('#passaword');
var inputNombreUsuario = document.querySelector('#nombreUsuario');
var inputEmailUsuario = document.querySelector('#emailUsuario');
var tablevisibility = document.querySelector('#tabla');


// Definir función y evitar definirla de manera anónima
const cuandoSeHaceClick = function (evento) {
	globalThis.btn_aceptar = document.querySelector('#btn_aceptar');
	inputCedula.style.visibility = "hidden";
	inputCedula.value = "0";
	inputUsuario.style.visibility = "hidden";
	inputUsuario.value = "0";
	inputPasswordUsuario.style.visibility = "hidden";
	inputPasswordUsuario.value = "0";
	inputNombreUsuario.style.visibility = "hidden";
	inputNombreUsuario.value = "null";
	inputEmailUsuario.style.visibility = "hidden";
	inputEmailUsuario.value = "0";
	tablevisibility.style.visibility = "hidden";
	
	btn_aceptar.style.visibility = "hidden";
	btn_aceptar.value = "";

	// Asign etiqueta y valor al boton aceptar segun operacion realizada
	switch(this.id){
		
		case "btn_borrar":
		      btn_aceptar.value = "Borrar";
		
		case "btn_consultar":
		      inputCedula.style.visibility = "visible";
			  inputCedula.value = "";
	          btn_aceptar.style.visibility = "visible";
              if(btn_aceptar.value == ""){
				btn_aceptar.value = "Consultar";
				}
				
			  
              break;

		case "btn_crear":	
		      btn_aceptar.value = "Crear";
              

		case "btn_actualizar":
		    inputCedula.style.visibility = "visible";
			inputCedula.value = "";
			inputUsuario.style.visibility = "visible";
			inputUsuario.value = "";
			inputPasswordUsuario.style.visibility = "visible";
			inputPasswordUsuario.value = "";			
			inputNombreUsuario.style.visibility = "visible";
			inputNombreUsuario.value = "";
			inputEmailUsuario.style.visibility = "visible";
			inputEmailUsuario.value = "";
				
			btn_aceptar.style.visibility = "visible";
			if(btn_aceptar.value == ""){
				btn_aceptar.value = "Actualizar";
				}
		
			
		default:
			break;	
	}
	
	

 }

// botones es un arreglo así que lo recorremos
botones.forEach(boton => {
	//Agregar listener
	boton.addEventListener("click", cuandoSeHaceClick);
});





});/**
 * 
 */