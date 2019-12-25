package com.wisezone.vo;

public class StudentScoreVo {
    private int studentNo;
    private String name;
    private String phone;
    private int scoreId;
    private String course;
    private double score;

    public StudentScoreVo() {
    }

    public StudentScoreVo(int studentNo, String name, String phone, int scoreId, String course, double score) {
        this.studentNo = studentNo;
        this.name = name;
        this.phone = phone;
        this.scoreId = scoreId;
        this.course = course;
        this.score = score;
    }

    public int getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(int studentNo) {
        this.studentNo = studentNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getScoreId() {
        return scoreId;
    }

    public void setScoreId(int scoreId) {
        this.scoreId = scoreId;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "StudentScoreVo{" +
                "studentNo=" + studentNo +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", scoreId=" + scoreId +
                ", course='" + course + '\'' +
                ", score=" + score +
                '}';
    }
}
