package com.trigyn.librarymanagement.service;

import com.trigyn.librarymanagement.model.entity.Student;
import com.trigyn.librarymanagement.model.entity.Book;
import com.trigyn.librarymanagement.model.BookVO;
import com.trigyn.librarymanagement.repository.StudentRepository;
import com.trigyn.librarymanagement.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    @Autowired
    StudentRepository studentRepository;

    private Book convertVO(BookVO bookVO) {
        Book book = new Book();
        book.setId(bookVO.getId());
        book.setTitle(bookVO.getTitle());
        book.setAuthor(bookVO.getAuthor());
        book.setDescription(bookVO.getDescription());
        Student student = null;
        if(bookVO.getStudentId()!= null){
            student = studentRepository.findById(bookVO.getStudentId()).get();
            book.setDept(student);
        }
        return book;
    }

    public Boolean createStudent(BookVO bookVO) {
        Book book = convertVO(bookVO);
        try {
            bookRepository.save(book);
        } catch (Exception exception) {
            return false;
        }
        return true;
    }

    private BookVO convertEntity(Book book) {
        BookVO bookVO = new BookVO();
        bookVO.setId(book.getId());
        bookVO.setTitle(book.getTitle());
        bookVO.setAuthor(book.getAuthor());
        bookVO.setDescription(book.getDescription());
        bookVO.setStudentId(book.getDept().getId());
        return bookVO;
    }

    public List<BookVO> getAll(){
        List<BookVO> studentList = new ArrayList<>();
        for(Book book : bookRepository.findAll()){
            studentList.add(convertEntity(book));
        }
        return studentList;
    }

    public List<BookVO> findStudentByName(String name){
        List<BookVO> studentList = new ArrayList<>();
        for(Book book : bookRepository.findStudentByTitle(name)){
            studentList.add(convertEntity(book));
        }
        return studentList;
    }




    public List<BookVO> getStudentByDept(Long id){
        List<BookVO> bookList = new ArrayList<>();
        for(Book book : bookRepository.findBookByStudent(id)){
            bookList.add(convertEntity(book));
        }
        return bookList;
    }

}
