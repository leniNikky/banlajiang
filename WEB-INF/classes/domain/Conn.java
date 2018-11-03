package domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conn {
	public static Connection getConnection(){
		Connection con=null;	
		String drive = "com.mysql.jdbc.Driver";	
//		String url = "jdbc:mysql://localhost:3306/sichuanchili?useUnicode=true&amp;characterEncoding=UTF-8";    
		String url = "jdbc:mysql://localhost:3306/sichuanchili?characterEncoding=UTF-8";    
		String username="root";
		String password="";		
		try{
			Class.forName(drive);
			con = DriverManager.getConnection(url,username,password);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return con;
	}
	public static void release(Connection conn){
		      if(conn!=null)
		      try{
				conn.close();
			   }catch(SQLException e){
				e.printStackTrace();
			   }
	}	
	public static void release(PreparedStatement pstmt){		
	  if(pstmt!=null)
	  try{
	  pstmt.close();
	  }catch(SQLException e){
			e.printStackTrace();
		}	  
   }   
   public static void release(ResultSet rs){		
		 if(rs!=null)
		 try{
		 rs.close();
		 }catch(SQLException e){
			   e.printStackTrace();
		   }
   }
}
