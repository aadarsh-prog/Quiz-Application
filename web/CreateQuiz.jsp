<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
    <title>Create Quiz</title>
    <script>
        function addQuestion() {
            var container = document.getElementById('questionsContainer');
            var index = container.children.length;
            
            var div = document.createElement('div');
            div.innerHTML = `
                <h3>Question ${index + 1}</h3>
                <label for="questionText${index}">Question Text:</label>
                <input type="text" id="questionText${index}" name="questions[${index}][text]" required><br><br>
                <label for="option1${index}">Option 1:</label>
                <input type="text" id="option1${index}" name="questions[${index}][options][0]" required>
                <label for="isCorrect1${index}">Correct?</label>
                <input type="radio" id="isCorrect1${index}" name="questions[${index}][correct]" value="0"><br><br>
                <label for="option2${index}">Option 2:</label>
                <input type="text" id="option2${index}" name="questions[${index}][options][1]" required>
                <label for="isCorrect2${index}">Correct?</label>
                <input type="radio" id="isCorrect2${index}" name="questions[${index}][correct]" value="1"><br><br>
            `;
            container.appendChild(div);
        }
    </script>
</head>
<body>
    <form action="CreateQuizServlet" method="post">
        <h2>Create a New Quiz</h2>
        <label for="quizTitle">Quiz Title:</label>
        <input type="text" id="quizTitle" name="quizTitle" required><br><br>
        
        <label for="description">Description:</label>
        <textarea id="description" name="description" required></textarea><br><br>
        
        <label for="timeLimit">Time Limit (in minutes):</label>
        <input type="number" id="timeLimit" name="timeLimit" required><br><br>

        <div id="questionsContainer">
            <!-- Dynamic questions will be added here -->
        </div>
        <button type="button" onclick="addQuestion()">Add Question</button><br><br>

        <button type="submit">Create Quiz</button>
    </form>
</body>
</html>
