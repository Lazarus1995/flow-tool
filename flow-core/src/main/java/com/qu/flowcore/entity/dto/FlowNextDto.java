package com.qu.flowcore.entity.dto;


import java.io.Serializable;
import java.util.List;

/**
 * @Description: 人员和组
 * @author: qu
 * @date: 2021.05.21.15:10
 */
public class FlowNextDto implements Serializable {

    private String type;

    private String vars;

    private List<Object> userList;

    //private List<SysRole> roleList;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVars() {
        return vars;
    }

    public void setVars(String vars) {
        this.vars = vars;
    }

    public List<Object> getUserList() {
        return userList;
    }

    public void setUserList(List<Object> userList) {
        this.userList = userList;
    }
}
