package cn.ideal.pojo;

import java.io.Serializable;

public class CommodityCatKey implements Serializable {
    private Long id;

    private Long pid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }
}