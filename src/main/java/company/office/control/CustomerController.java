package company.office.control;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import company.office.entity.Customer;
import company.office.service.CustomerService;



@RestController
@SpringBootApplication
public class CustomerController {

	@Autowired
	 private CustomerService  customerService;
	
	@ResponseBody
	@RequestMapping("getCustomer")
	public String getCustomer() {
		customerService.createIfNotExistsTable();
		return "success";
	}
	
	@ResponseBody
	@RequestMapping("addCustomer")
	public String addCustomer() {
		Customer customer = new Customer("customerName", "customerPassword", "customergender",
				new Date(), 15207104346L);
		customerService.insert(customer);
		return "success";
	}
	
	@ResponseBody
	@RequestMapping("deleteCustomer")
	public String deleteCustomer() {
		Customer customer = new Customer();
		customer.setCustomerId(15207104346L);
		customerService.delete(customer.getCustomerId());
		return "success";
	}
}
