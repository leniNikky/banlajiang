package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import domain.Conn;
import domain.consign;
import domain.goods;
import domain.user;


public class consignDao {
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs =null;
	//添加联系方式
	public boolean insertConsign(consign consign) {
		String sql="insert into consign(consignName,consignAddress,consignPhone,userID) values(?,?,?,?)";
		int i=0;
		try{
			conn = Conn.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,consign.getConsignName());
			pstmt.setString(2,consign.getConsignAddress());
			pstmt.setString(3,consign.getConsignPhone());
			pstmt.setInt(4,consign.getUserID());
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
	//显示联系方式
	public consign findconsign(int userID) {
		consign consign=new consign();
		String sql="select * from consign where userID=?";
			try{ 
				conn=Conn.getConnection();
				pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1,userID);
				rs = pstmt.executeQuery();
				if(rs.next()){
					consign.setConsignID(rs.getInt("consignID"));
					consign.setUserID(rs.getInt("userID"));
					consign.setConsignName(rs.getString("consignName"));
					consign.setConsignAddress(rs.getString("consignAddress"));
					consign.setConsignPhone(rs.getString("consignPhone"));
	    			/*System.out.print(goods.getGoodsName());*/
				}else consign=null;
		}catch(SQLException e){
			e.printStackTrace();					
		}finally{
			Conn.release(rs);
			Conn.release(pstmt);
			Conn.release(conn);
		}
			return consign;
	}
	//修改收货信息
	public int updateConsign(consign consign) {
		int userID=consign.getUserID();
		String consignName=consign.getConsignName();
		String consignAddress=consign.getConsignAddress();
		String consignPhone=consign.getConsignPhone();
		conn = Conn.getConnection();
		int up=0;
		try{
			String sql="update consign set consignName=?, consignAddress=?,consignPhone=? where userID = ?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,consignName);
			pstmt.setString(2,consignAddress);
			pstmt.setString(3,consignPhone);
			pstmt.setInt(4,userID);
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
}
