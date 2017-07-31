package com.yunfang.inquiry.entity1;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HandicapExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HandicapExample() {
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

        public Criteria andQishuIsNull() {
            addCriterion("QiShu is null");
            return (Criteria) this;
        }

        public Criteria andQishuIsNotNull() {
            addCriterion("QiShu is not null");
            return (Criteria) this;
        }

        public Criteria andQishuEqualTo(String value) {
            addCriterion("QiShu =", value, "qishu");
            return (Criteria) this;
        }

        public Criteria andQishuNotEqualTo(String value) {
            addCriterion("QiShu <>", value, "qishu");
            return (Criteria) this;
        }

        public Criteria andQishuGreaterThan(String value) {
            addCriterion("QiShu >", value, "qishu");
            return (Criteria) this;
        }

        public Criteria andQishuGreaterThanOrEqualTo(String value) {
            addCriterion("QiShu >=", value, "qishu");
            return (Criteria) this;
        }

        public Criteria andQishuLessThan(String value) {
            addCriterion("QiShu <", value, "qishu");
            return (Criteria) this;
        }

        public Criteria andQishuLessThanOrEqualTo(String value) {
            addCriterion("QiShu <=", value, "qishu");
            return (Criteria) this;
        }

        public Criteria andQishuLike(String value) {
            addCriterion("QiShu like", value, "qishu");
            return (Criteria) this;
        }

        public Criteria andQishuNotLike(String value) {
            addCriterion("QiShu not like", value, "qishu");
            return (Criteria) this;
        }

        public Criteria andQishuIn(List<String> values) {
            addCriterion("QiShu in", values, "qishu");
            return (Criteria) this;
        }

        public Criteria andQishuNotIn(List<String> values) {
            addCriterion("QiShu not in", values, "qishu");
            return (Criteria) this;
        }

        public Criteria andQishuBetween(String value1, String value2) {
            addCriterion("QiShu between", value1, value2, "qishu");
            return (Criteria) this;
        }

        public Criteria andQishuNotBetween(String value1, String value2) {
            addCriterion("QiShu not between", value1, value2, "qishu");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("Status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("Status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Byte value) {
            addCriterion("Status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Byte value) {
            addCriterion("Status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Byte value) {
            addCriterion("Status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("Status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Byte value) {
            addCriterion("Status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Byte value) {
            addCriterion("Status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Byte> values) {
            addCriterion("Status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Byte> values) {
            addCriterion("Status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Byte value1, Byte value2) {
            addCriterion("Status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("Status not between", value1, value2, "status");
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

        public Criteria andNo1EqualTo(Integer value) {
            addCriterion("No1 =", value, "no1");
            return (Criteria) this;
        }

        public Criteria andNo1NotEqualTo(Integer value) {
            addCriterion("No1 <>", value, "no1");
            return (Criteria) this;
        }

        public Criteria andNo1GreaterThan(Integer value) {
            addCriterion("No1 >", value, "no1");
            return (Criteria) this;
        }

        public Criteria andNo1GreaterThanOrEqualTo(Integer value) {
            addCriterion("No1 >=", value, "no1");
            return (Criteria) this;
        }

        public Criteria andNo1LessThan(Integer value) {
            addCriterion("No1 <", value, "no1");
            return (Criteria) this;
        }

        public Criteria andNo1LessThanOrEqualTo(Integer value) {
            addCriterion("No1 <=", value, "no1");
            return (Criteria) this;
        }

        public Criteria andNo1In(List<Integer> values) {
            addCriterion("No1 in", values, "no1");
            return (Criteria) this;
        }

        public Criteria andNo1NotIn(List<Integer> values) {
            addCriterion("No1 not in", values, "no1");
            return (Criteria) this;
        }

        public Criteria andNo1Between(Integer value1, Integer value2) {
            addCriterion("No1 between", value1, value2, "no1");
            return (Criteria) this;
        }

        public Criteria andNo1NotBetween(Integer value1, Integer value2) {
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

        public Criteria andNo2EqualTo(Integer value) {
            addCriterion("No2 =", value, "no2");
            return (Criteria) this;
        }

        public Criteria andNo2NotEqualTo(Integer value) {
            addCriterion("No2 <>", value, "no2");
            return (Criteria) this;
        }

        public Criteria andNo2GreaterThan(Integer value) {
            addCriterion("No2 >", value, "no2");
            return (Criteria) this;
        }

        public Criteria andNo2GreaterThanOrEqualTo(Integer value) {
            addCriterion("No2 >=", value, "no2");
            return (Criteria) this;
        }

        public Criteria andNo2LessThan(Integer value) {
            addCriterion("No2 <", value, "no2");
            return (Criteria) this;
        }

        public Criteria andNo2LessThanOrEqualTo(Integer value) {
            addCriterion("No2 <=", value, "no2");
            return (Criteria) this;
        }

        public Criteria andNo2In(List<Integer> values) {
            addCriterion("No2 in", values, "no2");
            return (Criteria) this;
        }

        public Criteria andNo2NotIn(List<Integer> values) {
            addCriterion("No2 not in", values, "no2");
            return (Criteria) this;
        }

        public Criteria andNo2Between(Integer value1, Integer value2) {
            addCriterion("No2 between", value1, value2, "no2");
            return (Criteria) this;
        }

        public Criteria andNo2NotBetween(Integer value1, Integer value2) {
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

        public Criteria andNo3EqualTo(Integer value) {
            addCriterion("No3 =", value, "no3");
            return (Criteria) this;
        }

        public Criteria andNo3NotEqualTo(Integer value) {
            addCriterion("No3 <>", value, "no3");
            return (Criteria) this;
        }

        public Criteria andNo3GreaterThan(Integer value) {
            addCriterion("No3 >", value, "no3");
            return (Criteria) this;
        }

        public Criteria andNo3GreaterThanOrEqualTo(Integer value) {
            addCriterion("No3 >=", value, "no3");
            return (Criteria) this;
        }

        public Criteria andNo3LessThan(Integer value) {
            addCriterion("No3 <", value, "no3");
            return (Criteria) this;
        }

        public Criteria andNo3LessThanOrEqualTo(Integer value) {
            addCriterion("No3 <=", value, "no3");
            return (Criteria) this;
        }

        public Criteria andNo3In(List<Integer> values) {
            addCriterion("No3 in", values, "no3");
            return (Criteria) this;
        }

        public Criteria andNo3NotIn(List<Integer> values) {
            addCriterion("No3 not in", values, "no3");
            return (Criteria) this;
        }

        public Criteria andNo3Between(Integer value1, Integer value2) {
            addCriterion("No3 between", value1, value2, "no3");
            return (Criteria) this;
        }

        public Criteria andNo3NotBetween(Integer value1, Integer value2) {
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

        public Criteria andNo4EqualTo(Integer value) {
            addCriterion("No4 =", value, "no4");
            return (Criteria) this;
        }

        public Criteria andNo4NotEqualTo(Integer value) {
            addCriterion("No4 <>", value, "no4");
            return (Criteria) this;
        }

        public Criteria andNo4GreaterThan(Integer value) {
            addCriterion("No4 >", value, "no4");
            return (Criteria) this;
        }

        public Criteria andNo4GreaterThanOrEqualTo(Integer value) {
            addCriterion("No4 >=", value, "no4");
            return (Criteria) this;
        }

        public Criteria andNo4LessThan(Integer value) {
            addCriterion("No4 <", value, "no4");
            return (Criteria) this;
        }

        public Criteria andNo4LessThanOrEqualTo(Integer value) {
            addCriterion("No4 <=", value, "no4");
            return (Criteria) this;
        }

        public Criteria andNo4In(List<Integer> values) {
            addCriterion("No4 in", values, "no4");
            return (Criteria) this;
        }

        public Criteria andNo4NotIn(List<Integer> values) {
            addCriterion("No4 not in", values, "no4");
            return (Criteria) this;
        }

        public Criteria andNo4Between(Integer value1, Integer value2) {
            addCriterion("No4 between", value1, value2, "no4");
            return (Criteria) this;
        }

        public Criteria andNo4NotBetween(Integer value1, Integer value2) {
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

        public Criteria andNo5EqualTo(Integer value) {
            addCriterion("No5 =", value, "no5");
            return (Criteria) this;
        }

        public Criteria andNo5NotEqualTo(Integer value) {
            addCriterion("No5 <>", value, "no5");
            return (Criteria) this;
        }

        public Criteria andNo5GreaterThan(Integer value) {
            addCriterion("No5 >", value, "no5");
            return (Criteria) this;
        }

        public Criteria andNo5GreaterThanOrEqualTo(Integer value) {
            addCriterion("No5 >=", value, "no5");
            return (Criteria) this;
        }

        public Criteria andNo5LessThan(Integer value) {
            addCriterion("No5 <", value, "no5");
            return (Criteria) this;
        }

        public Criteria andNo5LessThanOrEqualTo(Integer value) {
            addCriterion("No5 <=", value, "no5");
            return (Criteria) this;
        }

        public Criteria andNo5In(List<Integer> values) {
            addCriterion("No5 in", values, "no5");
            return (Criteria) this;
        }

        public Criteria andNo5NotIn(List<Integer> values) {
            addCriterion("No5 not in", values, "no5");
            return (Criteria) this;
        }

        public Criteria andNo5Between(Integer value1, Integer value2) {
            addCriterion("No5 between", value1, value2, "no5");
            return (Criteria) this;
        }

        public Criteria andNo5NotBetween(Integer value1, Integer value2) {
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

        public Criteria andNo6EqualTo(Integer value) {
            addCriterion("No6 =", value, "no6");
            return (Criteria) this;
        }

        public Criteria andNo6NotEqualTo(Integer value) {
            addCriterion("No6 <>", value, "no6");
            return (Criteria) this;
        }

        public Criteria andNo6GreaterThan(Integer value) {
            addCriterion("No6 >", value, "no6");
            return (Criteria) this;
        }

        public Criteria andNo6GreaterThanOrEqualTo(Integer value) {
            addCriterion("No6 >=", value, "no6");
            return (Criteria) this;
        }

        public Criteria andNo6LessThan(Integer value) {
            addCriterion("No6 <", value, "no6");
            return (Criteria) this;
        }

        public Criteria andNo6LessThanOrEqualTo(Integer value) {
            addCriterion("No6 <=", value, "no6");
            return (Criteria) this;
        }

        public Criteria andNo6In(List<Integer> values) {
            addCriterion("No6 in", values, "no6");
            return (Criteria) this;
        }

        public Criteria andNo6NotIn(List<Integer> values) {
            addCriterion("No6 not in", values, "no6");
            return (Criteria) this;
        }

        public Criteria andNo6Between(Integer value1, Integer value2) {
            addCriterion("No6 between", value1, value2, "no6");
            return (Criteria) this;
        }

        public Criteria andNo6NotBetween(Integer value1, Integer value2) {
            addCriterion("No6 not between", value1, value2, "no6");
            return (Criteria) this;
        }

        public Criteria andTemaIsNull() {
            addCriterion("Tema is null");
            return (Criteria) this;
        }

        public Criteria andTemaIsNotNull() {
            addCriterion("Tema is not null");
            return (Criteria) this;
        }

        public Criteria andTemaEqualTo(Integer value) {
            addCriterion("Tema =", value, "tema");
            return (Criteria) this;
        }

        public Criteria andTemaNotEqualTo(Integer value) {
            addCriterion("Tema <>", value, "tema");
            return (Criteria) this;
        }

        public Criteria andTemaGreaterThan(Integer value) {
            addCriterion("Tema >", value, "tema");
            return (Criteria) this;
        }

        public Criteria andTemaGreaterThanOrEqualTo(Integer value) {
            addCriterion("Tema >=", value, "tema");
            return (Criteria) this;
        }

        public Criteria andTemaLessThan(Integer value) {
            addCriterion("Tema <", value, "tema");
            return (Criteria) this;
        }

        public Criteria andTemaLessThanOrEqualTo(Integer value) {
            addCriterion("Tema <=", value, "tema");
            return (Criteria) this;
        }

        public Criteria andTemaIn(List<Integer> values) {
            addCriterion("Tema in", values, "tema");
            return (Criteria) this;
        }

        public Criteria andTemaNotIn(List<Integer> values) {
            addCriterion("Tema not in", values, "tema");
            return (Criteria) this;
        }

        public Criteria andTemaBetween(Integer value1, Integer value2) {
            addCriterion("Tema between", value1, value2, "tema");
            return (Criteria) this;
        }

        public Criteria andTemaNotBetween(Integer value1, Integer value2) {
            addCriterion("Tema not between", value1, value2, "tema");
            return (Criteria) this;
        }

        public Criteria andOpentimeIsNull() {
            addCriterion("OpenTime is null");
            return (Criteria) this;
        }

        public Criteria andOpentimeIsNotNull() {
            addCriterion("OpenTime is not null");
            return (Criteria) this;
        }

        public Criteria andOpentimeEqualTo(Date value) {
            addCriterion("OpenTime =", value, "opentime");
            return (Criteria) this;
        }

        public Criteria andOpentimeNotEqualTo(Date value) {
            addCriterion("OpenTime <>", value, "opentime");
            return (Criteria) this;
        }

        public Criteria andOpentimeGreaterThan(Date value) {
            addCriterion("OpenTime >", value, "opentime");
            return (Criteria) this;
        }

        public Criteria andOpentimeGreaterThanOrEqualTo(Date value) {
            addCriterion("OpenTime >=", value, "opentime");
            return (Criteria) this;
        }

        public Criteria andOpentimeLessThan(Date value) {
            addCriterion("OpenTime <", value, "opentime");
            return (Criteria) this;
        }

        public Criteria andOpentimeLessThanOrEqualTo(Date value) {
            addCriterion("OpenTime <=", value, "opentime");
            return (Criteria) this;
        }

        public Criteria andOpentimeIn(List<Date> values) {
            addCriterion("OpenTime in", values, "opentime");
            return (Criteria) this;
        }

        public Criteria andOpentimeNotIn(List<Date> values) {
            addCriterion("OpenTime not in", values, "opentime");
            return (Criteria) this;
        }

        public Criteria andOpentimeBetween(Date value1, Date value2) {
            addCriterion("OpenTime between", value1, value2, "opentime");
            return (Criteria) this;
        }

        public Criteria andOpentimeNotBetween(Date value1, Date value2) {
            addCriterion("OpenTime not between", value1, value2, "opentime");
            return (Criteria) this;
        }

        public Criteria andAutoopenIsNull() {
            addCriterion("AutoOpen is null");
            return (Criteria) this;
        }

        public Criteria andAutoopenIsNotNull() {
            addCriterion("AutoOpen is not null");
            return (Criteria) this;
        }

        public Criteria andAutoopenEqualTo(Boolean value) {
            addCriterion("AutoOpen =", value, "autoopen");
            return (Criteria) this;
        }

        public Criteria andAutoopenNotEqualTo(Boolean value) {
            addCriterion("AutoOpen <>", value, "autoopen");
            return (Criteria) this;
        }

        public Criteria andAutoopenGreaterThan(Boolean value) {
            addCriterion("AutoOpen >", value, "autoopen");
            return (Criteria) this;
        }

        public Criteria andAutoopenGreaterThanOrEqualTo(Boolean value) {
            addCriterion("AutoOpen >=", value, "autoopen");
            return (Criteria) this;
        }

        public Criteria andAutoopenLessThan(Boolean value) {
            addCriterion("AutoOpen <", value, "autoopen");
            return (Criteria) this;
        }

        public Criteria andAutoopenLessThanOrEqualTo(Boolean value) {
            addCriterion("AutoOpen <=", value, "autoopen");
            return (Criteria) this;
        }

        public Criteria andAutoopenIn(List<Boolean> values) {
            addCriterion("AutoOpen in", values, "autoopen");
            return (Criteria) this;
        }

        public Criteria andAutoopenNotIn(List<Boolean> values) {
            addCriterion("AutoOpen not in", values, "autoopen");
            return (Criteria) this;
        }

        public Criteria andAutoopenBetween(Boolean value1, Boolean value2) {
            addCriterion("AutoOpen between", value1, value2, "autoopen");
            return (Criteria) this;
        }

        public Criteria andAutoopenNotBetween(Boolean value1, Boolean value2) {
            addCriterion("AutoOpen not between", value1, value2, "autoopen");
            return (Criteria) this;
        }

        public Criteria andTemastatusIsNull() {
            addCriterion("TemaStatus is null");
            return (Criteria) this;
        }

        public Criteria andTemastatusIsNotNull() {
            addCriterion("TemaStatus is not null");
            return (Criteria) this;
        }

        public Criteria andTemastatusEqualTo(Boolean value) {
            addCriterion("TemaStatus =", value, "temastatus");
            return (Criteria) this;
        }

        public Criteria andTemastatusNotEqualTo(Boolean value) {
            addCriterion("TemaStatus <>", value, "temastatus");
            return (Criteria) this;
        }

        public Criteria andTemastatusGreaterThan(Boolean value) {
            addCriterion("TemaStatus >", value, "temastatus");
            return (Criteria) this;
        }

        public Criteria andTemastatusGreaterThanOrEqualTo(Boolean value) {
            addCriterion("TemaStatus >=", value, "temastatus");
            return (Criteria) this;
        }

        public Criteria andTemastatusLessThan(Boolean value) {
            addCriterion("TemaStatus <", value, "temastatus");
            return (Criteria) this;
        }

        public Criteria andTemastatusLessThanOrEqualTo(Boolean value) {
            addCriterion("TemaStatus <=", value, "temastatus");
            return (Criteria) this;
        }

        public Criteria andTemastatusIn(List<Boolean> values) {
            addCriterion("TemaStatus in", values, "temastatus");
            return (Criteria) this;
        }

        public Criteria andTemastatusNotIn(List<Boolean> values) {
            addCriterion("TemaStatus not in", values, "temastatus");
            return (Criteria) this;
        }

        public Criteria andTemastatusBetween(Boolean value1, Boolean value2) {
            addCriterion("TemaStatus between", value1, value2, "temastatus");
            return (Criteria) this;
        }

        public Criteria andTemastatusNotBetween(Boolean value1, Boolean value2) {
            addCriterion("TemaStatus not between", value1, value2, "temastatus");
            return (Criteria) this;
        }

        public Criteria andZhengmastatusIsNull() {
            addCriterion("ZhengmaStatus is null");
            return (Criteria) this;
        }

        public Criteria andZhengmastatusIsNotNull() {
            addCriterion("ZhengmaStatus is not null");
            return (Criteria) this;
        }

        public Criteria andZhengmastatusEqualTo(Boolean value) {
            addCriterion("ZhengmaStatus =", value, "zhengmastatus");
            return (Criteria) this;
        }

        public Criteria andZhengmastatusNotEqualTo(Boolean value) {
            addCriterion("ZhengmaStatus <>", value, "zhengmastatus");
            return (Criteria) this;
        }

        public Criteria andZhengmastatusGreaterThan(Boolean value) {
            addCriterion("ZhengmaStatus >", value, "zhengmastatus");
            return (Criteria) this;
        }

        public Criteria andZhengmastatusGreaterThanOrEqualTo(Boolean value) {
            addCriterion("ZhengmaStatus >=", value, "zhengmastatus");
            return (Criteria) this;
        }

        public Criteria andZhengmastatusLessThan(Boolean value) {
            addCriterion("ZhengmaStatus <", value, "zhengmastatus");
            return (Criteria) this;
        }

        public Criteria andZhengmastatusLessThanOrEqualTo(Boolean value) {
            addCriterion("ZhengmaStatus <=", value, "zhengmastatus");
            return (Criteria) this;
        }

        public Criteria andZhengmastatusIn(List<Boolean> values) {
            addCriterion("ZhengmaStatus in", values, "zhengmastatus");
            return (Criteria) this;
        }

        public Criteria andZhengmastatusNotIn(List<Boolean> values) {
            addCriterion("ZhengmaStatus not in", values, "zhengmastatus");
            return (Criteria) this;
        }

        public Criteria andZhengmastatusBetween(Boolean value1, Boolean value2) {
            addCriterion("ZhengmaStatus between", value1, value2, "zhengmastatus");
            return (Criteria) this;
        }

        public Criteria andZhengmastatusNotBetween(Boolean value1, Boolean value2) {
            addCriterion("ZhengmaStatus not between", value1, value2, "zhengmastatus");
            return (Criteria) this;
        }

        public Criteria andTemaclosetimeIsNull() {
            addCriterion("TemaCloseTime is null");
            return (Criteria) this;
        }

        public Criteria andTemaclosetimeIsNotNull() {
            addCriterion("TemaCloseTime is not null");
            return (Criteria) this;
        }

        public Criteria andTemaclosetimeEqualTo(Date value) {
            addCriterion("TemaCloseTime =", value, "temaclosetime");
            return (Criteria) this;
        }

        public Criteria andTemaclosetimeNotEqualTo(Date value) {
            addCriterion("TemaCloseTime <>", value, "temaclosetime");
            return (Criteria) this;
        }

        public Criteria andTemaclosetimeGreaterThan(Date value) {
            addCriterion("TemaCloseTime >", value, "temaclosetime");
            return (Criteria) this;
        }

        public Criteria andTemaclosetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("TemaCloseTime >=", value, "temaclosetime");
            return (Criteria) this;
        }

        public Criteria andTemaclosetimeLessThan(Date value) {
            addCriterion("TemaCloseTime <", value, "temaclosetime");
            return (Criteria) this;
        }

        public Criteria andTemaclosetimeLessThanOrEqualTo(Date value) {
            addCriterion("TemaCloseTime <=", value, "temaclosetime");
            return (Criteria) this;
        }

        public Criteria andTemaclosetimeIn(List<Date> values) {
            addCriterion("TemaCloseTime in", values, "temaclosetime");
            return (Criteria) this;
        }

        public Criteria andTemaclosetimeNotIn(List<Date> values) {
            addCriterion("TemaCloseTime not in", values, "temaclosetime");
            return (Criteria) this;
        }

        public Criteria andTemaclosetimeBetween(Date value1, Date value2) {
            addCriterion("TemaCloseTime between", value1, value2, "temaclosetime");
            return (Criteria) this;
        }

        public Criteria andTemaclosetimeNotBetween(Date value1, Date value2) {
            addCriterion("TemaCloseTime not between", value1, value2, "temaclosetime");
            return (Criteria) this;
        }

        public Criteria andZhengmaclosetimeIsNull() {
            addCriterion("ZhengmaCloseTime is null");
            return (Criteria) this;
        }

        public Criteria andZhengmaclosetimeIsNotNull() {
            addCriterion("ZhengmaCloseTime is not null");
            return (Criteria) this;
        }

        public Criteria andZhengmaclosetimeEqualTo(Date value) {
            addCriterion("ZhengmaCloseTime =", value, "zhengmaclosetime");
            return (Criteria) this;
        }

        public Criteria andZhengmaclosetimeNotEqualTo(Date value) {
            addCriterion("ZhengmaCloseTime <>", value, "zhengmaclosetime");
            return (Criteria) this;
        }

        public Criteria andZhengmaclosetimeGreaterThan(Date value) {
            addCriterion("ZhengmaCloseTime >", value, "zhengmaclosetime");
            return (Criteria) this;
        }

        public Criteria andZhengmaclosetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("ZhengmaCloseTime >=", value, "zhengmaclosetime");
            return (Criteria) this;
        }

        public Criteria andZhengmaclosetimeLessThan(Date value) {
            addCriterion("ZhengmaCloseTime <", value, "zhengmaclosetime");
            return (Criteria) this;
        }

        public Criteria andZhengmaclosetimeLessThanOrEqualTo(Date value) {
            addCriterion("ZhengmaCloseTime <=", value, "zhengmaclosetime");
            return (Criteria) this;
        }

        public Criteria andZhengmaclosetimeIn(List<Date> values) {
            addCriterion("ZhengmaCloseTime in", values, "zhengmaclosetime");
            return (Criteria) this;
        }

        public Criteria andZhengmaclosetimeNotIn(List<Date> values) {
            addCriterion("ZhengmaCloseTime not in", values, "zhengmaclosetime");
            return (Criteria) this;
        }

        public Criteria andZhengmaclosetimeBetween(Date value1, Date value2) {
            addCriterion("ZhengmaCloseTime between", value1, value2, "zhengmaclosetime");
            return (Criteria) this;
        }

        public Criteria andZhengmaclosetimeNotBetween(Date value1, Date value2) {
            addCriterion("ZhengmaCloseTime not between", value1, value2, "zhengmaclosetime");
            return (Criteria) this;
        }

        public Criteria andIssettlementIsNull() {
            addCriterion("IsSettlement is null");
            return (Criteria) this;
        }

        public Criteria andIssettlementIsNotNull() {
            addCriterion("IsSettlement is not null");
            return (Criteria) this;
        }

        public Criteria andIssettlementEqualTo(Boolean value) {
            addCriterion("IsSettlement =", value, "issettlement");
            return (Criteria) this;
        }

        public Criteria andIssettlementNotEqualTo(Boolean value) {
            addCriterion("IsSettlement <>", value, "issettlement");
            return (Criteria) this;
        }

        public Criteria andIssettlementGreaterThan(Boolean value) {
            addCriterion("IsSettlement >", value, "issettlement");
            return (Criteria) this;
        }

        public Criteria andIssettlementGreaterThanOrEqualTo(Boolean value) {
            addCriterion("IsSettlement >=", value, "issettlement");
            return (Criteria) this;
        }

        public Criteria andIssettlementLessThan(Boolean value) {
            addCriterion("IsSettlement <", value, "issettlement");
            return (Criteria) this;
        }

        public Criteria andIssettlementLessThanOrEqualTo(Boolean value) {
            addCriterion("IsSettlement <=", value, "issettlement");
            return (Criteria) this;
        }

        public Criteria andIssettlementIn(List<Boolean> values) {
            addCriterion("IsSettlement in", values, "issettlement");
            return (Criteria) this;
        }

        public Criteria andIssettlementNotIn(List<Boolean> values) {
            addCriterion("IsSettlement not in", values, "issettlement");
            return (Criteria) this;
        }

        public Criteria andIssettlementBetween(Boolean value1, Boolean value2) {
            addCriterion("IsSettlement between", value1, value2, "issettlement");
            return (Criteria) this;
        }

        public Criteria andIssettlementNotBetween(Boolean value1, Boolean value2) {
            addCriterion("IsSettlement not between", value1, value2, "issettlement");
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