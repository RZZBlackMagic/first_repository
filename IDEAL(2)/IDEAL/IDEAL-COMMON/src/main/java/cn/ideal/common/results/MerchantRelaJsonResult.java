package cn.ideal.common.results;

import java.io.Serializable;
import java.util.Date;

public class MerchantRelaJsonResult implements Serializable {

    private Long merchantId;

    private Long productorId;

    private Date applyTime;

    private String merchantName;

    private String productorName;

    private Integer status;

    private Date agreeTime;

    private Integer relaComNum;

    public MerchantRelaJsonResult() {
    }

    public MerchantRelaJsonResult(Long merchantId, Long productorId, Date applyTime, String merchantName, String productorName, Integer status, Date agreeTime, Integer relaComNum) {
        this.merchantId = merchantId;
        this.productorId = productorId;
        this.applyTime = applyTime;
        this.merchantName = merchantName;
        this.productorName = productorName;
        this.status = status;
        this.agreeTime = agreeTime;
        this.relaComNum = relaComNum;
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

    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getProductorName() {
        return productorName;
    }

    public void setProductorName(String productorName) {
        this.productorName = productorName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getAgreeTime() {
        return agreeTime;
    }

    public void setAgreeTime(Date agreeTime) {
        this.agreeTime = agreeTime;
    }

    public Integer getRelaComNum() {
        return relaComNum;
    }

    public void setRelaComNum(Integer relaComNum) {
        this.relaComNum = relaComNum;
    }
}
