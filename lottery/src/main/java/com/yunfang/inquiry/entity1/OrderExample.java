package com.yunfang.inquiry.entity1;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderExample() {
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

        public Criteria andHandicapidIsNull() {
            addCriterion("HandicapId is null");
            return (Criteria) this;
        }

        public Criteria andHandicapidIsNotNull() {
            addCriterion("HandicapId is not null");
            return (Criteria) this;
        }

        public Criteria andHandicapidEqualTo(String value) {
            addCriterion("HandicapId =", value, "handicapid");
            return (Criteria) this;
        }

        public Criteria andHandicapidNotEqualTo(String value) {
            addCriterion("HandicapId <>", value, "handicapid");
            return (Criteria) this;
        }

        public Criteria andHandicapidGreaterThan(String value) {
            addCriterion("HandicapId >", value, "handicapid");
            return (Criteria) this;
        }

        public Criteria andHandicapidGreaterThanOrEqualTo(String value) {
            addCriterion("HandicapId >=", value, "handicapid");
            return (Criteria) this;
        }

        public Criteria andHandicapidLessThan(String value) {
            addCriterion("HandicapId <", value, "handicapid");
            return (Criteria) this;
        }

        public Criteria andHandicapidLessThanOrEqualTo(String value) {
            addCriterion("HandicapId <=", value, "handicapid");
            return (Criteria) this;
        }

        public Criteria andHandicapidLike(String value) {
            addCriterion("HandicapId like", value, "handicapid");
            return (Criteria) this;
        }

        public Criteria andHandicapidNotLike(String value) {
            addCriterion("HandicapId not like", value, "handicapid");
            return (Criteria) this;
        }

        public Criteria andHandicapidIn(List<String> values) {
            addCriterion("HandicapId in", values, "handicapid");
            return (Criteria) this;
        }

        public Criteria andHandicapidNotIn(List<String> values) {
            addCriterion("HandicapId not in", values, "handicapid");
            return (Criteria) this;
        }

        public Criteria andHandicapidBetween(String value1, String value2) {
            addCriterion("HandicapId between", value1, value2, "handicapid");
            return (Criteria) this;
        }

        public Criteria andHandicapidNotBetween(String value1, String value2) {
            addCriterion("HandicapId not between", value1, value2, "handicapid");
            return (Criteria) this;
        }

        public Criteria andOrdernoIsNull() {
            addCriterion("OrderNo is null");
            return (Criteria) this;
        }

        public Criteria andOrdernoIsNotNull() {
            addCriterion("OrderNo is not null");
            return (Criteria) this;
        }

        public Criteria andOrdernoEqualTo(String value) {
            addCriterion("OrderNo =", value, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoNotEqualTo(String value) {
            addCriterion("OrderNo <>", value, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoGreaterThan(String value) {
            addCriterion("OrderNo >", value, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoGreaterThanOrEqualTo(String value) {
            addCriterion("OrderNo >=", value, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoLessThan(String value) {
            addCriterion("OrderNo <", value, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoLessThanOrEqualTo(String value) {
            addCriterion("OrderNo <=", value, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoLike(String value) {
            addCriterion("OrderNo like", value, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoNotLike(String value) {
            addCriterion("OrderNo not like", value, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoIn(List<String> values) {
            addCriterion("OrderNo in", values, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoNotIn(List<String> values) {
            addCriterion("OrderNo not in", values, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoBetween(String value1, String value2) {
            addCriterion("OrderNo between", value1, value2, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoNotBetween(String value1, String value2) {
            addCriterion("OrderNo not between", value1, value2, "orderno");
            return (Criteria) this;
        }

        public Criteria andHandciapIsNull() {
            addCriterion("Handciap is null");
            return (Criteria) this;
        }

        public Criteria andHandciapIsNotNull() {
            addCriterion("Handciap is not null");
            return (Criteria) this;
        }

        public Criteria andHandciapEqualTo(String value) {
            addCriterion("Handciap =", value, "handciap");
            return (Criteria) this;
        }

        public Criteria andHandciapNotEqualTo(String value) {
            addCriterion("Handciap <>", value, "handciap");
            return (Criteria) this;
        }

        public Criteria andHandciapGreaterThan(String value) {
            addCriterion("Handciap >", value, "handciap");
            return (Criteria) this;
        }

        public Criteria andHandciapGreaterThanOrEqualTo(String value) {
            addCriterion("Handciap >=", value, "handciap");
            return (Criteria) this;
        }

        public Criteria andHandciapLessThan(String value) {
            addCriterion("Handciap <", value, "handciap");
            return (Criteria) this;
        }

        public Criteria andHandciapLessThanOrEqualTo(String value) {
            addCriterion("Handciap <=", value, "handciap");
            return (Criteria) this;
        }

        public Criteria andHandciapLike(String value) {
            addCriterion("Handciap like", value, "handciap");
            return (Criteria) this;
        }

        public Criteria andHandciapNotLike(String value) {
            addCriterion("Handciap not like", value, "handciap");
            return (Criteria) this;
        }

        public Criteria andHandciapIn(List<String> values) {
            addCriterion("Handciap in", values, "handciap");
            return (Criteria) this;
        }

        public Criteria andHandciapNotIn(List<String> values) {
            addCriterion("Handciap not in", values, "handciap");
            return (Criteria) this;
        }

        public Criteria andHandciapBetween(String value1, String value2) {
            addCriterion("Handciap between", value1, value2, "handciap");
            return (Criteria) this;
        }

        public Criteria andHandciapNotBetween(String value1, String value2) {
            addCriterion("Handciap not between", value1, value2, "handciap");
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

        public Criteria andOrdernameIsNull() {
            addCriterion("OrderName is null");
            return (Criteria) this;
        }

        public Criteria andOrdernameIsNotNull() {
            addCriterion("OrderName is not null");
            return (Criteria) this;
        }

        public Criteria andOrdernameEqualTo(String value) {
            addCriterion("OrderName =", value, "ordername");
            return (Criteria) this;
        }

        public Criteria andOrdernameNotEqualTo(String value) {
            addCriterion("OrderName <>", value, "ordername");
            return (Criteria) this;
        }

        public Criteria andOrdernameGreaterThan(String value) {
            addCriterion("OrderName >", value, "ordername");
            return (Criteria) this;
        }

        public Criteria andOrdernameGreaterThanOrEqualTo(String value) {
            addCriterion("OrderName >=", value, "ordername");
            return (Criteria) this;
        }

        public Criteria andOrdernameLessThan(String value) {
            addCriterion("OrderName <", value, "ordername");
            return (Criteria) this;
        }

        public Criteria andOrdernameLessThanOrEqualTo(String value) {
            addCriterion("OrderName <=", value, "ordername");
            return (Criteria) this;
        }

        public Criteria andOrdernameLike(String value) {
            addCriterion("OrderName like", value, "ordername");
            return (Criteria) this;
        }

        public Criteria andOrdernameNotLike(String value) {
            addCriterion("OrderName not like", value, "ordername");
            return (Criteria) this;
        }

        public Criteria andOrdernameIn(List<String> values) {
            addCriterion("OrderName in", values, "ordername");
            return (Criteria) this;
        }

        public Criteria andOrdernameNotIn(List<String> values) {
            addCriterion("OrderName not in", values, "ordername");
            return (Criteria) this;
        }

        public Criteria andOrdernameBetween(String value1, String value2) {
            addCriterion("OrderName between", value1, value2, "ordername");
            return (Criteria) this;
        }

        public Criteria andOrdernameNotBetween(String value1, String value2) {
            addCriterion("OrderName not between", value1, value2, "ordername");
            return (Criteria) this;
        }

        public Criteria andGametypeIsNull() {
            addCriterion("GameType is null");
            return (Criteria) this;
        }

        public Criteria andGametypeIsNotNull() {
            addCriterion("GameType is not null");
            return (Criteria) this;
        }

        public Criteria andGametypeEqualTo(String value) {
            addCriterion("GameType =", value, "gametype");
            return (Criteria) this;
        }

        public Criteria andGametypeNotEqualTo(String value) {
            addCriterion("GameType <>", value, "gametype");
            return (Criteria) this;
        }

        public Criteria andGametypeGreaterThan(String value) {
            addCriterion("GameType >", value, "gametype");
            return (Criteria) this;
        }

        public Criteria andGametypeGreaterThanOrEqualTo(String value) {
            addCriterion("GameType >=", value, "gametype");
            return (Criteria) this;
        }

        public Criteria andGametypeLessThan(String value) {
            addCriterion("GameType <", value, "gametype");
            return (Criteria) this;
        }

        public Criteria andGametypeLessThanOrEqualTo(String value) {
            addCriterion("GameType <=", value, "gametype");
            return (Criteria) this;
        }

        public Criteria andGametypeLike(String value) {
            addCriterion("GameType like", value, "gametype");
            return (Criteria) this;
        }

        public Criteria andGametypeNotLike(String value) {
            addCriterion("GameType not like", value, "gametype");
            return (Criteria) this;
        }

        public Criteria andGametypeIn(List<String> values) {
            addCriterion("GameType in", values, "gametype");
            return (Criteria) this;
        }

        public Criteria andGametypeNotIn(List<String> values) {
            addCriterion("GameType not in", values, "gametype");
            return (Criteria) this;
        }

        public Criteria andGametypeBetween(String value1, String value2) {
            addCriterion("GameType between", value1, value2, "gametype");
            return (Criteria) this;
        }

        public Criteria andGametypeNotBetween(String value1, String value2) {
            addCriterion("GameType not between", value1, value2, "gametype");
            return (Criteria) this;
        }

        public Criteria andNumIsNull() {
            addCriterion("Num is null");
            return (Criteria) this;
        }

        public Criteria andNumIsNotNull() {
            addCriterion("Num is not null");
            return (Criteria) this;
        }

        public Criteria andNumEqualTo(Integer value) {
            addCriterion("Num =", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotEqualTo(Integer value) {
            addCriterion("Num <>", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumGreaterThan(Integer value) {
            addCriterion("Num >", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("Num >=", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumLessThan(Integer value) {
            addCriterion("Num <", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumLessThanOrEqualTo(Integer value) {
            addCriterion("Num <=", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumIn(List<Integer> values) {
            addCriterion("Num in", values, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotIn(List<Integer> values) {
            addCriterion("Num not in", values, "num");
            return (Criteria) this;
        }

        public Criteria andNumBetween(Integer value1, Integer value2) {
            addCriterion("Num between", value1, value2, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotBetween(Integer value1, Integer value2) {
            addCriterion("Num not between", value1, value2, "num");
            return (Criteria) this;
        }

        public Criteria andAmountIsNull() {
            addCriterion("Amount is null");
            return (Criteria) this;
        }

        public Criteria andAmountIsNotNull() {
            addCriterion("Amount is not null");
            return (Criteria) this;
        }

        public Criteria andAmountEqualTo(Integer value) {
            addCriterion("Amount =", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotEqualTo(Integer value) {
            addCriterion("Amount <>", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThan(Integer value) {
            addCriterion("Amount >", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("Amount >=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThan(Integer value) {
            addCriterion("Amount <", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThanOrEqualTo(Integer value) {
            addCriterion("Amount <=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountIn(List<Integer> values) {
            addCriterion("Amount in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotIn(List<Integer> values) {
            addCriterion("Amount not in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountBetween(Integer value1, Integer value2) {
            addCriterion("Amount between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("Amount not between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andOddsIsNull() {
            addCriterion("Odds is null");
            return (Criteria) this;
        }

        public Criteria andOddsIsNotNull() {
            addCriterion("Odds is not null");
            return (Criteria) this;
        }

        public Criteria andOddsEqualTo(Float value) {
            addCriterion("Odds =", value, "odds");
            return (Criteria) this;
        }

        public Criteria andOddsNotEqualTo(Float value) {
            addCriterion("Odds <>", value, "odds");
            return (Criteria) this;
        }

        public Criteria andOddsGreaterThan(Float value) {
            addCriterion("Odds >", value, "odds");
            return (Criteria) this;
        }

        public Criteria andOddsGreaterThanOrEqualTo(Float value) {
            addCriterion("Odds >=", value, "odds");
            return (Criteria) this;
        }

        public Criteria andOddsLessThan(Float value) {
            addCriterion("Odds <", value, "odds");
            return (Criteria) this;
        }

        public Criteria andOddsLessThanOrEqualTo(Float value) {
            addCriterion("Odds <=", value, "odds");
            return (Criteria) this;
        }

        public Criteria andOddsIn(List<Float> values) {
            addCriterion("Odds in", values, "odds");
            return (Criteria) this;
        }

        public Criteria andOddsNotIn(List<Float> values) {
            addCriterion("Odds not in", values, "odds");
            return (Criteria) this;
        }

        public Criteria andOddsBetween(Float value1, Float value2) {
            addCriterion("Odds between", value1, value2, "odds");
            return (Criteria) this;
        }

        public Criteria andOddsNotBetween(Float value1, Float value2) {
            addCriterion("Odds not between", value1, value2, "odds");
            return (Criteria) this;
        }

        public Criteria andReteatIsNull() {
            addCriterion("Reteat is null");
            return (Criteria) this;
        }

        public Criteria andReteatIsNotNull() {
            addCriterion("Reteat is not null");
            return (Criteria) this;
        }

        public Criteria andReteatEqualTo(Float value) {
            addCriterion("Reteat =", value, "reteat");
            return (Criteria) this;
        }

        public Criteria andReteatNotEqualTo(Float value) {
            addCriterion("Reteat <>", value, "reteat");
            return (Criteria) this;
        }

        public Criteria andReteatGreaterThan(Float value) {
            addCriterion("Reteat >", value, "reteat");
            return (Criteria) this;
        }

        public Criteria andReteatGreaterThanOrEqualTo(Float value) {
            addCriterion("Reteat >=", value, "reteat");
            return (Criteria) this;
        }

        public Criteria andReteatLessThan(Float value) {
            addCriterion("Reteat <", value, "reteat");
            return (Criteria) this;
        }

        public Criteria andReteatLessThanOrEqualTo(Float value) {
            addCriterion("Reteat <=", value, "reteat");
            return (Criteria) this;
        }

        public Criteria andReteatIn(List<Float> values) {
            addCriterion("Reteat in", values, "reteat");
            return (Criteria) this;
        }

        public Criteria andReteatNotIn(List<Float> values) {
            addCriterion("Reteat not in", values, "reteat");
            return (Criteria) this;
        }

        public Criteria andReteatBetween(Float value1, Float value2) {
            addCriterion("Reteat between", value1, value2, "reteat");
            return (Criteria) this;
        }

        public Criteria andReteatNotBetween(Float value1, Float value2) {
            addCriterion("Reteat not between", value1, value2, "reteat");
            return (Criteria) this;
        }

        public Criteria andWinamountIsNull() {
            addCriterion("WinAmount is null");
            return (Criteria) this;
        }

        public Criteria andWinamountIsNotNull() {
            addCriterion("WinAmount is not null");
            return (Criteria) this;
        }

        public Criteria andWinamountEqualTo(Float value) {
            addCriterion("WinAmount =", value, "winamount");
            return (Criteria) this;
        }

        public Criteria andWinamountNotEqualTo(Float value) {
            addCriterion("WinAmount <>", value, "winamount");
            return (Criteria) this;
        }

        public Criteria andWinamountGreaterThan(Float value) {
            addCriterion("WinAmount >", value, "winamount");
            return (Criteria) this;
        }

        public Criteria andWinamountGreaterThanOrEqualTo(Float value) {
            addCriterion("WinAmount >=", value, "winamount");
            return (Criteria) this;
        }

        public Criteria andWinamountLessThan(Float value) {
            addCriterion("WinAmount <", value, "winamount");
            return (Criteria) this;
        }

        public Criteria andWinamountLessThanOrEqualTo(Float value) {
            addCriterion("WinAmount <=", value, "winamount");
            return (Criteria) this;
        }

        public Criteria andWinamountIn(List<Float> values) {
            addCriterion("WinAmount in", values, "winamount");
            return (Criteria) this;
        }

        public Criteria andWinamountNotIn(List<Float> values) {
            addCriterion("WinAmount not in", values, "winamount");
            return (Criteria) this;
        }

        public Criteria andWinamountBetween(Float value1, Float value2) {
            addCriterion("WinAmount between", value1, value2, "winamount");
            return (Criteria) this;
        }

        public Criteria andWinamountNotBetween(Float value1, Float value2) {
            addCriterion("WinAmount not between", value1, value2, "winamount");
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

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("Status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("Status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("Status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("Status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("Status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("Status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("Status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("Status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("Status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("Status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andCreatedateIsNull() {
            addCriterion("CreateDate is null");
            return (Criteria) this;
        }

        public Criteria andCreatedateIsNotNull() {
            addCriterion("CreateDate is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedateEqualTo(Date value) {
            addCriterion("CreateDate =", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateNotEqualTo(Date value) {
            addCriterion("CreateDate <>", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateGreaterThan(Date value) {
            addCriterion("CreateDate >", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateGreaterThanOrEqualTo(Date value) {
            addCriterion("CreateDate >=", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateLessThan(Date value) {
            addCriterion("CreateDate <", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateLessThanOrEqualTo(Date value) {
            addCriterion("CreateDate <=", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateIn(List<Date> values) {
            addCriterion("CreateDate in", values, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateNotIn(List<Date> values) {
            addCriterion("CreateDate not in", values, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateBetween(Date value1, Date value2) {
            addCriterion("CreateDate between", value1, value2, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateNotBetween(Date value1, Date value2) {
            addCriterion("CreateDate not between", value1, value2, "createdate");
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