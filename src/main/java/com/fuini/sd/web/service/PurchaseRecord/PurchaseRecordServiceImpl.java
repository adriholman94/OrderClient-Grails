package com.fuini.sd.web.service.PurchaseRecord;

import com.fiuni.sd.DTO.PurchaseRecord.PurchaseRecordDTO;
import com.fiuni.sd.DTO.PurchaseRecordDetails.PurchaseRecordDetailDTO;
import com.fuini.sd.web.beans.PurchaseRecord.PurchaseRecordB;
import com.fuini.sd.web.beans.PurchaseRecord.PurchaseRecordDetailB;
import com.fuini.sd.web.rest.PurchaseRecord.IPurchaseRecordResource;
import com.fuini.sd.web.service.Base.BaseServiceImpl;
import com.fuini.sd.web.service.Product.IProductService;
import com.fuini.sd.web.service.Supplier.ISupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("purchaseRecordService")
public class PurchaseRecordServiceImpl extends BaseServiceImpl<PurchaseRecordB, PurchaseRecordDTO> implements IPurchaseRecordService{

    @Autowired
    private IPurchaseRecordResource purchaseRecordResource;

    @Autowired
    private IProductService productService;

    @Autowired
    private ISupplierService supplierService;

    private Integer pages;

    @Override
    protected PurchaseRecordB convertDtoToBean(PurchaseRecordDTO dto) {
        final Map<String, String> params = new HashMap<>();
        params.put("id", String.valueOf(dto.getId()));
        params.put("finalPrice", String.valueOf(dto.getFinalPrice()));
        final PurchaseRecordB purchaseB = new PurchaseRecordB(params);
        purchaseB.setDate(dto.getDate());
        return purchaseB;
    }

    @Override
    protected PurchaseRecordDTO convertBeanToDto(PurchaseRecordB bean) {
        return null;
    }

    @Override
    public PurchaseRecordB getById(Integer id) {
        final PurchaseRecordDTO purchaseRecordDTO = purchaseRecordResource.getById(id);
        final List<PurchaseRecordDetailB> details = new ArrayList<>();
        final PurchaseRecordB purchaseRecordB = convertDtoToBean(purchaseRecordDTO);
        return purchaseRecordB;
    }

    @Override
    public List<PurchaseRecordB> getAll(Integer page) {
        return null;
    }

    @Override
    public PurchaseRecordB save(PurchaseRecordB bean) {
        return null;
    }

    public PurchaseRecordDetailDTO convertBeanToDto(PurchaseRecordDetailB bean) {
        return null;
    }

    public PurchaseRecordDetailB convertDtoToBean(PurchaseRecordDetailDTO dto) {
        final Map<String, String> params = new HashMap<>();
        params.put("id", String.valueOf(dto.getId()));
        params.put("productQuantity", String.valueOf(dto.getProductQuantity()));
        params.put("unitPrice", String.valueOf(dto.getUnitPrice()));
        params.put("totalPrice", String.valueOf(dto.getTotalPrice()));
        final PurchaseRecordDetailB bean = new PurchaseRecordDetailB(params);
        bean.setProduct(productService.getById(dto.getProduct().getId()));
        bean.setSupplier(supplierService.getById(dto.getSupplier().getId()));
        return bean;
    }
}
