package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.http.HTTPException;

public class OrderItemListServlet extends HttpServlet{
    protected void service(HttpServletRequest request,HttpServletResponse response)throws
    IOException, ServletException{
        request.getRequestDispatcher("listOrderItem.jsp").forward(request, response);
    }

}
