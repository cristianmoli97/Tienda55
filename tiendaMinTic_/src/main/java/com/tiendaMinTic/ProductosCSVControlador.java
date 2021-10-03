package com.tiendaMinTic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import com.tiendaMinTic.CSV.Servicios.ServicioUploadCSV;
import com.tiendaMinTicDto.MensajeTienda;

@RestController
public class ProductosCSVControlador {
	
	@Autowired
	ServicioUploadCSV uploadFileCsv;
	
	@PostMapping("/UploadProductos")
	  public ResponseEntity<MensajeTienda> uploadFile(@RequestParam("file") MultipartFile file) {
		  
	    String message = "";
	    String TYPE = "application/vnd.ms-excel";

	    if (TYPE.equals(file.getContentType())) {
	      try {
	    	  uploadFileCsv.save(file);

	        message = "Archivo Cargado: " + file.getOriginalFilename();
	        return ResponseEntity.status(HttpStatus.OK).body(new MensajeTienda(message));
	      } catch (Exception e) {
	        message = "Archivo no cargado: " + file.getOriginalFilename() + "!";
	        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new MensajeTienda(message));
	      }
	    }

	    message = "Seleccione archivo csv!";
	    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new MensajeTienda(message));
	  }
	

}
