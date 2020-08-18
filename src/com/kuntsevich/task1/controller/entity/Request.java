package com.kuntsevich.task1.controller.entity;

import java.util.Map;

public class Request {
    private String command;
    private Map<String, Object> params;

    public Request(String command, Map<String, Object> params) {
        this.command = command;
        this.params = params;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public Map<String, Object> getParams() {
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Request request = (Request) o;
        return command.equals(request.command)
                && params.equals(request.params);
    }

    @Override
    public int hashCode() {
        int result = command.hashCode();
        result = 31 * result + params.hashCode();
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Request{");
        sb.append("command='").append(command).append('\'');
        sb.append(", params=").append(params);
        sb.append('}');
        return sb.toString();
    }
}
