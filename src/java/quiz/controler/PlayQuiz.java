package quiz.controler;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import quiz.model.QuizDAO;
import quiz.pojo.QuizPOJO;

public class PlayQuiz extends HttpServlet {

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
        
            QuizPOJO quiz = null;

            try {
                // Check if quizid is passed in the request and is valid
                String quizIdParam = request.getParameter("quizid");
                if (quizIdParam != null) 
                {
                   int quizId = Integer.parseInt(quizIdParam);
                    quiz = QuizDAO.getQuiz(quizId);
                    if(quiz==null)
                    {
                      out.println("Invalid quiz ID");  
                      return;
                    }
                    request.setAttribute("quiz", quiz);
                     request.getRequestDispatcher("PlayQuiz.jsp").forward(request, response);
                } else {
                    out.println("Quiz ID not provided.");
                }
            } catch (NumberFormatException e) {
                out.println("Invalid quiz ID format.");
            }

           
    }
    

   
}
