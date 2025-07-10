package com.summerpep.lib.service;

import com.summerpep.lib.dao.StudentRepository;
import com.summerpep.model.Student;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LibraryServiceImpl {
    @Autowired
    StudentRepository studentRepository;

    @Transactional
    public void issueBook(int bid, int roll){
        Student student=studentRepository.findById(roll).get();
    }
}
