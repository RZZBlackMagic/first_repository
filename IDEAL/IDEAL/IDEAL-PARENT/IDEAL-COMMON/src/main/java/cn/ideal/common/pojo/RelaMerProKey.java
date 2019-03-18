package cn.ideal.common.pojo;

import java.io.Serializable;

public class RelaMerProKey implements Serializable {
    private Long merchantId;

    private Long productorId;

    public RelaMerProKey() {
    }

    public RelaMerProKey(Long merchantId, Long productorId) {
        this.merchantId = merchantId;
        this.productorId = productorId;
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
}