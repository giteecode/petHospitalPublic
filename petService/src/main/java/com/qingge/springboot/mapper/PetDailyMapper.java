package com.qingge.springboot.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qingge.springboot.VO.PetDailyVO;
import com.qingge.springboot.entity.PetDaily;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 墨枫
 * @since 2022-03-03
 */
public interface PetDailyMapper extends BaseMapper<PetDaily> {

    @Select("select p.id,p.name,d.id,d.height,d.weight,d.temperature,d.appetite,d.status,d.create_time from pet p,pet_daily d where p.id = d.pet_id")
    List<PetDailyVO> listPetAndDaily();

    Page<PetDaily> findPage(Page<PetDaily> page, @Param("name") String name);

}
