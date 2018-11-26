package com.ideal.common.pojo;

import java.io.Serializable;

public class CommodityZtreeJsonResult implements Serializable {
    private Long id;
    private Long pId;
    private  String name;
    private boolean open;

    public CommodityZtreeJsonResult() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getpId() {
        return pId;
    }

    public void setpId(Long pId) {
        this.pId = pId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    @Override
    public String toString() {
        return "CommodityZtreeJsonResult{" +
                "id=" + id +
                ", pId=" + pId +
                ", name='" + name + '\'' +
                ", open=" + open +
                '}';
    }
}
