package servlet;

import bean.Product;
import dao.ProductDao;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.http.HTTPException;

public class ProductlistServlet extends HttpServlet{
    protected void service(HttpServletRequest request,HttpServletResponse response)
               throws ServletException,IOException{
        List<Product> products=new ProductDao().listProduct();
        request.setAttribute("products",products);
        request.getRequestDispatcher("listProduct.jsp").forward(request, response);     
    }
   
    
}
