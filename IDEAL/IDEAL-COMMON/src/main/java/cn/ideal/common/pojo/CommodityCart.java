package cn.ideal.common.pojo;

import java.io.Serializable;

public class CommodityCart implements Serializable {
    private Long id;

    private String title;

    private Long num;

    private Long price;

    private String pic;

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

    public Long getNum() {
        return num;
    }

    public void setNum(Long num) {
        this.num = num;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic == null ? null : pic.trim();
    }

    public CommodityCart(Long id, String title, Long num, Long price, String pic) {
        this.id = id;
        this.title = title;
        this.num = num;
        this.price = price;
        this.pic = pic;
    }

    public CommodityCart() {
    }

    @Override
    public String toString() {
        return "CommodityCart{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", num=" + num +
                ", price=" + price +
                ", pic='" + pic + '\'' +
                '}';
    }
}