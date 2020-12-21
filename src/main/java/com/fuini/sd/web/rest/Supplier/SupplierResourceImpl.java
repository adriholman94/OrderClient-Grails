package com.fuini.sd.web.rest.Supplier;

import com.fiuni.sd.DTO.Supplier.SupplierDTO;
import com.fiuni.sd.DTO.Supplier.SupplierResult;

import com.fuini.sd.web.rest.Base.BaseResourceImpl;
import org.springframework.stereotype.Repository;

@Repository("supplierResource")
public class SupplierResourceImpl extends BaseResourceImpl<SupplierDTO> implements ISupplierResource {

    public SupplierResourceImpl() {
        super(SupplierDTO.class, "suppliers");
    }

    @Override
    public SupplierResult getAll(Integer page) {
        System.out.println("all -> " + getWebResource().path("/page/" + page).toString());
        return getWebResource().path("/page/" + page).get(SupplierResult.class);
    }

    @Override
    public SupplierDTO update(SupplierDTO supplierDTO) {
        System.out.println("update -> " + getWebResource().path("/" + supplierDTO.getId()).toString());
        SupplierDTO updateDTO = getWebResource().path("/" + supplierDTO.getId()).entity(supplierDTO).put(getDTOClass());
        return updateDTO;
    }

    @Override
    public SupplierDTO delete(Integer id) {
        System.out.println("delete -> " + getWebResource().path("/" + id).toString());
        SupplierDTO DTO = getWebResource().path("/" + id).delete(getDTOClass());
        return DTO;
    }
}
