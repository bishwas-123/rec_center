package login;
import com.google.gson.Gson;
import login.model.User;
import login.model.UserList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/checkuser")
public class UserValidityCheck extends HttpServlet {
    public static String result;
    private UserList userList;
    @Override
    public void init() throws ServletException {
       // Gson mapper = new Gson();
        userList=new UserList();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username=req.getParameter("check");
        PrintWriter out = resp.getWriter();
       // int st=0;
        String str=new String();
        int count=0;

        for(User users:userList.getAllUsers() ){

              if(users.getUsername().startsWith(username.trim())){
                  count=1;
                  break;


              }else{
                  count=0;


              }


        }
        out.print(count);



    }
}
