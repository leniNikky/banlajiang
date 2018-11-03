package domain;

public class comments {
	private int commentID;
	private int userID;
	private String userName;
	private int orderID;
	private String orderNo;
	private String content;
	private String cdate;
	public comments() {}
	public int getCommentID() {
		return commentID;
	}
	public void setCommentID(int commentID) {
		this.commentID = commentID;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getOrderID() {
		return orderID;
	}
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCdate() {
		return cdate;
	}
	public void setCdate(String cdate) {
		this.cdate = cdate;
	}
	@Override
	public String toString() {
		return "comments [commentID=" + commentID + ", userID=" + userID + ", userName=" + userName + ", orderID="
				+ orderID + ", orderNo=" + orderNo + ", content=" + content + ", cdate=" + cdate + "]";
	}
	public comments(int commentID, int userID, String userName, int orderID, String orderNo, String content,
			String cdate) {
		super();
		this.commentID = commentID;
		this.userID = userID;
		this.userName = userName;
		this.orderID = orderID;
		this.orderNo = orderNo;
		this.content = content;
		this.cdate = cdate;
	}
	
}
