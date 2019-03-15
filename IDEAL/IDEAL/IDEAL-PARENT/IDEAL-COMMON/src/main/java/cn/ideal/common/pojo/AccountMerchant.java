package cn.ideal.common.pojo;

import java.io.Serializable;
import java.util.Date;

public class AccountMerchant implements Serializable {
    private Long id;

    private String username;

    private String password;

    private String phone;

    private String email;

    private String companyZh;

    private String companyEn;

    private String location;

    private String address;

    private String zip;

    private String job;

    private String telephone;

    private String fax;

    private String ci;

    private String ein;

    private String legalRepresentative;

    private String legalCode;

    private String mainProprietor;

    private String leaderCode;

    private Long registedFund;

    private String bank;

    private String bankAccount;

    private String bankPermit;

    private Long employee;

    private String power;

    private String employeeAnalysis;

    private String businessField;

    private Byte isFixedSource;

    private Date created;

    private Date updated;

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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
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

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job == null ? null : job.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax == null ? null : fax.trim();
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci == null ? null : ci.trim();
    }

    public String getEin() {
        return ein;
    }

    public void setEin(String ein) {
        this.ein = ein == null ? null : ein.trim();
    }

    public String getLegalRepresentative() {
        return legalRepresentative;
    }

    public void setLegalRepresentative(String legalRepresentative) {
        this.legalRepresentative = legalRepresentative == null ? null : legalRepresentative.trim();
    }

    public String getLegalCode() {
        return legalCode;
    }

    public void setLegalCode(String legalCode) {
        this.legalCode = legalCode == null ? null : legalCode.trim();
    }

    public String getMainProprietor() {
        return mainProprietor;
    }

    public void setMainProprietor(String mainProprietor) {
        this.mainProprietor = mainProprietor == null ? null : mainProprietor.trim();
    }

    public String getLeaderCode() {
        return leaderCode;
    }

    public void setLeaderCode(String leaderCode) {
        this.leaderCode = leaderCode == null ? null : leaderCode.trim();
    }

    public Long getRegistedFund() {
        return registedFund;
    }

    public void setRegistedFund(Long registedFund) {
        this.registedFund = registedFund;
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

    public Long getEmployee() {
        return employee;
    }

    public void setEmployee(Long employee) {
        this.employee = employee;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power == null ? null : power.trim();
    }

    public String getEmployeeAnalysis() {
        return employeeAnalysis;
    }

    public void setEmployeeAnalysis(String employeeAnalysis) {
        this.employeeAnalysis = employeeAnalysis == null ? null : employeeAnalysis.trim();
    }

    public String getBusinessField() {
        return businessField;
    }

    public void setBusinessField(String businessField) {
        this.businessField = businessField == null ? null : businessField.trim();
    }

    public Byte getIsFixedSource() {
        return isFixedSource;
    }

    public void setIsFixedSource(Byte isFixedSource) {
        this.isFixedSource = isFixedSource;
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