package com.edu.unimagdalena.appmoviles.sqliteuniversity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.security.spec.ECField;
import java.util.ArrayList;
import java.util.List;

public class StudentListActivity extends AppCompatActivity {

    ListView studentList;
    Cursor students;
    StudentController stdController;
    Button back;
    Context c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_list);
        try {
            studentList = findViewById(R.id.studentlist);
            stdController = new StudentController(this);
            students = stdController.allStudents();
            c = this;
            StudentAdapter sAdapter = new StudentAdapter(this, students, false);
            studentList.setAdapter(sAdapter);
            back = findViewById(R.id.btnBack);

            back.setOnClickListener(new AdapterView.OnClickListener(){

                @Override
                public void onClick(View v){

                    Intent i = new Intent(c, MainActivity.class);
                    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(i);

                }
            });

            studentList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    TextView code = view.findViewById(R.id.txtCode);
                    Intent i = new Intent(c, ModifyStudentActivity.class);
                    i.putExtra("itemCode",code.getText().toString());
                    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(i);
                }
            });
        }catch(Exception ex) {
            Toast.makeText(getApplicationContext(), "Error "+ex.getMessage(), Toast.LENGTH_LONG).show();
            System.out.println(ex.getMessage());
        }

    }
}
