package com.fuini.sd.web.rest.Supplier


import com.fiuni.sd.DTO.Supplier.SupplierDTO
import com.fiuni.sd.DTO.Supplier.SupplierResult
import com.fuini.sd.web.rest.Base.BaseResourceImpl

import org.springframework.stereotype.Repository

@Repository("supplierResource")
public class SupplierResourceImpl extends BaseResourceImpl<SupplierDTO> implements ISupplierResource{
    public SupplierResourceImpl() {
        super(SupplierDTO.class, "suppliers");
    }

    @Override
    public SupplierResult getAll(Integer page) {
        return getWebResource().path("/" + page).get(SupplierResult.class);
    }

    @Override
    public SupplierResult getSuppliers() { return getWebResource().path("/" ).get(SupplierResult.class);
    }
}
