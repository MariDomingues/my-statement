package br.com.mystatement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MyStatementApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyStatementApplication.class, args);
	}
}
