package com.fuini.sd.web.beans.Product;

import com.fuini.sd.web.beans.Base.BaseBean;
import com.fuini.sd.web.beans.Category.CategoryB;

import java.util.Map;

public class ProductB extends BaseBean {

    private String productName;
    private Integer productPrice;
    private CategoryB category;

    public ProductB(Map<String, String> params) {
        super(params);
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Integer productPrice) {
        this.productPrice = productPrice;
    }

    public CategoryB getCategory() {
        return category;
    }

    public void setCategory(CategoryB category) {
        this.category = category;
    }

    @Override
    protected void create(Map<String, String> params) {
        if (params.containsKey("id")) {
            setId(Integer.valueOf(params.get("id")));
        }
        setProductName(params.get("productName"));
        setProductPrice(Integer.valueOf(params.get("productPrice")));
    }
}
