package com.fuini.sd.web.rest.Supplier;

import com.fiuni.sd.DTO.Supplier.SupplierDTO;
import com.fiuni.sd.DTO.Supplier.SupplierResult;
import com.fuini.sd.web.rest.Base.IBaseResource;

public interface ISupplierResource extends IBaseResource<SupplierDTO> {
    public abstract SupplierResult getAll(Integer page);

    public abstract SupplierResult getSuppliers();
}
