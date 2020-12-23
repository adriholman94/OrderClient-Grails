package com.fuini.sd.web.beans.Role;

import com.fuini.sd.web.beans.Base.BaseBean;

import java.util.Map;

public class RoleB extends BaseBean {

    private String roleName;

    public RoleB(Map<String, String> params){
        super(params);
    }

    public void setRoleName(String roleName){
        this.roleName = roleName;
    }

    public String getRoleName(){
        return this.roleName;
    }

    @Override
    protected void create(Map<String, String> params) {
        if (params.containsKey("id")) {
            setId(Integer.valueOf(params.get("id")));
        }
        setRoleName(params.get("roleName"));
    }
}
