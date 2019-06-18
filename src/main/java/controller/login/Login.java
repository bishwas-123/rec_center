package controller.login;

import dao.UserDAO;
import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/admin")
public class Login extends HttpServlet {
    private UserDAO userDAO = UserDAO.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect(req.getContextPath()+"/views/login.jsp");
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email").trim();
        String password = req.getParameter("password").trim();

        if (!email.isEmpty() && !password.isEmpty()) {
            if (userDAO.checkUser(new User(email,password))) {
                if (req.getParameter("remember")!= null) {
                    Cookie user = new Cookie("uname", email);
                    user.setMaxAge(60*60*24*30);
                    resp.addCookie(user);
                    String remember = req.getParameter("remember").trim();
                    Cookie rem = new Cookie("remember", remember);
                    rem.setMaxAge(60*60*24*30);
                    resp.addCookie(rem);
                }
                else{
                    Cookie user = new Cookie("uname", null);
                    user.setMaxAge(0);
                    resp.addCookie(user);
                    Cookie rem = new Cookie("remember", null);
                    rem.setMaxAge(0);
                    resp.addCookie(rem);
                }
                HttpSession httpSession = req.getSession();
                //   httpSession.setAttribute("user", email.trim());
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/admin/users.jsp");
                requestDispatcher.forward(req, resp);
            }
            else{
                //mismatch
                req.getSession().setAttribute("msg", "Authentication failure. Incorrect Credentials !");
                resp.sendRedirect("/views/login.jsp");
            }
        }
        else{
            req.getSession().setAttribute("msg", "Username and Password are required fields.");
            resp.sendRedirect("/views/login.jsp");

        }
    }
}
