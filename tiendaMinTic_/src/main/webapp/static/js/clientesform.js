$(document).ready(function(){


 
	// Obtener referencia a formulario y botones
	
	var clientesForm = document.querySelector('#clienteForm');
	const botones = document.querySelectorAll(".botons");
	
	var inputCedula = document.querySelector('#cedulaCliente');
	var inputNombreCompleto = document.querySelector('#nombreCompleto');
	var inputDireccionCliente = document.querySelector('#direccion');
	var inputTelefonoCliente = document.querySelector('#telefono');
	var inputCorreoCliente = document.querySelector('#correoElectronico');
	var tablevisibility = document.querySelector('#tabla');
	
	
	// Definir función y evitar definirla de manera anónima
	const cuandoSeHaceClick = function (evento) {
		
		globalThis.btn_aceptar = document.querySelector('#btn_aceptar');
		inputCedula.style.visibility = "hidden";
		inputCedula.value = "0";
		inputNombreCompleto.style.visibility = "hidden";
		inputNombreCompleto.value = "0";
		inputDireccionCliente.style.visibility = "hidden";
		inputDireccionCliente.value = "0";
		inputTelefonoCliente.style.visibility = "hidden";
		inputTelefonoCliente.value = "0";
		inputCorreoCliente.style.visibility = "hidden";
		inputCorreoCliente.value = "0";
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
				inputNombreCompleto.style.visibility = "visible";
				inputNombreCompleto.value = "";
				inputDireccionCliente.style.visibility = "visible";
				inputDireccionCliente.value = "";
				inputTelefonoCliente.style.visibility = "visible";
				inputTelefonoCliente.value = "";
				inputCorreoCliente.style.visibility = "visible";
				inputCorreoCliente.value = "";
		
			   
					
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