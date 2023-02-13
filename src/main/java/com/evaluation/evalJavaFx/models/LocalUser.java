package com.evaluation.evalJavaFx.models;


import java.util.ArrayList;
import java.util.List;

public class LocalUser {
    private String username;
    private String password;
    private List<Integer> categoryList = new ArrayList<Integer>();

    private String role;

    public LocalUser() {}

    public LocalUser(String username, String password, List<Integer> categoryList, String role) {
        this.username = username;
        this.password = password;
        this.categoryList = categoryList;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Integer> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Integer> categoryList) {
        this.categoryList = categoryList;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
