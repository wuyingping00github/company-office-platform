package company.office.control;

import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import company.office.entity.Customer;
import company.office.service.CustomerService;



@RestController
@RequestMapping("customer")
public class CustomerController {


	@Autowired
	private CustomerService customerService;
	
	@ResponseBody
	@RequestMapping("create")
	public String createCustomer() {
		customerService.createIfNotExistsTable();
		return "success";
	}
	
	@ResponseBody
	@RequestMapping("add")
	public String addCustomer(){
		Customer customer = new Customer("customerName", "customerPassword", "男",
				new Date(), 15207104346L);
		customerService.insert(customer);
		return "success";
	}
	
	@ResponseBody
	@RequestMapping("delete")
	public String deleteCustomer() {
		Customer customer = new Customer();
		customer.setCustomerId(15207104346L);
		customerService.delete(customer.getCustomerId());
		return "success";
	}

	@ResponseBody
	@RequestMapping("getOne/{id}")
	public String getCustomer(@Param("id") Long id) {
		Customer customer = customerService.selectOne(id);
		String json =JSONArray.toJSONString(customer);
		return json;
	}

	@ResponseBody
	@RequestMapping("show")
	public String showCustomer() {
		List<Customer> list = customerService.selectAll();
		String json =JSONArray.toJSONString(list);
		return json;
	}
	@ResponseBody
	@RequestMapping("update")
	public String updateCustomer() {
		Customer customer = new Customer();
		customer.setCustomerId(15207104346L);
		customer.setCustomerBirthday(new Date());
		customer.setCustomerGender("男");
		customer.setCustomerName("铁男");
		customer.setCustomerPassword("123456");
		customer.getCustomerPhone(15207104346L);
		customerService.update(customer);
		return "success";
	}

}
