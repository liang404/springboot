package com.fms.service.Impl;

import com.fms.bo.AccountBo;
import com.fms.mapper.AccountMapper;
import com.fms.mapper.CoachMapper;
import com.fms.mapper.StudentMapper;
import com.fms.pojo.Account;
import com.fms.pojo.Student;
import com.fms.service.LoginService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author liang
 * @create 2020/6/26 17:42
 */
@Service
@Transactional
public class LoginServiceImpl implements LoginService {

    @Autowired
    private AccountMapper accountMapper;

    @Autowired
    private CoachMapper coachMapper;

    @Autowired
    private StudentMapper studentMapper;


    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    @Override
    public AccountBo login(String username, String password) {
        //检查用户名密码是否存在
        Example example = new Example(Account.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("username",username);
        criteria.andEqualTo("password",password);
        List<Account> accounts = this.accountMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(accounts)){
            return null;
        }
        Account account = accounts.get(0);
        AccountBo accountBo = new AccountBo();
        BeanUtils.copyProperties(account,accountBo);
        System.out.println(account.getType());
        if (account.getType()==0){
//            获取学生信息
            Student student = this.studentMapper.queryStudentByAid(account.getId());
            System.out.println(student);
            accountBo.setStudent(student);
        }else {
//          获取教练信息
            accountBo.setCoach(this.coachMapper.queryByAid(account.getId()));
        }
        return accountBo;
    }

    /**
     * 注册学员添加账号信息
     * @param username
     * @param password
     */
    @Override
    public void addAccount(String username, String password) {
        Account account = new Account();
        account.setType(0);
        account.setUsername(username);
        account.setPassword(password);
//        将注册信息插入账号表
        this.accountMapper.insert(account);
//         将账号id插入学员表
        Student student = new Student();
        student.setAccountid(account.getId());
        this.studentMapper.insert(student);
    }

    /**
     * 校验用户名是否合法
     * @param username
     */
    @Override
    public Boolean checkUsername(String username) {
        Account account = this.accountMapper.queryAccountByUsername(username);
        if (account==null){
            return true;
        }else {
            return false;
        }
    }
    /**
     * 添加学员插入账号
     */
    public void addStudentByAccount(String username, String password){
        Account account = new Account();
        account.setType(0);
        account.setUsername(username);
        account.setPassword(password);
//        将注册信息插入账号表
        this.accountMapper.insert(account);
    }




    /**
     * 根据登录名查询账号信息
     * @param username
     * @return
     */
    @Override
    public Account queryAccountByUsername(String username) {

        return this.accountMapper.queryAccountByUsername(username);
    }

}
