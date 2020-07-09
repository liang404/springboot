package com.fms.service.Impl;

import com.fms.mapper.CtypeMapper;
import com.fms.mapper.KeChengDao;
import com.fms.pojo.KeCheng;
import com.fms.service.KeChengService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class KeChengServiceImpl implements KeChengService {
    @Autowired
    private KeChengDao keChengDao;

    @Autowired
    private CtypeMapper ctypeMapper;
    @Override
    public PageInfo<KeCheng> findAll(Integer page, Integer size) {
        //开启分页查询，写在查询语句上方
        //只有紧跟在PageHelper.startPage方法后的第一个Mybatis的查询（Select）方法会被分页。
        PageHelper.startPage(page, size);
//        数据查询
        List<KeCheng> keChengs=keChengDao.findAll();

        PageInfo<KeCheng> pageInfo=new PageInfo<>(keChengs);

        return pageInfo;
    }

    @Override
    public KeCheng findById(Integer id) {
      return keChengDao.findById(id);
    }

    @Override
    public void save(KeCheng keCheng) {
        keChengDao.save(keCheng);
    }

    @Override
    public void delete(Integer id) {
        keChengDao.deleteByid(id);
    }

    @Override
    public void update(KeCheng keCheng) {
        keChengDao.update(keCheng);
    }

    /**
     * 根据学生id查询学员所报课程
     * @param studentid
     * @return
     */
    @Override
    public List<KeCheng> queryByStudentId(Integer studentid) {
        return this.keChengDao.queryByStudentId(studentid);
    }




}
