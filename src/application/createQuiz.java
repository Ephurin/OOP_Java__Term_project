package application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;

public class createQuiz extends JFrame implements ActionListener {
    private static String s;
    JTextField quizID, quizType, quizName;
    JButton next;
    public createQuiz(String s){
        this.s = s;
        getContentPane().setBackground(new Color(0, 51, 102));
        setLayout(null);
        // heading name
        JLabel heading = new JLabel("Quiz");
        heading.setBounds(380, 60, 300, 45);
        heading.setFont(new Font("SansSerif", Font.BOLD + Font.ITALIC, 40));
        heading.setForeground(new Color(30, 144, 254));
        add(heading);
        //username
        JLabel quizid = new JLabel("Quiz ID");
        quizid.setBounds(200, 150, 300, 20);
        quizid.setFont(new Font("Arial", Font.BOLD, 18));
        quizid.setForeground(new Color(30, 144, 254));
        add(quizid);

        quizID = new JTextField();
        quizID.setBounds(300, 150, 300, 25);
        quizID.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(quizID);
        // quizName
        JLabel quizname = new JLabel("Quiz Name");
        quizname.setBounds(200, 200, 300, 20);
        quizname.setFont(new Font("Arial", Font.BOLD, 18));
        quizname.setForeground(new Color(30, 144, 254));
        add(quizname);

        quizName = new JTextField();
        quizName.setBounds(300, 200, 300, 25);
        quizName.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(quizName);

        //Quiz type
        JLabel quiztype = new JLabel("Quiz Type");
        quiztype.setBounds(200, 250, 300, 20);
        quiztype.setFont(new Font("Arial", Font.BOLD, 18));
        quiztype.setForeground(new Color(30, 144, 254));
        add(quiztype);

        quizType = new JTextField();
        quizType.setBounds(300, 250, 300, 25);
        quizType.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(quizType);

        next = new JButton("Next");
        next.setBounds(600, 400, 120, 30);
        next.setBackground(new Color(30, 144, 254));
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Arial", Font.BOLD, 16)); // Chọn font Arial, kiểu chữ thường, cỡ 16
        next.addActionListener(this);
        add(next);

        setSize(1000, 500);
        setLocation(300, 150); // center
        setVisible(true);
    }
    public static void main(String[] args) {
        new createQuiz(s);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String qID = quizID.getText();
        String quizName1 = quizName.getText();
        String quiztype = quizType.getText();
        if(e.getSource() == next){
            try {
                ConnectionDatabase cdb = new ConnectionDatabase();
                String createNameQuiz = "insert into quiztable(quiz_id, quiz_name, quiz_type)" +
                        "values(?,?,?)";
                PreparedStatement stmt = cdb.c.prepareStatement(createNameQuiz);
                stmt.setString(1, qID);   // mc_questionID (giả sử là String)
                stmt.setString(2, quizName1);
                stmt.setString(3, quiztype);// Câu hỏi
                int rowsAffected = stmt.executeUpdate();

                // Kiểm tra nếu có dòng dữ liệu bị thay đổi
                if (rowsAffected > 0) {
                    System.out.println("Đã thêm câu hỏi vào cơ sở dữ liệu thành công.");
                } else {
                    System.out.println("Không có dữ liệu được thêm.");
                }
            } catch (Exception ar) {
                ar.printStackTrace();
            }
            if(s.equals("multiple choice")){
                new MultipleChoice(qID);
            } else if (s.equals("Answer Filling")) {
                new AnswerFilling(qID);
            }
        }
    }
}
