package com.fms.mapper;

import com.fms.pojo.KeCheng;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface KeChengDao extends tk.mybatis.mapper.common.Mapper<KeCheng> {
    //查询所有课程的方法
    List<KeCheng> findAll();

    //根据id查询课程信息
    KeCheng findById(Integer id);

    //保存课程信息的方法
    void save(KeCheng keCheng);

    //根据id删除课程的方法
    void deleteByid(Integer id);

    //更新课程信息
    void update(KeCheng keCheng);

    /**
     * 根据学生id查询所有学员所报课程
     * @param studentid
     * @return
     */
    @Select("select * from tb_class where id in(select classid from tb_student_class where studentid = #{studentid})")
    List<KeCheng> queryByStudentId(Integer studentid);
}
