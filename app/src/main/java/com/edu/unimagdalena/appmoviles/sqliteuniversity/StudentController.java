package com.edu.unimagdalena.appmoviles.sqliteuniversity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class StudentController {
    
    private DBHandler db;
    private Context c;

    public StudentController(Context c) {
        this.db = new DBHandler(c);
        this.c = c;
    }
    
    /**
     * CRUD(Create, Read, Update, Delete) Operations
     */

    public void addStudent(Student student) {
        SQLiteDatabase sql = db.getWritableDatabase();

        try {

            ContentValues values = new ContentValues();
            values.put(DefDB.KEY_STUDENT_CODE, student.getStudentCode());
            values.put(DefDB.KEY_STUDENT_NAME, student.getStudentName());
            values.put(DefDB.KEY_STUDENT_CAREER, student.getStudentCareer());

            long id = sql.insert(DefDB.TABLE_STUDENTS, null, values);
            sql.close();
            Toast.makeText(c, "Student added " , Toast.LENGTH_LONG).show();

        } catch (Exception ex) {
            Toast.makeText(c, "Error insert student " + ex.getMessage(), Toast.LENGTH_LONG).show();
            sql.close();
        }
    }

    // Getting single student details through Code
    public Student getStudent(int studentCode) {
        SQLiteDatabase sql = db.getReadableDatabase();
        Cursor cursor = sql.query(DefDB.TABLE_STUDENTS,
                new String[] { DefDB.KEY_STUDENT_CODE, DefDB.KEY_STUDENT_NAME, DefDB.KEY_STUDENT_CAREER },
                DefDB.KEY_STUDENT_CODE + "=?",
                new String[] { String.valueOf(studentCode) },
                null,
                null,
                null,
                null);

        if (cursor.getCount()>0) {
            cursor.moveToFirst();

            Student student = new Student(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2));

            //Return Student
            db.close();
            return student;
        }
        else
            {
                db.close();
                return null;
            }
    }

    // Getting All Student
    public Cursor allStudents(){
        try{
            SQLiteDatabase sql = db.getReadableDatabase();
            Cursor cur = sql.rawQuery("select studentCode as _id , studentName, studentCareer from students", null);
            return cur;
        }
        catch (Exception ex){
            Toast.makeText(c, "Error consulta estudiantes " + ex.getMessage(), Toast.LENGTH_LONG).show();
            return null;
        }
    }

    // Updating single student
    public int updateStudent(Student student) {
        SQLiteDatabase sql = db.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(DefDB.KEY_STUDENT_NAME, student.getStudentName());
        values.put(DefDB.KEY_STUDENT_CAREER, student.getStudentCareer());

        // updating student row
        return sql.update(DefDB.TABLE_STUDENTS,
                values,
                DefDB.KEY_STUDENT_CODE + " = ?",
                new String[] { String.valueOf(student.getStudentCode())});
    }

    // Deleting single student
    public void deleteStudent(Student student) {

        SQLiteDatabase sql = db.getWritableDatabase();
        sql.delete(DefDB.TABLE_STUDENTS,DefDB.KEY_STUDENT_CODE + " = ?",
                new String[] { String.valueOf(student.getStudentCode())});
        sql.close();
    }

}
