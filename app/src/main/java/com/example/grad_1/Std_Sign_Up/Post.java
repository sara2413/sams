package com.example.grad_1.Std_Sign_Up;

public class Post {

        String email;
        String password;
        Boolean PrepYear;
        String Student_ID;
        String Student_Name;

    public Boolean getPrepYear() {
        return PrepYear;
    }

    public void setPrepYear(Boolean prepYear) {
        PrepYear = prepYear;
    }

    public String getStudent_ID() {
        return Student_ID;
    }

    public void setStudent_ID(String student_ID) {
        Student_ID = student_ID;
    }

    public String getStudent_Name() {
        return Student_Name;
    }

    public void setStudent_Name(String student_Name) {
        Student_Name = student_Name;
    }

    public Post(String email, Boolean prepYear, String student_ID, String student_Name) {
            this.email = email;
            PrepYear = prepYear;
            Student_ID = student_ID;
            Student_Name = student_Name;
        }

        public Post(Boolean prepYear, String student_ID, String student_Name) {
            PrepYear = prepYear;
            Student_ID = student_ID;
            Student_Name = student_Name;
        }

        public Post(String email, String password) {
            this.email = email;
            this.password = password;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

}
