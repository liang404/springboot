package com.fms.controller;

import com.fms.bo.AccountBo;
import com.fms.pojo.Account;
import com.fms.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author liang
 * @create 2020/6/26 16:56
 */
@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;
    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    @PostMapping("/login")
  public ResponseEntity<AccountBo> login(
          @RequestParam(value = "username",required = true) String username,
          @RequestParam(value = "password",required = true) String password
        /* @PathVariable("username") String username,
         @PathVariable("password") String password*/
  ){
      AccountBo accountBo = this.loginService.login(username, password);
//      把信息注入session
        System.out.println(accountBo);

      return ResponseEntity.ok(accountBo);
  }

    /**
     * 注册登录名校验
     */
    @GetMapping("/register/check")
    public ResponseEntity<Boolean> checkUsername(@RequestParam("username")String username){
        Boolean aBoolean = this.loginService.checkUsername(username);
        return ResponseEntity.status(HttpStatus.CREATED).body(aBoolean);
    }

    /**
     * 注册
     */
    @PostMapping("/register")
    public ResponseEntity<Void> register(
            @RequestParam(value = "username",required = true) String username,
            @RequestParam(value = "password",required = true) String password
    ){
        this.loginService.addAccount(username,password);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
