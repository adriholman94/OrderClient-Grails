package com.fuini.sd.web.service.Product;

import com.fiuni.sd.DTO.Product.ProductDTO;
import com.fuini.sd.web.beans.Product.ProductB;
import com.fuini.sd.web.service.Base.IBaseService;

import java.util.List;

public interface IProductService extends IBaseService<ProductB, ProductDTO> {

    ProductB update(ProductB updateBean);

    Integer getCPages();

    ProductB delete(Integer id);

    List<ProductB> getProducts();
}
