package cn.ideal.common.pojo;

import java.io.Serializable;

/**
 * @author XINER
 * @create 2018-11-27 18:53
 * @desc ZTree JSON对象
 **/
public class TreeJsonResult implements Serializable {

    private long id;
    private String name;
    private long pId;
    private Integer isParent;
    private Boolean open;

    public TreeJsonResult() {
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

    public Integer getIsParent() {
        return isParent;
    }

    public void setIsParent(Integer isParent) {
        this.isParent = isParent;
    }

    public Boolean getOpen() {
        return open;
    }

    public void setOpen(Boolean open) {
        this.open = open;
    }

    @Override
    public String toString() {
        return "TreeJsonResult{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pId=" + pId +
                ", isParent=" + isParent +
                ", open=" + open +
                '}';
    }
}
