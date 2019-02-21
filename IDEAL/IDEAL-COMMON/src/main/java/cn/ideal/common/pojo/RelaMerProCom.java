package cn.ideal.common.pojo;

import java.io.Serializable;
import java.util.Date;

public class RelaMerProCom extends RelaMerProComKey implements Serializable {
    private Date time;

    private String merchantName;

    private String productorName;

    private String commodityName;

    private Integer status;

    public RelaMerProCom() {
    }

    public RelaMerProCom(Long merchantId, Long productorId, Long commodityId, Date time, String merchantName, String productorName, String commodityName, Integer status) {
        super(merchantId, productorId, commodityId);
        this.time = time;
        this.merchantName = merchantName;
        this.productorName = productorName;
        this.commodityName = commodityName;
        this.status = status;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}