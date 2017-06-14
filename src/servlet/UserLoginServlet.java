package servlet;

import java.io.IOException;
import java.sql.SQLException;

import dao.UserDao;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.*;
public class UserLoginServlet extends HttpServlet {
    public void service(HttpServletRequest request,HttpServletResponse response)throws
        ServletException,IOException{
        String name=request.getParameter("name");
        String password =request.getParameter("password");
        try {
            User user=new UserDao().getUser(name, password);
            if(null != user){
                request.getSession().setAttribute("user", user);
                response.sendRedirect("/listProduct");
            }
            else
            {
               System.out.println("密码不正确，请重新输入");
               response.sendRedirect("/repeatInput.jsp");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        
    }
}
