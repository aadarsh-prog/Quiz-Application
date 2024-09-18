import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import quiz.model.QuizDAO;
import quiz.pojo.OptionsPOJO;
import quiz.pojo.QuestionPOJO;
import quiz.pojo.QuizPOJO;

public class CreateQuizServlet extends HttpServlet {

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        PrintWriter out=response.getWriter();
        String title = request.getParameter("quizTitle");
        String description = request.getParameter("description");
        String timeLimitStr = request.getParameter("timeLimit");
  
        
      
        
           // Validate required fields
           if (title == null || title.isEmpty() || description == null || description.isEmpty() || timeLimitStr == null || timeLimitStr.isEmpty()) {
               throw new IllegalArgumentException("Required parameters are missing.");
            }

           // Parse time limit
           int timeLimit;
           try 
           {
                timeLimit = Integer.parseInt(timeLimitStr);
           } catch (Exception e) 
           {
                throw new IllegalArgumentException("Time limit must be a valid integer.");
           }

           //Create QuizPOJO
           QuizPOJO quiz = new QuizPOJO(title, description, timeLimit);

            // Save quiz and get the generated quiz ID
           int quizId = QuizDAO.addQuiz(quiz);
          
        
           int numberOfQuestion=Integer.parseInt(request.getParameter("numberOfQuestions"));
          
            // Handle questions and options
           
          String[] questionTexts=new String[numberOfQuestion];
          for(int i=0;i<numberOfQuestion;i++)
          {
            questionTexts[i] = request.getParameter("questions["+i+"]");
           
          }  

//           if (questionTexts == null) {
//                System.out.println("Question texts is null");
//               out.println("Questions not found!");
//               return;
//           }
//
           for (int i = 0; i < questionTexts.length; i++) 
           {
                String questionText = questionTexts[i];
              
                // Fetch options and correct answer
               int numberOfOptions=Integer.parseInt(request.getParameter("questions["+i+"][optionCount]"));
               String[] options = new String[numberOfOptions];
               String correctOption = request.getParameter("questions["+i+"][correct]");
               
                 for(int j=0;j<numberOfOptions;j++)
                 {
                     options[j]=request.getParameter("questions["+i+"][options]["+j+"]");
             
                 }
                 
              
//                if (options == null || correctOption == null) 
//                {
//                    throw new IllegalArgumentException("Options or correct answer missing for question " + i);
//              }
//
                // Add question to database
                QuestionPOJO question = new QuestionPOJO(quizId, questionText);
                int questionId = QuizDAO.addQuestion(question);
                
                // Add each option to the database
              for (int j = 0; j < options.length; j++) 
                {
                    boolean isCorrect = (j == Integer.parseInt(correctOption));
                    OptionsPOJO op=new OptionsPOJO();
                    op.setOption_text (options[j]);
                    op.setIs_correct(isCorrect);
                    op.setQuestion_id(questionId);
                    QuizDAO.addOptions(op);
               }
            }
           out.println("<html>");
           out.println("<body>");
           out.println("<h1>Link of the Quiz</h1> <br>");
           out.println("<h2><a href='PlayQuiz?quizid="+quizId+"'>http://localhost:8080/Quiz_Application/PlayQuiz?quizid="+quizId+"</a></h2>");
           out.println("</body>");
           out.println("</html>");

//            // Redirect to success page
//           response.sendRedirect("success.jsp");

        } 

    }
