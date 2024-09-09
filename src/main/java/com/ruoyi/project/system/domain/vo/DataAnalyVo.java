package com.ruoyi.project.system.domain.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class DataAnalyVo {

    @ApiModelProperty(value = "饰品中文名称")
    private String name;
    //前面是平台后面是steam
    @ApiModelProperty(value = "比例(求购/在售)")
    private Double purchaseToSellRatio;
    @ApiModelProperty(value = "比例(求购/求购)")
    private Double purchaseToPurchaseRatio;
    @ApiModelProperty(value = "比例(在售/求购)")
    private Double sellToPurchaseRatio;

    @ApiModelProperty(value = "比例(在售/在售)")
    private Double sellToSellRatio;

    @ApiModelProperty(value = "Steam售价")
    private Double steamSellPrice;

    @ApiModelProperty(value = "BUFF售价")
    private Double buffSellPrice;

    @ApiModelProperty(value = "YYYP售价")
    private Double yyypSellPrice;

    @ApiModelProperty(value = "BUFF求购价")
    private Double buffBuyPrice;

    @ApiModelProperty(value = "YYYP求购价")
    private Double yyypBuyPrice;

    @ApiModelProperty(value = "Steam求购价")
    private Double steamBuyPrice;

    @ApiModelProperty(value = "BUFF链接")
    private String buffLink;

    @ApiModelProperty(value = "YYYP链接")
    private String yyypLink;

    @ApiModelProperty(value = "Steam链接")
    private String steamLink;

}
