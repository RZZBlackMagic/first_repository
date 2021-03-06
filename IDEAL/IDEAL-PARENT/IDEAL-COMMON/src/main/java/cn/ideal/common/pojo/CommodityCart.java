package cn.ideal.common.pojo;

import java.io.Serializable;
import java.util.Date;

public class CommodityCart implements Serializable {
    private Long id;

    private Long userId;

    private Long skuId;

    private String title;

    private String image;

    private Integer price;

    private Integer amount;

    private String spe;

    private Date created;

    private Byte checked;

    public CommodityCart() {

    }

    public CommodityCart(Long id, Long userId, Long skuId, String title, String image, Integer price, Integer amount, String spe, Date created, Byte checked) {
        this.id = id;
        this.userId = userId;
        this.skuId = skuId;
        this.title = title;
        this.image = image;
        this.price = price;
        this.amount = amount;
        this.spe = spe;
        this.created = created;
        this.checked = checked;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getSkuId() {
        return skuId;
    }

    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getSpe() {
        return spe;
    }

    public void setSpe(String spe) {
        this.spe = spe == null ? null : spe.trim();
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Byte getChecked() {
        return checked;
    }

    public void setChecked(Byte checked) {
        this.checked = checked;
    }
}