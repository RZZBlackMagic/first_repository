package cn.ideal.common.results;

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
    private String isParent;

    public TreeJsonResult() {
    }

    public TreeJsonResult(long id, String name, long pId, String isParent) {
        this.id = id;
        this.name = name;
        this.pId = pId;
        this.isParent = isParent;
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

}
