package quiz.controler;



import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import quiz.model.UserDAO;
import quiz.pojo.UserPojo;
public class LoginCon extends HttpServlet 
{

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        PrintWriter out=response.getWriter();
      String uname=request.getParameter("u1");
      String upass=request.getParameter("u2");
      
      
      UserPojo user=new UserPojo();
      user.setUname(uname);
      user.setUpass(upass);
      boolean status=  UserDAO.validateUser(user);
      if(status)
      {
          response.sendRedirect("home.jsp");
      }
      else
      {
      response.sendRedirect("login.jsp");
          
      }
      
      
    }
    

}