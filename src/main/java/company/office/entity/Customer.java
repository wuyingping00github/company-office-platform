package company.office.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;

/**
 * customer表，对应数据库里面同名的表，数据库不分大小写写
 * 
 * @author 吴应平
 */
public class Customer {

	// 顾客账号，也是ID
	private Long customerId;
	// 顾客名称
	private String customerName;
	// 登陆密码
	private String customerPassword;
	// 顾客性别
	private String customerGender;
	// 顾客生日
	private Date customerBirthday;
	// 顾客手机
	private Long customerPhone;
	// 顾客收货信息,一个顾客有多个收货信息
	private List<HarvestInfo> harvestList;

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerPassword() {
		return customerPassword;
	}

	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}

	public String getCustomerGender() {
		return customerGender;
	}

	public void setCustomerGender(String customerGender) {
		this.customerGender = customerGender;
	}

	public Date getCustomerBirthday() {
		return customerBirthday;
	}

	public void setCustomerBirthday(Date customerBirthday) {
		this.customerBirthday = customerBirthday;
	}

	public Long getCustomerPhone(Long customerPhone) {
		return customerPhone;
	}

	public void setCustomerPhone(Long customerPhone) {
		this.customerPhone = customerPhone;
	}


	/**
	 * 无参构造
	 */
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<HarvestInfo> getHarvestList() {
		return harvestList;
	}

	public void setHarvestList(List<HarvestInfo> harvestList) {
		this.harvestList = harvestList;
	}

	/**
	 * 全参构造器
	 * 
	 * @param customerId
	 *            顾客ID
	 * @param customerName
	 *            顾客姓名
	 * @param customerPassword
	 *            顾客登陆密码
	 * @param customergender
	 *            顾客性别
	 * @param customerBirthday
	 *            顾客生日
	 * @param customerPhone
	 *            顾客电话
	 * @param harvestList
	 *            顾客收货信息
	 */
	public Customer(long customerId, String customerName, String customerPassword, String customergender,
			Date customerBirthday, long customerPhone, List<HarvestInfo> harvestList) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerPassword = customerPassword;
		this.customerGender = customergender;
		this.customerBirthday = customerBirthday;
		this.customerPhone = customerPhone;
		this.harvestList = harvestList;
	}

	
	public Customer(String customerName, String customerPassword, String customergender,
			Date customerBirthday, long customerPhone){
		
		this.customerName = customerName;
		this.customerPassword = customerPassword;
		this.customerGender = customergender;
		this.customerBirthday = customerBirthday;
		this.customerPhone = customerPhone;
	}

	@Override
	public String toString() {
		return "Customer{" +
				"customerId=" + customerId +
				", customerName='" + customerName + '\'' +
				", customerPassword='" + customerPassword + '\'' +
				", customerGender='" + customerGender + '\'' +
				", customerBirthday=" + customerBirthday +
				", customerPhone=" + customerPhone +
				", harvestList=" + harvestList +
				'}';
	}
}
