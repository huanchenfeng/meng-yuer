package com.ruoyi.project.system.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.hutool.http.HttpRequest;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ruoyi.project.system.domain.vo.DataAnalyVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.mapper.AccessoriesMapper;
import com.ruoyi.project.system.domain.Accessories;
import com.ruoyi.project.system.service.IAccessoriesService;

/**
 * 饰品信息Service业务层处理
 * 
 * @author cfs
 * @date 2024-09-06
 */
@Service
public class AccessoriesServiceImpl  extends ServiceImpl<AccessoriesMapper, Accessories> implements IAccessoriesService
{
    @Autowired
    private AccessoriesMapper accessoriesMapper;

    /**
     * 查询饰品信息
     * 
     * @param id 饰品信息主键
     * @return 饰品信息
     */
    @Override
    public Accessories selectAccessoriesById(Long id)
    {
        return accessoriesMapper.selectAccessoriesById(id);
    }

    /**
     * 查询饰品信息列表
     * 
     * @param accessories 饰品信息
     * @return 饰品信息
     */
    @Override
    public List<Accessories> selectAccessoriesList(Accessories accessories)
    {
        return accessoriesMapper.selectAccessoriesList(accessories);
    }

    /**
     * 新增饰品信息
     * 
     * @param accessories 饰品信息
     * @return 结果
     */
    @Override
    public int insertAccessories(Accessories accessories)
    {
        return accessoriesMapper.insertAccessories(accessories);
    }

    /**
     * 修改饰品信息
     * 
     * @param accessories 饰品信息
     * @return 结果
     */
    @Override
    public int updateAccessories(Accessories accessories)
    {
        return accessoriesMapper.updateAccessories(accessories);
    }

    /**
     * 批量删除饰品信息
     * 
     * @param ids 需要删除的饰品信息主键
     * @return 结果
     */
    @Override
    public int deleteAccessoriesByIds(Long[] ids)
    {
        return accessoriesMapper.deleteAccessoriesByIds(ids);
    }

    /**
     * 删除饰品信息信息
     * 
     * @param id 饰品信息主键
     * @return 结果
     */
    @Override
    public int deleteAccessoriesById(Long id)
    {
        return accessoriesMapper.deleteAccessoriesById(id);
    }

    @Override
    public  List<DataAnalyVo> dataAnalys(int type)
    {
        return accessoriesMapper.dataAnalys(type);
    }

    @Override
    public void updateAccessoriesData(int pageSum) {
        String url = "https://api.csqaq.com/api/v1/info/exchange_detail";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("res", 0);
        paramMap.put("platforms", "BUFF-YYYP");
        paramMap.put("sort_by", 1);
        paramMap.put("turnover", 0);
        paramMap.put("min_price", 0);
        paramMap.put("max_price", 200000);
        for (int i = 1; i <= pageSum; i++) {
            paramMap.put("page_index", i);
            String jsonMap = JSONUtil.toJsonStr(paramMap);
            String response = HttpRequest.post(url)
                    .header("Content-Type", "application/json")
                    .header("ApiToken", "VEZEW1I7T2R4O8J3R3N1O0H3")
                    .body(jsonMap)//表单内容
                    .timeout(20000)//超时，毫秒
                    .execute().body();
            ObjectMapper objectMapper = new ObjectMapper();
            // 获取 "data" 字段的数据并转换为 List<ItemInfo>
            try {
                List<Accessories> items = objectMapper.readValue(
                        objectMapper.readTree(response).get("data").toString(),
                        new TypeReference<List<Accessories>>() {
                        }
                );
                this.saveOrUpdateBatch(items);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e+"第"+i+"页出现的问题");
            }
        }

    }
}
