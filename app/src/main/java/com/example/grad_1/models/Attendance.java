package com.example.grad_1.models;

import com.google.gson.annotations.SerializedName;

public class Attendance {

    @SerializedName("student_id")
    private String student_id;
    @SerializedName("week_1")
    private String week_1;
    @SerializedName("week_2")
    private String week_2;
    @SerializedName("week_3")
    private String week_3;
    @SerializedName("week_4")
    private String week_4;
    @SerializedName("week_5")
    private String week_5;
    @SerializedName("week_6")
    private String week_6;
    @SerializedName("week_7")
    private String week_7;
    @SerializedName("week_8")
    private String week_8;

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getWeek_1() {
        return week_1;
    }

    public void setWeek_1(String week_1) {
        this.week_1 = week_1;
    }

    public String getWeek_2() {
        return week_2;
    }

    public void setWeek_2(String week_2) {
        this.week_2 = week_2;
    }

    public String getWeek_3() {
        return week_3;
    }

    public void setWeek_3(String week_3) {
        this.week_3 = week_3;
    }

    public String getWeek_4() {
        return week_4;
    }

    public void setWeek_4(String week_4) {
        this.week_4 = week_4;
    }

    public String getWeek_5() {
        return week_5;
    }

    public void setWeek_5(String week_5) {
        this.week_5 = week_5;
    }

    public String getWeek_6() {
        return week_6;
    }

    public void setWeek_6(String week_6) {
        this.week_6 = week_6;
    }

    public String getWeek_7() {
        return week_7;
    }

    public void setWeek_7(String week_7) {
        this.week_7 = week_7;
    }

    public String getWeek_8() {
        return week_8;
    }

    public void setWeek_8(String week_8) {
        this.week_8 = week_8;
    }
}
