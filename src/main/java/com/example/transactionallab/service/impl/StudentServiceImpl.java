package com.example.transactionallab.service.impl;

import com.example.transactionallab.entity.Student;
import com.example.transactionallab.service.StudentService;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * @author passer
 * @time 2023/5/23 23:36
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Resource(name = "test1JdbcTemplate")
    private JdbcTemplate jdbcTemplate1;

    @Resource(name = "test2JdbcTemplate")
    private JdbcTemplate jdbcTemplate2;

    @Transactional
    @Override
    public void addStudent(Student user) {
        jdbcTemplate1.execute("insert into student(name) values ('test11')");

        jdbcTemplate2.execute("insert into student(name) values ('test22')");

        throw new RuntimeException(".....");
    }

    @Override
    public Student getStudent(Long id) {
        Student student1 = jdbcTemplate1.query("select id, name from student where id = " + id, new ResultSetExtractor<Student>() {
            public Student extractData(ResultSet rs) throws SQLException, DataAccessException {
                while (rs.next()) {
                    Student student = new Student();
                    student.setId(id);
                    student.setName(rs.getString("name"));
                    return student;
                }
                return null;
            }
        });
        System.out.println(student1);
        Student student2 = jdbcTemplate2.query("select id, name from student where id = " + id, new ResultSetExtractor<Student>() {
            public Student extractData(ResultSet rs) throws SQLException, DataAccessException {
                while (rs.next()) {
                    Student student = new Student();
                    student.setId(id);
                    student.setName(rs.getString("name"));
                    return student;
                }
                return null;
            }
        });
        System.out.println(student2);

        return student1;
    }
}
