package Quiz_System.Main_classes.Login_Management;

public class Admin extends User{
    Admin(){
        super();
    }

    Admin(String Name, String UserName, String password){
        super(Name, UserName, password);
        this.setRole("Admin");
    }
    
    // Admin specific methods
    public void createQuestion(){

    }

    public void deleteQuestion(){

    }

    public void createQuiz(){

    }

    public void deleteQuiz(){

    }

    public void createUser(){

    }

    public void deleteUser(){
        
    }
}