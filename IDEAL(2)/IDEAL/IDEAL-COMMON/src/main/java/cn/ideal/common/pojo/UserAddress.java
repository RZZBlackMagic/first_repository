package cn.ideal.common.pojo;

import java.io.Serializable;

public class UserAddress implements Serializable {
    private String id;
    private String userName;
    private String zipCode;
    private String phone;
    private String address;
    private String detailAddress;
    private String addressTag;

    public UserAddress() {
    }

    public UserAddress(String id, String userName, String zipCode, String phone, String address, String detailAddress, String addressTag) {
        this.id = id;
        this.userName = userName;
        this.zipCode = zipCode;
        this.phone = phone;
        this.address = address;
        this.detailAddress = detailAddress;
        this.addressTag = addressTag;
    }

    public String  getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDetailAddress() {
        return detailAddress;
    }

    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress;
    }

    public String getAddressTag() {
        return addressTag;
    }

    public void setAddressTag(String addressTag) {
        this.addressTag = addressTag;
    }

    @Override
    public String toString() {
        return "UserAddress{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", detailAddress='" + detailAddress + '\'' +
                ", addressTag='" + addressTag + '\'' +
                '}';
    }
}
