package com.telran.oscar.data;

public class User {
    private String email;
    private String password;
    private String password2;

    public static final String LOG_EMAIL = "nm123@mail.com";
    public static final String LOG_PASSWORD = "Qwerty123$";

    public static final String REG_EMAIL = "nm567@mail.com";
    public static final String REG_PASSWORD = "Qwerty123$";

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
