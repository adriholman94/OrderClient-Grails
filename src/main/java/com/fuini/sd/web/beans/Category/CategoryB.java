package com.fuini.sd.web.beans.Category;

import com.fuini.sd.web.beans.Base.BaseBean;

import java.util.Map;

public class CategoryB extends BaseBean {

    private String categoryName;

    public CategoryB(Map<String, String> params){
        super(params);
    }

    public void setCategoryName(String categoryName){
        this.categoryName = categoryName;
    }

    public String getCategoryName(){
        return this.categoryName;
    }

    @Override
    protected void create(Map<String, String> params) {
        if (params.containsKey("id")) {
            setId(Integer.valueOf(params.get("id")));
        }
        setCategoryName(params.get("categoryName"));
    }
}
