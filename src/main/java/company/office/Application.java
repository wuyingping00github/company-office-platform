package company.office;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;


@MapperScan("company.office.mapper")
@ComponentScan(basePackages =  {"company.office.entity","company.office.control","company.office.service","company.office.mapper"})
@EnableAutoConfiguration
@EntityScan("company.office.entity")
public class Application {

	public static void main(String[] args) {

		SpringApplication.run(Application.class,args);

	}

}
