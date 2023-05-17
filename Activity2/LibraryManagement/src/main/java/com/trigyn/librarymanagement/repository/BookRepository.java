package com.trigyn.librarymanagement.repository;

import com.trigyn.librarymanagement.model.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findStudentByTitle(String name);


    @Query("Select b from Book b where b.student.id = :id")
    List<Book> findBookByStudent(Long id);
}
