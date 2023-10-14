package com.qingge.springboot.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qingge.springboot.VO.PetDailyVO;
import com.qingge.springboot.entity.Diagnosis;
import com.qingge.springboot.utils.TokenUtils;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qingge.springboot.common.Result;

import com.qingge.springboot.service.IPetDailyService;
import com.qingge.springboot.entity.PetDaily;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 墨枫
 * @since 2022-03-03
 */
@RestController
@RequestMapping("/daily")
public class PetDailyController {

    @Resource
    private IPetDailyService petDailyService;

    // 新增或者更新
    @PostMapping
    public Result save(@RequestBody PetDaily petDaily) {

        petDailyService.saveOrUpdate(petDaily);
        return Result.success();
    }

    @PostMapping("/add")
    public Result add(@RequestBody PetDaily petDaily) {
        if(petDaily.getCreateTime() == null){
            petDaily.setCreateTime(LocalDateTime.now());
            petDaily.setUserId(TokenUtils.getCurrentUser().getId().longValue());
        }
        petDailyService.saveOrUpdate(petDaily);
        return Result.success();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        petDailyService.removeById(id);
        return Result.success();
    }

    @PostMapping("/del/batch")
    public Result deleteBatch(@RequestBody List<Integer> ids) {
        petDailyService.removeByIds(ids);
        return Result.success();
    }

    @GetMapping
    public Result findAll() {
        return Result.success(petDailyService.list());
    }

    @GetMapping("/{id}")
    public Result findOne(@PathVariable Integer id) {
        return Result.success(petDailyService.getById(id));
    }

    @GetMapping("/page")
    public Result findPage(@RequestParam Integer pageNum,
                                @RequestParam Integer pageSize,
                           @RequestParam String name) {
        Page<PetDaily> page = petDailyService.findPage(new Page<>(pageNum, pageSize), name);
        System.out.println(page);
        return Result.success(page);
    }




}

