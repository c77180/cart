package servlet;

import java.io.IOError;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Order;
import bean.OrderItem;
import bean.User;
import dao.OrderDao;
import dao.OrderItemDao;

public class OrderCreatServlet extends HttpServlet {
	protected void service(HttpServletRequest request,HttpServletResponse response)throws
		ServletException,IOException{
		User user=(User)request.getSession().getAttribute("user");
		if(null==user){
			response.sendRedirect("repeatInput.jsp");
			return ;
		}
		Order order=new Order();
		order.setUser(user);
		
		new OrderDao().insert(order);
		
		List<OrderItem> ois=(List<OrderItem>) request.getSession().getAttribute("ois");
		
		for(OrderItem oIt:ois){
			oIt.setOrder(order);
			new OrderItemDao().insert(oIt);
		}
		ois.clear();
		
		response.setContentType("text/html; charset=utf8");
		response.getWriter().println("订单创建成功");
		
		
	}

}
