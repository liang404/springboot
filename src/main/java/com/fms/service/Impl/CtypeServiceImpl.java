package com.fms.service.Impl;

import com.fms.mapper.CtypeMapper;
import com.fms.pojo.Ctype;
import com.fms.service.CtypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author liang
 * @create 2020/6/28 15:07
 */
@Service
@Transactional
public class CtypeServiceImpl implements CtypeService {

    @Autowired
    private CtypeMapper ctypeMapper;

    /**
     * 根据学生id查询学员所选意向（课程类型）
     */
    public List<Ctype> queryCtypeByStudentid(Integer studentid){
        return this.ctypeMapper.queryCtypeByStudentid(studentid);
    }


}
