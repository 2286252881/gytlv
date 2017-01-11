package com.gytlv.base.baseEntity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TArticlevisitorExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TArticlevisitorExample() {
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

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUseridIsNull() {
            addCriterion("userid is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userid is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(String value) {
            addCriterion("userid =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(String value) {
            addCriterion("userid <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(String value) {
            addCriterion("userid >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(String value) {
            addCriterion("userid >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(String value) {
            addCriterion("userid <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(String value) {
            addCriterion("userid <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLike(String value) {
            addCriterion("userid like", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotLike(String value) {
            addCriterion("userid not like", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<String> values) {
            addCriterion("userid in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<String> values) {
            addCriterion("userid not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(String value1, String value2) {
            addCriterion("userid between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(String value1, String value2) {
            addCriterion("userid not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andVisitornameIsNull() {
            addCriterion("visitorname is null");
            return (Criteria) this;
        }

        public Criteria andVisitornameIsNotNull() {
            addCriterion("visitorname is not null");
            return (Criteria) this;
        }

        public Criteria andVisitornameEqualTo(String value) {
            addCriterion("visitorname =", value, "visitorname");
            return (Criteria) this;
        }

        public Criteria andVisitornameNotEqualTo(String value) {
            addCriterion("visitorname <>", value, "visitorname");
            return (Criteria) this;
        }

        public Criteria andVisitornameGreaterThan(String value) {
            addCriterion("visitorname >", value, "visitorname");
            return (Criteria) this;
        }

        public Criteria andVisitornameGreaterThanOrEqualTo(String value) {
            addCriterion("visitorname >=", value, "visitorname");
            return (Criteria) this;
        }

        public Criteria andVisitornameLessThan(String value) {
            addCriterion("visitorname <", value, "visitorname");
            return (Criteria) this;
        }

        public Criteria andVisitornameLessThanOrEqualTo(String value) {
            addCriterion("visitorname <=", value, "visitorname");
            return (Criteria) this;
        }

        public Criteria andVisitornameLike(String value) {
            addCriterion("visitorname like", value, "visitorname");
            return (Criteria) this;
        }

        public Criteria andVisitornameNotLike(String value) {
            addCriterion("visitorname not like", value, "visitorname");
            return (Criteria) this;
        }

        public Criteria andVisitornameIn(List<String> values) {
            addCriterion("visitorname in", values, "visitorname");
            return (Criteria) this;
        }

        public Criteria andVisitornameNotIn(List<String> values) {
            addCriterion("visitorname not in", values, "visitorname");
            return (Criteria) this;
        }

        public Criteria andVisitornameBetween(String value1, String value2) {
            addCriterion("visitorname between", value1, value2, "visitorname");
            return (Criteria) this;
        }

        public Criteria andVisitornameNotBetween(String value1, String value2) {
            addCriterion("visitorname not between", value1, value2, "visitorname");
            return (Criteria) this;
        }

        public Criteria andVisitoripIsNull() {
            addCriterion("visitorip is null");
            return (Criteria) this;
        }

        public Criteria andVisitoripIsNotNull() {
            addCriterion("visitorip is not null");
            return (Criteria) this;
        }

        public Criteria andVisitoripEqualTo(String value) {
            addCriterion("visitorip =", value, "visitorip");
            return (Criteria) this;
        }

        public Criteria andVisitoripNotEqualTo(String value) {
            addCriterion("visitorip <>", value, "visitorip");
            return (Criteria) this;
        }

        public Criteria andVisitoripGreaterThan(String value) {
            addCriterion("visitorip >", value, "visitorip");
            return (Criteria) this;
        }

        public Criteria andVisitoripGreaterThanOrEqualTo(String value) {
            addCriterion("visitorip >=", value, "visitorip");
            return (Criteria) this;
        }

        public Criteria andVisitoripLessThan(String value) {
            addCriterion("visitorip <", value, "visitorip");
            return (Criteria) this;
        }

        public Criteria andVisitoripLessThanOrEqualTo(String value) {
            addCriterion("visitorip <=", value, "visitorip");
            return (Criteria) this;
        }

        public Criteria andVisitoripLike(String value) {
            addCriterion("visitorip like", value, "visitorip");
            return (Criteria) this;
        }

        public Criteria andVisitoripNotLike(String value) {
            addCriterion("visitorip not like", value, "visitorip");
            return (Criteria) this;
        }

        public Criteria andVisitoripIn(List<String> values) {
            addCriterion("visitorip in", values, "visitorip");
            return (Criteria) this;
        }

        public Criteria andVisitoripNotIn(List<String> values) {
            addCriterion("visitorip not in", values, "visitorip");
            return (Criteria) this;
        }

        public Criteria andVisitoripBetween(String value1, String value2) {
            addCriterion("visitorip between", value1, value2, "visitorip");
            return (Criteria) this;
        }

        public Criteria andVisitoripNotBetween(String value1, String value2) {
            addCriterion("visitorip not between", value1, value2, "visitorip");
            return (Criteria) this;
        }

        public Criteria andVisitortimeIsNull() {
            addCriterion("visitortime is null");
            return (Criteria) this;
        }

        public Criteria andVisitortimeIsNotNull() {
            addCriterion("visitortime is not null");
            return (Criteria) this;
        }

        public Criteria andVisitortimeEqualTo(Date value) {
            addCriterion("visitortime =", value, "visitortime");
            return (Criteria) this;
        }

        public Criteria andVisitortimeNotEqualTo(Date value) {
            addCriterion("visitortime <>", value, "visitortime");
            return (Criteria) this;
        }

        public Criteria andVisitortimeGreaterThan(Date value) {
            addCriterion("visitortime >", value, "visitortime");
            return (Criteria) this;
        }

        public Criteria andVisitortimeGreaterThanOrEqualTo(Date value) {
            addCriterion("visitortime >=", value, "visitortime");
            return (Criteria) this;
        }

        public Criteria andVisitortimeLessThan(Date value) {
            addCriterion("visitortime <", value, "visitortime");
            return (Criteria) this;
        }

        public Criteria andVisitortimeLessThanOrEqualTo(Date value) {
            addCriterion("visitortime <=", value, "visitortime");
            return (Criteria) this;
        }

        public Criteria andVisitortimeIn(List<Date> values) {
            addCriterion("visitortime in", values, "visitortime");
            return (Criteria) this;
        }

        public Criteria andVisitortimeNotIn(List<Date> values) {
            addCriterion("visitortime not in", values, "visitortime");
            return (Criteria) this;
        }

        public Criteria andVisitortimeBetween(Date value1, Date value2) {
            addCriterion("visitortime between", value1, value2, "visitortime");
            return (Criteria) this;
        }

        public Criteria andVisitortimeNotBetween(Date value1, Date value2) {
            addCriterion("visitortime not between", value1, value2, "visitortime");
            return (Criteria) this;
        }

        public Criteria andVisitoruseridIsNull() {
            addCriterion("visitoruserid is null");
            return (Criteria) this;
        }

        public Criteria andVisitoruseridIsNotNull() {
            addCriterion("visitoruserid is not null");
            return (Criteria) this;
        }

        public Criteria andVisitoruseridEqualTo(String value) {
            addCriterion("visitoruserid =", value, "visitoruserid");
            return (Criteria) this;
        }

        public Criteria andVisitoruseridNotEqualTo(String value) {
            addCriterion("visitoruserid <>", value, "visitoruserid");
            return (Criteria) this;
        }

        public Criteria andVisitoruseridGreaterThan(String value) {
            addCriterion("visitoruserid >", value, "visitoruserid");
            return (Criteria) this;
        }

        public Criteria andVisitoruseridGreaterThanOrEqualTo(String value) {
            addCriterion("visitoruserid >=", value, "visitoruserid");
            return (Criteria) this;
        }

        public Criteria andVisitoruseridLessThan(String value) {
            addCriterion("visitoruserid <", value, "visitoruserid");
            return (Criteria) this;
        }

        public Criteria andVisitoruseridLessThanOrEqualTo(String value) {
            addCriterion("visitoruserid <=", value, "visitoruserid");
            return (Criteria) this;
        }

        public Criteria andVisitoruseridLike(String value) {
            addCriterion("visitoruserid like", value, "visitoruserid");
            return (Criteria) this;
        }

        public Criteria andVisitoruseridNotLike(String value) {
            addCriterion("visitoruserid not like", value, "visitoruserid");
            return (Criteria) this;
        }

        public Criteria andVisitoruseridIn(List<String> values) {
            addCriterion("visitoruserid in", values, "visitoruserid");
            return (Criteria) this;
        }

        public Criteria andVisitoruseridNotIn(List<String> values) {
            addCriterion("visitoruserid not in", values, "visitoruserid");
            return (Criteria) this;
        }

        public Criteria andVisitoruseridBetween(String value1, String value2) {
            addCriterion("visitoruserid between", value1, value2, "visitoruserid");
            return (Criteria) this;
        }

        public Criteria andVisitoruseridNotBetween(String value1, String value2) {
            addCriterion("visitoruserid not between", value1, value2, "visitoruserid");
            return (Criteria) this;
        }

        public Criteria andVisitorarticleidIsNull() {
            addCriterion("visitorarticleid is null");
            return (Criteria) this;
        }

        public Criteria andVisitorarticleidIsNotNull() {
            addCriterion("visitorarticleid is not null");
            return (Criteria) this;
        }

        public Criteria andVisitorarticleidEqualTo(String value) {
            addCriterion("visitorarticleid =", value, "visitorarticleid");
            return (Criteria) this;
        }

        public Criteria andVisitorarticleidNotEqualTo(String value) {
            addCriterion("visitorarticleid <>", value, "visitorarticleid");
            return (Criteria) this;
        }

        public Criteria andVisitorarticleidGreaterThan(String value) {
            addCriterion("visitorarticleid >", value, "visitorarticleid");
            return (Criteria) this;
        }

        public Criteria andVisitorarticleidGreaterThanOrEqualTo(String value) {
            addCriterion("visitorarticleid >=", value, "visitorarticleid");
            return (Criteria) this;
        }

        public Criteria andVisitorarticleidLessThan(String value) {
            addCriterion("visitorarticleid <", value, "visitorarticleid");
            return (Criteria) this;
        }

        public Criteria andVisitorarticleidLessThanOrEqualTo(String value) {
            addCriterion("visitorarticleid <=", value, "visitorarticleid");
            return (Criteria) this;
        }

        public Criteria andVisitorarticleidLike(String value) {
            addCriterion("visitorarticleid like", value, "visitorarticleid");
            return (Criteria) this;
        }

        public Criteria andVisitorarticleidNotLike(String value) {
            addCriterion("visitorarticleid not like", value, "visitorarticleid");
            return (Criteria) this;
        }

        public Criteria andVisitorarticleidIn(List<String> values) {
            addCriterion("visitorarticleid in", values, "visitorarticleid");
            return (Criteria) this;
        }

        public Criteria andVisitorarticleidNotIn(List<String> values) {
            addCriterion("visitorarticleid not in", values, "visitorarticleid");
            return (Criteria) this;
        }

        public Criteria andVisitorarticleidBetween(String value1, String value2) {
            addCriterion("visitorarticleid between", value1, value2, "visitorarticleid");
            return (Criteria) this;
        }

        public Criteria andVisitorarticleidNotBetween(String value1, String value2) {
            addCriterion("visitorarticleid not between", value1, value2, "visitorarticleid");
            return (Criteria) this;
        }

        public Criteria andVisitorarticletypeidIsNull() {
            addCriterion("visitorarticletypeid is null");
            return (Criteria) this;
        }

        public Criteria andVisitorarticletypeidIsNotNull() {
            addCriterion("visitorarticletypeid is not null");
            return (Criteria) this;
        }

        public Criteria andVisitorarticletypeidEqualTo(String value) {
            addCriterion("visitorarticletypeid =", value, "visitorarticletypeid");
            return (Criteria) this;
        }

        public Criteria andVisitorarticletypeidNotEqualTo(String value) {
            addCriterion("visitorarticletypeid <>", value, "visitorarticletypeid");
            return (Criteria) this;
        }

        public Criteria andVisitorarticletypeidGreaterThan(String value) {
            addCriterion("visitorarticletypeid >", value, "visitorarticletypeid");
            return (Criteria) this;
        }

        public Criteria andVisitorarticletypeidGreaterThanOrEqualTo(String value) {
            addCriterion("visitorarticletypeid >=", value, "visitorarticletypeid");
            return (Criteria) this;
        }

        public Criteria andVisitorarticletypeidLessThan(String value) {
            addCriterion("visitorarticletypeid <", value, "visitorarticletypeid");
            return (Criteria) this;
        }

        public Criteria andVisitorarticletypeidLessThanOrEqualTo(String value) {
            addCriterion("visitorarticletypeid <=", value, "visitorarticletypeid");
            return (Criteria) this;
        }

        public Criteria andVisitorarticletypeidLike(String value) {
            addCriterion("visitorarticletypeid like", value, "visitorarticletypeid");
            return (Criteria) this;
        }

        public Criteria andVisitorarticletypeidNotLike(String value) {
            addCriterion("visitorarticletypeid not like", value, "visitorarticletypeid");
            return (Criteria) this;
        }

        public Criteria andVisitorarticletypeidIn(List<String> values) {
            addCriterion("visitorarticletypeid in", values, "visitorarticletypeid");
            return (Criteria) this;
        }

        public Criteria andVisitorarticletypeidNotIn(List<String> values) {
            addCriterion("visitorarticletypeid not in", values, "visitorarticletypeid");
            return (Criteria) this;
        }

        public Criteria andVisitorarticletypeidBetween(String value1, String value2) {
            addCriterion("visitorarticletypeid between", value1, value2, "visitorarticletypeid");
            return (Criteria) this;
        }

        public Criteria andVisitorarticletypeidNotBetween(String value1, String value2) {
            addCriterion("visitorarticletypeid not between", value1, value2, "visitorarticletypeid");
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