package com.libraray.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.UUID;

@Document
public class LibraryHis {
    @Id
    private UUID id;
    private UUID studentId;
    private UUID bookId;
    private Date issueDt;
    private  Date returnDt;
    private Date submissionDt;
    private long fineAmount;

    public LibraryHis() {

        this.id = UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getStudentId() {
        return studentId;
    }

    public void setStudentId(UUID studentId) {
        this.studentId = studentId;
    }

    public UUID getBookId() {
        return bookId;
    }

    public void setBookId(UUID bookId) {
        this.bookId = bookId;
    }

    public Date getIssueDt() {
        return issueDt;
    }

    public void setIssueDt(Date issueDt) {
        this.issueDt = issueDt;
    }

    public  Date getReturnDt() {
        return returnDt;
    }

    public  void setReturnDt(Date returnDt) {
        this.returnDt = returnDt;
    }

    public Date getSubmissionDt() {
        return submissionDt;
    }

    public void setSubmissionDt(Date submissionDt) {
        this.submissionDt = submissionDt;
    }

    public long getFineAmount() {
        return fineAmount;
    }

    public void setFineAmount(long fineAmount) {
        this.fineAmount = fineAmount;
    }

    @Override
    public String toString() {
        return "LibraryHis{" +
                "id=" + id +
                ", studentId=" + studentId +
                ", bookId=" + bookId +
                ", issueDt=" + issueDt +
                ", submissionDt=" + submissionDt +
                ", fineAmount=" + fineAmount +
                '}';
    }
}
