package com.fms.service;

import com.fms.bo.AccountBo;
import com.fms.pojo.Account;
import org.springframework.stereotype.Service;

/**
 * @author liang
 * @create 2020/6/26 17:41
 */
@Service
public interface LoginService {


    AccountBo login(String username, String password);

    void addAccount(String username, String password);

    Boolean checkUsername(String username);

    Account queryAccountByUsername(String username);

    void addStudentByAccount(String username, String password);
}
