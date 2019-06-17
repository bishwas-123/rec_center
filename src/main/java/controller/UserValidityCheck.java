package controller;

import dao.UserDAO;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/checkuser")
public class UserValidityCheck extends HttpServlet {
    private UserDAO userList;
    @Override
    public void init() throws ServletException {
       // Gson mapper = new Gson();
        userList = UserDAO.getInstance();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName=req.getParameter("userName");
        boolean matching=false;
        PrintWriter out = resp.getWriter();
        for(User user:userList.getUsers()){
            if (user.getUserName().matches(userName))
                matching=true;
        }
        out.print(matching);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email=req.getParameter("check");
        PrintWriter out = resp.getWriter();
        int count=0;
        for(User user:userList.getUsers()){
              if(user.getEmail().startsWith(email.trim())){
                  count=1;
                  break;
              }else{
                  count=0;
              }
        }
        out.print(count);
    }
}
