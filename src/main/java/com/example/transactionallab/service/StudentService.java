package com.example.transactionallab.service;

import com.example.transactionallab.entity.Student;

/**
 * @author passer
 * @time 2023/5/23 23:35
 */
public interface StudentService {
    void addStudent(Student user);

    Student getStudent(Long id);
}
