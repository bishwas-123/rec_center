package controller.resource;

import com.google.gson.Gson;
import dao.ResourcesDao;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/resourceDelete")
public class DeleteResourcesController extends HttpServlet {

    private ResourcesDao dao;

    Gson mapper = new Gson();
    @Override
    public void init() throws ServletException {
//        dao = new MemberDao();
        dao = ResourcesDao.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id= Integer.parseInt(req.getParameter("id"));

        System.out.println(dao.toString());

        //dao.deleteMember(id);
        dao.deleteResoucres(id);
    }
}
