package cn.ideal.common.pojo;

import java.io.Serializable;
import java.util.Date;

public class AccountProductor implements Serializable {
    private Long id;

    private String username;

    private String password;

    private String companyZh;

    private String companyEn;

    private String logo;

    private Date foundingTime;

    private String loginAddress;

    private String zip;

    private Long employees;

    private Long turnover;

    private String phone;

    private String telephone;

    private String email;

    private String fax;

    private String website;

    private String legalRepresentative;

    private String mainProprietor;

    private String area;

    private String economicType;

    private Byte marketPassport;

    private String stockCode;

    private String businessField;

    private String bank;

    private String bankAccount;

    private String bankPermit;

    private Date created;

    private Date updated;

    private Integer status;

    public AccountProductor() {
    }

    public AccountProductor(Long id, String username, String password, String companyZh, String companyEn, String logo, Date foundingTime, String loginAddress, String zip, Long employees, Long turnover, String phone, String telephone, String email, String fax, String website, String legalRepresentative, String mainProprietor, String area, String economicType, Byte marketPassport, String stockCode, String businessField, String bank, String bankAccount, String bankPermit, Date created, Date updated, Integer status) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.companyZh = companyZh;
        this.companyEn = companyEn;
        this.logo = logo;
        this.foundingTime = foundingTime;
        this.loginAddress = loginAddress;
        this.zip = zip;
        this.employees = employees;
        this.turnover = turnover;
        this.phone = phone;
        this.telephone = telephone;
        this.email = email;
        this.fax = fax;
        this.website = website;
        this.legalRepresentative = legalRepresentative;
        this.mainProprietor = mainProprietor;
        this.area = area;
        this.economicType = economicType;
        this.marketPassport = marketPassport;
        this.stockCode = stockCode;
        this.businessField = businessField;
        this.bank = bank;
        this.bankAccount = bankAccount;
        this.bankPermit = bankPermit;
        this.created = created;
        this.updated = updated;
        this.status = status;
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

    public String getCompanyZh() {
        return companyZh;
    }

    public void setCompanyZh(String companyZh) {
        this.companyZh = companyZh == null ? null : companyZh.trim();
    }

    public String getCompanyEn() {
        return companyEn;
    }

    public void setCompanyEn(String companyEn) {
        this.companyEn = companyEn == null ? null : companyEn.trim();
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo == null ? null : logo.trim();
    }

    public Date getFoundingTime() {
        return foundingTime;
    }

    public void setFoundingTime(Date foundingTime) {
        this.foundingTime = foundingTime;
    }

    public String getLoginAddress() {
        return loginAddress;
    }

    public void setLoginAddress(String loginAddress) {
        this.loginAddress = loginAddress == null ? null : loginAddress.trim();
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip == null ? null : zip.trim();
    }

    public Long getEmployees() {
        return employees;
    }

    public void setEmployees(Long employees) {
        this.employees = employees;
    }

    public Long getTurnover() {
        return turnover;
    }

    public void setTurnover(Long turnover) {
        this.turnover = turnover;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
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

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax == null ? null : fax.trim();
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website == null ? null : website.trim();
    }

    public String getLegalRepresentative() {
        return legalRepresentative;
    }

    public void setLegalRepresentative(String legalRepresentative) {
        this.legalRepresentative = legalRepresentative == null ? null : legalRepresentative.trim();
    }

    public String getMainProprietor() {
        return mainProprietor;
    }

    public void setMainProprietor(String mainProprietor) {
        this.mainProprietor = mainProprietor == null ? null : mainProprietor.trim();
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    public String getEconomicType() {
        return economicType;
    }

    public void setEconomicType(String economicType) {
        this.economicType = economicType == null ? null : economicType.trim();
    }

    public Byte getMarketPassport() {
        return marketPassport;
    }

    public void setMarketPassport(Byte marketPassport) {
        this.marketPassport = marketPassport;
    }

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode == null ? null : stockCode.trim();
    }

    public String getBusinessField() {
        return businessField;
    }

    public void setBusinessField(String businessField) {
        this.businessField = businessField == null ? null : businessField.trim();
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank == null ? null : bank.trim();
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount == null ? null : bankAccount.trim();
    }

    public String getBankPermit() {
        return bankPermit;
    }

    public void setBankPermit(String bankPermit) {
        this.bankPermit = bankPermit == null ? null : bankPermit.trim();
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}