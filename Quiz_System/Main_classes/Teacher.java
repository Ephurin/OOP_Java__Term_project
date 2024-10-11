package Quiz_System.Main_classes;

public class Teacher extends User{
    private String school;

    Teacher(){
        super();
    }

    Teacher(String Name, String UserName, String password, String school){
        super(Name, UserName, password);
        this.setRole("Teacher");
        this.school = school;
    }

    public String getSchool(){
        return this.school;
    }

    public void setSchool(String school){
        this.school = school;
    }

    public void createQuiz(){

    }

    public void deleteQuiz(){

    }
}
