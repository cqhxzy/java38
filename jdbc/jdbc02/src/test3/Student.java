package test3;

import java.util.Date;

/**
 * 学生的实体类，对应数据库中的student表
 */
public class Student {
    private int studentNo;
    private String name;
    private String loginPwd;
    private String gender;
    private String phone;
    private String address;
    private Date bornDate;

    public Student() {
    }

    public Student(int studentNo, String name, String loginPwd, String gender, String phone, String address, Date bornDate) {
        this.studentNo = studentNo;
        this.name = name;
        this.loginPwd = loginPwd;
        this.gender = gender;
        this.phone = phone;
        this.address = address;
        this.bornDate = bornDate;
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

    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBornDate() {
        return bornDate;
    }


    public void setBornDate(Date bornDate) {
        this.bornDate = bornDate;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentNo=" + studentNo +
                ", name='" + name + '\'' +
                ", loginPwd='" + loginPwd + '\'' +
                ", gender='" + gender + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", bornDate=" + bornDate +
                '}';
    }
}
