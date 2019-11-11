package company.office.dao;

import java.sql.Date;
import java.util.List;
import org.apache.ibatis.annotations.*;
import company.office.entity.Customer;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 * dao曾的数据操作框架使用的是mybtis,dao曾使用Mapper而不是Reposity
 * @author  吴应平
 *
 */
@Component
@Mapper
public interface CustomerMapper {

	/**
	 * 创建表
	 */
	void createIfNotExistsTable();
	/**
	 * 删除表，清空表内容
	 */
	/*@Update("TRUNCATE TABLE customer")*/
	void truncateTable();

	/**
	 * 增加信息，按照顾客对象来增加
	 * 
	 * @param customer 顾客对象
	 * @return customerId 返回顾客ID
	 */
	/*@Insert("INSERT INTO customer ( customer_name,customer_password, customer_birthday,"
			+ " customer_gender,customer_phone )  VALUES ( #{customerName}, #{customerPassword}, " +
			"#{customerBirthday}, #{customerGender}, #{customerPhone}) ")
	@Options(useGeneratedKeys = true, keyProperty = "customer.customerId")*/
	 Long insert(Customer customer);

	/**
	 * 更新信息，按照顾客对象来修改
	 * 
	 * @param customer 顾客对象
	 */
	/*@Update("UPDATE Customer SET " +
			"customer_name=#{customerName}, customer_birthday=#{customerBirthday}, " +
			"customer_password=#{customerPassword}, " +
			"customer_gender=#{customerGender}, customer_phone=#{customerPhone} " +
			"WHERE customer_Id=#{customerId}")*/
	 void update(Customer customer);

	/**
	 * 删除信息，按照顾客ID来删除
	 * @param customerId 顾客ID
	 */
	/*@Delete("DELETE FORM customer WHERE  customer_id=#{customerId}")*/
	 void delete(@Param("customerId") Long customerId);

	/**
	 * 查询所有的客户
	 * @return 返回顾客列表
	 */
	/*@Select("SELECT * FROM  customer")
	@Results({ @Result(property = "customerId", column = "customer_id", javaType = Long.class),
			   @Result(property = "customerName", column = "customer_name") ,
			   @Result(property = "customerGender", column = "customer_gender") ,
			   @Result(property = "customerPassword", column = "customer_password") ,
               @Result(property = "customerBirthday", column = "customer_birthday",javaType = Date.class) ,
			   @Result(property = "customerPhone", column = "customer_phone") })*/
	 List<Customer> selectAll();

	/**
	 * 删除表，直接从数据库移除该表
	 */
	/*@Update("DROP TABLE IF EXISTS customer")*/
	 void dropTable();

	/**
	 * 查询所有的客户
	 * @return 返回顾客列表
	 */
	/*@Select("SELECT * FROM customer WHERE customer_id=#{customerId}")
	@Results({ @Result(property = "customerId", column = "customer_id", javaType = Long.class),
			   @Result(property = "customerName", column = "customer_name") ,
			   @Result(property = "customerGender", column = "customer_gender") ,
			   @Result(property = "customerPassword", column = "customer_password") ,
			   @Result(property = "customerBirthday", column = "customer_birthday",javaType = Date.class) ,
			   @Result(property = "customerPhone", column = "customer_phone") })*/
	Customer selectOne(Long customerId);
}
