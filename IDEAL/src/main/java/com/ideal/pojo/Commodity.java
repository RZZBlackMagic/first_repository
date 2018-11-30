package com.ideal.pojo;

import java.util.Date;

public class Commodity {
	private Long id;

     private String title;

     private String hotpoint;

     private Long price;

     private Integer quantity;

     private Long bid;

     private String image;

    private String position;

    private String category;

    private Byte status;

    private Date created;

    private Date updated;

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

    public String getHotpoint() {
        return hotpoint;
    }

    public void setHotpoint(String hotpoint) {
        this.hotpoint = hotpoint == null ? null : hotpoint.trim();
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Long getBid() {
        return bid;
    }

    public void setBid(Long bid) {
        this.bid = bid;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

	@Override
	public String toString() {
		return "Commodity [id=" + id + ", title=" + title + ", hotpoint=" + hotpoint + ", price=" + price
				+ ", quantity=" + quantity + ", bid=" + bid + ", image=" + image + ", position=" + position
				+ ", category=" + category + ", status=" + status + ", created=" + created + ", updated=" + updated
				+ "]";
	}
    
}