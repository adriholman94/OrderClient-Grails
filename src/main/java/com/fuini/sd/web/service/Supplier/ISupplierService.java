package com.fuini.sd.web.service.Supplier;

import com.fiuni.sd.DTO.Supplier.SupplierDTO;
import com.fuini.sd.web.beans.Supplier.SupplierB;
import com.fuini.sd.web.service.Base.IBaseService;

import java.util.List;

public interface ISupplierService extends IBaseService<SupplierB, SupplierDTO> {

    SupplierB update(SupplierB updateBean);

    Integer getCPages();

    SupplierB delete(Integer id);

    List<SupplierB> getSuppliers();
}
