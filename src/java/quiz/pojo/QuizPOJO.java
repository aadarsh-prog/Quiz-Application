package quiz.pojo;

public class QuizPOJO 
{
    private int quizId;

    private String title ;
    private int timeLimit;
    private String description ;
    
    public QuizPOJO()
    {
        
    }

    public QuizPOJO(String title, String description, int timeLimit) {
        this.title = title;
        this.description = description;
        this.timeLimit = timeLimit;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(int timeLimit) {
        this.timeLimit = timeLimit;
    }
    
    public int getQuizId() {
        return quizId;
    }

    public void setQuizId(int quizId) {
        this.quizId = quizId;
    }
}
