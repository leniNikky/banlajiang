package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import domain.comments;
import domain.goods;
import domain.orders;
import domain.orderdetail;
import domain.Conn;


public class CommentDao {
	//插入评论
	Connection conn=null;
	PreparedStatement ps=null;
	ResultSet rs =null;
	public boolean insertComment(comments comment) {
		String sql="insert into comments(userID,orderNo,content,cdate,orderID,userName) values(?,?,?,?,?,?)";
		int i=0;
		Date time = new Date(System.currentTimeMillis());
		try{
			conn = Conn.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, comment.getUserID());
			ps.setString(2, comment.getOrderNo());
			ps.setString(3, comment.getContent());
			ps.setString(4,time.toString());
			ps.setInt(5, comment.getOrderID());
			ps.setString(6, comment.getUserName());
			i=ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();					
		}finally{
			Conn.release(ps);
			Conn.release(conn);
		}
		if (i>0) return true;
		else return false;
	}
	//查看个人评论
	public Collection<comments> myCm(int userID){
		
		Collection<comments> comments = new ArrayList<comments>();
	    System.out.println("plun"+userID);
		try{
			
			String sql = "select * from comments where userID = "+userID;
			
    		conn = Conn.getConnection();
    		ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			/*System.out.println(goodsName);*/
			
    		while(rs.next()){
    			comments comment = new comments();
    			comment.setCommentID(rs.getInt("commentID"));
    			comment.setUserID(rs.getInt("userID"));
    			comment.setUserName(rs.getString("userName"));
    			comment.setOrderID(rs.getInt("orderID"));
    			comment.setOrderNo(rs.getString("orderNo"));
    			comment.setContent(rs.getString("content"));
    			comment.setCdate(rs.getString("cdate"));
    			comments.add(comment);
    		}
    		
    	}catch(SQLException e){
			throw new RuntimeException(e);
		}finally{
			Conn.release(rs);
			Conn.release(ps);
			Conn.release(conn);
		}
		return comments;
		
	}
	//一件商品的一条评论
	public comments goodsComment(String orderNo) {
		comments comment=new comments();
		String sql="select * from comments where orderNo=?";
			try{ 
				conn=Conn.getConnection();
				ps=conn.prepareStatement(sql);
				ps.setString(1,orderNo);
				rs = ps.executeQuery();
				if(rs.next()){
					comment.setCommentID(rs.getInt("commentID"));
					comment.setUserID(rs.getInt("userID"));
					comment.setOrderID(rs.getInt("orderID"));
					comment.setUserID(rs.getInt("userID"));
					comment.setUserName(rs.getString("userName"));
					comment.setContent(rs.getString("content"));
					comment.setCdate(rs.getString("cdate"));
					
	    			/*System.out.print(goods.getGoodsName());*/
				}else comment=null;
		}catch(SQLException e){
			e.printStackTrace();					
		}finally{
			Conn.release(rs);
			Conn.release(ps);
			Conn.release(conn);
		}
			return comment;
	}
	//一件商品的所有评论
public Collection<comments> allcm(int goodsID){
		
		Collection<comments> goodscomments = new ArrayList<comments>();
	    
		try{
			
			String orderNo = "select orderNo from orderdetail where userID = "+goodsID;
			
    		conn = Conn.getConnection();
    		ps=conn.prepareStatement(orderNo);
			rs=ps.executeQuery();
			/*System.out.println(goodsName);*/
			
    		while(rs.next()){
    			System.out.print("123");
    			String ono = rs.getString("orderNo");
    			String sql = "select orderNo from orderdetail where userID = "+ono;
    			ps=conn.prepareStatement(sql);
    			comments comment = new comments();
    			
    			while(rs.next()) {
    				
        			comment.setCommentID(rs.getInt("commentID"));
        			comment.setUserID(rs.getInt("userID"));
        			comment.setUserName(rs.getString("userName"));
        			comment.setOrderID(rs.getInt("orderID"));
        			comment.setOrderNo(rs.getString("orderNo"));
        			comment.setContent(rs.getString("content"));
        			comment.setCdate(rs.getString("cdate"));
        			goodscomments.add(comment);
        			
    			}
    			
    		}
    		
    	}catch(SQLException e){
			throw new RuntimeException(e);
		}finally{
			Conn.release(rs);
			Conn.release(ps);
			Conn.release(conn);
		}
		return goodscomments;
		
	}
//总评论数
public int cmCount(){
	int cmtotal=0;
	conn = Conn.getConnection();
	try{
		String sql="select count(commentID) as cmtotal from comments";
		ps=conn.prepareStatement(sql);
		rs = ps.executeQuery();
		if(rs.next()){
			cmtotal = rs.getInt("cmtotal");
		}
		
	}catch(SQLException e){
		throw new RuntimeException(e);
	}finally{
		Conn.release(rs);
		Conn.release(ps);
		Conn.release(conn);
	}
	return cmtotal;
}
}
