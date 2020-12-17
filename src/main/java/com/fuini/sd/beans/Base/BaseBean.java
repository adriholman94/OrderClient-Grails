package com.fuini.sd.beans.Base;

import java.io.Serializable;
import java.util.Map;

public abstract class BaseBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public BaseBean(Map<String, String> params) {
        create(params);
    }

    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    protected abstract void create(Map<String, String> params);
}
