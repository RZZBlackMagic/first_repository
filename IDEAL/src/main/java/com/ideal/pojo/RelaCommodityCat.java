package com.ideal.pojo;

public class RelaCommodityCat {
    private Long id;

    private Long cid;

    private String title;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

	@Override
	public String toString() {
		return "RelaCommodityCat [id=" + id + ", cid=" + cid + ", title=" + title + "]";
	}
    
}