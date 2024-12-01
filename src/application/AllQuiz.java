package application;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AllQuiz extends JFrame implements ActionListener {
    JButton back;
    JFrame frame;
    DefaultTableModel model;
    public AllQuiz() {

        frame = new JFrame("Multiple Choice") ;
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 700);
        frame.setLayout(null);
        String[] columnNames = {"Quiz ID", "Quiz Name", "Date Created", "Quiz Type"};
        model = new DefaultTableModel(columnNames, 0);
        Object[][] data = {
                {"Q01", "Technology", "2024-12-10", "multiple choice"}
        };
        //model = new DefaultTableModel(data, columnNames);
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(20, 20, 950, 200);
        frame.add(scrollPane);
        back = new JButton("Back");
        back.setBounds(700, 550, 150, 30);
        back.addActionListener(this);
        frame.add(back);

        displayQuiz();
        frame.setVisible(true);
    }

    private void displayQuiz() {
        try {
            ConnectionDatabase cdb = new ConnectionDatabase();
            String query = "select * from quiztable";
            PreparedStatement stmt = cdb.c.prepareStatement(query);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String quizID = rs.getString("quiz_id");
                String quizName = rs.getString("quiz_name");
                String dateCreated = rs.getString("date_created");
                String quizType = rs.getString("quiz_type");

                // Thêm một hàng dữ liệu vào bảng
                model.addRow(new Object[]{quizID, quizName, dateCreated, quizType});
            }
            // Kiểm tra nếu có dòng dữ liệu bị thay đổi
            rs.close();
            stmt.close();

        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new AllQuiz();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == back){
            frame.dispose();
        }
    }
}
