package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

import com.example.myapplication.model.Model;
import com.example.myapplication.model.Student;

import java.util.List;

public class StudentListActivity extends AppCompatActivity {

    List<Student> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_list);

        data = Model.instance().getAllStudents();

        ListView studentList = findViewById(R.id.StudentList);
        StudentLisaAdapter adapter = new StudentLisaAdapter();
        studentList.setAdapter(adapter);


    }

    class StudentLisaAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return 0;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            Student student = data.get(i);
            if (view == null){
                LayoutInflater inflater = getLayoutInflater();
                view = inflater.inflate(R.layout.activity_studetn_list_row, null);
                CheckBox cb = findViewById(R.id.studentlistrow_checkBox);
                cb.setOnClickListener((_view)->{
                    int pos = (int)_view.getTag();
                    Student _st = data.get(pos);
                    _st .checked = cb.isChecked();
                });
            }
            TextView name = view.findViewById(R.id.studentlistrow_name);
            name.setText(student.name);
            TextView id = view.findViewById(R.id.studentlistrow_id);
            id.setText(student.id);
            CheckBox cb = findViewById(R.id.studentlistrow_checkBox);
            cb.setChecked(student.checked);
            cb.setTag(i);
            return view;
        }
    }
}