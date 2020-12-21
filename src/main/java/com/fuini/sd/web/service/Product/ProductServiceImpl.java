package com.fuini.sd.web.service.Product;

import com.fiuni.sd.DTO.Product.ProductDTO;
import com.fiuni.sd.DTO.Product.ProductResult;
import com.fuini.sd.web.beans.Product.ProductB;
import com.fuini.sd.web.rest.Product.IProductResource;
import com.fuini.sd.web.service.Base.BaseServiceImpl;
import com.fuini.sd.web.service.Category.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("productService")
public class ProductServiceImpl extends BaseServiceImpl<ProductB, ProductDTO> implements IProductService {

    @Autowired
    private ICategoryService _categoryService;

    @Autowired
    private IProductResource productResource;

    private Integer pages;

    @Override
    protected ProductB convertDtoToBean(ProductDTO dto) {
        final Map<String, String> params = new HashMap<>();
        params.put("id", String.valueOf(dto.getId()));
        params.put("productName", dto.getProductName());
        params.put("productPrice", String.valueOf(dto.getProductPrice()));
        final ProductB productB = new ProductB(params);
        productB.setCategory(_categoryService.toBean(dto.getCategory()));
        return productB;
    }

    @Override
    protected ProductDTO convertBeanToDto(ProductB bean) {
        return null;
    }

    @Override
    public ProductB getById(Integer id) {
        return null;
    }

    @Override
    public List<ProductB> getAll(Integer page) {
        final ProductResult result = productResource.getAll(page);
        final List<ProductDTO> dto = null == result.getProducts() ? new ArrayList<>() : result.getProducts();
        setCPages(result.getPages());
        final List<ProductB> products = new ArrayList<>();
        dto.forEach(c -> products.add(convertDtoToBean(c)));
        return products;
    }

    @Override
    public ProductB save(ProductB bean) {
        return null;
    }

    @Override
    public ProductB update(ProductB updateBean) {
        return null;
    }

    @Override
    public Integer getCPages() {
        return null;
    }

    public void setCPages(Integer pages) {
        this.pages = pages;
    }

    @Override
    public ProductB delete(Integer id) {
        return null;
    }
}
