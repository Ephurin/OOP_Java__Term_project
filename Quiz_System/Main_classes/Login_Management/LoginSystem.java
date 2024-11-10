package Quiz_System.Main_classes.Login_Management;

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

    public void logout() {
    }

    public void changePassword(String username, String oldPassword, String newPassword) {
    }

    public void changeUsername(String oldUsername, String newUsername) {
    }

    public void deleteUser(String username) {
    }

    public void findUser(String username) {
    }

    public void findQuiz(String quizName) {
    }

    public void findQuestion(String question) {
    }
}



