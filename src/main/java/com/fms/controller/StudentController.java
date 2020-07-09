package com.fms.controller;

import com.fms.bo.StudentBo;
import com.fms.pojo.Coach;
import com.fms.pojo.Student;
import com.fms.service.StudentService;
import com.fms.util.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

/**
 * @author liang
 * @create 2020/6/25 20:28
 */
@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;
    /**
     * 新增学生信息
     */
    @PostMapping("/add")
    public ResponseEntity<Void> addStudent(@RequestBody StudentBo studentBo){
        this.studentService.add(studentBo);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /**
     * 修改学生信息
     */
    @PostMapping("update")
    public ResponseEntity<Void> editStudent(@RequestBody Student student){
        this.studentService.edit(student);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /**
     *
     * @param key 按名称条件
     * @param rows 一页多少行
     * @param page 当前页
     * @return
     */
    @GetMapping("/queryAll")
    public ResponseEntity<PageResult<Student>> queryAllStudent(
            @RequestParam(value = "key",required = false) String key,
            @RequestParam(value = "rows",defaultValue = "5") Integer rows,
            @RequestParam(value = "page",defaultValue = "1") Integer page
    ){
        PageResult<Student> result = this.studentService.queryAllStudent(key,page,rows);
        System.out.println(result);
        if (CollectionUtils.isEmpty(result.getItems())){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result);
    }

    /**
     * 根据账号id完善学员信息
     *
     */
    @PostMapping("/updateStudentByAid")
    public ResponseEntity<Void> updateStudentByAid(@RequestBody Student student){
        this.studentService.updateStudentByAid(student);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }





}
