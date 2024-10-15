package Quiz_System.Main_classes;

public class Login {
    private String UserName, password;

    Login(){
        this.UserName = "";
        this.password = "";
    }

    Login(String UserName, String password){
        this.UserName = UserName;
        this.password = password;
    }

    public void CheckLogin(User user){
        if(this.UserName.equals(user.getUserName()) && this.password.equals(user.getPassword())){
            System.out.println("Login Successful");
        }else{
            System.out.println("Login Failed");
        }
    }
    
}
