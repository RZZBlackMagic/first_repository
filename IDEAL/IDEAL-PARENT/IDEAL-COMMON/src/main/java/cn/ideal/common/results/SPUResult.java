package cn.ideal.common.results;

import java.io.Serializable;

/**
 * @author XINER
 * @create 2019-02-01 21:51
 * @desc SPU
 **/
public class SpuResult implements Serializable {
    private Long id;

    private Long cid;

    private Long apid;

    private String title;

    private String category;

    private String productor;

    private String sellpoint;

    private String image;

    private Byte status;

    public SpuResult() {
    }

    public SpuResult(Long id, Long cid, Long apid, String title, String category, String productor, String sellpoint, String image, Byte status) {
        this.id = id;
        this.cid = cid;
        this.apid = apid;
        this.title = title;
        this.category = category;
        this.productor = productor;
        this.sellpoint = sellpoint;
        this.image = image;
        this.status = status;
    }

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

    public Long getApid() {
        return apid;
    }

    public void setApid(Long apid) {
        this.apid = apid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getProductor() {
        return productor;
    }

    public void setProductor(String productor) {
        this.productor = productor;
    }

    public String getSellpoint() {
        return sellpoint;
    }

    public void setSellpoint(String sellpoint) {
        this.sellpoint = sellpoint;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }
}
