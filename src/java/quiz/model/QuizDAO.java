package quiz.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import quiz.db.DbConnection;
import quiz.pojo.OptionsPOJO;
import quiz.pojo.QuestionPOJO;
import quiz.pojo.QuizPOJO;

public class QuizDAO 
{
    public static int addQuiz(QuizPOJO q)
    {
         Connection con = DbConnection.getConnection();
        PreparedStatement ps = null;
        int id=0;
    
       
        try {
           String query = "INSERT INTO  Quizzes (quiz_title, description, time_limit) VALUES (?, ?, ?)";
            ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, q.getTitle());
            ps.setString(2, q.getDescription());
            ps.setInt(3, q.getTimeLimit());
            ps.executeUpdate();
            
            // Retrieve the generated quiz_id
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next())
            {
                
              id=rs.getInt(1);
            }
            
        }
        catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                if (ps != null) ps.close();
                DbConnection.closeConnection();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
       
       return id; 
    }
    public static int addQuestion(QuestionPOJO q)
    {
         Connection con = DbConnection.getConnection();
        PreparedStatement ps = null;
        int id=0;
    
       
        try {
           String questionSql = "INSERT INTO Questions (quiz_id, question_text) VALUES (?, ?)";
                ps = con.prepareStatement(questionSql, Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1, q.getQuizId());
                ps.setString(2, q.getQuestionText());
                ps.executeUpdate();
            
            // Retrieve the generated quiz_id
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next())
            {
              id=rs.getInt(1);
            }
            
        }
        catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                if (ps != null) ps.close();
                DbConnection.closeConnection();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
          System.out.println(id);
       return id; 
    }
     public static void addOptions(OptionsPOJO op)
    {
         Connection con = DbConnection.getConnection();
        PreparedStatement ps = null;
        int id=0;
    
       
        try {
           String questionSql = "INSERT INTO Options (question_id, option_text, is_correct) VALUES (?, ?, ?)";;
                ps = con.prepareStatement(questionSql, Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1,op.getQuestion_id());
                ps.setString(2,op.getOption_text());
                ps.setBoolean(3,op.getIs_correct());
                ps.executeUpdate();
            
            
            
        }
        catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                if (ps != null) ps.close();
                DbConnection.closeConnection();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
       
    }
     public static QuizPOJO getQuiz(int quizId)
     {
        Connection con = DbConnection.getConnection();
        Statement st=null;
        QuizPOJO quiz=null;
        try {
          st = con.createStatement();
          String query = "select * from  Quizzes where quiz_id='"+quizId+"'";
           
            // Retrieve the generated quiz_id
            ResultSet rs =   st.executeQuery(query);
            if(rs.next())
            {
             quiz=new QuizPOJO();
             quiz.setQuizId(quizId);
             quiz.setTitle(rs.getString(2));
             quiz.setDescription(rs.getString(3));
             quiz.setTimeLimit(rs.getInt(4));
            }
            
        }
        catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                if (st != null) st.close();
                DbConnection.closeConnection();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        
       return quiz; 
         
     }
     public static List<QuestionPOJO> getQuestions(int quizId) {
    Connection con = DbConnection.getConnection();
    Statement st = null;
    ResultSet rs = null;
    ArrayList<QuestionPOJO> questionsList = new ArrayList<>();
    
    try {
        st = con.createStatement();
        String query = "SELECT * FROM Questions WHERE quiz_id='" + quizId + "'";
        
        // Retrieve the questions for the given quiz_id
        rs = st.executeQuery(query);
        
        while (rs.next()) {
            QuestionPOJO question = new QuestionPOJO();
            question.setQuestionId(rs.getInt("question_id"));
            question.setQuestionText(rs.getString("question_text"));
            
            // Fetch options for this question
            List<OptionsPOJO> options = getOptionsForQuestion(rs.getInt("question_id"));
            question.setOptions(options);
            System.out.print("sssss");
            questionsList.add(question);
        }
    } catch (SQLException e) {
        System.out.println(e);
    } finally {
        try {
            if (rs != null) rs.close();
            if (st != null) st.close();
            DbConnection.closeConnection();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    return questionsList;
}

      public static List<OptionsPOJO> getOptionsForQuestion(int questionId) {
    Connection con = DbConnection.getConnection();
    PreparedStatement ps = null;
    ResultSet rs = null;
    ArrayList<OptionsPOJO> optionsList = new ArrayList<>();
    
    try {
        String query = "SELECT * FROM Options WHERE question_id = ?";
        ps = con.prepareStatement(query);
        ps.setInt(1, questionId);
        
        rs = ps.executeQuery();
        
        while (rs.next()) {
            OptionsPOJO option = new OptionsPOJO();
            
            option.setOption_text(rs.getString("option_text"));
            option.setIs_correct(rs.getBoolean("is_correct"));
            optionsList.add(option);
        }
    } catch (SQLException e) {
        System.out.println(e);
    } finally {
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    return optionsList;
}
     

}
