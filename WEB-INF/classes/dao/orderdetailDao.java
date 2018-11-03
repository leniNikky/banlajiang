package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;

import domain.Conn;
import domain.goods;
import domain.orderdetail;
import domain.shoppingcart;

public class orderdetailDao {
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs =null;
	//鍔犲叆璁㈠崟璇︽儏
	public boolean addOrderDetail(orderdetail orderdetail) {
		String sql="insert into orderdetail(userID,orderNo,goodsID,goodsName,goodsPrice,gclass,goodsCount,gtotalPrice,goodsImg) values(?,?,?,?,?,?,?,?,?)";
		int i=0;
		try{
			conn = Conn.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, orderdetail.getUserID());
			pstmt.setString(2, orderdetail.getOrderNo());
			pstmt.setInt(3, orderdetail.getGoodsID());
			pstmt.setString(4, orderdetail.getGoodsName());
			pstmt.setFloat(5, orderdetail.getGoodsPrice());
			pstmt.setString(6, orderdetail.getGclass());
			pstmt.setInt(7, orderdetail.getGoodsCount());
			pstmt.setFloat(8, orderdetail.getGtotalPrice());
			pstmt.setString(9, orderdetail.getGoodsImg());
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
	//鏌ョ湅涓�涓鍗曡鎯�
	public orderdetail orderDetail(String orderNo) {
		orderdetail orderdetail=new orderdetail();
		String sql="select * from orderdetail where orderNo=?";
			try{ 
				conn=Conn.getConnection();
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1,orderNo);
				rs = pstmt.executeQuery();
				if(rs.next()){
					orderdetail.setOrderdetailID(rs.getInt("orderdetailID"));
					orderdetail.setUserID(rs.getInt("userID"));
					orderdetail.setOrderNo(rs.getString("orderNo"));
					orderdetail.setGoodsID(rs.getInt("goodsID"));
					orderdetail.setGoodsName(rs.getString("goodsName"));
					orderdetail.setGoodsPrice(rs.getFloat("goodsPrice"));
					orderdetail.setGtotalPrice(rs.getFloat("gtotalPrice"));
					orderdetail.setGoodsCount(rs.getInt("goodsCount"));
					orderdetail.setGclass(rs.getString("gclass"));
					orderdetail.setGoodsImg(rs.getString("goodsImg"));
	    			/*System.out.print(goods.getGoodsName());*/
				}else orderdetail=null;
		}catch(SQLException e){
			e.printStackTrace();					
		}finally{
			Conn.release(rs);
			Conn.release(pstmt);
			Conn.release(conn);
		}
			return orderdetail;
	}
	//鏌ョ湅璁㈠崟
	public Collection<orderdetail> getOrderdetail(String orderNo){
		Collection<orderdetail> orderdetail = new ArrayList<orderdetail>();
		
		try{
    		String sql = "select * from orderdetail where orderNo = ?";
    		
    		conn = Conn.getConnection();
    		pstmt = conn.prepareStatement(sql);
    		pstmt.setString(1,orderNo);
    		rs = pstmt.executeQuery();
    		
    		while(rs.next()){
    			orderdetail od  = new orderdetail();
    			od.setOrderNo(rs.getString("orderNo"));
    			od.setOrderdetailID(rs.getInt("orderdetailID"));
    			od.setUserID(rs.getInt("userID"));
    			od.setGoodsID(rs.getInt("goodsID"));
    			od.setGoodsName(rs.getString("goodsName"));
    			od.setGoodsImg(rs.getString("goodsImg"));
    			od.setGclass(rs.getString("gclass"));
    			od.setGoodsCount(rs.getInt("goodsCount"));
    			od.setGoodsPrice(rs.getFloat("goodsPrice"));
    			od.setGtotalPrice(rs.getFloat("gtotalPrice"));
    			orderdetail.add(od);
    		}
    	}catch(SQLException e){
			throw new RuntimeException(e);
		}finally{
			Conn.release(rs);
			Conn.release(pstmt);
			Conn.release(conn);
		}
		return orderdetail;
		
	}
	//查找一个商品的所有订单详情
	public Collection<orderdetail> getGoodsOrder(int goodsID){
		Collection<orderdetail> GoodsOrder = new ArrayList<orderdetail>();
		
		try{
    		String sql = "select * from orderdetail where goodsID = ?";
    		
    		conn = Conn.getConnection();
    		pstmt = conn.prepareStatement(sql);
    		pstmt.setInt(1,goodsID);
    		rs = pstmt.executeQuery();
    		
    		while(rs.next()){
    			orderdetail od  = new orderdetail();
    			od.setOrderNo(rs.getString("orderNo"));
    			od.setOrderdetailID(rs.getInt("orderdetailID"));
    			od.setUserID(rs.getInt("userID"));
    			od.setGoodsID(rs.getInt("goodsID"));
    			od.setGoodsName(rs.getString("goodsName"));
    			od.setGoodsImg(rs.getString("goodsImg"));
    			od.setGclass(rs.getString("gclass"));
    			od.setGoodsCount(rs.getInt("goodsCount"));
    			od.setGoodsPrice(rs.getFloat("goodsPrice"));
    			od.setGtotalPrice(rs.getFloat("gtotalPrice"));
    			GoodsOrder.add(od);
    		}
    	}catch(SQLException e){
			throw new RuntimeException(e);
		}finally{
			Conn.release(rs);
			Conn.release(pstmt);
			Conn.release(conn);
		}
		return GoodsOrder;
		
	}
}
