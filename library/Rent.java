package JP2.library;

import java.util.Date;

public class Rent {
    public Integer studentid;
    public Integer bookid;
    public Integer qty;
    public Date startDate;
    public Date endDate;
    public Date updateDate;
    public Integer status;
    public String note;

    public Rent(Integer studentid, Integer bookid, Integer qty, Date startDate, Date endDate, Date updateDate, Integer status, String note){
        this.studentid = studentid;
        this.bookid = bookid;
        this.qty = qty;
        this.startDate = startDate;
        this.endDate = endDate;
        this.updateDate = updateDate;
        this.status = status;
        this.note = note;
    }

    public Integer getStudentid() {
        return studentid;
    }

    public void setStudentid(Integer studentid) {
        this.studentid = studentid;
    }

    public Integer getBookid() {
        return bookid;
    }

    public void setBookid(Integer bookid) {
        this.bookid = bookid;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
