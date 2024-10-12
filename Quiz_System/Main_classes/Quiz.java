package Quiz_System.Main_classes;

import java.util.ArrayList;
import java.util.List;

public class Quiz {
    private String Quiz_title;
    private List<Question> Questions;
    private int Quiz_numberOfQuestions;

    Quiz(){
        this.Quiz_title = "";
        this.Quiz_numberOfQuestions = 0;
        this.Questions = new ArrayList<Question>();
    }

    Quiz(String Quiz_title, int Quiz_numberOfQuestions, List<Question> Questions){
        this.Quiz_title = Quiz_title;
        this.Quiz_numberOfQuestions = Quiz_numberOfQuestions;
        this.Questions = new ArrayList<Question>();
        for(int i = 0; i < this.Quiz_numberOfQuestions; i++){
            this.Questions.add(Questions.get(i));
        }
    }

    // getters
    public String getQuiz_title(){
        return this.Quiz_title;
    }

    public List<Question> getQuestions(){
        return this.Questions;
    }

    public int getQuiz_numberOfQuestions(){
        return this.Quiz_numberOfQuestions;
    }

    // setters
    public void setQuiz_title(String Quiz_title){
        this.Quiz_title = Quiz_title;
    }

    public void setQuestions(List<Question> Questions){
        this.Questions = Questions;
    }

    public void setQuiz_numberOfQuestions(int Quiz_numberOfQuestions){
        this.Quiz_numberOfQuestions = Quiz_numberOfQuestions;
    }

    public void addQuestion(Question question){
        this.Questions.add(question);
    }

    public void removeQuestion(Question question){
        this.Questions.remove(question);
    }
    
}
