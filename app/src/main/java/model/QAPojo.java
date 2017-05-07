package model;

/**
 * Created by rutu001 on 5/5/17.
 */
public class QAPojo {

    int imgNum;
    int questionNum;
    String questionTxt;
    String option1;
    String option2;
    String option3;
    String option4;
    String option5;
    int ansValue;


    public int getQuestionNumber() {
        return questionNum;
    }

    public void setQuestionNumber(int questionNumber) {
        this.questionNum = questionNumber;
    }
    public int getAnswer() {
        return ansValue;
    }

    public void setAnswer(int answer) {
        this.ansValue = answer;
    }

    public int getImg1() {
        return imgNum;
    }

    public void setImg1(int imgNum) {
        this.imgNum = imgNum;
    }

    public String getQuestion() {
        return questionTxt;
    }

    public void setQuestion(String question) {
        this.questionTxt = question;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public String getOption4() {
        return option4;
    }

    public void setOption4(String option4) {
        this.option4 = option4;
    }

    public String getOption5() {
        return option5;
    }

    public void setOption5(String option5) {
        this.option5 = option5;
    }

    public String getGroupItem() {
        return groupItem;
    }

    public void setGroupItem(String groupItem) {
        this.groupItem = groupItem;
    }

    String groupItem;

}
