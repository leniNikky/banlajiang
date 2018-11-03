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
import domain.shoppingcart;
import domain.user;

public class shoppingcartDao {
	//加入购物车
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs =null;
	public boolean addGoods(shoppingcart shoppingcart) {
		String sql="insert into shoppingcart(userID,goodsID,goodsName,goodsImg,goodsPrice,goodsCount,date,gclass,gtotalPrice) values(?,?,?,?,?,?,?,?,?)";
		int i=0;
		float gtotalPrice = shoppingcart.getGoodsPrice()* shoppingcart.getGoodsCount();
		System.out.println(gtotalPrice);
		Date time = new Date(System.currentTimeMillis());
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    String current = sdf.format(time);
		try{
			conn = Conn.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1,shoppingcart.getUserID());
			pstmt.setInt(2,shoppingcart.getGoodsID());
			pstmt.setString(3,shoppingcart.getGoodsName());
			pstmt.setString(4,shoppingcart.getGoodsImg());
			pstmt.setFloat(5,shoppingcart.getGoodsPrice());
			pstmt.setInt(6,shoppingcart.getGoodsCount());
			pstmt.setString(7,current);
			pstmt.setString(8,shoppingcart.getGclass());
			pstmt.setFloat(9,gtotalPrice);
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
	//查看购物车
	public Collection<shoppingcart> getCarts(int userID){
		Collection<shoppingcart> carts = new ArrayList<shoppingcart>();
		
		try{
    		String sql = "select * from shoppingcart where userID = ?";
    		
    		conn = Conn.getConnection();
    		pstmt = conn.prepareStatement(sql);
    		pstmt.setInt(1,userID);
    		rs = pstmt.executeQuery();
    		
    		while(rs.next()){
    			shoppingcart cart  = new shoppingcart();
    			cart.setShoppingcartID(rs.getInt("shoppingcartID"));
    			cart.setUserID(rs.getInt("userID"));
    			cart.setGoodsID(rs.getInt("goodsID"));
    			cart.setGoodsName(rs.getString("goodsName"));
    			cart.setGoodsImg(rs.getString("goodsImg"));
    			cart.setGoodsPrice(rs.getFloat("goodsPrice"));
    			cart.setGtotalPrice(rs.getFloat("gtotalPrice"));
    			cart.setGoodsCount(rs.getInt("goodsCount"));
    			cart.setGclass(rs.getString("gclass"));
    			carts.add(cart);
    		}
    	}catch(SQLException e){
			throw new RuntimeException(e);
		}finally{
			Conn.release(rs);
			Conn.release(pstmt);
			Conn.release(conn);
		}
		return carts;
		
	}
	//删除商品
	public int deleteGoods(int shoppingcartID) {
		conn = Conn.getConnection();
		int de=0;
		try{
			String sql="delete from shoppingcart where shoppingcartID=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1,shoppingcartID);
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
	//修改购物车
	public int updateCart(int goodsCount, float goodsPrice,int shoppingcartID) {
		
		conn = Conn.getConnection();
		int up=0;
		float gtotalPrice = goodsCount*goodsPrice;
		try{
			String sql="update shoppingcart set goodsCount=?,gtotalPrice=? where shoppingcartID = ?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1,goodsCount);
			pstmt.setFloat(2,gtotalPrice);
			pstmt.setInt(3,shoppingcartID);
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
	//一条购物车记录
	public shoppingcart shopcart(int shoppingcartID) {
		shoppingcart cart=new shoppingcart();
		String sql="select * from shoppingcart where shoppingcartID=?";
			try{ 
				conn=Conn.getConnection();
				pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1,shoppingcartID);
				rs = pstmt.executeQuery();
				if(rs.next()){
	    			cart.setUserID(rs.getInt("userID"));
	    			cart.setGoodsID(rs.getInt("goodsID"));
	    			cart.setGoodsName(rs.getString("goodsName"));
	    			cart.setGoodsImg(rs.getString("goodsImg"));
	    			cart.setGoodsPrice(rs.getFloat("goodsPrice"));
	    			cart.setGtotalPrice(rs.getFloat("gtotalPrice"));
	    			cart.setGoodsCount(rs.getInt("goodsCount"));
	    			cart.setGclass(rs.getString("gclass"));
	    			/*System.out.print(goods.getGoodsName());*/
				}else cart=null;
		}catch(SQLException e){
			e.printStackTrace();					
		}finally{
			Conn.release(rs);
			Conn.release(pstmt);
			Conn.release(conn);
		}
			return cart;
	}
}
