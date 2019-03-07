package cn.ideal.common.pojo;

import java.io.Serializable;

public class CommodityOrderItem implements Serializable {
    private String id;

    private Long itemId;

    private String orderId;

    private Integer number;

    private String title;

    private Integer price;

    private Integer totalFee;

    private String picPath;

    public CommodityOrderItem() {
    }

    public CommodityOrderItem(String id, Long itemId, String orderId, Integer number, String title, Integer price, Integer totalFee, String picPath) {
        this.id = id;
        this.itemId = itemId;
        this.orderId = orderId;
        this.number = number;
        this.title = title;
        this.price = price;
        this.totalFee = totalFee;
        this.picPath = picPath;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(Integer totalFee) {
        this.totalFee = totalFee;
    }

    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath == null ? null : picPath.trim();
    }
}