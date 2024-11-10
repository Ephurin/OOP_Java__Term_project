package Quiz_System.Main_classes.Question_Management;

public class Answer_Filling_Question extends Question{
    private String Question_title, Question_type, Question_answer;
    // constructors
    Answer_Filling_Question(){
        super();
    }

    Answer_Filling_Question(String Question_title, String Question_type, String Question_answer){
        super(Question_title, Question_type, Question_answer);
    }

    // setters
    @Override
    public void setQuestion_title(String Question_title){
        this.Question_title = Question_title;
    }
    @Override
    public void setQuestion_type(String Question_type){
        this.Question_type = Question_type;
    }
    @Override
    public void setQuestion_answer(String Question_answer){
        this.Question_answer = Question_answer;
    }

    // getters
    @Override
    public String getQuestion_title(){
        return this.Question_title;
    }
    @Override
    public String getQuestion_type(){
        return this.Question_type;
    }
    @Override
    public String getQuestion_answer(){
        return this.Question_answer;
    }

    @Override
    public void displayQuestion(){
        System.out.println("Question: " + this.getQuestion_title());
        System.out.println("Type: " + this.getQuestion_type());
        System.out.println("Answer: " + this.getQuestion_answer());
    }
}
