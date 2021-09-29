package com.tiendaMinTic;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController


public class Controlador {
	
	@RequestMapping("/hola")
	public String saludar () {
		return "hola";};
}
