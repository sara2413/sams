package com.example.grad_1.models;

import com.google.gson.annotations.SerializedName;

public class Subjects {
    @SerializedName("subject")
    private String subject;
    @SerializedName("professor_name")
    private String professor_name;

    public String getProfessor_name() {
        return professor_name;
    }

    public void setProfessor_name(String professor_name) {
        this.professor_name = professor_name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
