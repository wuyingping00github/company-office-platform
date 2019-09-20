package company.office.control;

import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import company.office.entity.Customer;
import company.office.service.CustomerService;


//使用Restful的编程，需要在方法函数上面注明@PathVariable
@RestController
@RequestMapping("customer")
public class CustomerController {


	@Autowired
	private CustomerService customerService;
	

	@RequestMapping("create")
	public String createCustomer() {
		customerService.createIfNotExistsTable();
		return "success";
	}



	@RequestMapping("add")
	public String addCustomer(){
		Customer customer = new Customer("customerName", "customerPassword", "男",
				new Date(), 15207104346L);
		customerService.insert(customer);
		return "success";
	}
	

	@RequestMapping("delete")
	public String deleteCustomer() {
		Customer customer = new Customer();
		customer.setCustomerId(15207104346L);
		customerService.delete(customer.getCustomerId());
		return "success";
	}


	@RequestMapping("getOne/{id}")
	//使用Restful的编程，需要在方法函数上面注明@PathVariable
	public Customer getCustomer(@PathVariable("id") Long id) {
		Customer customer = customerService.selectOne(id);
		return customer;
	}


	@RequestMapping("show")
	public String showCustomer() {
		List<Customer> list = customerService.selectAll();
		String json =JSONArray.toJSONString(list);
		return json;
	}

	@RequestMapping("update/{id}")
	//使用Restful的编程，需要在方法函数上面注明@PathVariable
	public String updateCustomer(@PathVariable("id") Long id) {
		Customer customer = new Customer();
		customer.setCustomerId(id);
		customer.setCustomerBirthday(new Date());
		customer.setCustomerGender("男");
		customer.setCustomerName("铁男");
		customer.setCustomerPassword("123456");
		customer.setCustomerPhone(id);
		customerService.update(customer);
		return "success";
	}

}
