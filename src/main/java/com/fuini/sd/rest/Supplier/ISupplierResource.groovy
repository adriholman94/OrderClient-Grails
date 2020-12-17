package com.fuini.sd.rest.Supplier

import com.fiuni.sd.DTO.Category.CategoryDTO
import com.fiuni.sd.DTO.Category.CategoryResult
import com.fiuni.sd.DTO.Supplier.SupplierDTO
import com.fiuni.sd.DTO.Supplier.SupplierResult
import com.fuini.sd.rest.Base.IBaseResource


public interface ISupplierResource extends IBaseResource<SupplierDTO> {

    SupplierResult getAll(Integer page);

    SupplierResult getSuppliers();
}
