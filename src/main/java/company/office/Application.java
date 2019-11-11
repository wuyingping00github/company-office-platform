package company.office;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootConfiguration
@MapperScan("company.office.dao")
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		//使用工厂类一样可以运行
		//new SpringApplicationBuilder(Application.class).run(args);
		SpringApplication.run(Application.class,args);

	}

}
