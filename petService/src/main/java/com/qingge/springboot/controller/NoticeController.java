package com.qingge.springboot.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qingge.springboot.utils.TokenUtils;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qingge.springboot.common.Result;

import com.qingge.springboot.service.INoticeService;
import com.qingge.springboot.entity.Notice;

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
@RequestMapping("/notice")
public class NoticeController {

    @Resource
    private INoticeService noticeService;

    // 新增或者更新
    @PostMapping
    public Result save(@RequestBody Notice notice) {
        if(notice.getId() == null){
            notice.setCreateTime(LocalDateTime.now());
            notice.setViewCount(0);
            notice.setAuthor(TokenUtils.getCurrentUser().getNickname());
        }
        noticeService.saveOrUpdate(notice);
        return Result.success();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        noticeService.removeById(id);
        return Result.success();
    }

    @PostMapping("/del/batch")
    public Result deleteBatch(@RequestBody List<Integer> ids) {
        noticeService.removeByIds(ids);
        return Result.success();
    }

    @PostMapping("/addViewCount")
    public Result updateViewCount(@RequestBody Notice notice) {
        notice.setViewCount(notice.getViewCount()+1);
        noticeService.updateById(notice);
        return Result.success();
    }

    @GetMapping
    public Result findAll() {
        return Result.success(noticeService.list());
    }

    @GetMapping("/{id}")
    public Result findOne(@PathVariable Integer id) {
        return Result.success(noticeService.getById(id));
    }

    @GetMapping("/page")
    public Result findPage(@RequestParam Integer pageNum,
                                @RequestParam Integer pageSize,
                           @RequestParam(defaultValue = "") String title) {
        QueryWrapper<Notice> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("id");
        if(!"".equals(title)){
            queryWrapper.like("title", title);
        }
        return Result.success(noticeService.page(new Page<>(pageNum, pageSize), queryWrapper));
    }

}

