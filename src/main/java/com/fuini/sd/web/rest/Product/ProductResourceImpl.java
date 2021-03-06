package com.fuini.sd.web.rest.Product;

import com.fiuni.sd.DTO.Category.CategoryResult;
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
        setWebResourceBasicAuthFilter();
        System.out.println("page -> " + getWebResource().path("/page/" + page).toString());
        return getWebResource().path("/page/" + page).get(ProductResult.class);
    }

    @Override
    public ProductDTO update(ProductDTO productDTO) {
        setWebResourceBasicAuthFilter();
        System.out.println("update -> " + getWebResource().path("/" + productDTO.getId()).toString());
        ProductDTO updateDTO = getWebResource().path("/" + productDTO.getId()).entity(productDTO).put(getDTOClass());
        return updateDTO;
    }

    @Override
    public ProductDTO delete(Integer id) {
        setWebResourceBasicAuthFilter();
        System.out.println("delete -> " + getWebResource().path("/" + id).toString());
        ProductDTO DTO = getWebResource().path("/" + id).delete(getDTOClass());
        return DTO;
    }

    @Override
    public ProductResult getProducts() {
        setWebResourceBasicAuthFilter();
        System.out.println("all -> " + getWebResource().path("/all").toString());
        return getWebResource().path("/all").get(ProductResult.class);
    }
}
