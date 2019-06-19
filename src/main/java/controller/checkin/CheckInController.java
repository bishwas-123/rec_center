package controller.checkin;

import dao.CheckInDAO;
import dao.UserDAO;
import model.CheckInUser;
import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/checkin")
public class CheckInController extends HttpServlet {

    @Override
    public void init() throws ServletException {
    // UserDAO userDAO=UserDAO.getInstance();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // super.doGet(req, resp);
    }
    protected void checkIn(int id,HttpServletRequest req,HttpServletResponse resp)throws ServletException, IOException {
        LocalDate current_date=LocalDate.now();
        LocalTime current_time=LocalTime.now();
        CheckInUser inUser=new CheckInUser(id,current_date,current_time);
        CheckInDAO.getInstance().addUser(inUser);
   List<User> data=CheckInDAO.getInstance().getAllCheckInUsers();
   String name=data.stream().filter(x->x.getUserId()==id).map(x->x.getFullName()).collect(Collectors.joining());
        req.getSession().setAttribute("users",data );
        req.getSession().setAttribute("duration","");
        req.getSession().setAttribute("msg", "Welcome  "+name+", CheckIn successful !");
        resp.sendRedirect(req.getContextPath()+"/views/admin/users.jsp");
    }
    protected void checkout(int id,HttpServletRequest req,HttpServletResponse resp)throws ServletException, IOException {
        LocalTime current_time = LocalTime.now();
        List<CheckInUser> users =CheckInDAO.getInstance().getUserById(id);
        CheckInUser user=users.get(0);

        long elapsedMinutes = Duration.between(user.getCheckInTime(), current_time).toMinutes();
        CheckInDAO.getInstance().deleteUser(user);
        long hour=0;
        long minutes=0;
        if(elapsedMinutes>60){
            hour=elapsedMinutes/60;
            minutes=elapsedMinutes%60;
            req.getSession().setAttribute("duration","<span>Total Duration: "+hour+" hours And "+minutes+" Minutes");
        }else{
            minutes=elapsedMinutes;
            req.getSession().setAttribute("duration","<span>Total Duration: "+minutes+" Minutes</span>");
        }
        req.getSession().setAttribute("msg", "<span style='color:#B72048;'>Thank you, Checkout successful...Have a good Day!</span>");
        req.getSession().setAttribute("users", CheckInDAO.getInstance().getAllCheckInUsers());
        resp.sendRedirect(req.getContextPath()+"/views/admin/users.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String userId=req.getParameter("userId").trim();
          if(userId==null){
              req.getSession().setAttribute("msg", "User id is Mandatory !");
              resp.sendRedirect(req.getContextPath()+"/views/admin/users.jsp");
              return;
          }
         int id=Integer.parseInt(userId);
        PrintWriter out=resp.getWriter();
        if(UserDAO.getInstance().getUserById(id).isEmpty()){
            req.getSession().setAttribute("msg", "User Not Found !");
            req.getSession().setAttribute("users", CheckInDAO.getInstance().getAllCheckInUsers());
           resp.sendRedirect(req.getContextPath()+"/views/admin/users.jsp");
        }else{
                if(CheckInDAO.getInstance().getUserById(id).isEmpty()){
                     checkIn(id,req,resp);
                }
                else{
                    checkout(id,req,resp);
                }

        }





    }


}
