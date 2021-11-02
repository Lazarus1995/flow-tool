package com.qu.flowcore.entity.dto;


import java.io.Serializable;

/**
 * @author qu
 * @date 2021.05.19.15:10
 */
public class FlowViewerDto implements Serializable {

    private String key;
    private boolean completed;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
