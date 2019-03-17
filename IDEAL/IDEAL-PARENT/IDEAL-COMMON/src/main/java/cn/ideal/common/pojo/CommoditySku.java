package cn.ideal.common.pojo;

import java.io.Serializable;

public class CommoditySku implements Serializable {
    private Long id;

    private Long spuid;

    private Long csid;

    private Integer price;

    private Integer discount;

    private Integer quantity;

    private String image;

    private String position;

    private Byte status;

    private String descp;

    public CommoditySku() {
    }

    public CommoditySku(Long id, Long spuid, Long csid, Integer price, Integer discount, Integer quantity, String image, String position, Byte status, String descp) {
        this.id = id;
        this.spuid = spuid;
        this.csid = csid;
        this.price = price;
        this.discount = discount;
        this.quantity = quantity;
        this.image = image;
        this.position = position;
        this.status = status;
        this.descp = descp;
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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
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
        this.image = image == null ? null : image.trim();
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getDescp() {
        return descp;
    }

    public void setDescp(String descp) {
        this.descp = descp == null ? null : descp.trim();
    }

    @Override
    public String toString() {
        return "CommoditySku{" +
                "id=" + id +
                ", spuid=" + spuid +
                ", csid=" + csid +
                ", price=" + price +
                ", discount=" + discount +
                ", quantity=" + quantity +
                ", image='" + image + '\'' +
                ", position='" + position + '\'' +
                ", status=" + status +
                ", descp='" + descp + '\'' +
                '}';
    }
}