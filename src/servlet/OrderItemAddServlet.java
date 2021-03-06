package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.http.HTTPException;

import bean.OrderItem;
import bean.Product;
import dao.ProductDao;

public class OrderItemAddServlet extends HttpServlet{
    protected void service(HttpServletRequest request,HttpServletResponse response)
            throws ServletException,IOException{
        int pid=Integer.parseInt(request.getParameter("pid"));
        int num=Integer.parseInt(request.getParameter("num"));
        Product p=new ProductDao().getProduct(pid);
        
        OrderItem oi=new OrderItem();
        
        oi.setNum(num);
        oi.setProduct(p);
        
        List<OrderItem> ois=(List<OrderItem>) request.getSession().getAttribute("ois");
        
        if(null == ois){
            ois=new ArrayList<OrderItem>();
            request.getSession().setAttribute("ois", ois);
        }
        
        boolean found=false;
        for(OrderItem orderItem:ois){
            if(orderItem.getProduct().getId()==oi.getProduct().getId()){
                orderItem.setNum(orderItem.getNum()+oi.getNum());
                found=true;
                break;
            }
                
        }
        if(!found)
            ois.add(oi);
        
        response.sendRedirect("/listOrderItem");
          
    }
}
