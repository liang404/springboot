package com.fms;

import com.fms.bo.AccountBo;
import com.fms.pojo.Student;
import com.fms.service.CoachService;
import com.fms.service.LoginService;
import com.fms.service.StudentService;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author liang
 * @create 2020/6/26 22:00
 */
@SpringBootTest
public class Test {

    @Autowired
    private LoginService loginService;

    @Autowired
    private CoachService coachService;

    @Autowired
    private StudentService studentService;

    @org.junit.Test
    public void testStudent(){}

    @org.junit.Test
    public void testCoach(){}

    @org.junit.Test
    public void testlogin(){
//        this.studentService.queryAllStudent("",1,5,"",false);
    }




    @org.junit.Test
    public void test(){
        Student student = new Student();
        Student student1 =new Student();
        student.setName("asd");
        student1.setAccountid(1);
        student.setAccountid(student1.getAccountid());
        BeanUtils.copyProperties(student,student1);
        System.out.println(student);
        System.out.println(student1);

    }
}
