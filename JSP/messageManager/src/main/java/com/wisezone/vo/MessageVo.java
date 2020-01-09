package com.wisezone.vo;

public class MessageVo {
    private Integer id;
    private String topic;
    private String content;
    private String mesDate;
    private Integer authroId;
    private String author;

    @Override
    public String toString() {
        return "MessageVo{" +
                "id=" + id +
                ", topic='" + topic + '\'' +
                ", content='" + content + '\'' +
                ", mesDate='" + mesDate + '\'' +
                ", authroId=" + authroId +
                ", author='" + author + '\'' +
                '}';
    }

    public MessageVo() {
    }

    public MessageVo(Integer id, String topic, String content, String mesDate, Integer authroId, String author) {
        this.id = id;
        this.topic = topic;
        this.content = content;
        this.mesDate = mesDate;
        this.authroId = authroId;
        this.author = author;
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

    public String getMesDate() {
        return mesDate;
    }

    public void setMesDate(String mesDate) {
        this.mesDate = mesDate;
    }

    public Integer getAuthroId() {
        return authroId;
    }

    public void setAuthroId(Integer authroId) {
        this.authroId = authroId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
