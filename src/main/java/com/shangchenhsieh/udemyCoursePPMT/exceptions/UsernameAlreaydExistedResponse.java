package com.shangchenhsieh.udemyCoursePPMT.exceptions;

public class UsernameAlreaydExistedResponse {
    private String username;

    public UsernameAlreaydExistedResponse(String username) {
        this.username = username;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
