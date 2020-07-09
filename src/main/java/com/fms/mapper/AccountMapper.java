package com.fms.mapper;

import com.fms.pojo.Account;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author liang
 * @create 2020/6/26 17:39
 */
public interface AccountMapper extends Mapper<Account>{

    @Select("select * from tb_account where username=#{username}")
    Account queryAccountByUsername(String username);
}