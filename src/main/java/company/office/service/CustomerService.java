package company.office.service;

import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import company.office.entity.Customer;

/**
 * Customer的service曾的接口，方法的定义
 * @author 吴应平
 *
 */
@Service
@ComponentScan
public interface CustomerService {
	

	/**
	 * 创建表
	 */
    void createIfNotExistsTable();
    
    /**
     * 删除表，清空表内容
     */
    void truncateTable();
    
    /**
     * 增加信息，按照顾客对象来增加
     * @param customer 客户对象
     * @return 返回主键
     */
    Long insert(Customer customer);
    
    /**
     * 删除信息，按照顾客ID来删除
     * @param customerId
     */
    void delete(Long customerId);
    
    /**
     * 查询所有的客户
     * @return 返回顾客列表
     */
    List<Customer> selectAll();
    
    /**
     * 删除表，直接从数据库移除该表
     */
    void dropTable();

    /**
     * 更新客户信息
     * @return void
     */
   void update(Customer customer);

    /**
     * 查询所有的客户
     * @return 返回顾客列表
     */
     Customer selectOne(Long Id);
}
