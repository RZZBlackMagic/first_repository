package cn.ideal.common.pojo;

import java.io.Serializable;

public class CommoditySpuSpeKey implements Serializable {
    private Long spuid;

    private Long speid;

    public CommoditySpuSpeKey() {
    }

    public CommoditySpuSpeKey(Long spuid, Long speid) {
        this.spuid = spuid;
        this.speid = speid;
    }

    public Long getSpuid() {
        return spuid;
    }

    public void setSpuid(Long spuid) {
        this.spuid = spuid;
    }

    public Long getSpeid() {
        return speid;
    }

    public void setSpeid(Long speid) {
        this.speid = speid;
    }
}