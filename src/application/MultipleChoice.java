package application;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;

public class MultipleChoice extends JFrame implements ActionListener {
    private static String input;
    JButton addButton, clear;
    JTextField quizIDField, idField, questionField, aField, bField, cField, dField, keyField;
    DefaultTableModel model;
    JFrame frame;
    public MultipleChoice(String input) {
        this.input = input;
        frame = new JFrame("Multiple Choice") ;
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 700);
        frame.setLayout(null);

        String[] columnNames = {"Quiz ID", "Question ID", "Question", "A", "B", "C", "D", "Key"};
        Object[][] data = {
                {"Q01","MC01", "How old are you", 18, 19, 20, 21, 21}
        };
        model = new DefaultTableModel(data, columnNames);
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(20, 20, 950, 200);
        frame.add(scrollPane);

        // Panel nhập dữ liệu
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(null);
        inputPanel.setBounds(20, 300, 950, 300);
        //JTextField nhập dữ liệu
        JLabel id = new JLabel("Question ID");
        id.setBounds(0, 0  , 150, 20);
        inputPanel.add(id);
        idField = new JTextField(10);
        idField.setBounds(200, 0, 100, 25);
        inputPanel.add(idField);

        JLabel question = new JLabel("Question");
        question.setBounds(0, 30, 150, 20);
        inputPanel.add(question);
        questionField = new JTextField(30);
        questionField.setBounds(200, 30, 300, 25);
        inputPanel.add(questionField);

        JLabel a = new JLabel("Option A");
        a.setBounds(0, 60, 150, 20);
        inputPanel.add(a);
        aField = new JTextField(10);
        aField.setBounds(200, 60, 300, 25);
        inputPanel.add(aField);

        JLabel b = new JLabel("Option B");
        b.setBounds(0, 90, 150, 20);
        inputPanel.add(b);
        bField = new JTextField(10);
        bField.setBounds(200, 90, 300, 25);
        inputPanel.add(bField);

        JLabel c = new JLabel("Option C");
        c.setBounds(0, 120, 150, 20);
        inputPanel.add(c);
        cField = new JTextField(10);
        cField.setBounds(200, 120, 300, 25);
        inputPanel.add(cField);

        JLabel d = new JLabel("Option D");
        d.setBounds(0, 150, 150, 20);
        inputPanel.add(d);
        dField = new JTextField(10);
        dField.setBounds(200, 150, 300, 25);
        inputPanel.add(dField);

        JLabel key = new JLabel("Your Answer");
        key.setBounds(0, 180, 150, 20);
        inputPanel.add(key);
        keyField = new JTextField(10);
        keyField.setBounds(200, 180, 300, 25);
        inputPanel.add(keyField);

       /* JLabel quizID = new JLabel("Quiz ID");
        quizID.setBounds(0, 210, 150, 20);
        inputPanel.add(quizID);
        quizIDField = new JTextField(10);
        quizIDField.setBounds(200, 210, 300, 25);
        inputPanel.add(quizIDField);*/
        //JButton
        addButton = new JButton("Add question");
        addButton.setBounds(600, 60, 150, 20);
        addButton.addActionListener(this);
        inputPanel.add(addButton);
        clear = new JButton("Clear");
        clear.setBounds(600, 100, 150, 20);
        clear.addActionListener(this);
        inputPanel.add(clear);
        // thêm các component vào inputPanel

        //them inputPanel vào cửa sổ
        frame.add(inputPanel);
        frame.setVisible(true);

    }
    public static void main(String[] args){
        new MultipleChoice(input);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == addButton){
            String qID = idField.getText();
            String q = questionField.getText();
            String a = aField.getText();
            String b = bField.getText();
            String c1 = cField.getText();
            String d = dField.getText();
            String key1 = keyField.getText();
            String quizID = input;
            if(!qID.isEmpty() && !q.isEmpty() && !a.isEmpty() && !b.isEmpty() && !c1.isEmpty() && !d.isEmpty() && !key1.isEmpty() && !quizID.isEmpty() ){
                model.addRow(new Object[]{quizID,qID, q, a, b, c1, d, key1});
                try{
                    ConnectionDatabase cdb = new ConnectionDatabase();
                    String query = "insert into multiplechoice(question_id, quiz_id, question_text, option_a, option_b, option_c, option_d, correct_answer)" +
                            "values (?, ?, ?, ?, ?, ?, ?, ?)";
                    PreparedStatement stmt = cdb.c.prepareStatement(query);
                    stmt.setString(1, qID);
                    stmt.setString(2, quizID);// mc_questionID (giả sử là String)
                    stmt.setString(3, q);      // Câu hỏi
                    stmt.setString(4, a);      // Đáp án 1
                    stmt.setString(5, b);      // Đáp án 2
                    stmt.setString(6, c1);      // Đáp án 3
                    stmt.setString(7, d);      // Đáp án 4
                    stmt.setString(8, key1);// Đáp án đúng (key_question)


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
            } else{
                JOptionPane.showMessageDialog(frame, "Vui lòng nhập đầy đủ thông tin!", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            }
        } else if(e.getSource() == clear){
            idField.setText("");
            questionField.setText("");
            aField.setText("");
            bField.setText("");
            cField.setText("");
            dField.setText("");
            keyField.setText("");
            quizIDField.setText("");
        }
    }
}
