package cn.ideal.common.pojo;

import java.io.Serializable;

public class CommoditySpev implements Serializable {
    private Long id;

    private Long speid;

    private String value;

    public CommoditySpev() {
    }

    public CommoditySpev(Long id, Long speid, String value) {
        this.id = id;
        this.speid = speid;
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSpeid() {
        return speid;
    }

    public void setSpeid(Long speid) {
        this.speid = speid;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }
}