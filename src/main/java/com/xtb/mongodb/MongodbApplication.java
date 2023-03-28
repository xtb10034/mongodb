package com.xtb.mongodb;

import com.xtb.mongodb.service.Service;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MongodbApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context =  SpringApplication.run(MongodbApplication.class, args);
		Service service = context.getBean(Service.class);

		try{
			service.test1();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

}
