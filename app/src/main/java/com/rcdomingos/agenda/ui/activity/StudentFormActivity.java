package com.rcdomingos.agenda.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.rcdomingos.agenda.R;
import com.rcdomingos.agenda.dao.StudentDAO;
import com.rcdomingos.agenda.model.Student;

public class StudentFormActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_form);

        final StudentDAO studentDAO = new StudentDAO();

        final EditText fieldName = findViewById(R.id.activity_student_form_name);
        final EditText fieldPhone = findViewById(R.id.activity_student_form_phone);
        final EditText fieldEmail = findViewById(R.id.activity_student_form_email);

        //botão salvar
        Button btnSave = findViewById(R.id.activity_student_form_btn_save);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = fieldName.getText().toString();
                String phone = fieldPhone.getText().toString();
                String email = fieldEmail.getText().toString();
                Student student = new Student(name, phone, email);

                studentDAO.save(student);

                //ir para outra activity
                // startActivity(new Intent(StudentFormActivity.this, StudentListActivity.class));

                //encerrar a activity
                finish();
            }
        });
    }
}