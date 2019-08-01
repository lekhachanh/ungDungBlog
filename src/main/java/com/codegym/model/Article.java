package com.codegym.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "article")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String writer;
    private String content;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date date;


    public Article() {
    }

    public Article(String title, String writer, Date date, String content) {
        this.title = title;
        this.writer = writer;
        this.date = date;
        this.content = content;
    }

    @Override
    public String toString(){
        return String.format("article[id=%d, title='%s', writer='%s', content='%s', date='%s', content='$s']", id, title,writer, date, content );
    }

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

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
