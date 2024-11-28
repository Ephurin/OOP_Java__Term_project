package application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Scanner;

public class Register extends JFrame implements ActionListener {
    private static JButton back, next;
    private static JTextField tfusername,tfrole, tfpassword, tfreEnter;
    Register() {
        getContentPane().setBackground(new Color(0, 51, 102));
        setLayout(null);
        // heading name
        JLabel heading = new JLabel("REGISTER");
        heading.setBounds(380, 60, 300, 45);
        heading.setFont(new Font("SansSerif", Font.BOLD + Font.ITALIC, 40));
        heading.setForeground(new Color(30, 144, 254));
        add(heading);
        //username
        JLabel username = new JLabel("username");
        username.setBounds(250, 150, 300, 20);
        username.setFont(new Font("Arial", Font.BOLD, 18));
        username.setForeground(new Color(30, 144, 254));
        add(username);

        tfusername = new JTextField();
        tfusername.setBounds(350, 150, 300, 25);
        tfusername.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(tfusername);

        //role

        JLabel role = new JLabel("role");
        role.setBounds(250, 200, 300, 20);
        role.setFont(new Font("Arial", Font.BOLD, 18));
        role.setForeground(new Color(30, 144, 254));
        add(role);

        tfrole = new JTextField();
        tfrole.setBounds(350, 200, 300, 25);
        tfrole.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(tfrole);

        // password
        JLabel pw = new JLabel("password");
        pw.setBounds(250, 250, 300, 20);
        pw.setFont(new Font("Arial", Font.BOLD, 18));
        pw.setForeground(new Color(30, 144, 254));
        add(pw);

        tfpassword = new JPasswordField();
        tfpassword.setBounds(350, 250, 300, 25);
        tfpassword.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(tfpassword);

        // re-enter pw
        JLabel repw = new JLabel("<html>re-enter<br>password</html>");
        repw.setBounds(250, 290, 300, 50);
        repw.setFont(new Font("Arial", Font.BOLD, 18));
        repw.setForeground(new Color(30, 144, 254));
        add(repw);

        tfreEnter = new JPasswordField();
        tfreEnter.setBounds(350, 290, 300, 25);
        tfreEnter.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(tfreEnter);
        // Button
        back = new JButton("Back");
        back .setBounds(200, 350, 120, 30);
        back .setBackground(new Color(30, 144, 254));
        back .setForeground(Color.WHITE);
        back .setFont(new Font("Arial", Font.BOLD, 16)); // Chọn font Arial, kiểu chữ thường, cỡ 16
        back .addActionListener(this);
        add(back );


        next = new JButton("Next");
        next.setBounds(600, 350, 120, 30);
        next.setBackground(new Color(30, 144, 254));
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Arial", Font.BOLD, 16)); // Chọn font Arial, kiểu chữ thường, cỡ 16
        next.addActionListener(this);
        add(next);



        setSize(1000, 500);
        setLocation(300, 150); // center
        setVisible(true);
    }
    public static void main (String[] args) {
        new Register();
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == next) {
            String username = tfusername.getText();
            String password = tfreEnter.getText();
            String role = tfrole.getText();
            addMembers(username, password, role);
            JOptionPane.showMessageDialog(null, "Member added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    public static void addMembers(String username, String password, String role)  {
        try {
            FileWriter fw = new FileWriter("E:\\2024-2025\\quizmanagesystem\\src\\application\\members.in", true);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write(username + " " + password + " " + role);
            bw.newLine();
            bw.close();
            System.out.println("Member added successfully: " + username);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}

