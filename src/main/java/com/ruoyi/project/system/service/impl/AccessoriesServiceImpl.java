package com.ruoyi.project.system.service.impl;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ruoyi.project.system.domain.vo.DataAnalyVo;
import com.ruoyi.project.system.domain.vo.MyAccessorieVo;
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

    @Override
    public List<MyAccessorieVo> myAccessorieById(int id) {
        String url = "https://steamcommunity.com/inventory/76561199003162827/730/2?l=schinese&count=5000";
        // Make the request
        HttpRequest httpRequest = HttpRequest.get(url).timeout(30000);
        httpRequest.setProxy(new Proxy(Proxy.Type.HTTP, new InetSocketAddress("127.0.0.1", 7890)));
        String response = httpRequest.execute().body();

        // Parse JSON response
        JSONObject jsonResponse = JSONUtil.parseObj(response);
        JSONArray assets = jsonResponse.getJSONArray("assets");
        JSONArray descriptions = jsonResponse.getJSONArray("descriptions");

        // Map to store item count by classid
        Map<String, Integer> itemCount = new HashMap<>();
        Map<String, String> itemNameMap = new HashMap<>();

        // Process descriptions to map classid to names
        for (Object descObj : descriptions) {
            JSONObject description = (JSONObject) descObj;
            String classid = description.getStr("classid");
            String name = description.getStr("market_name");
            itemNameMap.put(classid, name);
        }

        // Count items by classid
        for (Object assetObj : assets) {
            JSONObject asset = (JSONObject) assetObj;
            String classid = asset.getStr("classid");

            itemCount.put(classid, itemCount.getOrDefault(classid, 0) + 1);
        }
        List<MyAccessorieVo> myAccessorieVoList=new ArrayList<>();
        // Output item counts with names
        itemCount.forEach((classid, count) -> {
            Accessories accessories=accessoriesMapper.selectOne(new QueryWrapper<Accessories>().eq("name",itemNameMap.get(classid)));
            MyAccessorieVo myAccessorieVo=new MyAccessorieVo();
            BeanUtil.copyProperties(accessories, myAccessorieVo);
            myAccessorieVo.setSum(count);
            myAccessorieVoList.add(myAccessorieVo);
        });
        return myAccessorieVoList;
    }
}
