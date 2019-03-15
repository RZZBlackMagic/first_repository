package cn.ideal.common.pojo;

import java.io.Serializable;
import java.util.Date;

public class RelaMerPro extends RelaMerProKey implements Serializable {
    private String merchantName;

    private String productorName;

    private Date applyTime;

    private Date agreeTime;

    private Byte status;

    public RelaMerPro() {
    }

    public RelaMerPro(String merchantName, String productorName, Date applyTime, Date agreeTime, Byte status) {
        this.merchantName = merchantName;
        this.productorName = productorName;
        this.applyTime = applyTime;
        this.agreeTime = agreeTime;
        this.status = status;
    }

    @Override
    public String toString() {
        return "RelaMerPro{" +
                "merchantName='" + merchantName + '\'' +
                ", productorName='" + productorName + '\'' +
                ", applyTime=" + applyTime +
                ", agreeTime=" + agreeTime +
                ", status=" + status +
                '}';
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