$(document).ready(function(){


 
    // Obtener referencia a formulario y botones
    
    var proveForm = document.querySelector('#proveForm');
    const botones = document.querySelectorAll(".botons");
    
    var inputNitProveedor = document.querySelector('#nitProveedor');
    var inputCiudadProveedor = document.querySelector('#ciudadProveedor');
    var inputDireccionProveedor = document.querySelector('#direccionProveedor');
    var inputNombreProveedor = document.querySelector('#nombreProveedor');
    var inputTelefonoProveedor = document.querySelector('#telefonoProveedor');
    var tablevisibility = document.querySelector('#tabla');
    
    
    // Definir función y evitar definirla de manera anónima
    const cuandoSeHaceClick = function (evento) {
        globalThis.btn_aceptar = document.querySelector('#btn_aceptar');
        inputNitProveedor.style.visibility = "hidden";
        inputNitProveedor.value = "0";
        inputCiudadProveedor.style.visibility = "hidden";
        inputCiudadProveedor.value = "0";
        inputDireccionProveedor.style.visibility = "hidden";
        inputDireccionProveedor.value = "0";
        inputNombreProveedor.style.visibility = "hidden";
        inputNombreProveedor.value = "null";
        inputTelefonoProveedor.style.visibility = "hidden";
        inputTelefonoProveedor.value = "0";
        tablevisibility.style.visibility = "hidden";
        
        btn_aceptar.style.visibility = "hidden";
        btn_aceptar.value = "";
    
        // Asign etiqueta y valor al boton aceptar segun operacion realizada
        switch(this.id){
            
            case "btn_borrar":
                  btn_aceptar.value = "Borrar";
            
            case "btn_consultar":
                  inputNitProveedor.style.visibility = "visible";
                  inputNitProveedor.value = "";
                  btn_aceptar.style.visibility = "visible";
                  if(btn_aceptar.value == ""){
                    btn_aceptar.value = "Consultar";
                    }
                    
                  
                  break;
    
            case "btn_crear":	
                  btn_aceptar.value = "Crear";
                  
    
            case "btn_actualizar":
                inputNitProveedor.style.visibility = "visible";
                inputNitProveedor.value = "";
                inputCiudadProveedor.style.visibility = "visible";
                inputCiudadProveedor.value = "";
                inputDireccionProveedor.style.visibility = "visible";
                inputDireccionProveedor.value = "";			
                inputNombreProveedor.style.visibility = "visible";
                inputNombreProveedor.value = "";
                inputTelefonoProveedor.style.visibility = "visible";
                inputTelefonoProveedor.value = "";
        
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