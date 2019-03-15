package cn.ideal.common.pojo;

import java.io.Serializable;

public class CommoditySpu implements Serializable {
    private Long id;

    private String title;

    private Long cid;

    private Long apid;

    private String sellpoint;

    private String image;

    private Byte status;

    public CommoditySpu() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public Long getApid() {
        return apid;
    }

    public void setApid(Long apid) {
        this.apid = apid;
    }

    public String getSellpoint() {
        return sellpoint;
    }

    public void setSellpoint(String sellpoint) {
        this.sellpoint = sellpoint == null ? null : sellpoint.trim();
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    public Byte getStatus() {
        return status;
    }

    public CommoditySpu(Long id, String title, Long cid, Long apid, String sellpoint, String image, Byte status) {
        this.id = id;
        this.title = title;
        this.cid = cid;
        this.apid = apid;
        this.sellpoint = sellpoint;
        this.image = image;
        this.status = status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }
}