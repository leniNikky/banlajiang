package dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Collection;
import domain.Conn;
import domain.user;

public class userDao {
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs =null;
	
	//查询用户名是否已被注册
	public int check(String userName) {
		
		String sql="select * from user where userName=?";
		int i =0;
			try{ 
				conn=Conn.getConnection();
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1,userName);	
				rs = pstmt.executeQuery();
				if(rs.next()){
					i=1;
				}else i=0;
		}catch(SQLException e){
			e.printStackTrace();					
		}finally{
			Conn.release(rs);
			Conn.release(pstmt);
			Conn.release(conn);
		}
			return i;
	}
	//注册
	public boolean insertUser(user user) {
		String sql="insert into user(userName,userPassword,phone,email) values(?,?,?,?)";
		int i=0;
		try{
			conn = Conn.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,user.getUserName());
			pstmt.setString(2,user.getUserPassword());
			pstmt.setString(3,user.getPhone());
			pstmt.setString(4,user.getEmail());
			i=pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();					
		}finally{
			Conn.release(pstmt);
			Conn.release(conn);
		}
		if (i>0) return true;
		else return false;
	}
	
	//登录
	public user login(String userName,String userPassword) {
		user user=new user();
		String sql="select * from user where userName=? and userPassword=?";
			try{ 
				conn=Conn.getConnection();
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1,userName);
				pstmt.setString(2,userPassword);	
				rs = pstmt.executeQuery();
				if(rs.next()){
					user.setUserID(rs.getInt("userID"));
					user.setUserName(rs.getString("userName"));
					user.setUserPassword(rs.getString("userPassword"));
					user.setPhone(rs.getString("phone"));
					user.setEmail(rs.getString("email"));
					user.setUserroot(rs.getInt("userroot"));
				}else user=null;
		}catch(SQLException e){
			e.printStackTrace();					
		}finally{
			Conn.release(rs);
			Conn.release(pstmt);
			Conn.release(conn);
		}
			return user;
	}
	
	//更改信息
	public int updateUser(user user) {
		String userName=user.getUserName();
		String email=user.getEmail();
		String phone=user.getPhone();
		conn = Conn.getConnection();
		int up=0;
		try{
			String sql="update user set email=?, phone=? where userName = ?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,email);
			pstmt.setString(2,phone);
			pstmt.setString(3,userName);
			up = pstmt.executeUpdate();
		}catch(SQLException e){
			throw new RuntimeException(e);
		}finally{
			Conn.release(rs);
			Conn.release(pstmt);
			Conn.release(conn);
		}
		return up;
	}
	
	//更改密码
	public int updatePass(String userName,String oldPass,String newPass) {
		conn = Conn.getConnection();
		int a = 0;
		try{
    		String sql = "update user set userPassword = ? where userName = ? and userPassword = ?";
    		pstmt = conn.prepareStatement(sql);
    		pstmt.setString(1, newPass);
    		pstmt.setString(2, userName);
    		pstmt.setString(3, oldPass);
    		a = pstmt.executeUpdate();
    	}catch(SQLException e){
			throw new RuntimeException(e);
		}finally{
			Conn.release(rs);
			Conn.release(pstmt);
			Conn.release(conn);
		}
		return a;
	}
	
	//所有用户
	public Collection<user> getUsers(){
		Collection<user> users = new ArrayList<user>();
		
		try{
    		String sql = "select * from user";
    		
    		conn = Conn.getConnection();
    		pstmt = conn.prepareStatement(sql);
    		rs = pstmt.executeQuery();
    		
    		while(rs.next()){
    			user user = new user();
    			user.setUserID(rs.getInt("userID"));
    			user.setUserName(rs.getString("userName"));
    			user.setUserroot(rs.getInt("userroot"));
    			user.setPhone(rs.getString("phone"));
    			user.setEmail(rs.getString("email"));
    			users.add(user);
    		}
    	}catch(SQLException e){
			throw new RuntimeException(e);
		}finally{
			Conn.release(rs);
			Conn.release(pstmt);
			Conn.release(conn);
		}
		return users;
		
	}
	//查找用户
		public Collection<user> findUsers(String userName){
			/*System.out.print(goodsName);*/
			Collection<user> users = new ArrayList<user>();
			try{
	    		String sql = "select * from user where userName like \'%"+userName+"%\'";
	    		
	    		conn = Conn.getConnection();
	    		pstmt=conn.prepareStatement(sql);
				rs=pstmt.executeQuery();
				/*System.out.println(goodsName);*/
				
	    		while(rs.next()){
	    			user user = new user();
	    			user.setUserID(rs.getInt("userID"));
	    			user.setUserName(rs.getString("userName"));
	    			user.setUserroot(rs.getInt("userroot"));
	    			user.setPhone(rs.getString("phone"));
	    			user.setEmail(rs.getString("email"));
	    			users.add(user);
	    			
	    			
	    		}
	    		
	    	}catch(SQLException e){
				throw new RuntimeException(e);
			}finally{
				Conn.release(rs);
				Conn.release(pstmt);
				Conn.release(conn);
			}
			return users;
			
		}
		//查看用户
		public user userDetails(int userID) {
			user user=new user();
			String sql="select * from user where userID=?";
				try{ 
					conn=Conn.getConnection();
					pstmt=conn.prepareStatement(sql);
					pstmt.setInt(1,userID);
					rs = pstmt.executeQuery();
					if(rs.next()){
						user.setUserID(rs.getInt("userID"));
		    			user.setUserName(rs.getString("userName"));
		    			user.setUserroot(rs.getInt("userroot"));
		    			user.setPhone(rs.getString("phone"));
		    			user.setEmail(rs.getString("email"));
					}else user=null;
			}catch(SQLException e){
				e.printStackTrace();					
			}finally{
				Conn.release(rs);
				Conn.release(pstmt);
				Conn.release(conn);
			}
				return user;
		}
		//更改权限
		public int updateRoot(int userroot,int userID) {
			conn = Conn.getConnection();
			int a = 0;
			try{
	    		String sql = "update user set userroot = ? where userID = ?";
	    		pstmt = conn.prepareStatement(sql);
	    		pstmt.setInt(1, userroot);
	    		pstmt.setInt(2, userID);
	       		a = pstmt.executeUpdate();
	    	}catch(SQLException e){
				throw new RuntimeException(e);
			}finally{
				Conn.release(rs);
				Conn.release(pstmt);
				Conn.release(conn);
			}
			return a;
		}
		//删除用户
		public int deleteUser(int userID) {
			conn = Conn.getConnection();
			int de=0;
			try{
				String sql="delete from user where userID=?";
				pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1,userID);
				de = pstmt.executeUpdate();
			}catch(SQLException e){
				throw new RuntimeException(e);
			}finally{
				Conn.release(rs);
				Conn.release(pstmt);
				Conn.release(conn);
			}
			return de;
		}
		//用户数
		public int userCount(){
			int usertotal=0;
			conn = Conn.getConnection();
			try{
				String sql="select count(userID) as usertotal from user";
				pstmt=conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				if(rs.next()){
					usertotal = rs.getInt("usertotal");
				}
				
			}catch(SQLException e){
				throw new RuntimeException(e);
			}finally{
				Conn.release(rs);
				Conn.release(pstmt);
				Conn.release(conn);
			}
			return usertotal;
		}
}
