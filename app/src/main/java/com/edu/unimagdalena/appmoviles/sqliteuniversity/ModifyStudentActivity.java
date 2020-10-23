package com.edu.unimagdalena.appmoviles.sqliteuniversity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ModifyStudentActivity extends AppCompatActivity implements View.OnClickListener{
    Student s;
    StudentController sc;
    EditText name, career;
    TextView code;
    Button save, delete, cancel;
    String cd, nm, cr;
    Intent data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_student);

        save =  findViewById(R.id.btnSave);
        delete = findViewById(R.id.btnDelete);
        cancel = findViewById(R.id.btnCancel);

        code = findViewById(R.id.mdfCode);
        name = findViewById(R.id.mdfName);
        career =  findViewById(R.id.mdfCareer);

        save.setOnClickListener(this);
        delete.setOnClickListener(this);
        cancel.setOnClickListener(this);
        sc = new StudentController(this);
        cd = ""; nm = ""; cr = "";

        data = getIntent();
        cd = data.getStringExtra("itemCode");

        if(cd != null) {
            Student student = sc.getStudent(Integer.parseInt(cd));
            code.setText(String.valueOf(student.getStudentCode()));
            name.setText(student.getStudentName());
            career.setText(student.getStudentCareer());

        }

    }

    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.btnSave:
                if( TextUtils.isEmpty(name.getText().toString()) || TextUtils.isEmpty(career.getText().toString())){
                    Toast.makeText(this,"Los datos no pueden ser vacíos", Toast.LENGTH_LONG).show();
                }else
                    {
                        s = new Student(Integer.parseInt(code.getText().toString()),name.getText().toString(), career.getText().toString());
                        long rows = sc.updateStudent(s);
                        if(rows > 0 )
                            Toast.makeText(this,"Los datos se actualizaron correctamente", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(this,"Error al actualizar", Toast.LENGTH_LONG).show();
                    }
                break;

            case R.id.btnCancel:
                Intent i = new Intent(this, StudentListActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(i);
                break;

            case R.id.btnDelete:
                s = sc.getStudent(Integer.parseInt(code.getText().toString()));
                if(s != null) {
                    sc.deleteStudent(s);
                    Toast.makeText(this,"Estudiante eliminado correctamente", Toast.LENGTH_LONG).show();
                    Intent j = new Intent(this, StudentListActivity.class);
                    j.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(j);
                }
                else
                    {
                        Toast.makeText(this,"error al eliminar", Toast.LENGTH_LONG).show();
                    }
                break;


        }
    }
}
