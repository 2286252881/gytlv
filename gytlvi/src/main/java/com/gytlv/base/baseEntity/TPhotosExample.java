package com.gytlv.base.baseEntity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TPhotosExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TPhotosExample() {
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

        public Criteria andPhotonameIsNull() {
            addCriterion("photoname is null");
            return (Criteria) this;
        }

        public Criteria andPhotonameIsNotNull() {
            addCriterion("photoname is not null");
            return (Criteria) this;
        }

        public Criteria andPhotonameEqualTo(String value) {
            addCriterion("photoname =", value, "photoname");
            return (Criteria) this;
        }

        public Criteria andPhotonameNotEqualTo(String value) {
            addCriterion("photoname <>", value, "photoname");
            return (Criteria) this;
        }

        public Criteria andPhotonameGreaterThan(String value) {
            addCriterion("photoname >", value, "photoname");
            return (Criteria) this;
        }

        public Criteria andPhotonameGreaterThanOrEqualTo(String value) {
            addCriterion("photoname >=", value, "photoname");
            return (Criteria) this;
        }

        public Criteria andPhotonameLessThan(String value) {
            addCriterion("photoname <", value, "photoname");
            return (Criteria) this;
        }

        public Criteria andPhotonameLessThanOrEqualTo(String value) {
            addCriterion("photoname <=", value, "photoname");
            return (Criteria) this;
        }

        public Criteria andPhotonameLike(String value) {
            addCriterion("photoname like", value, "photoname");
            return (Criteria) this;
        }

        public Criteria andPhotonameNotLike(String value) {
            addCriterion("photoname not like", value, "photoname");
            return (Criteria) this;
        }

        public Criteria andPhotonameIn(List<String> values) {
            addCriterion("photoname in", values, "photoname");
            return (Criteria) this;
        }

        public Criteria andPhotonameNotIn(List<String> values) {
            addCriterion("photoname not in", values, "photoname");
            return (Criteria) this;
        }

        public Criteria andPhotonameBetween(String value1, String value2) {
            addCriterion("photoname between", value1, value2, "photoname");
            return (Criteria) this;
        }

        public Criteria andPhotonameNotBetween(String value1, String value2) {
            addCriterion("photoname not between", value1, value2, "photoname");
            return (Criteria) this;
        }

        public Criteria andPhotosrcIsNull() {
            addCriterion("photosrc is null");
            return (Criteria) this;
        }

        public Criteria andPhotosrcIsNotNull() {
            addCriterion("photosrc is not null");
            return (Criteria) this;
        }

        public Criteria andPhotosrcEqualTo(String value) {
            addCriterion("photosrc =", value, "photosrc");
            return (Criteria) this;
        }

        public Criteria andPhotosrcNotEqualTo(String value) {
            addCriterion("photosrc <>", value, "photosrc");
            return (Criteria) this;
        }

        public Criteria andPhotosrcGreaterThan(String value) {
            addCriterion("photosrc >", value, "photosrc");
            return (Criteria) this;
        }

        public Criteria andPhotosrcGreaterThanOrEqualTo(String value) {
            addCriterion("photosrc >=", value, "photosrc");
            return (Criteria) this;
        }

        public Criteria andPhotosrcLessThan(String value) {
            addCriterion("photosrc <", value, "photosrc");
            return (Criteria) this;
        }

        public Criteria andPhotosrcLessThanOrEqualTo(String value) {
            addCriterion("photosrc <=", value, "photosrc");
            return (Criteria) this;
        }

        public Criteria andPhotosrcLike(String value) {
            addCriterion("photosrc like", value, "photosrc");
            return (Criteria) this;
        }

        public Criteria andPhotosrcNotLike(String value) {
            addCriterion("photosrc not like", value, "photosrc");
            return (Criteria) this;
        }

        public Criteria andPhotosrcIn(List<String> values) {
            addCriterion("photosrc in", values, "photosrc");
            return (Criteria) this;
        }

        public Criteria andPhotosrcNotIn(List<String> values) {
            addCriterion("photosrc not in", values, "photosrc");
            return (Criteria) this;
        }

        public Criteria andPhotosrcBetween(String value1, String value2) {
            addCriterion("photosrc between", value1, value2, "photosrc");
            return (Criteria) this;
        }

        public Criteria andPhotosrcNotBetween(String value1, String value2) {
            addCriterion("photosrc not between", value1, value2, "photosrc");
            return (Criteria) this;
        }

        public Criteria andPhotodescriptionIsNull() {
            addCriterion("photodescription is null");
            return (Criteria) this;
        }

        public Criteria andPhotodescriptionIsNotNull() {
            addCriterion("photodescription is not null");
            return (Criteria) this;
        }

        public Criteria andPhotodescriptionEqualTo(String value) {
            addCriterion("photodescription =", value, "photodescription");
            return (Criteria) this;
        }

        public Criteria andPhotodescriptionNotEqualTo(String value) {
            addCriterion("photodescription <>", value, "photodescription");
            return (Criteria) this;
        }

        public Criteria andPhotodescriptionGreaterThan(String value) {
            addCriterion("photodescription >", value, "photodescription");
            return (Criteria) this;
        }

        public Criteria andPhotodescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("photodescription >=", value, "photodescription");
            return (Criteria) this;
        }

        public Criteria andPhotodescriptionLessThan(String value) {
            addCriterion("photodescription <", value, "photodescription");
            return (Criteria) this;
        }

        public Criteria andPhotodescriptionLessThanOrEqualTo(String value) {
            addCriterion("photodescription <=", value, "photodescription");
            return (Criteria) this;
        }

        public Criteria andPhotodescriptionLike(String value) {
            addCriterion("photodescription like", value, "photodescription");
            return (Criteria) this;
        }

        public Criteria andPhotodescriptionNotLike(String value) {
            addCriterion("photodescription not like", value, "photodescription");
            return (Criteria) this;
        }

        public Criteria andPhotodescriptionIn(List<String> values) {
            addCriterion("photodescription in", values, "photodescription");
            return (Criteria) this;
        }

        public Criteria andPhotodescriptionNotIn(List<String> values) {
            addCriterion("photodescription not in", values, "photodescription");
            return (Criteria) this;
        }

        public Criteria andPhotodescriptionBetween(String value1, String value2) {
            addCriterion("photodescription between", value1, value2, "photodescription");
            return (Criteria) this;
        }

        public Criteria andPhotodescriptionNotBetween(String value1, String value2) {
            addCriterion("photodescription not between", value1, value2, "photodescription");
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

        public Criteria andPhonetypeidIsNull() {
            addCriterion("phonetypeid is null");
            return (Criteria) this;
        }

        public Criteria andPhonetypeidIsNotNull() {
            addCriterion("phonetypeid is not null");
            return (Criteria) this;
        }

        public Criteria andPhonetypeidEqualTo(String value) {
            addCriterion("phonetypeid =", value, "phonetypeid");
            return (Criteria) this;
        }

        public Criteria andPhonetypeidNotEqualTo(String value) {
            addCriterion("phonetypeid <>", value, "phonetypeid");
            return (Criteria) this;
        }

        public Criteria andPhonetypeidGreaterThan(String value) {
            addCriterion("phonetypeid >", value, "phonetypeid");
            return (Criteria) this;
        }

        public Criteria andPhonetypeidGreaterThanOrEqualTo(String value) {
            addCriterion("phonetypeid >=", value, "phonetypeid");
            return (Criteria) this;
        }

        public Criteria andPhonetypeidLessThan(String value) {
            addCriterion("phonetypeid <", value, "phonetypeid");
            return (Criteria) this;
        }

        public Criteria andPhonetypeidLessThanOrEqualTo(String value) {
            addCriterion("phonetypeid <=", value, "phonetypeid");
            return (Criteria) this;
        }

        public Criteria andPhonetypeidLike(String value) {
            addCriterion("phonetypeid like", value, "phonetypeid");
            return (Criteria) this;
        }

        public Criteria andPhonetypeidNotLike(String value) {
            addCriterion("phonetypeid not like", value, "phonetypeid");
            return (Criteria) this;
        }

        public Criteria andPhonetypeidIn(List<String> values) {
            addCriterion("phonetypeid in", values, "phonetypeid");
            return (Criteria) this;
        }

        public Criteria andPhonetypeidNotIn(List<String> values) {
            addCriterion("phonetypeid not in", values, "phonetypeid");
            return (Criteria) this;
        }

        public Criteria andPhonetypeidBetween(String value1, String value2) {
            addCriterion("phonetypeid between", value1, value2, "phonetypeid");
            return (Criteria) this;
        }

        public Criteria andPhonetypeidNotBetween(String value1, String value2) {
            addCriterion("phonetypeid not between", value1, value2, "phonetypeid");
            return (Criteria) this;
        }

        public Criteria andUploadtimeIsNull() {
            addCriterion("uploadtime is null");
            return (Criteria) this;
        }

        public Criteria andUploadtimeIsNotNull() {
            addCriterion("uploadtime is not null");
            return (Criteria) this;
        }

        public Criteria andUploadtimeEqualTo(Date value) {
            addCriterion("uploadtime =", value, "uploadtime");
            return (Criteria) this;
        }

        public Criteria andUploadtimeNotEqualTo(Date value) {
            addCriterion("uploadtime <>", value, "uploadtime");
            return (Criteria) this;
        }

        public Criteria andUploadtimeGreaterThan(Date value) {
            addCriterion("uploadtime >", value, "uploadtime");
            return (Criteria) this;
        }

        public Criteria andUploadtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("uploadtime >=", value, "uploadtime");
            return (Criteria) this;
        }

        public Criteria andUploadtimeLessThan(Date value) {
            addCriterion("uploadtime <", value, "uploadtime");
            return (Criteria) this;
        }

        public Criteria andUploadtimeLessThanOrEqualTo(Date value) {
            addCriterion("uploadtime <=", value, "uploadtime");
            return (Criteria) this;
        }

        public Criteria andUploadtimeIn(List<Date> values) {
            addCriterion("uploadtime in", values, "uploadtime");
            return (Criteria) this;
        }

        public Criteria andUploadtimeNotIn(List<Date> values) {
            addCriterion("uploadtime not in", values, "uploadtime");
            return (Criteria) this;
        }

        public Criteria andUploadtimeBetween(Date value1, Date value2) {
            addCriterion("uploadtime between", value1, value2, "uploadtime");
            return (Criteria) this;
        }

        public Criteria andUploadtimeNotBetween(Date value1, Date value2) {
            addCriterion("uploadtime not between", value1, value2, "uploadtime");
            return (Criteria) this;
        }

        public Criteria andUploadipIsNull() {
            addCriterion("uploadip is null");
            return (Criteria) this;
        }

        public Criteria andUploadipIsNotNull() {
            addCriterion("uploadip is not null");
            return (Criteria) this;
        }

        public Criteria andUploadipEqualTo(String value) {
            addCriterion("uploadip =", value, "uploadip");
            return (Criteria) this;
        }

        public Criteria andUploadipNotEqualTo(String value) {
            addCriterion("uploadip <>", value, "uploadip");
            return (Criteria) this;
        }

        public Criteria andUploadipGreaterThan(String value) {
            addCriterion("uploadip >", value, "uploadip");
            return (Criteria) this;
        }

        public Criteria andUploadipGreaterThanOrEqualTo(String value) {
            addCriterion("uploadip >=", value, "uploadip");
            return (Criteria) this;
        }

        public Criteria andUploadipLessThan(String value) {
            addCriterion("uploadip <", value, "uploadip");
            return (Criteria) this;
        }

        public Criteria andUploadipLessThanOrEqualTo(String value) {
            addCriterion("uploadip <=", value, "uploadip");
            return (Criteria) this;
        }

        public Criteria andUploadipLike(String value) {
            addCriterion("uploadip like", value, "uploadip");
            return (Criteria) this;
        }

        public Criteria andUploadipNotLike(String value) {
            addCriterion("uploadip not like", value, "uploadip");
            return (Criteria) this;
        }

        public Criteria andUploadipIn(List<String> values) {
            addCriterion("uploadip in", values, "uploadip");
            return (Criteria) this;
        }

        public Criteria andUploadipNotIn(List<String> values) {
            addCriterion("uploadip not in", values, "uploadip");
            return (Criteria) this;
        }

        public Criteria andUploadipBetween(String value1, String value2) {
            addCriterion("uploadip between", value1, value2, "uploadip");
            return (Criteria) this;
        }

        public Criteria andUploadipNotBetween(String value1, String value2) {
            addCriterion("uploadip not between", value1, value2, "uploadip");
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