package user_management;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet({"/login"})
public class LoginServlet extends HttpServlet {


    UserDB userDb=new UserDB();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getSession().invalidate();
//        RequestDispatcher dispatcher=request.getRequestDispatcher("/login.jsp");
//        dispatcher.forward(request,response);

        response.sendRedirect("user/login.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String userName=request.getParameter("userName");
        String password=request.getParameter("password");
        String rem=request.getParameter("remember");

        //Setting Cookie for userName in conjuction with 'Remember Me' checkbox in login.jsp
        Cookie cookie = new Cookie("userName", userName);
        boolean isRememberMe=(rem!=null && rem.equals("on"));
        if(!isRememberMe) {
            cookie.setValue("");
            cookie.setMaxAge(0);
        }
        response.addCookie(cookie);

        //check username and password with data in userDB
        if(userDb.checkUser(new User(userName,password))){
            HttpSession session=request.getSession();
            session.setAttribute("userName",userName);
//            RequestDispatcher dispatcher=request.getRequestDispatcher("/home.jsp");
//            dispatcher.forward(request,response);
            response.sendRedirect("user/home.jsp");
        }
        else {
            String loginMessage="Invalid Username or Password!";
            request.getSession().setAttribute("login-message",loginMessage);
//            RequestDispatcher dispatcher=request.getRequestDispatcher("/login.jsp");
//            dispatcher.forward(request,response);
            response.sendRedirect("user/login.jsp");
        }

    }
}
