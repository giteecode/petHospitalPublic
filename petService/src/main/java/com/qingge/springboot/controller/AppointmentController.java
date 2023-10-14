package com.qingge.springboot.controller;


import cn.hutool.core.date.LocalDateTimeUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qingge.springboot.common.AppointmentStatus;
import com.qingge.springboot.common.RoleEnum;
import com.qingge.springboot.utils.TokenUtils;
import net.bytebuddy.implementation.bytecode.constant.DefaultValue;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qingge.springboot.common.Result;

import com.qingge.springboot.service.IAppointmentService;
import com.qingge.springboot.entity.Appointment;

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
@RequestMapping("/appointment")
public class AppointmentController {

    @Resource
    private IAppointmentService appointmentService;

    // 新增或者更新
    @PostMapping
    public Result save(@RequestBody Appointment appointment) {
        if(appointment.getPetId() == null){
            appointment.setUserId(TokenUtils.getCurrentUser().getId());
            appointment.setCreateTime(LocalDateTime.now());
            appointment.setPetId(appointment.getId());
            appointment.setStatus(AppointmentStatus.appointmentStart);
            appointment.setDoctorId(TokenUtils.getCurrentUser().getId().longValue());
        }
        appointmentService.saveOrUpdate(appointment);
        return Result.success();
    }

    // 就诊时修改预约信息中的状态，变为已完成
    @PostMapping("/update_status")
    public Result updateAppointmentStatus(@RequestBody Appointment appointment) {
        appointment.setStatus(AppointmentStatus.appointmentComplete);
        appointmentService.saveOrUpdate(appointment);
        return Result.success();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        appointmentService.removeById(id);
        return Result.success();
    }

    @PostMapping("/del/batch")
    public Result deleteBatch(@RequestBody List<Integer> ids) {
        appointmentService.removeByIds(ids);
        return Result.success();
    }

    @GetMapping
    public Result findAll() {
        return Result.success(appointmentService.list());
    }

    @GetMapping("/{id}")
    public Result findOne(@PathVariable Integer id) {
        return Result.success(appointmentService.getById(id));
    }

    @GetMapping("/page")
    public Result findPage(@RequestParam Integer pageNum,
                                @RequestParam Integer pageSize,
                           @RequestParam(defaultValue = "") String title) {
        QueryWrapper<Appointment> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("id");
        if(!"".equals(title)){
            //根据内容来查询预约列表
            String applInfo = title;
            queryWrapper.like("appl_info", applInfo);
        }
        return Result.success(appointmentService.page(new Page<>(pageNum, pageSize), queryWrapper));
    }

}

