package com.fms.controller;

import com.fms.service.CtypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

/**
 * @author liang
 * @create 2020/6/28 15:09
 */
@Controller
public class CtypeController {
    @Autowired
    private CtypeService ctypeService;


}
