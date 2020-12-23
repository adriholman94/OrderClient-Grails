package com.fuini.sd.web.beans.PurchaseRecord;

import com.fuini.sd.web.beans.Base.BaseBean;
import com.fuini.sd.web.beans.Product.ProductB;
import com.fuini.sd.web.beans.Supplier.SupplierB;
import java.util.Map;

public class PurchaseRecordDetailB extends BaseBean {

    private PurchaseRecordB purchaseRecord;
    private Integer productQuantity;
    private Integer unitPrice;
    private Integer totalPrice;
    private ProductB product;
    private SupplierB supplier;

    public PurchaseRecordDetailB(Map<String, String> params) {
        super(params);
    }

    @Override
    protected void create(Map<String, String> params) {
        if (params.containsKey("id")) {
            setId(Integer.valueOf(params.get("id")));
        }
        setProductQuantity(Integer.valueOf(params.get("productQuantity")));
        setUnitPrice(Integer.valueOf(params.get("unitPrice")));
        setTotalPrice(Integer.valueOf(params.get("totalPrice")));
    }

    public PurchaseRecordB getPurchaseRecord() {
        return purchaseRecord;
    }

    public void setPurchaseRecord(PurchaseRecordB purchaseRecord) {
        this.purchaseRecord = purchaseRecord;
    }

    public Integer getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(Integer productQuantity) {
        this.productQuantity = productQuantity;
    }

    public Integer getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Integer unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    public ProductB getProduct() {
        return product;
    }

    public void setProduct(ProductB product) {
        this.product = product;
    }

    public SupplierB getSupplier() {
        return supplier;
    }

    public void setSupplier(SupplierB supplier) {
        this.supplier = supplier;
    }
}
