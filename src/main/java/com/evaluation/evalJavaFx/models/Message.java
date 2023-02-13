package com.evaluation.evalJavaFx.models;

public class Message {

    private String content;
    private int categoryId;

    public Message() {
    }

    public Message(String content, int category) {
        this.content = content;
        this.categoryId = category;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
}
