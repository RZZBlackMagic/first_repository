package cn.ideal.common.pojo;

import java.io.Serializable;

public class CommodityAddress implements Serializable {
    private Long id;

    private Long userId;

    private String name;

    private String mobile;

    private String fullRegion;

    private String address;

    private String addressTag;

    private String zip;

    private Byte isDefault;

    @Override
    public String toString() {
        return "CommodityAddress{" +
                "id=" + id +
                ", userId=" + userId +
                ", name='" + name + '\'' +
                ", mobile='" + mobile + '\'' +
                ", fullRegion='" + fullRegion + '\'' +
                ", address='" + address + '\'' +
                ", addressTag='" + addressTag + '\'' +
                ", zip='" + zip + '\'' +
                ", isDefault=" + isDefault +
                '}';
    }

    public CommodityAddress() {
    }

    public CommodityAddress(Long id, Long userId, String name, String mobile, String fullRegion, String address, String addressTag, String zip, Byte isDefault) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.mobile = mobile;
        this.fullRegion = fullRegion;
        this.address = address;
        this.addressTag = addressTag;
        this.zip = zip;
        this.isDefault = isDefault;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getFullRegion() {
        return fullRegion;
    }

    public void setFullRegion(String fullRegion) {
        this.fullRegion = fullRegion == null ? null : fullRegion.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getAddressTag() {
        return addressTag;
    }

    public void setAddressTag(String addressTag) {
        this.addressTag = addressTag == null ? null : addressTag.trim();
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip == null ? null : zip.trim();
    }

    public Byte getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Byte isDefault) {
        this.isDefault = isDefault;
    }
}