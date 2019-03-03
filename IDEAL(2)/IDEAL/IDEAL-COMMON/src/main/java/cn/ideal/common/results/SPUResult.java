package cn.ideal.common.results;

import java.io.Serializable;

/**
 * @author XINER
 * @create 2019-02-01 21:51
 * @desc SPU
 **/
public class SPUResult implements Serializable {
    private Long id;

    private String title;

    private String category;

    private String sellpoint;

    private String image;

    private Byte status;

    public SPUResult() {
    }

    public SPUResult(Long id, String title, String category, String sellpoint, String image, Byte status) {
        this.id = id;
        this.title = title;
        this.category = category;
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
