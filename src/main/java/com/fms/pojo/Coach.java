package com.fms.pojo;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * CREATE TABLE `fms`.`tb_coach` (
 *   `id` INT NOT NULL AUTO_INCREMENT,
 *   `name` VARCHAR(45) NULL,
 *   `sex` VARCHAR(45) NULL,
 *   `age` VARCHAR(45) NULL,
 *   `seniority` VARCHAR(200) NULL COMMENT '教练资历',
 *   `speciality` VARCHAR(200) NULL COMMENT '任课专长',
 *   `type` INT NULL COMMENT '教练类型：1为私人教练、0为普通教练',
 *   `online` INT(11) NULL COMMENT '是否在职,1在职，0离职'
 *   PRIMARY KEY (`id`));
 * @author liang
 * @create 2020/6/25 20:11
 */
@Table(name = "tb_coach")
public class Coach implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; //id
    private String name; //名称
    private String sex; //性别
    private String age; //年龄
    private String seniority; //教练资历
    private String speciality; //任课专长
    private Integer type; //教练类型：1为私人教练、0为普通教练'
    private Integer online; //是否在职,1在职，0离职
    private String image; //头像
    private Integer recommend;//推荐教练，1是，0否1

//    关联的账号id
    private Integer accountid; //


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

    public String getSeniority() {
        return seniority;
    }

    public void setSeniority(String seniority) {
        this.seniority = seniority;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getOnline() {
        return online;
    }

    public void setOnline(Integer online) {
        this.online = online;
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

    public Integer getRecommend() {
        return recommend;
    }

    public void setRecommend(Integer recommend) {
        this.recommend = recommend;
    }

    @Override
    public String toString() {
        return "Coach{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age='" + age + '\'' +
                ", seniority='" + seniority + '\'' +
                ", speciality='" + speciality + '\'' +
                ", online='" + online + '\'' +
                ", image='" + image + '\'' +
                ", accountid='" + accountid + '\'' +
                ", recommend='" + recommend + '\'' +
                ", type=" + type +
                '}';
    }
}
