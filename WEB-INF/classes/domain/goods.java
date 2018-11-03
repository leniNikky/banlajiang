package domain;

public class goods {
	private int goodsID;
	private int goodsNo;
	private String goodsName;
	private float goodsPrice;
	private String goodsIntr;
	private String goodsimg;
	private int goodsCount;
	private String pictext;
	private String gclass;
	private String gimg1;
	private String gimg2;
	private String gimg3;
	private String time;
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getGimg1() {
		return gimg1;
	}
	public void setGimg1(String gimg1) {
		this.gimg1 = gimg1;
	}
	public String getGimg2() {
		return gimg2;
	}
	public void setGimg2(String gimg2) {
		this.gimg2 = gimg2;
	}
	public String getGimg3() {
		return gimg3;
	}
	public void setGimg3(String gimg3) {
		this.gimg3 = gimg3;
	}
	public goods(){};
	public int getGoodsID() {
		return goodsID;
	}
	public void setGoodsID(int goodsID) {
		this.goodsID = goodsID;
	}
	public int getGoodsNo() {
		return goodsNo;
	}
	public void setGoodsNo(int goodsNo) {
		this.goodsNo = goodsNo;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public float getGoodsPrice() {
		return goodsPrice;
	}
	public void setGoodsPrice(float goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	public String getGoodsIntr() {
		return goodsIntr;
	}
	public void setGoodsIntr(String goodsIntr) {
		this.goodsIntr = goodsIntr;
	}
	public String getGoodsimg() {
		return goodsimg;
	}
	public void setGoodsimg(String goodsimg) {
		this.goodsimg = goodsimg;
	}
	public int getGoodsCount() {
		return goodsCount;
	}
	public void setGoodsCount(int goodsCount) {
		this.goodsCount = goodsCount;
	}
	public String getPictext() {
		return pictext;
	}
	public void setPictext(String pictext) {
		this.pictext = pictext;
	}
	public String getGclass() {
		return gclass;
	}
	public void setGclass(String gclass) {
		this.gclass = gclass;
	}
	public goods(int goodsID, int goodsNo, String goodsName, float goodsPrice, String goodsIntr, String goodsimg,
			int goodsCount, String pictext, String gclass, String gimg1, String gimg2, String gimg3,String time) {
		super();
		this.goodsID = goodsID;
		this.goodsNo = goodsNo;
		this.goodsName = goodsName;
		this.goodsPrice = goodsPrice;
		this.goodsIntr = goodsIntr;
		this.goodsimg = goodsimg;
		this.goodsCount = goodsCount;
		this.pictext = pictext;
		this.gclass = gclass;
		this.gimg1 = gimg1;
		this.gimg2 = gimg2;
		this.gimg3 = gimg3;
		this.time = time;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return goodsID+goodsNo+goodsName+goodsPrice+goodsIntr+goodsimg+goodsCount+pictext+gclass+gimg1+gimg2+gimg3+time;
	}
	
}
