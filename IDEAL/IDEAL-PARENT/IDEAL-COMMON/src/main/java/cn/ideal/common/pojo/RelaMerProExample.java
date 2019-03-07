package cn.ideal.common.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RelaMerProExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RelaMerProExample() {
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

        public Criteria andMerchantIdIsNull() {
            addCriterion("merchant_id is null");
            return (Criteria) this;
        }

        public Criteria andMerchantIdIsNotNull() {
            addCriterion("merchant_id is not null");
            return (Criteria) this;
        }

        public Criteria andMerchantIdEqualTo(Long value) {
            addCriterion("merchant_id =", value, "merchantId");
            return (Criteria) this;
        }

        public Criteria andMerchantIdNotEqualTo(Long value) {
            addCriterion("merchant_id <>", value, "merchantId");
            return (Criteria) this;
        }

        public Criteria andMerchantIdGreaterThan(Long value) {
            addCriterion("merchant_id >", value, "merchantId");
            return (Criteria) this;
        }

        public Criteria andMerchantIdGreaterThanOrEqualTo(Long value) {
            addCriterion("merchant_id >=", value, "merchantId");
            return (Criteria) this;
        }

        public Criteria andMerchantIdLessThan(Long value) {
            addCriterion("merchant_id <", value, "merchantId");
            return (Criteria) this;
        }

        public Criteria andMerchantIdLessThanOrEqualTo(Long value) {
            addCriterion("merchant_id <=", value, "merchantId");
            return (Criteria) this;
        }

        public Criteria andMerchantIdIn(List<Long> values) {
            addCriterion("merchant_id in", values, "merchantId");
            return (Criteria) this;
        }

        public Criteria andMerchantIdNotIn(List<Long> values) {
            addCriterion("merchant_id not in", values, "merchantId");
            return (Criteria) this;
        }

        public Criteria andMerchantIdBetween(Long value1, Long value2) {
            addCriterion("merchant_id between", value1, value2, "merchantId");
            return (Criteria) this;
        }

        public Criteria andMerchantIdNotBetween(Long value1, Long value2) {
            addCriterion("merchant_id not between", value1, value2, "merchantId");
            return (Criteria) this;
        }

        public Criteria andProductorIdIsNull() {
            addCriterion("productor_id is null");
            return (Criteria) this;
        }

        public Criteria andProductorIdIsNotNull() {
            addCriterion("productor_id is not null");
            return (Criteria) this;
        }

        public Criteria andProductorIdEqualTo(Long value) {
            addCriterion("productor_id =", value, "productorId");
            return (Criteria) this;
        }

        public Criteria andProductorIdNotEqualTo(Long value) {
            addCriterion("productor_id <>", value, "productorId");
            return (Criteria) this;
        }

        public Criteria andProductorIdGreaterThan(Long value) {
            addCriterion("productor_id >", value, "productorId");
            return (Criteria) this;
        }

        public Criteria andProductorIdGreaterThanOrEqualTo(Long value) {
            addCriterion("productor_id >=", value, "productorId");
            return (Criteria) this;
        }

        public Criteria andProductorIdLessThan(Long value) {
            addCriterion("productor_id <", value, "productorId");
            return (Criteria) this;
        }

        public Criteria andProductorIdLessThanOrEqualTo(Long value) {
            addCriterion("productor_id <=", value, "productorId");
            return (Criteria) this;
        }

        public Criteria andProductorIdIn(List<Long> values) {
            addCriterion("productor_id in", values, "productorId");
            return (Criteria) this;
        }

        public Criteria andProductorIdNotIn(List<Long> values) {
            addCriterion("productor_id not in", values, "productorId");
            return (Criteria) this;
        }

        public Criteria andProductorIdBetween(Long value1, Long value2) {
            addCriterion("productor_id between", value1, value2, "productorId");
            return (Criteria) this;
        }

        public Criteria andProductorIdNotBetween(Long value1, Long value2) {
            addCriterion("productor_id not between", value1, value2, "productorId");
            return (Criteria) this;
        }

        public Criteria andMerchantNameIsNull() {
            addCriterion("merchant_name is null");
            return (Criteria) this;
        }

        public Criteria andMerchantNameIsNotNull() {
            addCriterion("merchant_name is not null");
            return (Criteria) this;
        }

        public Criteria andMerchantNameEqualTo(String value) {
            addCriterion("merchant_name =", value, "merchantName");
            return (Criteria) this;
        }

        public Criteria andMerchantNameNotEqualTo(String value) {
            addCriterion("merchant_name <>", value, "merchantName");
            return (Criteria) this;
        }

        public Criteria andMerchantNameGreaterThan(String value) {
            addCriterion("merchant_name >", value, "merchantName");
            return (Criteria) this;
        }

        public Criteria andMerchantNameGreaterThanOrEqualTo(String value) {
            addCriterion("merchant_name >=", value, "merchantName");
            return (Criteria) this;
        }

        public Criteria andMerchantNameLessThan(String value) {
            addCriterion("merchant_name <", value, "merchantName");
            return (Criteria) this;
        }

        public Criteria andMerchantNameLessThanOrEqualTo(String value) {
            addCriterion("merchant_name <=", value, "merchantName");
            return (Criteria) this;
        }

        public Criteria andMerchantNameLike(String value) {
            addCriterion("merchant_name like", value, "merchantName");
            return (Criteria) this;
        }

        public Criteria andMerchantNameNotLike(String value) {
            addCriterion("merchant_name not like", value, "merchantName");
            return (Criteria) this;
        }

        public Criteria andMerchantNameIn(List<String> values) {
            addCriterion("merchant_name in", values, "merchantName");
            return (Criteria) this;
        }

        public Criteria andMerchantNameNotIn(List<String> values) {
            addCriterion("merchant_name not in", values, "merchantName");
            return (Criteria) this;
        }

        public Criteria andMerchantNameBetween(String value1, String value2) {
            addCriterion("merchant_name between", value1, value2, "merchantName");
            return (Criteria) this;
        }

        public Criteria andMerchantNameNotBetween(String value1, String value2) {
            addCriterion("merchant_name not between", value1, value2, "merchantName");
            return (Criteria) this;
        }

        public Criteria andProductorNameIsNull() {
            addCriterion("productor_name is null");
            return (Criteria) this;
        }

        public Criteria andProductorNameIsNotNull() {
            addCriterion("productor_name is not null");
            return (Criteria) this;
        }

        public Criteria andProductorNameEqualTo(String value) {
            addCriterion("productor_name =", value, "productorName");
            return (Criteria) this;
        }

        public Criteria andProductorNameNotEqualTo(String value) {
            addCriterion("productor_name <>", value, "productorName");
            return (Criteria) this;
        }

        public Criteria andProductorNameGreaterThan(String value) {
            addCriterion("productor_name >", value, "productorName");
            return (Criteria) this;
        }

        public Criteria andProductorNameGreaterThanOrEqualTo(String value) {
            addCriterion("productor_name >=", value, "productorName");
            return (Criteria) this;
        }

        public Criteria andProductorNameLessThan(String value) {
            addCriterion("productor_name <", value, "productorName");
            return (Criteria) this;
        }

        public Criteria andProductorNameLessThanOrEqualTo(String value) {
            addCriterion("productor_name <=", value, "productorName");
            return (Criteria) this;
        }

        public Criteria andProductorNameLike(String value) {
            addCriterion("productor_name like", value, "productorName");
            return (Criteria) this;
        }

        public Criteria andProductorNameNotLike(String value) {
            addCriterion("productor_name not like", value, "productorName");
            return (Criteria) this;
        }

        public Criteria andProductorNameIn(List<String> values) {
            addCriterion("productor_name in", values, "productorName");
            return (Criteria) this;
        }

        public Criteria andProductorNameNotIn(List<String> values) {
            addCriterion("productor_name not in", values, "productorName");
            return (Criteria) this;
        }

        public Criteria andProductorNameBetween(String value1, String value2) {
            addCriterion("productor_name between", value1, value2, "productorName");
            return (Criteria) this;
        }

        public Criteria andProductorNameNotBetween(String value1, String value2) {
            addCriterion("productor_name not between", value1, value2, "productorName");
            return (Criteria) this;
        }

        public Criteria andApplyTimeIsNull() {
            addCriterion("apply_time is null");
            return (Criteria) this;
        }

        public Criteria andApplyTimeIsNotNull() {
            addCriterion("apply_time is not null");
            return (Criteria) this;
        }

        public Criteria andApplyTimeEqualTo(Date value) {
            addCriterion("apply_time =", value, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeNotEqualTo(Date value) {
            addCriterion("apply_time <>", value, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeGreaterThan(Date value) {
            addCriterion("apply_time >", value, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("apply_time >=", value, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeLessThan(Date value) {
            addCriterion("apply_time <", value, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeLessThanOrEqualTo(Date value) {
            addCriterion("apply_time <=", value, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeIn(List<Date> values) {
            addCriterion("apply_time in", values, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeNotIn(List<Date> values) {
            addCriterion("apply_time not in", values, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeBetween(Date value1, Date value2) {
            addCriterion("apply_time between", value1, value2, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeNotBetween(Date value1, Date value2) {
            addCriterion("apply_time not between", value1, value2, "applyTime");
            return (Criteria) this;
        }

        public Criteria andAgreeTimeIsNull() {
            addCriterion("agree_time is null");
            return (Criteria) this;
        }

        public Criteria andAgreeTimeIsNotNull() {
            addCriterion("agree_time is not null");
            return (Criteria) this;
        }

        public Criteria andAgreeTimeEqualTo(Date value) {
            addCriterion("agree_time =", value, "agreeTime");
            return (Criteria) this;
        }

        public Criteria andAgreeTimeNotEqualTo(Date value) {
            addCriterion("agree_time <>", value, "agreeTime");
            return (Criteria) this;
        }

        public Criteria andAgreeTimeGreaterThan(Date value) {
            addCriterion("agree_time >", value, "agreeTime");
            return (Criteria) this;
        }

        public Criteria andAgreeTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("agree_time >=", value, "agreeTime");
            return (Criteria) this;
        }

        public Criteria andAgreeTimeLessThan(Date value) {
            addCriterion("agree_time <", value, "agreeTime");
            return (Criteria) this;
        }

        public Criteria andAgreeTimeLessThanOrEqualTo(Date value) {
            addCriterion("agree_time <=", value, "agreeTime");
            return (Criteria) this;
        }

        public Criteria andAgreeTimeIn(List<Date> values) {
            addCriterion("agree_time in", values, "agreeTime");
            return (Criteria) this;
        }

        public Criteria andAgreeTimeNotIn(List<Date> values) {
            addCriterion("agree_time not in", values, "agreeTime");
            return (Criteria) this;
        }

        public Criteria andAgreeTimeBetween(Date value1, Date value2) {
            addCriterion("agree_time between", value1, value2, "agreeTime");
            return (Criteria) this;
        }

        public Criteria andAgreeTimeNotBetween(Date value1, Date value2) {
            addCriterion("agree_time not between", value1, value2, "agreeTime");
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

        public Criteria andStatusEqualTo(Byte value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Byte value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Byte value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Byte value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Byte value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Byte> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Byte> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Byte value1, Byte value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Byte value1, Byte value2) {
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