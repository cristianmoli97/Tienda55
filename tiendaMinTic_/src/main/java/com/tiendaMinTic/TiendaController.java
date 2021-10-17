package com.tiendaMinTic;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.tiendaMinTic.CSV.Servicios.ServicioAutenticar;
import com.tiendaMinTicDto.UsuariosVO;


@Controller
public class TiendaController {
	
	@GetMapping(value="/")
    public ModelAndView paginadefault(){
		ModelAndView mav = new ModelAndView("login0");
		TiendaMinTicApplication.GlobalUserName.setUserLoginx("nada");
		return mav;
    }
	
	@GetMapping(value="/login")
    public ModelAndView PaginaLogin(){
		ModelAndView mav = new ModelAndView("login0");
		TiendaMinTicApplication.GlobalUserName.setUserLoginx("nada");
		return mav;
    }
	
	
	
	
	UsuariosVO usuVO = new UsuariosVO();

	@PostMapping(value="/loginform")
    public ModelAndView AcessoUsuario(@RequestParam("username") String username, @RequestParam("password") String password){
        
    	ServicioAutenticar userAutenticar = new ServicioAutenticar();
		
		usuVO.setUsuario(username);
		usuVO.setPasswordUsuario(password);
		
        ModelAndView mav = new ModelAndView();
        if (!userAutenticar.autenticar(usuVO)) {
            mav.setViewName("redirect:login");
   
        }else {
        	mav.setViewName("redirect:usuarioscrud");
        	
        	TiendaMinTicApplication.GlobalUserName.setUserLoginx(usuVO.getUsuario());
        	
        }
        return mav;
    }
	
      
	}


