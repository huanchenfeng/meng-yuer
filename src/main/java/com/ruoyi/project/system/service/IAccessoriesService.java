package com.ruoyi.project.system.service;

import java.util.List;
import com.ruoyi.project.system.domain.Accessories;
import com.ruoyi.project.system.domain.vo.DataAnalyVo;

/**
 * 饰品信息Service接口
 * 
 * @author cfs
 * @date 2024-09-06
 */
public interface IAccessoriesService 
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
     * 批量删除饰品信息
     * 
     * @param ids 需要删除的饰品信息主键集合
     * @return 结果
     */
    public int deleteAccessoriesByIds(Long[] ids);

    /**
     * 删除饰品信息信息
     * 
     * @param id 饰品信息主键
     * @return 结果
     */
    public int deleteAccessoriesById(Long id);

    public  List<DataAnalyVo> dataAnalys(int type);

    void updateAccessoriesData(int pageSum);


}
