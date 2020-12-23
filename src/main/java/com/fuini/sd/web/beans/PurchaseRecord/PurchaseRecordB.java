package com.fuini.sd.web.beans.PurchaseRecord;

import com.fuini.sd.web.beans.Base.BaseBean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class PurchaseRecordB extends BaseBean {

    private Date date;
    private Integer finalPrice;
    private List<PurchaseRecordDetailB> purchaseRecordDetails = new ArrayList<>();

    public PurchaseRecordB(Map<String, String> params) {
        super(params);
    }

    @Override
    protected void create(Map<String, String> params) {
        if (params.containsKey("id")) {
            setId(Integer.valueOf(params.get("id")));
        }
        String finalPrice = null == params.get("finalPrice") ? "0" : params.get("finalPrice");
        setFinalPrice(Integer.valueOf(finalPrice));
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(Integer finalPrice) {
        this.finalPrice = finalPrice;
    }

    public List<PurchaseRecordDetailB> getPurchaseRecordDetails() {
        return purchaseRecordDetails;
    }

    public void setPurchaseRecordDetails(List<PurchaseRecordDetailB> purchaseRecordDetails) {
        this.purchaseRecordDetails = purchaseRecordDetails;
    }
}
