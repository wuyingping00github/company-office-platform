package company.office.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import company.office.service.CustomerService;


@RestController
@SpringBootApplication
public class CustomerController {

	@Autowired
	 private CustomerService customerService;
	
	@ResponseBody
	@RequestMapping("getCustomer")
	public String getCustomer() {
		customerService.createIfNotExistsTable();
		return "Hello World!-------success";
	}

}
