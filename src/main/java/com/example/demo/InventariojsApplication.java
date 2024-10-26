package com.example.demo;

import org.apache.catalina.User;
import org.apache.ibatis.type.MappedTypes;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MappedTypes(User.class)

@MapperScan("com.example.demo.accesoDatos")  // Asegúrate de que el paquete coincida con la ubicación de tus mappers
@MapperScan("com.example.demo.util.accesoDatos")  // Asegúrate de que el paquete coincida con la ubicación de tus mappers

public class InventariojsApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(InventariojsApplication.class, args);
	}

}
