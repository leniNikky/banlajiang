package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;

import com.sun.swing.internal.plaf.basic.resources.basic;

import domain.Conn;
import domain.goods;
import domain.orders;



public class orderDao {
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs =null;
	
	//鐢熸垚璁㈠崟
	public boolean insertorder(orders order) {
		int i=0;
		Date time = new Date(System.currentTimeMillis());
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    String current = sdf.format(time);
	    System.out.print(current);
	    String sql="insert into orders(userID,consignName,consigneeAddress,consigneePhone,orderDate,totalprice,orderNo) values(?,?,?,?,?,?,?)";
		try{
			conn = Conn.getConnection();
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setInt(1,order.getUserID());
			pstmt.setString(2,order.getConsignName());
			pstmt.setString(3,order.getConsigneeAddress());
			pstmt.setString(4,order.getConsigneePhone());
			pstmt.setString(5,current);
			pstmt.setFloat(6,order.getTotalprice());
			pstmt.setString(7,order.getOrderNo());
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
	//鏌ョ湅鎵�鏈夎鍗�
	public Collection<orders> getOrders(int userID){
		Collection<orders> orders = new ArrayList<orders>();
		
		try{
    		String sql = "select * from orders where userID = ?";
    		
    		conn = Conn.getConnection();
    		pstmt = conn.prepareStatement(sql);
    		pstmt.setInt(1,userID);
    		rs = pstmt.executeQuery();
    		
    		while(rs.next()){
    			orders order  = new orders();
    			order.setOrderID(rs.getInt("orderID"));
    			order.setOrderNo(rs.getString("orderNo"));
    			order.setUserID(rs.getInt("userID"));
    			order.setConsignName(rs.getString("consignName"));
    			order.setConsigneeAddress(rs.getString("consigneeAddress"));
    			order.setConsigneePhone(rs.getString("consigneePhone"));
    			order.setPayway(rs.getString("payway"));
    			order.setOrderDate(rs.getString("orderDate"));
    			order.setOrderstatus(rs.getString("orderstatus"));
    			order.setTotalprice(rs.getFloat("totalprice"));
    			orders.add(order);
    		}
    	}catch(SQLException e){
			throw new RuntimeException(e);
		}finally{
			Conn.release(rs);
			Conn.release(pstmt);
			Conn.release(conn);
		}
		return orders;
		
}
	//显示已收货订单
		public Collection<orders> getROrders(int userID){
			Collection<orders> orders = new ArrayList<orders>();
			
			try{
	    		String sql = "select * from orders where userID = ? and orderstatus ='已收货'";
	    		
	    		conn = Conn.getConnection();
	    		pstmt = conn.prepareStatement(sql);
	    		pstmt.setInt(1,userID);
	    		rs = pstmt.executeQuery();
	    		
	    		while(rs.next()){
	    			orders order  = new orders();
	    			order.setOrderID(rs.getInt("orderID"));
	    			order.setOrderNo(rs.getString("orderNo"));
	    			order.setUserID(rs.getInt("userID"));
	    			order.setConsignName(rs.getString("consignName"));
	    			order.setConsigneeAddress(rs.getString("consigneeAddress"));
	    			order.setConsigneePhone(rs.getString("consigneePhone"));
	    			order.setPayway(rs.getString("payway"));
	    			order.setOrderDate(rs.getString("orderDate"));
	    			order.setOrderstatus(rs.getString("orderstatus"));
	    			order.setTotalprice(rs.getFloat("totalprice"));
	    			orders.add(order);
	    		}
	    	}catch(SQLException e){
				throw new RuntimeException(e);
			}finally{
				Conn.release(rs);
				Conn.release(pstmt);
				Conn.release(conn);
			}
			return orders;
			
	}
	//鍚庡彴鏄剧ず鎵�鏈夎鍗�
	public Collection<orders> allOrder(){
		Collection<orders> orders = new ArrayList<orders>();
		
		try{
    		String sql = "select * from orders";
    		
    		conn = Conn.getConnection();
    		pstmt=conn.prepareStatement(sql);
    		rs = pstmt.executeQuery();
    		
    		while(rs.next()){
    			orders order  = new orders();
    			order.setOrderID(rs.getInt("orderID"));
    			order.setOrderNo(rs.getString("orderNo"));
    			order.setUserID(rs.getInt("userID"));
    			order.setConsignName(rs.getString("consignName"));
    			order.setConsigneeAddress(rs.getString("consigneeAddress"));
    			order.setConsigneePhone(rs.getString("consigneePhone"));
    			order.setPayway(rs.getString("payway"));
    			order.setOrderDate(rs.getString("orderDate"));
    			order.setOrderstatus(rs.getString("orderstatus"));
    			order.setTotalprice(rs.getFloat("totalprice"));
    			orders.add(order);
    		}
    	}catch(SQLException e){
			throw new RuntimeException(e);
		}finally{
			Conn.release(rs);
			Conn.release(pstmt);
			Conn.release(conn);
		}
		return orders;
		
}
	//订单详情
		public orders orderDetails(int orderID) {
			orders order=new orders();
			String sql="select * from orders where orderID=?";
				try{ 
					conn=Conn.getConnection();
					pstmt=conn.prepareStatement(sql);
					pstmt.setInt(1,orderID);
					rs = pstmt.executeQuery();
					if(rs.next()){
						order.setConsigneeAddress(rs.getString("consigneeAddress"));
						order.setConsigneePhone(rs.getString("consigneePhone"));
						order.setConsignName(rs.getString("consignName"));
						order.setOrderDate(rs.getString("orderDate"));				
						order.setOrderID(rs.getInt("orderID"));
						order.setOrderNo(rs.getString("orderNo"));
						order.setOrderstatus(rs.getString("orderstatus"));
						order.setPayway(rs.getString("payway"));
						order.setTotalprice(rs.getFloat("totalprice"));
						order.setUserID(rs.getInt("userID"));
						
		    			/*System.out.print(goods.getGoodsName());*/
					}else order=null;
			}catch(SQLException e){
				e.printStackTrace();					
			}finally{
				Conn.release(rs);
				Conn.release(pstmt);
				Conn.release(conn);
			}
				return order;
		}
		
		//淇敼璁㈠崟鐘舵��
		public int updateStatus(int orderID,String orderstatus) {
			conn = Conn.getConnection();
			int a = 0;
			try{
	    		String sql = "update orders set orderstatus = ? where orderID = ?";
	    		pstmt = conn.prepareStatement(sql);
	    		pstmt.setString(1, orderstatus);
	    		pstmt.setInt(2, orderID);
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
		//鏌ユ壘鍟嗗搧
		public Collection<orders> findGoods(String ordermsg,String msg){
			/*System.out.print(goodsName);*/
			/*if(msg=="璁㈠崟缂栧彿") {
				Integer.parseInt(ordermsg) ;
			}*/
			Collection<orders> findorders = new ArrayList<orders>();
		
			try{
				
				String sql = "select * from orders where "+msg +" like \'%"+ordermsg+"%\'";
				
	    		conn = Conn.getConnection();
	    		pstmt=conn.prepareStatement(sql);
				rs=pstmt.executeQuery();
				/*System.out.println(goodsName);*/
				
	    		while(rs.next()){
	    			orders order = new orders();
	    			order.setConsigneeAddress(rs.getString("consigneeAddress"));
					order.setConsigneePhone(rs.getString("consigneePhone"));
					order.setConsignName(rs.getString("consignName"));
					order.setOrderDate(rs.getString("orderDate"));				
					order.setOrderID(rs.getInt("orderID"));
					order.setOrderNo(rs.getString("orderNo"));
					order.setOrderstatus(rs.getString("orderstatus"));
					order.setPayway(rs.getString("payway"));
					order.setTotalprice(rs.getFloat("totalprice"));
					order.setUserID(rs.getInt("userID"));
					findorders.add(order);
	    		}
	    		
	    	}catch(SQLException e){
				throw new RuntimeException(e);
			}finally{
				Conn.release(rs);
				Conn.release(pstmt);
				Conn.release(conn);
			}
			return findorders;
			
		}
		//璁㈠崟鎬绘暟
				public int orderCount(){
					int ordertotal=0;
					conn = Conn.getConnection();
					try{
						String sql="select count(orderID) as ordertotal from orders";
						pstmt=conn.prepareStatement(sql);
						rs = pstmt.executeQuery();
						if(rs.next()){
							ordertotal = rs.getInt("ordertotal");
						}
						
					}catch(SQLException e){
						throw new RuntimeException(e);
					}finally{
						Conn.release(rs);
						Conn.release(pstmt);
						Conn.release(conn);
					}
					return ordertotal;
				}
				//鏈鐞嗚鍗曟�绘暟
				public int orderunCount(){
					int ordertotal=0;
					conn = Conn.getConnection();
					try{
						String sql="select count(orderID) as orderuntotal from orders where orderstatus = '待处理'";
						pstmt=conn.prepareStatement(sql);
						rs = pstmt.executeQuery();
						if(rs.next()){
							ordertotal = rs.getInt("orderuntotal");
						}
						
					}catch(SQLException e){
						throw new RuntimeException(e);
					}finally{
						Conn.release(rs);
						Conn.release(pstmt);
						Conn.release(conn);
					}
					return ordertotal;
				}
				//宸插鐞嗚鍗曟�绘暟
				public int orderarlCount(){
					int ordertotal=0;
					conn = Conn.getConnection();
					try{
						String sql="select count(orderID) as orderarltotal from orders where orderstatus = '已处理'";
						pstmt=conn.prepareStatement(sql);
						rs = pstmt.executeQuery();
						if(rs.next()){
							ordertotal = rs.getInt("orderarltotal");
						}
						
					}catch(SQLException e){
						throw new RuntimeException(e);
					}finally{
						Conn.release(rs);
						Conn.release(pstmt);
						Conn.release(conn);
					}
					return ordertotal;
				}
				//宸插彂璐ц鍗曟�绘暟
				public int sendCount(){
					int ordertotal=0;
					conn = Conn.getConnection();
					try{
						String sql="select count(orderID) as sendtotal from orders where orderstatus = '已发货'";
						pstmt=conn.prepareStatement(sql);
						rs = pstmt.executeQuery();
						if(rs.next()){
							ordertotal = rs.getInt("sendtotal");
						}
						
					}catch(SQLException e){
						throw new RuntimeException(e);
					}finally{
						Conn.release(rs);
						Conn.release(pstmt);
						Conn.release(conn);
					}
					return ordertotal;
				}
				//寰呮敹璐ц鍗曟�绘暟
				public int waitCount(){
					int ordertotal=0;
					conn = Conn.getConnection();
					try{
						String sql="select count(orderID) as waittotal from orders where orderstatus = '待收货'";
						pstmt=conn.prepareStatement(sql);
						rs = pstmt.executeQuery();
						if(rs.next()){
							ordertotal = rs.getInt("waittotal");
						}
						
					}catch(SQLException e){
						throw new RuntimeException(e);
					}finally{
						Conn.release(rs);
						Conn.release(pstmt);
						Conn.release(conn);
					}
					return ordertotal;
				}
				//宸叉敹璐ц鍗曟�绘暟
				public int reCount(){
					int ordertotal=0;
					conn = Conn.getConnection();
					try{
						String sql="select count(orderID) as retotal from orders where orderstatus = '已收货'";
						pstmt=conn.prepareStatement(sql);
						rs = pstmt.executeQuery();
						if(rs.next()){
							ordertotal = rs.getInt("retotal");
						}
						
					}catch(SQLException e){
						throw new RuntimeException(e);
					}finally{
						Conn.release(rs);
						Conn.release(pstmt);
						Conn.release(conn);
					}
					return ordertotal;
				}
				//浜ゆ槗鎬婚噾棰�
				public float totalP(){
					int totalp=0;
					conn = Conn.getConnection();
					try{
						String sql="select sum(totalprice) as totalp from orders";
						pstmt=conn.prepareStatement(sql);
						rs = pstmt.executeQuery();
						if(rs.next()){
							totalp = rs.getInt("totalp");
						}
						
					}catch(SQLException e){
						throw new RuntimeException(e);
					}finally{
						Conn.release(rs);
						Conn.release(pstmt);
						Conn.release(conn);
					}
					return totalp;
				}
}