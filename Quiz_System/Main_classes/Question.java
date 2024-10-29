package Quiz_System.Main_classes;

public class Question {
    private String Question_title, Question_type, Question_answer;
    private String[] Question_options;
    private int Question_numberOfOptions;

    Question(){
        this.Question_numberOfOptions = 4;  // Default number of options
        this.Question_title = "";
        this.Question_type = "";
        this.Question_answer = "";
        this.Question_options = new String[this.Question_numberOfOptions];
    }

    Question(String Question_title, String Question_type, String Question_answer,int Question_numberOfOptions, String[] Question_options){
        this.setQuestion_numberOfOptions(Question_numberOfOptions);  
        this.setQuestion_title(Question_title);
        this.setQuestion_type(Question_type);
        this.setQuestion_answer(Question_answer);
        this.setQuestion_options(Question_options);
    }

    // getters
    public String getQuestion_title(){
        return this.Question_title;
    }

    public String getQuestion_type(){
        return this.Question_type;
    }

    public String getQuestion_answer(){
        return this.Question_answer;
    }

    public String[] getQuestion_options(){
        return this.Question_options;
    }

    public int getQuestion_numberOfOptions(){
        return this.Question_numberOfOptions;
    }

    // setters
    public void setQuestion_title(String Question_title){
        this.Question_title = Question_title;
    }

    public void setQuestion_type(String Question_type){
        this.Question_type = Question_type;
    }

    public void setQuestion_answer(String Question_answer){
        this.Question_answer = Question_answer;
    }

    public void setQuestion_options(String[] Question_options){
        for(int i = 0; i < this.Question_numberOfOptions; i++){
            this.Question_options[i] = Question_options[i];
        }
    }

    public void setQuestion_numberOfOptions(int Question_numberOfOptions){
        this.Question_numberOfOptions = Question_numberOfOptions;
    }

}
