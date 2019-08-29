package company.office;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@MapperScan(basePackages = {"company.office.mapper"})
@ComponentScan(basePackages = 
       {"company.office.entity",
		"company.office.control",
		"company.office.service",
		"company.office.mapper"})
public class Application {

	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);

	}

}
