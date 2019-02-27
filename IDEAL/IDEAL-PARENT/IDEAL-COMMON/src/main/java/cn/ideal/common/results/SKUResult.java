package cn.ideal.common.results;

import java.io.Serializable;

/**
 * @author XINER
 * @create 2019-02-07 20:30
 * @desc SKU Result
 **/
public class SKUResult implements Serializable {
    private Long id;

    private Long spuid;

    private Long csid;

    private String spe;

    private Float price;

    private Integer quantity;

    private String image;

    private String position;

    private Byte status;

    private String desc;

    public SKUResult() {
    }

    public SKUResult(Long id, Long spuid, Long csid, String spe, Float price, Integer quantity, String image, String position, Byte status, String desc) {
        this.id = id;
        this.spuid = spuid;
        this.csid = csid;
        this.spe = spe;
        this.price = price;
        this.quantity = quantity;
        this.image = image;
        this.position = position;
        this.status = status;
        this.desc = desc;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSpuid() {
        return spuid;
    }

    public void setSpuid(Long spuid) {
        this.spuid = spuid;
    }

    public Long getCsid() {
        return csid;
    }

    public void setCsid(Long csid) {
        this.csid = csid;
    }

    public String getSpe() {
        return spe;
    }

    public void setSpe(String spe) {
        this.spe = spe;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "SKUResult{" +
                "id=" + id +
                ", spuid=" + spuid +
                ", csid=" + csid +
                ", spe='" + spe + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", image='" + image + '\'' +
                ", position='" + position + '\'' +
                ", status=" + status +
                ", desc='" + desc + '\'' +
                '}';
    }
}
