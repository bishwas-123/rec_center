//package filter;
//
//import dao.UserDAO;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//
//@WebFilter(
//        filterName = "authenticationFilter",
//        urlPatterns = "/*"
////        servletNames = {"LoginServlet"}
//)
//public class PageFilter implements Filter {
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//    }
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//        HttpSession currentUserSession = ((HttpServletRequest) request).getSession();
//        UserDAO userDAO=UserDAO.getInstance();
//        String email=currentUserSession.getAttribute("user")==null?"":currentUserSession.getAttribute("user").toString();
//         String currentRequest=((HttpServletRequest) request).getContextPath();
//         String currentUrl=((HttpServletRequest) request).getRequestURI();
//         boolean isHomeRequest= currentUrl.equals(currentRequest+"/") || currentUrl.equals(currentRequest+"/checkuser");
//         boolean isLoginRequest=currentUrl.equals(currentRequest+"/admin") || currentUrl.equals(currentRequest+"/views/login.jsp");
//        boolean isSignUpRequest=currentUrl.equals(currentRequest+"/signup") || currentUrl.equals(currentRequest+"/signup.jsp");
//        boolean isValidUser=email!="" && userDAO.getUsers().stream().filter(user -> user.getEmail().equals(email)).count()>0;
//       //  boolean isStaticResource = currentUrl.startsWith("/resources/")|| currentUrl.startsWith("/assets/");
//         boolean isLoogedIn=((HttpServletRequest) request).getSession().getAttribute("user")!=null;
//        String path = ((HttpServletRequest) request).getRequestURI();
//        boolean isResource=path.startsWith("/resources/");
//        boolean isStaticResource =((HttpServletRequest) request).getRequestURI().startsWith("/resources/");
//         if (isResource|| isHomeRequest || isLoginRequest || isSignUpRequest || isValidUser || isStaticResource || isLoogedIn)
//            chain.doFilter(request, response);
//        else
//        {
//            HttpServletResponse resp=(HttpServletResponse)response;
//           // resp.sendError(HttpServletResponse.SC_UNAUTHORIZED);
//
//            ((HttpServletResponse) response).sendRedirect("/admin");
//        }
//    }
//    @Override
//    public void destroy() {
//
//    }
//}
