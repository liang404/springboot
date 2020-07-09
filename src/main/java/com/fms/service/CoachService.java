package com.fms.service;

import com.fms.bo.CoachBo;
import com.fms.pojo.Coach;
import com.fms.util.PageResult;

import java.util.List;

/**
 * @author liang
 * @create 2020/6/25 20:23
 */
public interface CoachService {

    void addCoach(CoachBo accountBo);

    void editCoach(Coach coach);

    PageResult<Coach> queryAllCoach(String key, Integer rows, Integer page, String sortBy, Boolean desc);

    Coach queryByCid(Integer sid);

    Coach queryCoachByAid(Integer aid);

    void updateCoachByAid(Coach coach);

    List<Coach> queryCoachByRecommend();
}
