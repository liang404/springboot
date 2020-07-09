package com.fms.service.Impl;

import com.fms.bo.StudentBo;
import com.fms.mapper.StudentMapper;
import com.fms.pojo.Account;
import com.fms.pojo.Ctype;
import com.fms.pojo.KeCheng;
import com.fms.pojo.Student;
import com.fms.service.CtypeService;
import com.fms.service.KeChengService;
import com.fms.service.LoginService;
import com.fms.service.StudentService;
import com.fms.util.PageResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.thymeleaf.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.StringUtil;

import java.util.List;
import java.util.UUID;

/**
 * @author liang
 * @create 2020/6/25 20:22
 */
@Service
@Transactional
public class StudentServiceImpl implements StudentService {

//    注入StudentMapper
    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private LoginService loginService;

    @Autowired
    private KeChengService keChengService;

    @Autowired
    private CtypeService ctypeService;

    /**
     * 新增学生信息
     * @param studentBo
     */
    @Override
    public void add(StudentBo studentBo) {

//

//        添加账号信息，
        this.loginService.addStudentByAccount(studentBo.getUsername(),studentBo.getPassword());
//        根据登录名查询账号信息
        Account account =this.loginService.queryAccountByUsername(studentBo.getUsername());
//        添加学员信息
        Student student = new Student();
        student.setName(studentBo.getName());
        student.setAge(studentBo.getAge());
        student.setSex(studentBo.getSex());
        student.setVip(student.getVip());
        student.setAccountid(account.getId());
        this.studentMapper.insertSelective(student);

        //        将学员意向插入数据表
        studentBo.getPurpose().forEach(ctype -> {
            this.studentMapper.insertStudentIdAndCtypeId(student.getId(),ctype.getId());
        });

    }

    /**
     * 修改学生信息
     * @param student
     */

    @Override
    public void edit(Student student) {

//       查询所有所报的课程
        List<KeCheng> keChengs = this.keChengService.queryByStudentId(student.getId());
        keChengs.forEach(keCheng -> {
            this.studentMapper.deleteStudentAndCtype(student.getId(),keCheng.getId());
        });

//        查询所有所选的意向



    }

    /**
     * 查询所有学生信息（所报课程，意向信息）
     * @return
     * @param key
     * @param page
     * @param rows

     */
    @Override
    public PageResult<Student> queryAllStudent(String key, Integer page, Integer rows) {
        Example example = new Example(Student.class);
        Example.Criteria criteria = example.createCriteria();
        //根据条件查询学生
//        根据姓名查询学生信息
        criteria.andLike("name","%"+key+"%");
//
        //查询所有学生信息
        List<Student> students = this.studentMapper.selectByExample(example);
        students.forEach(student -> {
            //根据学生id查询查询学生所报课程和意向
            student.setKeChengs(this.keChengService.queryByStudentId(student.getId()));
            student.setPurpose(this.ctypeService.queryCtypeByStudentid(student.getId()));
        });
//        分页
        PageHelper.startPage(page,rows);
//        打包成pageInfo
        PageInfo<Student> pageInfo = new PageInfo<>(students);

        //返回pageResult
        return new PageResult<Student>( pageInfo.getTotal(),pageInfo.getList());
    }

    /**
     * 根据id查询学生信息
     * @param sid
     * @return
     */
    @Override
    public Student queryBySid(Integer sid) {
        return this.studentMapper.selectByPrimaryKey(sid);
    }

    /**
     * 根据账号id查询学生信息
     * @param aid
     * @return
     */
    @Override
    public Student queryStudentByAid(Integer aid) {
        return this.studentMapper.queryStudentByAid(aid);
    }

    /**
     *
     * @param student
     */
    @Override
    public void updateStudentByAid(Student student) {
//        根据aid查询学员信息
        Student student1 = this.studentMapper.queryStudentByAid(student.getAccountid());
//        把学员di赋值get前台获取的student
        student.setAccountid(student1.getAccountid());
//        前台获取的的student数据复制给查询到的student1
        BeanUtils.copyProperties(student,student1);
//        更新学员数据
        this.studentMapper.updateByPrimaryKeySelective(student1);
    }


}
