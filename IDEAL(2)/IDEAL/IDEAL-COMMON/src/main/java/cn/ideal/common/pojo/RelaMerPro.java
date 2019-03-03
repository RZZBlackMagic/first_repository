package cn.ideal.common.pojo;

import java.io.Serializable;
import java.util.Date;

public class RelaMerPro extends RelaMerProKey implements Serializable {
    private Date applyTime;

    private String merchantName;

    private String productorName;

    private Integer status;

    private Date agreeTime;

    public RelaMerPro() {
    }

    public RelaMerPro(Long merchantId, Long productorId) {
        super(merchantId, productorId);
    }

    public RelaMerPro(Date applyTime, String merchantName, String productorName, Integer status, Date agreeTime) {
        this.applyTime = applyTime;
        this.merchantName = merchantName;
        this.productorName = productorName;
        this.status = status;
        this.agreeTime = agreeTime;
    }

    public RelaMerPro(Long merchantId, Long productorId, Date applyTime, String merchantName, String productorName, Integer status, Date agreeTime) {
        super(merchantId, productorId);
        this.applyTime = applyTime;
        this.merchantName = merchantName;
        this.productorName = productorName;
        this.status = status;
        this.agreeTime = agreeTime;
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

    public void setAgreeTime(Date agreeTime) {
        this.agreeTime = agreeTime;
    }
}