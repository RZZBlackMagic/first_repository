package cn.ideal.common.pojo;

import java.io.Serializable;

public class CommoditySpe implements Serializable {
    private Long id;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public CommoditySpe(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public CommoditySpe() {
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}