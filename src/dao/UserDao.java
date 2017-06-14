package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.*;
public class UserDao {
    public static void main(String[] args) throws SQLException  {
        System.out.println(new UserDao().getUser("cat", "dhx1234").getId());
    }
    
    public User getUser(String name,String password) throws SQLException{
        User result=null;
            try{
                Class.forName("com.mysql.jdbc.Driver");
                String url="jdbc:mysql://localhost:3306/cart?characterEncoding=utf-8";
                Connection con=DriverManager.getConnection(url,"root","dhx123");
                String sql="select * from User where name=? and password=?";
                PreparedStatement ps=con.prepareStatement(sql);
                ps.setString(1, name);
                ps.setString(2, password);
                ResultSet rs=ps.executeQuery();
                while(rs.next()){
                    result = new User();
                    result.setId(rs.getInt(1));
                    result.setName(name);
                    result.setPassword(password);                    
                }
                ps.close();
                con.close();
            }catch(ClassNotFoundException e){
                e.printStackTrace();
            }catch(SQLException s){
                s.printStackTrace();
            }
            return result;
        }  
}
