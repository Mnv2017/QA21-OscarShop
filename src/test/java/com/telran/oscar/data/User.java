package com.telran.oscar.data;

public class User {
    private String email;
    private String password;
    private String password2;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPassword2() {
        return password2;
    }

    public User setPassword2(String password2) {
        this.password2 = password2;
        return this;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    @Override
    public String toString() {
        return
                email + ", " + password;
    }
}
