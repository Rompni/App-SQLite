package com.edu.unimagdalena.appmoviles.sqliteuniversity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Student s;
    StudentController sc;
    EditText code, name, career;
    Button add, clear, list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        add = findViewById(R.id.btnAdd);
        clear = findViewById(R.id.btnClear);
        list = findViewById(R.id.btnList);
        code = findViewById(R.id.edtCode);
        name = findViewById(R.id.edtName);
        career = findViewById(R.id.edtCareer);
        add.setOnClickListener(this);
        clear.setOnClickListener(this);
        list.setOnClickListener(this);
        sc = new StudentController(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btnAdd:
                if(TextUtils.isEmpty(code.getText().toString()) || TextUtils.isEmpty(name.getText().toString()) || TextUtils.isEmpty(career.getText().toString())){
                    Toast.makeText(this,"Los datos no pueden ser vacíos", Toast.LENGTH_LONG).show();
                }
                else
                {
                    s = new Student(Integer.parseInt(code.getText().toString()), name.getText().toString(), career.getText().toString());
                    if(sc.getStudent(s.getStudentCode()) != null)
                        Toast.makeText(this,"Estudiante ya esta registrado", Toast.LENGTH_LONG).show();
                   else
                        sc.addStudent(s);
                }
                break;

            case R.id.btnClear:
                code.setText("");
                name.setText("");
                career.setText("");
                break;

            case R.id.btnList:
                Intent i = new Intent(this, StudentListActivity.class);
                //i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(i);
                break;


        }
    }
}
