package com.qinbaoge.hngmanagementsystem.Entity;

public class Username {
    private int id;
    private String username;
    private String password;
    private String qq_number;

    public int getId() {
        return id;
    }

    public String getQq_number() {
        return qq_number;
    }

    public void setQq_number(String qq_number) {
        this.qq_number = qq_number;
    }

    public void setId(int id) {
        this.id = id;
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
}
