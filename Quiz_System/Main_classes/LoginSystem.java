package Quiz_System.Main_classes;

import java.util.ArrayList;

public class LoginSystem {
    private ArrayList<User> users;

    public LoginSystem() {
        users = new ArrayList<>();
    }

    public void addUser(User user) {
        users.add(user);
    }

    public String login(String username, String password) {
        return "";
    }
}



