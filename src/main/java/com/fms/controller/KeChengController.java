package com.fms.controller;


import com.fms.mapper.CtypeMapper;
import com.fms.pojo.KeCheng;
import com.fms.service.KeChengService;
import com.fms.util.PageResult;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("kecheng")
public class KeChengController {
        @Autowired
        private KeChengService keChengService;


        //查询全部
        @GetMapping("/findAll")
        public PageResult<KeCheng> findAll(@RequestParam(defaultValue = "0") Integer page,
                                           @RequestParam(defaultValue = "0") Integer size){
        PageInfo<KeCheng> keChengs=keChengService.findAll(page,size);

        return new PageResult<KeCheng>(keChengs.getTotal(),keChengs.getList());
        }
        //用id查出对应的课程
        @GetMapping("/findById")
        public KeCheng findById(int id){
        return keChengService.findById(id);

        }
        //更新课程信息的方法,通过Vue异步请求可以拿到msg显示是否成功
        @PostMapping("update")
         public Map<String,Object> update(KeCheng keCheng){
            Map<String,Object> map=new HashMap<>();
            try {
                keChengService.update(keCheng);
                map.put("state",true);
                map.put("msg","更新成功!");
            }catch (Exception e){
                e.printStackTrace();
                map.put("state",false);
                map.put("msg",e.getMessage());
            }
            return map;
        }
        //根据id删除对应的课程
        @PostMapping("/delete")
        public Map<String,Object> delete(int i){
            Map<String,Object> map=new HashMap<>();
            try {
                keChengService.delete(i);
                map.put("state",true);
                map.put("msg","删除成功!");
            }catch (Exception e){
                e.printStackTrace();
                map.put("state",false);
                map.put("msg",e.getMessage());
            }
            return map;
        }
        //增加课程
        @PostMapping("/add")
        public Map<String,Object> add(KeCheng keCheng){
            Map<String,Object> map=new HashMap<>();
            try {
                keChengService.save(keCheng);
                map.put("state",true);
                map.put("msg","添加成功!");
            }catch (Exception e){
                e.printStackTrace();
                map.put("state",false);
                map.put("msg",e.getMessage());
            }
            return map;
        }



}
