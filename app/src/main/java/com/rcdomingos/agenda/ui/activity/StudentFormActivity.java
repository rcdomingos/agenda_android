package com.rcdomingos.agenda.ui.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.rcdomingos.agenda.R;
import com.rcdomingos.agenda.dao.StudentDAO;
import com.rcdomingos.agenda.model.Student;

public class StudentFormActivity extends AppCompatActivity {

    private EditText fieldName;
    private EditText fieldPhone;
    private EditText fieldEmail;

    private static final String APPBAR_TITLE = "Novo Aluno";
    private final StudentDAO studentDAO = new StudentDAO();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_form);
        setTitle(APPBAR_TITLE);

        fieldInitialization();
        configSaveButton();
    }

    private void configSaveButton() {
        Button btnSave = findViewById(R.id.activity_student_form_btn_save);
        btnSave.setOnClickListener((view) -> {
            Student student = createNewStudent();
            saveAndFinish(student);
        });
    }

    private void fieldInitialization() {
        fieldName = findViewById(R.id.activity_student_form_name);
        fieldPhone = findViewById(R.id.activity_student_form_phone);
        fieldEmail = findViewById(R.id.activity_student_form_email);
    }

    private void saveAndFinish(Student student) {
        studentDAO.save(student);
        //encerrar a activity
        finish();
    }

    @NonNull
    private Student createNewStudent() {
        String name = fieldName.getText().toString();
        String phone = fieldPhone.getText().toString();
        String email = fieldEmail.getText().toString();
        Student student = new Student(name, phone, email);
        return student;
    }
}