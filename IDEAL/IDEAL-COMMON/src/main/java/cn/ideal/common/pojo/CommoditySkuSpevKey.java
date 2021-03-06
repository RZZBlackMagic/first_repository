package cn.ideal.common.pojo;

import java.io.Serializable;

public class CommoditySkuSpevKey implements Serializable {
    private Long skuid;

    private Long spevid;

    public CommoditySkuSpevKey() {
    }

    public CommoditySkuSpevKey(Long skuid, Long spevid) {
        this.skuid = skuid;
        this.spevid = spevid;
    }

    public Long getSkuid() {
        return skuid;
    }

    public void setSkuid(Long skuid) {
        this.skuid = skuid;
    }

    public Long getSpevid() {
        return spevid;
    }

    public void setSpevid(Long spevid) {
        this.spevid = spevid;
    }
}