package Quiz_System.Main_classes;

public class Admin extends User{
    Admin(){
        super();
    }

    Admin(String Name, String UserName, String password){
        super(Name, UserName, password);
        this.setRole("Teacher");
    }
}
