package application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Scanner;

public class Login extends JFrame implements ActionListener {
    JButton back, next, forgotpw;
    JTextField tfusername, tfpassword;

    Login() {
        getContentPane().setBackground(new Color(0, 51, 102));
        setLayout(null);
        // heading name
        JLabel heading = new JLabel("LOGIN");
        heading.setBounds(380, 60, 300, 45);
        heading.setFont(new Font("SansSerif", Font.BOLD + Font.ITALIC, 40));
        heading.setForeground(new Color(30, 144, 254));
        add(heading);
        //username
        JLabel username = new JLabel("username");
        username.setBounds(200, 150, 300, 20);
        username.setFont(new Font("Arial", Font.BOLD, 18));
        username.setForeground(new Color(30, 144, 254));
        add(username);

        tfusername = new JTextField();
        tfusername.setBounds(300, 150, 300, 25);
        tfusername.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(tfusername);
        // password
        JLabel pw = new JLabel("password");
        pw.setBounds(200, 200, 300, 20);
        pw.setFont(new Font("Arial", Font.BOLD, 18));
        pw.setForeground(new Color(30, 144, 254));
        add(pw);

        tfpassword = new JPasswordField();
        tfpassword.setBounds(300, 200, 300, 25);
        tfpassword.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(tfpassword);

        // Button
        back = new JButton("Back");
        back .setBounds(200, 300, 120, 30);
        back .setBackground(new Color(30, 144, 254));
        back .setForeground(Color.WHITE);
        back .setFont(new Font("Arial", Font.BOLD, 16)); // Chọn font Arial, kiểu chữ thường, cỡ 16
        back .addActionListener(this);
        add(back );


        next = new JButton("Next");
        next.setBounds(600, 300, 120, 30);
        next.setBackground(new Color(30, 144, 254));
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Arial", Font.BOLD, 16)); // Chọn font Arial, kiểu chữ thường, cỡ 16
        next.addActionListener(this);
        add(next);

        forgotpw = new JButton("Forgot password");
        forgotpw.setBounds(580, 250, 150, 30);
        forgotpw.setBackground(new Color(0, 51, 102));
        forgotpw.setForeground(Color.WHITE);
        forgotpw.setFont(new Font("Arial", Font.BOLD, 11)); // Chọn font Arial, kiểu chữ thường, cỡ 16
        forgotpw.addActionListener(this);
        add(forgotpw);

        setSize(1000, 500);
        setLocation(300, 150); // center
        setVisible(true);
    }
    public static void main (String[] args) {
        new Login();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == next) {
            String username = tfusername.getText();
            String password = tfpassword.getText();
            verifyLogin(username, password);

        }
    }
    public static void verifyLogin(String username, String password) {
        boolean found = false;
        String tempusername = "";
        String temppassword = "";
        String temprole = "";
        try{
            Scanner sc = new Scanner(new File("E:\\2024-2025\\quizmanagesystem\\src\\application\\members.in"));
            while (sc.hasNext() && !found) {
                tempusername = sc.next();
                temppassword = sc.next();
                temprole = sc.next();
                if(tempusername.trim().equals(username.trim()) && temppassword.trim().equals(password.trim())) {

                    found = true;
                }
            }
            if(found == true) {
                JOptionPane.showMessageDialog(null, "Login successfully as " + temprole, "Successfully", JOptionPane.INFORMATION_MESSAGE);
                switch (temprole){
                    case "Teacher":
                        new TeacherUI();
                    case "Student":
                        new StudentUI();
                    case "Admin":
                        new AdminUI();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Wrong password or Wrong answer", "Failed", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
