package com.yunfang.inquiry.entity1;

import java.util.ArrayList;
import java.util.List;

public class OddsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OddsExample() {
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

        public Criteria andTypeIsNull() {
            addCriterion("Type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("Type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("Type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("Type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("Type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("Type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("Type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("Type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("Type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("Type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("Type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("Type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("Type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("Type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andIsdefaultIsNull() {
            addCriterion("IsDefault is null");
            return (Criteria) this;
        }

        public Criteria andIsdefaultIsNotNull() {
            addCriterion("IsDefault is not null");
            return (Criteria) this;
        }

        public Criteria andIsdefaultEqualTo(Boolean value) {
            addCriterion("IsDefault =", value, "isdefault");
            return (Criteria) this;
        }

        public Criteria andIsdefaultNotEqualTo(Boolean value) {
            addCriterion("IsDefault <>", value, "isdefault");
            return (Criteria) this;
        }

        public Criteria andIsdefaultGreaterThan(Boolean value) {
            addCriterion("IsDefault >", value, "isdefault");
            return (Criteria) this;
        }

        public Criteria andIsdefaultGreaterThanOrEqualTo(Boolean value) {
            addCriterion("IsDefault >=", value, "isdefault");
            return (Criteria) this;
        }

        public Criteria andIsdefaultLessThan(Boolean value) {
            addCriterion("IsDefault <", value, "isdefault");
            return (Criteria) this;
        }

        public Criteria andIsdefaultLessThanOrEqualTo(Boolean value) {
            addCriterion("IsDefault <=", value, "isdefault");
            return (Criteria) this;
        }

        public Criteria andIsdefaultIn(List<Boolean> values) {
            addCriterion("IsDefault in", values, "isdefault");
            return (Criteria) this;
        }

        public Criteria andIsdefaultNotIn(List<Boolean> values) {
            addCriterion("IsDefault not in", values, "isdefault");
            return (Criteria) this;
        }

        public Criteria andIsdefaultBetween(Boolean value1, Boolean value2) {
            addCriterion("IsDefault between", value1, value2, "isdefault");
            return (Criteria) this;
        }

        public Criteria andIsdefaultNotBetween(Boolean value1, Boolean value2) {
            addCriterion("IsDefault not between", value1, value2, "isdefault");
            return (Criteria) this;
        }

        public Criteria andNo1IsNull() {
            addCriterion("No1 is null");
            return (Criteria) this;
        }

        public Criteria andNo1IsNotNull() {
            addCriterion("No1 is not null");
            return (Criteria) this;
        }

        public Criteria andNo1EqualTo(Float value) {
            addCriterion("No1 =", value, "no1");
            return (Criteria) this;
        }

        public Criteria andNo1NotEqualTo(Float value) {
            addCriterion("No1 <>", value, "no1");
            return (Criteria) this;
        }

        public Criteria andNo1GreaterThan(Float value) {
            addCriterion("No1 >", value, "no1");
            return (Criteria) this;
        }

        public Criteria andNo1GreaterThanOrEqualTo(Float value) {
            addCriterion("No1 >=", value, "no1");
            return (Criteria) this;
        }

        public Criteria andNo1LessThan(Float value) {
            addCriterion("No1 <", value, "no1");
            return (Criteria) this;
        }

        public Criteria andNo1LessThanOrEqualTo(Float value) {
            addCriterion("No1 <=", value, "no1");
            return (Criteria) this;
        }

        public Criteria andNo1In(List<Float> values) {
            addCriterion("No1 in", values, "no1");
            return (Criteria) this;
        }

        public Criteria andNo1NotIn(List<Float> values) {
            addCriterion("No1 not in", values, "no1");
            return (Criteria) this;
        }

        public Criteria andNo1Between(Float value1, Float value2) {
            addCriterion("No1 between", value1, value2, "no1");
            return (Criteria) this;
        }

        public Criteria andNo1NotBetween(Float value1, Float value2) {
            addCriterion("No1 not between", value1, value2, "no1");
            return (Criteria) this;
        }

        public Criteria andNo2IsNull() {
            addCriterion("No2 is null");
            return (Criteria) this;
        }

        public Criteria andNo2IsNotNull() {
            addCriterion("No2 is not null");
            return (Criteria) this;
        }

        public Criteria andNo2EqualTo(Float value) {
            addCriterion("No2 =", value, "no2");
            return (Criteria) this;
        }

        public Criteria andNo2NotEqualTo(Float value) {
            addCriterion("No2 <>", value, "no2");
            return (Criteria) this;
        }

        public Criteria andNo2GreaterThan(Float value) {
            addCriterion("No2 >", value, "no2");
            return (Criteria) this;
        }

        public Criteria andNo2GreaterThanOrEqualTo(Float value) {
            addCriterion("No2 >=", value, "no2");
            return (Criteria) this;
        }

        public Criteria andNo2LessThan(Float value) {
            addCriterion("No2 <", value, "no2");
            return (Criteria) this;
        }

        public Criteria andNo2LessThanOrEqualTo(Float value) {
            addCriterion("No2 <=", value, "no2");
            return (Criteria) this;
        }

        public Criteria andNo2In(List<Float> values) {
            addCriterion("No2 in", values, "no2");
            return (Criteria) this;
        }

        public Criteria andNo2NotIn(List<Float> values) {
            addCriterion("No2 not in", values, "no2");
            return (Criteria) this;
        }

        public Criteria andNo2Between(Float value1, Float value2) {
            addCriterion("No2 between", value1, value2, "no2");
            return (Criteria) this;
        }

        public Criteria andNo2NotBetween(Float value1, Float value2) {
            addCriterion("No2 not between", value1, value2, "no2");
            return (Criteria) this;
        }

        public Criteria andNo3IsNull() {
            addCriterion("No3 is null");
            return (Criteria) this;
        }

        public Criteria andNo3IsNotNull() {
            addCriterion("No3 is not null");
            return (Criteria) this;
        }

        public Criteria andNo3EqualTo(Float value) {
            addCriterion("No3 =", value, "no3");
            return (Criteria) this;
        }

        public Criteria andNo3NotEqualTo(Float value) {
            addCriterion("No3 <>", value, "no3");
            return (Criteria) this;
        }

        public Criteria andNo3GreaterThan(Float value) {
            addCriterion("No3 >", value, "no3");
            return (Criteria) this;
        }

        public Criteria andNo3GreaterThanOrEqualTo(Float value) {
            addCriterion("No3 >=", value, "no3");
            return (Criteria) this;
        }

        public Criteria andNo3LessThan(Float value) {
            addCriterion("No3 <", value, "no3");
            return (Criteria) this;
        }

        public Criteria andNo3LessThanOrEqualTo(Float value) {
            addCriterion("No3 <=", value, "no3");
            return (Criteria) this;
        }

        public Criteria andNo3In(List<Float> values) {
            addCriterion("No3 in", values, "no3");
            return (Criteria) this;
        }

        public Criteria andNo3NotIn(List<Float> values) {
            addCriterion("No3 not in", values, "no3");
            return (Criteria) this;
        }

        public Criteria andNo3Between(Float value1, Float value2) {
            addCriterion("No3 between", value1, value2, "no3");
            return (Criteria) this;
        }

        public Criteria andNo3NotBetween(Float value1, Float value2) {
            addCriterion("No3 not between", value1, value2, "no3");
            return (Criteria) this;
        }

        public Criteria andNo4IsNull() {
            addCriterion("No4 is null");
            return (Criteria) this;
        }

        public Criteria andNo4IsNotNull() {
            addCriterion("No4 is not null");
            return (Criteria) this;
        }

        public Criteria andNo4EqualTo(Float value) {
            addCriterion("No4 =", value, "no4");
            return (Criteria) this;
        }

        public Criteria andNo4NotEqualTo(Float value) {
            addCriterion("No4 <>", value, "no4");
            return (Criteria) this;
        }

        public Criteria andNo4GreaterThan(Float value) {
            addCriterion("No4 >", value, "no4");
            return (Criteria) this;
        }

        public Criteria andNo4GreaterThanOrEqualTo(Float value) {
            addCriterion("No4 >=", value, "no4");
            return (Criteria) this;
        }

        public Criteria andNo4LessThan(Float value) {
            addCriterion("No4 <", value, "no4");
            return (Criteria) this;
        }

        public Criteria andNo4LessThanOrEqualTo(Float value) {
            addCriterion("No4 <=", value, "no4");
            return (Criteria) this;
        }

        public Criteria andNo4In(List<Float> values) {
            addCriterion("No4 in", values, "no4");
            return (Criteria) this;
        }

        public Criteria andNo4NotIn(List<Float> values) {
            addCriterion("No4 not in", values, "no4");
            return (Criteria) this;
        }

        public Criteria andNo4Between(Float value1, Float value2) {
            addCriterion("No4 between", value1, value2, "no4");
            return (Criteria) this;
        }

        public Criteria andNo4NotBetween(Float value1, Float value2) {
            addCriterion("No4 not between", value1, value2, "no4");
            return (Criteria) this;
        }

        public Criteria andNo5IsNull() {
            addCriterion("No5 is null");
            return (Criteria) this;
        }

        public Criteria andNo5IsNotNull() {
            addCriterion("No5 is not null");
            return (Criteria) this;
        }

        public Criteria andNo5EqualTo(Float value) {
            addCriterion("No5 =", value, "no5");
            return (Criteria) this;
        }

        public Criteria andNo5NotEqualTo(Float value) {
            addCriterion("No5 <>", value, "no5");
            return (Criteria) this;
        }

        public Criteria andNo5GreaterThan(Float value) {
            addCriterion("No5 >", value, "no5");
            return (Criteria) this;
        }

        public Criteria andNo5GreaterThanOrEqualTo(Float value) {
            addCriterion("No5 >=", value, "no5");
            return (Criteria) this;
        }

        public Criteria andNo5LessThan(Float value) {
            addCriterion("No5 <", value, "no5");
            return (Criteria) this;
        }

        public Criteria andNo5LessThanOrEqualTo(Float value) {
            addCriterion("No5 <=", value, "no5");
            return (Criteria) this;
        }

        public Criteria andNo5In(List<Float> values) {
            addCriterion("No5 in", values, "no5");
            return (Criteria) this;
        }

        public Criteria andNo5NotIn(List<Float> values) {
            addCriterion("No5 not in", values, "no5");
            return (Criteria) this;
        }

        public Criteria andNo5Between(Float value1, Float value2) {
            addCriterion("No5 between", value1, value2, "no5");
            return (Criteria) this;
        }

        public Criteria andNo5NotBetween(Float value1, Float value2) {
            addCriterion("No5 not between", value1, value2, "no5");
            return (Criteria) this;
        }

        public Criteria andNo6IsNull() {
            addCriterion("No6 is null");
            return (Criteria) this;
        }

        public Criteria andNo6IsNotNull() {
            addCriterion("No6 is not null");
            return (Criteria) this;
        }

        public Criteria andNo6EqualTo(Float value) {
            addCriterion("No6 =", value, "no6");
            return (Criteria) this;
        }

        public Criteria andNo6NotEqualTo(Float value) {
            addCriterion("No6 <>", value, "no6");
            return (Criteria) this;
        }

        public Criteria andNo6GreaterThan(Float value) {
            addCriterion("No6 >", value, "no6");
            return (Criteria) this;
        }

        public Criteria andNo6GreaterThanOrEqualTo(Float value) {
            addCriterion("No6 >=", value, "no6");
            return (Criteria) this;
        }

        public Criteria andNo6LessThan(Float value) {
            addCriterion("No6 <", value, "no6");
            return (Criteria) this;
        }

        public Criteria andNo6LessThanOrEqualTo(Float value) {
            addCriterion("No6 <=", value, "no6");
            return (Criteria) this;
        }

        public Criteria andNo6In(List<Float> values) {
            addCriterion("No6 in", values, "no6");
            return (Criteria) this;
        }

        public Criteria andNo6NotIn(List<Float> values) {
            addCriterion("No6 not in", values, "no6");
            return (Criteria) this;
        }

        public Criteria andNo6Between(Float value1, Float value2) {
            addCriterion("No6 between", value1, value2, "no6");
            return (Criteria) this;
        }

        public Criteria andNo6NotBetween(Float value1, Float value2) {
            addCriterion("No6 not between", value1, value2, "no6");
            return (Criteria) this;
        }

        public Criteria andNo7IsNull() {
            addCriterion("No7 is null");
            return (Criteria) this;
        }

        public Criteria andNo7IsNotNull() {
            addCriterion("No7 is not null");
            return (Criteria) this;
        }

        public Criteria andNo7EqualTo(Float value) {
            addCriterion("No7 =", value, "no7");
            return (Criteria) this;
        }

        public Criteria andNo7NotEqualTo(Float value) {
            addCriterion("No7 <>", value, "no7");
            return (Criteria) this;
        }

        public Criteria andNo7GreaterThan(Float value) {
            addCriterion("No7 >", value, "no7");
            return (Criteria) this;
        }

        public Criteria andNo7GreaterThanOrEqualTo(Float value) {
            addCriterion("No7 >=", value, "no7");
            return (Criteria) this;
        }

        public Criteria andNo7LessThan(Float value) {
            addCriterion("No7 <", value, "no7");
            return (Criteria) this;
        }

        public Criteria andNo7LessThanOrEqualTo(Float value) {
            addCriterion("No7 <=", value, "no7");
            return (Criteria) this;
        }

        public Criteria andNo7In(List<Float> values) {
            addCriterion("No7 in", values, "no7");
            return (Criteria) this;
        }

        public Criteria andNo7NotIn(List<Float> values) {
            addCriterion("No7 not in", values, "no7");
            return (Criteria) this;
        }

        public Criteria andNo7Between(Float value1, Float value2) {
            addCriterion("No7 between", value1, value2, "no7");
            return (Criteria) this;
        }

        public Criteria andNo7NotBetween(Float value1, Float value2) {
            addCriterion("No7 not between", value1, value2, "no7");
            return (Criteria) this;
        }

        public Criteria andNo8IsNull() {
            addCriterion("No8 is null");
            return (Criteria) this;
        }

        public Criteria andNo8IsNotNull() {
            addCriterion("No8 is not null");
            return (Criteria) this;
        }

        public Criteria andNo8EqualTo(Float value) {
            addCriterion("No8 =", value, "no8");
            return (Criteria) this;
        }

        public Criteria andNo8NotEqualTo(Float value) {
            addCriterion("No8 <>", value, "no8");
            return (Criteria) this;
        }

        public Criteria andNo8GreaterThan(Float value) {
            addCriterion("No8 >", value, "no8");
            return (Criteria) this;
        }

        public Criteria andNo8GreaterThanOrEqualTo(Float value) {
            addCriterion("No8 >=", value, "no8");
            return (Criteria) this;
        }

        public Criteria andNo8LessThan(Float value) {
            addCriterion("No8 <", value, "no8");
            return (Criteria) this;
        }

        public Criteria andNo8LessThanOrEqualTo(Float value) {
            addCriterion("No8 <=", value, "no8");
            return (Criteria) this;
        }

        public Criteria andNo8In(List<Float> values) {
            addCriterion("No8 in", values, "no8");
            return (Criteria) this;
        }

        public Criteria andNo8NotIn(List<Float> values) {
            addCriterion("No8 not in", values, "no8");
            return (Criteria) this;
        }

        public Criteria andNo8Between(Float value1, Float value2) {
            addCriterion("No8 between", value1, value2, "no8");
            return (Criteria) this;
        }

        public Criteria andNo8NotBetween(Float value1, Float value2) {
            addCriterion("No8 not between", value1, value2, "no8");
            return (Criteria) this;
        }

        public Criteria andNo9IsNull() {
            addCriterion("No9 is null");
            return (Criteria) this;
        }

        public Criteria andNo9IsNotNull() {
            addCriterion("No9 is not null");
            return (Criteria) this;
        }

        public Criteria andNo9EqualTo(Float value) {
            addCriterion("No9 =", value, "no9");
            return (Criteria) this;
        }

        public Criteria andNo9NotEqualTo(Float value) {
            addCriterion("No9 <>", value, "no9");
            return (Criteria) this;
        }

        public Criteria andNo9GreaterThan(Float value) {
            addCriterion("No9 >", value, "no9");
            return (Criteria) this;
        }

        public Criteria andNo9GreaterThanOrEqualTo(Float value) {
            addCriterion("No9 >=", value, "no9");
            return (Criteria) this;
        }

        public Criteria andNo9LessThan(Float value) {
            addCriterion("No9 <", value, "no9");
            return (Criteria) this;
        }

        public Criteria andNo9LessThanOrEqualTo(Float value) {
            addCriterion("No9 <=", value, "no9");
            return (Criteria) this;
        }

        public Criteria andNo9In(List<Float> values) {
            addCriterion("No9 in", values, "no9");
            return (Criteria) this;
        }

        public Criteria andNo9NotIn(List<Float> values) {
            addCriterion("No9 not in", values, "no9");
            return (Criteria) this;
        }

        public Criteria andNo9Between(Float value1, Float value2) {
            addCriterion("No9 between", value1, value2, "no9");
            return (Criteria) this;
        }

        public Criteria andNo9NotBetween(Float value1, Float value2) {
            addCriterion("No9 not between", value1, value2, "no9");
            return (Criteria) this;
        }

        public Criteria andNo10IsNull() {
            addCriterion("No10 is null");
            return (Criteria) this;
        }

        public Criteria andNo10IsNotNull() {
            addCriterion("No10 is not null");
            return (Criteria) this;
        }

        public Criteria andNo10EqualTo(Float value) {
            addCriterion("No10 =", value, "no10");
            return (Criteria) this;
        }

        public Criteria andNo10NotEqualTo(Float value) {
            addCriterion("No10 <>", value, "no10");
            return (Criteria) this;
        }

        public Criteria andNo10GreaterThan(Float value) {
            addCriterion("No10 >", value, "no10");
            return (Criteria) this;
        }

        public Criteria andNo10GreaterThanOrEqualTo(Float value) {
            addCriterion("No10 >=", value, "no10");
            return (Criteria) this;
        }

        public Criteria andNo10LessThan(Float value) {
            addCriterion("No10 <", value, "no10");
            return (Criteria) this;
        }

        public Criteria andNo10LessThanOrEqualTo(Float value) {
            addCriterion("No10 <=", value, "no10");
            return (Criteria) this;
        }

        public Criteria andNo10In(List<Float> values) {
            addCriterion("No10 in", values, "no10");
            return (Criteria) this;
        }

        public Criteria andNo10NotIn(List<Float> values) {
            addCriterion("No10 not in", values, "no10");
            return (Criteria) this;
        }

        public Criteria andNo10Between(Float value1, Float value2) {
            addCriterion("No10 between", value1, value2, "no10");
            return (Criteria) this;
        }

        public Criteria andNo10NotBetween(Float value1, Float value2) {
            addCriterion("No10 not between", value1, value2, "no10");
            return (Criteria) this;
        }

        public Criteria andNo11IsNull() {
            addCriterion("No11 is null");
            return (Criteria) this;
        }

        public Criteria andNo11IsNotNull() {
            addCriterion("No11 is not null");
            return (Criteria) this;
        }

        public Criteria andNo11EqualTo(Float value) {
            addCriterion("No11 =", value, "no11");
            return (Criteria) this;
        }

        public Criteria andNo11NotEqualTo(Float value) {
            addCriterion("No11 <>", value, "no11");
            return (Criteria) this;
        }

        public Criteria andNo11GreaterThan(Float value) {
            addCriterion("No11 >", value, "no11");
            return (Criteria) this;
        }

        public Criteria andNo11GreaterThanOrEqualTo(Float value) {
            addCriterion("No11 >=", value, "no11");
            return (Criteria) this;
        }

        public Criteria andNo11LessThan(Float value) {
            addCriterion("No11 <", value, "no11");
            return (Criteria) this;
        }

        public Criteria andNo11LessThanOrEqualTo(Float value) {
            addCriterion("No11 <=", value, "no11");
            return (Criteria) this;
        }

        public Criteria andNo11In(List<Float> values) {
            addCriterion("No11 in", values, "no11");
            return (Criteria) this;
        }

        public Criteria andNo11NotIn(List<Float> values) {
            addCriterion("No11 not in", values, "no11");
            return (Criteria) this;
        }

        public Criteria andNo11Between(Float value1, Float value2) {
            addCriterion("No11 between", value1, value2, "no11");
            return (Criteria) this;
        }

        public Criteria andNo11NotBetween(Float value1, Float value2) {
            addCriterion("No11 not between", value1, value2, "no11");
            return (Criteria) this;
        }

        public Criteria andNo12IsNull() {
            addCriterion("No12 is null");
            return (Criteria) this;
        }

        public Criteria andNo12IsNotNull() {
            addCriterion("No12 is not null");
            return (Criteria) this;
        }

        public Criteria andNo12EqualTo(Float value) {
            addCriterion("No12 =", value, "no12");
            return (Criteria) this;
        }

        public Criteria andNo12NotEqualTo(Float value) {
            addCriterion("No12 <>", value, "no12");
            return (Criteria) this;
        }

        public Criteria andNo12GreaterThan(Float value) {
            addCriterion("No12 >", value, "no12");
            return (Criteria) this;
        }

        public Criteria andNo12GreaterThanOrEqualTo(Float value) {
            addCriterion("No12 >=", value, "no12");
            return (Criteria) this;
        }

        public Criteria andNo12LessThan(Float value) {
            addCriterion("No12 <", value, "no12");
            return (Criteria) this;
        }

        public Criteria andNo12LessThanOrEqualTo(Float value) {
            addCriterion("No12 <=", value, "no12");
            return (Criteria) this;
        }

        public Criteria andNo12In(List<Float> values) {
            addCriterion("No12 in", values, "no12");
            return (Criteria) this;
        }

        public Criteria andNo12NotIn(List<Float> values) {
            addCriterion("No12 not in", values, "no12");
            return (Criteria) this;
        }

        public Criteria andNo12Between(Float value1, Float value2) {
            addCriterion("No12 between", value1, value2, "no12");
            return (Criteria) this;
        }

        public Criteria andNo12NotBetween(Float value1, Float value2) {
            addCriterion("No12 not between", value1, value2, "no12");
            return (Criteria) this;
        }

        public Criteria andNo13IsNull() {
            addCriterion("No13 is null");
            return (Criteria) this;
        }

        public Criteria andNo13IsNotNull() {
            addCriterion("No13 is not null");
            return (Criteria) this;
        }

        public Criteria andNo13EqualTo(Float value) {
            addCriterion("No13 =", value, "no13");
            return (Criteria) this;
        }

        public Criteria andNo13NotEqualTo(Float value) {
            addCriterion("No13 <>", value, "no13");
            return (Criteria) this;
        }

        public Criteria andNo13GreaterThan(Float value) {
            addCriterion("No13 >", value, "no13");
            return (Criteria) this;
        }

        public Criteria andNo13GreaterThanOrEqualTo(Float value) {
            addCriterion("No13 >=", value, "no13");
            return (Criteria) this;
        }

        public Criteria andNo13LessThan(Float value) {
            addCriterion("No13 <", value, "no13");
            return (Criteria) this;
        }

        public Criteria andNo13LessThanOrEqualTo(Float value) {
            addCriterion("No13 <=", value, "no13");
            return (Criteria) this;
        }

        public Criteria andNo13In(List<Float> values) {
            addCriterion("No13 in", values, "no13");
            return (Criteria) this;
        }

        public Criteria andNo13NotIn(List<Float> values) {
            addCriterion("No13 not in", values, "no13");
            return (Criteria) this;
        }

        public Criteria andNo13Between(Float value1, Float value2) {
            addCriterion("No13 between", value1, value2, "no13");
            return (Criteria) this;
        }

        public Criteria andNo13NotBetween(Float value1, Float value2) {
            addCriterion("No13 not between", value1, value2, "no13");
            return (Criteria) this;
        }

        public Criteria andNo14IsNull() {
            addCriterion("No14 is null");
            return (Criteria) this;
        }

        public Criteria andNo14IsNotNull() {
            addCriterion("No14 is not null");
            return (Criteria) this;
        }

        public Criteria andNo14EqualTo(Float value) {
            addCriterion("No14 =", value, "no14");
            return (Criteria) this;
        }

        public Criteria andNo14NotEqualTo(Float value) {
            addCriterion("No14 <>", value, "no14");
            return (Criteria) this;
        }

        public Criteria andNo14GreaterThan(Float value) {
            addCriterion("No14 >", value, "no14");
            return (Criteria) this;
        }

        public Criteria andNo14GreaterThanOrEqualTo(Float value) {
            addCriterion("No14 >=", value, "no14");
            return (Criteria) this;
        }

        public Criteria andNo14LessThan(Float value) {
            addCriterion("No14 <", value, "no14");
            return (Criteria) this;
        }

        public Criteria andNo14LessThanOrEqualTo(Float value) {
            addCriterion("No14 <=", value, "no14");
            return (Criteria) this;
        }

        public Criteria andNo14In(List<Float> values) {
            addCriterion("No14 in", values, "no14");
            return (Criteria) this;
        }

        public Criteria andNo14NotIn(List<Float> values) {
            addCriterion("No14 not in", values, "no14");
            return (Criteria) this;
        }

        public Criteria andNo14Between(Float value1, Float value2) {
            addCriterion("No14 between", value1, value2, "no14");
            return (Criteria) this;
        }

        public Criteria andNo14NotBetween(Float value1, Float value2) {
            addCriterion("No14 not between", value1, value2, "no14");
            return (Criteria) this;
        }

        public Criteria andNo15IsNull() {
            addCriterion("No15 is null");
            return (Criteria) this;
        }

        public Criteria andNo15IsNotNull() {
            addCriterion("No15 is not null");
            return (Criteria) this;
        }

        public Criteria andNo15EqualTo(Float value) {
            addCriterion("No15 =", value, "no15");
            return (Criteria) this;
        }

        public Criteria andNo15NotEqualTo(Float value) {
            addCriterion("No15 <>", value, "no15");
            return (Criteria) this;
        }

        public Criteria andNo15GreaterThan(Float value) {
            addCriterion("No15 >", value, "no15");
            return (Criteria) this;
        }

        public Criteria andNo15GreaterThanOrEqualTo(Float value) {
            addCriterion("No15 >=", value, "no15");
            return (Criteria) this;
        }

        public Criteria andNo15LessThan(Float value) {
            addCriterion("No15 <", value, "no15");
            return (Criteria) this;
        }

        public Criteria andNo15LessThanOrEqualTo(Float value) {
            addCriterion("No15 <=", value, "no15");
            return (Criteria) this;
        }

        public Criteria andNo15In(List<Float> values) {
            addCriterion("No15 in", values, "no15");
            return (Criteria) this;
        }

        public Criteria andNo15NotIn(List<Float> values) {
            addCriterion("No15 not in", values, "no15");
            return (Criteria) this;
        }

        public Criteria andNo15Between(Float value1, Float value2) {
            addCriterion("No15 between", value1, value2, "no15");
            return (Criteria) this;
        }

        public Criteria andNo15NotBetween(Float value1, Float value2) {
            addCriterion("No15 not between", value1, value2, "no15");
            return (Criteria) this;
        }

        public Criteria andNo16IsNull() {
            addCriterion("No16 is null");
            return (Criteria) this;
        }

        public Criteria andNo16IsNotNull() {
            addCriterion("No16 is not null");
            return (Criteria) this;
        }

        public Criteria andNo16EqualTo(Float value) {
            addCriterion("No16 =", value, "no16");
            return (Criteria) this;
        }

        public Criteria andNo16NotEqualTo(Float value) {
            addCriterion("No16 <>", value, "no16");
            return (Criteria) this;
        }

        public Criteria andNo16GreaterThan(Float value) {
            addCriterion("No16 >", value, "no16");
            return (Criteria) this;
        }

        public Criteria andNo16GreaterThanOrEqualTo(Float value) {
            addCriterion("No16 >=", value, "no16");
            return (Criteria) this;
        }

        public Criteria andNo16LessThan(Float value) {
            addCriterion("No16 <", value, "no16");
            return (Criteria) this;
        }

        public Criteria andNo16LessThanOrEqualTo(Float value) {
            addCriterion("No16 <=", value, "no16");
            return (Criteria) this;
        }

        public Criteria andNo16In(List<Float> values) {
            addCriterion("No16 in", values, "no16");
            return (Criteria) this;
        }

        public Criteria andNo16NotIn(List<Float> values) {
            addCriterion("No16 not in", values, "no16");
            return (Criteria) this;
        }

        public Criteria andNo16Between(Float value1, Float value2) {
            addCriterion("No16 between", value1, value2, "no16");
            return (Criteria) this;
        }

        public Criteria andNo16NotBetween(Float value1, Float value2) {
            addCriterion("No16 not between", value1, value2, "no16");
            return (Criteria) this;
        }

        public Criteria andNo17IsNull() {
            addCriterion("No17 is null");
            return (Criteria) this;
        }

        public Criteria andNo17IsNotNull() {
            addCriterion("No17 is not null");
            return (Criteria) this;
        }

        public Criteria andNo17EqualTo(Float value) {
            addCriterion("No17 =", value, "no17");
            return (Criteria) this;
        }

        public Criteria andNo17NotEqualTo(Float value) {
            addCriterion("No17 <>", value, "no17");
            return (Criteria) this;
        }

        public Criteria andNo17GreaterThan(Float value) {
            addCriterion("No17 >", value, "no17");
            return (Criteria) this;
        }

        public Criteria andNo17GreaterThanOrEqualTo(Float value) {
            addCriterion("No17 >=", value, "no17");
            return (Criteria) this;
        }

        public Criteria andNo17LessThan(Float value) {
            addCriterion("No17 <", value, "no17");
            return (Criteria) this;
        }

        public Criteria andNo17LessThanOrEqualTo(Float value) {
            addCriterion("No17 <=", value, "no17");
            return (Criteria) this;
        }

        public Criteria andNo17In(List<Float> values) {
            addCriterion("No17 in", values, "no17");
            return (Criteria) this;
        }

        public Criteria andNo17NotIn(List<Float> values) {
            addCriterion("No17 not in", values, "no17");
            return (Criteria) this;
        }

        public Criteria andNo17Between(Float value1, Float value2) {
            addCriterion("No17 between", value1, value2, "no17");
            return (Criteria) this;
        }

        public Criteria andNo17NotBetween(Float value1, Float value2) {
            addCriterion("No17 not between", value1, value2, "no17");
            return (Criteria) this;
        }

        public Criteria andNo18IsNull() {
            addCriterion("No18 is null");
            return (Criteria) this;
        }

        public Criteria andNo18IsNotNull() {
            addCriterion("No18 is not null");
            return (Criteria) this;
        }

        public Criteria andNo18EqualTo(Float value) {
            addCriterion("No18 =", value, "no18");
            return (Criteria) this;
        }

        public Criteria andNo18NotEqualTo(Float value) {
            addCriterion("No18 <>", value, "no18");
            return (Criteria) this;
        }

        public Criteria andNo18GreaterThan(Float value) {
            addCriterion("No18 >", value, "no18");
            return (Criteria) this;
        }

        public Criteria andNo18GreaterThanOrEqualTo(Float value) {
            addCriterion("No18 >=", value, "no18");
            return (Criteria) this;
        }

        public Criteria andNo18LessThan(Float value) {
            addCriterion("No18 <", value, "no18");
            return (Criteria) this;
        }

        public Criteria andNo18LessThanOrEqualTo(Float value) {
            addCriterion("No18 <=", value, "no18");
            return (Criteria) this;
        }

        public Criteria andNo18In(List<Float> values) {
            addCriterion("No18 in", values, "no18");
            return (Criteria) this;
        }

        public Criteria andNo18NotIn(List<Float> values) {
            addCriterion("No18 not in", values, "no18");
            return (Criteria) this;
        }

        public Criteria andNo18Between(Float value1, Float value2) {
            addCriterion("No18 between", value1, value2, "no18");
            return (Criteria) this;
        }

        public Criteria andNo18NotBetween(Float value1, Float value2) {
            addCriterion("No18 not between", value1, value2, "no18");
            return (Criteria) this;
        }

        public Criteria andNo19IsNull() {
            addCriterion("No19 is null");
            return (Criteria) this;
        }

        public Criteria andNo19IsNotNull() {
            addCriterion("No19 is not null");
            return (Criteria) this;
        }

        public Criteria andNo19EqualTo(Float value) {
            addCriterion("No19 =", value, "no19");
            return (Criteria) this;
        }

        public Criteria andNo19NotEqualTo(Float value) {
            addCriterion("No19 <>", value, "no19");
            return (Criteria) this;
        }

        public Criteria andNo19GreaterThan(Float value) {
            addCriterion("No19 >", value, "no19");
            return (Criteria) this;
        }

        public Criteria andNo19GreaterThanOrEqualTo(Float value) {
            addCriterion("No19 >=", value, "no19");
            return (Criteria) this;
        }

        public Criteria andNo19LessThan(Float value) {
            addCriterion("No19 <", value, "no19");
            return (Criteria) this;
        }

        public Criteria andNo19LessThanOrEqualTo(Float value) {
            addCriterion("No19 <=", value, "no19");
            return (Criteria) this;
        }

        public Criteria andNo19In(List<Float> values) {
            addCriterion("No19 in", values, "no19");
            return (Criteria) this;
        }

        public Criteria andNo19NotIn(List<Float> values) {
            addCriterion("No19 not in", values, "no19");
            return (Criteria) this;
        }

        public Criteria andNo19Between(Float value1, Float value2) {
            addCriterion("No19 between", value1, value2, "no19");
            return (Criteria) this;
        }

        public Criteria andNo19NotBetween(Float value1, Float value2) {
            addCriterion("No19 not between", value1, value2, "no19");
            return (Criteria) this;
        }

        public Criteria andNo20IsNull() {
            addCriterion("No20 is null");
            return (Criteria) this;
        }

        public Criteria andNo20IsNotNull() {
            addCriterion("No20 is not null");
            return (Criteria) this;
        }

        public Criteria andNo20EqualTo(Float value) {
            addCriterion("No20 =", value, "no20");
            return (Criteria) this;
        }

        public Criteria andNo20NotEqualTo(Float value) {
            addCriterion("No20 <>", value, "no20");
            return (Criteria) this;
        }

        public Criteria andNo20GreaterThan(Float value) {
            addCriterion("No20 >", value, "no20");
            return (Criteria) this;
        }

        public Criteria andNo20GreaterThanOrEqualTo(Float value) {
            addCriterion("No20 >=", value, "no20");
            return (Criteria) this;
        }

        public Criteria andNo20LessThan(Float value) {
            addCriterion("No20 <", value, "no20");
            return (Criteria) this;
        }

        public Criteria andNo20LessThanOrEqualTo(Float value) {
            addCriterion("No20 <=", value, "no20");
            return (Criteria) this;
        }

        public Criteria andNo20In(List<Float> values) {
            addCriterion("No20 in", values, "no20");
            return (Criteria) this;
        }

        public Criteria andNo20NotIn(List<Float> values) {
            addCriterion("No20 not in", values, "no20");
            return (Criteria) this;
        }

        public Criteria andNo20Between(Float value1, Float value2) {
            addCriterion("No20 between", value1, value2, "no20");
            return (Criteria) this;
        }

        public Criteria andNo20NotBetween(Float value1, Float value2) {
            addCriterion("No20 not between", value1, value2, "no20");
            return (Criteria) this;
        }

        public Criteria andNo21IsNull() {
            addCriterion("No21 is null");
            return (Criteria) this;
        }

        public Criteria andNo21IsNotNull() {
            addCriterion("No21 is not null");
            return (Criteria) this;
        }

        public Criteria andNo21EqualTo(Float value) {
            addCriterion("No21 =", value, "no21");
            return (Criteria) this;
        }

        public Criteria andNo21NotEqualTo(Float value) {
            addCriterion("No21 <>", value, "no21");
            return (Criteria) this;
        }

        public Criteria andNo21GreaterThan(Float value) {
            addCriterion("No21 >", value, "no21");
            return (Criteria) this;
        }

        public Criteria andNo21GreaterThanOrEqualTo(Float value) {
            addCriterion("No21 >=", value, "no21");
            return (Criteria) this;
        }

        public Criteria andNo21LessThan(Float value) {
            addCriterion("No21 <", value, "no21");
            return (Criteria) this;
        }

        public Criteria andNo21LessThanOrEqualTo(Float value) {
            addCriterion("No21 <=", value, "no21");
            return (Criteria) this;
        }

        public Criteria andNo21In(List<Float> values) {
            addCriterion("No21 in", values, "no21");
            return (Criteria) this;
        }

        public Criteria andNo21NotIn(List<Float> values) {
            addCriterion("No21 not in", values, "no21");
            return (Criteria) this;
        }

        public Criteria andNo21Between(Float value1, Float value2) {
            addCriterion("No21 between", value1, value2, "no21");
            return (Criteria) this;
        }

        public Criteria andNo21NotBetween(Float value1, Float value2) {
            addCriterion("No21 not between", value1, value2, "no21");
            return (Criteria) this;
        }

        public Criteria andNo22IsNull() {
            addCriterion("No22 is null");
            return (Criteria) this;
        }

        public Criteria andNo22IsNotNull() {
            addCriterion("No22 is not null");
            return (Criteria) this;
        }

        public Criteria andNo22EqualTo(Float value) {
            addCriterion("No22 =", value, "no22");
            return (Criteria) this;
        }

        public Criteria andNo22NotEqualTo(Float value) {
            addCriterion("No22 <>", value, "no22");
            return (Criteria) this;
        }

        public Criteria andNo22GreaterThan(Float value) {
            addCriterion("No22 >", value, "no22");
            return (Criteria) this;
        }

        public Criteria andNo22GreaterThanOrEqualTo(Float value) {
            addCriterion("No22 >=", value, "no22");
            return (Criteria) this;
        }

        public Criteria andNo22LessThan(Float value) {
            addCriterion("No22 <", value, "no22");
            return (Criteria) this;
        }

        public Criteria andNo22LessThanOrEqualTo(Float value) {
            addCriterion("No22 <=", value, "no22");
            return (Criteria) this;
        }

        public Criteria andNo22In(List<Float> values) {
            addCriterion("No22 in", values, "no22");
            return (Criteria) this;
        }

        public Criteria andNo22NotIn(List<Float> values) {
            addCriterion("No22 not in", values, "no22");
            return (Criteria) this;
        }

        public Criteria andNo22Between(Float value1, Float value2) {
            addCriterion("No22 between", value1, value2, "no22");
            return (Criteria) this;
        }

        public Criteria andNo22NotBetween(Float value1, Float value2) {
            addCriterion("No22 not between", value1, value2, "no22");
            return (Criteria) this;
        }

        public Criteria andNo23IsNull() {
            addCriterion("No23 is null");
            return (Criteria) this;
        }

        public Criteria andNo23IsNotNull() {
            addCriterion("No23 is not null");
            return (Criteria) this;
        }

        public Criteria andNo23EqualTo(Float value) {
            addCriterion("No23 =", value, "no23");
            return (Criteria) this;
        }

        public Criteria andNo23NotEqualTo(Float value) {
            addCriterion("No23 <>", value, "no23");
            return (Criteria) this;
        }

        public Criteria andNo23GreaterThan(Float value) {
            addCriterion("No23 >", value, "no23");
            return (Criteria) this;
        }

        public Criteria andNo23GreaterThanOrEqualTo(Float value) {
            addCriterion("No23 >=", value, "no23");
            return (Criteria) this;
        }

        public Criteria andNo23LessThan(Float value) {
            addCriterion("No23 <", value, "no23");
            return (Criteria) this;
        }

        public Criteria andNo23LessThanOrEqualTo(Float value) {
            addCriterion("No23 <=", value, "no23");
            return (Criteria) this;
        }

        public Criteria andNo23In(List<Float> values) {
            addCriterion("No23 in", values, "no23");
            return (Criteria) this;
        }

        public Criteria andNo23NotIn(List<Float> values) {
            addCriterion("No23 not in", values, "no23");
            return (Criteria) this;
        }

        public Criteria andNo23Between(Float value1, Float value2) {
            addCriterion("No23 between", value1, value2, "no23");
            return (Criteria) this;
        }

        public Criteria andNo23NotBetween(Float value1, Float value2) {
            addCriterion("No23 not between", value1, value2, "no23");
            return (Criteria) this;
        }

        public Criteria andNo24IsNull() {
            addCriterion("No24 is null");
            return (Criteria) this;
        }

        public Criteria andNo24IsNotNull() {
            addCriterion("No24 is not null");
            return (Criteria) this;
        }

        public Criteria andNo24EqualTo(Float value) {
            addCriterion("No24 =", value, "no24");
            return (Criteria) this;
        }

        public Criteria andNo24NotEqualTo(Float value) {
            addCriterion("No24 <>", value, "no24");
            return (Criteria) this;
        }

        public Criteria andNo24GreaterThan(Float value) {
            addCriterion("No24 >", value, "no24");
            return (Criteria) this;
        }

        public Criteria andNo24GreaterThanOrEqualTo(Float value) {
            addCriterion("No24 >=", value, "no24");
            return (Criteria) this;
        }

        public Criteria andNo24LessThan(Float value) {
            addCriterion("No24 <", value, "no24");
            return (Criteria) this;
        }

        public Criteria andNo24LessThanOrEqualTo(Float value) {
            addCriterion("No24 <=", value, "no24");
            return (Criteria) this;
        }

        public Criteria andNo24In(List<Float> values) {
            addCriterion("No24 in", values, "no24");
            return (Criteria) this;
        }

        public Criteria andNo24NotIn(List<Float> values) {
            addCriterion("No24 not in", values, "no24");
            return (Criteria) this;
        }

        public Criteria andNo24Between(Float value1, Float value2) {
            addCriterion("No24 between", value1, value2, "no24");
            return (Criteria) this;
        }

        public Criteria andNo24NotBetween(Float value1, Float value2) {
            addCriterion("No24 not between", value1, value2, "no24");
            return (Criteria) this;
        }

        public Criteria andNo25IsNull() {
            addCriterion("No25 is null");
            return (Criteria) this;
        }

        public Criteria andNo25IsNotNull() {
            addCriterion("No25 is not null");
            return (Criteria) this;
        }

        public Criteria andNo25EqualTo(Float value) {
            addCriterion("No25 =", value, "no25");
            return (Criteria) this;
        }

        public Criteria andNo25NotEqualTo(Float value) {
            addCriterion("No25 <>", value, "no25");
            return (Criteria) this;
        }

        public Criteria andNo25GreaterThan(Float value) {
            addCriterion("No25 >", value, "no25");
            return (Criteria) this;
        }

        public Criteria andNo25GreaterThanOrEqualTo(Float value) {
            addCriterion("No25 >=", value, "no25");
            return (Criteria) this;
        }

        public Criteria andNo25LessThan(Float value) {
            addCriterion("No25 <", value, "no25");
            return (Criteria) this;
        }

        public Criteria andNo25LessThanOrEqualTo(Float value) {
            addCriterion("No25 <=", value, "no25");
            return (Criteria) this;
        }

        public Criteria andNo25In(List<Float> values) {
            addCriterion("No25 in", values, "no25");
            return (Criteria) this;
        }

        public Criteria andNo25NotIn(List<Float> values) {
            addCriterion("No25 not in", values, "no25");
            return (Criteria) this;
        }

        public Criteria andNo25Between(Float value1, Float value2) {
            addCriterion("No25 between", value1, value2, "no25");
            return (Criteria) this;
        }

        public Criteria andNo25NotBetween(Float value1, Float value2) {
            addCriterion("No25 not between", value1, value2, "no25");
            return (Criteria) this;
        }

        public Criteria andNo26IsNull() {
            addCriterion("No26 is null");
            return (Criteria) this;
        }

        public Criteria andNo26IsNotNull() {
            addCriterion("No26 is not null");
            return (Criteria) this;
        }

        public Criteria andNo26EqualTo(Float value) {
            addCriterion("No26 =", value, "no26");
            return (Criteria) this;
        }

        public Criteria andNo26NotEqualTo(Float value) {
            addCriterion("No26 <>", value, "no26");
            return (Criteria) this;
        }

        public Criteria andNo26GreaterThan(Float value) {
            addCriterion("No26 >", value, "no26");
            return (Criteria) this;
        }

        public Criteria andNo26GreaterThanOrEqualTo(Float value) {
            addCriterion("No26 >=", value, "no26");
            return (Criteria) this;
        }

        public Criteria andNo26LessThan(Float value) {
            addCriterion("No26 <", value, "no26");
            return (Criteria) this;
        }

        public Criteria andNo26LessThanOrEqualTo(Float value) {
            addCriterion("No26 <=", value, "no26");
            return (Criteria) this;
        }

        public Criteria andNo26In(List<Float> values) {
            addCriterion("No26 in", values, "no26");
            return (Criteria) this;
        }

        public Criteria andNo26NotIn(List<Float> values) {
            addCriterion("No26 not in", values, "no26");
            return (Criteria) this;
        }

        public Criteria andNo26Between(Float value1, Float value2) {
            addCriterion("No26 between", value1, value2, "no26");
            return (Criteria) this;
        }

        public Criteria andNo26NotBetween(Float value1, Float value2) {
            addCriterion("No26 not between", value1, value2, "no26");
            return (Criteria) this;
        }

        public Criteria andNo27IsNull() {
            addCriterion("No27 is null");
            return (Criteria) this;
        }

        public Criteria andNo27IsNotNull() {
            addCriterion("No27 is not null");
            return (Criteria) this;
        }

        public Criteria andNo27EqualTo(Float value) {
            addCriterion("No27 =", value, "no27");
            return (Criteria) this;
        }

        public Criteria andNo27NotEqualTo(Float value) {
            addCriterion("No27 <>", value, "no27");
            return (Criteria) this;
        }

        public Criteria andNo27GreaterThan(Float value) {
            addCriterion("No27 >", value, "no27");
            return (Criteria) this;
        }

        public Criteria andNo27GreaterThanOrEqualTo(Float value) {
            addCriterion("No27 >=", value, "no27");
            return (Criteria) this;
        }

        public Criteria andNo27LessThan(Float value) {
            addCriterion("No27 <", value, "no27");
            return (Criteria) this;
        }

        public Criteria andNo27LessThanOrEqualTo(Float value) {
            addCriterion("No27 <=", value, "no27");
            return (Criteria) this;
        }

        public Criteria andNo27In(List<Float> values) {
            addCriterion("No27 in", values, "no27");
            return (Criteria) this;
        }

        public Criteria andNo27NotIn(List<Float> values) {
            addCriterion("No27 not in", values, "no27");
            return (Criteria) this;
        }

        public Criteria andNo27Between(Float value1, Float value2) {
            addCriterion("No27 between", value1, value2, "no27");
            return (Criteria) this;
        }

        public Criteria andNo27NotBetween(Float value1, Float value2) {
            addCriterion("No27 not between", value1, value2, "no27");
            return (Criteria) this;
        }

        public Criteria andNo28IsNull() {
            addCriterion("No28 is null");
            return (Criteria) this;
        }

        public Criteria andNo28IsNotNull() {
            addCriterion("No28 is not null");
            return (Criteria) this;
        }

        public Criteria andNo28EqualTo(Float value) {
            addCriterion("No28 =", value, "no28");
            return (Criteria) this;
        }

        public Criteria andNo28NotEqualTo(Float value) {
            addCriterion("No28 <>", value, "no28");
            return (Criteria) this;
        }

        public Criteria andNo28GreaterThan(Float value) {
            addCriterion("No28 >", value, "no28");
            return (Criteria) this;
        }

        public Criteria andNo28GreaterThanOrEqualTo(Float value) {
            addCriterion("No28 >=", value, "no28");
            return (Criteria) this;
        }

        public Criteria andNo28LessThan(Float value) {
            addCriterion("No28 <", value, "no28");
            return (Criteria) this;
        }

        public Criteria andNo28LessThanOrEqualTo(Float value) {
            addCriterion("No28 <=", value, "no28");
            return (Criteria) this;
        }

        public Criteria andNo28In(List<Float> values) {
            addCriterion("No28 in", values, "no28");
            return (Criteria) this;
        }

        public Criteria andNo28NotIn(List<Float> values) {
            addCriterion("No28 not in", values, "no28");
            return (Criteria) this;
        }

        public Criteria andNo28Between(Float value1, Float value2) {
            addCriterion("No28 between", value1, value2, "no28");
            return (Criteria) this;
        }

        public Criteria andNo28NotBetween(Float value1, Float value2) {
            addCriterion("No28 not between", value1, value2, "no28");
            return (Criteria) this;
        }

        public Criteria andNo29IsNull() {
            addCriterion("No29 is null");
            return (Criteria) this;
        }

        public Criteria andNo29IsNotNull() {
            addCriterion("No29 is not null");
            return (Criteria) this;
        }

        public Criteria andNo29EqualTo(Float value) {
            addCriterion("No29 =", value, "no29");
            return (Criteria) this;
        }

        public Criteria andNo29NotEqualTo(Float value) {
            addCriterion("No29 <>", value, "no29");
            return (Criteria) this;
        }

        public Criteria andNo29GreaterThan(Float value) {
            addCriterion("No29 >", value, "no29");
            return (Criteria) this;
        }

        public Criteria andNo29GreaterThanOrEqualTo(Float value) {
            addCriterion("No29 >=", value, "no29");
            return (Criteria) this;
        }

        public Criteria andNo29LessThan(Float value) {
            addCriterion("No29 <", value, "no29");
            return (Criteria) this;
        }

        public Criteria andNo29LessThanOrEqualTo(Float value) {
            addCriterion("No29 <=", value, "no29");
            return (Criteria) this;
        }

        public Criteria andNo29In(List<Float> values) {
            addCriterion("No29 in", values, "no29");
            return (Criteria) this;
        }

        public Criteria andNo29NotIn(List<Float> values) {
            addCriterion("No29 not in", values, "no29");
            return (Criteria) this;
        }

        public Criteria andNo29Between(Float value1, Float value2) {
            addCriterion("No29 between", value1, value2, "no29");
            return (Criteria) this;
        }

        public Criteria andNo29NotBetween(Float value1, Float value2) {
            addCriterion("No29 not between", value1, value2, "no29");
            return (Criteria) this;
        }

        public Criteria andNo30IsNull() {
            addCriterion("No30 is null");
            return (Criteria) this;
        }

        public Criteria andNo30IsNotNull() {
            addCriterion("No30 is not null");
            return (Criteria) this;
        }

        public Criteria andNo30EqualTo(Float value) {
            addCriterion("No30 =", value, "no30");
            return (Criteria) this;
        }

        public Criteria andNo30NotEqualTo(Float value) {
            addCriterion("No30 <>", value, "no30");
            return (Criteria) this;
        }

        public Criteria andNo30GreaterThan(Float value) {
            addCriterion("No30 >", value, "no30");
            return (Criteria) this;
        }

        public Criteria andNo30GreaterThanOrEqualTo(Float value) {
            addCriterion("No30 >=", value, "no30");
            return (Criteria) this;
        }

        public Criteria andNo30LessThan(Float value) {
            addCriterion("No30 <", value, "no30");
            return (Criteria) this;
        }

        public Criteria andNo30LessThanOrEqualTo(Float value) {
            addCriterion("No30 <=", value, "no30");
            return (Criteria) this;
        }

        public Criteria andNo30In(List<Float> values) {
            addCriterion("No30 in", values, "no30");
            return (Criteria) this;
        }

        public Criteria andNo30NotIn(List<Float> values) {
            addCriterion("No30 not in", values, "no30");
            return (Criteria) this;
        }

        public Criteria andNo30Between(Float value1, Float value2) {
            addCriterion("No30 between", value1, value2, "no30");
            return (Criteria) this;
        }

        public Criteria andNo30NotBetween(Float value1, Float value2) {
            addCriterion("No30 not between", value1, value2, "no30");
            return (Criteria) this;
        }

        public Criteria andNo31IsNull() {
            addCriterion("No31 is null");
            return (Criteria) this;
        }

        public Criteria andNo31IsNotNull() {
            addCriterion("No31 is not null");
            return (Criteria) this;
        }

        public Criteria andNo31EqualTo(Float value) {
            addCriterion("No31 =", value, "no31");
            return (Criteria) this;
        }

        public Criteria andNo31NotEqualTo(Float value) {
            addCriterion("No31 <>", value, "no31");
            return (Criteria) this;
        }

        public Criteria andNo31GreaterThan(Float value) {
            addCriterion("No31 >", value, "no31");
            return (Criteria) this;
        }

        public Criteria andNo31GreaterThanOrEqualTo(Float value) {
            addCriterion("No31 >=", value, "no31");
            return (Criteria) this;
        }

        public Criteria andNo31LessThan(Float value) {
            addCriterion("No31 <", value, "no31");
            return (Criteria) this;
        }

        public Criteria andNo31LessThanOrEqualTo(Float value) {
            addCriterion("No31 <=", value, "no31");
            return (Criteria) this;
        }

        public Criteria andNo31In(List<Float> values) {
            addCriterion("No31 in", values, "no31");
            return (Criteria) this;
        }

        public Criteria andNo31NotIn(List<Float> values) {
            addCriterion("No31 not in", values, "no31");
            return (Criteria) this;
        }

        public Criteria andNo31Between(Float value1, Float value2) {
            addCriterion("No31 between", value1, value2, "no31");
            return (Criteria) this;
        }

        public Criteria andNo31NotBetween(Float value1, Float value2) {
            addCriterion("No31 not between", value1, value2, "no31");
            return (Criteria) this;
        }

        public Criteria andNo32IsNull() {
            addCriterion("No32 is null");
            return (Criteria) this;
        }

        public Criteria andNo32IsNotNull() {
            addCriterion("No32 is not null");
            return (Criteria) this;
        }

        public Criteria andNo32EqualTo(Float value) {
            addCriterion("No32 =", value, "no32");
            return (Criteria) this;
        }

        public Criteria andNo32NotEqualTo(Float value) {
            addCriterion("No32 <>", value, "no32");
            return (Criteria) this;
        }

        public Criteria andNo32GreaterThan(Float value) {
            addCriterion("No32 >", value, "no32");
            return (Criteria) this;
        }

        public Criteria andNo32GreaterThanOrEqualTo(Float value) {
            addCriterion("No32 >=", value, "no32");
            return (Criteria) this;
        }

        public Criteria andNo32LessThan(Float value) {
            addCriterion("No32 <", value, "no32");
            return (Criteria) this;
        }

        public Criteria andNo32LessThanOrEqualTo(Float value) {
            addCriterion("No32 <=", value, "no32");
            return (Criteria) this;
        }

        public Criteria andNo32In(List<Float> values) {
            addCriterion("No32 in", values, "no32");
            return (Criteria) this;
        }

        public Criteria andNo32NotIn(List<Float> values) {
            addCriterion("No32 not in", values, "no32");
            return (Criteria) this;
        }

        public Criteria andNo32Between(Float value1, Float value2) {
            addCriterion("No32 between", value1, value2, "no32");
            return (Criteria) this;
        }

        public Criteria andNo32NotBetween(Float value1, Float value2) {
            addCriterion("No32 not between", value1, value2, "no32");
            return (Criteria) this;
        }

        public Criteria andNo33IsNull() {
            addCriterion("No33 is null");
            return (Criteria) this;
        }

        public Criteria andNo33IsNotNull() {
            addCriterion("No33 is not null");
            return (Criteria) this;
        }

        public Criteria andNo33EqualTo(Float value) {
            addCriterion("No33 =", value, "no33");
            return (Criteria) this;
        }

        public Criteria andNo33NotEqualTo(Float value) {
            addCriterion("No33 <>", value, "no33");
            return (Criteria) this;
        }

        public Criteria andNo33GreaterThan(Float value) {
            addCriterion("No33 >", value, "no33");
            return (Criteria) this;
        }

        public Criteria andNo33GreaterThanOrEqualTo(Float value) {
            addCriterion("No33 >=", value, "no33");
            return (Criteria) this;
        }

        public Criteria andNo33LessThan(Float value) {
            addCriterion("No33 <", value, "no33");
            return (Criteria) this;
        }

        public Criteria andNo33LessThanOrEqualTo(Float value) {
            addCriterion("No33 <=", value, "no33");
            return (Criteria) this;
        }

        public Criteria andNo33In(List<Float> values) {
            addCriterion("No33 in", values, "no33");
            return (Criteria) this;
        }

        public Criteria andNo33NotIn(List<Float> values) {
            addCriterion("No33 not in", values, "no33");
            return (Criteria) this;
        }

        public Criteria andNo33Between(Float value1, Float value2) {
            addCriterion("No33 between", value1, value2, "no33");
            return (Criteria) this;
        }

        public Criteria andNo33NotBetween(Float value1, Float value2) {
            addCriterion("No33 not between", value1, value2, "no33");
            return (Criteria) this;
        }

        public Criteria andNo34IsNull() {
            addCriterion("No34 is null");
            return (Criteria) this;
        }

        public Criteria andNo34IsNotNull() {
            addCriterion("No34 is not null");
            return (Criteria) this;
        }

        public Criteria andNo34EqualTo(Float value) {
            addCriterion("No34 =", value, "no34");
            return (Criteria) this;
        }

        public Criteria andNo34NotEqualTo(Float value) {
            addCriterion("No34 <>", value, "no34");
            return (Criteria) this;
        }

        public Criteria andNo34GreaterThan(Float value) {
            addCriterion("No34 >", value, "no34");
            return (Criteria) this;
        }

        public Criteria andNo34GreaterThanOrEqualTo(Float value) {
            addCriterion("No34 >=", value, "no34");
            return (Criteria) this;
        }

        public Criteria andNo34LessThan(Float value) {
            addCriterion("No34 <", value, "no34");
            return (Criteria) this;
        }

        public Criteria andNo34LessThanOrEqualTo(Float value) {
            addCriterion("No34 <=", value, "no34");
            return (Criteria) this;
        }

        public Criteria andNo34In(List<Float> values) {
            addCriterion("No34 in", values, "no34");
            return (Criteria) this;
        }

        public Criteria andNo34NotIn(List<Float> values) {
            addCriterion("No34 not in", values, "no34");
            return (Criteria) this;
        }

        public Criteria andNo34Between(Float value1, Float value2) {
            addCriterion("No34 between", value1, value2, "no34");
            return (Criteria) this;
        }

        public Criteria andNo34NotBetween(Float value1, Float value2) {
            addCriterion("No34 not between", value1, value2, "no34");
            return (Criteria) this;
        }

        public Criteria andNo35IsNull() {
            addCriterion("No35 is null");
            return (Criteria) this;
        }

        public Criteria andNo35IsNotNull() {
            addCriterion("No35 is not null");
            return (Criteria) this;
        }

        public Criteria andNo35EqualTo(Float value) {
            addCriterion("No35 =", value, "no35");
            return (Criteria) this;
        }

        public Criteria andNo35NotEqualTo(Float value) {
            addCriterion("No35 <>", value, "no35");
            return (Criteria) this;
        }

        public Criteria andNo35GreaterThan(Float value) {
            addCriterion("No35 >", value, "no35");
            return (Criteria) this;
        }

        public Criteria andNo35GreaterThanOrEqualTo(Float value) {
            addCriterion("No35 >=", value, "no35");
            return (Criteria) this;
        }

        public Criteria andNo35LessThan(Float value) {
            addCriterion("No35 <", value, "no35");
            return (Criteria) this;
        }

        public Criteria andNo35LessThanOrEqualTo(Float value) {
            addCriterion("No35 <=", value, "no35");
            return (Criteria) this;
        }

        public Criteria andNo35In(List<Float> values) {
            addCriterion("No35 in", values, "no35");
            return (Criteria) this;
        }

        public Criteria andNo35NotIn(List<Float> values) {
            addCriterion("No35 not in", values, "no35");
            return (Criteria) this;
        }

        public Criteria andNo35Between(Float value1, Float value2) {
            addCriterion("No35 between", value1, value2, "no35");
            return (Criteria) this;
        }

        public Criteria andNo35NotBetween(Float value1, Float value2) {
            addCriterion("No35 not between", value1, value2, "no35");
            return (Criteria) this;
        }

        public Criteria andNo36IsNull() {
            addCriterion("No36 is null");
            return (Criteria) this;
        }

        public Criteria andNo36IsNotNull() {
            addCriterion("No36 is not null");
            return (Criteria) this;
        }

        public Criteria andNo36EqualTo(Float value) {
            addCriterion("No36 =", value, "no36");
            return (Criteria) this;
        }

        public Criteria andNo36NotEqualTo(Float value) {
            addCriterion("No36 <>", value, "no36");
            return (Criteria) this;
        }

        public Criteria andNo36GreaterThan(Float value) {
            addCriterion("No36 >", value, "no36");
            return (Criteria) this;
        }

        public Criteria andNo36GreaterThanOrEqualTo(Float value) {
            addCriterion("No36 >=", value, "no36");
            return (Criteria) this;
        }

        public Criteria andNo36LessThan(Float value) {
            addCriterion("No36 <", value, "no36");
            return (Criteria) this;
        }

        public Criteria andNo36LessThanOrEqualTo(Float value) {
            addCriterion("No36 <=", value, "no36");
            return (Criteria) this;
        }

        public Criteria andNo36In(List<Float> values) {
            addCriterion("No36 in", values, "no36");
            return (Criteria) this;
        }

        public Criteria andNo36NotIn(List<Float> values) {
            addCriterion("No36 not in", values, "no36");
            return (Criteria) this;
        }

        public Criteria andNo36Between(Float value1, Float value2) {
            addCriterion("No36 between", value1, value2, "no36");
            return (Criteria) this;
        }

        public Criteria andNo36NotBetween(Float value1, Float value2) {
            addCriterion("No36 not between", value1, value2, "no36");
            return (Criteria) this;
        }

        public Criteria andNo37IsNull() {
            addCriterion("No37 is null");
            return (Criteria) this;
        }

        public Criteria andNo37IsNotNull() {
            addCriterion("No37 is not null");
            return (Criteria) this;
        }

        public Criteria andNo37EqualTo(Float value) {
            addCriterion("No37 =", value, "no37");
            return (Criteria) this;
        }

        public Criteria andNo37NotEqualTo(Float value) {
            addCriterion("No37 <>", value, "no37");
            return (Criteria) this;
        }

        public Criteria andNo37GreaterThan(Float value) {
            addCriterion("No37 >", value, "no37");
            return (Criteria) this;
        }

        public Criteria andNo37GreaterThanOrEqualTo(Float value) {
            addCriterion("No37 >=", value, "no37");
            return (Criteria) this;
        }

        public Criteria andNo37LessThan(Float value) {
            addCriterion("No37 <", value, "no37");
            return (Criteria) this;
        }

        public Criteria andNo37LessThanOrEqualTo(Float value) {
            addCriterion("No37 <=", value, "no37");
            return (Criteria) this;
        }

        public Criteria andNo37In(List<Float> values) {
            addCriterion("No37 in", values, "no37");
            return (Criteria) this;
        }

        public Criteria andNo37NotIn(List<Float> values) {
            addCriterion("No37 not in", values, "no37");
            return (Criteria) this;
        }

        public Criteria andNo37Between(Float value1, Float value2) {
            addCriterion("No37 between", value1, value2, "no37");
            return (Criteria) this;
        }

        public Criteria andNo37NotBetween(Float value1, Float value2) {
            addCriterion("No37 not between", value1, value2, "no37");
            return (Criteria) this;
        }

        public Criteria andNo38IsNull() {
            addCriterion("No38 is null");
            return (Criteria) this;
        }

        public Criteria andNo38IsNotNull() {
            addCriterion("No38 is not null");
            return (Criteria) this;
        }

        public Criteria andNo38EqualTo(Float value) {
            addCriterion("No38 =", value, "no38");
            return (Criteria) this;
        }

        public Criteria andNo38NotEqualTo(Float value) {
            addCriterion("No38 <>", value, "no38");
            return (Criteria) this;
        }

        public Criteria andNo38GreaterThan(Float value) {
            addCriterion("No38 >", value, "no38");
            return (Criteria) this;
        }

        public Criteria andNo38GreaterThanOrEqualTo(Float value) {
            addCriterion("No38 >=", value, "no38");
            return (Criteria) this;
        }

        public Criteria andNo38LessThan(Float value) {
            addCriterion("No38 <", value, "no38");
            return (Criteria) this;
        }

        public Criteria andNo38LessThanOrEqualTo(Float value) {
            addCriterion("No38 <=", value, "no38");
            return (Criteria) this;
        }

        public Criteria andNo38In(List<Float> values) {
            addCriterion("No38 in", values, "no38");
            return (Criteria) this;
        }

        public Criteria andNo38NotIn(List<Float> values) {
            addCriterion("No38 not in", values, "no38");
            return (Criteria) this;
        }

        public Criteria andNo38Between(Float value1, Float value2) {
            addCriterion("No38 between", value1, value2, "no38");
            return (Criteria) this;
        }

        public Criteria andNo38NotBetween(Float value1, Float value2) {
            addCriterion("No38 not between", value1, value2, "no38");
            return (Criteria) this;
        }

        public Criteria andNo39IsNull() {
            addCriterion("No39 is null");
            return (Criteria) this;
        }

        public Criteria andNo39IsNotNull() {
            addCriterion("No39 is not null");
            return (Criteria) this;
        }

        public Criteria andNo39EqualTo(Float value) {
            addCriterion("No39 =", value, "no39");
            return (Criteria) this;
        }

        public Criteria andNo39NotEqualTo(Float value) {
            addCriterion("No39 <>", value, "no39");
            return (Criteria) this;
        }

        public Criteria andNo39GreaterThan(Float value) {
            addCriterion("No39 >", value, "no39");
            return (Criteria) this;
        }

        public Criteria andNo39GreaterThanOrEqualTo(Float value) {
            addCriterion("No39 >=", value, "no39");
            return (Criteria) this;
        }

        public Criteria andNo39LessThan(Float value) {
            addCriterion("No39 <", value, "no39");
            return (Criteria) this;
        }

        public Criteria andNo39LessThanOrEqualTo(Float value) {
            addCriterion("No39 <=", value, "no39");
            return (Criteria) this;
        }

        public Criteria andNo39In(List<Float> values) {
            addCriterion("No39 in", values, "no39");
            return (Criteria) this;
        }

        public Criteria andNo39NotIn(List<Float> values) {
            addCriterion("No39 not in", values, "no39");
            return (Criteria) this;
        }

        public Criteria andNo39Between(Float value1, Float value2) {
            addCriterion("No39 between", value1, value2, "no39");
            return (Criteria) this;
        }

        public Criteria andNo39NotBetween(Float value1, Float value2) {
            addCriterion("No39 not between", value1, value2, "no39");
            return (Criteria) this;
        }

        public Criteria andNo40IsNull() {
            addCriterion("No40 is null");
            return (Criteria) this;
        }

        public Criteria andNo40IsNotNull() {
            addCriterion("No40 is not null");
            return (Criteria) this;
        }

        public Criteria andNo40EqualTo(Float value) {
            addCriterion("No40 =", value, "no40");
            return (Criteria) this;
        }

        public Criteria andNo40NotEqualTo(Float value) {
            addCriterion("No40 <>", value, "no40");
            return (Criteria) this;
        }

        public Criteria andNo40GreaterThan(Float value) {
            addCriterion("No40 >", value, "no40");
            return (Criteria) this;
        }

        public Criteria andNo40GreaterThanOrEqualTo(Float value) {
            addCriterion("No40 >=", value, "no40");
            return (Criteria) this;
        }

        public Criteria andNo40LessThan(Float value) {
            addCriterion("No40 <", value, "no40");
            return (Criteria) this;
        }

        public Criteria andNo40LessThanOrEqualTo(Float value) {
            addCriterion("No40 <=", value, "no40");
            return (Criteria) this;
        }

        public Criteria andNo40In(List<Float> values) {
            addCriterion("No40 in", values, "no40");
            return (Criteria) this;
        }

        public Criteria andNo40NotIn(List<Float> values) {
            addCriterion("No40 not in", values, "no40");
            return (Criteria) this;
        }

        public Criteria andNo40Between(Float value1, Float value2) {
            addCriterion("No40 between", value1, value2, "no40");
            return (Criteria) this;
        }

        public Criteria andNo40NotBetween(Float value1, Float value2) {
            addCriterion("No40 not between", value1, value2, "no40");
            return (Criteria) this;
        }

        public Criteria andNo41IsNull() {
            addCriterion("No41 is null");
            return (Criteria) this;
        }

        public Criteria andNo41IsNotNull() {
            addCriterion("No41 is not null");
            return (Criteria) this;
        }

        public Criteria andNo41EqualTo(Float value) {
            addCriterion("No41 =", value, "no41");
            return (Criteria) this;
        }

        public Criteria andNo41NotEqualTo(Float value) {
            addCriterion("No41 <>", value, "no41");
            return (Criteria) this;
        }

        public Criteria andNo41GreaterThan(Float value) {
            addCriterion("No41 >", value, "no41");
            return (Criteria) this;
        }

        public Criteria andNo41GreaterThanOrEqualTo(Float value) {
            addCriterion("No41 >=", value, "no41");
            return (Criteria) this;
        }

        public Criteria andNo41LessThan(Float value) {
            addCriterion("No41 <", value, "no41");
            return (Criteria) this;
        }

        public Criteria andNo41LessThanOrEqualTo(Float value) {
            addCriterion("No41 <=", value, "no41");
            return (Criteria) this;
        }

        public Criteria andNo41In(List<Float> values) {
            addCriterion("No41 in", values, "no41");
            return (Criteria) this;
        }

        public Criteria andNo41NotIn(List<Float> values) {
            addCriterion("No41 not in", values, "no41");
            return (Criteria) this;
        }

        public Criteria andNo41Between(Float value1, Float value2) {
            addCriterion("No41 between", value1, value2, "no41");
            return (Criteria) this;
        }

        public Criteria andNo41NotBetween(Float value1, Float value2) {
            addCriterion("No41 not between", value1, value2, "no41");
            return (Criteria) this;
        }

        public Criteria andNo42IsNull() {
            addCriterion("No42 is null");
            return (Criteria) this;
        }

        public Criteria andNo42IsNotNull() {
            addCriterion("No42 is not null");
            return (Criteria) this;
        }

        public Criteria andNo42EqualTo(Float value) {
            addCriterion("No42 =", value, "no42");
            return (Criteria) this;
        }

        public Criteria andNo42NotEqualTo(Float value) {
            addCriterion("No42 <>", value, "no42");
            return (Criteria) this;
        }

        public Criteria andNo42GreaterThan(Float value) {
            addCriterion("No42 >", value, "no42");
            return (Criteria) this;
        }

        public Criteria andNo42GreaterThanOrEqualTo(Float value) {
            addCriterion("No42 >=", value, "no42");
            return (Criteria) this;
        }

        public Criteria andNo42LessThan(Float value) {
            addCriterion("No42 <", value, "no42");
            return (Criteria) this;
        }

        public Criteria andNo42LessThanOrEqualTo(Float value) {
            addCriterion("No42 <=", value, "no42");
            return (Criteria) this;
        }

        public Criteria andNo42In(List<Float> values) {
            addCriterion("No42 in", values, "no42");
            return (Criteria) this;
        }

        public Criteria andNo42NotIn(List<Float> values) {
            addCriterion("No42 not in", values, "no42");
            return (Criteria) this;
        }

        public Criteria andNo42Between(Float value1, Float value2) {
            addCriterion("No42 between", value1, value2, "no42");
            return (Criteria) this;
        }

        public Criteria andNo42NotBetween(Float value1, Float value2) {
            addCriterion("No42 not between", value1, value2, "no42");
            return (Criteria) this;
        }

        public Criteria andNo43IsNull() {
            addCriterion("No43 is null");
            return (Criteria) this;
        }

        public Criteria andNo43IsNotNull() {
            addCriterion("No43 is not null");
            return (Criteria) this;
        }

        public Criteria andNo43EqualTo(Float value) {
            addCriterion("No43 =", value, "no43");
            return (Criteria) this;
        }

        public Criteria andNo43NotEqualTo(Float value) {
            addCriterion("No43 <>", value, "no43");
            return (Criteria) this;
        }

        public Criteria andNo43GreaterThan(Float value) {
            addCriterion("No43 >", value, "no43");
            return (Criteria) this;
        }

        public Criteria andNo43GreaterThanOrEqualTo(Float value) {
            addCriterion("No43 >=", value, "no43");
            return (Criteria) this;
        }

        public Criteria andNo43LessThan(Float value) {
            addCriterion("No43 <", value, "no43");
            return (Criteria) this;
        }

        public Criteria andNo43LessThanOrEqualTo(Float value) {
            addCriterion("No43 <=", value, "no43");
            return (Criteria) this;
        }

        public Criteria andNo43In(List<Float> values) {
            addCriterion("No43 in", values, "no43");
            return (Criteria) this;
        }

        public Criteria andNo43NotIn(List<Float> values) {
            addCriterion("No43 not in", values, "no43");
            return (Criteria) this;
        }

        public Criteria andNo43Between(Float value1, Float value2) {
            addCriterion("No43 between", value1, value2, "no43");
            return (Criteria) this;
        }

        public Criteria andNo43NotBetween(Float value1, Float value2) {
            addCriterion("No43 not between", value1, value2, "no43");
            return (Criteria) this;
        }

        public Criteria andNo44IsNull() {
            addCriterion("No44 is null");
            return (Criteria) this;
        }

        public Criteria andNo44IsNotNull() {
            addCriterion("No44 is not null");
            return (Criteria) this;
        }

        public Criteria andNo44EqualTo(Float value) {
            addCriterion("No44 =", value, "no44");
            return (Criteria) this;
        }

        public Criteria andNo44NotEqualTo(Float value) {
            addCriterion("No44 <>", value, "no44");
            return (Criteria) this;
        }

        public Criteria andNo44GreaterThan(Float value) {
            addCriterion("No44 >", value, "no44");
            return (Criteria) this;
        }

        public Criteria andNo44GreaterThanOrEqualTo(Float value) {
            addCriterion("No44 >=", value, "no44");
            return (Criteria) this;
        }

        public Criteria andNo44LessThan(Float value) {
            addCriterion("No44 <", value, "no44");
            return (Criteria) this;
        }

        public Criteria andNo44LessThanOrEqualTo(Float value) {
            addCriterion("No44 <=", value, "no44");
            return (Criteria) this;
        }

        public Criteria andNo44In(List<Float> values) {
            addCriterion("No44 in", values, "no44");
            return (Criteria) this;
        }

        public Criteria andNo44NotIn(List<Float> values) {
            addCriterion("No44 not in", values, "no44");
            return (Criteria) this;
        }

        public Criteria andNo44Between(Float value1, Float value2) {
            addCriterion("No44 between", value1, value2, "no44");
            return (Criteria) this;
        }

        public Criteria andNo44NotBetween(Float value1, Float value2) {
            addCriterion("No44 not between", value1, value2, "no44");
            return (Criteria) this;
        }

        public Criteria andNo45IsNull() {
            addCriterion("No45 is null");
            return (Criteria) this;
        }

        public Criteria andNo45IsNotNull() {
            addCriterion("No45 is not null");
            return (Criteria) this;
        }

        public Criteria andNo45EqualTo(Float value) {
            addCriterion("No45 =", value, "no45");
            return (Criteria) this;
        }

        public Criteria andNo45NotEqualTo(Float value) {
            addCriterion("No45 <>", value, "no45");
            return (Criteria) this;
        }

        public Criteria andNo45GreaterThan(Float value) {
            addCriterion("No45 >", value, "no45");
            return (Criteria) this;
        }

        public Criteria andNo45GreaterThanOrEqualTo(Float value) {
            addCriterion("No45 >=", value, "no45");
            return (Criteria) this;
        }

        public Criteria andNo45LessThan(Float value) {
            addCriterion("No45 <", value, "no45");
            return (Criteria) this;
        }

        public Criteria andNo45LessThanOrEqualTo(Float value) {
            addCriterion("No45 <=", value, "no45");
            return (Criteria) this;
        }

        public Criteria andNo45In(List<Float> values) {
            addCriterion("No45 in", values, "no45");
            return (Criteria) this;
        }

        public Criteria andNo45NotIn(List<Float> values) {
            addCriterion("No45 not in", values, "no45");
            return (Criteria) this;
        }

        public Criteria andNo45Between(Float value1, Float value2) {
            addCriterion("No45 between", value1, value2, "no45");
            return (Criteria) this;
        }

        public Criteria andNo45NotBetween(Float value1, Float value2) {
            addCriterion("No45 not between", value1, value2, "no45");
            return (Criteria) this;
        }

        public Criteria andNo46IsNull() {
            addCriterion("No46 is null");
            return (Criteria) this;
        }

        public Criteria andNo46IsNotNull() {
            addCriterion("No46 is not null");
            return (Criteria) this;
        }

        public Criteria andNo46EqualTo(Float value) {
            addCriterion("No46 =", value, "no46");
            return (Criteria) this;
        }

        public Criteria andNo46NotEqualTo(Float value) {
            addCriterion("No46 <>", value, "no46");
            return (Criteria) this;
        }

        public Criteria andNo46GreaterThan(Float value) {
            addCriterion("No46 >", value, "no46");
            return (Criteria) this;
        }

        public Criteria andNo46GreaterThanOrEqualTo(Float value) {
            addCriterion("No46 >=", value, "no46");
            return (Criteria) this;
        }

        public Criteria andNo46LessThan(Float value) {
            addCriterion("No46 <", value, "no46");
            return (Criteria) this;
        }

        public Criteria andNo46LessThanOrEqualTo(Float value) {
            addCriterion("No46 <=", value, "no46");
            return (Criteria) this;
        }

        public Criteria andNo46In(List<Float> values) {
            addCriterion("No46 in", values, "no46");
            return (Criteria) this;
        }

        public Criteria andNo46NotIn(List<Float> values) {
            addCriterion("No46 not in", values, "no46");
            return (Criteria) this;
        }

        public Criteria andNo46Between(Float value1, Float value2) {
            addCriterion("No46 between", value1, value2, "no46");
            return (Criteria) this;
        }

        public Criteria andNo46NotBetween(Float value1, Float value2) {
            addCriterion("No46 not between", value1, value2, "no46");
            return (Criteria) this;
        }

        public Criteria andNo47IsNull() {
            addCriterion("No47 is null");
            return (Criteria) this;
        }

        public Criteria andNo47IsNotNull() {
            addCriterion("No47 is not null");
            return (Criteria) this;
        }

        public Criteria andNo47EqualTo(Float value) {
            addCriterion("No47 =", value, "no47");
            return (Criteria) this;
        }

        public Criteria andNo47NotEqualTo(Float value) {
            addCriterion("No47 <>", value, "no47");
            return (Criteria) this;
        }

        public Criteria andNo47GreaterThan(Float value) {
            addCriterion("No47 >", value, "no47");
            return (Criteria) this;
        }

        public Criteria andNo47GreaterThanOrEqualTo(Float value) {
            addCriterion("No47 >=", value, "no47");
            return (Criteria) this;
        }

        public Criteria andNo47LessThan(Float value) {
            addCriterion("No47 <", value, "no47");
            return (Criteria) this;
        }

        public Criteria andNo47LessThanOrEqualTo(Float value) {
            addCriterion("No47 <=", value, "no47");
            return (Criteria) this;
        }

        public Criteria andNo47In(List<Float> values) {
            addCriterion("No47 in", values, "no47");
            return (Criteria) this;
        }

        public Criteria andNo47NotIn(List<Float> values) {
            addCriterion("No47 not in", values, "no47");
            return (Criteria) this;
        }

        public Criteria andNo47Between(Float value1, Float value2) {
            addCriterion("No47 between", value1, value2, "no47");
            return (Criteria) this;
        }

        public Criteria andNo47NotBetween(Float value1, Float value2) {
            addCriterion("No47 not between", value1, value2, "no47");
            return (Criteria) this;
        }

        public Criteria andNo48IsNull() {
            addCriterion("No48 is null");
            return (Criteria) this;
        }

        public Criteria andNo48IsNotNull() {
            addCriterion("No48 is not null");
            return (Criteria) this;
        }

        public Criteria andNo48EqualTo(Float value) {
            addCriterion("No48 =", value, "no48");
            return (Criteria) this;
        }

        public Criteria andNo48NotEqualTo(Float value) {
            addCriterion("No48 <>", value, "no48");
            return (Criteria) this;
        }

        public Criteria andNo48GreaterThan(Float value) {
            addCriterion("No48 >", value, "no48");
            return (Criteria) this;
        }

        public Criteria andNo48GreaterThanOrEqualTo(Float value) {
            addCriterion("No48 >=", value, "no48");
            return (Criteria) this;
        }

        public Criteria andNo48LessThan(Float value) {
            addCriterion("No48 <", value, "no48");
            return (Criteria) this;
        }

        public Criteria andNo48LessThanOrEqualTo(Float value) {
            addCriterion("No48 <=", value, "no48");
            return (Criteria) this;
        }

        public Criteria andNo48In(List<Float> values) {
            addCriterion("No48 in", values, "no48");
            return (Criteria) this;
        }

        public Criteria andNo48NotIn(List<Float> values) {
            addCriterion("No48 not in", values, "no48");
            return (Criteria) this;
        }

        public Criteria andNo48Between(Float value1, Float value2) {
            addCriterion("No48 between", value1, value2, "no48");
            return (Criteria) this;
        }

        public Criteria andNo48NotBetween(Float value1, Float value2) {
            addCriterion("No48 not between", value1, value2, "no48");
            return (Criteria) this;
        }

        public Criteria andNo49IsNull() {
            addCriterion("No49 is null");
            return (Criteria) this;
        }

        public Criteria andNo49IsNotNull() {
            addCriterion("No49 is not null");
            return (Criteria) this;
        }

        public Criteria andNo49EqualTo(Float value) {
            addCriterion("No49 =", value, "no49");
            return (Criteria) this;
        }

        public Criteria andNo49NotEqualTo(Float value) {
            addCriterion("No49 <>", value, "no49");
            return (Criteria) this;
        }

        public Criteria andNo49GreaterThan(Float value) {
            addCriterion("No49 >", value, "no49");
            return (Criteria) this;
        }

        public Criteria andNo49GreaterThanOrEqualTo(Float value) {
            addCriterion("No49 >=", value, "no49");
            return (Criteria) this;
        }

        public Criteria andNo49LessThan(Float value) {
            addCriterion("No49 <", value, "no49");
            return (Criteria) this;
        }

        public Criteria andNo49LessThanOrEqualTo(Float value) {
            addCriterion("No49 <=", value, "no49");
            return (Criteria) this;
        }

        public Criteria andNo49In(List<Float> values) {
            addCriterion("No49 in", values, "no49");
            return (Criteria) this;
        }

        public Criteria andNo49NotIn(List<Float> values) {
            addCriterion("No49 not in", values, "no49");
            return (Criteria) this;
        }

        public Criteria andNo49Between(Float value1, Float value2) {
            addCriterion("No49 between", value1, value2, "no49");
            return (Criteria) this;
        }

        public Criteria andNo49NotBetween(Float value1, Float value2) {
            addCriterion("No49 not between", value1, value2, "no49");
            return (Criteria) this;
        }

        public Criteria andDanIsNull() {
            addCriterion("Dan is null");
            return (Criteria) this;
        }

        public Criteria andDanIsNotNull() {
            addCriterion("Dan is not null");
            return (Criteria) this;
        }

        public Criteria andDanEqualTo(Float value) {
            addCriterion("Dan =", value, "dan");
            return (Criteria) this;
        }

        public Criteria andDanNotEqualTo(Float value) {
            addCriterion("Dan <>", value, "dan");
            return (Criteria) this;
        }

        public Criteria andDanGreaterThan(Float value) {
            addCriterion("Dan >", value, "dan");
            return (Criteria) this;
        }

        public Criteria andDanGreaterThanOrEqualTo(Float value) {
            addCriterion("Dan >=", value, "dan");
            return (Criteria) this;
        }

        public Criteria andDanLessThan(Float value) {
            addCriterion("Dan <", value, "dan");
            return (Criteria) this;
        }

        public Criteria andDanLessThanOrEqualTo(Float value) {
            addCriterion("Dan <=", value, "dan");
            return (Criteria) this;
        }

        public Criteria andDanIn(List<Float> values) {
            addCriterion("Dan in", values, "dan");
            return (Criteria) this;
        }

        public Criteria andDanNotIn(List<Float> values) {
            addCriterion("Dan not in", values, "dan");
            return (Criteria) this;
        }

        public Criteria andDanBetween(Float value1, Float value2) {
            addCriterion("Dan between", value1, value2, "dan");
            return (Criteria) this;
        }

        public Criteria andDanNotBetween(Float value1, Float value2) {
            addCriterion("Dan not between", value1, value2, "dan");
            return (Criteria) this;
        }

        public Criteria andShuangIsNull() {
            addCriterion("Shuang is null");
            return (Criteria) this;
        }

        public Criteria andShuangIsNotNull() {
            addCriterion("Shuang is not null");
            return (Criteria) this;
        }

        public Criteria andShuangEqualTo(Float value) {
            addCriterion("Shuang =", value, "shuang");
            return (Criteria) this;
        }

        public Criteria andShuangNotEqualTo(Float value) {
            addCriterion("Shuang <>", value, "shuang");
            return (Criteria) this;
        }

        public Criteria andShuangGreaterThan(Float value) {
            addCriterion("Shuang >", value, "shuang");
            return (Criteria) this;
        }

        public Criteria andShuangGreaterThanOrEqualTo(Float value) {
            addCriterion("Shuang >=", value, "shuang");
            return (Criteria) this;
        }

        public Criteria andShuangLessThan(Float value) {
            addCriterion("Shuang <", value, "shuang");
            return (Criteria) this;
        }

        public Criteria andShuangLessThanOrEqualTo(Float value) {
            addCriterion("Shuang <=", value, "shuang");
            return (Criteria) this;
        }

        public Criteria andShuangIn(List<Float> values) {
            addCriterion("Shuang in", values, "shuang");
            return (Criteria) this;
        }

        public Criteria andShuangNotIn(List<Float> values) {
            addCriterion("Shuang not in", values, "shuang");
            return (Criteria) this;
        }

        public Criteria andShuangBetween(Float value1, Float value2) {
            addCriterion("Shuang between", value1, value2, "shuang");
            return (Criteria) this;
        }

        public Criteria andShuangNotBetween(Float value1, Float value2) {
            addCriterion("Shuang not between", value1, value2, "shuang");
            return (Criteria) this;
        }

        public Criteria andDaIsNull() {
            addCriterion("Da is null");
            return (Criteria) this;
        }

        public Criteria andDaIsNotNull() {
            addCriterion("Da is not null");
            return (Criteria) this;
        }

        public Criteria andDaEqualTo(Float value) {
            addCriterion("Da =", value, "da");
            return (Criteria) this;
        }

        public Criteria andDaNotEqualTo(Float value) {
            addCriterion("Da <>", value, "da");
            return (Criteria) this;
        }

        public Criteria andDaGreaterThan(Float value) {
            addCriterion("Da >", value, "da");
            return (Criteria) this;
        }

        public Criteria andDaGreaterThanOrEqualTo(Float value) {
            addCriterion("Da >=", value, "da");
            return (Criteria) this;
        }

        public Criteria andDaLessThan(Float value) {
            addCriterion("Da <", value, "da");
            return (Criteria) this;
        }

        public Criteria andDaLessThanOrEqualTo(Float value) {
            addCriterion("Da <=", value, "da");
            return (Criteria) this;
        }

        public Criteria andDaIn(List<Float> values) {
            addCriterion("Da in", values, "da");
            return (Criteria) this;
        }

        public Criteria andDaNotIn(List<Float> values) {
            addCriterion("Da not in", values, "da");
            return (Criteria) this;
        }

        public Criteria andDaBetween(Float value1, Float value2) {
            addCriterion("Da between", value1, value2, "da");
            return (Criteria) this;
        }

        public Criteria andDaNotBetween(Float value1, Float value2) {
            addCriterion("Da not between", value1, value2, "da");
            return (Criteria) this;
        }

        public Criteria andXiaoIsNull() {
            addCriterion("Xiao is null");
            return (Criteria) this;
        }

        public Criteria andXiaoIsNotNull() {
            addCriterion("Xiao is not null");
            return (Criteria) this;
        }

        public Criteria andXiaoEqualTo(Float value) {
            addCriterion("Xiao =", value, "xiao");
            return (Criteria) this;
        }

        public Criteria andXiaoNotEqualTo(Float value) {
            addCriterion("Xiao <>", value, "xiao");
            return (Criteria) this;
        }

        public Criteria andXiaoGreaterThan(Float value) {
            addCriterion("Xiao >", value, "xiao");
            return (Criteria) this;
        }

        public Criteria andXiaoGreaterThanOrEqualTo(Float value) {
            addCriterion("Xiao >=", value, "xiao");
            return (Criteria) this;
        }

        public Criteria andXiaoLessThan(Float value) {
            addCriterion("Xiao <", value, "xiao");
            return (Criteria) this;
        }

        public Criteria andXiaoLessThanOrEqualTo(Float value) {
            addCriterion("Xiao <=", value, "xiao");
            return (Criteria) this;
        }

        public Criteria andXiaoIn(List<Float> values) {
            addCriterion("Xiao in", values, "xiao");
            return (Criteria) this;
        }

        public Criteria andXiaoNotIn(List<Float> values) {
            addCriterion("Xiao not in", values, "xiao");
            return (Criteria) this;
        }

        public Criteria andXiaoBetween(Float value1, Float value2) {
            addCriterion("Xiao between", value1, value2, "xiao");
            return (Criteria) this;
        }

        public Criteria andXiaoNotBetween(Float value1, Float value2) {
            addCriterion("Xiao not between", value1, value2, "xiao");
            return (Criteria) this;
        }

        public Criteria andHedanIsNull() {
            addCriterion("HeDan is null");
            return (Criteria) this;
        }

        public Criteria andHedanIsNotNull() {
            addCriterion("HeDan is not null");
            return (Criteria) this;
        }

        public Criteria andHedanEqualTo(Float value) {
            addCriterion("HeDan =", value, "hedan");
            return (Criteria) this;
        }

        public Criteria andHedanNotEqualTo(Float value) {
            addCriterion("HeDan <>", value, "hedan");
            return (Criteria) this;
        }

        public Criteria andHedanGreaterThan(Float value) {
            addCriterion("HeDan >", value, "hedan");
            return (Criteria) this;
        }

        public Criteria andHedanGreaterThanOrEqualTo(Float value) {
            addCriterion("HeDan >=", value, "hedan");
            return (Criteria) this;
        }

        public Criteria andHedanLessThan(Float value) {
            addCriterion("HeDan <", value, "hedan");
            return (Criteria) this;
        }

        public Criteria andHedanLessThanOrEqualTo(Float value) {
            addCriterion("HeDan <=", value, "hedan");
            return (Criteria) this;
        }

        public Criteria andHedanIn(List<Float> values) {
            addCriterion("HeDan in", values, "hedan");
            return (Criteria) this;
        }

        public Criteria andHedanNotIn(List<Float> values) {
            addCriterion("HeDan not in", values, "hedan");
            return (Criteria) this;
        }

        public Criteria andHedanBetween(Float value1, Float value2) {
            addCriterion("HeDan between", value1, value2, "hedan");
            return (Criteria) this;
        }

        public Criteria andHedanNotBetween(Float value1, Float value2) {
            addCriterion("HeDan not between", value1, value2, "hedan");
            return (Criteria) this;
        }

        public Criteria andHeshuangIsNull() {
            addCriterion("HeShuang is null");
            return (Criteria) this;
        }

        public Criteria andHeshuangIsNotNull() {
            addCriterion("HeShuang is not null");
            return (Criteria) this;
        }

        public Criteria andHeshuangEqualTo(Float value) {
            addCriterion("HeShuang =", value, "heshuang");
            return (Criteria) this;
        }

        public Criteria andHeshuangNotEqualTo(Float value) {
            addCriterion("HeShuang <>", value, "heshuang");
            return (Criteria) this;
        }

        public Criteria andHeshuangGreaterThan(Float value) {
            addCriterion("HeShuang >", value, "heshuang");
            return (Criteria) this;
        }

        public Criteria andHeshuangGreaterThanOrEqualTo(Float value) {
            addCriterion("HeShuang >=", value, "heshuang");
            return (Criteria) this;
        }

        public Criteria andHeshuangLessThan(Float value) {
            addCriterion("HeShuang <", value, "heshuang");
            return (Criteria) this;
        }

        public Criteria andHeshuangLessThanOrEqualTo(Float value) {
            addCriterion("HeShuang <=", value, "heshuang");
            return (Criteria) this;
        }

        public Criteria andHeshuangIn(List<Float> values) {
            addCriterion("HeShuang in", values, "heshuang");
            return (Criteria) this;
        }

        public Criteria andHeshuangNotIn(List<Float> values) {
            addCriterion("HeShuang not in", values, "heshuang");
            return (Criteria) this;
        }

        public Criteria andHeshuangBetween(Float value1, Float value2) {
            addCriterion("HeShuang between", value1, value2, "heshuang");
            return (Criteria) this;
        }

        public Criteria andHeshuangNotBetween(Float value1, Float value2) {
            addCriterion("HeShuang not between", value1, value2, "heshuang");
            return (Criteria) this;
        }

        public Criteria andHongboIsNull() {
            addCriterion("HongBo is null");
            return (Criteria) this;
        }

        public Criteria andHongboIsNotNull() {
            addCriterion("HongBo is not null");
            return (Criteria) this;
        }

        public Criteria andHongboEqualTo(Float value) {
            addCriterion("HongBo =", value, "hongbo");
            return (Criteria) this;
        }

        public Criteria andHongboNotEqualTo(Float value) {
            addCriterion("HongBo <>", value, "hongbo");
            return (Criteria) this;
        }

        public Criteria andHongboGreaterThan(Float value) {
            addCriterion("HongBo >", value, "hongbo");
            return (Criteria) this;
        }

        public Criteria andHongboGreaterThanOrEqualTo(Float value) {
            addCriterion("HongBo >=", value, "hongbo");
            return (Criteria) this;
        }

        public Criteria andHongboLessThan(Float value) {
            addCriterion("HongBo <", value, "hongbo");
            return (Criteria) this;
        }

        public Criteria andHongboLessThanOrEqualTo(Float value) {
            addCriterion("HongBo <=", value, "hongbo");
            return (Criteria) this;
        }

        public Criteria andHongboIn(List<Float> values) {
            addCriterion("HongBo in", values, "hongbo");
            return (Criteria) this;
        }

        public Criteria andHongboNotIn(List<Float> values) {
            addCriterion("HongBo not in", values, "hongbo");
            return (Criteria) this;
        }

        public Criteria andHongboBetween(Float value1, Float value2) {
            addCriterion("HongBo between", value1, value2, "hongbo");
            return (Criteria) this;
        }

        public Criteria andHongboNotBetween(Float value1, Float value2) {
            addCriterion("HongBo not between", value1, value2, "hongbo");
            return (Criteria) this;
        }

        public Criteria andLvboIsNull() {
            addCriterion("Lvbo is null");
            return (Criteria) this;
        }

        public Criteria andLvboIsNotNull() {
            addCriterion("Lvbo is not null");
            return (Criteria) this;
        }

        public Criteria andLvboEqualTo(Float value) {
            addCriterion("Lvbo =", value, "lvbo");
            return (Criteria) this;
        }

        public Criteria andLvboNotEqualTo(Float value) {
            addCriterion("Lvbo <>", value, "lvbo");
            return (Criteria) this;
        }

        public Criteria andLvboGreaterThan(Float value) {
            addCriterion("Lvbo >", value, "lvbo");
            return (Criteria) this;
        }

        public Criteria andLvboGreaterThanOrEqualTo(Float value) {
            addCriterion("Lvbo >=", value, "lvbo");
            return (Criteria) this;
        }

        public Criteria andLvboLessThan(Float value) {
            addCriterion("Lvbo <", value, "lvbo");
            return (Criteria) this;
        }

        public Criteria andLvboLessThanOrEqualTo(Float value) {
            addCriterion("Lvbo <=", value, "lvbo");
            return (Criteria) this;
        }

        public Criteria andLvboIn(List<Float> values) {
            addCriterion("Lvbo in", values, "lvbo");
            return (Criteria) this;
        }

        public Criteria andLvboNotIn(List<Float> values) {
            addCriterion("Lvbo not in", values, "lvbo");
            return (Criteria) this;
        }

        public Criteria andLvboBetween(Float value1, Float value2) {
            addCriterion("Lvbo between", value1, value2, "lvbo");
            return (Criteria) this;
        }

        public Criteria andLvboNotBetween(Float value1, Float value2) {
            addCriterion("Lvbo not between", value1, value2, "lvbo");
            return (Criteria) this;
        }

        public Criteria andLanboIsNull() {
            addCriterion("LanBo is null");
            return (Criteria) this;
        }

        public Criteria andLanboIsNotNull() {
            addCriterion("LanBo is not null");
            return (Criteria) this;
        }

        public Criteria andLanboEqualTo(Float value) {
            addCriterion("LanBo =", value, "lanbo");
            return (Criteria) this;
        }

        public Criteria andLanboNotEqualTo(Float value) {
            addCriterion("LanBo <>", value, "lanbo");
            return (Criteria) this;
        }

        public Criteria andLanboGreaterThan(Float value) {
            addCriterion("LanBo >", value, "lanbo");
            return (Criteria) this;
        }

        public Criteria andLanboGreaterThanOrEqualTo(Float value) {
            addCriterion("LanBo >=", value, "lanbo");
            return (Criteria) this;
        }

        public Criteria andLanboLessThan(Float value) {
            addCriterion("LanBo <", value, "lanbo");
            return (Criteria) this;
        }

        public Criteria andLanboLessThanOrEqualTo(Float value) {
            addCriterion("LanBo <=", value, "lanbo");
            return (Criteria) this;
        }

        public Criteria andLanboIn(List<Float> values) {
            addCriterion("LanBo in", values, "lanbo");
            return (Criteria) this;
        }

        public Criteria andLanboNotIn(List<Float> values) {
            addCriterion("LanBo not in", values, "lanbo");
            return (Criteria) this;
        }

        public Criteria andLanboBetween(Float value1, Float value2) {
            addCriterion("LanBo between", value1, value2, "lanbo");
            return (Criteria) this;
        }

        public Criteria andLanboNotBetween(Float value1, Float value2) {
            addCriterion("LanBo not between", value1, value2, "lanbo");
            return (Criteria) this;
        }

        public Criteria andJiaqinIsNull() {
            addCriterion("JiaQin is null");
            return (Criteria) this;
        }

        public Criteria andJiaqinIsNotNull() {
            addCriterion("JiaQin is not null");
            return (Criteria) this;
        }

        public Criteria andJiaqinEqualTo(Float value) {
            addCriterion("JiaQin =", value, "jiaqin");
            return (Criteria) this;
        }

        public Criteria andJiaqinNotEqualTo(Float value) {
            addCriterion("JiaQin <>", value, "jiaqin");
            return (Criteria) this;
        }

        public Criteria andJiaqinGreaterThan(Float value) {
            addCriterion("JiaQin >", value, "jiaqin");
            return (Criteria) this;
        }

        public Criteria andJiaqinGreaterThanOrEqualTo(Float value) {
            addCriterion("JiaQin >=", value, "jiaqin");
            return (Criteria) this;
        }

        public Criteria andJiaqinLessThan(Float value) {
            addCriterion("JiaQin <", value, "jiaqin");
            return (Criteria) this;
        }

        public Criteria andJiaqinLessThanOrEqualTo(Float value) {
            addCriterion("JiaQin <=", value, "jiaqin");
            return (Criteria) this;
        }

        public Criteria andJiaqinIn(List<Float> values) {
            addCriterion("JiaQin in", values, "jiaqin");
            return (Criteria) this;
        }

        public Criteria andJiaqinNotIn(List<Float> values) {
            addCriterion("JiaQin not in", values, "jiaqin");
            return (Criteria) this;
        }

        public Criteria andJiaqinBetween(Float value1, Float value2) {
            addCriterion("JiaQin between", value1, value2, "jiaqin");
            return (Criteria) this;
        }

        public Criteria andJiaqinNotBetween(Float value1, Float value2) {
            addCriterion("JiaQin not between", value1, value2, "jiaqin");
            return (Criteria) this;
        }

        public Criteria andYeshouIsNull() {
            addCriterion("YeShou is null");
            return (Criteria) this;
        }

        public Criteria andYeshouIsNotNull() {
            addCriterion("YeShou is not null");
            return (Criteria) this;
        }

        public Criteria andYeshouEqualTo(Float value) {
            addCriterion("YeShou =", value, "yeshou");
            return (Criteria) this;
        }

        public Criteria andYeshouNotEqualTo(Float value) {
            addCriterion("YeShou <>", value, "yeshou");
            return (Criteria) this;
        }

        public Criteria andYeshouGreaterThan(Float value) {
            addCriterion("YeShou >", value, "yeshou");
            return (Criteria) this;
        }

        public Criteria andYeshouGreaterThanOrEqualTo(Float value) {
            addCriterion("YeShou >=", value, "yeshou");
            return (Criteria) this;
        }

        public Criteria andYeshouLessThan(Float value) {
            addCriterion("YeShou <", value, "yeshou");
            return (Criteria) this;
        }

        public Criteria andYeshouLessThanOrEqualTo(Float value) {
            addCriterion("YeShou <=", value, "yeshou");
            return (Criteria) this;
        }

        public Criteria andYeshouIn(List<Float> values) {
            addCriterion("YeShou in", values, "yeshou");
            return (Criteria) this;
        }

        public Criteria andYeshouNotIn(List<Float> values) {
            addCriterion("YeShou not in", values, "yeshou");
            return (Criteria) this;
        }

        public Criteria andYeshouBetween(Float value1, Float value2) {
            addCriterion("YeShou between", value1, value2, "yeshou");
            return (Criteria) this;
        }

        public Criteria andYeshouNotBetween(Float value1, Float value2) {
            addCriterion("YeShou not between", value1, value2, "yeshou");
            return (Criteria) this;
        }

        public Criteria andHedaIsNull() {
            addCriterion("HeDa is null");
            return (Criteria) this;
        }

        public Criteria andHedaIsNotNull() {
            addCriterion("HeDa is not null");
            return (Criteria) this;
        }

        public Criteria andHedaEqualTo(Float value) {
            addCriterion("HeDa =", value, "heda");
            return (Criteria) this;
        }

        public Criteria andHedaNotEqualTo(Float value) {
            addCriterion("HeDa <>", value, "heda");
            return (Criteria) this;
        }

        public Criteria andHedaGreaterThan(Float value) {
            addCriterion("HeDa >", value, "heda");
            return (Criteria) this;
        }

        public Criteria andHedaGreaterThanOrEqualTo(Float value) {
            addCriterion("HeDa >=", value, "heda");
            return (Criteria) this;
        }

        public Criteria andHedaLessThan(Float value) {
            addCriterion("HeDa <", value, "heda");
            return (Criteria) this;
        }

        public Criteria andHedaLessThanOrEqualTo(Float value) {
            addCriterion("HeDa <=", value, "heda");
            return (Criteria) this;
        }

        public Criteria andHedaIn(List<Float> values) {
            addCriterion("HeDa in", values, "heda");
            return (Criteria) this;
        }

        public Criteria andHedaNotIn(List<Float> values) {
            addCriterion("HeDa not in", values, "heda");
            return (Criteria) this;
        }

        public Criteria andHedaBetween(Float value1, Float value2) {
            addCriterion("HeDa between", value1, value2, "heda");
            return (Criteria) this;
        }

        public Criteria andHedaNotBetween(Float value1, Float value2) {
            addCriterion("HeDa not between", value1, value2, "heda");
            return (Criteria) this;
        }

        public Criteria andHexiaoIsNull() {
            addCriterion("HeXiao is null");
            return (Criteria) this;
        }

        public Criteria andHexiaoIsNotNull() {
            addCriterion("HeXiao is not null");
            return (Criteria) this;
        }

        public Criteria andHexiaoEqualTo(Float value) {
            addCriterion("HeXiao =", value, "hexiao");
            return (Criteria) this;
        }

        public Criteria andHexiaoNotEqualTo(Float value) {
            addCriterion("HeXiao <>", value, "hexiao");
            return (Criteria) this;
        }

        public Criteria andHexiaoGreaterThan(Float value) {
            addCriterion("HeXiao >", value, "hexiao");
            return (Criteria) this;
        }

        public Criteria andHexiaoGreaterThanOrEqualTo(Float value) {
            addCriterion("HeXiao >=", value, "hexiao");
            return (Criteria) this;
        }

        public Criteria andHexiaoLessThan(Float value) {
            addCriterion("HeXiao <", value, "hexiao");
            return (Criteria) this;
        }

        public Criteria andHexiaoLessThanOrEqualTo(Float value) {
            addCriterion("HeXiao <=", value, "hexiao");
            return (Criteria) this;
        }

        public Criteria andHexiaoIn(List<Float> values) {
            addCriterion("HeXiao in", values, "hexiao");
            return (Criteria) this;
        }

        public Criteria andHexiaoNotIn(List<Float> values) {
            addCriterion("HeXiao not in", values, "hexiao");
            return (Criteria) this;
        }

        public Criteria andHexiaoBetween(Float value1, Float value2) {
            addCriterion("HeXiao between", value1, value2, "hexiao");
            return (Criteria) this;
        }

        public Criteria andHexiaoNotBetween(Float value1, Float value2) {
            addCriterion("HeXiao not between", value1, value2, "hexiao");
            return (Criteria) this;
        }

        public Criteria andWeidaIsNull() {
            addCriterion("WeiDa is null");
            return (Criteria) this;
        }

        public Criteria andWeidaIsNotNull() {
            addCriterion("WeiDa is not null");
            return (Criteria) this;
        }

        public Criteria andWeidaEqualTo(Float value) {
            addCriterion("WeiDa =", value, "weida");
            return (Criteria) this;
        }

        public Criteria andWeidaNotEqualTo(Float value) {
            addCriterion("WeiDa <>", value, "weida");
            return (Criteria) this;
        }

        public Criteria andWeidaGreaterThan(Float value) {
            addCriterion("WeiDa >", value, "weida");
            return (Criteria) this;
        }

        public Criteria andWeidaGreaterThanOrEqualTo(Float value) {
            addCriterion("WeiDa >=", value, "weida");
            return (Criteria) this;
        }

        public Criteria andWeidaLessThan(Float value) {
            addCriterion("WeiDa <", value, "weida");
            return (Criteria) this;
        }

        public Criteria andWeidaLessThanOrEqualTo(Float value) {
            addCriterion("WeiDa <=", value, "weida");
            return (Criteria) this;
        }

        public Criteria andWeidaIn(List<Float> values) {
            addCriterion("WeiDa in", values, "weida");
            return (Criteria) this;
        }

        public Criteria andWeidaNotIn(List<Float> values) {
            addCriterion("WeiDa not in", values, "weida");
            return (Criteria) this;
        }

        public Criteria andWeidaBetween(Float value1, Float value2) {
            addCriterion("WeiDa between", value1, value2, "weida");
            return (Criteria) this;
        }

        public Criteria andWeidaNotBetween(Float value1, Float value2) {
            addCriterion("WeiDa not between", value1, value2, "weida");
            return (Criteria) this;
        }

        public Criteria andWeixiaoIsNull() {
            addCriterion("WeiXiao is null");
            return (Criteria) this;
        }

        public Criteria andWeixiaoIsNotNull() {
            addCriterion("WeiXiao is not null");
            return (Criteria) this;
        }

        public Criteria andWeixiaoEqualTo(Float value) {
            addCriterion("WeiXiao =", value, "weixiao");
            return (Criteria) this;
        }

        public Criteria andWeixiaoNotEqualTo(Float value) {
            addCriterion("WeiXiao <>", value, "weixiao");
            return (Criteria) this;
        }

        public Criteria andWeixiaoGreaterThan(Float value) {
            addCriterion("WeiXiao >", value, "weixiao");
            return (Criteria) this;
        }

        public Criteria andWeixiaoGreaterThanOrEqualTo(Float value) {
            addCriterion("WeiXiao >=", value, "weixiao");
            return (Criteria) this;
        }

        public Criteria andWeixiaoLessThan(Float value) {
            addCriterion("WeiXiao <", value, "weixiao");
            return (Criteria) this;
        }

        public Criteria andWeixiaoLessThanOrEqualTo(Float value) {
            addCriterion("WeiXiao <=", value, "weixiao");
            return (Criteria) this;
        }

        public Criteria andWeixiaoIn(List<Float> values) {
            addCriterion("WeiXiao in", values, "weixiao");
            return (Criteria) this;
        }

        public Criteria andWeixiaoNotIn(List<Float> values) {
            addCriterion("WeiXiao not in", values, "weixiao");
            return (Criteria) this;
        }

        public Criteria andWeixiaoBetween(Float value1, Float value2) {
            addCriterion("WeiXiao between", value1, value2, "weixiao");
            return (Criteria) this;
        }

        public Criteria andWeixiaoNotBetween(Float value1, Float value2) {
            addCriterion("WeiXiao not between", value1, value2, "weixiao");
            return (Criteria) this;
        }

        public Criteria andWeidanIsNull() {
            addCriterion("WeiDan is null");
            return (Criteria) this;
        }

        public Criteria andWeidanIsNotNull() {
            addCriterion("WeiDan is not null");
            return (Criteria) this;
        }

        public Criteria andWeidanEqualTo(Float value) {
            addCriterion("WeiDan =", value, "weidan");
            return (Criteria) this;
        }

        public Criteria andWeidanNotEqualTo(Float value) {
            addCriterion("WeiDan <>", value, "weidan");
            return (Criteria) this;
        }

        public Criteria andWeidanGreaterThan(Float value) {
            addCriterion("WeiDan >", value, "weidan");
            return (Criteria) this;
        }

        public Criteria andWeidanGreaterThanOrEqualTo(Float value) {
            addCriterion("WeiDan >=", value, "weidan");
            return (Criteria) this;
        }

        public Criteria andWeidanLessThan(Float value) {
            addCriterion("WeiDan <", value, "weidan");
            return (Criteria) this;
        }

        public Criteria andWeidanLessThanOrEqualTo(Float value) {
            addCriterion("WeiDan <=", value, "weidan");
            return (Criteria) this;
        }

        public Criteria andWeidanIn(List<Float> values) {
            addCriterion("WeiDan in", values, "weidan");
            return (Criteria) this;
        }

        public Criteria andWeidanNotIn(List<Float> values) {
            addCriterion("WeiDan not in", values, "weidan");
            return (Criteria) this;
        }

        public Criteria andWeidanBetween(Float value1, Float value2) {
            addCriterion("WeiDan between", value1, value2, "weidan");
            return (Criteria) this;
        }

        public Criteria andWeidanNotBetween(Float value1, Float value2) {
            addCriterion("WeiDan not between", value1, value2, "weidan");
            return (Criteria) this;
        }

        public Criteria andWeishuangIsNull() {
            addCriterion("WeiShuang is null");
            return (Criteria) this;
        }

        public Criteria andWeishuangIsNotNull() {
            addCriterion("WeiShuang is not null");
            return (Criteria) this;
        }

        public Criteria andWeishuangEqualTo(Float value) {
            addCriterion("WeiShuang =", value, "weishuang");
            return (Criteria) this;
        }

        public Criteria andWeishuangNotEqualTo(Float value) {
            addCriterion("WeiShuang <>", value, "weishuang");
            return (Criteria) this;
        }

        public Criteria andWeishuangGreaterThan(Float value) {
            addCriterion("WeiShuang >", value, "weishuang");
            return (Criteria) this;
        }

        public Criteria andWeishuangGreaterThanOrEqualTo(Float value) {
            addCriterion("WeiShuang >=", value, "weishuang");
            return (Criteria) this;
        }

        public Criteria andWeishuangLessThan(Float value) {
            addCriterion("WeiShuang <", value, "weishuang");
            return (Criteria) this;
        }

        public Criteria andWeishuangLessThanOrEqualTo(Float value) {
            addCriterion("WeiShuang <=", value, "weishuang");
            return (Criteria) this;
        }

        public Criteria andWeishuangIn(List<Float> values) {
            addCriterion("WeiShuang in", values, "weishuang");
            return (Criteria) this;
        }

        public Criteria andWeishuangNotIn(List<Float> values) {
            addCriterion("WeiShuang not in", values, "weishuang");
            return (Criteria) this;
        }

        public Criteria andWeishuangBetween(Float value1, Float value2) {
            addCriterion("WeiShuang between", value1, value2, "weishuang");
            return (Criteria) this;
        }

        public Criteria andWeishuangNotBetween(Float value1, Float value2) {
            addCriterion("WeiShuang not between", value1, value2, "weishuang");
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