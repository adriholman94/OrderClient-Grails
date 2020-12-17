package com.fuini.sd.beans.Base;

import java.io.Serializable;

public abstract class BaseBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
