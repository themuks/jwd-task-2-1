package com.kuntsevich.task1.model.dao.entity;

public class ObjectParameter {
    private String parameterName;
    private String parameterValue;

    public ObjectParameter(String parameterName, String parameterValue) {
        this.parameterName = parameterName;
        this.parameterValue = parameterValue;
    }

    public String getParameterName() {
        return parameterName;
    }

    public void setParameterName(String parameterName) {
        this.parameterName = parameterName;
    }

    public String getParameterValue() {
        return parameterValue;
    }

    public void setParameterValue(String parameterValue) {
        this.parameterValue = parameterValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ObjectParameter objectParameter = (ObjectParameter) o;
        if (!parameterName.equals(objectParameter.parameterName)) {
            return false;
        }
        return parameterValue.equals(objectParameter.parameterValue);
    }

    @Override
    public int hashCode() {
        int result = parameterName.hashCode();
        result = 31 * result + parameterValue.hashCode();
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Parameter{");
        sb.append("parameterName='").append(parameterName).append('\'');
        sb.append(", parameterValue=").append(parameterValue);
        sb.append('}');
        return sb.toString();
    }
}
