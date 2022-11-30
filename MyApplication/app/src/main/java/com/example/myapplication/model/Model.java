package com.example.myapplication.model;

import java.util.LinkedList;
import java.util.List;

public class Model {
    private static final Model instance = new Model();

    private Model(){
        for(int i=0; i<20; i++){
            Student student = new Student("name "+i, ""+i,"",false);
            addStudent(student);
        }
    }

    public static Model instance(){
        return instance;
    }
    List<Student> data = new LinkedList<>();

    public List<Student> getAllStudents(){
        return data;
    }

    void addStudent(Student student){
        data.add(student);
    }
}
