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

    public RelaMerProCom() {
    }

    public RelaMerProCom(Long id, Long merchantId, Long productorId, Long commodityId, Long cid, String merchantName, String productorName, String commodityName, String location, Date applyTime, Date agreeTime, Byte status) {
        this.id = id;
        this.merchantId = merchantId;
        this.productorId = productorId;
        this.commodityId = commodityId;
        this.cid = cid;
        this.merchantName = merchantName;
        this.productorName = productorName;
        this.commodityName = commodityName;
        this.location = location;
        this.applyTime = applyTime;
        this.agreeTime = agreeTime;
        this.status = status;
    }

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
}