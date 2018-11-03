package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import domain.Conn;

public class visitedDao {
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs =null;
	//网站访问次数
	public int visitedCount(){
		int visitedcount=0;
		conn = Conn.getConnection();
		try{
			String sql="select visitedCount from visited";
			pstmt=conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()){
				visitedcount = rs.getInt("visitedcount");
			}
			
		}catch(SQLException e){
			throw new RuntimeException(e);
		}finally{
			Conn.release(rs);
			Conn.release(pstmt);
			Conn.release(conn);
		}
		return visitedcount;
	}
	//更新访问数
	public int updateCount(int count) {
		conn = Conn.getConnection();
		int a = 0;
		try{
    		String sql = "update visited set visitedCount = ?";
    		pstmt = conn.prepareStatement(sql);
    		pstmt.setInt(1, count);
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
}
