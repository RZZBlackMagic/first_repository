package cn.ideal.common.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AccountMerchantExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AccountMerchantExample() {
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

        public Criteria andLocationIsNull() {
            addCriterion("location is null");
            return (Criteria) this;
        }

        public Criteria andLocationIsNotNull() {
            addCriterion("location is not null");
            return (Criteria) this;
        }

        public Criteria andLocationEqualTo(String value) {
            addCriterion("location =", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotEqualTo(String value) {
            addCriterion("location <>", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationGreaterThan(String value) {
            addCriterion("location >", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationGreaterThanOrEqualTo(String value) {
            addCriterion("location >=", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationLessThan(String value) {
            addCriterion("location <", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationLessThanOrEqualTo(String value) {
            addCriterion("location <=", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationLike(String value) {
            addCriterion("location like", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotLike(String value) {
            addCriterion("location not like", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationIn(List<String> values) {
            addCriterion("location in", values, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotIn(List<String> values) {
            addCriterion("location not in", values, "location");
            return (Criteria) this;
        }

        public Criteria andLocationBetween(String value1, String value2) {
            addCriterion("location between", value1, value2, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotBetween(String value1, String value2) {
            addCriterion("location not between", value1, value2, "location");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
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

        public Criteria andJobIsNull() {
            addCriterion("job is null");
            return (Criteria) this;
        }

        public Criteria andJobIsNotNull() {
            addCriterion("job is not null");
            return (Criteria) this;
        }

        public Criteria andJobEqualTo(String value) {
            addCriterion("job =", value, "job");
            return (Criteria) this;
        }

        public Criteria andJobNotEqualTo(String value) {
            addCriterion("job <>", value, "job");
            return (Criteria) this;
        }

        public Criteria andJobGreaterThan(String value) {
            addCriterion("job >", value, "job");
            return (Criteria) this;
        }

        public Criteria andJobGreaterThanOrEqualTo(String value) {
            addCriterion("job >=", value, "job");
            return (Criteria) this;
        }

        public Criteria andJobLessThan(String value) {
            addCriterion("job <", value, "job");
            return (Criteria) this;
        }

        public Criteria andJobLessThanOrEqualTo(String value) {
            addCriterion("job <=", value, "job");
            return (Criteria) this;
        }

        public Criteria andJobLike(String value) {
            addCriterion("job like", value, "job");
            return (Criteria) this;
        }

        public Criteria andJobNotLike(String value) {
            addCriterion("job not like", value, "job");
            return (Criteria) this;
        }

        public Criteria andJobIn(List<String> values) {
            addCriterion("job in", values, "job");
            return (Criteria) this;
        }

        public Criteria andJobNotIn(List<String> values) {
            addCriterion("job not in", values, "job");
            return (Criteria) this;
        }

        public Criteria andJobBetween(String value1, String value2) {
            addCriterion("job between", value1, value2, "job");
            return (Criteria) this;
        }

        public Criteria andJobNotBetween(String value1, String value2) {
            addCriterion("job not between", value1, value2, "job");
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

        public Criteria andCiIsNull() {
            addCriterion("ci is null");
            return (Criteria) this;
        }

        public Criteria andCiIsNotNull() {
            addCriterion("ci is not null");
            return (Criteria) this;
        }

        public Criteria andCiEqualTo(String value) {
            addCriterion("ci =", value, "ci");
            return (Criteria) this;
        }

        public Criteria andCiNotEqualTo(String value) {
            addCriterion("ci <>", value, "ci");
            return (Criteria) this;
        }

        public Criteria andCiGreaterThan(String value) {
            addCriterion("ci >", value, "ci");
            return (Criteria) this;
        }

        public Criteria andCiGreaterThanOrEqualTo(String value) {
            addCriterion("ci >=", value, "ci");
            return (Criteria) this;
        }

        public Criteria andCiLessThan(String value) {
            addCriterion("ci <", value, "ci");
            return (Criteria) this;
        }

        public Criteria andCiLessThanOrEqualTo(String value) {
            addCriterion("ci <=", value, "ci");
            return (Criteria) this;
        }

        public Criteria andCiLike(String value) {
            addCriterion("ci like", value, "ci");
            return (Criteria) this;
        }

        public Criteria andCiNotLike(String value) {
            addCriterion("ci not like", value, "ci");
            return (Criteria) this;
        }

        public Criteria andCiIn(List<String> values) {
            addCriterion("ci in", values, "ci");
            return (Criteria) this;
        }

        public Criteria andCiNotIn(List<String> values) {
            addCriterion("ci not in", values, "ci");
            return (Criteria) this;
        }

        public Criteria andCiBetween(String value1, String value2) {
            addCriterion("ci between", value1, value2, "ci");
            return (Criteria) this;
        }

        public Criteria andCiNotBetween(String value1, String value2) {
            addCriterion("ci not between", value1, value2, "ci");
            return (Criteria) this;
        }

        public Criteria andEinIsNull() {
            addCriterion("ein is null");
            return (Criteria) this;
        }

        public Criteria andEinIsNotNull() {
            addCriterion("ein is not null");
            return (Criteria) this;
        }

        public Criteria andEinEqualTo(String value) {
            addCriterion("ein =", value, "ein");
            return (Criteria) this;
        }

        public Criteria andEinNotEqualTo(String value) {
            addCriterion("ein <>", value, "ein");
            return (Criteria) this;
        }

        public Criteria andEinGreaterThan(String value) {
            addCriterion("ein >", value, "ein");
            return (Criteria) this;
        }

        public Criteria andEinGreaterThanOrEqualTo(String value) {
            addCriterion("ein >=", value, "ein");
            return (Criteria) this;
        }

        public Criteria andEinLessThan(String value) {
            addCriterion("ein <", value, "ein");
            return (Criteria) this;
        }

        public Criteria andEinLessThanOrEqualTo(String value) {
            addCriterion("ein <=", value, "ein");
            return (Criteria) this;
        }

        public Criteria andEinLike(String value) {
            addCriterion("ein like", value, "ein");
            return (Criteria) this;
        }

        public Criteria andEinNotLike(String value) {
            addCriterion("ein not like", value, "ein");
            return (Criteria) this;
        }

        public Criteria andEinIn(List<String> values) {
            addCriterion("ein in", values, "ein");
            return (Criteria) this;
        }

        public Criteria andEinNotIn(List<String> values) {
            addCriterion("ein not in", values, "ein");
            return (Criteria) this;
        }

        public Criteria andEinBetween(String value1, String value2) {
            addCriterion("ein between", value1, value2, "ein");
            return (Criteria) this;
        }

        public Criteria andEinNotBetween(String value1, String value2) {
            addCriterion("ein not between", value1, value2, "ein");
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

        public Criteria andLegalCodeIsNull() {
            addCriterion("legal_code is null");
            return (Criteria) this;
        }

        public Criteria andLegalCodeIsNotNull() {
            addCriterion("legal_code is not null");
            return (Criteria) this;
        }

        public Criteria andLegalCodeEqualTo(String value) {
            addCriterion("legal_code =", value, "legalCode");
            return (Criteria) this;
        }

        public Criteria andLegalCodeNotEqualTo(String value) {
            addCriterion("legal_code <>", value, "legalCode");
            return (Criteria) this;
        }

        public Criteria andLegalCodeGreaterThan(String value) {
            addCriterion("legal_code >", value, "legalCode");
            return (Criteria) this;
        }

        public Criteria andLegalCodeGreaterThanOrEqualTo(String value) {
            addCriterion("legal_code >=", value, "legalCode");
            return (Criteria) this;
        }

        public Criteria andLegalCodeLessThan(String value) {
            addCriterion("legal_code <", value, "legalCode");
            return (Criteria) this;
        }

        public Criteria andLegalCodeLessThanOrEqualTo(String value) {
            addCriterion("legal_code <=", value, "legalCode");
            return (Criteria) this;
        }

        public Criteria andLegalCodeLike(String value) {
            addCriterion("legal_code like", value, "legalCode");
            return (Criteria) this;
        }

        public Criteria andLegalCodeNotLike(String value) {
            addCriterion("legal_code not like", value, "legalCode");
            return (Criteria) this;
        }

        public Criteria andLegalCodeIn(List<String> values) {
            addCriterion("legal_code in", values, "legalCode");
            return (Criteria) this;
        }

        public Criteria andLegalCodeNotIn(List<String> values) {
            addCriterion("legal_code not in", values, "legalCode");
            return (Criteria) this;
        }

        public Criteria andLegalCodeBetween(String value1, String value2) {
            addCriterion("legal_code between", value1, value2, "legalCode");
            return (Criteria) this;
        }

        public Criteria andLegalCodeNotBetween(String value1, String value2) {
            addCriterion("legal_code not between", value1, value2, "legalCode");
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

        public Criteria andLeaderCodeIsNull() {
            addCriterion("leader_code is null");
            return (Criteria) this;
        }

        public Criteria andLeaderCodeIsNotNull() {
            addCriterion("leader_code is not null");
            return (Criteria) this;
        }

        public Criteria andLeaderCodeEqualTo(String value) {
            addCriterion("leader_code =", value, "leaderCode");
            return (Criteria) this;
        }

        public Criteria andLeaderCodeNotEqualTo(String value) {
            addCriterion("leader_code <>", value, "leaderCode");
            return (Criteria) this;
        }

        public Criteria andLeaderCodeGreaterThan(String value) {
            addCriterion("leader_code >", value, "leaderCode");
            return (Criteria) this;
        }

        public Criteria andLeaderCodeGreaterThanOrEqualTo(String value) {
            addCriterion("leader_code >=", value, "leaderCode");
            return (Criteria) this;
        }

        public Criteria andLeaderCodeLessThan(String value) {
            addCriterion("leader_code <", value, "leaderCode");
            return (Criteria) this;
        }

        public Criteria andLeaderCodeLessThanOrEqualTo(String value) {
            addCriterion("leader_code <=", value, "leaderCode");
            return (Criteria) this;
        }

        public Criteria andLeaderCodeLike(String value) {
            addCriterion("leader_code like", value, "leaderCode");
            return (Criteria) this;
        }

        public Criteria andLeaderCodeNotLike(String value) {
            addCriterion("leader_code not like", value, "leaderCode");
            return (Criteria) this;
        }

        public Criteria andLeaderCodeIn(List<String> values) {
            addCriterion("leader_code in", values, "leaderCode");
            return (Criteria) this;
        }

        public Criteria andLeaderCodeNotIn(List<String> values) {
            addCriterion("leader_code not in", values, "leaderCode");
            return (Criteria) this;
        }

        public Criteria andLeaderCodeBetween(String value1, String value2) {
            addCriterion("leader_code between", value1, value2, "leaderCode");
            return (Criteria) this;
        }

        public Criteria andLeaderCodeNotBetween(String value1, String value2) {
            addCriterion("leader_code not between", value1, value2, "leaderCode");
            return (Criteria) this;
        }

        public Criteria andRegistedFundIsNull() {
            addCriterion("registed_fund is null");
            return (Criteria) this;
        }

        public Criteria andRegistedFundIsNotNull() {
            addCriterion("registed_fund is not null");
            return (Criteria) this;
        }

        public Criteria andRegistedFundEqualTo(Long value) {
            addCriterion("registed_fund =", value, "registedFund");
            return (Criteria) this;
        }

        public Criteria andRegistedFundNotEqualTo(Long value) {
            addCriterion("registed_fund <>", value, "registedFund");
            return (Criteria) this;
        }

        public Criteria andRegistedFundGreaterThan(Long value) {
            addCriterion("registed_fund >", value, "registedFund");
            return (Criteria) this;
        }

        public Criteria andRegistedFundGreaterThanOrEqualTo(Long value) {
            addCriterion("registed_fund >=", value, "registedFund");
            return (Criteria) this;
        }

        public Criteria andRegistedFundLessThan(Long value) {
            addCriterion("registed_fund <", value, "registedFund");
            return (Criteria) this;
        }

        public Criteria andRegistedFundLessThanOrEqualTo(Long value) {
            addCriterion("registed_fund <=", value, "registedFund");
            return (Criteria) this;
        }

        public Criteria andRegistedFundIn(List<Long> values) {
            addCriterion("registed_fund in", values, "registedFund");
            return (Criteria) this;
        }

        public Criteria andRegistedFundNotIn(List<Long> values) {
            addCriterion("registed_fund not in", values, "registedFund");
            return (Criteria) this;
        }

        public Criteria andRegistedFundBetween(Long value1, Long value2) {
            addCriterion("registed_fund between", value1, value2, "registedFund");
            return (Criteria) this;
        }

        public Criteria andRegistedFundNotBetween(Long value1, Long value2) {
            addCriterion("registed_fund not between", value1, value2, "registedFund");
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

        public Criteria andEmployeeIsNull() {
            addCriterion("employee is null");
            return (Criteria) this;
        }

        public Criteria andEmployeeIsNotNull() {
            addCriterion("employee is not null");
            return (Criteria) this;
        }

        public Criteria andEmployeeEqualTo(Long value) {
            addCriterion("employee =", value, "employee");
            return (Criteria) this;
        }

        public Criteria andEmployeeNotEqualTo(Long value) {
            addCriterion("employee <>", value, "employee");
            return (Criteria) this;
        }

        public Criteria andEmployeeGreaterThan(Long value) {
            addCriterion("employee >", value, "employee");
            return (Criteria) this;
        }

        public Criteria andEmployeeGreaterThanOrEqualTo(Long value) {
            addCriterion("employee >=", value, "employee");
            return (Criteria) this;
        }

        public Criteria andEmployeeLessThan(Long value) {
            addCriterion("employee <", value, "employee");
            return (Criteria) this;
        }

        public Criteria andEmployeeLessThanOrEqualTo(Long value) {
            addCriterion("employee <=", value, "employee");
            return (Criteria) this;
        }

        public Criteria andEmployeeIn(List<Long> values) {
            addCriterion("employee in", values, "employee");
            return (Criteria) this;
        }

        public Criteria andEmployeeNotIn(List<Long> values) {
            addCriterion("employee not in", values, "employee");
            return (Criteria) this;
        }

        public Criteria andEmployeeBetween(Long value1, Long value2) {
            addCriterion("employee between", value1, value2, "employee");
            return (Criteria) this;
        }

        public Criteria andEmployeeNotBetween(Long value1, Long value2) {
            addCriterion("employee not between", value1, value2, "employee");
            return (Criteria) this;
        }

        public Criteria andPowerIsNull() {
            addCriterion("power is null");
            return (Criteria) this;
        }

        public Criteria andPowerIsNotNull() {
            addCriterion("power is not null");
            return (Criteria) this;
        }

        public Criteria andPowerEqualTo(String value) {
            addCriterion("power =", value, "power");
            return (Criteria) this;
        }

        public Criteria andPowerNotEqualTo(String value) {
            addCriterion("power <>", value, "power");
            return (Criteria) this;
        }

        public Criteria andPowerGreaterThan(String value) {
            addCriterion("power >", value, "power");
            return (Criteria) this;
        }

        public Criteria andPowerGreaterThanOrEqualTo(String value) {
            addCriterion("power >=", value, "power");
            return (Criteria) this;
        }

        public Criteria andPowerLessThan(String value) {
            addCriterion("power <", value, "power");
            return (Criteria) this;
        }

        public Criteria andPowerLessThanOrEqualTo(String value) {
            addCriterion("power <=", value, "power");
            return (Criteria) this;
        }

        public Criteria andPowerLike(String value) {
            addCriterion("power like", value, "power");
            return (Criteria) this;
        }

        public Criteria andPowerNotLike(String value) {
            addCriterion("power not like", value, "power");
            return (Criteria) this;
        }

        public Criteria andPowerIn(List<String> values) {
            addCriterion("power in", values, "power");
            return (Criteria) this;
        }

        public Criteria andPowerNotIn(List<String> values) {
            addCriterion("power not in", values, "power");
            return (Criteria) this;
        }

        public Criteria andPowerBetween(String value1, String value2) {
            addCriterion("power between", value1, value2, "power");
            return (Criteria) this;
        }

        public Criteria andPowerNotBetween(String value1, String value2) {
            addCriterion("power not between", value1, value2, "power");
            return (Criteria) this;
        }

        public Criteria andEmployeeAnalysisIsNull() {
            addCriterion("employee_analysis is null");
            return (Criteria) this;
        }

        public Criteria andEmployeeAnalysisIsNotNull() {
            addCriterion("employee_analysis is not null");
            return (Criteria) this;
        }

        public Criteria andEmployeeAnalysisEqualTo(String value) {
            addCriterion("employee_analysis =", value, "employeeAnalysis");
            return (Criteria) this;
        }

        public Criteria andEmployeeAnalysisNotEqualTo(String value) {
            addCriterion("employee_analysis <>", value, "employeeAnalysis");
            return (Criteria) this;
        }

        public Criteria andEmployeeAnalysisGreaterThan(String value) {
            addCriterion("employee_analysis >", value, "employeeAnalysis");
            return (Criteria) this;
        }

        public Criteria andEmployeeAnalysisGreaterThanOrEqualTo(String value) {
            addCriterion("employee_analysis >=", value, "employeeAnalysis");
            return (Criteria) this;
        }

        public Criteria andEmployeeAnalysisLessThan(String value) {
            addCriterion("employee_analysis <", value, "employeeAnalysis");
            return (Criteria) this;
        }

        public Criteria andEmployeeAnalysisLessThanOrEqualTo(String value) {
            addCriterion("employee_analysis <=", value, "employeeAnalysis");
            return (Criteria) this;
        }

        public Criteria andEmployeeAnalysisLike(String value) {
            addCriterion("employee_analysis like", value, "employeeAnalysis");
            return (Criteria) this;
        }

        public Criteria andEmployeeAnalysisNotLike(String value) {
            addCriterion("employee_analysis not like", value, "employeeAnalysis");
            return (Criteria) this;
        }

        public Criteria andEmployeeAnalysisIn(List<String> values) {
            addCriterion("employee_analysis in", values, "employeeAnalysis");
            return (Criteria) this;
        }

        public Criteria andEmployeeAnalysisNotIn(List<String> values) {
            addCriterion("employee_analysis not in", values, "employeeAnalysis");
            return (Criteria) this;
        }

        public Criteria andEmployeeAnalysisBetween(String value1, String value2) {
            addCriterion("employee_analysis between", value1, value2, "employeeAnalysis");
            return (Criteria) this;
        }

        public Criteria andEmployeeAnalysisNotBetween(String value1, String value2) {
            addCriterion("employee_analysis not between", value1, value2, "employeeAnalysis");
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

        public Criteria andIsFixedSourceIsNull() {
            addCriterion("is_fixed_source is null");
            return (Criteria) this;
        }

        public Criteria andIsFixedSourceIsNotNull() {
            addCriterion("is_fixed_source is not null");
            return (Criteria) this;
        }

        public Criteria andIsFixedSourceEqualTo(Byte value) {
            addCriterion("is_fixed_source =", value, "isFixedSource");
            return (Criteria) this;
        }

        public Criteria andIsFixedSourceNotEqualTo(Byte value) {
            addCriterion("is_fixed_source <>", value, "isFixedSource");
            return (Criteria) this;
        }

        public Criteria andIsFixedSourceGreaterThan(Byte value) {
            addCriterion("is_fixed_source >", value, "isFixedSource");
            return (Criteria) this;
        }

        public Criteria andIsFixedSourceGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_fixed_source >=", value, "isFixedSource");
            return (Criteria) this;
        }

        public Criteria andIsFixedSourceLessThan(Byte value) {
            addCriterion("is_fixed_source <", value, "isFixedSource");
            return (Criteria) this;
        }

        public Criteria andIsFixedSourceLessThanOrEqualTo(Byte value) {
            addCriterion("is_fixed_source <=", value, "isFixedSource");
            return (Criteria) this;
        }

        public Criteria andIsFixedSourceIn(List<Byte> values) {
            addCriterion("is_fixed_source in", values, "isFixedSource");
            return (Criteria) this;
        }

        public Criteria andIsFixedSourceNotIn(List<Byte> values) {
            addCriterion("is_fixed_source not in", values, "isFixedSource");
            return (Criteria) this;
        }

        public Criteria andIsFixedSourceBetween(Byte value1, Byte value2) {
            addCriterion("is_fixed_source between", value1, value2, "isFixedSource");
            return (Criteria) this;
        }

        public Criteria andIsFixedSourceNotBetween(Byte value1, Byte value2) {
            addCriterion("is_fixed_source not between", value1, value2, "isFixedSource");
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