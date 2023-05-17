package com.trigyn.librarymanagement.service;

import com.trigyn.librarymanagement.model.entity.Student;
import com.trigyn.librarymanagement.model.entity.Book;
import com.trigyn.librarymanagement.model.StudentVO;
import com.trigyn.librarymanagement.model.BookVO;
import com.trigyn.librarymanagement.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    private Student convertVo(StudentVO deptVO){
        Student student =new Student();
        student.setId(deptVO.getId());
        student.setName(deptVO.getStudentName());
        student.setAge(deptVO.getAge());
        return student;
    }

    public Boolean createDept(StudentVO deptVO){

        Student student = convertVo(deptVO);
        try {
            studentRepository.save(student);
        }catch(Exception exception){
            return false;
        }
        return true;

    }

    private List<BookVO> convertStudents(List<Book> books){
        List<BookVO> bookVOS = new ArrayList<>();
        for(Book book : books){
            BookVO bookVO =new BookVO();
            bookVO.setId(book.getId());
            bookVO.setTitle(book.getTitle());
            bookVO.setAuthor(book.getAuthor());
            bookVO.setDescription(book.getDescription());
            bookVO.setStudentId(book.getDept().getId());
            bookVOS.add(bookVO);
        }
        return bookVOS;
    }
    private StudentVO convertEntity(Student student){
        StudentVO deptVO=new StudentVO();
        StudentVO studentVO = new StudentVO();
        studentVO.setId(student.getId());
        studentVO.setStudentName(student.getName());
        studentVO.setAge(student.getAge());
        studentVO.setBooks(convertStudents(student.getBooks()));
        return studentVO;
    }

    public List<StudentVO> getAll(){
        List<StudentVO> deptList = new ArrayList<>();
        for(Student student : studentRepository.findAll()){
            deptList.add(convertEntity(student));
        }
        return deptList;
    }
}
