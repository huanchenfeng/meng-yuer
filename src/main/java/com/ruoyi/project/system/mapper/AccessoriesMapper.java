package com.ruoyi.project.system.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruoyi.project.system.domain.Accessories;
import com.ruoyi.project.system.domain.vo.DataAnalyVo;

/**
 * 饰品信息Mapper接口
 * 
 * @author cfs
 * @date 2024-09-06
 */
public interface AccessoriesMapper extends BaseMapper<Accessories>
{
    /**
     * 查询饰品信息
     * 
     * @param id 饰品信息主键
     * @return 饰品信息
     */
    public Accessories selectAccessoriesById(Long id);

    /**
     * 查询饰品信息列表
     * 
     * @param accessories 饰品信息
     * @return 饰品信息集合
     */
    public List<Accessories> selectAccessoriesList(Accessories accessories);

    /**
     * 新增饰品信息
     * 
     * @param accessories 饰品信息
     * @return 结果
     */
    public int insertAccessories(Accessories accessories);

    /**
     * 修改饰品信息
     * 
     * @param accessories 饰品信息
     * @return 结果
     */
    public int updateAccessories(Accessories accessories);

    /**
     * 删除饰品信息
     * 
     * @param id 饰品信息主键
     * @return 结果
     */
    public int deleteAccessoriesById(Long id);

    /**
     * 批量删除饰品信息
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAccessoriesByIds(Long[] ids);

    List<DataAnalyVo> dataAnalys(int type);
}
