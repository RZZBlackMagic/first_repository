package com.ideal.pojo;

public class CommodityCat {
    private Long cid;

    private Long pid;

    private String name;

    private Byte status;

    private Integer sort;

    private Byte parent;

    private String created;

    private String updated;

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
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

    public Byte getParent() {
        return parent;
    }

    public void setParent(Byte parent) {
        this.parent = parent;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created == null ? null : created.trim();
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated == null ? null : updated.trim();
    }

	@Override
	public String toString() {
		return "CommodityCat [cid=" + cid + ", pid=" + pid + ", name=" + name + ", status=" + status + ", sort=" + sort
				+ ", parent=" + parent + ", created=" + created + ", updated=" + updated + "]";
	}
    
}