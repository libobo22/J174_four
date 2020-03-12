package com.project0310.bean;

public class RepertoryBean {
    private Integer goodsId;
    private String goodsName;
    private Integer num;

    public RepertoryBean() {
    }

    public RepertoryBean(Integer goodsId, String goodsName, Integer num) {
        this.goodsId = goodsId;
        this.goodsName = goodsName;
        this.num = num;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
