package domain;

public class orderdetail {
	private int orderdetailID;
	private float gtotalPrice;
	private int userID;
	private int goodsCount;
	private String orderNo;
	private int goodsID;
	private String goodsName;
	private String goodsImg;
	private float goodsPrice;
	private String gclass;
	public orderdetail(){}
	public int getOrderdetailID() {
		return orderdetailID;
	}
	public void setOrderdetailID(int orderdetailID) {
		this.orderdetailID = orderdetailID;
	}
	public float getGtotalPrice() {
		return gtotalPrice;
	}
	public void setGtotalPrice(float gtotalPrice) {
		this.gtotalPrice = gtotalPrice;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public int getGoodsCount() {
		return goodsCount;
	}
	public void setGoodsCount(int goodsCount) {
		this.goodsCount = goodsCount;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public int getGoodsID() {
		return goodsID;
	}
	public void setGoodsID(int goodsID) {
		this.goodsID = goodsID;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public String getGoodsImg() {
		return goodsImg;
	}
	public void setGoodsImg(String goodsImg) {
		this.goodsImg = goodsImg;
	}
	public float getGoodsPrice() {
		return goodsPrice;
	}
	public void setGoodsPrice(float goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	public String getGclass() {
		return gclass;
	}
	public void setGclass(String gclass) {
		this.gclass = gclass;
	}
	@Override
	public String toString() {
		return "orderdetail [orderdetailID=" + orderdetailID + ", gtotalPrice=" + gtotalPrice + ", userID=" + userID
				+ ", goodsCount=" + goodsCount + ", orderNo=" + orderNo + ", goodsID=" + goodsID + ", goodsName="
				+ goodsName + ", goodsImg=" + goodsImg + ", goodsPrice=" + goodsPrice + ", gclass=" + gclass + "]";
	}
	public orderdetail(int orderdetailID, float gtotalPrice, int userID, int goodsCount, String orderNo, int goodsID,
			String goodsName, String goodsImg, float goodsPrice, String gclass) {
		super();
		this.orderdetailID = orderdetailID;
		this.gtotalPrice = gtotalPrice;
		this.userID = userID;
		this.goodsCount = goodsCount;
		this.orderNo = orderNo;
		this.goodsID = goodsID;
		this.goodsName = goodsName;
		this.goodsImg = goodsImg;
		this.goodsPrice = goodsPrice;
		this.gclass = gclass;
	};
	
}
