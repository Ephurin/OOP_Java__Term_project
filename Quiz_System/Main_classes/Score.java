package Quiz_System.Main_classes;

public class Score {
    private int score, correctAnswers, wrongAnswers;
    private String Quiz_ID, Student_ID;

    Score(){
        this.score = 0;
        this.correctAnswers = 0;
        this.wrongAnswers = 0;
        this.Quiz_ID = "";
        this.Student_ID = "";
    }

    Score(int score, int correctAnswers, int wrongAnswers, String Quiz_ID, String Student_ID){
        this.score = score;
        this.correctAnswers = correctAnswers;
        this.wrongAnswers = wrongAnswers;
        this.Quiz_ID = Quiz_ID;
        this.Student_ID = Student_ID;
    }

    // getters

    public int getScore(){
        return this.score;
    }

    public int getCorrectAnswers(){
        return this.correctAnswers;
    }

    public int getWrongAnswers(){
        return this.wrongAnswers;
    }

    public String getQuiz_ID(){
        return this.Quiz_ID;
    }

    public String getStudent_ID(){
        return this.Student_ID;
    }

    // setters

    public void setScore(int score){
        this.score = score;
    }

    public void setCorrectAnswers(int rightAnswers){
        this.correctAnswers = rightAnswers;
    }

    public void setWrongAnswers(int wrongAnswers){
        this.wrongAnswers = wrongAnswers;
    }

    public void setQuiz_ID(String Quiz_ID){
        this.Quiz_ID = Quiz_ID;
    }

    public void setStudent_ID(String Student_ID){
        this.Student_ID = Student_ID;
    }

}
