package Quiz_System.Main_classes.Question_Management;

public abstract class Question{
    private String Question_title, Question_type, Question_answer;

    // constructors
    Question(){
        this.setQuestion_title("");
        this.setQuestion_type("");
        this.setQuestion_answer("");
    }

    Question(String Question_title, String Question_type, String Question_answer){
        this.setQuestion_title(Question_title);
        this.setQuestion_type(Question_type);
        this.setQuestion_answer(Question_answer);
    }
    
    // setters
    abstract void setQuestion_title(String Question_title);
    abstract void setQuestion_type(String Question_type);
    abstract void setQuestion_answer(String Question_answer);

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

    public void displayQuestion(){
        System.out.println("Question: " + this.getQuestion_title());
        System.out.println("Type: " + this.getQuestion_type());
        System.out.println("Answer: " + this.getQuestion_answer());
    }
}
