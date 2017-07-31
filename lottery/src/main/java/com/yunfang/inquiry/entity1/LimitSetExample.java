package com.yunfang.inquiry.entity1;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class LimitSetExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LimitSetExample() {
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
            addCriterion("Id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("Id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("Id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("Id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("Id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("Id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("Id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("Id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("Id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("Id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("Id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("Id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("Id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("Id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUseridIsNull() {
            addCriterion("UserId is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("UserId is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(String value) {
            addCriterion("UserId =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(String value) {
            addCriterion("UserId <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(String value) {
            addCriterion("UserId >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(String value) {
            addCriterion("UserId >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(String value) {
            addCriterion("UserId <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(String value) {
            addCriterion("UserId <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLike(String value) {
            addCriterion("UserId like", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotLike(String value) {
            addCriterion("UserId not like", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<String> values) {
            addCriterion("UserId in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<String> values) {
            addCriterion("UserId not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(String value1, String value2) {
            addCriterion("UserId between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(String value1, String value2) {
            addCriterion("UserId not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andLimittypeIsNull() {
            addCriterion("LimitType is null");
            return (Criteria) this;
        }

        public Criteria andLimittypeIsNotNull() {
            addCriterion("LimitType is not null");
            return (Criteria) this;
        }

        public Criteria andLimittypeEqualTo(String value) {
            addCriterion("LimitType =", value, "limittype");
            return (Criteria) this;
        }

        public Criteria andLimittypeNotEqualTo(String value) {
            addCriterion("LimitType <>", value, "limittype");
            return (Criteria) this;
        }

        public Criteria andLimittypeGreaterThan(String value) {
            addCriterion("LimitType >", value, "limittype");
            return (Criteria) this;
        }

        public Criteria andLimittypeGreaterThanOrEqualTo(String value) {
            addCriterion("LimitType >=", value, "limittype");
            return (Criteria) this;
        }

        public Criteria andLimittypeLessThan(String value) {
            addCriterion("LimitType <", value, "limittype");
            return (Criteria) this;
        }

        public Criteria andLimittypeLessThanOrEqualTo(String value) {
            addCriterion("LimitType <=", value, "limittype");
            return (Criteria) this;
        }

        public Criteria andLimittypeLike(String value) {
            addCriterion("LimitType like", value, "limittype");
            return (Criteria) this;
        }

        public Criteria andLimittypeNotLike(String value) {
            addCriterion("LimitType not like", value, "limittype");
            return (Criteria) this;
        }

        public Criteria andLimittypeIn(List<String> values) {
            addCriterion("LimitType in", values, "limittype");
            return (Criteria) this;
        }

        public Criteria andLimittypeNotIn(List<String> values) {
            addCriterion("LimitType not in", values, "limittype");
            return (Criteria) this;
        }

        public Criteria andLimittypeBetween(String value1, String value2) {
            addCriterion("LimitType between", value1, value2, "limittype");
            return (Criteria) this;
        }

        public Criteria andLimittypeNotBetween(String value1, String value2) {
            addCriterion("LimitType not between", value1, value2, "limittype");
            return (Criteria) this;
        }

        public Criteria andSingleminIsNull() {
            addCriterion("SingleMin is null");
            return (Criteria) this;
        }

        public Criteria andSingleminIsNotNull() {
            addCriterion("SingleMin is not null");
            return (Criteria) this;
        }

        public Criteria andSingleminEqualTo(Integer value) {
            addCriterion("SingleMin =", value, "singlemin");
            return (Criteria) this;
        }

        public Criteria andSingleminNotEqualTo(Integer value) {
            addCriterion("SingleMin <>", value, "singlemin");
            return (Criteria) this;
        }

        public Criteria andSingleminGreaterThan(Integer value) {
            addCriterion("SingleMin >", value, "singlemin");
            return (Criteria) this;
        }

        public Criteria andSingleminGreaterThanOrEqualTo(Integer value) {
            addCriterion("SingleMin >=", value, "singlemin");
            return (Criteria) this;
        }

        public Criteria andSingleminLessThan(Integer value) {
            addCriterion("SingleMin <", value, "singlemin");
            return (Criteria) this;
        }

        public Criteria andSingleminLessThanOrEqualTo(Integer value) {
            addCriterion("SingleMin <=", value, "singlemin");
            return (Criteria) this;
        }

        public Criteria andSingleminIn(List<Integer> values) {
            addCriterion("SingleMin in", values, "singlemin");
            return (Criteria) this;
        }

        public Criteria andSingleminNotIn(List<Integer> values) {
            addCriterion("SingleMin not in", values, "singlemin");
            return (Criteria) this;
        }

        public Criteria andSingleminBetween(Integer value1, Integer value2) {
            addCriterion("SingleMin between", value1, value2, "singlemin");
            return (Criteria) this;
        }

        public Criteria andSingleminNotBetween(Integer value1, Integer value2) {
            addCriterion("SingleMin not between", value1, value2, "singlemin");
            return (Criteria) this;
        }

        public Criteria andSinglemaxIsNull() {
            addCriterion("SingleMax is null");
            return (Criteria) this;
        }

        public Criteria andSinglemaxIsNotNull() {
            addCriterion("SingleMax is not null");
            return (Criteria) this;
        }

        public Criteria andSinglemaxEqualTo(Integer value) {
            addCriterion("SingleMax =", value, "singlemax");
            return (Criteria) this;
        }

        public Criteria andSinglemaxNotEqualTo(Integer value) {
            addCriterion("SingleMax <>", value, "singlemax");
            return (Criteria) this;
        }

        public Criteria andSinglemaxGreaterThan(Integer value) {
            addCriterion("SingleMax >", value, "singlemax");
            return (Criteria) this;
        }

        public Criteria andSinglemaxGreaterThanOrEqualTo(Integer value) {
            addCriterion("SingleMax >=", value, "singlemax");
            return (Criteria) this;
        }

        public Criteria andSinglemaxLessThan(Integer value) {
            addCriterion("SingleMax <", value, "singlemax");
            return (Criteria) this;
        }

        public Criteria andSinglemaxLessThanOrEqualTo(Integer value) {
            addCriterion("SingleMax <=", value, "singlemax");
            return (Criteria) this;
        }

        public Criteria andSinglemaxIn(List<Integer> values) {
            addCriterion("SingleMax in", values, "singlemax");
            return (Criteria) this;
        }

        public Criteria andSinglemaxNotIn(List<Integer> values) {
            addCriterion("SingleMax not in", values, "singlemax");
            return (Criteria) this;
        }

        public Criteria andSinglemaxBetween(Integer value1, Integer value2) {
            addCriterion("SingleMax between", value1, value2, "singlemax");
            return (Criteria) this;
        }

        public Criteria andSinglemaxNotBetween(Integer value1, Integer value2) {
            addCriterion("SingleMax not between", value1, value2, "singlemax");
            return (Criteria) this;
        }

        public Criteria andSinglehighestIsNull() {
            addCriterion("SingleHighest is null");
            return (Criteria) this;
        }

        public Criteria andSinglehighestIsNotNull() {
            addCriterion("SingleHighest is not null");
            return (Criteria) this;
        }

        public Criteria andSinglehighestEqualTo(Integer value) {
            addCriterion("SingleHighest =", value, "singlehighest");
            return (Criteria) this;
        }

        public Criteria andSinglehighestNotEqualTo(Integer value) {
            addCriterion("SingleHighest <>", value, "singlehighest");
            return (Criteria) this;
        }

        public Criteria andSinglehighestGreaterThan(Integer value) {
            addCriterion("SingleHighest >", value, "singlehighest");
            return (Criteria) this;
        }

        public Criteria andSinglehighestGreaterThanOrEqualTo(Integer value) {
            addCriterion("SingleHighest >=", value, "singlehighest");
            return (Criteria) this;
        }

        public Criteria andSinglehighestLessThan(Integer value) {
            addCriterion("SingleHighest <", value, "singlehighest");
            return (Criteria) this;
        }

        public Criteria andSinglehighestLessThanOrEqualTo(Integer value) {
            addCriterion("SingleHighest <=", value, "singlehighest");
            return (Criteria) this;
        }

        public Criteria andSinglehighestIn(List<Integer> values) {
            addCriterion("SingleHighest in", values, "singlehighest");
            return (Criteria) this;
        }

        public Criteria andSinglehighestNotIn(List<Integer> values) {
            addCriterion("SingleHighest not in", values, "singlehighest");
            return (Criteria) this;
        }

        public Criteria andSinglehighestBetween(Integer value1, Integer value2) {
            addCriterion("SingleHighest between", value1, value2, "singlehighest");
            return (Criteria) this;
        }

        public Criteria andSinglehighestNotBetween(Integer value1, Integer value2) {
            addCriterion("SingleHighest not between", value1, value2, "singlehighest");
            return (Criteria) this;
        }

        public Criteria andARetreatIsNull() {
            addCriterion("A_Retreat is null");
            return (Criteria) this;
        }

        public Criteria andARetreatIsNotNull() {
            addCriterion("A_Retreat is not null");
            return (Criteria) this;
        }

        public Criteria andARetreatEqualTo(BigDecimal value) {
            addCriterion("A_Retreat =", value, "aRetreat");
            return (Criteria) this;
        }

        public Criteria andARetreatNotEqualTo(BigDecimal value) {
            addCriterion("A_Retreat <>", value, "aRetreat");
            return (Criteria) this;
        }

        public Criteria andARetreatGreaterThan(BigDecimal value) {
            addCriterion("A_Retreat >", value, "aRetreat");
            return (Criteria) this;
        }

        public Criteria andARetreatGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("A_Retreat >=", value, "aRetreat");
            return (Criteria) this;
        }

        public Criteria andARetreatLessThan(BigDecimal value) {
            addCriterion("A_Retreat <", value, "aRetreat");
            return (Criteria) this;
        }

        public Criteria andARetreatLessThanOrEqualTo(BigDecimal value) {
            addCriterion("A_Retreat <=", value, "aRetreat");
            return (Criteria) this;
        }

        public Criteria andARetreatIn(List<BigDecimal> values) {
            addCriterion("A_Retreat in", values, "aRetreat");
            return (Criteria) this;
        }

        public Criteria andARetreatNotIn(List<BigDecimal> values) {
            addCriterion("A_Retreat not in", values, "aRetreat");
            return (Criteria) this;
        }

        public Criteria andARetreatBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("A_Retreat between", value1, value2, "aRetreat");
            return (Criteria) this;
        }

        public Criteria andARetreatNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("A_Retreat not between", value1, value2, "aRetreat");
            return (Criteria) this;
        }

        public Criteria andBRetreatIsNull() {
            addCriterion("B_Retreat is null");
            return (Criteria) this;
        }

        public Criteria andBRetreatIsNotNull() {
            addCriterion("B_Retreat is not null");
            return (Criteria) this;
        }

        public Criteria andBRetreatEqualTo(BigDecimal value) {
            addCriterion("B_Retreat =", value, "bRetreat");
            return (Criteria) this;
        }

        public Criteria andBRetreatNotEqualTo(BigDecimal value) {
            addCriterion("B_Retreat <>", value, "bRetreat");
            return (Criteria) this;
        }

        public Criteria andBRetreatGreaterThan(BigDecimal value) {
            addCriterion("B_Retreat >", value, "bRetreat");
            return (Criteria) this;
        }

        public Criteria andBRetreatGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("B_Retreat >=", value, "bRetreat");
            return (Criteria) this;
        }

        public Criteria andBRetreatLessThan(BigDecimal value) {
            addCriterion("B_Retreat <", value, "bRetreat");
            return (Criteria) this;
        }

        public Criteria andBRetreatLessThanOrEqualTo(BigDecimal value) {
            addCriterion("B_Retreat <=", value, "bRetreat");
            return (Criteria) this;
        }

        public Criteria andBRetreatIn(List<BigDecimal> values) {
            addCriterion("B_Retreat in", values, "bRetreat");
            return (Criteria) this;
        }

        public Criteria andBRetreatNotIn(List<BigDecimal> values) {
            addCriterion("B_Retreat not in", values, "bRetreat");
            return (Criteria) this;
        }

        public Criteria andBRetreatBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("B_Retreat between", value1, value2, "bRetreat");
            return (Criteria) this;
        }

        public Criteria andBRetreatNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("B_Retreat not between", value1, value2, "bRetreat");
            return (Criteria) this;
        }

        public Criteria andCRetreatIsNull() {
            addCriterion("C_Retreat is null");
            return (Criteria) this;
        }

        public Criteria andCRetreatIsNotNull() {
            addCriterion("C_Retreat is not null");
            return (Criteria) this;
        }

        public Criteria andCRetreatEqualTo(BigDecimal value) {
            addCriterion("C_Retreat =", value, "cRetreat");
            return (Criteria) this;
        }

        public Criteria andCRetreatNotEqualTo(BigDecimal value) {
            addCriterion("C_Retreat <>", value, "cRetreat");
            return (Criteria) this;
        }

        public Criteria andCRetreatGreaterThan(BigDecimal value) {
            addCriterion("C_Retreat >", value, "cRetreat");
            return (Criteria) this;
        }

        public Criteria andCRetreatGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("C_Retreat >=", value, "cRetreat");
            return (Criteria) this;
        }

        public Criteria andCRetreatLessThan(BigDecimal value) {
            addCriterion("C_Retreat <", value, "cRetreat");
            return (Criteria) this;
        }

        public Criteria andCRetreatLessThanOrEqualTo(BigDecimal value) {
            addCriterion("C_Retreat <=", value, "cRetreat");
            return (Criteria) this;
        }

        public Criteria andCRetreatIn(List<BigDecimal> values) {
            addCriterion("C_Retreat in", values, "cRetreat");
            return (Criteria) this;
        }

        public Criteria andCRetreatNotIn(List<BigDecimal> values) {
            addCriterion("C_Retreat not in", values, "cRetreat");
            return (Criteria) this;
        }

        public Criteria andCRetreatBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("C_Retreat between", value1, value2, "cRetreat");
            return (Criteria) this;
        }

        public Criteria andCRetreatNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("C_Retreat not between", value1, value2, "cRetreat");
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