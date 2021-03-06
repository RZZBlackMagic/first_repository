package cn.ideal.pojo;

import java.io.Serializable;
import java.util.Date;

public class RelaMerProCom extends RelaMerProComKey implements Serializable {
    private Date time;

    private String merchantName;

    private String productorName;

    private String commodityName;

    private Integer status;



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

    @Override
    public String toString() {
        return "RelaMerProCom{" +
                "time=" + time +
                ", merchantName='" + merchantName + '\'' +
                ", productorName='" + productorName + '\'' +
                ", commodityName='" + commodityName + '\'' +
                ", status=" + status +
                '}';
    }
}