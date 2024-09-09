package com.ruoyi.project.system.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 饰品信息对象 accessories
 * 
 * @author cfs
 * @date 2024-09-06
 */
public class Accessories extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 饰品ID */
    private Long id;

    /** BUFF平台饰品ID */
    @Excel(name = "BUFF平台饰品ID")
    private Long buffId;

    /** BUFF在售价 */
    @Excel(name = "BUFF在售价")
    private BigDecimal buffSellPrice;

    /** BUFF在售数量 */
    @Excel(name = "BUFF在售数量")
    private Long buffSellNum;

    /** BUFF求购价 */
    @Excel(name = "BUFF求购价")
    private BigDecimal buffBuyPrice;

    /** BUFF求购数量 */
    @Excel(name = "BUFF求购数量")
    private Long buffBuyNum;

    /** Steam在售价 */
    @Excel(name = "Steam在售价")
    private BigDecimal steamSellPrice;

    /** Steam在售数量 */
    @Excel(name = "Steam在售数量")
    private Long steamSellNum;

    /** Steam求购价 */
    @Excel(name = "Steam求购价")
    private BigDecimal steamBuyPrice;

    /** Steam求购数量 */
    @Excel(name = "Steam求购数量")
    private Long steamBuyNum;

    /** Steam市场名称 */
    @Excel(name = "Steam市场名称")
    private String marketHashName;

    /** 饰品中文名称 */
    @Excel(name = "饰品中文名称")
    private String name;

    /** 饰品图片 */
    @Excel(name = "饰品图片")
    private String img;

    /** YYYP平台饰品ID */
    @Excel(name = "YYYP平台饰品ID")
    private Long yyypId;

    /** YYYP在售价 */
    @Excel(name = "YYYP在售价")
    private BigDecimal yyypSellPrice;

    /** YYYP在售数量 */
    @Excel(name = "YYYP在售数量")
    private Long yyypSellNum;

    /** YYYP求购价 */
    @Excel(name = "YYYP求购价")
    private BigDecimal yyypBuyPrice;

    /** YYYP求购数量 */
    @Excel(name = "YYYP求购数量")
    private Long yyypBuyNum;

    /** 平台价格最大值 */
    @Excel(name = "平台价格最大值")
    private BigDecimal maxPrice;

    /** Steam当日成交量 */
    @Excel(name = "Steam当日成交量")
    private BigDecimal turnoverNumber;

    /** Steam平台ID */
    @Excel(name = "Steam平台ID")
    private Long steamId;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setBuffId(Long buffId) 
    {
        this.buffId = buffId;
    }

    public Long getBuffId() 
    {
        return buffId;
    }
    public void setBuffSellPrice(BigDecimal buffSellPrice) 
    {
        this.buffSellPrice = buffSellPrice;
    }

    public BigDecimal getBuffSellPrice() 
    {
        return buffSellPrice;
    }
    public void setBuffSellNum(Long buffSellNum) 
    {
        this.buffSellNum = buffSellNum;
    }

    public Long getBuffSellNum() 
    {
        return buffSellNum;
    }
    public void setBuffBuyPrice(BigDecimal buffBuyPrice) 
    {
        this.buffBuyPrice = buffBuyPrice;
    }

    public BigDecimal getBuffBuyPrice() 
    {
        return buffBuyPrice;
    }
    public void setBuffBuyNum(Long buffBuyNum) 
    {
        this.buffBuyNum = buffBuyNum;
    }

    public Long getBuffBuyNum() 
    {
        return buffBuyNum;
    }
    public void setSteamSellPrice(BigDecimal steamSellPrice) 
    {
        this.steamSellPrice = steamSellPrice;
    }

    public BigDecimal getSteamSellPrice() 
    {
        return steamSellPrice;
    }
    public void setSteamSellNum(Long steamSellNum) 
    {
        this.steamSellNum = steamSellNum;
    }

    public Long getSteamSellNum() 
    {
        return steamSellNum;
    }
    public void setSteamBuyPrice(BigDecimal steamBuyPrice) 
    {
        this.steamBuyPrice = steamBuyPrice;
    }

    public BigDecimal getSteamBuyPrice() 
    {
        return steamBuyPrice;
    }
    public void setSteamBuyNum(Long steamBuyNum) 
    {
        this.steamBuyNum = steamBuyNum;
    }

    public Long getSteamBuyNum() 
    {
        return steamBuyNum;
    }
    public void setMarketHashName(String marketHashName) 
    {
        this.marketHashName = marketHashName;
    }

    public String getMarketHashName() 
    {
        return marketHashName;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setImg(String img) 
    {
        this.img = img;
    }

    public String getImg() 
    {
        return img;
    }
    public void setYyypId(Long yyypId) 
    {
        this.yyypId = yyypId;
    }

    public Long getYyypId() 
    {
        return yyypId;
    }
    public void setYyypSellPrice(BigDecimal yyypSellPrice) 
    {
        this.yyypSellPrice = yyypSellPrice;
    }

    public BigDecimal getYyypSellPrice() 
    {
        return yyypSellPrice;
    }
    public void setYyypSellNum(Long yyypSellNum) 
    {
        this.yyypSellNum = yyypSellNum;
    }

    public Long getYyypSellNum() 
    {
        return yyypSellNum;
    }
    public void setYyypBuyPrice(BigDecimal yyypBuyPrice) 
    {
        this.yyypBuyPrice = yyypBuyPrice;
    }

    public BigDecimal getYyypBuyPrice() 
    {
        return yyypBuyPrice;
    }
    public void setYyypBuyNum(Long yyypBuyNum) 
    {
        this.yyypBuyNum = yyypBuyNum;
    }

    public Long getYyypBuyNum() 
    {
        return yyypBuyNum;
    }
    public void setMaxPrice(BigDecimal maxPrice) 
    {
        this.maxPrice = maxPrice;
    }

    public BigDecimal getMaxPrice() 
    {
        return maxPrice;
    }
    public void setTurnoverNumber(BigDecimal turnoverNumber) 
    {
        this.turnoverNumber = turnoverNumber;
    }

    public BigDecimal getTurnoverNumber() 
    {
        return turnoverNumber;
    }
    public void setSteamId(Long steamId) 
    {
        this.steamId = steamId;
    }

    public Long getSteamId() 
    {
        return steamId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("buffId", getBuffId())
            .append("buffSellPrice", getBuffSellPrice())
            .append("buffSellNum", getBuffSellNum())
            .append("buffBuyPrice", getBuffBuyPrice())
            .append("buffBuyNum", getBuffBuyNum())
            .append("steamSellPrice", getSteamSellPrice())
            .append("steamSellNum", getSteamSellNum())
            .append("steamBuyPrice", getSteamBuyPrice())
            .append("steamBuyNum", getSteamBuyNum())
            .append("marketHashName", getMarketHashName())
            .append("name", getName())
            .append("img", getImg())
            .append("yyypId", getYyypId())
            .append("yyypSellPrice", getYyypSellPrice())
            .append("yyypSellNum", getYyypSellNum())
            .append("yyypBuyPrice", getYyypBuyPrice())
            .append("yyypBuyNum", getYyypBuyNum())
            .append("maxPrice", getMaxPrice())
            .append("turnoverNumber", getTurnoverNumber())
            .append("steamId", getSteamId())
            .toString();
    }
}
