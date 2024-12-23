package application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

class fillQuizSelectionScreen extends JFrame {
    private JList<String> quizList;
    private DefaultListModel<String> listModel;
    private JButton startButton;
    private Connection connection;
    private Map<String, String> quizIdMap;

    public fillQuizSelectionScreen() {
        initializeDatabase();
        initializeUI();
        loadQuizzes();
    }

    private void initializeDatabase() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/quiz";
            String username = "root";
            String password = "1234";
            connection = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Database connection failed: " + e.getMessage());
        }
    }

    private void initializeUI() {
        setTitle("Quiz Selection");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));
        getContentPane().setBackground(new Color(240, 240, 240));

        // Title Label
        JLabel titleLabel = new JLabel("Select a Quiz", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(15, 0, 15, 0));
        add(titleLabel, BorderLayout.NORTH);

        // Quiz List
        listModel = new DefaultListModel<>();
        quizList = new JList<>(listModel);
        quizList.setFont(new Font("Arial", Font.PLAIN, 14));
        quizList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        quizList.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        JScrollPane scrollPane = new JScrollPane(quizList);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
        add(scrollPane, BorderLayout.CENTER);

        // Start Button
        startButton = new JButton("Start Quiz");
        startButton.setFont(new Font("Arial", Font.BOLD, 14));
        startButton.setBackground(new Color(30, 144, 254));
        startButton.setForeground(Color.WHITE);
        startButton.setEnabled(false);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(240, 240, 240));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        buttonPanel.add(startButton);
        add(buttonPanel, BorderLayout.SOUTH);

        // Enable start button when a quiz is selected
        quizList.addListSelectionListener(e -> startButton.setEnabled(!quizList.isSelectionEmpty()));

        // Start button action
        startButton.addActionListener(e -> {
            String selectedQuiz = quizList.getSelectedValue();
            if (selectedQuiz != null && quizIdMap.containsKey(selectedQuiz)) {
                dispose();
                new FillBlankQuiz(quizIdMap.get(selectedQuiz));
            }
        });
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void loadQuizzes() {
        quizIdMap = new HashMap<>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT DISTINCT quizID, quiz_name, quiz_type FROM quiz");

            while (rs.next()) {
                String quizId = rs.getString("quizID");
                String quizName = rs.getString("quiz_name");
                String quizType = rs.getString("quiz_type");
                if (Objects.equals(quizType, "fillblank")) {
                    listModel.addElement(quizName);
                    quizIdMap.put(quizName, quizId);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error loading quizzes: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new fillQuizSelectionScreen());
    }
}


public class FillBlankQuiz extends JFrame implements ActionListener {
    private JLabel questionLabel;
    private JTextField answerField;
    private JButton submitButton, nextButton;
    private JLabel resultLabel;
    private String correctAnswer;
    private double mark;
    private int true_ans = 0;
    private int question_count = 0;
    private int currentQuestionId = 1;
    private String quizId;
    private Connection connection;

    public FillBlankQuiz(String quizId) {
        this.quizId = quizId;
        initializeDatabase();
        initializeUI();
        loadQuestion(String.format("FB%02d", currentQuestionId));
    }

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }

    private void initializeDatabase() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/quiz";
            String username = "root";
            String password = "1234";
            connection = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Database connection failed: " + e.getMessage());
        }
    }

    private void initializeUI() {
        setTitle("Fill in the Blank Quiz");
        setSize(600, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(new Color(240, 240, 240));

        // Question Label
        questionLabel = new JLabel("");
        questionLabel.setBounds(50, 50, 500, 30);
        questionLabel.setFont(new Font("Arial", Font.BOLD, 16));
        add(questionLabel);

        // Answer field
        answerField = new JTextField();
        answerField.setBounds(50, 100, 200, 30);
        answerField.setFont(new Font("Arial", Font.PLAIN, 14));
        add(answerField);

        // Submit Button
        submitButton = new JButton("Submit Answer");
        submitButton.setBounds(50, 150, 150, 35);
        submitButton.setBackground(new Color(30, 144, 254));
        submitButton.setForeground(Color.WHITE);
        submitButton.setFont(new Font("Arial", Font.BOLD, 14));
        submitButton.addActionListener(this);
        add(submitButton);

        // Next Button
        nextButton = new JButton("Next Question");
        nextButton.setBounds(220, 150, 150, 35);
        nextButton.setBackground(new Color(30, 144, 254));
        nextButton.setForeground(Color.WHITE);
        nextButton.setFont(new Font("Arial", Font.BOLD, 14));
        nextButton.addActionListener(this);
        nextButton.setEnabled(false);
        add(nextButton);

        // Result Label
        resultLabel = new JLabel("");
        resultLabel.setBounds(50, 200, 500, 30);
        resultLabel.setFont(new Font("Arial", Font.BOLD, 14));
        add(resultLabel);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void loadQuestion(String questionId) {
        try {
            String query = "SELECT question, answer FROM fill_question WHERE quizID = ? AND questionID = ?";
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setString(1, quizId);
            pstmt.setString(2, questionId);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                submitButton.setEnabled(true);
                answerField.setEnabled(true);
                questionLabel.setText(rs.getString("question"));
                correctAnswer = rs.getString("answer");
                answerField.setText("");
                resultLabel.setText("");
                question_count++;
                nextButton.setEnabled(false);
            } else {
                setMark((double) true_ans / question_count * 10);
                String massage = "Quiz completed!\n" + String.format("Result: %.2f", getMark());
                JOptionPane.showMessageDialog(this, massage);
                dispose();
                new fillQuizSelectionScreen();
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error loading question: " + e.getMessage());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            String userAnswer = answerField.getText().trim();

            if (userAnswer.isEmpty()) {
                resultLabel.setText("Please enter an answer!");
                resultLabel.setForeground(Color.RED);
                return;
            }

            if (userAnswer.equalsIgnoreCase(correctAnswer)) {
                resultLabel.setText("Correct! " + correctAnswer + " is the right answer!");
                resultLabel.setForeground(new Color(0, 150, 0));
                true_ans++;
            } else {
                resultLabel.setText("Incorrect. The correct answer is " + correctAnswer + ".");
                resultLabel.setForeground(Color.RED);
            }
            submitButton.setEnabled(false);
            answerField.setEnabled(false);
            nextButton.setEnabled(true);

        } else if (e.getSource() == nextButton) {
            currentQuestionId++;
            loadQuestion(String.format("FB%02d", currentQuestionId));
        }
    }
}