package application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MultipleChoice extends JFrame implements ActionListener {
    JTextField op1, op2, op3, op4, questionID, question;
    JButton save, clear;
    public MultipleChoice(){
        setTitle("MULTIPLE CHOICE");
        setSize(900, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(Color.YELLOW);
        // icon frame
        ImageIcon iconTeacher = new ImageIcon("E:\\2024-2025\\quizmanagesystem\\src\\image\\option.png");
        setIconImage(iconTeacher.getImage());

        JLabel heading = new JLabel("ADD NEW QUESTION");
        heading.setBounds(230, 20, 400, 45);
        heading.setFont(new Font("SansSerif", Font.BOLD + Font.ITALIC, 30));
        heading.setForeground(new Color(30, 144, 254));
        ImageIcon icHeading = new ImageIcon("E:\\2024-2025\\quizmanagesystem\\src\\image\\customer-service.png");
        heading.setIcon(icHeading);
        add(heading);
        //question id
        JLabel q_id = new JLabel("Question ID");
        q_id.setBounds(100, 100, 300, 20);
        q_id.setFont(new Font("Arial", Font.BOLD, 18));
        q_id.setForeground(new Color(Color.BITMASK));
        add(q_id);

        questionID = new JTextField();
        questionID.setBounds(250, 100, 100, 25);
        questionID.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(questionID);
        // question
        JLabel q = new JLabel("Question");
        q.setBounds(100, 150, 300, 20);
        q.setFont(new Font("Arial", Font.BOLD, 18));
        q.setForeground(new Color(Color.BITMASK));
        add(q);

        question = new JTextField();
        question.setBounds(250, 150, 300, 25);
        question.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(question);
        // dap an A
        JLabel a = new JLabel("A.");
        a.setBounds(200, 200, 300, 20);
        a.setFont(new Font("Arial", Font.BOLD, 18));
        a.setForeground(new Color(Color.BITMASK));
        add(a);

        op1 = new JTextField();
        op1.setBounds(250, 200, 300, 25);
        op1.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(op1);
        //dap an B
        JLabel b = new JLabel("B.");
        b.setBounds(200, 250, 300, 20);
        b.setFont(new Font("Arial", Font.BOLD, 18));
        b.setForeground(new Color(Color.BITMASK));
        add(b);

        op2 = new JTextField();
        op2.setBounds(250, 250, 300, 25);
        op2.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(op2);
        //dap an C
        JLabel c = new JLabel("C.");
        c.setBounds(200, 300, 300, 20);
        c.setFont(new Font("Arial", Font.BOLD, 18));
        c.setForeground(new Color(Color.BITMASK));
        add(c);

        op3 = new JTextField();
        op3.setBounds(250, 300, 300, 25);
        op3.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(op3);
        //dap an D
        JLabel d = new JLabel("D.");
        d.setBounds(200, 350, 300, 20);
        d.setFont(new Font("Arial", Font.BOLD, 18));
        d.setForeground(new Color(Color.BITMASK));
        add(d);

        op4 = new JTextField();
        op4.setBounds(250, 350, 300, 25);
        op4.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(op4);

        //Button
        save = new JButton("SAVE");
        save .setBounds(100, 400, 120, 30);
        save .setBackground(new Color(30, 144, 254));
        save .setForeground(Color.WHITE);
        save .setFont(new Font("Arial", Font.BOLD, 16)); // Chọn font Arial, kiểu chữ thường, cỡ 16
        save .addActionListener(this);
        ImageIcon icSave = new ImageIcon("E:\\2024-2025\\quizmanagesystem\\src\\image\\diskette.png");
        save.setIcon(icSave);
        add(save );

        clear = new JButton("NEXT");
        clear .setBounds(500, 400, 120, 30);
        clear .setBackground(new Color(30, 144, 254));
        clear .setForeground(Color.WHITE);
        clear .setFont(new Font("Arial", Font.BOLD, 16)); // Chọn font Arial, kiểu chữ thường, cỡ 16
        clear .addActionListener(this);
        ImageIcon icClear = new ImageIcon("E:\\2024-2025\\quizmanagesystem\\src\\image\\data-cleaning_12177271 (1).png");
        clear.setIcon(icClear);
        add(clear );

        setVisible(true);
    }
    public static void main(String[] args) {
        new MultipleChoice();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == save){
            String qID = questionID.getText();
            String q = question.getText();
            String a = op1.getText();
            String b = op2.getText();
            String c1 = op3.getText();
            String d = op4.getText();
            String key1 = op1.getText();
            try{
                ConnectionDatabase cdb = new ConnectionDatabase();
                String query = "insert into multiplechoice(mc_questionID, question, op1, op2, op3, op4, key_question)" +
                        "values (?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement stmt = cdb.c.prepareStatement(query);
                stmt.setString(1, qID);   // mc_questionID (giả sử là String)
                stmt.setString(2, q);      // Câu hỏi
                stmt.setString(3, a);      // Đáp án 1
                stmt.setString(4, b);      // Đáp án 2
                stmt.setString(5, c1);      // Đáp án 3
                stmt.setString(6, d);      // Đáp án 4
                stmt.setString(7, key1);// Đáp án đúng (key_question)

                int rowsAffected = stmt.executeUpdate();

                // Kiểm tra nếu có dòng dữ liệu bị thay đổi
                if (rowsAffected > 0) {
                    System.out.println("Đã thêm câu hỏi vào cơ sở dữ liệu thành công.");
                } else {
                    System.out.println("Không có dữ liệu được thêm.");
                }
            } catch (Exception ae) {
                ae.printStackTrace();
            }
        } else if (e.getSource() == clear) {
            questionID.setText("");
            question.setText("");
            op1.setText("");
            op2.setText("");
            op3.setText("");
            op4.setText("");
        }

    }
}
