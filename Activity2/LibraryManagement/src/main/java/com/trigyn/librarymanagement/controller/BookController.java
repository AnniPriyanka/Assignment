package com.trigyn.librarymanagement.controller;

import com.trigyn.librarymanagement.model.BookVO;
import com.trigyn.librarymanagement.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping("/book")
    List<BookVO> getStudent(@RequestParam(required = false) String name)
    {
        if (name != null)
            return bookService.findStudentByName(name);
        else
            return bookService.getAll();
    }


    @PostMapping("/book")
    Boolean createStudent(@RequestBody BookVO bookVO){
        return bookService.createStudent(bookVO);
    }

//    @GetMapping("/getStudentByName")
//    List<StudentVO> getStudentByName(@RequestParam(required = false) String name)
//    {
//        if (name != null)
//            return studentService.getStudentByName(name);
//        else
//            return studentService.getAll();
//    }



//    @GetMapping("/getstudentbydeptid")
//    List<StudentVO> getStudentByDeptId(@RequestParam (required = false) Long id) {
//        if (id != null)
//            return studentService.getStudentByDept(id);
//        else
//            return studentService.getAll();
//    }

}
