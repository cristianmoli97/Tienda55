package com.tiendaMinTic;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tiendaMinTic.CSV.Servicios.ServicioAutenticar;
import com.tiendaMinTicDto.UsuariosVO;
import com.tiendaMinTicDao.ProveedoresDAO;
import com.tiendaMinTicDao.UsuariosDao;
import com.tiendaMinTicDto.ProveedoresVO;

@Controller
public class TiendaController {
	
	@GetMapping(value="/")
    public ModelAndView paginadefault(){
		ModelAndView mav = new ModelAndView("login0");
		return mav;
    }
	
	@GetMapping(value="/login")
    public ModelAndView PaginaLogin(){
		ModelAndView mav = new ModelAndView("login0");
		return mav;
    }
	
	
	@PostMapping(value="/loginform")
    public ModelAndView AcessoUsuario(@RequestParam("username") String username, @RequestParam("password") String password){
        
    	ServicioAutenticar userAutenticar = new ServicioAutenticar();
		UsuariosVO usuVO = new UsuariosVO();
		usuVO.setUsuario(username);
		usuVO.setPasswordUsuario(password);
		

        ModelAndView mav = new ModelAndView();
        if (!userAutenticar.autenticar(usuVO)) {
            mav.setViewName("redirect:login");
        }else {
        	mav.setViewName("redirect:usuarioscrud");
        }
        return mav;
    }
	

	  
	
	  
	

    
      
	}


