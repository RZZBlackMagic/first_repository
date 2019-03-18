package cn.ideal.common.pojo;

import java.io.Serializable;
import java.util.Date;

public class CommodityCat implements Serializable {
    private Long id;

    private Long pid;

    private String name;

    private String image;

    private String frontName;

    private Byte status;

    private Integer sort;

    private Byte isparent;

    private Date created;

    private Date updated;

    public CommodityCat() {
    }

    public CommodityCat(Long id, Long pid, String name, String image, String frontName, Byte status, Integer sort, Byte isparent, Date created, Date updated) {
        this.id = id;
        this.pid = pid;
        this.name = name;
        this.image = image;
        this.frontName = frontName;
        this.status = status;
        this.sort = sort;
        this.isparent = isparent;
        this.created = created;
        this.updated = updated;
    }

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    public String getFrontName() {
        return frontName;
    }

    public void setFrontName(String frontName) {
        this.frontName = frontName == null ? null : frontName.trim();
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

    @Override
    public String toString() {
        return "CommodityCat{" +
                "id=" + id +
                ", pid=" + pid +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", frontName='" + frontName + '\'' +
                ", status=" + status +
                ", sort=" + sort +
                ", isparent=" + isparent +
                ", created=" + created +
                ", updated=" + updated +
                '}';
    }
}