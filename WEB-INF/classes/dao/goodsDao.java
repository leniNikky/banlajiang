package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;



import domain.Conn;
import domain.goods;
import domain.user;



public class goodsDao {
	Connection conn=null;
	PreparedStatement ps=null;
	ResultSet rs =null;
	//娣诲姞鍟嗗搧
		public boolean insertGoods(goods goods) {
			String sql="insert into goods(goodsNo,goodsName,goodsPrice,goodsIntr,goodsimg,goodsCount,pictext,gimg1,gimg2,gimg3,time,gclass) values(?,?,?,?,?,?,?,?,?,?,?,?)";
			int i=0;
			Date time = new Date(System.currentTimeMillis());
			try{
				conn = Conn.getConnection();
				ps=conn.prepareStatement(sql);
				ps.setInt(1,goods.getGoodsNo());
				ps.setString(2,goods.getGoodsName());
				ps.setFloat(3,goods.getGoodsPrice());
				ps.setString(4,goods.getGoodsIntr());
				ps.setString(5,goods.getGoodsimg());
				ps.setInt(6,goods.getGoodsCount());
				ps.setString(7,goods.getPictext());
				ps.setString(8,goods.getGimg1());
				ps.setString(9,goods.getGimg2());
				ps.setString(10,goods.getGimg3());
				ps.setString(11,time.toString());
				ps.setString(12,goods.getGclass());
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
	
	//鏌ユ壘鍟嗗搧
	public Collection<goods> findGoods(String goodsName){
		/*System.out.print(goodsName);*/
		Collection<goods> findgoods = new ArrayList<goods>();
		try{
    		String sql = "select * from goods where goodsName like \'%"+goodsName+"%\'";
    		
    		conn = Conn.getConnection();
    		ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			/*System.out.println(goodsName);*/
			
    		while(rs.next()){
    			goods good = new goods();
    			good.setGoodsID(rs.getInt("goodsID"));
    			good.setGoodsNo(rs.getInt("goodsNo"));
    			good.setGoodsName(rs.getString("goodsName"));
    			good.setGoodsPrice(rs.getFloat("goodsPrice"));
    			good.setGoodsimg(rs.getString("goodsimg"));
    			good.setGoodsIntr(rs.getString("goodsIntr"));
    			good.setGoodsCount(rs.getInt("goodsCount"));
    			good.setPictext(rs.getString("pictext"));
    			good.setGclass(rs.getString("gclass"));
    			good.setGimg1(rs.getString("gimg1"));
    			good.setGimg2(rs.getString("gimg2"));
    			good.setGimg3(rs.getString("gimg3"));
    			good.setTime(rs.getString("time"));
    			findgoods.add(good);
    			
    		}
    		
    	}catch(SQLException e){
			throw new RuntimeException(e);
		}finally{
			Conn.release(rs);
			Conn.release(ps);
			Conn.release(conn);
		}
		return findgoods;
		
	}
	
	//涓�鏍峰晢鍝�
	public goods goodsDetails(int goodsID) {
		goods goods=new goods();
		String sql="select * from goods where goodsID=?";
			try{ 
				conn=Conn.getConnection();
				ps=conn.prepareStatement(sql);
				ps.setInt(1,goodsID);
				rs = ps.executeQuery();
				if(rs.next()){
					goods.setGoodsID(rs.getInt("goodsID"));
	    			goods.setGoodsNo(rs.getInt("goodsNo"));
	    			goods.setGoodsName(rs.getString("goodsName"));
	    			goods.setGoodsPrice(rs.getFloat("goodsPrice"));
	    			goods.setGoodsimg(rs.getString("goodsimg"));
	    			goods.setGoodsIntr(rs.getString("goodsIntr"));
	    			goods.setGoodsCount(rs.getInt("goodsCount"));
	    			goods.setPictext(rs.getString("pictext"));
	    			goods.setGclass(rs.getString("gclass"));
	    			goods.setGimg1(rs.getString("gimg1"));
	    			goods.setGimg2(rs.getString("gimg2"));
	    			goods.setGimg3(rs.getString("gimg3"));
	    			goods.setGimg3(rs.getString("time"));
	    			/*System.out.print(goods.getGoodsName());*/
				}else goods=null;
		}catch(SQLException e){
			e.printStackTrace();					
		}finally{
			Conn.release(rs);
			Conn.release(ps);
			Conn.release(conn);
		}
			return goods;
	}
	
	//鍟嗗搧鍒嗙被
	public Collection<goods> getGoodsClass(String gclass){
		Collection<goods> getGoodsClass = new ArrayList<goods>();
		try{
    		String sql = "select * from goods where gclass = '"+gclass+"'";
    		
    		conn = Conn.getConnection();
    		ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			
    		while(rs.next()){
    			goods good = new goods();
    			good.setGoodsID(rs.getInt("goodsID"));
    			good.setGoodsNo(rs.getInt("goodsNo"));
    			good.setGoodsName(rs.getString("goodsName"));
    			good.setGoodsPrice(rs.getFloat("goodsPrice"));
    			good.setGoodsimg(rs.getString("goodsimg"));
    			good.setGoodsIntr(rs.getString("goodsIntr"));
    			good.setGoodsCount(rs.getInt("goodsCount"));
    			good.setPictext(rs.getString("pictext"));
    			good.setGclass(rs.getString("gclass"));
    			good.setGimg1(rs.getString("gimg1"));
    			good.setGimg2(rs.getString("gimg2"));
    			good.setGimg3(rs.getString("gimg3"));
    			getGoodsClass.add(good);
    			
    		}
    		
    	}catch(SQLException e){
			throw new RuntimeException(e);
		}finally{
			Conn.release(rs);
			Conn.release(ps);
			Conn.release(conn);
		}
		return getGoodsClass;
		
	}
	
	//鎵�鏈夊晢鍝�
	public Collection<goods> getGoods(){
		Collection<goods> goods = new ArrayList<goods>();
		
		try{
    		String sql = "select * from goods";
    		
    		conn = Conn.getConnection();
    		ps=conn.prepareStatement(sql);
    		rs = ps.executeQuery();
    		
    		while(rs.next()){
    			goods good = new goods();
    			good.setGoodsID(rs.getInt("goodsID"));
    			good.setGoodsNo(rs.getInt("goodsNo"));
    			good.setGoodsName(rs.getString("goodsName"));
    			good.setGoodsPrice(rs.getFloat("goodsPrice"));
    			good.setGoodsimg(rs.getString("goodsimg"));
    			good.setGoodsIntr(rs.getString("goodsIntr"));
    			good.setGoodsCount(rs.getInt("goodsCount"));
    			good.setPictext(rs.getString("pictext"));
    			good.setGclass(rs.getString("gclass"));
    			good.setGimg1(rs.getString("gimg1"));
    			good.setGimg2(rs.getString("gimg2"));
    			good.setGimg3(rs.getString("gimg3"));
    			good.setTime(rs.getString("time"));
    			goods.add(good);
    		}
    	}catch(SQLException e){
			throw new RuntimeException(e);
		}finally{
			Conn.release(rs);
			Conn.release(ps);
			Conn.release(conn);
		}
		return goods;
		
	}
	//鏂板搧鎺ㄨ崘
		public Collection<goods> getNewGoods(){
			Collection<goods> goods = new ArrayList<goods>();
			
			try{
	    		String sql = "select * from goods order by time desc limit 4";
	    		
	    		conn = Conn.getConnection();
	    		ps=conn.prepareStatement(sql);
	    		rs = ps.executeQuery();
	    		
	    		while(rs.next()){
	    			goods good = new goods();
	    			good.setGoodsID(rs.getInt("goodsID"));
	    			good.setGoodsNo(rs.getInt("goodsNo"));
	    			good.setGoodsName(rs.getString("goodsName"));
	    			good.setGoodsPrice(rs.getFloat("goodsPrice"));
	    			good.setGoodsimg(rs.getString("goodsimg"));
	    			good.setGoodsIntr(rs.getString("goodsIntr"));
	    			good.setGoodsCount(rs.getInt("goodsCount"));
	    			good.setPictext(rs.getString("pictext"));
	    			good.setGclass(rs.getString("gclass"));
	    			good.setGimg1(rs.getString("gimg1"));
	    			good.setGimg2(rs.getString("gimg2"));
	    			good.setGimg3(rs.getString("gimg3"));
	    			goods.add(good);
	    		}
	    	}catch(SQLException e){
				throw new RuntimeException(e);
			}finally{
				Conn.release(rs);
				Conn.release(ps);
				Conn.release(conn);
			}
			return goods;
			
		}
		//闄愭椂浼樻儬
				public Collection<goods> getCheapGoods(){
					Collection<goods> goods = new ArrayList<goods>();
					
					try{
			    		String sql = "select * from goods where goodsPrice = '1' limit 4";
			    		
			    		conn = Conn.getConnection();
			    		ps=conn.prepareStatement(sql);
			    		rs = ps.executeQuery();
			    		
			    		while(rs.next()){
			    			goods good = new goods();
			    			good.setGoodsID(rs.getInt("goodsID"));
			    			good.setGoodsNo(rs.getInt("goodsNo"));
			    			good.setGoodsName(rs.getString("goodsName"));
			    			good.setGoodsPrice(rs.getFloat("goodsPrice"));
			    			good.setGoodsimg(rs.getString("goodsimg"));
			    			good.setGoodsIntr(rs.getString("goodsIntr"));
			    			good.setGoodsCount(rs.getInt("goodsCount"));
			    			good.setPictext(rs.getString("pictext"));
			    			good.setGclass(rs.getString("gclass"));
			    			good.setGimg1(rs.getString("gimg1"));
			    			good.setGimg2(rs.getString("gimg2"));
			    			good.setGimg3(rs.getString("gimg3"));
			    			goods.add(good);
			    		}
			    	}catch(SQLException e){
						throw new RuntimeException(e);
					}finally{
						Conn.release(rs);
						Conn.release(ps);
						Conn.release(conn);
					}
					return goods;
					
				}
				//鍒犻櫎鍟嗗搧
				public int deleteGoods(int goodsID) {
					conn = Conn.getConnection();
					int de=0;
					try{
						String sql="delete from goods where goodsID=?";
						ps=conn.prepareStatement(sql);
						ps.setInt(1,goodsID);
						de = ps.executeUpdate();
					}catch(SQLException e){
						throw new RuntimeException(e);
					}finally{
						Conn.release(rs);
						Conn.release(ps);
						Conn.release(conn);
					}
					return de;
				}
				//淇敼鍟嗗搧淇℃伅
				public int updateGoods(goods goods) {
					conn = Conn.getConnection();
					int up=0;
					try{
						String sql="update goods set goodsName=?, goodsPrice=?,goodsIntr=?,goodsimg=?,gclass=?,goodsCount=?,pictext=?,gimg1=?,gimg2=?,gimg3=? where goodsID = ?";
						ps=conn.prepareStatement(sql);
						ps.setString(1,goods.getGoodsName());
						ps.setFloat(2,goods.getGoodsPrice());
						ps.setString(3,goods.getGoodsIntr());
						ps.setString(4,goods.getGoodsimg());
						ps.setString(5,goods.getGclass());
						ps.setInt(6,goods.getGoodsCount());
						ps.setString(7,goods.getPictext());
						ps.setString(8,goods.getGimg1());
						ps.setString(9,goods.getGimg2());
						ps.setString(10,goods.getGimg3());
						ps.setInt(11,goods.getGoodsID());
						up = ps.executeUpdate();
					}catch(SQLException e){
						throw new RuntimeException(e);
					}finally{
						Conn.release(rs);
						Conn.release(ps);
						Conn.release(conn);
					}
					return up;
				}
				//鍔犲噺搴撳瓨1
				public goods deleteCount(int goodsID) {
					goods goods=new goods();
					String sql="select * from goods where goodsID=?";
						try{ 
							conn=Conn.getConnection();
							ps=conn.prepareStatement(sql);
							ps.setInt(1,goodsID);
							
							rs = ps.executeQuery();
							if(rs.next()){
								goods.setGoodsCount(rs.getInt("goodsCount"));
							}else goods=null;
					}catch(SQLException e){
						e.printStackTrace();					
					}finally{
						Conn.release(rs);
						Conn.release(ps);
						Conn.release(conn);
					}
						return goods;
				}
				//鍔犲噺搴撳瓨2
				public int addCount(int goodsCount,int goodsID) {
					
					conn = Conn.getConnection();
					int up=0;
					try{
						String sql="update goods set goodsCount=? where goodsID = ?";
						ps=conn.prepareStatement(sql);
						ps.setInt(1,goodsCount);
						ps.setInt(2,goodsID);
						
						up = ps.executeUpdate();
					}catch(SQLException e){
						throw new RuntimeException(e);
					}finally{
						Conn.release(rs);
						Conn.release(ps);
						Conn.release(conn);
					}
					return up;
				}
				
				//鍟嗗搧鎬绘暟
				public int goodsCount(){
					int goodstotal=0;
					conn = Conn.getConnection();
					try{
						String sql="select count(goodsID) as goodstotal from goods";
						ps=conn.prepareStatement(sql);
						rs = ps.executeQuery();
						if(rs.next()){
							goodstotal = rs.getInt("goodstotal");
						}
						
					}catch(SQLException e){
						throw new RuntimeException(e);
					}finally{
						Conn.release(rs);
						Conn.release(ps);
						Conn.release(conn);
					}
					return goodstotal;
				}
}
