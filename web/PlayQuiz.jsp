<%@page import="java.io.PrintWriter"%>
<%@page import="quiz.pojo.QuizPOJO"%>
<%@page import="quiz.model.QuizDAO"%>

<!DOCTYPE html>
<html>
<head>
 <link rel="stylesheet"  href="abc.css">

</head>
<body>
    <h2>Available Quizzes</h2>
    <table border="1">
        <tr>
            <th>Title</th>
            <th>Description</th>
            <th>Time Limit</th>
            <th>Action</th>
        </tr>
        <%
            
            QuizPOJO quiz =(QuizPOJO) request.getAttribute("quiz");

           
        %>
                <tr>
                    <td><%= quiz.getTitle() %></td>
                    <td><%= quiz.getDescription() %></td>
                    <td><%= quiz.getTimeLimit() %> minutes</td>
                    <td><a href="TakeQuiz?quizId=<%=quiz.getQuizId()%>&timeLimit=<%= quiz.getTimeLimit() %>">Take Quiz</a></td>
                </tr>
       
    </table>
</body>
</html>
`