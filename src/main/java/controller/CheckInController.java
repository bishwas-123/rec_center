package controller;

import dao.CheckinDAO;
import dao.UserDAO;
import com.google.gson.Gson;
import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet({"/checkin"})
public class CheckInController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private UserDAO userDAO;
    //private CheckinDAO checkinDAO;
    private Gson mapper = new Gson();

    @Override
    public void init() throws ServletException {
        userDAO=UserDAO.getInstance();
        //checkinDAO=CheckinDAO.getInstance();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("users", userDAO.getUsers());
        //request.setAttribute("checkin",checkinDAO);
        RequestDispatcher view = request.getRequestDispatcher("checkin.jsp");
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

//        String jsonSting = request.getParameter("userId");
//        User user = mapper.fromJson(request.getParameter("user"), User.class);
//        user.setId(dao.genId());
//        userDAO.addUser(user);

        Integer userId=Integer.parseInt(request.getParameter("Id"));
        userDAO.getUserById(userId).check();
        PrintWriter out = response.getWriter();

        out.print(mapper.toJson(userDAO.getUsers()));
    }

}
