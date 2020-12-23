package com.fuini.sd.web.rest.PurchaseRecord;

import com.fiuni.sd.DTO.PurchaseRecord.PurchaseRecordDTO;
import com.fuini.sd.web.rest.Base.BaseResourceImpl;
import org.springframework.stereotype.Repository;

@Repository("purchaseRecordResource")
public class PurchaseRecordResourceImpl extends BaseResourceImpl<PurchaseRecordDTO> implements IPurchaseRecordResource {

    public PurchaseRecordResourceImpl() {
        super(PurchaseRecordDTO.class, "purchases");
    }
}
