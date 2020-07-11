package com.practice.miniprogram.checkin.bean;

import java.util.ArrayList;
import java.util.List;

public class TaskRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TaskRecordExample() {
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

        public Criteria andTaskRecordIdIsNull() {
            addCriterion("task_record_id is null");
            return (Criteria) this;
        }

        public Criteria andTaskRecordIdIsNotNull() {
            addCriterion("task_record_id is not null");
            return (Criteria) this;
        }

        public Criteria andTaskRecordIdEqualTo(String value) {
            addCriterion("task_record_id =", value, "taskRecordId");
            return (Criteria) this;
        }

        public Criteria andTaskRecordIdNotEqualTo(String value) {
            addCriterion("task_record_id <>", value, "taskRecordId");
            return (Criteria) this;
        }

        public Criteria andTaskRecordIdGreaterThan(String value) {
            addCriterion("task_record_id >", value, "taskRecordId");
            return (Criteria) this;
        }

        public Criteria andTaskRecordIdGreaterThanOrEqualTo(String value) {
            addCriterion("task_record_id >=", value, "taskRecordId");
            return (Criteria) this;
        }

        public Criteria andTaskRecordIdLessThan(String value) {
            addCriterion("task_record_id <", value, "taskRecordId");
            return (Criteria) this;
        }

        public Criteria andTaskRecordIdLessThanOrEqualTo(String value) {
            addCriterion("task_record_id <=", value, "taskRecordId");
            return (Criteria) this;
        }

        public Criteria andTaskRecordIdLike(String value) {
            addCriterion("task_record_id like", value, "taskRecordId");
            return (Criteria) this;
        }

        public Criteria andTaskRecordIdNotLike(String value) {
            addCriterion("task_record_id not like", value, "taskRecordId");
            return (Criteria) this;
        }

        public Criteria andTaskRecordIdIn(List<String> values) {
            addCriterion("task_record_id in", values, "taskRecordId");
            return (Criteria) this;
        }

        public Criteria andTaskRecordIdNotIn(List<String> values) {
            addCriterion("task_record_id not in", values, "taskRecordId");
            return (Criteria) this;
        }

        public Criteria andTaskRecordIdBetween(String value1, String value2) {
            addCriterion("task_record_id between", value1, value2, "taskRecordId");
            return (Criteria) this;
        }

        public Criteria andTaskRecordIdNotBetween(String value1, String value2) {
            addCriterion("task_record_id not between", value1, value2, "taskRecordId");
            return (Criteria) this;
        }

        public Criteria andTaskIdIsNull() {
            addCriterion("task_id is null");
            return (Criteria) this;
        }

        public Criteria andTaskIdIsNotNull() {
            addCriterion("task_id is not null");
            return (Criteria) this;
        }

        public Criteria andTaskIdEqualTo(String value) {
            addCriterion("task_id =", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotEqualTo(String value) {
            addCriterion("task_id <>", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdGreaterThan(String value) {
            addCriterion("task_id >", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdGreaterThanOrEqualTo(String value) {
            addCriterion("task_id >=", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLessThan(String value) {
            addCriterion("task_id <", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLessThanOrEqualTo(String value) {
            addCriterion("task_id <=", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLike(String value) {
            addCriterion("task_id like", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotLike(String value) {
            addCriterion("task_id not like", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdIn(List<String> values) {
            addCriterion("task_id in", values, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotIn(List<String> values) {
            addCriterion("task_id not in", values, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdBetween(String value1, String value2) {
            addCriterion("task_id between", value1, value2, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotBetween(String value1, String value2) {
            addCriterion("task_id not between", value1, value2, "taskId");
            return (Criteria) this;
        }

        public Criteria andCheckDateIsNull() {
            addCriterion("check_date is null");
            return (Criteria) this;
        }

        public Criteria andCheckDateIsNotNull() {
            addCriterion("check_date is not null");
            return (Criteria) this;
        }

        public Criteria andCheckDateEqualTo(String value) {
            addCriterion("check_date =", value, "checkDate");
            return (Criteria) this;
        }

        public Criteria andCheckDateNotEqualTo(String value) {
            addCriterion("check_date <>", value, "checkDate");
            return (Criteria) this;
        }

        public Criteria andCheckDateGreaterThan(String value) {
            addCriterion("check_date >", value, "checkDate");
            return (Criteria) this;
        }

        public Criteria andCheckDateGreaterThanOrEqualTo(String value) {
            addCriterion("check_date >=", value, "checkDate");
            return (Criteria) this;
        }

        public Criteria andCheckDateLessThan(String value) {
            addCriterion("check_date <", value, "checkDate");
            return (Criteria) this;
        }

        public Criteria andCheckDateLessThanOrEqualTo(String value) {
            addCriterion("check_date <=", value, "checkDate");
            return (Criteria) this;
        }

        public Criteria andCheckDateLike(String value) {
            addCriterion("check_date like", value, "checkDate");
            return (Criteria) this;
        }

        public Criteria andCheckDateNotLike(String value) {
            addCriterion("check_date not like", value, "checkDate");
            return (Criteria) this;
        }

        public Criteria andCheckDateIn(List<String> values) {
            addCriterion("check_date in", values, "checkDate");
            return (Criteria) this;
        }

        public Criteria andCheckDateNotIn(List<String> values) {
            addCriterion("check_date not in", values, "checkDate");
            return (Criteria) this;
        }

        public Criteria andCheckDateBetween(String value1, String value2) {
            addCriterion("check_date between", value1, value2, "checkDate");
            return (Criteria) this;
        }

        public Criteria andCheckDateNotBetween(String value1, String value2) {
            addCriterion("check_date not between", value1, value2, "checkDate");
            return (Criteria) this;
        }

        public Criteria andCheckLocationIsNull() {
            addCriterion("check_location is null");
            return (Criteria) this;
        }

        public Criteria andCheckLocationIsNotNull() {
            addCriterion("check_location is not null");
            return (Criteria) this;
        }

        public Criteria andCheckLocationEqualTo(String value) {
            addCriterion("check_location =", value, "checkLocation");
            return (Criteria) this;
        }

        public Criteria andCheckLocationNotEqualTo(String value) {
            addCriterion("check_location <>", value, "checkLocation");
            return (Criteria) this;
        }

        public Criteria andCheckLocationGreaterThan(String value) {
            addCriterion("check_location >", value, "checkLocation");
            return (Criteria) this;
        }

        public Criteria andCheckLocationGreaterThanOrEqualTo(String value) {
            addCriterion("check_location >=", value, "checkLocation");
            return (Criteria) this;
        }

        public Criteria andCheckLocationLessThan(String value) {
            addCriterion("check_location <", value, "checkLocation");
            return (Criteria) this;
        }

        public Criteria andCheckLocationLessThanOrEqualTo(String value) {
            addCriterion("check_location <=", value, "checkLocation");
            return (Criteria) this;
        }

        public Criteria andCheckLocationLike(String value) {
            addCriterion("check_location like", value, "checkLocation");
            return (Criteria) this;
        }

        public Criteria andCheckLocationNotLike(String value) {
            addCriterion("check_location not like", value, "checkLocation");
            return (Criteria) this;
        }

        public Criteria andCheckLocationIn(List<String> values) {
            addCriterion("check_location in", values, "checkLocation");
            return (Criteria) this;
        }

        public Criteria andCheckLocationNotIn(List<String> values) {
            addCriterion("check_location not in", values, "checkLocation");
            return (Criteria) this;
        }

        public Criteria andCheckLocationBetween(String value1, String value2) {
            addCriterion("check_location between", value1, value2, "checkLocation");
            return (Criteria) this;
        }

        public Criteria andCheckLocationNotBetween(String value1, String value2) {
            addCriterion("check_location not between", value1, value2, "checkLocation");
            return (Criteria) this;
        }

        public Criteria andCheckWeatherIsNull() {
            addCriterion("check_weather is null");
            return (Criteria) this;
        }

        public Criteria andCheckWeatherIsNotNull() {
            addCriterion("check_weather is not null");
            return (Criteria) this;
        }

        public Criteria andCheckWeatherEqualTo(String value) {
            addCriterion("check_weather =", value, "checkWeather");
            return (Criteria) this;
        }

        public Criteria andCheckWeatherNotEqualTo(String value) {
            addCriterion("check_weather <>", value, "checkWeather");
            return (Criteria) this;
        }

        public Criteria andCheckWeatherGreaterThan(String value) {
            addCriterion("check_weather >", value, "checkWeather");
            return (Criteria) this;
        }

        public Criteria andCheckWeatherGreaterThanOrEqualTo(String value) {
            addCriterion("check_weather >=", value, "checkWeather");
            return (Criteria) this;
        }

        public Criteria andCheckWeatherLessThan(String value) {
            addCriterion("check_weather <", value, "checkWeather");
            return (Criteria) this;
        }

        public Criteria andCheckWeatherLessThanOrEqualTo(String value) {
            addCriterion("check_weather <=", value, "checkWeather");
            return (Criteria) this;
        }

        public Criteria andCheckWeatherLike(String value) {
            addCriterion("check_weather like", value, "checkWeather");
            return (Criteria) this;
        }

        public Criteria andCheckWeatherNotLike(String value) {
            addCriterion("check_weather not like", value, "checkWeather");
            return (Criteria) this;
        }

        public Criteria andCheckWeatherIn(List<String> values) {
            addCriterion("check_weather in", values, "checkWeather");
            return (Criteria) this;
        }

        public Criteria andCheckWeatherNotIn(List<String> values) {
            addCriterion("check_weather not in", values, "checkWeather");
            return (Criteria) this;
        }

        public Criteria andCheckWeatherBetween(String value1, String value2) {
            addCriterion("check_weather between", value1, value2, "checkWeather");
            return (Criteria) this;
        }

        public Criteria andCheckWeatherNotBetween(String value1, String value2) {
            addCriterion("check_weather not between", value1, value2, "checkWeather");
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