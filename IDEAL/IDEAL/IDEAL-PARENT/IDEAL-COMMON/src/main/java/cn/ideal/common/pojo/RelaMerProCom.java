package cn.ideal.common.pojo;

import java.io.Serializable;
import java.util.Date;

public class RelaMerProCom implements Serializable {
    private Long id;

    private Long merchantId;

    private Long productorId;

    private Long commodityId;

    private Long cid;

    private String merchantName;

    private String productorName;

    private String commodityName;

    private String location;

    private Date applyTime;

    private Date agreeTime;

    private Byte status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    public Long getProductorId() {
        return productorId;
    }

    public void setProductorId(Long productorId) {
        this.productorId = productorId;
    }

    public Long getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(Long commodityId) {
        this.commodityId = commodityId;
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName == null ? null : merchantName.trim();
    }

    public String getProductorName() {
        return productorName;
    }

    public void setProductorName(String productorName) {
        this.productorName = productorName == null ? null : productorName.trim();
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName == null ? null : commodityName.trim();
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    public Date getAgreeTime() {
        return agreeTime;
    }

    public void setAgreeTime(Date agreeTime) {
        this.agreeTime = agreeTime;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "RelaMerProCom{" +
                "id=" + id +
                ", merchantId=" + merchantId +
                ", productorId=" + productorId +
                ", commodityId=" + commodityId +
                ", cid=" + cid +
                ", merchantName='" + merchantName + '\'' +
                ", productorName='" + productorName + '\'' +
                ", commodityName='" + commodityName + '\'' +
                ", location='" + location + '\'' +
                ", applyTime=" + applyTime +
                ", agreeTime=" + agreeTime +
                ", status=" + status +
                '}';
    }
}