package application;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentUI extends JFrame implements ActionListener {
    // Buttons
    JButton btnTakeQuiz, btnLogOut;
    JPopupMenu quizMenu;

    public StudentUI() {
        // Setup JFrame
        setTitle("Student Portal");
        setSize(900, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Header - Title
        JLabel headerLabel = new JLabel("Welcome to the Student Portal!", JLabel.CENTER);
        headerLabel.setFont(new Font("Serif", Font.BOLD, 24));
        headerLabel.setForeground(new Color(33, 37, 41)); // Dark gray
        headerLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        add(headerLabel, BorderLayout.NORTH);

        // Create Buttons
        btnTakeQuiz = new JButton("Take Quiz");
        btnTakeQuiz.setFont(new Font("Serif", Font.PLAIN, 14));
        btnTakeQuiz.setPreferredSize(new Dimension(150, 40));
        btnTakeQuiz.setBackground(new Color(72, 149, 239)); // Light blue
        btnTakeQuiz.setForeground(Color.WHITE);
        btnTakeQuiz.setFocusPainted(false);
        btnTakeQuiz.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnTakeQuiz.addActionListener(this);

        btnLogOut = new JButton("Log Out");
        btnLogOut.setFont(new Font("Serif", Font.PLAIN, 14));
        btnLogOut.setPreferredSize(new Dimension(150, 40));
        btnLogOut.setBackground(new Color(220, 53, 69)); // Red
        btnLogOut.setForeground(Color.WHITE);
        btnLogOut.setFocusPainted(false);
        btnLogOut.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnLogOut.addActionListener(this);

        // Add Buttons to a Centered Panel
        JPanel buttonPanel = new JPanel(new GridBagLayout());
        buttonPanel.setBackground(new Color(248, 249, 250)); // Light gray background
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        gbc.gridx = 0;
        gbc.gridy = 0;
        buttonPanel.add(btnTakeQuiz, gbc);

        gbc.gridy = 1;
        buttonPanel.add(btnLogOut, gbc);

        add(buttonPanel, BorderLayout.CENTER);

        // Footer - Info
        JLabel footerLabel = new JLabel("© 2024 Student Management System", JLabel.CENTER);
        footerLabel.setFont(new Font("Serif", Font.PLAIN, 12));
        footerLabel.setForeground(new Color(108, 117, 125)); // Muted gray
        footerLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        add(footerLabel, BorderLayout.SOUTH);

        // Quiz Menu
        quizMenu = new JPopupMenu();

        JMenuItem multipleChoiceOption = new JMenuItem("Multiple Choice Question");
        multipleChoiceOption.addActionListener(e -> new ResultScreen());
        quizMenu.add(multipleChoiceOption);

        JMenuItem answerFillingOption = new JMenuItem("Answer Filling Question");
        answerFillingOption.addActionListener(e -> new AnswerFillingScreen());
        quizMenu.add(answerFillingOption);

        // Finalize JFrame
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new StudentUI()); // Ensures the UI is created on the Event Dispatch Thread
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnTakeQuiz) {
            // Show quiz options
            quizMenu.show(btnTakeQuiz, btnTakeQuiz.getWidth() / 2, btnTakeQuiz.getHeight() / 2);
        } else if (e.getSource() == btnLogOut) {
            int response = JOptionPane.showConfirmDialog(
                    this,
                    "Are you sure you want to log out?",
                    "Confirm Log Out",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE
            );

            if (response == JOptionPane.YES_OPTION) {
                System.exit(0); // Exit the program
            }
        }
    }
}

class ResultScreen extends JFrame {
    public ResultScreen() {
        setTitle("Quiz Result");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // Header
        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new GridLayout(3, 2));
        headerPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        headerPanel.setBackground(new Color(248, 249, 250));
        headerPanel.add(new JLabel("Student Name:"));
        headerPanel.add(new JLabel("John Doe")); // Example name
        headerPanel.add(new JLabel("Class:"));
        headerPanel.add(new JLabel("10A1")); // Example class
        headerPanel.add(new JLabel("Completion Time:"));
        headerPanel.add(new JLabel("10 minutes")); // Example time
        add(headerPanel, BorderLayout.NORTH);

        // Body - Result Table
        String[] columnNames = {"Question", "Selected Answer", "Correct Answer", "Result", "Score"};
        Object[][] data = {
                {"Question 1", "B", "C", "❌", 0},
                {"Question 2", "A", "A", "✅", 1}
        };
        JTable resultTable = new JTable(new DefaultTableModel(data, columnNames));
        JScrollPane scrollPane = new JScrollPane(resultTable);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        add(scrollPane, BorderLayout.CENTER);

        // Footer
        JPanel footerPanel = new JPanel();
        footerPanel.setLayout(new GridLayout(2, 1));
        footerPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        footerPanel.add(new JLabel("Total Score: 1/2"));
        footerPanel.add(new JLabel("Feedback: Needs improvement."));
        add(footerPanel, BorderLayout.SOUTH);

        // Finalize JFrame
        setVisible(true);
    }
}

class AnswerFillingScreen extends JFrame {
    public AnswerFillingScreen() {
        setTitle("Answer Filling Quiz");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // Header
        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new GridLayout(3, 2));
        headerPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        headerPanel.setBackground(new Color(248, 249, 250));
        headerPanel.add(new JLabel("Student Name:"));
        headerPanel.add(new JLabel("John Doe")); // Example name
        headerPanel.add(new JLabel("Class:"));
        headerPanel.add(new JLabel("10A1")); // Example class
        headerPanel.add(new JLabel("Completion Time:"));
        headerPanel.add(new JLabel("5 minutes")); // Example time
        add(headerPanel, BorderLayout.NORTH);

        // Body - Answer Filling Table
        String[] columnNames = {"Question", "Your Answer", "Correct Answer", "Result", "Score"};
        Object[][] data = {
                {"What is the capital of France?", "", "Paris", "❌", 0},
                {"Solve: 5 + 3", "", "8", "❌", 0}
        };

        JTable answerTable = new JTable(new DefaultTableModel(data, columnNames)) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 1; // Allow editing only in "Your Answer" column
            }
        };
        JScrollPane scrollPane = new JScrollPane(answerTable);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        add(scrollPane, BorderLayout.CENTER);

        // Footer
        JPanel footerPanel = new JPanel();
        footerPanel.setLayout(new GridLayout(2, 1));
        footerPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        footerPanel.add(new JLabel("Total Score: 0/2"));
        footerPanel.add(new JLabel("Feedback: Keep trying."));
        add(footerPanel, BorderLayout.SOUTH);

        // Finalize JFrame
        setVisible(true);
    }
}
