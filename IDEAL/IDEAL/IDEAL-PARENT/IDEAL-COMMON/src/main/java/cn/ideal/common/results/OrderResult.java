package cn.ideal.common.results;


import java.util.Date;

public class OrderResult {
    private String userId;
    private String orderId;
    private String title;
    private String price;
    private String number;
    private String picPath;
    private String receiverName;
    private Date created;

    public OrderResult() {
    }

    public OrderResult(String userId, String orderId, String title, String price, String number, String picPath, String receiverName, Date created) {
        this.userId = userId;
        this.orderId = orderId;
        this.title = title;
        this.price = price;
        this.number = number;
        this.picPath = picPath;
        this.receiverName = receiverName;
        this.created = created;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    @Override
    public String toString() {
        return "OrderResult{" +
                "userId='" + userId + '\'' +
                ", orderId='" + orderId + '\'' +
                ", title='" + title + '\'' +
                ", price='" + price + '\'' +
                ", number='" + number + '\'' +
                ", picPath='" + picPath + '\'' +
                ", receiverName='" + receiverName + '\'' +
                ", created=" + created +
                '}';
    }
}

