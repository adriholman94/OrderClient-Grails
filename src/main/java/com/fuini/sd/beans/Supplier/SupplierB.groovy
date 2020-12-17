package com.fuini.sd.beans.Supplier

import com.fuini.sd.beans.Base.BaseBean

class SupplierB extends BaseBean {
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
