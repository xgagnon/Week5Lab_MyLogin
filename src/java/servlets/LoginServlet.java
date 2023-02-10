/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.AccountService;
import models.User;

/**
 *
 * @author Xavier
 */
public class LoginServlet extends HttpServlet {
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        String logout = request.getParameter("logout");
        
        User user = (User) session.getAttribute("user");
        
        if(logout != null) {
            session.invalidate();
            request.setAttribute("message", "You have successfully logged out");
            
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp")
                .forward(request,response);
            return;
        }
        
        if(user != null) {
            response.sendRedirect("home");
            return;
        }
        
        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp")
                .forward(request,response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        if(username == null || password ==  null) {
            return;
        }
        
        AccountService accService = new AccountService();
        User user = accService.login(username,password);
        
        if(user != null) {
            session.setAttribute("user", user);
        }
        else {
            request.setAttribute("message","Invalid login credentials");
            
            request.setAttribute("username", username);
            request.setAttribute("password", password);
            
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp")
                .forward(request,response);
            
            return;
        }
        
        response.sendRedirect("home");
    }

}
