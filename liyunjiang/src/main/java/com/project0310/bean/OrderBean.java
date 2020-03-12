package com.project0310.bean;

public class OrderBean {
    private Integer orderId;
    private RepertoryBean repertory;
    private Integer price;

    public OrderBean() {
    }

    public OrderBean(Integer orderId, RepertoryBean repertory, Integer price) {
        this.orderId = orderId;
        this.repertory = repertory;
        this.price = price;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public RepertoryBean getRepertory() {
        return repertory;
    }

    public void setRepertory(RepertoryBean repertory) {
        this.repertory = repertory;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
