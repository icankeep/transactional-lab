package com.example.transactionallab.controller;

import com.example.transactionallab.entity.Student;
import com.example.transactionallab.service.StudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 * @author passer
 * @time 2023/5/23 23:38
 */
@RequestMapping
@RestController
public class StudentController {

    @Resource
    private StudentService studentService;

    @GetMapping("/get_student")
    public Student getUser(@RequestParam Long id) {
        return studentService.getStudent(id);
    }

    @GetMapping("insert_student")
    public void insert(@RequestParam(defaultValue = "111") String name) {
        Student user = new Student();
        user.setName(name);
        studentService.addStudent(user);
    }
}
