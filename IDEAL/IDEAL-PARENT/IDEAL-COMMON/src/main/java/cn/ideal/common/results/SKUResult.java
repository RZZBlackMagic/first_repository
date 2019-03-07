package cn.ideal.common.results;

import java.io.Serializable;

/**
 * @author XINER
 * @create 2019-02-07 20:30
 * @desc SKU Result
 **/
public class SkuResult implements Serializable {

    private Long id;

    private Long spuid;

    private Long csid; //生产商id

    private Long cid;

    private String spuName;

    private String categoryName;

    private String spe;

    private Integer price;

    private Integer discount;

    private Integer quantity;

    private String spu_image;

    private String sku_image;

    private String position;

    private String sellpoint;

    private String descp;

    private Byte spu_status;

    private Byte sku_status;

    public SkuResult() {
    }

    public SkuResult(Long id, Long spuid, Long csid, Long cid, String spuName, String categoryName, String spe, Integer price, Integer discount, Integer quantity, String spu_image, String sku_image, String position, String sellpoint, String descp, Byte spu_status, Byte sku_status) {
        this.id = id;
        this.spuid = spuid;
        this.csid = csid;
        this.cid = cid;
        this.spuName = spuName;
        this.categoryName = categoryName;
        this.spe = spe;
        this.price = price;
        this.discount = discount;
        this.quantity = quantity;
        this.spu_image = spu_image;
        this.sku_image = sku_image;
        this.position = position;
        this.sellpoint = sellpoint;
        this.descp = descp;
        this.spu_status = spu_status;
        this.sku_status = sku_status;
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

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public String getSpuName() {
        return spuName;
    }

    public void setSpuName(String spuName) {
        this.spuName = spuName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getSpe() {
        return spe;
    }

    public void setSpe(String spe) {
        this.spe = spe;
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

    public String getSpu_image() {
        return spu_image;
    }

    public void setSpu_image(String spu_image) {
        this.spu_image = spu_image;
    }

    public String getSku_image() {
        return sku_image;
    }

    public void setSku_image(String sku_image) {
        this.sku_image = sku_image;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getSellpoint() {
        return sellpoint;
    }

    public void setSellpoint(String sellpoint) {
        this.sellpoint = sellpoint;
    }

    public String getDescp() {
        return descp;
    }

    public void setDescp(String descp) {
        this.descp = descp;
    }

    public Byte getSpu_status() {
        return spu_status;
    }

    public void setSpu_status(Byte spu_status) {
        this.spu_status = spu_status;
    }

    public Byte getSku_status() {
        return sku_status;
    }

    public void setSku_status(Byte sku_status) {
        this.sku_status = sku_status;
    }
}
