package com.fuini.sd.web.rest.Product;

import com.fiuni.sd.DTO.Product.ProductDTO;
import com.fiuni.sd.DTO.Product.ProductResult;
import com.fuini.sd.web.rest.Base.BaseResourceImpl;
import org.springframework.stereotype.Repository;

@Repository("productResource")
public class ProductResourceImpl extends BaseResourceImpl<ProductDTO> implements IProductResource {

    public ProductResourceImpl() {
        super(ProductDTO.class, "products");
    }

    @Override
    public ProductResult getAll(Integer page) {
        System.out.println("all -> " + getWebResource().path("/page/" + page).toString());
        return getWebResource().path("/page/" + page).get(ProductResult.class);
    }

    @Override
    public ProductDTO update(ProductDTO productDTO) {
        System.out.println("update -> " + getWebResource().path("/" + productDTO.getId()).toString());
        ProductDTO updateDTO = getWebResource().path("/" + productDTO.getId()).entity(productDTO).put(getDTOClass());
        return updateDTO;
    }

    @Override
    public ProductDTO delete(Integer id) {
        System.out.println("delete -> " + getWebResource().path("/" + id).toString());
        ProductDTO DTO = getWebResource().path("/" + id).delete(getDTOClass());
        return DTO;
    }
}
