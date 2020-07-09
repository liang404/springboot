package com.fms.controller;

import com.fms.bo.AccountBo;
import com.fms.bo.CoachBo;
import com.fms.pojo.Coach;
import com.fms.service.CoachService;
import com.fms.util.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author liang
 * @create 2020/6/25 20:28
 */
@Controller
@RequestMapping("coach")
public class CoachController {

//    注入service
    @Autowired
    private CoachService coachService;

    /**
     * 新增教练信息
     */
    @PostMapping("/add")
    public ResponseEntity<Void> addCoach(@RequestBody CoachBo coachBo){
        this.coachService.addCoach(coachBo);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /**
     * 修改教练信息
     */
    @PostMapping("/update")
    public ResponseEntity<Coach> editCoach(@RequestBody Coach coach){
         this.coachService.editCoach(coach);
        return ResponseEntity.noContent().build();
    }

    /**
     * 分页查询所有教练信息
     */
    @GetMapping("all")
    public ResponseEntity<PageResult<Coach>> queryAllCoach(
            @RequestParam(value = "key",required = false) String key,
            @RequestParam(value = "rows",defaultValue = "5") Integer rows,
            @RequestParam(value = "page",defaultValue = "1") Integer page,
            @RequestParam(value = "sortBy",required = false) String sortBy,
            @RequestParam(value = "desc",required = false) Boolean desc
    ){
        PageResult<Coach> result =this.coachService.queryAllCoach(key,rows,page,sortBy,desc);
        if (CollectionUtils.isEmpty(result.getItems())){

//            return ResponseEntity.ok().build();
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result);
    }

    /**
     * 根据账号id完善信息
     * @param coach
     * @return
     */
    @PostMapping("/updateCoachByAid")
    public ResponseEntity<Coach> updateCoachByAid(@RequestBody Coach coach){
        this.coachService.updateCoachByAid(coach);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /**
     * 测试接口
     * @param id
     * @return
     */
    @GetMapping("/query/{id}")
    public  @ResponseBody Coach queryById(@PathVariable("id")Integer id){
        Coach coach = this.coachService.queryByCid(id);
        return coach;
    }
    /**
     * 查询推荐教练信息
     */
    @GetMapping("queryCoachByRecommend")
    public ResponseEntity<List<Coach>> queryCoachByRecommend(){
        List<Coach> list =this.coachService.queryCoachByRecommend();
        if (CollectionUtils.isEmpty(list)){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(list);
    }

}
