package company.office.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import company.office.entity.Customer;

/**
 * dao曾的数据操作框架使用的是mybtis,dao曾使用Mapper而不是Reposity
 * @author Shinelon
 *
 */
@Mapper
public interface CustomerMapper {
	

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
     * @param customer
     * @return
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
    
    /*
     * 删除表，直接从数据库移除该表
     */
    void dropTable();

}
