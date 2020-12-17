package com.fuini.sd.web.rest.Supplier


import com.fiuni.sd.DTO.Supplier.SupplierDTO
import com.fiuni.sd.DTO.Supplier.SupplierResult
import com.fuini.sd.web.rest.Base.IBaseResource


public interface ISupplierResource extends IBaseResource<SupplierDTO> {

    SupplierResult getAll(Integer page);

    SupplierResult getSuppliers();
}
