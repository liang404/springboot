package com.fms.pojo;



import java.util.Date;

public class KeCheng {
    private Integer id;
    private String name;
    private Date start;
    private Date end;
    private String schooltime;
    private Integer classroomId;
    private double price;
    private Integer putaway;
    private Integer vip;
    private Integer coachId;
    private Integer star;            // 起始行
    private Integer rows;             // 所取行数
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public String getSchooltime() {
        return schooltime;
    }

    public void setSchooltime(String schooltime) {
        this.schooltime = schooltime;
    }

    public int getClassroomId() {
        return classroomId;
    }

    public void setClassroomId(int classroomId) {
        this.classroomId = classroomId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getPutaway() {
        return putaway;
    }

    public void setPutaway(int putaway) {
        this.putaway = putaway;
    }

    public int getVip() {
        return vip;
    }

    public void setVip(int vip) {
        this.vip = vip;
    }

    public int getCoachId() {
        return coachId;
    }

    public void setCoachId(int coachId) {
        this.coachId = coachId;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setClassroomId(Integer classroomId) {
        this.classroomId = classroomId;
    }

    public void setPutaway(Integer putaway) {
        this.putaway = putaway;
    }

    public void setVip(Integer vip) {
        this.vip = vip;
    }

    public void setCoachId(Integer coachId) {
        this.coachId = coachId;
    }

    public Integer getStar() {
        return star;
    }

    public void setStar(Integer star) {
        this.star = star;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "KeCheng{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", start=" + start +
                ", end=" + end +
                ", schooltime='" + schooltime + '\'' +
                ", classroomId=" + classroomId +
                ", price=" + price +
                ", putaway=" + putaway +
                ", vip=" + vip +
                ", coachId=" + coachId +
                ", star=" + star +
                ", rows=" + rows +
                '}';
    }
}
