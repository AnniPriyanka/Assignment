package com.trigyn.librarymanagement.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Book {

    @Id
    private Long id;

    @Column(name="title")
    private String title;

    @Column
    private String author;

    @Column
    private String description;

    @ManyToOne
    Student student;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Student getDept() {
        return student;
    }

    public void setDept(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", description='" + description + '\'' +
                ", dept=" + student +
                '}';
    }
}
