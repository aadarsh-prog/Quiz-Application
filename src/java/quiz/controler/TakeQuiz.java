package quiz.controler;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import quiz.model.QuizDAO;
import quiz.pojo.QuestionPOJO;


public class TakeQuiz extends HttpServlet 
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
        
     PrintWriter out = response.getWriter();
     int quizId = Integer.parseInt(request.getParameter("quizId"));
     int timeLimit=Integer.parseInt(request.getParameter("timeLimit"));
      ArrayList<QuestionPOJO> questions=(ArrayList<QuestionPOJO>)QuizDAO.getQuestions(quizId);
      
       request.setAttribute("questions", questions);      
        request.setAttribute("timeLimit", timeLimit);
     
     request.getRequestDispatcher("TakeQuiz.jsp").forward(request, response);
      
                
    }
}
