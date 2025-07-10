package com.summerpep.lib.service;

import com.summerpep.lib.dao.StudentRepository;
import com.summerpep.model.Student;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepository studentRepository;
    Student findById(int roll){
        Optional<Student>optionalStudent=studentRepository.findById(roll);
        return optionalStudent.orElse(null);
    }
    @Override
    @Transactional
    public Student add(Student student) {
        return studentRepository.save(student);
    }
}
