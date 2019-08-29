package company.office.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import company.office.entity.Customer;
import company.office.mapper.CustomerMapper;

/**
 * Customer的service曾的实现类
 * @author 吴应平
 *
 */
@Service
public class CustomerServiceImpl implements CustomerService {
	
	
	@Autowired
	private CustomerMapper customerMapper;

	@Override
	public void createIfNotExistsTable() {
		
		
	}

	@Override
	public void truncateTable() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Long insert(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long customerId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Customer> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void dropTable() {
		// TODO Auto-generated method stub
		
	}

}
