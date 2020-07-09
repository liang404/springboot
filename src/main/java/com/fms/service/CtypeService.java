package com.fms.service;

import com.fms.pojo.Ctype;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author liang
 * @create 2020/6/28 15:06
 */

public interface CtypeService {
    List<Ctype> queryCtypeByStudentid(Integer studentid);
}
