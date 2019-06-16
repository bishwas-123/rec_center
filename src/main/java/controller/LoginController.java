package controller;

import model.User;
import dao.UserDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet({"/login"})
public class LoginController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private UserDAO userDAO = UserDAO.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getSession().invalidate();
//        RequestDispatcher dispatcher=request.getRequestDispatcher("login.jsp");
//        dispatcher.forward(request,response);

        response.sendRedirect("login.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email=request.getParameter("email");
        String password=request.getParameter("password");
        String rem=request.getParameter("remember");

        //Setting Cookie for userName in conjuction with 'Remember Me' checkbox in login.jsp
        Cookie cookie = new Cookie("email", email);
        boolean isRememberMe=(rem!=null && rem.equals("on"));
        if(!isRememberMe) {
            cookie.setValue("");
            cookie.setMaxAge(0);
        }
        response.addCookie(cookie);

        //check username and password with data in userDB
        if(userDAO.checkUser(new User(email,password))){
            HttpSession session=request.getSession();
            session.setAttribute("email",email);
//            RequestDispatcher dispatcher=request.getRequestDispatcher("home.jsp");
//            dispatcher.forward(request,response);
            //response.sendRedirect("home.jsp");
            response.sendRedirect("users.html");
        }
        else {
            String loginMessage="Invalid Email or Password!";
            request.getSession().setAttribute("login-message",loginMessage);
            RequestDispatcher dispatcher=request.getRequestDispatcher("login.jsp");
            dispatcher.forward(request,response);
//            response.sendRedirect("login.jsp");
        }

    }
}
