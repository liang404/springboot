package com.fms.mapper;

import com.fms.pojo.Ctype;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author liang
 * @create 2020/6/28 15:03
 */
public interface CtypeMapper extends Mapper<Ctype> {
    @Select("select * from tb_ctype where id in(select ctypeid from tb_student_ctype where studentid = #{studentid})")
    List<Ctype> queryCtypeByStudentid(Integer studentid);
}
