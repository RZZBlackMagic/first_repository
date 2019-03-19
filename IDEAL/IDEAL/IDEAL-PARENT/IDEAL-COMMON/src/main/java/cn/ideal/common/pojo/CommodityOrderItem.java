package cn.ideal.common.pojo;

import java.io.Serializable;

public class CommodityOrderItem implements Serializable {
    private String id;

    private String itemId;

    private String orderId;

    private String number;

    private String title;

    private String price;

    private String totalFee;

    private String picPath;

    public CommodityOrderItem() {
    }

    public CommodityOrderItem(String id, String itemId, String orderId, String number, String title, String price, String totalFee, String picPath) {
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

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId == null ? null : itemId.trim();
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number == null ? null : number.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price == null ? null : price.trim();
    }

    public String getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(String totalFee) {
        this.totalFee = totalFee == null ? null : totalFee.trim();
    }

    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath == null ? null : picPath.trim();
    }
}