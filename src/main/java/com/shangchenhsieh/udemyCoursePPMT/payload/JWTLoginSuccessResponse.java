package com.shangchenhsieh.udemyCoursePPMT.payload;

public class JWTLoginSuccessResponse {
    private boolean success;
    private String token;

    public JWTLoginSuccessResponse(boolean succ, String tok) {
        this.success = succ;
        this.token = tok;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "JWTLoginSucessReponse{" +
                "success=" + success +
                ", token='" + token + '\'' +
                '}';
    }


}
