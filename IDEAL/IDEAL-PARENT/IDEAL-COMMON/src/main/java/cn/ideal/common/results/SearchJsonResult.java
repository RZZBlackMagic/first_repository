package cn.ideal.common.results;

import java.io.Serializable;

/**
 * @author XINER
 * @create 2019-02-23 16:20
 * @desc 搜索POJO
 **/
public class SearchJsonResult implements Serializable {
    private String id;
    private String title;
    private String sellpoint;
    private String image;
    private String category_name;
    private String productor_name;
    private String merchant_name;
    private Float price;
    private Float discount;

    public SearchJsonResult() {
    }


    public SearchJsonResult(String id, String title, String sellpoint, String image, String category_name, String productor_name, String merchant_name, Float price, Float discount) {
        this.id = id;
        this.title = title;
        this.sellpoint = sellpoint;
        this.image = image;
        this.category_name = category_name;
        this.productor_name = productor_name;
        this.merchant_name = merchant_name;
        this.price = price;
        this.discount = discount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public String getProductor_name() {
        return productor_name;
    }

    public void setProductor_name(String productor_name) {
        this.productor_name = productor_name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Float getDiscount() {
        return discount;
    }

    public void setDiscount(Float discount) {
        this.discount = discount;
    }

    public String getMerchant_name() {
        return merchant_name;
    }

    public void setMerchant_name(String merchant_name) {
        this.merchant_name = merchant_name;
    }

    @Override
    public String toString() {
        return "SearchJsonResult{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", sellpoint='" + sellpoint + '\'' +
                ", image='" + image + '\'' +
                ", category_name='" + category_name + '\'' +
                ", productor_name='" + productor_name + '\'' +
                ", merchant_name='" + merchant_name + '\'' +
                ", price=" + price +
                ", discount=" + discount +
                '}';
    }
}
