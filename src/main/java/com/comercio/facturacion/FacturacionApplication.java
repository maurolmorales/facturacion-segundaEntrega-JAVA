package com.comercio.facturacion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FacturacionApplication {

	public static void main(String[] args) {
		try {
			SpringApplication.run(FacturacionApplication.class, args);
		}catch(Exception error){
			System.out.println(error.getMessage());
		}
	}

}
