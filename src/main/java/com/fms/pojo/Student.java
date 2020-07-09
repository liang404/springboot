package com.fms.pojo;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

/**
 * CREATE TABLE `fms`.`tb_student` (
 *   `id` INT NOT NULL AUTO_INCREMENT,
 *   `name` VARCHAR(45) NULL COMMENT '姓名',
 *   `sex` VARCHAR(45) NULL COMMENT '性别',
 *   `age` VARCHAR(45) NULL COMMENT '年龄',
 *   `course` VARCHAR(100) NULL COMMENT '所报课程',
 *   `purpose` VARCHAR(100) NULL COMMENT '意向',
 *   `vip` INT NULL COMMENT '是否为vip：1是，0否',
 *   所报课程
 *   意向
 *   PRIMARY KEY (`id`));
 * @author liang
 * @create 2020/6/25 20:13
 */
@Table(name = "tb_student")
public class Student implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; //id
    private String name; //姓名
    private String sex; //性别
    private String age; //年龄
    private Integer vip; //是否vip，1是，0否
    private String image; //头像

//    关联账号表
    private Integer accountid;

    //所报课程
    private List<KeCheng> keChengs;

//    课程类型表
    private List<Ctype> purpose;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Integer getVip() {
        return vip;
    }

    public void setVip(Integer vip) {
        this.vip = vip;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getAccountid() {
        return accountid;
    }

    public void setAccountid(Integer accountid) {
        this.accountid = accountid;
    }

    public List<KeCheng> getKeChengs() {
        return keChengs;
    }

    public void setKeChengs(List<KeCheng> keChengs) {
        this.keChengs = keChengs;
    }

    public List<Ctype> getPurpose() {
        return purpose;
    }

    public void setPurpose(List<Ctype> purpose) {
        this.purpose = purpose;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age='" + age + '\'' +
                ", vip=" + vip +
                ", image='" + image + '\'' +
                ", accountid=" + accountid +
                '}';
    }
}
