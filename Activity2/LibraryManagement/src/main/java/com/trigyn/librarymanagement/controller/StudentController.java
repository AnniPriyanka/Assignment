package com.trigyn.librarymanagement.controller;

import com.trigyn.librarymanagement.model.StudentVO;
import com.trigyn.librarymanagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/student")
    List<StudentVO> getDept() {
        return studentService.getAll();
    }

    @PostMapping("/student")
    Boolean createDept(@RequestBody StudentVO studentVO) {
        return studentService.createDept(studentVO);
    }

}
