package com.wisezone.entity;

import java.util.Date;

public class Message {
    private Integer id;
    private String topic;
    private String content;
    private Date mesDate;
    private Author author;

    public Message() {
    }

    public Message(Integer id, String topic, String content, Date mesDate, Author author) {
        this.id = id;
        this.topic = topic;
        this.content = content;
        this.mesDate = mesDate;
        this.author = author;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", topic='" + topic + '\'' +
                ", content='" + content + '\'' +
                ", mesDate=" + mesDate +
                ", author=" + author +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getMesDate() {
        return mesDate;
    }

    public void setMesDate(Date mesDate) {
        this.mesDate = mesDate;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
