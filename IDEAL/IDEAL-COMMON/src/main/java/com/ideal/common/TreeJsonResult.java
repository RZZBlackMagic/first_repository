package com.ideal.common;

import java.io.Serializable;

public class TreeJsonResult implements Serializable {

    private long id;
    private String name;
    private long pId;
    private String isParent;
    private String open;

    public TreeJsonResult() {
    }

    public TreeJsonResult(long id, String name, long pId, String isParent, String open) {
        this.id = id;
        this.name = name;
        this.pId = pId;
        this.isParent = isParent;
        this.open = open;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getpId() {
        return pId;
    }

    public void setpId(long pId) {
        this.pId = pId;
    }

    public String getIsParent() {
        return isParent;
    }

    public void setIsParent(String isParent) {
        this.isParent = isParent;
    }

    public String getOpen() {
        return open;
    }

    public void setOpen(String open) {
        this.open = open;
    }
}
