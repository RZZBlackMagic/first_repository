package cn.ideal.pojo;

import java.util.Date;

public class AccountProductor {
    private Long id;

    private String username;

    private String password;

    private Date updated;

    private Date created;

    private Integer status;

    private String companyzh;

    private String companyen;

    private String mainbusiness;

    private String location;

    private String type;

    private Long turnover;

    private Long employees;

    private String website;

    private String ceo;

    private String logo;

    private String phone;

    private String email;

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

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCompanyzh() {
        return companyzh;
    }

    public void setCompanyzh(String companyzh) {
        this.companyzh = companyzh == null ? null : companyzh.trim();
    }

    public String getCompanyen() {
        return companyen;
    }

    public void setCompanyen(String companyen) {
        this.companyen = companyen == null ? null : companyen.trim();
    }

    public String getMainbusiness() {
        return mainbusiness;
    }

    public void setMainbusiness(String mainbusiness) {
        this.mainbusiness = mainbusiness == null ? null : mainbusiness.trim();
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Long getTurnover() {
        return turnover;
    }

    public void setTurnover(Long turnover) {
        this.turnover = turnover;
    }

    public Long getEmployees() {
        return employees;
    }

    public void setEmployees(Long employees) {
        this.employees = employees;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website == null ? null : website.trim();
    }

    public String getCeo() {
        return ceo;
    }

    public void setCeo(String ceo) {
        this.ceo = ceo == null ? null : ceo.trim();
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo == null ? null : logo.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }
}