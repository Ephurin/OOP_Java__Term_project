package Quiz_System.Main_classes;

public class Student extends User{
    private String school;
    private int Grade_Level;

    Student(){
        super();
    }

    Student(String Name, String UserName, String password, String school, int Grade_Level){
        super(Name, UserName, password);
        this.setRole("Student");
        this.setSchool(school);
        this.setGrade_Level(Grade_Level);
    }

    //Getters
    public String getSchool(){
        return this.school;
    }

    public int getGrade_Level(){
        return this.Grade_Level;
    }

    //Setters
    public void setSchool(String school){
        this.school = school;
    }   

    public void setGrade_Level(int Grade_Level){
        this.Grade_Level = Grade_Level;
    }

    // Student specific methods
    public void takeQuestion(Question question){

    }

    public void takeQuiz(Quiz quiz){

    }
}
