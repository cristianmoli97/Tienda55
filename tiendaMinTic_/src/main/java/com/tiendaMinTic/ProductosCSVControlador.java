package com.tiendaMinTic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.tiendaMinTic.CSV.Servicios.ServicioUploadCSV;
import com.tiendaMinTicDto.MensajeTienda;

/**
 * 
 * @author ledyn roman moreno castellanso
 *
 */
@RestController
public class ProductosCSVControlador {
	
	// Interfaz cargar archivo csv
	@GetMapping(value = {"/producto"})
	public ModelAndView prodcsv(Model model){
		ModelAndView mav = new ModelAndView();
		String userloginInUse = TiendaMinTicApplication.usernameLoginx; //accede al ususario ingresado en login

	    if(userloginInUse.equals("nada")) {

			 mav.setViewName("redirect:login");
		}else {

		     mav.setViewName("productos");
		}
		
		return mav;

	}
			
	@Autowired
	ServicioUploadCSV uploadFileCsv;
	
	@PostMapping("/UploadProductos")
	  public ResponseEntity<MensajeTienda> uploadFile(@RequestParam("file") MultipartFile file) {

	    String message = "Error: no se seleccionó archivo para cargar";
	    

	    String TYPE = "application/vnd.ms-excel";

	    if (TYPE.equals(file.getContentType())) {

	      try {
	    	  if(uploadFileCsv.save(file)) {
	    		  message = "Archivo Cargado exitosamente: " + file.getOriginalFilename();
	  	          return ResponseEntity.status(HttpStatus.OK).body(new MensajeTienda(message));
	    	  }
	    	  
	       
	      } catch (Exception e) {
	        message = "Archivo no cargado: " + file.getOriginalFilename() + "!";
	        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new MensajeTienda(message));
	      }
	    }

	    message = "Error: formato de archivo inválido!";
	    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new MensajeTienda(message));
	  }
	

}
