package Quiz_System.Main_classes;

import java.util.ArrayList;

public class LoginSystem {
    private ArrayList<User> users;

    public LoginSystem() {
        users = new ArrayList<>();
    }

    public void addUser(String username, String password) {
        users.add(new User(username, password));
    }

    public String login(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.verifyPassword(password)) {
                return "Login successful";
            }
        }
        return "Invalid username or password";
    }
}

