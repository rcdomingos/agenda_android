package com.rcdomingos.agenda.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.rcdomingos.agenda.R;
import com.rcdomingos.agenda.dao.StudentDAO;

public class StudentListActivity extends AppCompatActivity {
    private static final String APPBAR_TITLE = "Lista de Alunos";
    private final StudentDAO studentDAO = new StudentDAO();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_list);
        setTitle(APPBAR_TITLE);

        configFloatButtonAdd();
    }

    private void configFloatButtonAdd() {
        FloatingActionButton btnNewStudent = findViewById(R.id.activity_student_list_fab_new_student);
        btnNewStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFormStudentActivity();
            }
        });
    }

    private void openFormStudentActivity() {
        startActivity(new Intent(this, StudentFormActivity.class));
    }

    @Override
    protected void onResume() {
        super.onResume();
        configStudentList();
    }

    private void configStudentList() {
        ListView stundentList = findViewById(R.id.activity_student_list_listview);
        stundentList.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, studentDAO.findAll()));
    }
}
