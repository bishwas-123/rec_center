package controller.checkout;

import dao.CheckInDAO;
import dao.UserDAO;
import model.CheckInUser;

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
import java.util.Date;
import java.util.List;

@WebServlet("/checkout")
public class CheckoutController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = req.getParameter("userId").trim();
        int id = Integer.parseInt(userId);

        // PrintWriter out=resp.getWriter();
        if (UserDAO.getInstance().getUserById(id).isEmpty()) {
            req.getSession().setAttribute("msg", "Wrong User !");
            resp.sendRedirect(req.getContextPath() + "/views/admin/users.jsp");
        } else {
            if (CheckInDAO.getInstance().getUserById(id).isEmpty()) {
                req.getSession().setAttribute("msg", "User already checkedOut !");
                resp.sendRedirect(req.getContextPath() + "/views/admin/users.jsp");
            } else {
//                LocalDate current_date = LocalDate.now();
//                LocalTime current_time = LocalTime.now();
//               List<CheckInUser> users =CheckInDAO.getInstance().getUserById(id);
//                CheckInUser user=users.get(0);
//                SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
//                long elapsedMinutes = Duration.between(user.getCheckInTime(), current_time).toMinutes();
//              long hour=0;
//                long minutes=0;
//                if(elapsedMinutes>60){
//                     hour=elapsedMinutes/60;
//                     minutes=elapsedMinutes%60;
//                    req.getSession().setAttribute("duration",hour+" And "+minutes);
//                }else{
//                    minutes=elapsedMinutes;
//                    req.getSession().setAttribute("duration",minutes);
//                }
//                req.getSession().setAttribute("msg", "Thank you! checkout successful !");
//                resp.sendRedirect(req.getContextPath()+"/views/admin/users.jsp");
            }

        }
    }
}
