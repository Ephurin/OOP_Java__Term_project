package Quiz_System.Main_classes;

public class Multiple_Choice_Question extends Question{
    private String Question_title, Question_type, Question_answer;
    private String[] Question_options;
    private int Question_numberOfOptions;

    // constructors
    Multiple_Choice_Question(){
        super();
        this.setQuestion_numberOfOptions(4); // default number of options is 4
        this.setQuestion_options(new String[4]);
    }

    Multiple_Choice_Question(String Question_title, String Question_type, String Question_answer,int Question_numberOfOptions, String[] Question_options){
        super(Question_title, Question_type, Question_answer);
        this.setQuestion_numberOfOptions(Question_numberOfOptions);  
        this.setQuestion_options(Question_options);
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

    public String[] getQuestion_options(){
        return this.Question_options;
    }

    public int getQuestion_numberOfOptions(){
        return this.Question_numberOfOptions;
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

    public void setQuestion_options(String[] Question_options){
        for(int i = 0; i < this.Question_numberOfOptions; i++){
            this.Question_options[i] = Question_options[i];
        }
    }

    public void setQuestion_numberOfOptions(int Question_numberOfOptions){
        this.Question_numberOfOptions = Question_numberOfOptions;
    }

    @Override
    public void displayQuestion(){
        System.out.println("Question: " + this.getQuestion_title());
        System.out.println("Options: ");
        for(int i = 0; i < this.getQuestion_numberOfOptions(); i++){
            System.out.println((i+1) + ". " + this.getQuestion_options()[i]);
        }
    }

}
