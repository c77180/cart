package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.User;
public class UserDao {
	public static void main(String[] args) {
		System.out.println(new UserDao().getUser("tom", "123").getName());
	}
	public User getUser(String name,String password){
		User user=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/cart?characterEncoding=utf-8";
			String Sqlname="root";
			String Sqlpassword="dhx123";
			Connection con=DriverManager.getConnection(url,Sqlname,Sqlpassword);
			String sql="select * from user where name= ? and password=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				user=new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
			}
			ps.close();
			con.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return user;
	}
	
}
