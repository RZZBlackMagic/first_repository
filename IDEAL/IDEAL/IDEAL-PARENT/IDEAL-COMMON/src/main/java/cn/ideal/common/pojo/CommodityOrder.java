package cn.ideal.common.pojo;

import java.io.Serializable;
import java.util.Date;

public class CommodityOrder implements Serializable {
    private String id;

    private String payment;

    private Integer paymentType;

    private String postFee;

    private Byte status;

    private Date paymentTime;

    private Date closeTime;

    private Date endTime;

    private Date consignTime;

    private String shippingName;

    private String shippingCode;

    private Long userId;

    private String buyerMessage;

    private String buyerNick;

    private Byte buyerRate;

    private Date created;

    private Date updated;

    public CommodityOrder() {
    }

    public CommodityOrder(String id, String payment, Integer paymentType, String postFee, Byte status, Date paymentTime, Date closeTime, Date endTime, Date consignTime, String shippingName, String shippingCode, Long userId, String buyerMessage, String buyerNick, Byte buyerRate, Date created, Date updated) {
        this.id = id;
        this.payment = payment;
        this.paymentType = paymentType;
        this.postFee = postFee;
        this.status = status;
        this.paymentTime = paymentTime;
        this.closeTime = closeTime;
        this.endTime = endTime;
        this.consignTime = consignTime;
        this.shippingName = shippingName;
        this.shippingCode = shippingCode;
        this.userId = userId;
        this.buyerMessage = buyerMessage;
        this.buyerNick = buyerNick;
        this.buyerRate = buyerRate;
        this.created = created;
        this.updated = updated;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment == null ? null : payment.trim();
    }

    public Integer getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(Integer paymentType) {
        this.paymentType = paymentType;
    }

    public String getPostFee() {
        return postFee;
    }

    public void setPostFee(String postFee) {
        this.postFee = postFee == null ? null : postFee.trim();
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Date getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(Date paymentTime) {
        this.paymentTime = paymentTime;
    }

    public Date getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(Date closeTime) {
        this.closeTime = closeTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getConsignTime() {
        return consignTime;
    }

    public void setConsignTime(Date consignTime) {
        this.consignTime = consignTime;
    }

    public String getShippingName() {
        return shippingName;
    }

    public void setShippingName(String shippingName) {
        this.shippingName = shippingName == null ? null : shippingName.trim();
    }

    public String getShippingCode() {
        return shippingCode;
    }

    public void setShippingCode(String shippingCode) {
        this.shippingCode = shippingCode == null ? null : shippingCode.trim();
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getBuyerMessage() {
        return buyerMessage;
    }

    public void setBuyerMessage(String buyerMessage) {
        this.buyerMessage = buyerMessage == null ? null : buyerMessage.trim();
    }

    public String getBuyerNick() {
        return buyerNick;
    }

    public void setBuyerNick(String buyerNick) {
        this.buyerNick = buyerNick == null ? null : buyerNick.trim();
    }

    public Byte getBuyerRate() {
        return buyerRate;
    }

    public void setBuyerRate(Byte buyerRate) {
        this.buyerRate = buyerRate;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    @Override
    public String toString() {
        return "CommodityOrder{" +
                "id='" + id + '\'' +
                ", payment='" + payment + '\'' +
                ", paymentType=" + paymentType +
                ", postFee='" + postFee + '\'' +
                ", status=" + status +
                ", paymentTime=" + paymentTime +
                ", closeTime=" + closeTime +
                ", endTime=" + endTime +
                ", consignTime=" + consignTime +
                ", shippingName='" + shippingName + '\'' +
                ", shippingCode='" + shippingCode + '\'' +
                ", userId=" + userId +
                ", buyerMessage='" + buyerMessage + '\'' +
                ", buyerNick='" + buyerNick + '\'' +
                ", buyerRate=" + buyerRate +
                ", created=" + created +
                ", updated=" + updated +
                '}';
    }
}