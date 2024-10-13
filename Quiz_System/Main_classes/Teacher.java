package Quiz_System.Main_classes;

public class Teacher extends User{
    private String school, subject;

    Teacher(){
        super();
    }

    Teacher(String Name, String UserName, String password, String school, String subject){
        super(Name, UserName, password);
        this.setRole("Teacher");
        this.school = school;
        this.subject = subject;
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
    public void createQuestion(){

    }

    public void deleteQuestion(){

    }

    public void createQuiz(){
        
    }

    public void deleteQuiz(){

    }
}
