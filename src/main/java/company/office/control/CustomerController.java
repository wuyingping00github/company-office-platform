package company.office.control;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.JSONArray;
import company.office.entity.HarvestInfo;
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
	private CustomerService customerService;
	
	@ResponseBody
	@RequestMapping("getCustomer")
	public String getCustomer() {
		customerService.createIfNotExistsTable();
		return "success";
	}
	
	@ResponseBody
	@RequestMapping("addCustomer")
	public String addCustomer(){
		Customer customer = new Customer("customerName", "customerPassword", "男",
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

	@ResponseBody
	@RequestMapping("showCustomer")
	public String showCustomer() {
		Customer customer = new Customer();
		customer.setCustomerId(15207104346L);
		customer.setCustomerBirthday(new Date());
		customer.setCustomerGender("男");
		customer.setCustomerName("铁男");
		customer.setCustomerPassword("123456");
		customer.getCustomerPhone(15207104346L);
		HarvestInfo harvestInfo=new HarvestInfo(1520710,15207104346L,"武汉","15207104346");
		List list = new ArrayList();
		list.add(harvestInfo);
		customer.setHarvestList(list);
		String json =JSONArray.toJSONString(customer);

		return json;
	}
}
