package company.office.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Update;
import company.office.entity.Customer;

/**
 * dao曾的数据操作框架使用的是mybtis,dao曾使用Mapper而不是Reposity
 * 
 * @author  吴应平
 *
 */
@Mapper
public interface CustomerMapper {


	/**
	 * 创建表
	 */
	@Update("CREATE TABLE IF"+
	"NOT EXISTS"+
	"customer ( customer_id   BIGINT  AUTO_INCREMENT,"+
	"customer_name  VARCHAR(128) NOT NULL, "+
	"customer_birthday DATE  NOT NULL,"+
	"customer_password VARCHAR(128) NOT NULL,"+
	"customer_gender   VARCHAR(6)   NOT NULL,"+
	"customer_phone    BIGINT       NOT NULL,"+
	"PRIMARY KEY (customer_id)")
	void createIfNotExistsTable();

	/**
	 * 删除表，清空表内容
	 */
	void truncateTable();

	/**
	 * 增加信息，按照顾客对象来增加
	 * 
	 * @param customer
	 * @return
	 */
	@Insert("INSERT INTO customer ( customer_name,customer_password, customer_birthday,"
			+ " customer_gender,customer_phone )  VALUES ( #{customerName}, #{customerPassword}, " +
			"#{customerBirthday}, #{customerGender}, #{customerPhone}) ")
	@Options(useGeneratedKeys = true, keyProperty = "customer.customerId")
	Long insert(Customer customer);

	/**
	 * 更新信息，按照顾客对象来修改
	 * 
	 * @param customer
	 */
	void update(Customer customer);

	/**
	 * 删除信息，按照顾客ID来删除
	 * 
	 * @param customerId
	 */
	void delete(Long customerId);

	/**
	 * 查询所有的客户
	 * 
	 * @return 返回顾客列表
	 */
	List<Customer> selectAll();

	/**
	 * 删除表，直接从数据库移除该表
	 */
	void dropTable();

}
