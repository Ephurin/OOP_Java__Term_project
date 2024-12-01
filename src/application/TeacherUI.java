package application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TeacherUI extends JFrame implements ActionListener {
    // Các nút trong thanh điều hướng
    JMenu newQuiz, updateQuiz, allQuiz, stuRes, logOut;
    JTextField searchQuiz;
    JButton search;

    public TeacherUI() {
        // Thiết lập JFrame
        setTitle("TEACHER");
        setSize(900, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        // icon frame
        ImageIcon iconTeacher = new ImageIcon("E:\\2024-2025\\quizmanagesystem\\src\\image\\teacher.png");
        setIconImage(iconTeacher.getImage());

        JMenuBar menubar = new JMenuBar();
        setJMenuBar(menubar);

        newQuiz = new JMenu("New Quiz");
        ImageIcon icNewQuiz = new ImageIcon("E:\\2024-2025\\quizmanagesystem\\src\\image\\add.png");
        newQuiz.setIcon(icNewQuiz);
        menubar.add(newQuiz);

        JMenuItem mc = new JMenuItem("Multiple Choice");
        mc.addActionListener(this);
        ImageIcon icMC = new ImageIcon("E:\\2024-2025\\quizmanagesystem\\src\\image\\option.png");
        mc.setIcon(icMC);
        newQuiz.add(mc);

        JMenuItem answerFilling = new JMenuItem("Answer Filling");
        answerFilling.addActionListener(this);
        ImageIcon icAnswerFilling = new ImageIcon("E:\\2024-2025\\quizmanagesystem\\src\\image\\answer.png");
        answerFilling.setIcon(icAnswerFilling);
        newQuiz.add(answerFilling);
        //allquiz
        allQuiz = new JMenu("All Quiz");
        ImageIcon iconAllQuiz = new ImageIcon("E:\\2024-2025\\quizmanagesystem\\src\\image\\grid.png");
        allQuiz.setIcon(iconAllQuiz);
        menubar.add(allQuiz);

        JMenuItem mc1 = new JMenuItem("All Multiple Choice Quiz");
        mc1.addActionListener(this);
        ImageIcon icMC1 = new ImageIcon("E:\\2024-2025\\quizmanagesystem\\src\\image\\option.png");
        mc1.setIcon(icMC1);
        allQuiz.add(mc1);

        JMenuItem answerFilling1 = new JMenuItem("All Answer Filling Quiz");
        answerFilling1.addActionListener(this);
        ImageIcon icAnswerFilling1 = new ImageIcon("E:\\2024-2025\\quizmanagesystem\\src\\image\\answer.png");
        answerFilling1.setIcon(icAnswerFilling1);
        allQuiz.add(answerFilling1);

        stuRes = new JMenu("Student Result");
        ImageIcon iconStuRes = new ImageIcon("E:\\2024-2025\\quizmanagesystem\\src\\image\\medical-result.png");
        stuRes.setIcon(iconStuRes);
        menubar.add(stuRes);

        logOut = new JMenu("Log Out");
        ImageIcon iconLogOut = new ImageIcon("E:\\2024-2025\\quizmanagesystem\\src\\image\\logout.png");
        logOut.setIcon(iconLogOut);
        menubar.add(logOut);
        JMenuItem logOutItem = new JMenuItem("Log Out");
        logOutItem.setIcon(iconLogOut);
        logOutItem.addActionListener(this);
        logOut.add(logOutItem);  // Thêm JMenuItem vào JMenu


        JLabel s = new JLabel("SEARCH QUIZ");
        s.setBounds(200, 150, 200, 20);
        add(s);
        searchQuiz = new JTextField();
        searchQuiz.setBounds(350, 150, 200, 20);
        ImageIcon icSearch = new ImageIcon("E:\\2024-2025\\quizmanagesystem\\src\\image\\search-results_5358562.png");
        s.setIcon(icSearch);
        add(searchQuiz);
        search = new JButton("Search");
        search.setBounds(600, 150, 100, 20);
        search.setBackground(new Color(0, 51, 102));
        search.setForeground(Color.WHITE);
        search.setFont(new Font("Arial", Font.BOLD, 11)); // Chọn font Arial, kiểu chữ thường, cỡ 16
        search.addActionListener(this);
        add(search);

        add(menubar, BorderLayout.NORTH);
        //setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);


    }
    public static void main(String[] args) {
        new TeacherUI();
    }
    @Override
    public void actionPerformed (ActionEvent e) {
        String text = e.getActionCommand();

        if(text.equals("Multiple Choice")) {
            //String s = "Multiple Choice";
            new createQuiz(text);
        } else if (text.equals("Answer Filling")) {
            //String s = "Answer Filling";
            new createQuiz(text);
        } else if (text.equals("All Multiple Choice Quiz")) {
            new AllQuiz();
        }

         else if (text.equals("Log Out")) {
            setVisible(false);
            new Login();
        }
         if(e.getSource() == search) {
             String searchContent = searchQuiz.getText();
             new UpdateQuiz(searchContent);
         }
    }
}

