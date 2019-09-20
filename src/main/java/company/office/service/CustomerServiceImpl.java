package company.office.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import company.office.entity.Customer;
import company.office.dao.CustomerMapper;

/**
 * Customer的service曾的实现类
 * @author 吴应平
 */
@Service
public class CustomerServiceImpl implements CustomerService {
	
	
	@Autowired
	private CustomerMapper customerMapper;

	@Override
	public void createIfNotExistsTable() {
		
		customerMapper.createIfNotExistsTable();
	}

	@Override
	public void truncateTable() {
        // TODO Auto-generated method stub
		customerMapper.truncateTable();
	}

	@Override
	public Long insert(Customer customer) {
		// TODO Auto-generated method stub
		return customerMapper.insert(customer);
	}

	@Override
	public void delete(Long customerId) {
		// TODO Auto-generated method stub
		customerMapper.delete(customerId);
	}

	@Override
	public List<Customer> selectAll() {
		// TODO Auto-generated method stub
		return customerMapper.selectAll();
	}

	@Override
	public void dropTable() {
		// TODO Auto-generated method stub
		customerMapper.dropTable();
	}

	@Override
	public void update(Customer customer) {
		customerMapper.update(customer);
	}

	@Override
	public Customer selectOne(Long Id) {
		return customerMapper.selectOne(Id);
	}

}
