package company.office.entity;

public class HarvestInfo {
	//顾客账号，也是ID
	private long customerId;
	//收货地址
	private String HarvestAddress;
	//收获电话
	private String HarvestPhone;
	
	public long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	public String getHarvestAddress() {
		return HarvestAddress;
	}
	public void setHarvestAddress(String harvestAddress) {
		HarvestAddress = harvestAddress;
	}
	public String getHarvestPhone() {
		return HarvestPhone;
	}
	public void setHarvestPhone(String harvestPhone) {
		HarvestPhone = harvestPhone;
	}
	
	/**
	 * 有参构造器（全参构造）
	 * @param customerId 顾客账号
	 * @param harvestAddress 收获地址
	 * @param harvestPhone   收货电话
	 */
	public HarvestInfo(long customerId, String harvestAddress, String harvestPhone) {
		super();
		this.customerId = customerId;
		HarvestAddress = harvestAddress;
		HarvestPhone = harvestPhone;
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
		return "HarvestInfo [customerId=" + customerId + ", HarvestAddress=" + HarvestAddress + ", HarvestPhone="
				+ HarvestPhone + "]";
	}

	

}
