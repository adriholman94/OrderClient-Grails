package com.fuini.sd.web.beans.Supplier;

import com.fuini.sd.web.beans.Base.BaseBean;

import java.util.Map;

public class SupplierB extends BaseBean {
    private static final long serialVersionUID = 1L;

    private String supplierName;

    public SupplierB(Map<String, String> params){
        super(params);
    }

    public void setSupplierName(String supplierName){
        this.supplierName = supplierName;
    }

    public String getSupplierName(){
        return this.supplierName;
    }

    @Override
    protected void create(Map<String, String> params) {
        if (params.containsKey("id")) {
            setId(Integer.valueOf(params.get("id")));
        }
        setSupplierName(params.get("supplierName"));
    }
}
