package com.ruoyi.project.system.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.project.system.domain.vo.DataAnalyVo;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.project.system.domain.Accessories;
import com.ruoyi.project.system.service.IAccessoriesService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 饰品信息Controller
 * 
 * @author cfs
 * @date 2024-09-06
 */
@RestController
@RequestMapping("/system/accessories")
public class AccessoriesController extends BaseController
{
    @Autowired
    private IAccessoriesService accessoriesService;

    /**
     * 查询饰品信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:accessories:list')")
    @GetMapping("/list")
    public TableDataInfo list(Accessories accessories)
    {
        startPage();
        List<Accessories> list = accessoriesService.selectAccessoriesList(accessories);
        return getDataTable(list);
    }

    /**
     * 导出饰品信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:accessories:export')")
    @Log(title = "饰品信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Accessories accessories)
    {
        List<Accessories> list = accessoriesService.selectAccessoriesList(accessories);
        ExcelUtil<Accessories> util = new ExcelUtil<Accessories>(Accessories.class);
        util.exportExcel(response, list, "饰品信息数据");
    }

    /**
     * 获取饰品信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:accessories:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(accessoriesService.selectAccessoriesById(id));
    }

    /**
     * 新增饰品信息
     */
    @PreAuthorize("@ss.hasPermi('system:accessories:add')")
    @Log(title = "饰品信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Accessories accessories)
    {
        return toAjax(accessoriesService.insertAccessories(accessories));
    }

    /**
     * 修改饰品信息
     */
    @PreAuthorize("@ss.hasPermi('system:accessories:edit')")
    @Log(title = "饰品信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Accessories accessories)
    {
        return toAjax(accessoriesService.updateAccessories(accessories));
    }

    /**
     * 删除饰品信息
     */
    @PreAuthorize("@ss.hasPermi('system:accessories:remove')")
    @Log(title = "饰品信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(accessoriesService.deleteAccessoriesByIds(ids));
    }

    /**
     * 饰品数据分析
     */
    @PreAuthorize("@ss.hasPermi('system:accessories:query')")
    @GetMapping("/dataAnalys")
    public TableDataInfo remove(int type,int pageNum ,int pageSize)
    {
        startPage();
        List<DataAnalyVo> list =accessoriesService.dataAnalys(type);
        return getDataTable(list);
    }
}
