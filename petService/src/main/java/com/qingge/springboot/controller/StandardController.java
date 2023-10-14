package com.qingge.springboot.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qingge.springboot.common.Result;

import com.qingge.springboot.service.IStandardService;
import com.qingge.springboot.entity.Standard;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 墨枫
 * @since 2022-03-06
 */
@RestController
@RequestMapping("/standard")
public class StandardController {

    @Resource
    private IStandardService standardService;

    // 新增或者更新
    @PostMapping
    public Result save(@RequestBody Standard standard) {
        standardService.saveOrUpdate(standard);
        return Result.success();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        standardService.removeById(id);
        return Result.success();
    }

    @PostMapping("/del/batch")
    public Result deleteBatch(@RequestBody List<Integer> ids) {
        standardService.removeByIds(ids);
        return Result.success();
    }

    @GetMapping
    public Result findAll() {
        return Result.success(standardService.list());
    }

    @GetMapping("/{id}")
    public Result findOne(@PathVariable Integer id) {
        return Result.success(standardService.getById(id));
    }

    @GetMapping("/page")
    public Result findPage(@RequestParam Integer pageNum,
                                @RequestParam Integer pageSize,
                           @RequestParam(defaultValue = "") String type) {
        QueryWrapper<Standard> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("id");
        if(!"".equals(type)){
            queryWrapper.like("type", type);
        }
        return Result.success(standardService.page(new Page<>(pageNum, pageSize), queryWrapper));
    }

}

