package Quiz_System.Main_classes;

public class Student extends User{
    private String school;

    Student(){
        super();
    }

    Student(String Name, String UserName, String password, String school){
        super(Name, UserName, password);
        this.setRole("Student");
        this.school = school;
    }

    //Getters
    public String getSchool(){
        return this.school;
    }

    //Setters
    public void setSchool(String school){
        this.school = school;
    }   

    // Student specific methods
    public void takeQuestion(){

    }

    public void takeQuiz(){

    }
}
