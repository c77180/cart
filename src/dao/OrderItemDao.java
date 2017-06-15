package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.Order;
import bean.OrderItem;

public class OrderItemDao {
	public void insert(OrderItem orderItem){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/cart?characterEncoding=utf-8";
			Connection con=DriverManager.getConnection(url, "root", "dhx123");
			String sql="insert into orderitem values(null,?,?,?)";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, orderItem.getProduct().getId());
			ps.setInt(2, orderItem.getNum());
			ps.setInt(3, orderItem.getOrder().getId());
			
			ps.execute();
			ps.close();
			con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
