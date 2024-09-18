<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>

<%@page import="quiz.pojo.QuestionPOJO"%>
<%@page import="quiz.pojo.OptionsPOJO"%>

<%
    int timeLimit = Integer.parseInt(request.getParameter("timeLimit"));
    ArrayList<QuestionPOJO> allQuestions = (ArrayList<QuestionPOJO>) request.getAttribute("questions");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Quiz App</title>
    <link rel="stylesheet" href="xyz.css">
</head>
 
<body>
     <div class="app">
        <!-- Container for title and timer -->
        <div class="title-timer">
            <h1 id="title">Simple Quiz</h1>
            <div id="timer"></div> <!-- Timer element -->
        </div>
        
        <div class="quiz">
            <h2 id="question">Question goes here</h2>
            <div id="answer-buttons"></div>
            <button id="next-btn">Next</button>
        </div>

        <script>
            let timeLimit = <%= timeLimit %>; 
             
            const questions = 
                    [
                <% 
                    for (QuestionPOJO Question: allQuestions) 
                    {
                      
                        List<OptionsPOJO> options = Question.getOptions(); // Assuming the question has a method getOptions()
                %>
                        {
                    question: "<%= Question.getQuestionText() %>",
                    answers: 
                    [
                        <% for (OptionsPOJO option: options) 
                        {
                            
                        %>
                        {
                            text: "<%= option.getOption_text() %>",
                            correct: <%= option.getIs_correct() %> // Assuming there's a method `isCorrect()` that returns true/false
                        },
                      
                        <% } %>
                    ],
                },
               
                <% } %>
            ];
            
      

        </script>

         <script src="script.js"></script>
    </div>
</body>
</html>
