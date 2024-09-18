package quiz.pojo;

public class OptionsPOJO 
{
  private  int question_id;
  private String option_text;
  private  boolean is_correct;
  
  public OptionsPOJO(){}
    public OptionsPOJO(int question_id, String option_text, boolean is_correct) {
        this.question_id = question_id;
        this.option_text = option_text;
        this.is_correct = is_correct;
    }
  
  
    public int getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(int question_id) {
        this.question_id = question_id;
    }

    public String getOption_text() {
        return option_text;
    }

    public void setOption_text(String option_text) {
        this.option_text = option_text;
    }

    public boolean getIs_correct() {
        return is_correct;
    }

    public void setIs_correct(boolean is_correct) {
        this.is_correct = is_correct;
    }
    
}
