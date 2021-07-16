package com.example.grad_1.models;

public class sost {
    String student_id;
    String student_image;

    public sost(String student_id,String encodedImage) {
        student_image=encodedImage;
        this.student_id=student_id;
    }

    public sost(String encodedImage) {
    }
}
