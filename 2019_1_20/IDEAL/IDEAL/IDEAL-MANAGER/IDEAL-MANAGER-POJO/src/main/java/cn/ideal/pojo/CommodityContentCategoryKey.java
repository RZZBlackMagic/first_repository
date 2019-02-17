package cn.ideal.pojo;

import java.io.Serializable;

public class CommodityContentCategoryKey implements Serializable {
    private Long id;

    private Long parentId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }
}