package com.fms.mapper;

import com.fms.pojo.Student;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Value;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author liang
 * @create 2020/6/25 20:21
 */
public interface StudentMapper extends Mapper<Student> {
    @Select("select * from tb_student where accountid = #{aid}")
    Student queryStudentByAid(Integer aid);

    @Insert("insert into tb_student_ctype value (#{studentid},#{ctypeid})")
    void insertStudentIdAndCtypeId(@Param("studentid") Integer studentid, @Param("ctypeid") Integer ctypeid);

    @Delete("delete from tb_student_class where studentid=#{studentid} and classid=#{ctypeid}")
    void deleteStudentAndClass(@Param("studentid") Integer studentid, @Param("classid") Integer classid);

    @Delete("delete from tb_student_ctype where studentid=#{studentid} and ctypeid=#{ctypeid}")
    void deleteStudentAndCtype(@Param("studentid") Integer studentid, @Param("ctypeid") Integer ctypeid);
}
