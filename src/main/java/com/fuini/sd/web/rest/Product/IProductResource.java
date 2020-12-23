package com.fuini.sd.web.rest.Product;

import com.fiuni.sd.DTO.Category.CategoryDTO;
import com.fiuni.sd.DTO.Product.ProductDTO;
import com.fiuni.sd.DTO.Product.ProductResult;
import com.fuini.sd.web.rest.Base.IBaseResource;

public interface IProductResource extends IBaseResource<ProductDTO> {

    ProductResult getAll(Integer page);

    ProductDTO update(ProductDTO productDTO);

    ProductDTO delete(Integer id);

    ProductResult getProducts();

}
