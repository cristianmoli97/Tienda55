$(document).ready(function(){
$(".upload_btn").click(function(event){
     $(".upload_file").click();
     event.preventDefault();

});

document.getElementById("IdSelArchivo").onchange = function(e) {
	var x = document.getElementById("IdArchivo");
    x.setAttribute("placeholder", this.value);
}

'use strict';

var FormProdu = document.querySelector('#FormProdu');
var IdSelArchivo = document.querySelector('#IdSelArchivo');
var singleFileUploadError = document.querySelector('#singleFileUploadError');
var singleFileUploadSuccess = document.querySelector('#singleFileUploadSuccess');


function uploadSingleFile(file) {
    var formData = new FormData();
    formData.append("file", file);

    var xhr = new XMLHttpRequest();
    xhr.open("POST", "/jsp/productos.jsp/UploadProductos");

    xhr.onload = function() {
        console.log(xhr.responseText);
        var response = JSON.parse(xhr.responseText);
        if(xhr.status == 200) {
            singleFileUploadError.style.display = "none";
            singleFileUploadSuccess.innerHTML = response.message;
            singleFileUploadSuccess.style.display = "block";
        } else {
            singleFileUploadSuccess.style.display = "none";
            singleFileUploadError.innerHTML = response.message;
            singleFileUploadSuccess.style.display = "block";

        }
    }

    xhr.send(formData);
}

FormProdu.addEventListener('submit', function(event){
    var files = IdSelArchivo.files;
    if(files.length === 0) {
        singleFileUploadError.innerHTML = "Seleccione un archivo";
        singleFileUploadError.style.display = "block";
    }
    uploadSingleFile(files[0]);
    event.preventDefault();
}, true);

});

