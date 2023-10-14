package com.qingge.springboot.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qingge.springboot.VO.PetDailyVO;
import com.qingge.springboot.entity.PetDaily;
import com.qingge.springboot.mapper.PetDailyMapper;
import com.qingge.springboot.service.IPetDailyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 墨枫
 * @since 2022-03-03
 */
@Service
public class PetDailyServiceImpl extends ServiceImpl<PetDailyMapper, PetDaily> implements IPetDailyService {
    @Resource
    PetDailyMapper petDailyMapper;
    @Override
    public List<PetDailyVO> listPetAndDaily() {
        return petDailyMapper.listPetAndDaily();
    }

    @Override
    public Page<PetDaily> findPage(Page<PetDaily> page, String name) {
        return  petDailyMapper.findPage(page, name);
    }
}
