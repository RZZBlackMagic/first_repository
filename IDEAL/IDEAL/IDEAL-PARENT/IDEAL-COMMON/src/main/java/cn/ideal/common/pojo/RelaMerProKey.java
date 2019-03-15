package cn.ideal.common.pojo;

import java.io.Serializable;

public class RelaMerProKey implements Serializable {
    private Long merchantId;

    private Long productorId;

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



    @Override
    public String toString() {
        return "RelaMerProKey{" +
                "merchantId=" + merchantId +
                ", productorId=" + productorId +
                '}';
    }
}