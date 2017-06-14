package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



import bean.Product;
public class ProductDao {
    public static void main(String[] args) {
        System.out.println(new ProductDao().getProduct(1).getName());
    }
    public Product getProduct(int id){
        Product result=null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/cart?characterEncoding=utf-8";
            Connection con=DriverManager.getConnection(url,"root","dhx123");
            
            String sql="select * from product order by id =?";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet res=ps.executeQuery();
            while(res.next()){   
                result=new Product();
                result.setId(id);
                String name= res.getString(2);
                float price =res.getFloat(3);
                
                result.setName(name);
                result.setPrice(price);
            }
            ps.close();
            con.close();
           
        }catch(SQLException e){
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    public  List<Product> listProduct(){
        
        List<Product> products= new ArrayList<Product>();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/cart?characterEncoding=utf-8";
            Connection con=DriverManager.getConnection(url,"root","dhx123");
            
            String sql="select * from product order by id desc";
//            Statement sta=con.createStatement();
//            ResultSet res=sta.executeQuery(sql);
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet res=ps.executeQuery();
            while(res.next()){
               Product pro=new Product();
               int id=res.getInt(1);
               String name=res.getString(2);
               float price=res.getFloat(3);
               
               pro.setId(id);
               pro.setName(name);
               pro.setPrice(price);
               products.add(pro);
            }
            
            res.close();
            ps.close();
            con.close();
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return products;
    }
}
