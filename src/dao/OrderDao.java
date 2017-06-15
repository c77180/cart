package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.Order;

public class OrderDao {
	public void insert(Order od){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/cart?characterEncoding=utf-8";
			Connection con=DriverManager.getConnection(url, "root", "dhx123");
			String sql="insert into order_ values(null,?)";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, od.getUser().getId());
			ps.execute();
			
			ResultSet rs=ps.getGeneratedKeys();
			while(rs.next()){
				int id=rs.getInt(1);
				od.setId(id);
			}
			ps.close();
			con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
