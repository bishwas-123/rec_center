package controller.resource;

import com.google.gson.Gson;
import dao.ResourcesDao;
import model.RecResouces;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet({"/updateresources"})
public class UpdateResourcesController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private ResourcesDao resourcesDao;

    Gson mapper = new Gson();
    @Override
    public void init() throws ServletException {
        resourcesDao = resourcesDao.getInstance();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("resources", resourcesDao.getAllResouces());
        RequestDispatcher view = request.getRequestDispatcher("recResouces.jsp");
        view.forward(request,response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String id = request.getParameter("id");
        RecResouces recResouces = mapper.fromJson(request.getParameter("resourcesObj"),RecResouces.class);

        recResouces.setId(Integer.parseInt(id));

        resourcesDao.addResouce(recResouces);

        PrintWriter out = response.getWriter();
        out.println(mapper.toJson(recResouces));



    }
}
