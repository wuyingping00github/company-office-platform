package company.office.entity;

/**
 * 收货地址信息表
 * @author 吴应平
 *
 */
public class HarvestInfo {
	
	//收获信息Id
	private Long harvestId;
	//顾客账号，也是ID,外键
	private Long customerId;
	//收货地址
	private String harvestAddress;
	//收获电话
	private String harvestPhone;

	
	public Long getHarvestId() {
		return harvestId;
	}
	public void setHarvestId(Long harvestId) {
		this.harvestId = harvestId;
	}
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public String getHarvestAddress() {
		return harvestAddress;
	}
	public void setHarvestAddress(String harvestAddress) {
		this.harvestAddress = harvestAddress;
	}
	public String getHarvestPhone() {
		return harvestPhone;
	}
	public void setHarvestPhone(String harvestPhone) {
		this.harvestPhone = harvestPhone;
	}
	/**
	 * 有参构造器（全参构造）
	 * @param customerId 顾客账号
	 * @param harvestAddress 收获地址
	 * @param harvestPhone   收货电话
	 */
	public HarvestInfo(Long harvestId,Long customerId, String harvestAddress, String harvestPhone) {
		super();
		this.harvestId = harvestId;
		this.customerId = customerId;
		this.harvestAddress = harvestAddress;
		this.harvestAddress = harvestPhone;
	}
	
	
	/**
	 * 无参构造器
	 */
	public HarvestInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public String toString() {
		return "HarvestInfo [harvestId=" + harvestId + ",customerId=" + customerId + ", HarvestAddress=" + harvestAddress + ", HarvestPhone="
				+ harvestPhone + "]";
	}

	

}
