package login.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/admin")
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect(req.getContextPath()+"/views/login.jsp");
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("username");
        String pass = req.getParameter("password");
        PrintWriter out = resp.getWriter();
       // out.print("good");

        if (!userName.trim().isEmpty() && !pass.trim().isEmpty()) {
            boolean success = Auth.authenticate(userName.trim(), pass.trim());
            if (success) {
                if (req.getParameter("remember") != null) {

                    Cookie user = new Cookie("user", userName.trim());
                    user.setMaxAge(60*60*24*30);
                    resp.addCookie(user);

                    String remember = req.getParameter("remember");
                    Cookie rem = new Cookie("remember", remember);
                    rem.setMaxAge(60*60*24*30);
                    resp.addCookie(rem);

                }
                else{
                    Cookie user = new Cookie("user", null);
                    user.setMaxAge(0);
                    resp.addCookie(user);
                    Cookie rem = new Cookie("remember", null);
                    rem.setMaxAge(0);
                    resp.addCookie(rem);
                }
                HttpSession httpSession = req.getSession();
                httpSession.setAttribute("user", userName.trim());
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/admin/welcome.jsp");
                requestDispatcher.forward(req, resp);
            }
            else{
                //mismatch

                req.getSession().setAttribute("msg", "Authentication failure. Incorrect Credentials !");
                resp.sendRedirect(req.getContextPath()+"/views/login.jsp");

            }

        }
        else{
            req.getSession().setAttribute("msg", "Username and Password are required fields.");
            resp.sendRedirect(req.getContextPath()+"/views/login.jsp");

        }
    }
}
