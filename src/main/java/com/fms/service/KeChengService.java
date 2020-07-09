package com.fms.service;


import com.fms.pojo.KeCheng;
import com.github.pagehelper.PageInfo;
import java.util.List;

public interface KeChengService {
    //查询所有的方法
    PageInfo<KeCheng> findAll(Integer page, Integer size);

    //根据id查询员工信息
    KeCheng findById(Integer id);

    //保存员工的方法
    void save(KeCheng keCheng);

    //删除员工的方法
    void delete(Integer id);

    //更新员工信息的方法
    void update(KeCheng keCheng);


    List<KeCheng> queryByStudentId(Integer id);
}
