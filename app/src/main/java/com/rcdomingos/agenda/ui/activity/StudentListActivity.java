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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StudentListActivity extends AppCompatActivity {

    //subrescrever o metodo na hora da criacao da activity e adicionar comportamentos
    //Bundle mandar comportamentos para activity
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_list);

        setTitle("Lista de Alunos");
//        List<String> alunos = new ArrayList<>(Arrays.asList("Alex", "Fran", "Jose"));
        FloatingActionButton btnNewStudent = findViewById(R.id.activity_student_list_fab_new_student);
        btnNewStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StudentListActivity.this, StudentFormActivity.class));
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        StudentDAO studentDAO = new StudentDAO();
        ListView stundentList = findViewById(R.id.activity_student_list_listview);
        stundentList.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, studentDAO.findAll()));
    }
}
