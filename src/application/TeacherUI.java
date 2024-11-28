package application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TeacherUI extends JFrame implements ActionListener {
    // Các nút trong thanh điều hướng
    JMenu newQuiz, updateQuiz, allQuiz, stuRes, logOut;


    public TeacherUI() {
        // Thiết lập JFrame
        setTitle("TEACHER");
        setSize(900, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
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

        updateQuiz = new JMenu("Update Quiz");
        ImageIcon iconUpdateQuiz = new ImageIcon("E:\\2024-2025\\quizmanagesystem\\src\\image\\follow-up.png");
        updateQuiz.setIcon(iconUpdateQuiz);
        menubar.add(updateQuiz);

        allQuiz = new JMenu("All Quiz");
        ImageIcon iconAllQuiz = new ImageIcon("E:\\2024-2025\\quizmanagesystem\\src\\image\\grid.png");
        allQuiz.setIcon(iconAllQuiz);
        menubar.add(allQuiz);

        stuRes = new JMenu("Student Result");
        ImageIcon iconStuRes = new ImageIcon("E:\\2024-2025\\quizmanagesystem\\src\\image\\medical-result.png");
        stuRes.setIcon(iconStuRes);
        menubar.add(stuRes);

        logOut = new JMenu("Log Out");
        ImageIcon iconLogOut = new ImageIcon("E:\\2024-2025\\quizmanagesystem\\src\\image\\logout.png");
        logOut.setIcon(iconLogOut);
        menubar.add(logOut);

        add(menubar, BorderLayout.NORTH);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);


    }
    public static void main(String[] args) {
        new TeacherUI();
    }
    @Override
    public void actionPerformed (ActionEvent e) {
        String text = e.getActionCommand();

        if(text.equals("Multiple Choice")) {
            new MultipleChoice();
        } else if (text.equals("Answer Filling")) {
            new AnswerFilling();

        }
    }
}

