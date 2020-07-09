package com.fms.bo;

import com.fms.pojo.Account;
import com.fms.pojo.Coach;
import com.fms.pojo.Student;

/**
 * @author liang
 * @create 2020/6/26 18:00
 */
public class AccountBo extends Account {

    private Coach coach;
    private Student student;

    public Coach getCoach() {
        return coach;
    }

    public void setCoach(Coach coach) {
        this.coach = coach;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }


    @Override
    public String toString() {
        return "AccountBo{" +
                "coach=" + coach +
                ", student=" + student +
                ", username=" + this.getUsername() +
                ", password=" + this.getPassword() +
                '}';
    }
}
