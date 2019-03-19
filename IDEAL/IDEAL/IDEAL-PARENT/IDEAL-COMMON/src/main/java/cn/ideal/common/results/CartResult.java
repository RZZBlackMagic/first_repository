package cn.ideal.common.results;

import java.io.Serializable;

/**
 * @author XINER
 * @create 2019-03-18 10:18
 * @desc
 **/
public class CartResult implements Serializable {
    private Long id;

    private String title;

    private int num;

    private int price;

    private String pic;

    public CartResult() {
    }

    public CartResult(Long id, String title, int num, int price, String pic) {
        this.id = id;
        this.title = title;
        this.num = num;
        this.price = price;
        this.pic = pic;
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

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }
}
