package com.edu.unimagdalena.appmoviles.sqliteuniversity;

public class Student {

    private int studentCode;
    private String studentName;
    private  String studentCareer;

    public Student() {
    }

    public Student(int studentCode, String studentName, String studentCareer) {
        this.studentCode = studentCode;
        this.studentName = studentName;
        this.studentCareer = studentCareer;
    }

    public int getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(int studentCode) {
        this.studentCode = studentCode;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentCareer() {
        return studentCareer;
    }

    public void setStudentCareer(String studentCareer) {
        this.studentCareer = studentCareer;
    }
}
