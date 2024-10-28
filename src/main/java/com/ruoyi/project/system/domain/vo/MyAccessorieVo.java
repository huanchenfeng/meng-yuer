package com.ruoyi.project.system.domain.vo;

import com.ruoyi.project.system.domain.Accessories;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class MyAccessorieVo extends Accessories {
    @ApiModelProperty("数量")
    private Integer sum;



}
