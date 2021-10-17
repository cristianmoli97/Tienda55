package com.tiendaMinTic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@ComponentScan({"com.tiendaMinTic","com.tiendaMinTicDao"})
@EntityScan("com.tiendaMinTicDto")
public class TiendaMinTicApplication {

	public static class GlobalUserName{
	    public static String userLoginx = "nada";

	    public static String getUserLoginx(){
	        return GlobalUserName.userLoginx;
	    }


	    public static void setUserLoginx(String userloginx){
	    	GlobalUserName.userLoginx = userloginx;

	    }
	}

	public static void main(String[] args) {
		SpringApplication.run(TiendaMinTicApplication.class, args);
	}

}
