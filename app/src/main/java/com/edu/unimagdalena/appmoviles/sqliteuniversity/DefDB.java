package com.edu.unimagdalena.appmoviles.sqliteuniversity;

public class DefDB {

    public static final int DATABASE_VERSION = 2;
    public  static final String DATABASE_NAME = "university";
    // table name
    public  static final String TABLE_STUDENTS = "students";
    // Market Table Columns names
    public  static final String KEY_STUDENT_CODE = "studentCode";
    public  static final String KEY_STUDENT_NAME = "studentName";
    public  static final String KEY_STUDENT_CAREER= "studentCareer";

    //Query to create table
    public static final String CREATE_STUDENTS_TABLE = "CREATE TABLE IF NOT EXISTS "
            + TABLE_STUDENTS + "("
            + KEY_STUDENT_CODE + " INTEGER (10) PRIMARY KEY, "
            + KEY_STUDENT_NAME+ " TEXT, "
            + KEY_STUDENT_CAREER + " TEXT"
            + ")";

}
