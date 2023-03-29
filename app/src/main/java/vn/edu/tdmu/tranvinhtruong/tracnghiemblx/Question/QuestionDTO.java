package vn.edu.tdmu.tranvinhtruong.tracnghiemblx.Question;

public class QuestionDTO {

    private Integer IDQuestion;
    private String question;
    private String DA1;
    private String DA2;
    private String DA3;
    private String DA4;
    private String img;
    private String DL;
    private String GT;
    private String DA;
    private Integer ID_Exam;

    public int choiceID=-1;

    public String getTraloi() {
        return traloi;
    }

    public void setTraloi(String traloi) {
        this.traloi = traloi;
    }

    private String traloi="";

    public Integer getIDQuestion() {
        return IDQuestion;
    }

    public void setIDQuestion(Integer IDQuestion) {
        this.IDQuestion = IDQuestion;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getDA1() {
        return DA1;
    }

    public void setDA1(String DA1) {
        this.DA1 = DA1;
    }

    public String getDA2() {
        return DA2;
    }

    public void setDA2(String DA2) {
        this.DA2 = DA2;
    }

    public String getDA3() {
        return DA3;
    }

    public void setDA3(String DA3) {
        this.DA3 = DA3;
    }

    public String getDA4() {
        return DA4;
    }

    public void setDA4(String DA4) {
        this.DA4 = DA4;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDL() {
        return DL;
    }

    public void setDL(String DL) {
        this.DL = DL;
    }

    public String getGT() {
        return GT;
    }

    public void setGT(String GT) {
        this.GT = GT;
    }

    public String getDA() {
        return DA;
    }

    public void setDA(String DA) {
        this.DA = DA;
    }

    public Integer getID_Exam() {
        return ID_Exam;
    }

    public void setID_Exam(Integer ID_Exam) {
        this.ID_Exam = ID_Exam;
    }

    public QuestionDTO(String question, String DA1, String DA2, String DA3, String DA4, String img, String DL, String GT, String DA, Integer ID_Exam,String traloi) {
        this.question = question;
        this.DA1 = DA1;
        this.DA2 = DA2;
        this.DA3 = DA3;
        this.DA4 = DA4;
        this.img = img;
        this.DL = DL;
        this.GT = GT;
        this.DA = DA;
        this.ID_Exam = ID_Exam;
        this.traloi=traloi;

    }
}