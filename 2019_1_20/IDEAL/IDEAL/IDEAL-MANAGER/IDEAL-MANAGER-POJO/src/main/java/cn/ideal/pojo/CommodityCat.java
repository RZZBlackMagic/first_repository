package cn.ideal.pojo;

import java.io.Serializable;
import java.util.Date;

public class CommodityCat extends CommodityCatKey implements Serializable {
    private String name;

    private Byte status;

    private Integer sort;

    private Byte isparent;

    private Date created;

    private Date updated;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Byte getIsparent() {
        return isparent;
    }

    public void setIsparent(Byte isparent) {
        this.isparent = isparent;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }
}