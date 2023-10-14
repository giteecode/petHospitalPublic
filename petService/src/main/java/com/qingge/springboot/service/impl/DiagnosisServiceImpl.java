package com.qingge.springboot.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qingge.springboot.entity.Diagnosis;
import com.qingge.springboot.mapper.DiagnosisMapper;
import com.qingge.springboot.service.IDiagnosisService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 墨枫
 * @since 2022-03-06
 */
@Service
public class DiagnosisServiceImpl extends ServiceImpl<DiagnosisMapper, Diagnosis> implements IDiagnosisService {

    @Resource
    private DiagnosisMapper diagnosisMapper;
    @Override
    public Page<Diagnosis> findPage(Page<Diagnosis> page, String diagnosisAdvice) {
        return diagnosisMapper.findPage(page, diagnosisAdvice);
    }
}
