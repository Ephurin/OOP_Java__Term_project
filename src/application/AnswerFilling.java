package application;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;

public class AnswerFilling extends JFrame implements ActionListener {
    private static String input;
    JTextField questionID, question, answer, quizID;
    JButton save, clear;
    DefaultTableModel model;

    public AnswerFilling(String input) {
        this.input = input;
        setTitle("ANSWER FILLING");
        setSize(1000, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
       // getContentPane().setBackground(Color.PINK);
        //icon frame
        ImageIcon iconTeacher = new ImageIcon("E:\\2024-2025\\quizmanagesystem\\src\\image\\speech-bubble_17221393(1).png");
        setIconImage(iconTeacher.getImage());

        String[] columnNames = {"Quiz ID", "Question ID", "Question", "Your answer"};
        Object[][] data = {
                {"Q01","MC01", "How old are you", 18}
        };
        model = new DefaultTableModel(data, columnNames);
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(20, 20, 950, 200);
        add(scrollPane);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(null);
        inputPanel.setBounds(20, 300, 950, 400);

        //questionID
        JLabel q_id = new JLabel("Question ID");
        q_id.setBounds(0, 0, 150, 20);
        q_id.setFont(new Font("Arial", Font.BOLD, 18));
        q_id.setForeground(new Color(Color.BITMASK));
        inputPanel.add(q_id);

        questionID = new JTextField();
        questionID.setBounds(200, 0, 100, 25);
        questionID.setFont(new Font("Times New Roman", Font.BOLD, 20));
        inputPanel.add(questionID);
        // question
        JLabel q = new JLabel("Question");
        q.setBounds(0, 30, 300, 20);
        q.setFont(new Font("Arial", Font.BOLD, 18));
        q.setForeground(new Color(Color.BITMASK));
        inputPanel.add(q);

        question = new JTextField();
        question.setBounds(200, 30, 300, 25);
        question.setFont(new Font("Times New Roman", Font.BOLD, 20));
        inputPanel.add(question);
        // answer
        JLabel a = new JLabel("Your Answer");
        a.setBounds(0, 60, 150, 20);
        a.setFont(new Font("Arial", Font.BOLD, 18));
        a.setForeground(new Color(Color.BITMASK));
        inputPanel.add(a);

        answer = new JTextField();
        answer.setBounds(200, 60, 300, 60);
        answer.setFont(new Font("Times New Roman", Font.BOLD, 20));
        inputPanel.add(answer);

        /*JLabel quizid = new JLabel("Quiz ID");
        quizid.setBounds(0, 150, 150, 20);
        quizid.setFont(new Font("Arial", Font.BOLD, 18));
        quizid.setForeground(new Color(Color.BITMASK));
        inputPanel.add(quizid);

        quizID = new JTextField();
        quizID.setBounds(200, 150, 100, 25);
        quizID.setFont(new Font("Times New Roman", Font.BOLD, 20));
        inputPanel.add(quizID);*/

        //Button
        save = new JButton("SAVE");
        save .setBounds(600, 30, 120, 30);
        save .setBackground(new Color(30, 144, 254));
        save .setForeground(Color.WHITE);
        save .setFont(new Font("Arial", Font.BOLD, 16)); // Chọn font Arial, kiểu chữ thường, cỡ 16
        save .addActionListener(this);
        ImageIcon icSave = new ImageIcon("E:\\2024-2025\\quizmanagesystem\\src\\image\\diskette.png");
        save.setIcon(icSave);
        inputPanel.add(save );

        clear = new JButton("CLEAR");
        clear .setBounds(600, 90, 120, 30);
        clear .setBackground(new Color(30, 144, 254));
        clear .setForeground(Color.WHITE);
        clear .setFont(new Font("Arial", Font.BOLD, 16)); // Chọn font Arial, kiểu chữ thường, cỡ 16
        clear .addActionListener(this);
        ImageIcon icClear = new ImageIcon("E:\\2024-2025\\quizmanagesystem\\src\\image\\data-cleaning_12177271 (1).png");
        clear.setIcon(icClear);
        inputPanel.add(clear );
        add(inputPanel);
        setVisible(true);
    }
    public static void main (String[] args) {
        new AnswerFilling(input);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == save){
            String qID = questionID.getText();
            String q = question.getText();
            String a = answer.getText();
            String quiz_id = input;
            if(!qID.isEmpty() && !q.isEmpty() && !a.isEmpty() && !quiz_id.isEmpty() ){
                model.addRow(new Object[]{quiz_id, qID, q, a});
                try{
                    ConnectionDatabase cdb = new ConnectionDatabase();
                    String query = "insert into answerfilling(question_id, quiz_id, question_text, correct_answer)" +
                            "values (?, ?, ?, ?)";
                    PreparedStatement stmt = cdb.c.prepareStatement(query);
                    stmt.setString(1, qID);   // mc_questionID (giả sử là String)
                    stmt.setString(2, quiz_id);      // Câu hỏi
                    stmt.setString(3, q);
                    stmt.setString(4, a);// Đáp án 1
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
            }
        } else if (e.getSource() == clear) {
            questionID.setText("");
            question.setText("");
            answer.setText("");

        }
    }


}
