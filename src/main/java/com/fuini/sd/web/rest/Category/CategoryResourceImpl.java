package com.fuini.sd.web.rest.Category;

import com.fiuni.sd.DTO.Category.CategoryDTO;
import com.fiuni.sd.DTO.Category.CategoryResult;
import com.fiuni.sd.DTO.Product.ProductResult;
import com.fuini.sd.web.rest.Base.BaseResourceImpl;
import org.springframework.stereotype.Repository;

@Repository("categoryResource")
public class CategoryResourceImpl extends BaseResourceImpl<CategoryDTO> implements ICategoryResource{

    public CategoryResourceImpl() {
        super(CategoryDTO.class, "categories");
    }

    @Override
    public CategoryResult getAll(Integer page) {
        System.out.println("all -> " + getWebResource().path("/page/" + page).toString());
        return getWebResource().path("/page/" + page).get(CategoryResult.class);
    }

    @Override
    public CategoryDTO update(CategoryDTO categoryDTO) {
        System.out.println("update -> " + getWebResource().path("/" + categoryDTO.getId()).toString());
        CategoryDTO updateDTO = getWebResource().path("/" + categoryDTO.getId()).entity(categoryDTO).put(getDTOClass());
        return updateDTO;
    }

    @Override
    public CategoryDTO delete(Integer id) {
        System.out.println("delete -> " + getWebResource().path("/" + id).toString());
        CategoryDTO DTO = getWebResource().path("/" + id).delete(getDTOClass());
        return DTO;
    }

    @Override
    public CategoryResult getCategories() {
        System.out.println("all -> " + getWebResource().path("/all").toString());
        return getWebResource().path("/all").get(CategoryResult.class);
    }
}
