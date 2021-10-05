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

	public static void main(String[] args) {
		SpringApplication.run(TiendaMinTicApplication.class, args);
	}

}
