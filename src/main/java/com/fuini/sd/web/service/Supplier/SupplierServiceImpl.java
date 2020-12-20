package com.fuini.sd.web.service.Supplier;


import com.fiuni.sd.DTO.Supplier.SupplierDTO;
import com.fiuni.sd.DTO.Supplier.SupplierResult;
import com.fuini.sd.web.beans.Supplier.SupplierB;
import com.fuini.sd.web.rest.Supplier.ISupplierResource;
import com.fuini.sd.web.service.Base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service("supplierService")
public class SupplierServiceImpl extends BaseServiceImpl<SupplierB, SupplierDTO> implements ISupplierService {

    @Autowired
    private ISupplierResource supplierResource;

    @Override
    protected SupplierB convertDtoToBean(SupplierDTO dto) {
        final Map<String, String> params = new HashMap<>();
        params.put("id", String.valueOf(dto.getId()));
        params.put("supplierName", dto.getSupplierName());
        return new SupplierB(params);
    }

    @Override
    protected SupplierDTO convertBeanToDto(SupplierB bean) {
        final SupplierDTO DTO = new SupplierDTO();
        DTO.setId(bean.getId());
        DTO.setSupplierName(bean.getSupplierName());
        return DTO;
    }

    @Override
    public SupplierB getById(Integer id) {
        final SupplierDTO supplierDTO = supplierResource.getById(id);
        return convertDtoToBean(supplierDTO);
    }

    @Override
    public List<SupplierB> getAll(Integer page) {
        final SupplierResult result = supplierResource.getAll(page);
        final List<SupplierDTO> dto = null == result.getSuppliers() ? new ArrayList<>() : result.getSuppliers();
        final List<SupplierB> suppliers = new ArrayList<>();
        dto.forEach(c -> suppliers.add(convertDtoToBean(c)));
        return suppliers;
    }

    @Override
    public SupplierB save(SupplierB bean) {
        final SupplierDTO dto = convertBeanToDto(bean);
        return convertDtoToBean(supplierResource.save(dto));
    }
}