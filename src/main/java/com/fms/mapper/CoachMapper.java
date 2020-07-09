package com.fms.mapper;

import com.fms.pojo.Coach;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author liang
 * @create 2020/6/25 20:21
 */
public interface CoachMapper extends Mapper<Coach> {

    @Select("select * from tb_coach where accountid = #{aid}")
    Coach queryByAid(Integer aid);

    @Select("select * from tb_coach where recommend = 1")
    List<Coach> queryCoachByRecommend();
}
