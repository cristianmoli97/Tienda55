$(document).ready(function(){


 
    // Obtener referencia a formulario y botones
    
    var produForm = document.querySelector('#produForm');
    const botones = document.querySelectorAll(".botons");
    
    var inputCodigoProducto = document.querySelector('#codigoProducto');
    var inputIvaCompra = document.querySelector('#ivaCompra');
    var inputNitProveedor = document.querySelector('#nitProveedor');
    var inputNombreProducto = document.querySelector('#nombreProducto');
    var inputPrecioCompra = document.querySelector('#precioCompra');
    var inputPrecioVenta = document.querySelector('#precioVenta');
    
    
    
    // Definir función y evitar definirla de manera anónima
    const cuandoSeHaceClick = function (evento) {
        globalThis.btn_aceptar = document.querySelector('#btn_aceptar');
        inputCodigoProducto.style.visibility = "hidden";
        inputCodigoProducto.value = "0";
        inputIvaCompra.style.visibility = "hidden";
        inputIvaCompra.value = "0";
        inputNitProveedor.style.visibility = "hidden";
        inputNitProveedor.value = "0";
        inputNombreProducto.style.visibility = "hidden";
        inputNombreProducto.value = "null";
        inputPrecioCompra.style.visibility = "hidden";
        inputPrecioCompra.value = "0";
        inputPrecioVenta.style.visibility = "hidden";
        inputPrecioVenta.value = "0";
        
        btn_aceptar.style.visibility = "hidden";
        btn_aceptar.value = "";
    
        // Asign etiqueta y valor al boton aceptar segun operacion realizada
        switch(this.id){
            
            case "btn_borrar":
                  btn_aceptar.value = "Borrar";
            
            case "btn_consultar":
                  inputCodigoProducto.style.visibility = "visible";
                  inputCodigoProducto.value = "";
                  btn_aceptar.style.visibility = "visible";
                  if(btn_aceptar.value == ""){
                    btn_aceptar.value = "Consultar";
                    }
                    
                  
                  break;
    
            case "btn_crear":	
                  btn_aceptar.value = "Crear";
                  
    
            case "btn_actualizar":
                inputCodigoProducto.style.visibility = "visible";
                inputCodigoProducto.value = "";
                inputIvaCompra.style.visibility = "visible";
                inputIvaCompra.value = "";
                inputNitProveedor.style.visibility = "visible";
                inputNitProveedor.value = "";			
                inputNombreProducto.style.visibility = "visible";
                inputNombreProducto.value = "";
                inputPrecioCompra.style.visibility = "visible";
                inputPrecioCompra.value = "";
                inputPrecioVenta.style.visibility = "visible";
                inputPrecioVenta.value = "";
        
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