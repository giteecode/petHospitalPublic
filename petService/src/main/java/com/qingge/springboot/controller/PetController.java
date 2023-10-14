package com.qingge.springboot.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qingge.springboot.utils.TokenUtils;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qingge.springboot.common.Result;

import com.qingge.springboot.service.IPetService;
import com.qingge.springboot.entity.Pet;

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
@RequestMapping("/pet")
public class PetController {

    @Resource
    private IPetService petService;

    // 新增或者更新
    @PostMapping
    public Result save(@RequestBody Pet pet) {
        if(pet.getUserId() == null){
            pet.setUserId(TokenUtils.getCurrentUser().getId());
            pet.setCreateTime(LocalDateTime.now());
        }
        petService.saveOrUpdate(pet);
        return Result.success();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        petService.removeById(id);
        return Result.success();
    }

    @PostMapping("/del/batch")
    public Result deleteBatch(@RequestBody List<Integer> ids) {
        petService.removeByIds(ids);
        return Result.success();
    }

    @GetMapping
    public Result findAll() {
        return Result.success(petService.list());
    }

    @GetMapping("/{id}")
    public Result findOne(@PathVariable Integer id) {
        return Result.success(petService.getById(id));
    }

    @GetMapping("/page")
    public Result findPage(@RequestParam Integer pageNum,
                                @RequestParam Integer pageSize,
                           @RequestParam(defaultValue = "") String username) {
        QueryWrapper<Pet> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("id");
        if (!"".equals(username)) {
            queryWrapper.like("name", username);
        }
        return Result.success(petService.page(new Page<>(pageNum, pageSize), queryWrapper));
    }

}

