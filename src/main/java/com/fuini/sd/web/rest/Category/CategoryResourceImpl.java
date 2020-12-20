package com.fuini.sd.web.rest.Category;

import com.fiuni.sd.DTO.Category.CategoryDTO;
import com.fiuni.sd.DTO.Category.CategoryResult;
import com.fuini.sd.web.rest.Base.BaseResourceImpl;
import org.springframework.stereotype.Repository;

@Repository("categoryResource")
public class CategoryResourceImpl extends BaseResourceImpl<CategoryDTO> implements ICategoryResource{

    public CategoryResourceImpl() {
        super(CategoryDTO.class, "categories");
    }

    @Override
    public CategoryResult getAll(Integer page) {
        System.out.println(getWebResource().path("/page/" + page).toString());
        return getWebResource().path("/page/" + page).get(CategoryResult.class);
    }

    @Override
    public CategoryDTO update(CategoryDTO categoryDTO) {
        System.out.println(getWebResource().path("/" + categoryDTO.getId()).toString());
        CategoryDTO updateDTO = getWebResource().path("/" + categoryDTO.getId()).entity(categoryDTO).put(getDTOClass());
        return updateDTO;
    }
}
