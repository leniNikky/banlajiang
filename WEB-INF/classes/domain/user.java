package domain;

public class user {
	private int userID;
	private String userName;
	private String userPassword;
	private String phone;
	private String email;
	private int userroot;
	public int getUserroot() {
		return userroot;
	}
	public void setUserroot(int userroot) {
		this.userroot = userroot;
	}
	public user(){};
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
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public user(int userID, String userName, String userPassword, String phone, String email,int userroot) {
		super();
		this.userID = userID;
		this.userName = userName;
		this.userPassword = userPassword;
		this.phone = phone;
		this.email = email;
		this.userroot = userroot;
	}
	@Override
	public String toString() {
		return "user [userID=" + userID + ", userName=" + userName + ", userPassword=" + userPassword + ", phone="
				+ phone + ", email=" + email + "]";
	}
	
}
