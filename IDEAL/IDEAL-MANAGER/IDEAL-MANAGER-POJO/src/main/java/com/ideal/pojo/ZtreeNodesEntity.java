package com.ideal.pojo;

import java.io.Serializable;

public class ZtreeNodesEntity implements Serializable {

    private Long Id;
    private Long pId;
    private String name;
    private boolean open;

    public ZtreeNodesEntity() {

    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
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
        return "ZtreeNodesEntity{" +
                "Id=" + Id +
                ", pId=" + pId +
                ", name='" + name + '\'' +
                ", open=" + open +
                '}';
    }
}
