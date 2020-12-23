package com.fuini.sd.web.beans.User;

import com.fuini.sd.web.beans.Base.BaseBean;
import com.fuini.sd.web.beans.Role.RoleB;

import java.util.Map;

public class UserB extends BaseBean {

    private String userName;

    private RoleB role;

    public UserB(Map<String, String> params) {
        super(params);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public RoleB getRole() {
        return role;
    }

    public void setRole(RoleB role) {
        this.role = role;
    }

    @Override
    protected void create(Map<String, String> params) {
        if (params.containsKey("id")) {
            setId(Integer.valueOf(params.get("id")));
        }
        setUserName(params.get("userName"));

    }
}