const inputNameP = document.getElementById('idTxtNameP');
const inputAddP = document.getElementById('btnAddProducto');

document.addEventListener("DOMContentLoaded", function(){
    console.log('Inicio Pagina')
    activeBtnAdd(1)
});

const activeBtnAdd = origin =>{
    if(inputNameP.value == "" || inputNameP.value == "No encontrado" || origin == 2) inputAddP.disabled = true;
    else inputAddP.disabled = false;
}

const validarDoc = elemento =>{
    let btn = document.getElementById('btnSearchCliente');

    if(elemento.value != ''){
        btn.disabled = false;
    } else {
        btn.disabled  = true;
    }
}

const validarProducto = elemento =>{
    let btn = document.getElementById('btnSearchProducto');

    if(elemento.value != ''){
        btn.disabled = false;
    } else {
        btn.disabled  = true;
    }
}

const valorCantidadProdcuto = elemento =>{
    const vUnidad = document.getElementById('txtValorU').value;
    let inputTotal = document.getElementById('txtValorPT');
    let total = 0.0;
    if(vUnidad == ""){
        vUnidad = 0;
    }
    total = vUnidad * elemento.value;
    inputTotal.value = total;
    if(elemento.value > 0) activeBtnAdd(1);
    else  activeBtnAdd(2);
    

}