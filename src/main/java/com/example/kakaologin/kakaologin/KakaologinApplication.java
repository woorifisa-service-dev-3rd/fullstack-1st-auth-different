package com.example.kakaologin.kakaologin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class KakaologinApplication {

	public static void main(String[] args) {
		SpringApplication.run(KakaologinApplication.class, args);
	}

}
