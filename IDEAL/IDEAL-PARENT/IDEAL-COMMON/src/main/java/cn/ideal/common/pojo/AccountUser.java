package cn.ideal.common.pojo;

import java.io.Serializable;
import java.util.Date;

public class AccountUser implements Serializable {
    private Long id;

    private String username;

    private String password;

    private String nickname;

    private String image;

    private String pwdQuestion;

    private String pwdAnswer;

    private String realName;

    private String idCard;

    private String sex;

    private String telephone;

    private String email;

    private String country;

    private String address;

    private String zip;

    private Byte vip;

    private Byte status;

    private Long point;

    private Date lastVisitTime;

    private String lastVisitIp;

    private Date created;

    private Date updated;

    public AccountUser() {
    }

    public AccountUser(Long id, String username, String password, String nickname, String image, String pwdQuestion, String pwdAnswer, String realName, String idCard, String sex, String telephone, String email, String country, String address, String zip, Byte vip, Byte status, Long point, Date lastVisitTime, String lastVisitIp, Date created, Date updated) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.image = image;
        this.pwdQuestion = pwdQuestion;
        this.pwdAnswer = pwdAnswer;
        this.realName = realName;
        this.idCard = idCard;
        this.sex = sex;
        this.telephone = telephone;
        this.email = email;
        this.country = country;
        this.address = address;
        this.zip = zip;
        this.vip = vip;
        this.status = status;
        this.point = point;
        this.lastVisitTime = lastVisitTime;
        this.lastVisitIp = lastVisitIp;
        this.created = created;
        this.updated = updated;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    public String getPwdQuestion() {
        return pwdQuestion;
    }

    public void setPwdQuestion(String pwdQuestion) {
        this.pwdQuestion = pwdQuestion == null ? null : pwdQuestion.trim();
    }

    public String getPwdAnswer() {
        return pwdAnswer;
    }

    public void setPwdAnswer(String pwdAnswer) {
        this.pwdAnswer = pwdAnswer == null ? null : pwdAnswer.trim();
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard == null ? null : idCard.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country == null ? null : country.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip == null ? null : zip.trim();
    }

    public Byte getVip() {
        return vip;
    }

    public void setVip(Byte vip) {
        this.vip = vip;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Long getPoint() {
        return point;
    }

    public void setPoint(Long point) {
        this.point = point;
    }

    public Date getLastVisitTime() {
        return lastVisitTime;
    }

    public void setLastVisitTime(Date lastVisitTime) {
        this.lastVisitTime = lastVisitTime;
    }

    public String getLastVisitIp() {
        return lastVisitIp;
    }

    public void setLastVisitIp(String lastVisitIp) {
        this.lastVisitIp = lastVisitIp == null ? null : lastVisitIp.trim();
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
}