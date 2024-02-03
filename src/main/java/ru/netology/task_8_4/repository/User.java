package ru.netology.task_8_4.repository;

import ru.netology.task_8_4.model.Authorities;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String user;
    private String password;
    private List<Authorities> authorities;

    public User(String user, String password) {
        this.user = user;
        this.password = password;
        this.authorities = new ArrayList<>();
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void addAuthority(Authorities authority) {
        if (!this.authorities.contains(authority)) {
            this.authorities.add(authority);
        }
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public List<Authorities> getAuthorities() {
        return authorities;
    }
}