package cn.ideal.common.pojo;

import java.io.Serializable;
import java.util.Date;

public class AccountManager implements Serializable {
    private Long id;

    private String username;

    private String password;

    private Date created;

    private Date updated;

    private String phone;

    private String email;

    public AccountManager() {
    }

    public AccountManager(Long id, String username, String password, Date created, Date updated, String phone, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.created = created;
        this.updated = updated;
        this.phone = phone;
        this.email = email;
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