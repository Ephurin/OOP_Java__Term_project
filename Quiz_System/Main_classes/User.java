package Quiz_System.Main_classes;

public class User {
    private String UserID, Name, UserName, password, Role;
    private static int id = 1;

    User(){
        this.UserID = String.format("USID%04d", id++);
        this.Name = "";
        this.UserName = "";
        this.password = "";
        if (id >= 9999) id = 1;
    }

    User(String Name, String UserName, String password){
        this.UserID = String.format("USID%04d", id++);
        this.Name = Name;
        this.UserName = UserName;
        this.password = password;
        if (id >= 9999) id = 1;
    }
    //Getters
    public String getUserID(){
        return this.UserID;
    }

    public String getName(){
        return this.Name;
    }

    public String getUserName(){
        return this.UserName;
    }

    public String getPassword(){
        return this.password;
    }

    public String getRole(){
        return this.Role;
    }

    //Setters
    public void setName(String Name){
        this.Name = Name;
    }

    public void setUserName(String UserName){
        this.UserName = UserName;
    }

    public void setPassword(String password){
        this.password = password;
    }
}