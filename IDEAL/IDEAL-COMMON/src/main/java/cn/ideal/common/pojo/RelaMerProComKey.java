package cn.ideal.common.pojo;

import java.io.Serializable;

public class RelaMerProComKey implements Serializable {
    private Long merchantId;

    private Long productorId;

    private Long commodityId;

    public RelaMerProComKey() {
    }

    public RelaMerProComKey(Long merchantId, Long productorId, Long commodityId) {
        this.merchantId = merchantId;
        this.productorId = productorId;
        this.commodityId = commodityId;
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
}