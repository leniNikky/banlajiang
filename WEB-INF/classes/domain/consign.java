package domain;

public class consign {
	private int consignID;
	private int userID;
	private String consignName;
	private String consignAddress;
	private String consignPhone;
	public consign() {}
	public int getConsignID() {
		return consignID;
	}
	public void setConsignID(int consignID) {
		this.consignID = consignID;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getConsignName() {
		return consignName;
	}
	public void setConsignName(String consignName) {
		this.consignName = consignName;
	}
	public String getConsignAddress() {
		return consignAddress;
	}
	public void setConsignAddress(String consignAddress) {
		this.consignAddress = consignAddress;
	}
	public String getConsignPhone() {
		return consignPhone;
	}
	public void setConsignPhone(String consignPhone) {
		this.consignPhone = consignPhone;
	}
	@Override
	public String toString() {
		return "consign [consignID=" + consignID + ", userID=" + userID + ", consignName=" + consignName
				+ ", consignAddress=" + consignAddress + ", consignPhone=" + consignPhone + "]";
	}
	public consign(int consignID, int userID, String consignName, String consignAddress, String consignPhone) {
		super();
		this.consignID = consignID;
		this.userID = userID;
		this.consignName = consignName;
		this.consignAddress = consignAddress;
		this.consignPhone = consignPhone;
	};
	
}
