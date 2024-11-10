package Quiz_System.Main_classes;

public class Yes_or_No_Question {
    private String Question_title, Question_type, Question_answer, Question_option1 = "Yes", Question_option2 = "No";

    // constructors
    Yes_or_No_Question(){
        this.setQuestion_title("");
        this.setQuestion_type("");
        this.setQuestion_answer("");
    }

    Yes_or_No_Question(String Question_title, String Question_type, String Question_answer){
        this.setQuestion_title(Question_title);
        this.setQuestion_type(Question_type);
        this.setQuestion_answer(Question_answer);
    }

    // setters
    void setQuestion_title(String Question_title){
        this.Question_title = Question_title;
    }
    void setQuestion_type(String Question_type){
        this.Question_type = Question_type;
    }
    void setQuestion_answer(String Question_answer){
        this.Question_answer = Question_answer;
    }

    // getters
    String getQuestion_title(){
        return this.Question_title;
    }
    String getQuestion_type(){
        return this.Question_type;
    }
    String getQuestion_answer(){
        return this.Question_answer;
    }

    void displayQuestion(){
        System.out.println("Question: " + this.getQuestion_title());
        System.out.println("Type: " + this.getQuestion_type());
        System.out.println("Answer: " + this.getQuestion_answer());
        System.out.println("Options: ");
        System.out.println("1. " + this.Question_option1);
        System.out.println("2. " + this.Question_option2);
    }
}
