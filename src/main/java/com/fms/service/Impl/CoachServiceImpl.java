package com.fms.service.Impl;

import com.fms.bo.CoachBo;
import com.fms.mapper.CoachMapper;
import com.fms.pojo.Account;
import com.fms.pojo.Coach;
import com.fms.service.CoachService;
import com.fms.service.LoginService;
import com.fms.util.PageResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author liang
 * @create 2020/6/25 20:23
 */
@Service
@Transactional
public class CoachServiceImpl implements CoachService {

//   注入CoachMapper
    @Autowired
    private CoachMapper coachMapper;

    @Autowired
    private LoginService loginService;

    /**
     * 添加教练信息
     * @param coachBo
     */
    @Override
    public void addCoach(CoachBo coachBo) {
//        添加账号信息，
        this.loginService.addAccount(coachBo.getUsername(),coachBo.getPassword());
//        根据登录名查询账号信息
        Account account =this.loginService.queryAccountByUsername(coachBo.getUsername());
//        添加教练信息
        Coach coach = new Coach();
        coach.setName(coachBo.getName());
        coach.setAge(coachBo.getAge());
        coach.setSex(coachBo.getSex());
        coach.setSeniority(coachBo.getSeniority());
        coach.setSpeciality(coachBo.getSpeciality());
        coach.setOnline(coachBo.getOnline());
        coach.setType(coachBo.getType());
        coach.setRecommend(coachBo.getRecommend());
        coach.setAccountid(account.getId());
        this.coachMapper.insertSelective(coach);
    }

    /**
     * 修改教练信息
     * @param coach
     */
    @Override
    public void editCoach(Coach coach) {

        this.coachMapper.updateByPrimaryKeySelective(coach);
    }

    /**
     * 分页查询所有教练信息
     * @param key
     * @param rows
     * @param page
     * @param sortBy
     * @param desc
     * @return
     */
    @Override
    public PageResult<Coach> queryAllCoach(String key, Integer rows, Integer page, String sortBy, Boolean desc) {
        Example example = new Example(Coach.class);
        Example.Criteria criteria = example.createCriteria();
//       使用name模糊查询
        criteria.andLike("name","%"+key+"%");
//        升序，降序
//        example.setOrderByClause(sortBy+" "+(desc?"desc":"asc"));
        List<Coach> coaches = this.coachMapper.selectByExample(example);
//        分页
        PageHelper.startPage(page,rows);
        PageInfo<Coach> pageInfo = new PageInfo<>(coaches);
//        返回结果集
        return new PageResult<Coach>(pageInfo.getTotal(),pageInfo.getList());
    }

    /**
     * 根据id查询教练信息
     * @param sid
     * @return
     */
    @Override
    public Coach queryByCid(Integer sid) {
        return this.coachMapper.selectByPrimaryKey(sid);
    }

    /**
     * 根据账号id查询教练信息
     * @param aid
     * @return
     */
    @Override
    public Coach queryCoachByAid(Integer aid) {
        return this.coachMapper.queryByAid(aid);
    }

    /**
     * 根据账号id添加教练信息
     * @param coach
     */
    @Override
    public void updateCoachByAid(Coach coach) {
//        根据账号id查找教练信息
        Coach coach1 = this.coachMapper.queryByAid(coach.getAccountid());
        coach.setId(coach1.getId());
        BeanUtils.copyProperties(coach,coach1);
        this.coachMapper.updateByPrimaryKeySelective(coach1);
    }


    /**
     * 查询是否为推荐教练
     * @return
     */
    @Override
    public List<Coach> queryCoachByRecommend() {
        return this.coachMapper.queryCoachByRecommend();
    }


}
