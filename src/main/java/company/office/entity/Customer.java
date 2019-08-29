package company.office.entity;

import java.util.Date;

/**
 * customer表，对应数据库里面同名的表，数据库不分大小写写
 * @author 吴应平
 *
 */
public class Customer {
	
	//顾客账号，也是ID
	private long customerId;
	//顾客名称
	private String customerName;
	//登陆密码
	private String customerPassword;
	//顾客性别
	private String customergender;
	//顾客生日
	private Date customerBirthday;
	//顾客手机
	private String customerPhone;
	//顾客收货信息
	private HarvestInfo harvestInfo;
	public long getCustomerId() {
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
	public String getCustomergender() {
		return customergender;
	}
	public void setCustomergender(String customergender) {
		this.customergender = customergender;
	}
	public Date getCustomerBirthday() {
		return customerBirthday;
	}
	public void setCustomerBirthday(Date customerBirthday) {
		this.customerBirthday = customerBirthday;
	}
	public String getCustomerPhone() {
		return customerPhone;
	}
	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}
	public HarvestInfo getHarvestInfo() {
		return harvestInfo;
	}
	public void setHarvestInfo(HarvestInfo harvestInfo) {
		this.harvestInfo = harvestInfo;
	}
	
	/**
	 * 无参构造
	 */
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 *  全参构造器
	 * @param customerId 顾客ID
	 * @param customerName 顾客姓名
	 * @param customerPassword 顾客登陆密码
	 * @param customergender 顾客行吧
	 * @param customerBirthday 顾客生日
	 * @param customerPhone 顾客电话
	 * @param harvestInfo  顾客收货信息
	 */
	public Customer(long customerId, String customerName, String customerPassword, String customergender,
			Date customerBirthday, String customerPhone, HarvestInfo harvestInfo) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerPassword = customerPassword;
		this.customergender = customergender;
		this.customerBirthday = customerBirthday;
		this.customerPhone = customerPhone;
		this.harvestInfo = harvestInfo;
	}
	
	
	

}
