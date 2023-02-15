package com.libraray.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document(collection = "student")
public class Student {
    @Id
    private UUID student_id;
    private String studentName;
    private long mobileNumber;
    private String email;
    private long enroll;
    private Address address;

    public Student(UUID student_id, String studentName, long mobileNumber, String email, long enroll, Address address) {
        this.student_id = student_id;
        this.studentName = studentName;
        this.mobileNumber = mobileNumber;
        this.email = email;
        this.enroll = enroll;
        this.address = address;
    }

    public Student() {
        UUID uuid = UUID.randomUUID();
        if(student_id == null){
            this.student_id = uuid;
        }
    }

    public UUID getStudent_id() {
        return student_id;
    }

    public void setStudent_id(UUID student_id) {
        this.student_id = student_id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public long getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(long mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getEnroll() {
        return enroll;
    }

    public void setEnroll(long enroll) {
        this.enroll = enroll;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "student_id=" + student_id +
                ", studentName='" + studentName + '\'' +
                ", mobileNumber=" + mobileNumber +
                ", email='" + email + '\'' +
                ", enroll=" + enroll +
                ", address=" + address +
                '}';
    }
}
