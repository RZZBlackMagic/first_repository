package cn.ideal.common.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AccountProductorExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AccountProductorExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNull() {
            addCriterion("username is null");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNotNull() {
            addCriterion("username is not null");
            return (Criteria) this;
        }

        public Criteria andUsernameEqualTo(String value) {
            addCriterion("username =", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("username <>", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("username >", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("username >=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("username <", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("username <=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLike(String value) {
            addCriterion("username like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("username not like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameIn(List<String> values) {
            addCriterion("username in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotIn(List<String> values) {
            addCriterion("username not in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("username between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("username not between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("password is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("password is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("password =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("password <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("password >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("password >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("password <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("password <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("password like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("password not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("password in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("password not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("password between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("password not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andCompanyZhIsNull() {
            addCriterion("company_zh is null");
            return (Criteria) this;
        }

        public Criteria andCompanyZhIsNotNull() {
            addCriterion("company_zh is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyZhEqualTo(String value) {
            addCriterion("company_zh =", value, "companyZh");
            return (Criteria) this;
        }

        public Criteria andCompanyZhNotEqualTo(String value) {
            addCriterion("company_zh <>", value, "companyZh");
            return (Criteria) this;
        }

        public Criteria andCompanyZhGreaterThan(String value) {
            addCriterion("company_zh >", value, "companyZh");
            return (Criteria) this;
        }

        public Criteria andCompanyZhGreaterThanOrEqualTo(String value) {
            addCriterion("company_zh >=", value, "companyZh");
            return (Criteria) this;
        }

        public Criteria andCompanyZhLessThan(String value) {
            addCriterion("company_zh <", value, "companyZh");
            return (Criteria) this;
        }

        public Criteria andCompanyZhLessThanOrEqualTo(String value) {
            addCriterion("company_zh <=", value, "companyZh");
            return (Criteria) this;
        }

        public Criteria andCompanyZhLike(String value) {
            addCriterion("company_zh like", value, "companyZh");
            return (Criteria) this;
        }

        public Criteria andCompanyZhNotLike(String value) {
            addCriterion("company_zh not like", value, "companyZh");
            return (Criteria) this;
        }

        public Criteria andCompanyZhIn(List<String> values) {
            addCriterion("company_zh in", values, "companyZh");
            return (Criteria) this;
        }

        public Criteria andCompanyZhNotIn(List<String> values) {
            addCriterion("company_zh not in", values, "companyZh");
            return (Criteria) this;
        }

        public Criteria andCompanyZhBetween(String value1, String value2) {
            addCriterion("company_zh between", value1, value2, "companyZh");
            return (Criteria) this;
        }

        public Criteria andCompanyZhNotBetween(String value1, String value2) {
            addCriterion("company_zh not between", value1, value2, "companyZh");
            return (Criteria) this;
        }

        public Criteria andCompanyEnIsNull() {
            addCriterion("company_en is null");
            return (Criteria) this;
        }

        public Criteria andCompanyEnIsNotNull() {
            addCriterion("company_en is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyEnEqualTo(String value) {
            addCriterion("company_en =", value, "companyEn");
            return (Criteria) this;
        }

        public Criteria andCompanyEnNotEqualTo(String value) {
            addCriterion("company_en <>", value, "companyEn");
            return (Criteria) this;
        }

        public Criteria andCompanyEnGreaterThan(String value) {
            addCriterion("company_en >", value, "companyEn");
            return (Criteria) this;
        }

        public Criteria andCompanyEnGreaterThanOrEqualTo(String value) {
            addCriterion("company_en >=", value, "companyEn");
            return (Criteria) this;
        }

        public Criteria andCompanyEnLessThan(String value) {
            addCriterion("company_en <", value, "companyEn");
            return (Criteria) this;
        }

        public Criteria andCompanyEnLessThanOrEqualTo(String value) {
            addCriterion("company_en <=", value, "companyEn");
            return (Criteria) this;
        }

        public Criteria andCompanyEnLike(String value) {
            addCriterion("company_en like", value, "companyEn");
            return (Criteria) this;
        }

        public Criteria andCompanyEnNotLike(String value) {
            addCriterion("company_en not like", value, "companyEn");
            return (Criteria) this;
        }

        public Criteria andCompanyEnIn(List<String> values) {
            addCriterion("company_en in", values, "companyEn");
            return (Criteria) this;
        }

        public Criteria andCompanyEnNotIn(List<String> values) {
            addCriterion("company_en not in", values, "companyEn");
            return (Criteria) this;
        }

        public Criteria andCompanyEnBetween(String value1, String value2) {
            addCriterion("company_en between", value1, value2, "companyEn");
            return (Criteria) this;
        }

        public Criteria andCompanyEnNotBetween(String value1, String value2) {
            addCriterion("company_en not between", value1, value2, "companyEn");
            return (Criteria) this;
        }

        public Criteria andLogoIsNull() {
            addCriterion("logo is null");
            return (Criteria) this;
        }

        public Criteria andLogoIsNotNull() {
            addCriterion("logo is not null");
            return (Criteria) this;
        }

        public Criteria andLogoEqualTo(String value) {
            addCriterion("logo =", value, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoNotEqualTo(String value) {
            addCriterion("logo <>", value, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoGreaterThan(String value) {
            addCriterion("logo >", value, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoGreaterThanOrEqualTo(String value) {
            addCriterion("logo >=", value, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoLessThan(String value) {
            addCriterion("logo <", value, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoLessThanOrEqualTo(String value) {
            addCriterion("logo <=", value, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoLike(String value) {
            addCriterion("logo like", value, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoNotLike(String value) {
            addCriterion("logo not like", value, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoIn(List<String> values) {
            addCriterion("logo in", values, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoNotIn(List<String> values) {
            addCriterion("logo not in", values, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoBetween(String value1, String value2) {
            addCriterion("logo between", value1, value2, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoNotBetween(String value1, String value2) {
            addCriterion("logo not between", value1, value2, "logo");
            return (Criteria) this;
        }

        public Criteria andFoundingTimeIsNull() {
            addCriterion("founding_time is null");
            return (Criteria) this;
        }

        public Criteria andFoundingTimeIsNotNull() {
            addCriterion("founding_time is not null");
            return (Criteria) this;
        }

        public Criteria andFoundingTimeEqualTo(Date value) {
            addCriterion("founding_time =", value, "foundingTime");
            return (Criteria) this;
        }

        public Criteria andFoundingTimeNotEqualTo(Date value) {
            addCriterion("founding_time <>", value, "foundingTime");
            return (Criteria) this;
        }

        public Criteria andFoundingTimeGreaterThan(Date value) {
            addCriterion("founding_time >", value, "foundingTime");
            return (Criteria) this;
        }

        public Criteria andFoundingTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("founding_time >=", value, "foundingTime");
            return (Criteria) this;
        }

        public Criteria andFoundingTimeLessThan(Date value) {
            addCriterion("founding_time <", value, "foundingTime");
            return (Criteria) this;
        }

        public Criteria andFoundingTimeLessThanOrEqualTo(Date value) {
            addCriterion("founding_time <=", value, "foundingTime");
            return (Criteria) this;
        }

        public Criteria andFoundingTimeIn(List<Date> values) {
            addCriterion("founding_time in", values, "foundingTime");
            return (Criteria) this;
        }

        public Criteria andFoundingTimeNotIn(List<Date> values) {
            addCriterion("founding_time not in", values, "foundingTime");
            return (Criteria) this;
        }

        public Criteria andFoundingTimeBetween(Date value1, Date value2) {
            addCriterion("founding_time between", value1, value2, "foundingTime");
            return (Criteria) this;
        }

        public Criteria andFoundingTimeNotBetween(Date value1, Date value2) {
            addCriterion("founding_time not between", value1, value2, "foundingTime");
            return (Criteria) this;
        }

        public Criteria andLoginAddressIsNull() {
            addCriterion("login_address is null");
            return (Criteria) this;
        }

        public Criteria andLoginAddressIsNotNull() {
            addCriterion("login_address is not null");
            return (Criteria) this;
        }

        public Criteria andLoginAddressEqualTo(String value) {
            addCriterion("login_address =", value, "loginAddress");
            return (Criteria) this;
        }

        public Criteria andLoginAddressNotEqualTo(String value) {
            addCriterion("login_address <>", value, "loginAddress");
            return (Criteria) this;
        }

        public Criteria andLoginAddressGreaterThan(String value) {
            addCriterion("login_address >", value, "loginAddress");
            return (Criteria) this;
        }

        public Criteria andLoginAddressGreaterThanOrEqualTo(String value) {
            addCriterion("login_address >=", value, "loginAddress");
            return (Criteria) this;
        }

        public Criteria andLoginAddressLessThan(String value) {
            addCriterion("login_address <", value, "loginAddress");
            return (Criteria) this;
        }

        public Criteria andLoginAddressLessThanOrEqualTo(String value) {
            addCriterion("login_address <=", value, "loginAddress");
            return (Criteria) this;
        }

        public Criteria andLoginAddressLike(String value) {
            addCriterion("login_address like", value, "loginAddress");
            return (Criteria) this;
        }

        public Criteria andLoginAddressNotLike(String value) {
            addCriterion("login_address not like", value, "loginAddress");
            return (Criteria) this;
        }

        public Criteria andLoginAddressIn(List<String> values) {
            addCriterion("login_address in", values, "loginAddress");
            return (Criteria) this;
        }

        public Criteria andLoginAddressNotIn(List<String> values) {
            addCriterion("login_address not in", values, "loginAddress");
            return (Criteria) this;
        }

        public Criteria andLoginAddressBetween(String value1, String value2) {
            addCriterion("login_address between", value1, value2, "loginAddress");
            return (Criteria) this;
        }

        public Criteria andLoginAddressNotBetween(String value1, String value2) {
            addCriterion("login_address not between", value1, value2, "loginAddress");
            return (Criteria) this;
        }

        public Criteria andZipIsNull() {
            addCriterion("zip is null");
            return (Criteria) this;
        }

        public Criteria andZipIsNotNull() {
            addCriterion("zip is not null");
            return (Criteria) this;
        }

        public Criteria andZipEqualTo(String value) {
            addCriterion("zip =", value, "zip");
            return (Criteria) this;
        }

        public Criteria andZipNotEqualTo(String value) {
            addCriterion("zip <>", value, "zip");
            return (Criteria) this;
        }

        public Criteria andZipGreaterThan(String value) {
            addCriterion("zip >", value, "zip");
            return (Criteria) this;
        }

        public Criteria andZipGreaterThanOrEqualTo(String value) {
            addCriterion("zip >=", value, "zip");
            return (Criteria) this;
        }

        public Criteria andZipLessThan(String value) {
            addCriterion("zip <", value, "zip");
            return (Criteria) this;
        }

        public Criteria andZipLessThanOrEqualTo(String value) {
            addCriterion("zip <=", value, "zip");
            return (Criteria) this;
        }

        public Criteria andZipLike(String value) {
            addCriterion("zip like", value, "zip");
            return (Criteria) this;
        }

        public Criteria andZipNotLike(String value) {
            addCriterion("zip not like", value, "zip");
            return (Criteria) this;
        }

        public Criteria andZipIn(List<String> values) {
            addCriterion("zip in", values, "zip");
            return (Criteria) this;
        }

        public Criteria andZipNotIn(List<String> values) {
            addCriterion("zip not in", values, "zip");
            return (Criteria) this;
        }

        public Criteria andZipBetween(String value1, String value2) {
            addCriterion("zip between", value1, value2, "zip");
            return (Criteria) this;
        }

        public Criteria andZipNotBetween(String value1, String value2) {
            addCriterion("zip not between", value1, value2, "zip");
            return (Criteria) this;
        }

        public Criteria andEmployeesIsNull() {
            addCriterion("employees is null");
            return (Criteria) this;
        }

        public Criteria andEmployeesIsNotNull() {
            addCriterion("employees is not null");
            return (Criteria) this;
        }

        public Criteria andEmployeesEqualTo(Long value) {
            addCriterion("employees =", value, "employees");
            return (Criteria) this;
        }

        public Criteria andEmployeesNotEqualTo(Long value) {
            addCriterion("employees <>", value, "employees");
            return (Criteria) this;
        }

        public Criteria andEmployeesGreaterThan(Long value) {
            addCriterion("employees >", value, "employees");
            return (Criteria) this;
        }

        public Criteria andEmployeesGreaterThanOrEqualTo(Long value) {
            addCriterion("employees >=", value, "employees");
            return (Criteria) this;
        }

        public Criteria andEmployeesLessThan(Long value) {
            addCriterion("employees <", value, "employees");
            return (Criteria) this;
        }

        public Criteria andEmployeesLessThanOrEqualTo(Long value) {
            addCriterion("employees <=", value, "employees");
            return (Criteria) this;
        }

        public Criteria andEmployeesIn(List<Long> values) {
            addCriterion("employees in", values, "employees");
            return (Criteria) this;
        }

        public Criteria andEmployeesNotIn(List<Long> values) {
            addCriterion("employees not in", values, "employees");
            return (Criteria) this;
        }

        public Criteria andEmployeesBetween(Long value1, Long value2) {
            addCriterion("employees between", value1, value2, "employees");
            return (Criteria) this;
        }

        public Criteria andEmployeesNotBetween(Long value1, Long value2) {
            addCriterion("employees not between", value1, value2, "employees");
            return (Criteria) this;
        }

        public Criteria andTurnoverIsNull() {
            addCriterion("turnover is null");
            return (Criteria) this;
        }

        public Criteria andTurnoverIsNotNull() {
            addCriterion("turnover is not null");
            return (Criteria) this;
        }

        public Criteria andTurnoverEqualTo(Long value) {
            addCriterion("turnover =", value, "turnover");
            return (Criteria) this;
        }

        public Criteria andTurnoverNotEqualTo(Long value) {
            addCriterion("turnover <>", value, "turnover");
            return (Criteria) this;
        }

        public Criteria andTurnoverGreaterThan(Long value) {
            addCriterion("turnover >", value, "turnover");
            return (Criteria) this;
        }

        public Criteria andTurnoverGreaterThanOrEqualTo(Long value) {
            addCriterion("turnover >=", value, "turnover");
            return (Criteria) this;
        }

        public Criteria andTurnoverLessThan(Long value) {
            addCriterion("turnover <", value, "turnover");
            return (Criteria) this;
        }

        public Criteria andTurnoverLessThanOrEqualTo(Long value) {
            addCriterion("turnover <=", value, "turnover");
            return (Criteria) this;
        }

        public Criteria andTurnoverIn(List<Long> values) {
            addCriterion("turnover in", values, "turnover");
            return (Criteria) this;
        }

        public Criteria andTurnoverNotIn(List<Long> values) {
            addCriterion("turnover not in", values, "turnover");
            return (Criteria) this;
        }

        public Criteria andTurnoverBetween(Long value1, Long value2) {
            addCriterion("turnover between", value1, value2, "turnover");
            return (Criteria) this;
        }

        public Criteria andTurnoverNotBetween(Long value1, Long value2) {
            addCriterion("turnover not between", value1, value2, "turnover");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNull() {
            addCriterion("phone is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("phone is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("phone =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("phone <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("phone >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("phone >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("phone <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("phone <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("phone like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("phone not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("phone in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("phone not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("phone between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("phone not between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andTelephoneIsNull() {
            addCriterion("telephone is null");
            return (Criteria) this;
        }

        public Criteria andTelephoneIsNotNull() {
            addCriterion("telephone is not null");
            return (Criteria) this;
        }

        public Criteria andTelephoneEqualTo(String value) {
            addCriterion("telephone =", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotEqualTo(String value) {
            addCriterion("telephone <>", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneGreaterThan(String value) {
            addCriterion("telephone >", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneGreaterThanOrEqualTo(String value) {
            addCriterion("telephone >=", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneLessThan(String value) {
            addCriterion("telephone <", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneLessThanOrEqualTo(String value) {
            addCriterion("telephone <=", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneLike(String value) {
            addCriterion("telephone like", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotLike(String value) {
            addCriterion("telephone not like", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneIn(List<String> values) {
            addCriterion("telephone in", values, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotIn(List<String> values) {
            addCriterion("telephone not in", values, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneBetween(String value1, String value2) {
            addCriterion("telephone between", value1, value2, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotBetween(String value1, String value2) {
            addCriterion("telephone not between", value1, value2, "telephone");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("email is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("email is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("email =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("email <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("email >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("email >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("email <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("email <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("email like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("email not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("email in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("email not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("email between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("email not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andFaxIsNull() {
            addCriterion("fax is null");
            return (Criteria) this;
        }

        public Criteria andFaxIsNotNull() {
            addCriterion("fax is not null");
            return (Criteria) this;
        }

        public Criteria andFaxEqualTo(String value) {
            addCriterion("fax =", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxNotEqualTo(String value) {
            addCriterion("fax <>", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxGreaterThan(String value) {
            addCriterion("fax >", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxGreaterThanOrEqualTo(String value) {
            addCriterion("fax >=", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxLessThan(String value) {
            addCriterion("fax <", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxLessThanOrEqualTo(String value) {
            addCriterion("fax <=", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxLike(String value) {
            addCriterion("fax like", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxNotLike(String value) {
            addCriterion("fax not like", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxIn(List<String> values) {
            addCriterion("fax in", values, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxNotIn(List<String> values) {
            addCriterion("fax not in", values, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxBetween(String value1, String value2) {
            addCriterion("fax between", value1, value2, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxNotBetween(String value1, String value2) {
            addCriterion("fax not between", value1, value2, "fax");
            return (Criteria) this;
        }

        public Criteria andWebsiteIsNull() {
            addCriterion("website is null");
            return (Criteria) this;
        }

        public Criteria andWebsiteIsNotNull() {
            addCriterion("website is not null");
            return (Criteria) this;
        }

        public Criteria andWebsiteEqualTo(String value) {
            addCriterion("website =", value, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteNotEqualTo(String value) {
            addCriterion("website <>", value, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteGreaterThan(String value) {
            addCriterion("website >", value, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteGreaterThanOrEqualTo(String value) {
            addCriterion("website >=", value, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteLessThan(String value) {
            addCriterion("website <", value, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteLessThanOrEqualTo(String value) {
            addCriterion("website <=", value, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteLike(String value) {
            addCriterion("website like", value, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteNotLike(String value) {
            addCriterion("website not like", value, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteIn(List<String> values) {
            addCriterion("website in", values, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteNotIn(List<String> values) {
            addCriterion("website not in", values, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteBetween(String value1, String value2) {
            addCriterion("website between", value1, value2, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteNotBetween(String value1, String value2) {
            addCriterion("website not between", value1, value2, "website");
            return (Criteria) this;
        }

        public Criteria andLegalRepresentativeIsNull() {
            addCriterion("legal_representative is null");
            return (Criteria) this;
        }

        public Criteria andLegalRepresentativeIsNotNull() {
            addCriterion("legal_representative is not null");
            return (Criteria) this;
        }

        public Criteria andLegalRepresentativeEqualTo(String value) {
            addCriterion("legal_representative =", value, "legalRepresentative");
            return (Criteria) this;
        }

        public Criteria andLegalRepresentativeNotEqualTo(String value) {
            addCriterion("legal_representative <>", value, "legalRepresentative");
            return (Criteria) this;
        }

        public Criteria andLegalRepresentativeGreaterThan(String value) {
            addCriterion("legal_representative >", value, "legalRepresentative");
            return (Criteria) this;
        }

        public Criteria andLegalRepresentativeGreaterThanOrEqualTo(String value) {
            addCriterion("legal_representative >=", value, "legalRepresentative");
            return (Criteria) this;
        }

        public Criteria andLegalRepresentativeLessThan(String value) {
            addCriterion("legal_representative <", value, "legalRepresentative");
            return (Criteria) this;
        }

        public Criteria andLegalRepresentativeLessThanOrEqualTo(String value) {
            addCriterion("legal_representative <=", value, "legalRepresentative");
            return (Criteria) this;
        }

        public Criteria andLegalRepresentativeLike(String value) {
            addCriterion("legal_representative like", value, "legalRepresentative");
            return (Criteria) this;
        }

        public Criteria andLegalRepresentativeNotLike(String value) {
            addCriterion("legal_representative not like", value, "legalRepresentative");
            return (Criteria) this;
        }

        public Criteria andLegalRepresentativeIn(List<String> values) {
            addCriterion("legal_representative in", values, "legalRepresentative");
            return (Criteria) this;
        }

        public Criteria andLegalRepresentativeNotIn(List<String> values) {
            addCriterion("legal_representative not in", values, "legalRepresentative");
            return (Criteria) this;
        }

        public Criteria andLegalRepresentativeBetween(String value1, String value2) {
            addCriterion("legal_representative between", value1, value2, "legalRepresentative");
            return (Criteria) this;
        }

        public Criteria andLegalRepresentativeNotBetween(String value1, String value2) {
            addCriterion("legal_representative not between", value1, value2, "legalRepresentative");
            return (Criteria) this;
        }

        public Criteria andMainProprietorIsNull() {
            addCriterion("main_proprietor is null");
            return (Criteria) this;
        }

        public Criteria andMainProprietorIsNotNull() {
            addCriterion("main_proprietor is not null");
            return (Criteria) this;
        }

        public Criteria andMainProprietorEqualTo(String value) {
            addCriterion("main_proprietor =", value, "mainProprietor");
            return (Criteria) this;
        }

        public Criteria andMainProprietorNotEqualTo(String value) {
            addCriterion("main_proprietor <>", value, "mainProprietor");
            return (Criteria) this;
        }

        public Criteria andMainProprietorGreaterThan(String value) {
            addCriterion("main_proprietor >", value, "mainProprietor");
            return (Criteria) this;
        }

        public Criteria andMainProprietorGreaterThanOrEqualTo(String value) {
            addCriterion("main_proprietor >=", value, "mainProprietor");
            return (Criteria) this;
        }

        public Criteria andMainProprietorLessThan(String value) {
            addCriterion("main_proprietor <", value, "mainProprietor");
            return (Criteria) this;
        }

        public Criteria andMainProprietorLessThanOrEqualTo(String value) {
            addCriterion("main_proprietor <=", value, "mainProprietor");
            return (Criteria) this;
        }

        public Criteria andMainProprietorLike(String value) {
            addCriterion("main_proprietor like", value, "mainProprietor");
            return (Criteria) this;
        }

        public Criteria andMainProprietorNotLike(String value) {
            addCriterion("main_proprietor not like", value, "mainProprietor");
            return (Criteria) this;
        }

        public Criteria andMainProprietorIn(List<String> values) {
            addCriterion("main_proprietor in", values, "mainProprietor");
            return (Criteria) this;
        }

        public Criteria andMainProprietorNotIn(List<String> values) {
            addCriterion("main_proprietor not in", values, "mainProprietor");
            return (Criteria) this;
        }

        public Criteria andMainProprietorBetween(String value1, String value2) {
            addCriterion("main_proprietor between", value1, value2, "mainProprietor");
            return (Criteria) this;
        }

        public Criteria andMainProprietorNotBetween(String value1, String value2) {
            addCriterion("main_proprietor not between", value1, value2, "mainProprietor");
            return (Criteria) this;
        }

        public Criteria andAreaIsNull() {
            addCriterion("area is null");
            return (Criteria) this;
        }

        public Criteria andAreaIsNotNull() {
            addCriterion("area is not null");
            return (Criteria) this;
        }

        public Criteria andAreaEqualTo(String value) {
            addCriterion("area =", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotEqualTo(String value) {
            addCriterion("area <>", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaGreaterThan(String value) {
            addCriterion("area >", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaGreaterThanOrEqualTo(String value) {
            addCriterion("area >=", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLessThan(String value) {
            addCriterion("area <", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLessThanOrEqualTo(String value) {
            addCriterion("area <=", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLike(String value) {
            addCriterion("area like", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotLike(String value) {
            addCriterion("area not like", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaIn(List<String> values) {
            addCriterion("area in", values, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotIn(List<String> values) {
            addCriterion("area not in", values, "area");
            return (Criteria) this;
        }

        public Criteria andAreaBetween(String value1, String value2) {
            addCriterion("area between", value1, value2, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotBetween(String value1, String value2) {
            addCriterion("area not between", value1, value2, "area");
            return (Criteria) this;
        }

        public Criteria andEconomicTypeIsNull() {
            addCriterion("economic_type is null");
            return (Criteria) this;
        }

        public Criteria andEconomicTypeIsNotNull() {
            addCriterion("economic_type is not null");
            return (Criteria) this;
        }

        public Criteria andEconomicTypeEqualTo(String value) {
            addCriterion("economic_type =", value, "economicType");
            return (Criteria) this;
        }

        public Criteria andEconomicTypeNotEqualTo(String value) {
            addCriterion("economic_type <>", value, "economicType");
            return (Criteria) this;
        }

        public Criteria andEconomicTypeGreaterThan(String value) {
            addCriterion("economic_type >", value, "economicType");
            return (Criteria) this;
        }

        public Criteria andEconomicTypeGreaterThanOrEqualTo(String value) {
            addCriterion("economic_type >=", value, "economicType");
            return (Criteria) this;
        }

        public Criteria andEconomicTypeLessThan(String value) {
            addCriterion("economic_type <", value, "economicType");
            return (Criteria) this;
        }

        public Criteria andEconomicTypeLessThanOrEqualTo(String value) {
            addCriterion("economic_type <=", value, "economicType");
            return (Criteria) this;
        }

        public Criteria andEconomicTypeLike(String value) {
            addCriterion("economic_type like", value, "economicType");
            return (Criteria) this;
        }

        public Criteria andEconomicTypeNotLike(String value) {
            addCriterion("economic_type not like", value, "economicType");
            return (Criteria) this;
        }

        public Criteria andEconomicTypeIn(List<String> values) {
            addCriterion("economic_type in", values, "economicType");
            return (Criteria) this;
        }

        public Criteria andEconomicTypeNotIn(List<String> values) {
            addCriterion("economic_type not in", values, "economicType");
            return (Criteria) this;
        }

        public Criteria andEconomicTypeBetween(String value1, String value2) {
            addCriterion("economic_type between", value1, value2, "economicType");
            return (Criteria) this;
        }

        public Criteria andEconomicTypeNotBetween(String value1, String value2) {
            addCriterion("economic_type not between", value1, value2, "economicType");
            return (Criteria) this;
        }

        public Criteria andMarketPassportIsNull() {
            addCriterion("market_passport is null");
            return (Criteria) this;
        }

        public Criteria andMarketPassportIsNotNull() {
            addCriterion("market_passport is not null");
            return (Criteria) this;
        }

        public Criteria andMarketPassportEqualTo(Byte value) {
            addCriterion("market_passport =", value, "marketPassport");
            return (Criteria) this;
        }

        public Criteria andMarketPassportNotEqualTo(Byte value) {
            addCriterion("market_passport <>", value, "marketPassport");
            return (Criteria) this;
        }

        public Criteria andMarketPassportGreaterThan(Byte value) {
            addCriterion("market_passport >", value, "marketPassport");
            return (Criteria) this;
        }

        public Criteria andMarketPassportGreaterThanOrEqualTo(Byte value) {
            addCriterion("market_passport >=", value, "marketPassport");
            return (Criteria) this;
        }

        public Criteria andMarketPassportLessThan(Byte value) {
            addCriterion("market_passport <", value, "marketPassport");
            return (Criteria) this;
        }

        public Criteria andMarketPassportLessThanOrEqualTo(Byte value) {
            addCriterion("market_passport <=", value, "marketPassport");
            return (Criteria) this;
        }

        public Criteria andMarketPassportIn(List<Byte> values) {
            addCriterion("market_passport in", values, "marketPassport");
            return (Criteria) this;
        }

        public Criteria andMarketPassportNotIn(List<Byte> values) {
            addCriterion("market_passport not in", values, "marketPassport");
            return (Criteria) this;
        }

        public Criteria andMarketPassportBetween(Byte value1, Byte value2) {
            addCriterion("market_passport between", value1, value2, "marketPassport");
            return (Criteria) this;
        }

        public Criteria andMarketPassportNotBetween(Byte value1, Byte value2) {
            addCriterion("market_passport not between", value1, value2, "marketPassport");
            return (Criteria) this;
        }

        public Criteria andStockCodeIsNull() {
            addCriterion("stock_code is null");
            return (Criteria) this;
        }

        public Criteria andStockCodeIsNotNull() {
            addCriterion("stock_code is not null");
            return (Criteria) this;
        }

        public Criteria andStockCodeEqualTo(String value) {
            addCriterion("stock_code =", value, "stockCode");
            return (Criteria) this;
        }

        public Criteria andStockCodeNotEqualTo(String value) {
            addCriterion("stock_code <>", value, "stockCode");
            return (Criteria) this;
        }

        public Criteria andStockCodeGreaterThan(String value) {
            addCriterion("stock_code >", value, "stockCode");
            return (Criteria) this;
        }

        public Criteria andStockCodeGreaterThanOrEqualTo(String value) {
            addCriterion("stock_code >=", value, "stockCode");
            return (Criteria) this;
        }

        public Criteria andStockCodeLessThan(String value) {
            addCriterion("stock_code <", value, "stockCode");
            return (Criteria) this;
        }

        public Criteria andStockCodeLessThanOrEqualTo(String value) {
            addCriterion("stock_code <=", value, "stockCode");
            return (Criteria) this;
        }

        public Criteria andStockCodeLike(String value) {
            addCriterion("stock_code like", value, "stockCode");
            return (Criteria) this;
        }

        public Criteria andStockCodeNotLike(String value) {
            addCriterion("stock_code not like", value, "stockCode");
            return (Criteria) this;
        }

        public Criteria andStockCodeIn(List<String> values) {
            addCriterion("stock_code in", values, "stockCode");
            return (Criteria) this;
        }

        public Criteria andStockCodeNotIn(List<String> values) {
            addCriterion("stock_code not in", values, "stockCode");
            return (Criteria) this;
        }

        public Criteria andStockCodeBetween(String value1, String value2) {
            addCriterion("stock_code between", value1, value2, "stockCode");
            return (Criteria) this;
        }

        public Criteria andStockCodeNotBetween(String value1, String value2) {
            addCriterion("stock_code not between", value1, value2, "stockCode");
            return (Criteria) this;
        }

        public Criteria andBusinessFieldIsNull() {
            addCriterion("business_field is null");
            return (Criteria) this;
        }

        public Criteria andBusinessFieldIsNotNull() {
            addCriterion("business_field is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessFieldEqualTo(String value) {
            addCriterion("business_field =", value, "businessField");
            return (Criteria) this;
        }

        public Criteria andBusinessFieldNotEqualTo(String value) {
            addCriterion("business_field <>", value, "businessField");
            return (Criteria) this;
        }

        public Criteria andBusinessFieldGreaterThan(String value) {
            addCriterion("business_field >", value, "businessField");
            return (Criteria) this;
        }

        public Criteria andBusinessFieldGreaterThanOrEqualTo(String value) {
            addCriterion("business_field >=", value, "businessField");
            return (Criteria) this;
        }

        public Criteria andBusinessFieldLessThan(String value) {
            addCriterion("business_field <", value, "businessField");
            return (Criteria) this;
        }

        public Criteria andBusinessFieldLessThanOrEqualTo(String value) {
            addCriterion("business_field <=", value, "businessField");
            return (Criteria) this;
        }

        public Criteria andBusinessFieldLike(String value) {
            addCriterion("business_field like", value, "businessField");
            return (Criteria) this;
        }

        public Criteria andBusinessFieldNotLike(String value) {
            addCriterion("business_field not like", value, "businessField");
            return (Criteria) this;
        }

        public Criteria andBusinessFieldIn(List<String> values) {
            addCriterion("business_field in", values, "businessField");
            return (Criteria) this;
        }

        public Criteria andBusinessFieldNotIn(List<String> values) {
            addCriterion("business_field not in", values, "businessField");
            return (Criteria) this;
        }

        public Criteria andBusinessFieldBetween(String value1, String value2) {
            addCriterion("business_field between", value1, value2, "businessField");
            return (Criteria) this;
        }

        public Criteria andBusinessFieldNotBetween(String value1, String value2) {
            addCriterion("business_field not between", value1, value2, "businessField");
            return (Criteria) this;
        }

        public Criteria andBankIsNull() {
            addCriterion("bank is null");
            return (Criteria) this;
        }

        public Criteria andBankIsNotNull() {
            addCriterion("bank is not null");
            return (Criteria) this;
        }

        public Criteria andBankEqualTo(String value) {
            addCriterion("bank =", value, "bank");
            return (Criteria) this;
        }

        public Criteria andBankNotEqualTo(String value) {
            addCriterion("bank <>", value, "bank");
            return (Criteria) this;
        }

        public Criteria andBankGreaterThan(String value) {
            addCriterion("bank >", value, "bank");
            return (Criteria) this;
        }

        public Criteria andBankGreaterThanOrEqualTo(String value) {
            addCriterion("bank >=", value, "bank");
            return (Criteria) this;
        }

        public Criteria andBankLessThan(String value) {
            addCriterion("bank <", value, "bank");
            return (Criteria) this;
        }

        public Criteria andBankLessThanOrEqualTo(String value) {
            addCriterion("bank <=", value, "bank");
            return (Criteria) this;
        }

        public Criteria andBankLike(String value) {
            addCriterion("bank like", value, "bank");
            return (Criteria) this;
        }

        public Criteria andBankNotLike(String value) {
            addCriterion("bank not like", value, "bank");
            return (Criteria) this;
        }

        public Criteria andBankIn(List<String> values) {
            addCriterion("bank in", values, "bank");
            return (Criteria) this;
        }

        public Criteria andBankNotIn(List<String> values) {
            addCriterion("bank not in", values, "bank");
            return (Criteria) this;
        }

        public Criteria andBankBetween(String value1, String value2) {
            addCriterion("bank between", value1, value2, "bank");
            return (Criteria) this;
        }

        public Criteria andBankNotBetween(String value1, String value2) {
            addCriterion("bank not between", value1, value2, "bank");
            return (Criteria) this;
        }

        public Criteria andBankAccountIsNull() {
            addCriterion("bank_account is null");
            return (Criteria) this;
        }

        public Criteria andBankAccountIsNotNull() {
            addCriterion("bank_account is not null");
            return (Criteria) this;
        }

        public Criteria andBankAccountEqualTo(String value) {
            addCriterion("bank_account =", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountNotEqualTo(String value) {
            addCriterion("bank_account <>", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountGreaterThan(String value) {
            addCriterion("bank_account >", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountGreaterThanOrEqualTo(String value) {
            addCriterion("bank_account >=", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountLessThan(String value) {
            addCriterion("bank_account <", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountLessThanOrEqualTo(String value) {
            addCriterion("bank_account <=", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountLike(String value) {
            addCriterion("bank_account like", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountNotLike(String value) {
            addCriterion("bank_account not like", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountIn(List<String> values) {
            addCriterion("bank_account in", values, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountNotIn(List<String> values) {
            addCriterion("bank_account not in", values, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountBetween(String value1, String value2) {
            addCriterion("bank_account between", value1, value2, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountNotBetween(String value1, String value2) {
            addCriterion("bank_account not between", value1, value2, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankPermitIsNull() {
            addCriterion("bank_permit is null");
            return (Criteria) this;
        }

        public Criteria andBankPermitIsNotNull() {
            addCriterion("bank_permit is not null");
            return (Criteria) this;
        }

        public Criteria andBankPermitEqualTo(String value) {
            addCriterion("bank_permit =", value, "bankPermit");
            return (Criteria) this;
        }

        public Criteria andBankPermitNotEqualTo(String value) {
            addCriterion("bank_permit <>", value, "bankPermit");
            return (Criteria) this;
        }

        public Criteria andBankPermitGreaterThan(String value) {
            addCriterion("bank_permit >", value, "bankPermit");
            return (Criteria) this;
        }

        public Criteria andBankPermitGreaterThanOrEqualTo(String value) {
            addCriterion("bank_permit >=", value, "bankPermit");
            return (Criteria) this;
        }

        public Criteria andBankPermitLessThan(String value) {
            addCriterion("bank_permit <", value, "bankPermit");
            return (Criteria) this;
        }

        public Criteria andBankPermitLessThanOrEqualTo(String value) {
            addCriterion("bank_permit <=", value, "bankPermit");
            return (Criteria) this;
        }

        public Criteria andBankPermitLike(String value) {
            addCriterion("bank_permit like", value, "bankPermit");
            return (Criteria) this;
        }

        public Criteria andBankPermitNotLike(String value) {
            addCriterion("bank_permit not like", value, "bankPermit");
            return (Criteria) this;
        }

        public Criteria andBankPermitIn(List<String> values) {
            addCriterion("bank_permit in", values, "bankPermit");
            return (Criteria) this;
        }

        public Criteria andBankPermitNotIn(List<String> values) {
            addCriterion("bank_permit not in", values, "bankPermit");
            return (Criteria) this;
        }

        public Criteria andBankPermitBetween(String value1, String value2) {
            addCriterion("bank_permit between", value1, value2, "bankPermit");
            return (Criteria) this;
        }

        public Criteria andBankPermitNotBetween(String value1, String value2) {
            addCriterion("bank_permit not between", value1, value2, "bankPermit");
            return (Criteria) this;
        }

        public Criteria andCreatedIsNull() {
            addCriterion("created is null");
            return (Criteria) this;
        }

        public Criteria andCreatedIsNotNull() {
            addCriterion("created is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedEqualTo(Date value) {
            addCriterion("created =", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotEqualTo(Date value) {
            addCriterion("created <>", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedGreaterThan(Date value) {
            addCriterion("created >", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedGreaterThanOrEqualTo(Date value) {
            addCriterion("created >=", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedLessThan(Date value) {
            addCriterion("created <", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedLessThanOrEqualTo(Date value) {
            addCriterion("created <=", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedIn(List<Date> values) {
            addCriterion("created in", values, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotIn(List<Date> values) {
            addCriterion("created not in", values, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedBetween(Date value1, Date value2) {
            addCriterion("created between", value1, value2, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotBetween(Date value1, Date value2) {
            addCriterion("created not between", value1, value2, "created");
            return (Criteria) this;
        }

        public Criteria andUpdatedIsNull() {
            addCriterion("updated is null");
            return (Criteria) this;
        }

        public Criteria andUpdatedIsNotNull() {
            addCriterion("updated is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatedEqualTo(Date value) {
            addCriterion("updated =", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedNotEqualTo(Date value) {
            addCriterion("updated <>", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedGreaterThan(Date value) {
            addCriterion("updated >", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedGreaterThanOrEqualTo(Date value) {
            addCriterion("updated >=", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedLessThan(Date value) {
            addCriterion("updated <", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedLessThanOrEqualTo(Date value) {
            addCriterion("updated <=", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedIn(List<Date> values) {
            addCriterion("updated in", values, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedNotIn(List<Date> values) {
            addCriterion("updated not in", values, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedBetween(Date value1, Date value2) {
            addCriterion("updated between", value1, value2, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedNotBetween(Date value1, Date value2) {
            addCriterion("updated not between", value1, value2, "updated");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}