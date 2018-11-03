package domain;

public class shoppingcart {
	private int shoppingcartID;
	private int userID;
	private int goodsID;
	private String goodsName;
	private String goodsImg;
	private String gclass;
	private float goodsPrice;
	private float gtotalPrice;
	private int goodsCount;
	private String date;
	public shoppingcart(){}
	public int getShoppingcartID() {
		return shoppingcartID;
	}
	public void setShoppingcartID(int shoppingcartID) {
		this.shoppingcartID = shoppingcartID;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
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
	
	public String getGclass() {
		return gclass;
	}
	public void setGclass(String gclass) {
		this.gclass = gclass;
	}
	public float getGoodsPrice() {
		return goodsPrice;
	}
	public void setGoodsPrice(float goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	
	
	public float getGtotalPrice() {
		return gtotalPrice;
	}
	public void setGtotalPrice(float gtotalPrice) {
		this.gtotalPrice = gtotalPrice;
	}
	public int getGoodsCount() {
		return goodsCount;
	}
	public void setGoodsCount(int goodsCount) {
		this.goodsCount = goodsCount;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public shoppingcart(int shoppingcartID, int userID, int goodsID, String goodsName, String goodsImg, String gclass,
			float goodsPrice, float gtotalPrice, int goodsCount, String date) {
		super();
		this.shoppingcartID = shoppingcartID;
		this.userID = userID;
		this.goodsID = goodsID;
		this.goodsName = goodsName;
		this.goodsImg = goodsImg;
		this.gclass = gclass;
		this.goodsPrice = goodsPrice;
		this.gtotalPrice = gtotalPrice;
		this.goodsCount = goodsCount;
		this.date = date;
	}
	@Override
	public String toString() {
		return "shoppingcart [shoppingcartID=" + shoppingcartID + ", userID=" + userID + ", goodsID=" + goodsID+ ", goodsName=" + goodsName+ ", goodsImg=" + goodsImg+ ", goodsPrice=" + goodsPrice
				+ ", goodsCount=" + goodsCount+ ", gtotalPrice=" + gtotalPrice+ ", gclass=" + gclass + ", date=" + date + "]";
	};
	
}
