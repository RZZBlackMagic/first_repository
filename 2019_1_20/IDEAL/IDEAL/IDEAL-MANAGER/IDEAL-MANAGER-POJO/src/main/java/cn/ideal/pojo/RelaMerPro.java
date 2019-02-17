package cn.ideal.pojo;

import java.io.Serializable;
import java.util.Date;

public class RelaMerPro implements Serializable {
    private Long merchantId;

    private Long productorId;

    private Date applyTime;

    private String merchantName;

    private String productorName;

    private Integer status;

    private Date agreeTime;

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
        this.merchantName = merchantName == null ? null : merchantName.trim();
    }

    public String getProductorName() {
        return productorName;
    }

    public void setProductorName(String productorName) {
        this.productorName = productorName == null ? null : productorName.trim();
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

    @Override
    public String toString() {
        return "RelaMerPro{" +
                "merchantId=" + merchantId +
                ", productorId=" + productorId +
                ", applyTime=" + applyTime +
                ", merchantName='" + merchantName + '\'' +
                ", productorName='" + productorName + '\'' +
                ", status=" + status +
                ", agreeTime=" + agreeTime +
                '}';
    }

    public void setAgreeTime(Date agreeTime) {
        this.agreeTime = agreeTime;
    }

}