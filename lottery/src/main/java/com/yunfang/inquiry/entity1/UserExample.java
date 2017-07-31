package com.yunfang.inquiry.entity1;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserExample() {
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

        public Criteria andParentidIsNull() {
            addCriterion("ParentId is null");
            return (Criteria) this;
        }

        public Criteria andParentidIsNotNull() {
            addCriterion("ParentId is not null");
            return (Criteria) this;
        }

        public Criteria andParentidEqualTo(String value) {
            addCriterion("ParentId =", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidNotEqualTo(String value) {
            addCriterion("ParentId <>", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidGreaterThan(String value) {
            addCriterion("ParentId >", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidGreaterThanOrEqualTo(String value) {
            addCriterion("ParentId >=", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidLessThan(String value) {
            addCriterion("ParentId <", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidLessThanOrEqualTo(String value) {
            addCriterion("ParentId <=", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidLike(String value) {
            addCriterion("ParentId like", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidNotLike(String value) {
            addCriterion("ParentId not like", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidIn(List<String> values) {
            addCriterion("ParentId in", values, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidNotIn(List<String> values) {
            addCriterion("ParentId not in", values, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidBetween(String value1, String value2) {
            addCriterion("ParentId between", value1, value2, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidNotBetween(String value1, String value2) {
            addCriterion("ParentId not between", value1, value2, "parentid");
            return (Criteria) this;
        }

        public Criteria andAccountIsNull() {
            addCriterion("Account is null");
            return (Criteria) this;
        }

        public Criteria andAccountIsNotNull() {
            addCriterion("Account is not null");
            return (Criteria) this;
        }

        public Criteria andAccountEqualTo(String value) {
            addCriterion("Account =", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotEqualTo(String value) {
            addCriterion("Account <>", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountGreaterThan(String value) {
            addCriterion("Account >", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountGreaterThanOrEqualTo(String value) {
            addCriterion("Account >=", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountLessThan(String value) {
            addCriterion("Account <", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountLessThanOrEqualTo(String value) {
            addCriterion("Account <=", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountLike(String value) {
            addCriterion("Account like", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotLike(String value) {
            addCriterion("Account not like", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountIn(List<String> values) {
            addCriterion("Account in", values, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotIn(List<String> values) {
            addCriterion("Account not in", values, "account");
            return (Criteria) this;
        }

        public Criteria andAccountBetween(String value1, String value2) {
            addCriterion("Account between", value1, value2, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotBetween(String value1, String value2) {
            addCriterion("Account not between", value1, value2, "account");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("Name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("Name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("Name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("Name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("Name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("Name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("Name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("Name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("Name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("Name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("Name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("Name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("Name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("Name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("Password is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("Password is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("Password =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("Password <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("Password >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("Password >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("Password <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("Password <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("Password like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("Password not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("Password in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("Password not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("Password between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("Password not between", value1, value2, "password");
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

        public Criteria andUsertypeIsNull() {
            addCriterion("UserType is null");
            return (Criteria) this;
        }

        public Criteria andUsertypeIsNotNull() {
            addCriterion("UserType is not null");
            return (Criteria) this;
        }

        public Criteria andUsertypeEqualTo(Byte value) {
            addCriterion("UserType =", value, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeNotEqualTo(Byte value) {
            addCriterion("UserType <>", value, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeGreaterThan(Byte value) {
            addCriterion("UserType >", value, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("UserType >=", value, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeLessThan(Byte value) {
            addCriterion("UserType <", value, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeLessThanOrEqualTo(Byte value) {
            addCriterion("UserType <=", value, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeIn(List<Byte> values) {
            addCriterion("UserType in", values, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeNotIn(List<Byte> values) {
            addCriterion("UserType not in", values, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeBetween(Byte value1, Byte value2) {
            addCriterion("UserType between", value1, value2, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeNotBetween(Byte value1, Byte value2) {
            addCriterion("UserType not between", value1, value2, "usertype");
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

        public Criteria andCreditsIsNull() {
            addCriterion("Credits is null");
            return (Criteria) this;
        }

        public Criteria andCreditsIsNotNull() {
            addCriterion("Credits is not null");
            return (Criteria) this;
        }

        public Criteria andCreditsEqualTo(Long value) {
            addCriterion("Credits =", value, "credits");
            return (Criteria) this;
        }

        public Criteria andCreditsNotEqualTo(Long value) {
            addCriterion("Credits <>", value, "credits");
            return (Criteria) this;
        }

        public Criteria andCreditsGreaterThan(Long value) {
            addCriterion("Credits >", value, "credits");
            return (Criteria) this;
        }

        public Criteria andCreditsGreaterThanOrEqualTo(Long value) {
            addCriterion("Credits >=", value, "credits");
            return (Criteria) this;
        }

        public Criteria andCreditsLessThan(Long value) {
            addCriterion("Credits <", value, "credits");
            return (Criteria) this;
        }

        public Criteria andCreditsLessThanOrEqualTo(Long value) {
            addCriterion("Credits <=", value, "credits");
            return (Criteria) this;
        }

        public Criteria andCreditsIn(List<Long> values) {
            addCriterion("Credits in", values, "credits");
            return (Criteria) this;
        }

        public Criteria andCreditsNotIn(List<Long> values) {
            addCriterion("Credits not in", values, "credits");
            return (Criteria) this;
        }

        public Criteria andCreditsBetween(Long value1, Long value2) {
            addCriterion("Credits between", value1, value2, "credits");
            return (Criteria) this;
        }

        public Criteria andCreditsNotBetween(Long value1, Long value2) {
            addCriterion("Credits not between", value1, value2, "credits");
            return (Criteria) this;
        }

        public Criteria andIsreplenishIsNull() {
            addCriterion("IsReplenish is null");
            return (Criteria) this;
        }

        public Criteria andIsreplenishIsNotNull() {
            addCriterion("IsReplenish is not null");
            return (Criteria) this;
        }

        public Criteria andIsreplenishEqualTo(Byte value) {
            addCriterion("IsReplenish =", value, "isreplenish");
            return (Criteria) this;
        }

        public Criteria andIsreplenishNotEqualTo(Byte value) {
            addCriterion("IsReplenish <>", value, "isreplenish");
            return (Criteria) this;
        }

        public Criteria andIsreplenishGreaterThan(Byte value) {
            addCriterion("IsReplenish >", value, "isreplenish");
            return (Criteria) this;
        }

        public Criteria andIsreplenishGreaterThanOrEqualTo(Byte value) {
            addCriterion("IsReplenish >=", value, "isreplenish");
            return (Criteria) this;
        }

        public Criteria andIsreplenishLessThan(Byte value) {
            addCriterion("IsReplenish <", value, "isreplenish");
            return (Criteria) this;
        }

        public Criteria andIsreplenishLessThanOrEqualTo(Byte value) {
            addCriterion("IsReplenish <=", value, "isreplenish");
            return (Criteria) this;
        }

        public Criteria andIsreplenishIn(List<Byte> values) {
            addCriterion("IsReplenish in", values, "isreplenish");
            return (Criteria) this;
        }

        public Criteria andIsreplenishNotIn(List<Byte> values) {
            addCriterion("IsReplenish not in", values, "isreplenish");
            return (Criteria) this;
        }

        public Criteria andIsreplenishBetween(Byte value1, Byte value2) {
            addCriterion("IsReplenish between", value1, value2, "isreplenish");
            return (Criteria) this;
        }

        public Criteria andIsreplenishNotBetween(Byte value1, Byte value2) {
            addCriterion("IsReplenish not between", value1, value2, "isreplenish");
            return (Criteria) this;
        }

        public Criteria andZhanchengheIsNull() {
            addCriterion("ZhanChengHe is null");
            return (Criteria) this;
        }

        public Criteria andZhanchengheIsNotNull() {
            addCriterion("ZhanChengHe is not null");
            return (Criteria) this;
        }

        public Criteria andZhanchengheEqualTo(Integer value) {
            addCriterion("ZhanChengHe =", value, "zhanchenghe");
            return (Criteria) this;
        }

        public Criteria andZhanchengheNotEqualTo(Integer value) {
            addCriterion("ZhanChengHe <>", value, "zhanchenghe");
            return (Criteria) this;
        }

        public Criteria andZhanchengheGreaterThan(Integer value) {
            addCriterion("ZhanChengHe >", value, "zhanchenghe");
            return (Criteria) this;
        }

        public Criteria andZhanchengheGreaterThanOrEqualTo(Integer value) {
            addCriterion("ZhanChengHe >=", value, "zhanchenghe");
            return (Criteria) this;
        }

        public Criteria andZhanchengheLessThan(Integer value) {
            addCriterion("ZhanChengHe <", value, "zhanchenghe");
            return (Criteria) this;
        }

        public Criteria andZhanchengheLessThanOrEqualTo(Integer value) {
            addCriterion("ZhanChengHe <=", value, "zhanchenghe");
            return (Criteria) this;
        }

        public Criteria andZhanchengheIn(List<Integer> values) {
            addCriterion("ZhanChengHe in", values, "zhanchenghe");
            return (Criteria) this;
        }

        public Criteria andZhanchengheNotIn(List<Integer> values) {
            addCriterion("ZhanChengHe not in", values, "zhanchenghe");
            return (Criteria) this;
        }

        public Criteria andZhanchengheBetween(Integer value1, Integer value2) {
            addCriterion("ZhanChengHe between", value1, value2, "zhanchenghe");
            return (Criteria) this;
        }

        public Criteria andZhanchengheNotBetween(Integer value1, Integer value2) {
            addCriterion("ZhanChengHe not between", value1, value2, "zhanchenghe");
            return (Criteria) this;
        }

        public Criteria andZongdaizhanchengshuIsNull() {
            addCriterion("ZongDaiZhanChengShu is null");
            return (Criteria) this;
        }

        public Criteria andZongdaizhanchengshuIsNotNull() {
            addCriterion("ZongDaiZhanChengShu is not null");
            return (Criteria) this;
        }

        public Criteria andZongdaizhanchengshuEqualTo(Integer value) {
            addCriterion("ZongDaiZhanChengShu =", value, "zongdaizhanchengshu");
            return (Criteria) this;
        }

        public Criteria andZongdaizhanchengshuNotEqualTo(Integer value) {
            addCriterion("ZongDaiZhanChengShu <>", value, "zongdaizhanchengshu");
            return (Criteria) this;
        }

        public Criteria andZongdaizhanchengshuGreaterThan(Integer value) {
            addCriterion("ZongDaiZhanChengShu >", value, "zongdaizhanchengshu");
            return (Criteria) this;
        }

        public Criteria andZongdaizhanchengshuGreaterThanOrEqualTo(Integer value) {
            addCriterion("ZongDaiZhanChengShu >=", value, "zongdaizhanchengshu");
            return (Criteria) this;
        }

        public Criteria andZongdaizhanchengshuLessThan(Integer value) {
            addCriterion("ZongDaiZhanChengShu <", value, "zongdaizhanchengshu");
            return (Criteria) this;
        }

        public Criteria andZongdaizhanchengshuLessThanOrEqualTo(Integer value) {
            addCriterion("ZongDaiZhanChengShu <=", value, "zongdaizhanchengshu");
            return (Criteria) this;
        }

        public Criteria andZongdaizhanchengshuIn(List<Integer> values) {
            addCriterion("ZongDaiZhanChengShu in", values, "zongdaizhanchengshu");
            return (Criteria) this;
        }

        public Criteria andZongdaizhanchengshuNotIn(List<Integer> values) {
            addCriterion("ZongDaiZhanChengShu not in", values, "zongdaizhanchengshu");
            return (Criteria) this;
        }

        public Criteria andZongdaizhanchengshuBetween(Integer value1, Integer value2) {
            addCriterion("ZongDaiZhanChengShu between", value1, value2, "zongdaizhanchengshu");
            return (Criteria) this;
        }

        public Criteria andZongdaizhanchengshuNotBetween(Integer value1, Integer value2) {
            addCriterion("ZongDaiZhanChengShu not between", value1, value2, "zongdaizhanchengshu");
            return (Criteria) this;
        }

        public Criteria andReplenishpercentIsNull() {
            addCriterion("ReplenishPercent is null");
            return (Criteria) this;
        }

        public Criteria andReplenishpercentIsNotNull() {
            addCriterion("ReplenishPercent is not null");
            return (Criteria) this;
        }

        public Criteria andReplenishpercentEqualTo(Integer value) {
            addCriterion("ReplenishPercent =", value, "replenishpercent");
            return (Criteria) this;
        }

        public Criteria andReplenishpercentNotEqualTo(Integer value) {
            addCriterion("ReplenishPercent <>", value, "replenishpercent");
            return (Criteria) this;
        }

        public Criteria andReplenishpercentGreaterThan(Integer value) {
            addCriterion("ReplenishPercent >", value, "replenishpercent");
            return (Criteria) this;
        }

        public Criteria andReplenishpercentGreaterThanOrEqualTo(Integer value) {
            addCriterion("ReplenishPercent >=", value, "replenishpercent");
            return (Criteria) this;
        }

        public Criteria andReplenishpercentLessThan(Integer value) {
            addCriterion("ReplenishPercent <", value, "replenishpercent");
            return (Criteria) this;
        }

        public Criteria andReplenishpercentLessThanOrEqualTo(Integer value) {
            addCriterion("ReplenishPercent <=", value, "replenishpercent");
            return (Criteria) this;
        }

        public Criteria andReplenishpercentIn(List<Integer> values) {
            addCriterion("ReplenishPercent in", values, "replenishpercent");
            return (Criteria) this;
        }

        public Criteria andReplenishpercentNotIn(List<Integer> values) {
            addCriterion("ReplenishPercent not in", values, "replenishpercent");
            return (Criteria) this;
        }

        public Criteria andReplenishpercentBetween(Integer value1, Integer value2) {
            addCriterion("ReplenishPercent between", value1, value2, "replenishpercent");
            return (Criteria) this;
        }

        public Criteria andReplenishpercentNotBetween(Integer value1, Integer value2) {
            addCriterion("ReplenishPercent not between", value1, value2, "replenishpercent");
            return (Criteria) this;
        }

        public Criteria andProportionalIsNull() {
            addCriterion("Proportional is null");
            return (Criteria) this;
        }

        public Criteria andProportionalIsNotNull() {
            addCriterion("Proportional is not null");
            return (Criteria) this;
        }

        public Criteria andProportionalEqualTo(Integer value) {
            addCriterion("Proportional =", value, "proportional");
            return (Criteria) this;
        }

        public Criteria andProportionalNotEqualTo(Integer value) {
            addCriterion("Proportional <>", value, "proportional");
            return (Criteria) this;
        }

        public Criteria andProportionalGreaterThan(Integer value) {
            addCriterion("Proportional >", value, "proportional");
            return (Criteria) this;
        }

        public Criteria andProportionalGreaterThanOrEqualTo(Integer value) {
            addCriterion("Proportional >=", value, "proportional");
            return (Criteria) this;
        }

        public Criteria andProportionalLessThan(Integer value) {
            addCriterion("Proportional <", value, "proportional");
            return (Criteria) this;
        }

        public Criteria andProportionalLessThanOrEqualTo(Integer value) {
            addCriterion("Proportional <=", value, "proportional");
            return (Criteria) this;
        }

        public Criteria andProportionalIn(List<Integer> values) {
            addCriterion("Proportional in", values, "proportional");
            return (Criteria) this;
        }

        public Criteria andProportionalNotIn(List<Integer> values) {
            addCriterion("Proportional not in", values, "proportional");
            return (Criteria) this;
        }

        public Criteria andProportionalBetween(Integer value1, Integer value2) {
            addCriterion("Proportional between", value1, value2, "proportional");
            return (Criteria) this;
        }

        public Criteria andProportionalNotBetween(Integer value1, Integer value2) {
            addCriterion("Proportional not between", value1, value2, "proportional");
            return (Criteria) this;
        }

        public Criteria andHandicapIsNull() {
            addCriterion("Handicap is null");
            return (Criteria) this;
        }

        public Criteria andHandicapIsNotNull() {
            addCriterion("Handicap is not null");
            return (Criteria) this;
        }

        public Criteria andHandicapEqualTo(String value) {
            addCriterion("Handicap =", value, "handicap");
            return (Criteria) this;
        }

        public Criteria andHandicapNotEqualTo(String value) {
            addCriterion("Handicap <>", value, "handicap");
            return (Criteria) this;
        }

        public Criteria andHandicapGreaterThan(String value) {
            addCriterion("Handicap >", value, "handicap");
            return (Criteria) this;
        }

        public Criteria andHandicapGreaterThanOrEqualTo(String value) {
            addCriterion("Handicap >=", value, "handicap");
            return (Criteria) this;
        }

        public Criteria andHandicapLessThan(String value) {
            addCriterion("Handicap <", value, "handicap");
            return (Criteria) this;
        }

        public Criteria andHandicapLessThanOrEqualTo(String value) {
            addCriterion("Handicap <=", value, "handicap");
            return (Criteria) this;
        }

        public Criteria andHandicapLike(String value) {
            addCriterion("Handicap like", value, "handicap");
            return (Criteria) this;
        }

        public Criteria andHandicapNotLike(String value) {
            addCriterion("Handicap not like", value, "handicap");
            return (Criteria) this;
        }

        public Criteria andHandicapIn(List<String> values) {
            addCriterion("Handicap in", values, "handicap");
            return (Criteria) this;
        }

        public Criteria andHandicapNotIn(List<String> values) {
            addCriterion("Handicap not in", values, "handicap");
            return (Criteria) this;
        }

        public Criteria andHandicapBetween(String value1, String value2) {
            addCriterion("Handicap between", value1, value2, "handicap");
            return (Criteria) this;
        }

        public Criteria andHandicapNotBetween(String value1, String value2) {
            addCriterion("Handicap not between", value1, value2, "handicap");
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