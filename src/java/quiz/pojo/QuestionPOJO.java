/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz.pojo;

import java.util.List;

public class QuestionPOJO {

    
    private String questionText;
    private int  quizId;
    private int questionId;
    private List<OptionsPOJO> options;
    
    public QuestionPOJO() {
    }

    
    public QuestionPOJO(int quizId ,String questionText) {
        this.questionText = questionText;
        this.quizId= quizId;
    }

    
    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }


   
    public int getQuizId() 
    {
        return quizId;
    }

    public void setQuizId(int quizId)
    {
        this.quizId = quizId;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public List<OptionsPOJO> getOptions() {
        return options;
    }

    public void setOptions(List<OptionsPOJO> options) {
        this.options = options;
    }
    
    
}