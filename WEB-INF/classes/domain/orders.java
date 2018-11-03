package domain;

public class orders {
	private int orderID;
	private int orderdetailID;
	private int userID;
	private String consignName;
	private String consigneeAddress;
	private String consigneePhone;
	private String payway;
	private String orderDate;
	private String orderstatus;
	private String orderNo;
	private float totalprice;
	public orders() {};
	
	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public float getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(float totalprice) {
		this.totalprice = totalprice;
	}

	public int getOrderID() {
		return orderID;
	}
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	public int getOrderdetailID() {
		return orderdetailID;
	}
	public void setOrderdetailID(int orderdetailID) {
		this.orderdetailID = orderdetailID;
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
	public String getConsigneeAddress() {
		return consigneeAddress;
	}
	public void setConsigneeAddress(String consigneeAddress) {
		this.consigneeAddress = consigneeAddress;
	}
	public String getConsigneePhone() {
		return consigneePhone;
	}
	public void setConsigneePhone(String consigneePhone) {
		this.consigneePhone = consigneePhone;
	}
	public String getPayway() {
		return payway;
	}
	public void setPayway(String payway) {
		this.payway = payway;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public String getOrderstatus() {
		return orderstatus;
	}
	public void setOrderstatus(String orderstatus) {
		this.orderstatus = orderstatus;
	}
	@Override
	public String toString() {
		return "orders [orderID=" + orderID + ", orderdetailID=" + orderdetailID + ", userID=" + userID
				+ ", consignName=" + consignName + ", consigneeAddress=" + consigneeAddress + ", consigneePhone="
				+ consigneePhone + ", payway=" + payway + ", orderNo=" + orderNo + ", orderDate=" + orderDate+ ", totalprice=" + totalprice + ", orderstatus=" + orderstatus
				+ "]";
	}
	public orders(int orderID, int orderdetailID, int userID, String consignName, String consigneeAddress,
			String consigneePhone, String payway, String orderDate, String orderstatus,float totalprice,String orderNo) {
		super();
		this.orderID = orderID;
		this.orderdetailID = orderdetailID;
		this.userID = userID;
		this.consignName = consignName;
		this.consigneeAddress = consigneeAddress;
		this.consigneePhone = consigneePhone;
		this.payway = payway;
		this.orderDate = orderDate;
		this.orderstatus = orderstatus;
		this.totalprice = totalprice;
		this.orderNo = orderNo;
	}
	
}
