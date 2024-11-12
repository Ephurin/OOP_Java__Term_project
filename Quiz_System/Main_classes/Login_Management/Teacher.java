package Quiz_System.Main_classes.Login_Management;

import Quiz_System.Main_classes.Question_Management.Question;

public class Teacher extends User{
    private String school, subject;

    Teacher(){
        super();
    }

    Teacher(String Name, String UserName, String password, String school, String subject){
        super(Name, UserName, password);
        this.setRole("Teacher");
        this.setSchool(school);
        this.setSubject(subject);
    }
    
    //Getters
    public String getSchool(){
        return this.school;
    }

    public String getSubject(){
        return this.subject;
    }

    //Setters
    public void setSchool(String school){
        this.school = school;
    }

    public void setSubject(String subject){
        this.subject = subject;
    }

    // Teacher specific methods
    public void createQuestion(Question question){

    }

    public void deleteQuestion(Question question){

    }

    public void createQuiz(){
        
    }

    public void deleteQuiz(){

    }
}